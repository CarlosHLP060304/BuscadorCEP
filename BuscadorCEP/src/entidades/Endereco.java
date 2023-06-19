package entidades;
public record Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf,
			String ibge, String gia, String ddd, String siafi) {

	@Override
	public String toString() {
		return "Endereco Encontrado:".toUpperCase()+"\n\nCep: " + cep + "\nLogradouro : " + logradouro + "\nComplemento : " + complemento + "\nBairro : "
				+ bairro + "\nLocalidade : " + localidade + "\nUf : " + uf + "\nDDD : "
				+ ddd;
	}

}
