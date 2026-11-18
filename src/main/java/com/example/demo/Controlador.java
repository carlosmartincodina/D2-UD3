package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SpringBootApplication
@Controller
@SessionAttributes("usuario")
public class Controlador {

	public static void main(String[] args) {
		SpringApplication.run(Controlador.class, args);
	}
	
	
	@GetMapping("/login")
	public String login(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "login";
	}
	@PostMapping("/login")
	public String postLogin(Model model, Usuario usuario, BindingResult br) {
		if (br.hasErrors()) return "login"; 
		Usuarios usuarios = new Usuarios();
		usuario.setAutenticado(usuarios.contraseñaCorrecta(usuario.getNick(), usuario.getPass()));
		if (usuario.isAutenticado()) return "index";

		return "login";
		
	}
	@GetMapping("/")
	public String inicio(Model model, Usuario usuario, BindingResult bindingResult) {
		model.addAttribute("usuario", usuario);
		if (!usuario.isAutenticado()) return "redirect:/login";
		return "inicio";
	}
	

}
