package com.marianowinar.warmup.util.validator;

import com.marianowinar.warmup.exception.category.CategoryException;
import com.marianowinar.warmup.exception.category.NullCategoryException;
import com.marianowinar.warmup.exception.role.RoleException;
import com.marianowinar.warmup.exception.user.UserException;
import com.marianowinar.warmup.model.Category;
import com.marianowinar.warmup.model.Role;
import com.marianowinar.warmup.model.User;

public abstract class Validator {

	protected static final int SUBSCRIPTION_MENOR = 0;
	protected static final int SUBSCRIPTION_MAYOR = 50;
	protected static final int CAPACITY_MENOR = 0;
	protected static final int CAPACITY_MAYOR = 50;
	protected static final int HOUR_MENOR = 0;
	protected static final int HOUR_MAYOR = 24;
	protected static final String ADMIN = "Admin";
	protected static final String USERS = "Student";
	protected static final String PROFESSOR = "Professor";
	protected static final String REGEX_PHONE = "^1(3|4|5|7|8)\\d{9}$";
	protected static final String REGEX_EMAIL = "^([a-zA-Z0-9-._ñ]+)@([a-zA-Z0-9-._ñ]+).([a-zA-Z]{2,5})$";
	protected static final String REGEX_NAMES = "^([a-zA-ZñÑ])+$";
	protected static final String REGEX_LEGAJO = "^([a-zA-ZñÑ0-9])+$";

	public void validCreateUser(User user) throws UserException {}
	public void validCreateRole(Role role) throws RoleException {}
	public void validCreateCategory(Category category) throws NullCategoryException, CategoryException {}
}
