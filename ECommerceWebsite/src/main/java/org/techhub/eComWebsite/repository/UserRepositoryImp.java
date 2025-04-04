package org.techhub.eComWebsite.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techhub.eComWebsite.Model.UserModel;

@Repository("userRepo")
public class UserRepositoryImp implements UserRepository{

	List<UserModel> list;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public boolean registerNewUser(UserModel model) {
		int result=jdbcTemplate.update("Insert into Registration (fullName,email,contactNo,address,password) values(?,?,?,?,?)",new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, model.getFullName());
				ps.setString(2, model.getEmail());
				ps.setString(3, model.getContactNo());
				ps.setString(4, model.getAddress());
				ps.setString(5, model.getPassword());				
			}
			
		});
		return result>0;
	}
	@Override
	public List<UserModel> getAllUser() {
		list=jdbcTemplate.query("Select * from Registration",new RowMapper<UserModel>() {

			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserModel model=new UserModel();
				model.setRegId(rs.getInt(1));
				model.setFullName(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContactNo(rs.getString(4));
				model.setAddress(rs.getString(5));
				model.setPassword(rs.getString(6));
				return model;
			}
			
		});
		return list;
	}
	
	@Override
	public UserModel searchUserByEmailId(String email) {
		list=jdbcTemplate.query("Select * from Registration where email=?",new Object [] {email},new RowMapper<UserModel>() {

			@Override
			public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserModel model=new UserModel();
				model.setRegId(rs.getInt(1));
				model.setFullName(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setContactNo(rs.getString(4));
				model.setAddress(rs.getString(5));
				model.setPassword(rs.getString(6));
				return model;
			}
			
		});
		return list.size()>0?list.get(0):null;
	}
	@Override
	public boolean deleteUserByEmail(String email) {
		int result=jdbcTemplate.update("delete from Registration where email=?",new Object [] {email});
		return result>0;
	}
	@Override
		public boolean updateUserByEmail(String email, UserModel model) {
		    try {
		        int result = jdbcTemplate.update("UPDATE Registration SET fullName = ?, contactNo = ?, address = ?, password = ? WHERE email = ?",
		                model.getFullName(), model.getContactNo(), model.getAddress(), model.getPassword(), email);
		        return result > 0;
		    } catch (DataAccessException e) {
		        return false;
		    }
		}
	@Override
	public boolean userLogin(String email, String password) {
		  try {
		    jdbcTemplate.queryForObject(
		      "SELECT * FROM User WHERE email = ? AND password = ?",
		      new Object[]{email, password},
		      new RowMapper<UserModel>() {
		        @Override
		        public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		          UserModel user = new UserModel();
		          user.setEmail(rs.getString("email"));
		          user.setPassword(rs.getString("password"));
		          return user;
		        }
		      }
		    );
		    return true;
		  } catch (EmptyResultDataAccessException e) {
		    return false;
		  }
		}





}
