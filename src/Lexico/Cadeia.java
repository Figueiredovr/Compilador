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

    public Cadeia(String tipo) {
        super(tipo);
    }



    @Override
    public boolean automato(char x) {

        switch (this.estadoAtual){

        case("INIT"):
          if(x=='\"')  this.estadoAtual = "Q1";
          break;

        case("Q1"):
          if (this.letra(x)) {
            this.estadoAtual =  "Q2";
          }else if (x=='\"') {
            this.estadoAtual = "E2"
          } else {
            this.estadoAtual = "E1"
            throw new PrefixoInvalido(); //começou a cadeia com número ou caracteer invalido
          }
          break;

          case("Q2"):
          if(this.letra(x) || this.numero(x) || x==' '){
            this.estadoAtual = "Q2"
          }

          case("E1"):
            if (this.letra(x)) {
              this.estadoAtual = "Q2";
            } else if (x=="\"") {
              throw new CadeiaVazia(); //cadeia sem um caracter valido
              this.estadoAtual = "E2"
            }
            break;








        }


    }

}
