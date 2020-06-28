/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatropicalizadobuild1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javatropicalizadobuild1.Token.Tipos;

/**
 * Clase AnalizadorLexico
 * Entradas: archivo a separa por tokens
 * Salidas: lista de tokens identificados 
 * PD:esta clase cuenta con 1 metodo el cual se llama tokenizador y se encarga 
 * de identificar los token presentes en el programa a compilar.
 */
public class AnalizadorLexico {
    static boolean  comentarioActivo = false ;

    
    
    /**
     * Metodo: Tokenizador()
     * Entradas: String a procesar
     * Salidas: Lista con todos los tokens identificados o mensaje de error
     * PD: esta clase es la que se encarga de comparar cada palabra del string 
     * con un patron predefinido y determinar a que token pertenece.
     */
    public  ArrayList<Token> Tokenizador(String cadena){
       ArrayList<Token> tokens = new ArrayList<Token>() ;
       
       String[] spliter = cadena.split(" ");
        for( String palabra : spliter ){
            
            if(palabra.equals("*/")){
               comentarioActivo = false;
            }
           
            boolean bandera = false;
            for(Tipos token: Tipos.values()){
           
                Pattern patron =Pattern.compile(token.patron);
                Matcher matcher = patron.matcher(palabra);
                if(matcher.matches()&& bandera == false ){
                    bandera = true;
                    if(comentarioActivo == false){
                        Token tokentemp = new Token();
                        tokentemp.setTipo(token);
                        tokentemp.setValor(palabra);
                        tokens.add(tokentemp);
                    }
                }
            }
        
            if(palabra.equals("/*")){
               comentarioActivo = true;
               //System.out.println("entre");
               
            }
        
            if(bandera== false){
            
                Exception r = new RuntimeException("Se ha encontrado un error en la palabra: "+palabra);
                throw new RuntimeException("Error en token", r);
            
            }  
        }
        return tokens;
    } 
}