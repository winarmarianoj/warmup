package com.marianowinar.warmup.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.marianowinar.warmup.dto.request.UserDto;
import com.marianowinar.warmup.dto.response.UserCreationResponseDto;
import com.marianowinar.warmup.dto.response.UserResponseDto;
import com.marianowinar.warmup.exception.user.NullUserException;
import com.marianowinar.warmup.exception.user.UserException;
import com.marianowinar.warmup.mapper.UserMapper;
import com.marianowinar.warmup.model.User;
import com.marianowinar.warmup.repository.UserRepository;
import com.marianowinar.warmup.service.interfaces.UserServiceDto;
import com.marianowinar.warmup.util.logger.Errors;
import com.marianowinar.warmup.util.validator.ValidUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceDto {

    private final UserRepository userRepo;
    private final UserMapper mapper;
    private final RoleService roleService;
    private final ValidUser validUser;
    private final Errors errors;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDetails users;

	public UserService(UserRepository userRepo, UserMapper mapper,
					   ValidUser validUser, Errors errors,
					   BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
		this.userRepo = userRepo;
		this.mapper = mapper;
		this.validUser = validUser;
		this.errors = errors;
		this.roleService = roleService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserCreationResponseDto save(UserDto dto) {
		User user = mapper.toModel(dto, roleService.toModelRole(dto));
		String pass = bCryptPasswordEncoder.encode(dto.getPassword());
		try{
			validUser.validCreateUser(user);
			user.setPassword(pass);
			userRepo.save(user);
		} catch (UserException e) {
			errors.logError(e.getError());
		}

		return mapper.toUserCreationDto(user);
	}

	@Override
	public UserResponseDto findById(Long id) throws NullUserException {
		Optional<User> user = userRepo.findById(id);
		if (!user.isPresent()) {
			throw new NullUserException();
		}

		return mapper.toUserDto(user.get());
	}

	@Override
	public UserResponseDto findByUsername(String username) {
		return mapper.toUserDto(userRepo.findByUsername(username));
	}

	@Override
	public List<UserResponseDto> findAllOrderByUsername() {
		return userRepo.getOrderedByUsername().stream().map(u -> mapper.toUserDto(u)).collect(Collectors.toList());
	}

}
