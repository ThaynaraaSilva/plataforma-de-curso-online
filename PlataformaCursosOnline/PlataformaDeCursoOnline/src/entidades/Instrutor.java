package entidades;

public class Instrutor {
	private String nome;
	private String especialidade;
	private int anosExperiencia;

	public Instrutor(String nome, String especialidade, int anosExperiencia) {
		this.nome = nome;
		this.especialidade = especialidade;
		this.anosExperiencia = anosExperiencia;
	}

	public String getNome() {
		return nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public int getAnosExperiencia() {
		return anosExperiencia;
	}

}
