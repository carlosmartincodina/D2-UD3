package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
	public String postLogin(Model model, Usuario usuario, SessionStatus session) {
		usuario.setContador(usuario.getContador()+1);
		Usuarios usuarios = new Usuarios();
		boolean autenticado = usuarios.contraseñaCorrecta(usuario.getNick(), usuario.getPass());
		usuario.setAutenticado(autenticado);
		
		if (usuario.isAutenticado()) return "redirect:/pagina1";
		session.setComplete();
		return "login";
		
	}
	
	@GetMapping("/pagina1")
	public String pagina1(Model model, Usuario usuario, SessionStatus session) {
		model.addAttribute("usuario", usuario);
		if (!usuario.isAutenticado()) {
			session.setComplete();
			return "redirect:/login";
		}
		return "pagina1";
	}
	@GetMapping("/pagina2")
	public String pagina2(Model model, Usuario usuario, SessionStatus session) {
		model.addAttribute("usuario", usuario);
		if (!usuario.isAutenticado()) {
			session.setComplete();
			return "redirect:/login";
		}
		return "pagina2";
	}
	
	@GetMapping("/")
	public String inicio(Model model, Usuario usuario, SessionStatus session) {
		model.addAttribute("usuario", usuario);
		if (!usuario.isAutenticado()) {
			session.setComplete();
			return "redirect:/login";
		}
		return "redirect:/pagina1";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/login";
	}
	

}
