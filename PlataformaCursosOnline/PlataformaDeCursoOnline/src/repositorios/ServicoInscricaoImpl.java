package repositorios;

import entidades.Curso;
import entidades.Aluno;
import exceptions.CursoNotFoundException;
import interfaces.ICursoServiceInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ServicoInscricaoImpl implements ICursoServiceInterface {
    private Map<Curso, List<Aluno>> inscricoes;

    public ServicoInscricaoImpl() {
        this.inscricoes = new HashMap<>();
    }

    @Override
    public void inscreverAluno(Curso curso, Aluno aluno) {
        inscricoes.computeIfAbsent(curso, k -> new ArrayList<>()).add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " inscrito no curso " + curso.getTitulo() + " com sucesso!");
    }

    @Override
    public void cancelarInscricao(Curso curso, Aluno aluno) throws CursoNotFoundException {
        List<Aluno> alunos = inscricoes.get(curso);
        if (alunos == null) {
            throw new CursoNotFoundException("Curso não encontrado.");
        }
        if (alunos.remove(aluno)) {
            System.out.println("Inscrição de " + aluno.getNome() + " no curso " + curso.getTitulo() + " cancelada com sucesso!");
        } else {
            System.out.println("Aluno não encontrado na lista de inscritos.");
        }
    }

    @Override
    public Aluno buscarAlunoInscrito(Curso curso, String alunoId) throws CursoNotFoundException {
        List<Aluno> alunos = inscricoes.get(curso);
        if (alunos == null) {
            throw new CursoNotFoundException("Curso não encontrado.");
        }
        return alunos.stream()
            .filter(a -> a.getId().equals(alunoId))
            .findFirst()
            .orElse(null);
    }

    @Override
    public void listarAlunosInscritos(Curso curso) {
        List<Aluno> alunos = inscricoes.get(curso);
        if (alunos == null || alunos.isEmpty()) {
            System.out.println("Nenhum aluno inscrito no curso " + curso.getTitulo() + ".");
        } else {
            System.out.println("Alunos inscritos no curso " + curso.getTitulo() + ":");
            for (Aluno aluno : alunos) {
                System.out.println("- " + aluno.getNome());
            }
        }
    }

	@Override
	public void removerInscricao(Curso curso, Aluno aluno) throws CursoNotFoundException {
		
	}

	@Override
	public void adicionarCurso(Curso curso) {
		// TODO Stub de método gerado automaticamente
		
	}

	@Override
	public int calcularTotalAlunosInscritos(Curso curso) {
		// TODO Stub de método gerado automaticamente
		return 0;
	}

	@Override
	public List<Curso> listarCursos() {
		// TODO Stub de método gerado automaticamente
		return null;
	}

}
