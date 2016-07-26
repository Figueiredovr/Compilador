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
            if (numero(num) || num == '-' || num == '.' || num == ';'
                    || num =='+' || num == '/' || num == '*') {
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
                        } else if (num == ';' || num == '+' || num == '-' 
                                || num == '*' || num == '/') {
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
    
    public boolean automatoPalavraReservada (String in){
        for (int i = 0; i < palavrasReservadas.length; i++)
            if(in.equals(palavrasReservadas[i]))
                return true;         
            
        return false;       
    }
    
    public boolean automatoIdentificador (String in){
        String estado = "primeiro";
        char c;
        
        for(int i = 0; i < in.length(); i++){
            c = in.charAt(i);
            switch(estado){
                case ("primeiro"):
                    if(letra(c)){
                        estado = "segundo";
                    } else {
                        estado = "erro";
                    }
                    break;
                    
                case ("segundo"):
                    if(letra(c) || numero(c) || c == '_'){
                        estado = "segundo";
                    } else if(c == ';'){
                        estado = "delimitador";
                    } else {
                        estado = "erro";
                    }                    
                    break;
                
                case ("erro"):
                    return false;
            }            
        }
        
        if(estado.equals("delimitador")){
            return true;
        } else {
            return false;
        }
            
    }
    
    public boolean automatoCadeia(String in){
        String estado = "primeiro";
        char c;
        for(int i = 0; i < in.length(); i++){
            c = in.charAt(i);
            
            switch(estado){
                case ("primeiro"):
                    if(c == '\"'){
                        estado = "segundo";
                    } else {
                        estado = "erro";
                    }                      
                    break;
                
                case ("segundo"):
                    if(letra(c)){
                        estado = "terceiro";
                    } else {
                        estado = "erro";
                    }                    
                    break;
                    
                case ("terceiro"):
                    if(c == '\"'){
                        estado = "delimitador";
                    } else if(c == '\\') {
                        estado = "erro";
                    } else {
                        estado = "terceiro";
                    }                    
                    break;
                
                case ("erro"):
                    return false;
            }
        }
        
        if(estado.equals("delimitador"))
            return true;
        else 
            return false;
        
    }
    
    public boolean automatoCaracter(String in){
        String estado = "primeiro";
        char c;
        for(int i = 0; i < in.length(); i++){
            c = in.charAt(i);
            
            switch(estado){
                case ("primeiro"):
                    if(c == '\''){
                        estado = "segundo";
                    } else {
                        estado = "erro";
                    }                      
                    break;
                
                case ("segundo"):
                    if(letra(c) || numero(c)){
                        estado = "terceiro";
                    } else {
                        estado = "erro";
                    }                    
                    break;
                    
                case ("terceiro"):
                    if(c == '\''){
                        estado = "delimitador";
                    } else {
                        estado = "erro";
                    }                    
                    break;
                
                case ("erro"):
                    return false;
            }
        }
        
        if(estado.equals("delimitador"))
            return true;
        else 
            return false;
        
    }
    
    
    public boolean numero(char x) {
        for (int i = 0; i < numero.length(); i++) {
            if (x == numero.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean letra (char x){
      for (int i=0;i<letras.length();i++){
        if(x == letras.charAt(i)) 
            return true;
      }
      return false;
    }
    
    public boolean delimitador (char x){
      for (int i=0;i<delimitador.length();i++){
        if(x == delimitador.charAt(i)) 
            return true;
      }
      return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean teste = false;
        
        AnalisadorLexico analisadorLexico = new AnalisadorLexico();
        
        teste = analisadorLexico.automatoIdentificador("qa123_23a");
        if(teste)
            System.out.println("Verdadeiro");
        else 
            System.out.println("Erro");
        
        teste = analisadorLexico.automatoCadeia("\"quaseuan cj 13j 123j svj12\" ");
        
        if(teste)
            System.out.println("Verdadeiro");
        else 
            System.out.println("Erro");
        
        teste = analisadorLexico.automatoCaracter("\'1\' ");
        
        if(teste)
            System.out.println("Verdadeiro");
        else 
            System.out.println("Erro");
        
        
    }

}
