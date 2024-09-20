package interfaces;

import java.util.List;

import entidades.Aluno;
import entidades.Curso;
import enums.TipoCurso;
import exceptions.CursoNotFoundException;
import exceptions.InvalidAnoCriacaoException;

public interface ICursoServiceInterface {
	
	 void adicionarCurso(Curso curso);
	 
	 int calcularTotalAlunosInscritos(Curso curso);
	 
	 void inscreverAluno(Curso curso, Aluno aluno);
    
	  void cancelarInscricao(Curso curso, Aluno aluno) throws CursoNotFoundException;
	  
	  List<Curso> listarCursos();
}