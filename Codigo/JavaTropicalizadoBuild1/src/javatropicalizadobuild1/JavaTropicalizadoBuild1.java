/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatropicalizadobuild1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author carlo
 */
public class JavaTropicalizadoBuild1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        
        Pattern patron =Pattern.compile("/[*](.|[\\r\\n])*?[*]/");
         Matcher matcher = patron.matcher("/*f A98 98(*^&6*/");
         
         if(matcher.find()){
             System.out.println("soy comen");
         }
         else{
             System.out.println("no soy");
         }
        
    }
    
}
