package com.marianowinar.warmup.util.validator;

import com.marianowinar.warmup.exception.role.InvalidRoleException;
import com.marianowinar.warmup.exception.role.NullRoleException;
import com.marianowinar.warmup.exception.role.RoleException;
import com.marianowinar.warmup.model.Role;
import com.marianowinar.warmup.model.enums.RoleName;
import org.springframework.stereotype.Component;

@Component
public class ValidRole extends Validator{

	public void validCreateRole(Role role) throws RoleException {
		if(role == null)
			throw new NullRoleException(null);
		
		validateRole(role.getRole());		
	}

	private void validateRole(RoleName role) throws InvalidRoleException {
		if(!role.equals(RoleName.ROLE_ADMIN) && !role.equals(RoleName.ROLE_USER))
			throw new InvalidRoleException(role);
	}

}
