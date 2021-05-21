package com.marianowinar.warmup.util.validator;

import com.marianowinar.warmup.exception.category.CategoryException;
import com.marianowinar.warmup.exception.category.NullCategoryException;
import com.marianowinar.warmup.exception.post.PostException;
import com.marianowinar.warmup.exception.role.RoleException;
import com.marianowinar.warmup.exception.user.UserException;
import com.marianowinar.warmup.model.Category;
import com.marianowinar.warmup.model.Post;
import com.marianowinar.warmup.model.Role;
import com.marianowinar.warmup.model.User;

public abstract class Validator {

	public void validCreateUser(User user) throws UserException {}
	public void validCreateRole(Role role) throws RoleException {}
	public void validCreateCategory(Category category) throws NullCategoryException, CategoryException {}
	public void validCreatePost(Post post) throws PostException {}
}
