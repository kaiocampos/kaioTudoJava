package fundamentos_java.verificador_palindromos.model;

/*
Vamos começar criando a entidade Frase, que representará a string que queremos verificar se é um palíndromo.
 */
public class Frase {
    private String texto;

    public Frase(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Frase{" +
                "texto='" + texto + '\'' +
                '}';
    }
}
