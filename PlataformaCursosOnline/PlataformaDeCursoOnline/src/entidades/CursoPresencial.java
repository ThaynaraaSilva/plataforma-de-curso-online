package entidades;
import enums.TipoCurso;

public class CursoPresencial extends Curso {
	private String local;
    private int capacidade;
	
    public CursoPresencial(String id,String titulo, String descricao, int anoCriacao, int duracaoHoras, double preco, String local, int capacidade) {
        super(titulo, descricao, local, anoCriacao, duracaoHoras, preco, TipoCurso.PRESENCIAL); 
        this.local = local;
        this.capacidade = capacidade;
    }
    
    public String getLocal() {
        return local;
    }

    public int getCapacidade() {
        return capacidade;
    }
    @Override
    
    public void avaliarCurso() {
    	System.out.println("Avaliando curso presencial: " + getTitulo());
    }
    
    @Override 
    public double calcularPreco() {
    	 return getPreco() * 1.5;
    }
    
   
}

