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
public class Cadeia extends Lexema {

    public Cadeia(String buffer, String tipo) {
        super(buffer, tipo);
    }   

    @Override //Essa parte Não entendi muito bem como tu vai usar as variaveis..
    public boolean automato(char x) {

        return false;
    }
                    break;

                case ("Q1"):
                    if (this.letra(x)) {
                        this.estadoAtual = "Q2";
                        this.consumir(x);
                    } else if (x == '\"' || x == '\n') {
                        throw new CadeiaVazia(); //cadeia sem um caracter valido
                        return this.buffer;

                    } else {
                        this.estadoAtual = "E"
                    this.valido = false;
                        throw new PrefixoInvalido(); //começou a cadeia com número ou caracteer invalido
}
