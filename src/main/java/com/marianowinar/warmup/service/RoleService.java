package com.marianowinar.warmup.service;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.exception.role.RoleException;
import com.marianowinar.warmup.model.Role;
import com.marianowinar.warmup.model.enums.RoleName;
import com.marianowinar.warmup.repository.RoleRepository;
import com.marianowinar.warmup.util.logger.Errors;
import com.marianowinar.warmup.util.validator.ValidRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepo;

    private final ValidRole validRole;
    private final Errors errors;

    public RoleService(ValidRole validRole, Errors errors) {
        this.validRole = validRole;
        this.errors = errors;
    }

    public boolean create(Role entity) {
        boolean result = false;
        try {
            validRole.validCreateRole(entity);
            roleRepo.save(entity);
            result = true;
        }catch(RoleException e) {
            errors.logError(e.getError());
        }
        return result;
    }

    /**
     * Busca un objeto por su nombre en la BD
     * @param dto Objeto tipo UserDto del front
     * @return el objeto RoleName
     */
    public Role toModelRole(UserDto dto) {
        Role role = new Role();
        if(dto.getType().equals(String.valueOf(RoleName.ROLE_ADMIN))) {
            role = roleRepo.findByRole(RoleName.ROLE_ADMIN).get();
        }else {
            role = roleRepo.findByRole(RoleName.ROLE_USER).get();
        }
        return role;
    }
}
