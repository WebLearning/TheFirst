package com.shangbao.control.Imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangbao.control.LogInControl;
import com.shangbao.dao.UserDao;
import com.shangbao.model.User;

@Component("logInControl")
public class LogInControlImp implements LogInControl{
	
	 
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Boolean logIn(String name, String passwd) {
		User user = new User();
		List<User> ulist = null;
		user.setName(name);
		user.setPasswd(passwd);
		if((ulist = userDao.find(user)).size() != 0){
			for(User u : ulist){
				System.out.println(u);
			}
			return true;
		}else{
			return false;
		}
	}

}
