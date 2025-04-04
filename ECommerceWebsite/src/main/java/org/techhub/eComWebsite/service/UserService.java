package org.techhub.eComWebsite.service;

import java.util.List;

import org.techhub.eComWebsite.Model.UserModel;

public interface UserService {
	public boolean registerNewUser(UserModel model);
	public List<UserModel> getAllUser();
	public UserModel searchUserByEmailId(String email);
	public boolean deleteUserByEmail(String email);
	public boolean updateUserByEmail(String email,UserModel model);
	public boolean userLogin(String email,String password);
}
