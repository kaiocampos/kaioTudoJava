package fundamentos_java.sitema_cadastro_alunos.controller;

import fundamentos_java.sitema_cadastro_alunos.model.Aluno;
import fundamentos_java.sitema_cadastro_alunos.service.AlunoService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/*
Esta classe será responsável por interagir com o usuário e controlar o fluxo do sistema.
 */
public class AlunoController {
    private AlunoService alunoService;
    private Scanner scanner;

    public AlunoController() {
        this.alunoService = new AlunoService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar(){
        while (true){
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Buscar Aluno por Nome");
            System.out.println("4. Remover Aluno");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao){
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    buscarAlunoPorNome();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    System.out.println("Saindo");
                    return;
                default:
                    System.out.println("Opção inválida.");


            }
        }
    }

    private void removerAluno() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        if (alunoService.removerAluno(nome)){
            System.out.println("Aluno removido com sucesso.");
        }else {
            System.out.println("Aluno não encontrado");
        }

    }

    private void buscarAlunoPorNome() {
        System.out.println("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        Optional<Aluno> aluno = alunoService.listarAlunoPorNome(nome);

        aluno.ifPresentOrElse(
                System.out::println, () -> System.out.println("Aluno não encontrado.")
        );
    }

    private void listarAlunos() {
        List<Aluno> alunos = alunoService.listarAlunos();
        alunos.forEach(System.out::println);
    }

    private void cadastrarAluno() {
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Idade: ");
        int idade = scanner.nextInt();
        System.out.println("Nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        alunoService.cadastrarAluno(nome,idade,nota);
        System.out.println("Aluno Cadastrado com sucesso.");
    }


}
