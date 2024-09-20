package entidades;

import enums.TipoCurso;

public class CursoOnline extends Curso{
	private int numAcessos;
	
	public CursoOnline(String id,String titulo, String descricao, int anoCriacao, int duracaoHoras, double preco, int numAcessos) {
		super(id, titulo, descricao, anoCriacao, duracaoHoras, preco, TipoCurso.ONLINE);
		this.numAcessos = numAcessos;
	}
	
	public int getNumeroAcessos() {
        return numAcessos;
    }
	 @Override
	    public void avaliarCurso() {
	        System.out.println("Avaliando curso online: " + getTitulo());
	    }
	 
	 @Override
	    public double calcularPreco() {
		 return getPreco() * 2.0;
	 }
}
