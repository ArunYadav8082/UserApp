package com.arun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arun.bussinesException.UserNotFoundException;
import com.arun.dto.UserRequest;
import com.arun.entity.UserRegistration;

import com.arun.repository.UserRepository;

@Service
public class UserServiceImp 
{
	@Autowired
	private UserRepository userRepo;
	
	public UserRegistration saveUser(UserRequest userRequest)
	{
		UserRegistration user =
				UserRegistration.build(0, userRequest.getFirstName(), userRequest.getLastName(),
						userRequest.getCity(), userRequest.getEmail(), userRequest.getMobile(),
						userRequest.getGender(), userRequest.getAge());
		return this.userRepo.save(user);
		
	}
	
	public List<UserRegistration> getAllUser()
	{
		return this.userRepo.findAll();
		
	}
	
	public UserRegistration getUser(int id) throws UserNotFoundException
	{
		UserRegistration user = this.userRepo.findAllByUserId(id);
		
		if(user!=null)
		{
			return user;
		}
		else
		{
			throw new UserNotFoundException("user not Found with Id :"+id);
		}
		
	}

}
