package app;

import exceptions.DadosProfessorIncompletosException;

public class Professor {

	private String nome;
	private String matricula;
	private String email;

	public Professor(String nome, String matricula, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}

	public static Professor obterProfessor(String nome, String matricula, String email) throws DadosProfessorIncompletosException {

		validarDados(nome, matricula, email);  
		
		return new Professor(nome, matricula, email);
		
	}

	private static void validarDados(String nome, String matricula, String email) throws DadosProfessorIncompletosException {
		if (nome == null || nome.equalsIgnoreCase("") ||
			matricula == null || matricula.equalsIgnoreCase("") || 
			email == null || email.equalsIgnoreCase("")) {
			
			StringBuilder builder = construirMensagemErro(nome, matricula, email);
			
			throw new DadosProfessorIncompletosException(builder.toString());
			
		}
	}

	private static StringBuilder construirMensagemErro(String nome, String matricula, String email) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Dados informados para Professor estão incompletos:");
		builder.append(nome == null ? "Nome: " + nome : null);
		builder.append(matricula == null ? "Matricula: " + matricula : null);
		builder.append(email == null ? "Email: " + email : null);
		return builder;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getEmail() {
		return email;
	}
	
	

}
