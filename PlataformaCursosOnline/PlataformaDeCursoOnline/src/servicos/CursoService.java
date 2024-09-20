package servicos;

import java.util.ArrayList;
import java.util.List;

import entidades.Curso;
import entidades.Aluno;
import enums.TipoCurso;
import exceptions.CursoNotFoundException;
import exceptions.InvalidAnoCriacaoException;
import interfaces.ICursoRepositorio;
import interfaces.ICursoServiceInterface;

public class CursoService implements ICursoServiceInterface {
    private ICursoRepositorio cursoRepositorio;

    public CursoService(ICursoRepositorio cursoRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
    }

    public void adicionarCurso(Curso curso) {
        cursoRepositorio.adicionarCurso(curso);
        System.out.println("Curso adicionado: " + curso.getTitulo());
    }

    public int calcularTotalAlunosInscritos(Curso curso) {
        List<Aluno> alunosInscritos = cursoRepositorio.listarAlunosInscritos(curso);
        return alunosInscritos.size();
    }

    @Override
    public void inscreverAluno(Curso curso, Aluno aluno) {
        cursoRepositorio.inscreverAluno(curso, aluno);
        System.out.println("Aluno " + aluno.getNome() + " inscrito no curso " + curso.getTitulo());
    }

    @Override
    public void cancelarInscricao(Curso curso, Aluno aluno) throws CursoNotFoundException {
        cursoRepositorio.cancelarInscricao(curso, aluno);
        System.out.println("Inscrição do aluno " + aluno.getNome() + " cancelada no curso " + curso.getTitulo());
    }

    public List<Curso> listarCursos() {
        List<Curso> cursos = cursoRepositorio.listarCursos();
        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getTitulo() + " | ID: " + curso.getId());
        }
        return cursos; // Retorna a lista de cursos, caso seja necessário utilizá-la
    }
}
