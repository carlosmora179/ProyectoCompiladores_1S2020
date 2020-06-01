/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatropicalizadobuild1;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class LecturaArchivo {
    String rutaArchivo = "";
    BufferedReader brArchivo ;

    public static void lectura(){
        AnalizadorLexico analizador = new AnalizadorLexico();
        BufferedReader objReader = null; 
        String ruta ="";
        
        ArrayList<Token> lista = new ArrayList<Token>();
        
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        try {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();                                        
            
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
        
        try{  
            String strCurrentLine;
            int lineas = 1;
            objReader = new BufferedReader(new FileReader(ruta));   
            
            while ((strCurrentLine = objReader.readLine()) != null) {
                
                   
                if(!strCurrentLine.equals("")){
                
                    strCurrentLine = strCurrentLine.replaceAll("    ","");
                    try {
                        lista.addAll(analizador.Tokenizador(strCurrentLine)); 

                    } catch (Exception e) {
                        throw new RuntimeException(" en la linea>"+(lineas)+" "+e.getCause(),e);
                    }
                    lineas++;
                }
            }
            
        } catch (IOException e ){ 
            System.out.println("error");
            e.printStackTrace();  
        }
        finally{   
            try{   
                if (objReader != null)     objReader.close();  
            } catch (IOException ex) {   
                ex.printStackTrace();  
            }
            if(lista !=null){
                String nombre = ".//salida.txt";
                File archivo = new File(nombre);
                
                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));
                    for(Token elem : lista){
                        bw.write(elem.getTipo()+" : "+elem.getValor()+"\n");
                        
                    }
                    bw.close();
                }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }
                
            for(Token elem : lista){
            System.out.println(elem.getTipo()+" : "+elem.getValor());
            }
        }
            
        }
    }
}