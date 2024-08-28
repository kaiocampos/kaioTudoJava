package fundamentos_java.sitema_cadastro_alunos.service;

import fundamentos_java.sitema_cadastro_alunos.model.Aluno;
import fundamentos_java.sitema_cadastro_alunos.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

/*
Esta classe conterá a lógica de negócio, como validações e manipulações nos dados dos alunos.
 */
public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService() {
        this.alunoRepository = new AlunoRepository();
    }

    public void cadastrarAluno(String nome, int idade, double nota) {
        Aluno aluno = new Aluno(nome, idade, nota);
        alunoRepository.salvar(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.listarTodos();
    }

    public Optional<Aluno> listarAlunoPorNome(String nome) {
        return alunoRepository.buscarPorNome(nome);
    }

/*
Explicação Detalhada:
alunoEncontrado.map(repository::remover):
aluno é um Optional<Aluno> retornado pelo método listarAlunoPorNome.

.map(repository::remover):
map é um método de Optional que aplica uma função ao valor contido (se presente).

repository::remover é uma method reference que se refere ao método remover do AlunoRepository.
Se o Optional contiver um Aluno, o método remover será chamado com esse aluno como argumento,
e o valor de retorno (um boolean) será envolvido em um novo Optional<Boolean>.

.orElse(false):
Se o Optional resultante de map contiver um valor (true ou false), esse valor será retornado.
Se o Optional estiver vazio (ou seja, o aluno não foi encontrado), false será retornado.
     */
    public boolean removerAluno(String nome) {
        Optional<Aluno> alunoEncontrado = listarAlunoPorNome(nome);
        return alunoEncontrado.map(alunoRepository::remover).orElse(false);
    }

}
