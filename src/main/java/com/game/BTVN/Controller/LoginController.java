package com.game.BTVN.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.game.BTVN.Model.Login;
import com.game.BTVN.Service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginres;
	
	//goi den trang index de hien thi danh sach cac Login
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listLogin", loginres.getAllLogin());
		return "index";
	}
	//goi den trang form tao moi login
	@GetMapping("/showNewLoginForm")
	public String showNewLoginForm(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "new_login";
	}
	//tao moi login
	@PostMapping("/saveLogin")
	public String saveLogin(@ModelAttribute("login") Login login) {
		loginres.saveLogin(login);
		return "redirect:/";
	}
	//tim kiem login theo id va cap nhat login do
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable (value = "id") long id, Model model) {
		Login login = loginres.getLoginById(id);
		
		model.addAttribute("login", login);
		return "update_login";
	}
	// xoa login theo id
	@GetMapping("/deleteLogin/{id}")
	public String deleteLogin(@PathVariable (value = "id") long id) {
		this.loginres.deleteLoginById(id);
		return "redirect:/";
	}
	
	
}
