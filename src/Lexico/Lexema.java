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
    
    public abstract boolean automato(char x);
        
    
    
    
}
