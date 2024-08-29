package fundamentos_java.verificador_palindromos.service;

import fundamentos_java.verificador_palindromos.model.Frase;

/*
Esta classe conterá a lógica de negócio, que inclui o algoritmo para verificar se uma frase é um palíndromo.
 */
public class VerificadorPalindromoService {

    public boolean verificarPalindromo(Frase frase){

        String texto = frase.getTexto().replace("[\\W", "").toLowerCase();
        String textoInvertido = new StringBuilder(texto).reverse().toString();
        return texto.equals(textoInvertido);
    }
}

/*
String texto = frase.getTexto().replaceAll("[\\W]", "").toLowerCase();

frase.getTexto(): Este método acessa a string armazenada dentro do objeto Frase. Isso é feito utilizando o método
getTexto(), que é um método acessor (getter) da classe Frase.

replaceAll("[\\W]", ""): Este método remove todos os caracteres que não são alfanuméricos (ou seja, que não são letras ou números) da string.
\\W é uma expressão regular que corresponde a qualquer caractere que não seja uma letra ou número.

replaceAll substitui todos esses caracteres por uma string vazia, essencialmente removendo-os da frase.

toLowerCase(): Este método converte toda a string para minúsculas. Isso é importante porque queremos verificar se a
frase é um palíndromo de forma case-insensitive, ou seja, ignorando se as letras são maiúsculas ou minúsculas.

Finalidade da linha: Produzir uma versão "normalizada" da frase, sem espaços, pontuações, ou diferenças entre maiúsculas e minúsculas.


String textoInvertido = new StringBuilder(texto).reverse().toString();

new StringBuilder(texto): StringBuilder é uma classe que facilita a manipulação de strings. Aqui, estamos criando um
novo StringBuilder a partir da string texto.

reverse(): Este método inverte a ordem dos caracteres na string. Por exemplo, se texto for "abc", após o reverse(), será "cba".

toString(): Converte o StringBuilder de volta para um objeto String, já que precisamos do resultado como uma string normal.

Finalidade da linha: Criar uma nova string que é a versão invertida de texto.

return texto.equals(textoInvertido);

texto.equals(textoInvertido): O método equals verifica se texto e textoInvertido são iguais.
                                   Ele retorna true se as duas strings forem exatamente iguais e false caso contrário.

Finalidade da linha: Verificar se a string original, após normalização, é igual à sua versão invertida. Se for, a frase é um palíndromo.

Resumo
Este trecho de código serve para verificar se uma frase é um palíndromo. Ele faz isso removendo caracteres especiais,
convertendo a frase para minúsculas, invertendo a string, e comparando a string original com a string invertida.
Se elas forem iguais, a frase é considerada um palíndromo.
 */
