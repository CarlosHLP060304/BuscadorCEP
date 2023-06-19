package main;

import static javax.swing.JOptionPane.showInputDialog;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		String cep = showInputDialog("Digite seu CEP: ");
		Util.exibeResposta(cep);
		Util.guardaNoJson(cep);
	}
	

}
