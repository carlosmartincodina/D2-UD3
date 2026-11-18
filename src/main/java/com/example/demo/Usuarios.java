package com.example.demo;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Usuarios {

	private ArrayList<Usuario> usuarios;
	
	public Usuarios() {
		usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Paco", "$2a$12$VRdAA0Nr49NLhTX1ZPT91elBXoR4CCvPsVHAaeNpKwNmwujEzvmo6"));
		usuarios.add(new Usuario("María", "$2a$12$Grj78KYCnhUBial/p8ScCeWQWuimUIZjZUXcEqK8BuEkyf6/8uZq."));
		usuarios.add(new Usuario("Carlos", "$2a$12$sOv.OJojW13bBRheJdPAVeMMDTpxd657r.er/UVwojeodPTfuELOG"));
		usuarios.add(new Usuario("JuanAndres", "$2a$12$NPsOPUUnaekKGbTnemZ3Ve5DTRE/R1KdMNMwi5eE595zUdQ2SDN/S"));
	}
	
	public boolean contraseñaCorrecta(String nombre, String pass) {
		String hash = null;
		for (int i = 0; i<usuarios.size();i++) {
			if (usuarios.get(i).getNick().equals(nombre)) {
				hash = usuarios.get(i).getPass();
			}
		}
		if (hash == null) return false;
		return BCrypt.checkpw(pass,hash);
	}
}
