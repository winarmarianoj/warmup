package com.marianowinar.warmup.config;

import com.marianowinar.warmup.model.Role;
import com.marianowinar.warmup.model.enums.RoleName;
import com.marianowinar.warmup.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService roleServ;

    @Override
    public void run(String... args) throws Exception {
    	/*Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
        Role rolUser = new Role(RoleName.ROLE_USER);
        roleServ.create(rolAdmin);
        roleServ.create(rolUser);*/
    }
}