package com.example.demo;

public class Usuario {

	private String nick;
	private String pass;
	private boolean autenticado;
	private int contador;
	
	
	
	public Usuario(String nick, String pass) {
		this.nick = nick;
		this.pass = pass;
	}
	public Usuario() {
		this.contador = 0;
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
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}
	
}
