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
    
    
    
    
    public static ArrayList<Token> Analizador(String cadena){
       ArrayList<Token> tokens = new ArrayList<Token>() ;
       
       String[] spliter = cadena.split(" ");
       String[] spliter2 = cadena.split("/");
       System.out.println(spliter2[0]+" separacion "+spliter2[1]);
       for( String palabra : spliter ){
           
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
    }
       
       return tokens;
    } 
    
    public static void main(String[] args) {
       ArrayList<Token> lista = Analizador("if ( 3 + 3 ) /*as das dfd   sfw*/");
       for(Token elem : lista){
           System.out.println(elem.getTipo()+" : "+elem.getValor());
       }
    }
    
    
}

