package fundamentos_java.calculadora_simples;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem Vindo a calculadora simples");
        System.out.println("Digite o Primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.println("Escolha a operação: +, -, * ou /");
        char operador = scanner.next().charAt(0);

        System.out.println("Escolha o Segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado;


        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                    return;
                }
                break;
            default:
                System.out.println("Operador inválido!");
                return;
        }

        System.out.println("Resultado: " + resultado);
        scanner.close();
    }
}
/*
next(): O método next() lê a próxima palavra (ou token) da entrada fornecida pelo usuário. Uma palavra aqui é considerada uma sequência de caracteres delimitada por espaços, ou seja, até o próximo espaço ou quebra de linha.

Exemplo: Se o usuário digitar +, next() vai capturar essa string +.
Se o usuário digitar "a + b": O next() capturará apenas o primeiro token "a", porque ele para no primeiro espaço ou caractere especial.

2. charAt(0)
charAt(0): O método charAt(int index) é usado para acessar um caractere específico em uma string. O índice fornecido (0 neste caso) indica que você deseja o primeiro caractere da string.

Exemplo: Se a string capturada for +, charAt(0) retorna +, porque é o primeiro e único caractere.
Se a string fosse "ab": charAt(0) retornaria a, pois é o primeiro caractere da string "ab".

 */