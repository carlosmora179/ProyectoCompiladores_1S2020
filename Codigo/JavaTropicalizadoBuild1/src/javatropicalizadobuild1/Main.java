/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatropicalizadobuild1;

import static javatropicalizadobuild1.LecturaArchivo.lectura;

/**
 * Clase:Main
 * Entrada: archivo a compilar
 * Salida:  token separados y clasificados.
 */
public class Main {
    
    /**
     * Metodo:main()
     * Entrada: String[] args
     * Salida: ejecucion del programa java tropicalizado.
     */
    public static void main(String[] args) {
        try {
           lectura(); 
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error:"+e.getMessage());
        }

    }
    
}
