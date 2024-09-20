package view;

import java.util.ArrayList;

import entidades.Curso;
import enums.TipoCurso;
import repositorios.CursoPilhaRepository;

public class MainCurso1 {
    public static ArrayList<Curso> cursos = new ArrayList<Curso>();
    public static ArrayList<Curso> cursosTemp = new ArrayList<Curso>();

    public static void main(String[] args) {
        CursoPilhaRepository cursoPilha = new CursoPilhaRepository(cursos);
        CursoPilhaRepository cursoPilhaTemp = new CursoPilhaRepository(cursosTemp);

   
        Curso curso1 = new Curso("Java Básico", TipoCurso.ONLINE, 2022);
        Curso curso2 = new Curso("Desenvolvimento Web", TipoCurso.PRESENCIAL, 2021);
        Curso curso3 = new Curso("Data Science", TipoCurso.ONLINE, 2023);
        Curso curso4 = new Curso("Android Development", TipoCurso.PRESENCIAL, 2023);
        Curso curso5 = new Curso("DevOps", TipoCurso.ONLINE, 2024);

     
        cursoPilha.push(curso1);
        System.out.println("Topo Curso: " + cursoPilha.stackpop().getTitulo());

        cursoPilha.push(curso2);
        System.out.println("Topo Curso: " + cursoPilha.stackpop().getTitulo());

        cursoPilha.push(curso3);
        System.out.println("Topo Curso: " + cursoPilha.stackpop().getTitulo());

        cursoPilha.push(curso4);
        System.out.println("Topo Curso: " + cursoPilha.stackpop().getTitulo());

        cursoPilha.push(curso5);
        System.out.println("Topo Curso: " + cursoPilha.stackpop().getTitulo());

       
        Curso curso = null;
        do {
            System.out.println("Tamanho da pilha: " + cursoPilha.size());
            curso = cursoPilha.pop();
            if (!curso.getTitulo().equals("Data Science")) {
                cursoPilhaTemp.push(curso);
            }
            System.out.println("Curso removido: " + curso.getTitulo());
        } while (!curso.getTitulo().equals("Data Science"));

        
        Curso cursoTemp = null;
        do {
            if (cursoTemp != null)
                System.out.println("Topo Temporário Curso: " + cursoTemp.getTitulo());
            cursoTemp = cursoPilhaTemp.pop();
            if (cursoTemp != null) {
                cursoPilha.push(cursoTemp);
            }
        } while (cursoTemp != null);

       
        System.out.println("Topo Curso Final: " + cursoPilha.stackpop().getTitulo());
    }
}