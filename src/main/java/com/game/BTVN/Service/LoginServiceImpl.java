package com.game.BTVN.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.BTVN.Model.Login;
import com.game.BTVN.Reponsitory.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginres;

	//tim tat ca login co trong database
	@Override
	public List<Login> getAllLogin(){
		return loginres.findAll();
	}
	//tao moi login
	@Override
	public void saveLogin(Login login) {
		this.loginres.save(login);
	}
	
	//tim kiem login theo id
	//kiem tra xem id chon co ton tai hay khong
	@Override
	public Login getLoginById(long id) {
		Optional<Login> optional = loginres.findById(id);
		Login login = null;
		if(optional.isPresent()) {
			login = optional.get();
		}else {
			throw new RuntimeException("Login not found for id :: " +id);
		}
		return login;
	}
	//tim kiem login theo ai r xoa login do
	@Override
	public void deleteLoginById(long id) {
		this.loginres.deleteById(id);
		
	}
}
