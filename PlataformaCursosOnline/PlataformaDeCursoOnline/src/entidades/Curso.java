package entidades;

import java.util.ArrayList;

import enums.TipoCurso;

public abstract class Curso {
	private String id;
	private String titulo;
	private String descricao;
	private int anoCriacao;
	private int DuracaoHoras;
	private double preco;
	private TipoCurso tipo;
	private ArrayList<Aluno> alunos;

	public Curso(String id,String titulo, String descricao, int anoCriacao, int DuracaoHoras, double preco,TipoCurso tipo) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.anoCriacao = anoCriacao;
		this.DuracaoHoras = DuracaoHoras;
		this.preco = preco;
		this.tipo = tipo;
		this.alunos = new ArrayList<Aluno>();
	}
	
	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getAnoCriacao() {
		return anoCriacao;
	}
	
	public int getDuracaoHoras() {
		return DuracaoHoras;
	}

	public double getPreco() {
		return preco;
	}

	public TipoCurso getTipo() {
		return tipo;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	
	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public abstract void avaliarCurso();
    public abstract double calcularPreco();	
}
