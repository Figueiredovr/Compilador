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
    public String automato(char x) {

        for (int i; i < this.buffer.length; i++) {
            x = this;
            switch (this.estadoAtual) {

                case ("INIT"):
                    if (x == '\"') {
                        this.estadoAtual = "Q1";
                        this.consumir(x);
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
                    break;

                case ("Q2"):
                    if (this.letra(x) || this.numero(x) || x == ' ') {
                        this.estadoAtual = "Q2"
                    } else if ("\"") {
                        this.consumir(x);
                    }
                    this.valido = true;
                    return buffer;
                    else return buffer;

                case ("E"):
                    if (this.letra(x)) {
                        this.estadoAtual = "E";
                        this.consumir(x);
                    } else if (this.delimitador(x)) {
                        throw new CadeiaMalFormada(); //cadeia sem um caracter valido
                        this.valido = false;
                        return buffer;
                    }
                    break;

            }

        }
    }

}
