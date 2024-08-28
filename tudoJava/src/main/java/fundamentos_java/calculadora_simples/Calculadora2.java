package fundamentos_java.calculadora_simples;

import java.util.Scanner;

public class Calculadora2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem Vindo a calculadora simples");
        System.out.println("Digite a operação (ex: 40+2): ");
        String entrada = scanner.nextLine(); // Captura a linha inteira de entrada

        /*
         String em java é um objeto, contém métodos prontos.
         String em C é um array de caracteres
         */

        int posicaoOperador = encontrarOperador(entrada);

        double numero1 = Double.parseDouble(entrada.substring(0,posicaoOperador).trim());
        char operador = entrada.charAt(posicaoOperador);
        double numero2 = Double.parseDouble(entrada.substring(posicaoOperador+1).trim());

        double resultado;

        switch (operador){
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if (numero2 != 0){
                    resultado = numero1 / numero2;
                }else {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                    return;
                }
                break;
            default:
                System.out.println("Operador inválido");
                return;

        }

        System.out.println("Resultado é : "+resultado);

        scanner.close();
    }

    public static int encontrarOperador(String entrada){
        int posicao = -1;

        if (entrada.contains("+")){
            posicao = entrada.indexOf("+");
        } else if (entrada.contains("-")) {
            posicao = entrada.indexOf("-");
        } else if (entrada.contains("*")) {
            posicao = entrada.indexOf("*");
        } else if (entrada.contains("/")) {
            posicao = entrada.indexOf("/");
        }
        return posicao;
    }

}