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
    private String tipo;            //Identificar qual lexema eh
    private String estadoAtual;     //Em qual estado do automato esta
    private String buffer;          //O buffer com o que foi consumido pelo automato

    //@param Tipo do lexema Ex: Identificador
    public Lexema (String tipo){
        this.tipo = tipo;
    }

    public String tipo (){
        return this.tipo;
    }

    public boolean letra (char x){
      String letras = String("abcdefghkijlmnpqorstuvwxyzABCDEFGHKIJLMNPQORSTUVWXYZ");
      for (int i=0;i<letras.length();i++){
        if(x==letras[i]) return true;
      }
      return false;
    }

    public boolean numero (char x){
      String numero = String("1234567890");
      for (int i=0;i<numero.length();i++){
        if(x==numero[i]) return true;
      }
      return false;
    }

    public abstract boolean automato(char x);




}
