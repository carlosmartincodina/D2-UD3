package com.example.demo;

import jakarta.validation.constraints.NotEmpty;

public class Usuario {

	@NotEmpty
	private String nick;
	@NotEmpty
	private String pass;
	private boolean autenticado;
	
	
	
	public Usuario(String nick, String pass) {
		this.nick = nick;
		this.pass = pass;
	}
	public Usuario() {

	}
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
}
