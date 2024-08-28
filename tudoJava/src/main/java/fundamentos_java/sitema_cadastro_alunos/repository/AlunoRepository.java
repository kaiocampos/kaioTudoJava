package fundamentos_java.sitema_cadastro_alunos.repository;

import fundamentos_java.sitema_cadastro_alunos.model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 *Esta classe será responsável por armazenar os dados dos alunos.
 */

public class AlunoRepository {
    /* Quando eu crio uma lista em java, essa lista já vem com alguns métodos inclusos, dentre tais temos o CRUD
     */
    private List<Aluno> alunoslist = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunoslist.add(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoslist;
    }


/*

Explicação Detalhada:

alunosList.stream():
Cria um Stream a partir da lista alunos. Um Stream é uma sequência de elementos que pode ser processada em operações
 em cadeia, como filtragem, mapeamento, e agregação.


.filter(aluno -> aluno.getNome().equalsIgnoreCase(nome)):
Aplica um filtro à Stream para selecionar apenas os elementos que satisfazem uma condição.

aluno -> aluno.getNome().equalsIgnoreCase(nome):
Este é um lambda expression. Para cada aluno no Stream, verifica se o nome do aluno (aluno.getNome()) é igual ao nome
fornecido (nome), ignorando maiúsculas e minúsculas (equalsIgnoreCase).
Se a condição for verdadeira, o aluno será mantido na Stream filtrada.


.findFirst():
Retorna um Optional<Aluno> contendo o primeiro aluno na Stream filtrada, se houver algum.
Se a Stream estiver vazia (nenhum aluno corresponde ao nome), retornará um Optional vazio.
 */

    public Optional<Aluno> buscarPorNome(String nome) {
        return alunoslist.stream().filter(aluno -> aluno.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public boolean remover(Aluno aluno) {
        return alunoslist.remove(aluno);
    }

}
