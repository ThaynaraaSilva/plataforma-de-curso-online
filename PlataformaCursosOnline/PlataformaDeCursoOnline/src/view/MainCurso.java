package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import entidades.Curso;
import entidades.CursoPresencial;
import entidades.CursoOnline;
import entidades.Instrutor;
import entidades.Aluno;
import enums.TipoCurso;
import exceptions.CursoNotFoundException;
import exceptions.InvalidAnoCriacaoException;
import exceptions.InvalidCursoTypeException;
import servicos.CursoService;
import interfaces.ICursoRepositorio;
import repositorios.CursoRepositorioImpl;

public class MainCurso {

    private static ICursoRepositorio cursoRepo = new CursoRepositorioImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\nPlataforma de Cursos Online");
                System.out.println("1. Gerenciar Cursos");
                System.out.println("2. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        menuCursos();
                        break;
                    case 2:
                        System.out.println("Saindo da plataforma...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    // Menu para gerenciamento de cursos
    private static void menuCursos() {
        while (true) {
            try {
                System.out.println("\nMenu Cursos");
                System.out.println("1. Adicionar Curso");
                System.out.println("2. Atualizar Curso");
                System.out.println("3. Remover Curso");
                System.out.println("4. Listar Cursos");
                System.out.println("5. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        adicionarCurso();
                        break;
                    case 2:
                        atualizarCurso();
                        break;
                    case 3:
                        removerCurso();
                        break;
                    case 4:
                        listarCursos();
                        break;
                    case 5:
                        return; // Voltar ao Menu Principal
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    // Métodos para gerenciar cursos
    private static void adicionarCurso() {
        try {
            System.out.print("Digite o título do curso: ");
            String titulo = scanner.nextLine();

            System.out.print("Digite o ano de criação do curso: ");
            int anoCriacao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Digite o tipo do curso (PRESENCIAL/ONLINE): ");
            String tipoCursoStr = scanner.nextLine().toUpperCase();
            TipoCurso tipoCurso = TipoCurso.valueOf(tipoCursoStr);

            Curso novoCurso;

            if (tipoCurso == TipoCurso.PRESENCIAL) {
                novoCurso = new CursoPresencial(titulo, tipoCursoStr, tipoCursoStr, anoCriacao, anoCriacao, anoCriacao, tipoCursoStr, anoCriacao);
            } else {
                novoCurso = new CursoOnline(titulo, tipoCursoStr, tipoCursoStr, anoCriacao, anoCriacao, anoCriacao, anoCriacao);
            }

            if (anoCriacao < 1900 || anoCriacao > 2100) {
                throw new InvalidAnoCriacaoException("Ano de criação deve ser entre 1900 e 2100.");
            }

            cursoRepo.adicionarCurso(novoCurso);
            System.out.println("Curso adicionado com sucesso!");

        } catch (InvalidAnoCriacaoException | IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar o curso: " + e.getMessage());
        }
    }

    private static void atualizarCurso() {
        // Implementação para atualizar curso
        System.out.println("Funcionalidade de atualizar curso ainda não implementada.");
    }

    private static void removerCurso() {
        // Implementação para remover curso
        System.out.println("Funcionalidade de remover curso ainda não implementada.");
    }

    private static void listarCursos() {
        System.out.println("Lista de Cursos:");
        for (Curso curso : cursoRepo.listarCursos()) {
            System.out.println(curso);
        }
    }
}
