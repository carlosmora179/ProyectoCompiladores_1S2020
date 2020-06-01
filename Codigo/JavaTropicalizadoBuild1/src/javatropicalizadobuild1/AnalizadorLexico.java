/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatropicalizadobuild1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javatropicalizadobuild1.Token.Tipos;

/**
 *
 * @author carlos
 */
public class AnalizadorLexico {
    
    
    
    
    public static ArrayList<Token> Tokenizador(String cadena){
       ArrayList<Token> tokens = new ArrayList<Token>() ;
       
       String[] spliter = cadena.split(" ");
       //String[] spliter2 = cadena.split("/");
       //System.out.println(spliter2[0]+" separacion "+spliter2[1]);
       for( String palabra : spliter ){
           //System.out.println("encontre: "+palabra);
           boolean bandera = false;
        for(Tipos token: Tipos.values())
       {
          Pattern patron =Pattern.compile(token.patron);
        Matcher matcher = patron.matcher(palabra);
        
        if(matcher.find()&& bandera == false){
            bandera = true;
            Token tokentemp = new Token();
            tokentemp.setTipo(token);
            tokentemp.setValor(palabra);
            tokens.add(tokentemp);
        }
        
       }
        if(bandera== false){
            
            Exception r = new RuntimeException("Se ha encontrado un error en la palabra: "+palabra);
            throw new RuntimeException("Error en token", r);
            
        }
    }
       return tokens;
    } 
    public static String Analizador(ArrayList<Token> tokens){
        String error ="";
        
        return error;
    }
    
    public static void main(String[] args) {
       ArrayList<Token> lista = Tokenizador("clase Factorial { publico estatico vacio inicial ( Cadena[] a ) { mostrarlinea ( nuevo Fac().ComputeFac( 10 ) ) ; } }");
       if(lista !=null){
       for(Token elem : lista){
           System.out.println(elem.getTipo()+" : "+elem.getValor());
       }
       }
    }
    
    //clase Factorial { publico estatico vacio inicial ( Cadena[] a ) { mostrarlinea ( nuevo Fac().ComputeFac( 10 ) ); } }
}

