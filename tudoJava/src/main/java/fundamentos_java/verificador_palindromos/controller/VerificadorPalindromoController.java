package fundamentos_java.verificador_palindromos.controller;

import fundamentos_java.verificador_palindromos.model.Frase;
import fundamentos_java.verificador_palindromos.service.VerificadorPalindromoService;

import java.util.Scanner;
/*
Esta classe será responsável por interagir com o usuário, coletar a entrada, e exibir os resultados.
 */
public class VerificadorPalindromoController {
    private VerificadorPalindromoService service;
    private Scanner scanner;

    public VerificadorPalindromoController() {
        this.service = new VerificadorPalindromoService();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.print("Digite uma frase para verificar se é um palíndromo: ");
        String texto = scanner.nextLine();
        Frase frase = new Frase(texto);

        boolean isPalindromo = service.verificarPalindromo(frase);

        if (isPalindromo) {
            System.out.println("A frase é um palíndromo.");
        } else {
            System.out.println("A frase não é um palíndromo.");
        }
    }
}
