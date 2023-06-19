package main;

import static javax.swing.JOptionPane.showMessageDialog;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import entidades.Endereco;

public class Util {
	public static HttpResponse<String> getResponse(String cep) throws IOException, InterruptedException{
		String url = "https://viacep.com.br/ws/"+ cep +"/json/";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response;
	}
	public static void exibeResposta(String cep) throws IOException, InterruptedException {
		HttpResponse<String> response = getResponse(cep);
		Gson gson = new Gson();
		Endereco endereco = gson.fromJson(response.body(), Endereco.class);	
		showMessageDialog(null, endereco);		
	}
	public static void guardaNoJson(String cep) throws IOException, InterruptedException {
		HttpResponse<String> response = getResponse(cep);
		PrintWriter pw = new PrintWriter("Endereco.json");
		pw.println(response.body());
		pw.close();
	}
}
