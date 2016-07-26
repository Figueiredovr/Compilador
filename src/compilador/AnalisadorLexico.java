/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico;

/**
 *
 * @author Anderson Queiroz
 */
public class AnalisadorLexico {

    String letras = "abcdefghkijlmnpqorstuvwxyzABCDEFGHKIJLMNPQORSTUVWXYZ";
    String numero = "1234567890";
    String delimitador = ",;()\'\"";
    String palavrasReservadas[] = {"programa", "const", "var", "funcao", "inicio", "fim",
        "se", "entao", "senao", "enquanto", "faca", "leia", "escreva", "inteiro",
        "real", "booleano", "verdadeiro", "falso", "cadeia", "caractere"};
    String operadoresAritmeticos = "+-*/";
    String operadoresRacionais[] = {"<>", "=", "<", "<=", ">", "<="};
    String operadoresLogicos[] = {"nao", "e", "ou"};
    int cont = 0;

    public boolean automatoNumero(String in) {
        String estado = "primeiro";
        char num;
        for (int i = 0; i < in.length(); i++) {
            num = in.charAt(i);
            if (numero(num) || num == '-' || num == '.' || num == ';') {
                switch (estado) {
                    case ("primeiro"):
                        if (numero(num)) {
                            estado = "segundo";
                        } else if (num == '-') {
                            estado = "negativo";
                        } else {
                            estado = "erro";
                        }
                        break;

                    case ("segundo"):
                        if (numero(num)) {
                            estado = "segundo";
                        } else if (num == '.') {
                            estado = "decimal";
                        } else if (num == ';') {
                            estado = "delimitador";
                        } else {
                            estado = "erro";
                        }
                        break;

                    case ("negativo"):
                        if (numero(num)) {
                            estado = "segundo";
                        } else {
                            estado = "erro";
                        }
                        break;

                    case ("decimal"):
                        if (numero(num)) {
                            estado = "terceiro";
                        } else {
                            estado = "erro";
                        }
                        break;     
                        
                    case ("terceiro"):
                        if(numero(num)){
                            estado = "terceiro";                            
                        } else if(num == ';' || num == '+' || num == '-' 
                                || num == '*' || num == '/'){
                            estado = "delimitador";
                        } else {
                            estado = "erro";
                        }                        
                        break;
                        
                    case ("erro"):
                        return false;
                        
                    default:
                        break;
                }
            } else {
                return false;
            }
        }
        if(estado.equals("delimitador"))
            return true;
        else 
            return false;
        
    }

    public boolean numero(char x) {
        String numero = "1234567890";
        for (int i = 0; i < numero.length(); i++) {
            if (x == numero.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean teste = false;
        
        AnalisadorLexico analisadorLexico = new AnalisadorLexico();
        
        teste = analisadorLexico.automatoNumero("10111111.1;");
        if(teste)
            System.out.println("Verdadeiro");
        else 
            System.out.println("Erro");
    }

}
