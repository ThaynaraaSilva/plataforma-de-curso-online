package interfaces;

import java.util.List;

import entidades.Aluno;
import entidades.Curso;

public interface ICursoRepositorio {
	
	void adicionarCurso(Curso curso);

	Curso buscarCursoPorId(int i);

	void atualizar(Curso curso);

	void removerCurso(String id);
	
	List<Curso> listarCursos();

	Curso buscarCursoPorId(String id);

	void inscreverAluno(Curso curso, Aluno aluno);

	boolean cancelarInscricao(Curso curso, Aluno aluno);

	List<Aluno> listarAlunosInscritos(Curso curso);

}
