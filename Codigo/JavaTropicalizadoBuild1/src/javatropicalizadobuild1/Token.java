/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatropicalizadobuild1;

/**
 *Clase: Token
 * Entradas: string con la palabra
 * Salidas: true si el patron concuerda con algun token del enum 
 * false si no concuerda con nunguno
 * PD: esta clase funciona como estructura de datos para la lista de los tokens.
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
 
    /**
     * Lista de tokens con su patron para ser comparado e identificado.
     */
    enum Tipos {
        
        OP_BINARIO("^[&&|<|>|+|!|*]$|^[-]$"),
        OP_ASIGNACION ("^=$"),
        COMENTARIO_INICIO ("^/[*]$"),
        COMENTARIO_FIN ("^[*]/$"),
        FIN_EJECUCION ("^[;]$"),
        DELIMITADOR_DER ("^[)]$|^[}]$"),
        DELIMITADOR_IZQ  ("^[(]$|^[{]$"),
        RESERVADA ("^clase$|^mientras$|^largo$"
                + "|^ent$|^publico$|^estatico$|^inicial$"
                + "|^vacio$|^nuevo$|^mostrarlinea$|^si$"
                + "|^sino$|^retornar$|^Cadena[^0-9a-zA-Z]*$"
                + "|^verdadero$|^falso$|^esto$|^extiende$|^[.]$"),
        IDENTIFICADOR ("^[^\\d].*[a-zA-Z_0-9]*"),
        ENTERO_REAL ("^[0-9]+$");
       
        public final String patron;/**variable para sacar el patron de la lista de tokens.*
        
        /**
         *Contructor de la lista enum de tokens se encarga de setear el patron solicitado. 
         */
        Tipos(String s) {
            this.patron = s;
        }
    }
    
    
}
