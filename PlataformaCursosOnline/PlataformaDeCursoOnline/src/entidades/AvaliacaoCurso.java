package entidades;

import java.util.Date;

public class AvaliacaoCurso {
	private Aluno aluno;
	private Curso curso;
	private double nota;
	private Date dataAvaliacao;

	public AvaliacaoCurso(Aluno aluno, Curso curso, double nota) {
		this.aluno = aluno;
		this.curso = curso;
		this.nota = nota;
		this.dataAvaliacao = new Date();
	}
	
	
	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public double getNota() {
		return nota;
	}


	public void setNota(double nota) {
		this.nota = nota;
	}


	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}


	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}


	public void gerarRelatorio() {
		 System.out.println("Avaliação de Curso:");
	        System.out.println("Aluno: " + aluno.getNome());
	        System.out.println("Curso: " + curso.getTitulo());
	        System.out.println("Nota: " + nota);
	        System.out.println("Data: " + dataAvaliacao);
	}
}
