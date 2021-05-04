package com.kakhileshpatel.user.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakhileshpatel.user.system.dao.UserRepository;
import com.kakhileshpatel.user.system.model.User;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public boolean updateUser(User user) throws Exception {
		boolean isExist = userRepository.existsById(user.getId());

		if (isExist) {
			userRepository.save(user);
		}else {
			throw new Exception("Address not fount for id "+user.getId());
		}
		return true;
	}

	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}


}
