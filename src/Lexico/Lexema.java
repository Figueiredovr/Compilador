/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexico;

/**
 *
 * @author Victor Figueiredo
 */
abstract class Lexema {

    public String var;              //Recebe o que tem no buffer no final do automato
    public String erro;
    public boolean valido;
    private String tipo;            //Identificar qual lexema eh
    private String estadoAtual;     //Em qual estado do automato esta
    private String buffer;          //O buffer com o que foi consumido pelo automato


    //@param Tipo do lexema Ex: Identificador
    public Lexema (String buffer, String tipo){
        this.tipo = tipo;
        this.buffer = buffer;
    }

    public String getTipo (){
        return this.tipo;
    }

    public boolean letra (char x){
      String letras = "abcdefghkijlmnpqorstuvwxyzABCDEFGHKIJLMNPQORSTUVWXYZ";
      for (int i=0;i<letras.length();i++){
        if(x == letras.charAt(i)) 
            return true;
      }
      return false;
    }

    public boolean numero (char x){
      String numero = "1234567890";
      for (int i=0;i<numero.length();i++){
        if(x == numero.charAt(i)) 
            return true;
      }
      return false;
    }

    public boolean delimitador (char x){
      String del = ",;()\'\" ";
      for (int i=0;i<del.length();i++){
        if(x == del.charAt(i)) 
            return true;
      }
      return false;
    }

    //Consome o x do byffer e adiciona no vetor var
    private void consumir (char x){
      this.var = this.var + x;
      this.buffer.replace( x, ' ');
    }

    private void erro (char x){
      
    }

    public abstract String automato(char x); 




}
