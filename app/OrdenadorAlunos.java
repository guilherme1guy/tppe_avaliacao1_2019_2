package app;

public class OrdenadorAlunos {
	
	CadastroAlunos source;
	
	private Aluno respostas[];
	private String matricula1;
	private String matricula2;
	private Aluno t;

	public OrdenadorAlunos(CadastroAlunos source) {
	
		this.source = source;
	}
	
	public Aluno[] computar() {
		
		respostas = new Aluno[source.alunos.length];
		//copia o vetor para o vetor de resposta
		for (int i=0; i < source.alunos.length; i++) {
			respostas[i] = source.alunos[i]; 
		}
		
		for (int i = 0; i < respostas.length - 1; i++) {
			for (int j = i; j < respostas.length; j++) {
				matricula1 = source.obterMatricula(respostas[i]);
				matricula2 = source.obterMatricula(respostas[j]);
				if (matricula1.compareTo(matricula2) > 0) {
					t = respostas[i]; 
					respostas[i] = respostas[j];
					respostas[j] = t;
				}
			}
		}
		
		return respostas;
	}
}