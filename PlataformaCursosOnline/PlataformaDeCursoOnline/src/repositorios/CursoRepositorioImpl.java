package repositorios;

import java.util.ArrayList;
import java.util.List;

import entidades.Aluno;
import entidades.Curso;
import interfaces.ICursoRepositorio;

public class CursoRepositorioImpl implements ICursoRepositorio {
	
    private ArrayList<Curso> cursos = new ArrayList<>();

    @Override
    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public Curso buscarCursoPorId(String id) {
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                return curso; 
            }
        }
        return null; 
    }

    @Override
    public void atualizar(Curso curso) {
        Curso c = buscarCursoPorId(curso.getId());
        if (c != null) {
            cursos.remove(c); 
            cursos.add(curso); 
        }
    }

    @Override
    public void removerCurso(String id) {
        Curso c = buscarCursoPorId(id);
        if (c != null) {
            cursos.remove(c); 
        }
    }

    @Override
    public List<Curso> listarCursos() {
        return new ArrayList<>(cursos); 
    }

	@Override
	public Curso buscarCursoPorId(int i) {
		// TODO Stub de método gerado automaticamente
		return null;
	}

	@Override
	public void inscreverAluno(Curso curso, Aluno aluno) {
		// TODO Stub de método gerado automaticamente
		
	}

	@Override
	public boolean cancelarInscricao(Curso curso, Aluno aluno) {
		// TODO Stub de método gerado automaticamente
		return false;
	}

	@Override
	public List<Aluno> listarAlunosInscritos(Curso curso) {
		// TODO Stub de método gerado automaticamente
		return null;
	}

	
}
