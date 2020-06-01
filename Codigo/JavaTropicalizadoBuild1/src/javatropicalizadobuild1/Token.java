/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatropicalizadobuild1;

/**
 *
 * @author carlo
 */
public class Token {
    
    private Tipos tipo;
    private String valor;
 
    
    public Tipos getTipo() {
        return tipo;
    }
 
    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }
 
    public String getValor() {
        return valor;
    }
 
    public void setValor(String valor) {
        this.valor = valor;
    }
 
   
    
    enum Tipos {
        ENTERO_REAL ("[0-9]+"),
        OP_BINARIO("[&&|<|+|-]"),
        COMENTARIO ("/[*](.|[\\r\\n])*?[*]/"),
        IDENTIFICADOR ("^[^\\d].*[a-zA-Z_0-9]+");
        
 
        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }
    
    
}
