/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatropicalizadoParser;

import ASTjavatropicalizado.DeclaraciondeClase;
import ASTjavatropicalizado.DeclaraciondeClaseProd1;
import ASTjavatropicalizado.DeclaraciondeMetodo;
import ASTjavatropicalizado.DeclaraciondeMetodoProd1;
import ASTjavatropicalizado.DeclaraciondeVariable;
import ASTjavatropicalizado.DelimitadorDer;
import ASTjavatropicalizado.DelimitadorIzq;
import ASTjavatropicalizado.Expresion;
import ASTjavatropicalizado.Expresion1;
import ASTjavatropicalizado.ExpresionProd1;
import ASTjavatropicalizado.FinEjecucion;
import ASTjavatropicalizado.Manifiesto;
import ASTjavatropicalizado.ManifiestoProd1;
import ASTjavatropicalizado.Reservada;
import ASTjavatropicalizado.Tipo;
import ASTjavatropicalizado.identificador;
import java.util.ArrayList;
import javatropicalizadobuild1.Token;
import javatropicalizadobuild1.Token.Tipos;

/**
 *
 * @author Carlos
 * @author Jose
 * @author Kevin
 * DeclaraciondeClase ::= “clase” identificador 
 * ( “extiende” Identificador)? “{“ ( DeclaraciondeVariable )* 
 * ( DeclaraciondeMetodo )* “}”
 * 
 * Manifiesto ::= “si” “(“ Expresion “)” Manifiesto “sino” Manifiesto
 * 
 * Expresion ::= Identificador Expresion’
 * 
 * DeclaraciondeMetodo ::= “publico” Tipo Identificador 
 * “(“ ( tipo identificador ( “,” tipo identificador )* )? “)”
 * “{“ ( DeclaraciondeVariable)* (  Manifiesto )* “retornar” Expresion “;” “}”
 */
public class Parser {
    private Token actual;

    public void setActual(Token actual) {
        this.actual = actual;
    }
    
    
    public void aceptarTerminal(String valor_esperado ) {
        if( actual.getValor().equals(valor_esperado) ){
            //actual = Scaner.proximoToken();
        }
        else{
            throw new RuntimeException("Error de syntaxis");
        }
    }
   
    public void parse_Programa(){
        parse_DeclaraciondeClase();
        
        
    }
    /*
     * DeclaraciondeClase ::= “clase” identificador 
     * ( “extiende” Identificador)? “{“ ( DeclaraciondeVariable )* 
     * ( DeclaraciondeMetodo )* “}”
     */
    public DeclaraciondeClase parse_DeclaraciondeClase()throws RuntimeException{
        DeclaraciondeClase astDeClase = null;
        Reservada astReser1 ;
        Reservada astReser2= null;
        identificador astIden1;
        identificador astIden2 = null;
        ArrayList<DeclaraciondeVariable> DevarLista = new ArrayList<DeclaraciondeVariable>();
        ArrayList<DeclaraciondeMetodo> DemetLista = new ArrayList<DeclaraciondeMetodo>();
                                                                                //DeclaraciondeClase ::=
        switch(actual.getTipo()){
            case RESERVADA :
            {
                aceptarTerminal("clase");                                       //“clase”
                astReser1 = new Reservada("calse");
                astIden1 = parse_identificador();                                          //identificador
                if(actual.getValor().equals("extiende")){                       //( “extiende” Identificador)? 
                    aceptarTerminal("extiende");                                //“extiende”
                    astReser2 = new Reservada("extiende");
                    astIden2 = parse_identificador();             //Identificador
                }
                aceptarTerminal("{");                                           //“{“
                DelimitadorIzq astdli1 = new  DelimitadorIzq("{");
                while(actual.getValor().equals("ent")       
                        ||actual.getValor().equals("booleano")
                        ||actual.getTipo() == Tipos.IDENTIFICADOR)
                {
                                                                                //( DeclaraciondeVariable )*
                    DeclaraciondeVariable astDeVaraible = parse_DeclaraciondeVariable();
                    DevarLista.add(astDeVaraible);
                }
                while(actual.getValor().equals("publico")){
                                                                                //( DeclaraciondeMetodo )*
                    DeclaraciondeMetodo astDeMetodo = parse_DeclaraciondeMetodo();
                    DemetLista.add(astDeMetodo);
                }
                aceptarTerminal("}");                                           //“}”
                DelimitadorDer astdld1 = new  DelimitadorDer("}");
                
                if(astReser2 != null){
                    astDeClase = new DeclaraciondeClaseProd1(astReser1,
                                                            astReser2, astIden1,
                                                            astIden2, astdli1, astdld1,
                                                            DevarLista, DemetLista);
                    return  astDeClase;
                }
                else if (astReser2 == null){
                    astDeClase = new DeclaraciondeClaseProd1(astReser1,
                                                              astIden1, astdli1,
                                                              astdld1, DevarLista,
                                                              DemetLista);
                    return  astDeClase;
                }
                
            }
            default:
                throw new RuntimeException("Error de sintaxis");
         }
        
      }
   /*
    * Manifiesto ::= “si” “(“ Expresion “)” Manifiesto “sino” Manifiesto
    */
    public Manifiesto parse_Manifiesto(){
        Manifiesto astManifiesto = null;
        Reservada astReser1;
        Reservada astReser2;
        DelimitadorIzq astdli1;
        DelimitadorDer astdld1;
        Manifiesto astMn1;
        Manifiesto astMn2;
        Expresion Exp1;
        
        switch(actual.getTipo()){                          //Manifiesto ::=
            case RESERVADA:{
                if(actual.getValor().equals("si")){ 
                    aceptarTerminal("si");                 //“si”
                    astReser1 = new Reservada("si");
                    aceptarTerminal("(");                  //“(“
                    astdli1 = new  DelimitadorIzq("(");
                    Exp1 = parse_Expresion();              //Expresion
                    aceptarTerminal(")");                  //“)”
                    astdld1 = new  DelimitadorDer(")");
                    astMn1 = parse_Manifiesto();           //Manifiesto
                    aceptarTerminal("sino");               //“sino”
                    astReser2 = new Reservada("sino");
                    astMn2 = parse_Manifiesto();           //Manifiesto
                    astManifiesto = new ManifiestoProd1(astReser1, astReser2,
                                                        Exp1, astdli1, astdld1,
                                                        astMn1, astMn2);

                }
               return astManifiesto;
                
            }
            default:
                throw new RuntimeException("error de sintaxis");
            
        }
        
    }
    /*
     * Expresion ::= Identificador Expresion’
     */
    public Expresion parse_Expresion(){
        Expresion astExpresion = null;
        identificador astident;
        Expresion1 astExp1_1;
        switch(actual.getTipo()){                      //Expresion ::=
            case IDENTIFICADOR:{            
                astident = parse_identificador();      //Identificador
                astExp1_1 =  parse_Expresion1();       //Expresion’
                astExpresion = new ExpresionProd1(astident, astExp1_1);
            }
            return astExpresion;
             default : 
                 throw new RuntimeException("Error de sintaxis");
        
        
        }
       
        
        
    }
   
   /* DeclaraciondeMetodo ::= “publico” Tipo Identificador 
 * “(“ ( tipo identificador ( “,” tipo identificador )* )? “)”
 * “{“ ( DeclaraciondeVariable)* (  Manifiesto )* “retornar” Expresion “;” “}”
 */   
    public DeclaraciondeMetodo parse_DeclaraciondeMetodo(){
        DeclaraciondeMetodo astDeMetodo = null;
        Reservada Reser1 = null ,Reser2 = null,Reser3;
        Tipo tipo1;
        Tipo tipo2 =null;
        identificador ident1, ident2 =null;
        ArrayList<Tipo> tipo3Lista= new ArrayList<Tipo>();
        ArrayList<identificador> identLista = new ArrayList<identificador>();
        ArrayList<DeclaraciondeVariable> DevarLista = new ArrayList<DeclaraciondeVariable>();
        ArrayList<Manifiesto> ManifiestoLista = new ArrayList<Manifiesto>();
        Expresion Exp1;
        FinEjecucion fne;
        DelimitadorIzq Dli1, Dli2;
        DelimitadorDer Dld1,Dld2;
        
        
        switch(actual.getTipo()){                                       //DeclaraciondeMetodo ::=
            case RESERVADA:{
                if(actual.getValor().equals("publico")){
                    aceptarTerminal("publico");                         //“publico”
                    Reser1 = new Reservada("publico");
                }
                tipo1 = parse_Tipo();                                   //Tipo
                ident1 = parse_identificador();                         //identificador
                aceptarTerminal("(");                                   //“(“
                Dli1 = new DelimitadorIzq("(");
                if(actual.getTipo() == Tipos.RESERVADA){                //( tipo identificador ( “,” tipo identificador )* )?
                    tipo2 =parse_Tipo();
                    ident2 =parse_identificador();                      //Identificador 
                    while(actual.getValor() == ","){                    //( “,” tipo identificador )*
                        aceptarTerminal(",");                           //,
                        Reser2 = new Reservada(",");
                        tipo3Lista.add(parse_Tipo());
                        identLista.add(parse_identificador());          //identificador
                    }
                }
                aceptarTerminal(")");                                   //“)”
                Dld1 = new DelimitadorDer(")");
                aceptarTerminal("{");                                   //“{“
                Dli2 = new DelimitadorIzq("{");
                while(actual.getValor().equals("ent")                   //( DeclaraciondeVariable)*
                        ||actual.getValor().equals("ent")){
                    
                    DevarLista.add(parse_DeclaraciondeVariable());      //DeclaraciondeVariable
                }
                while(actual.getTipo() == Tipos.RESERVADA){             //(  Manifiesto )*
                    ManifiestoLista.add(parse_Manifiesto());            //Manifiesto
                    
                }
                aceptarTerminal("retornar");                            //“retornar”
                Reser3 = new Reservada("retornar");
                Exp1 = parse_Expresion();                               //Expresion
                aceptarTerminal(";");                                   //“;”
                fne = new FinEjecucion();
                aceptarTerminal("}");                                   //“}”
                Dld2 = new DelimitadorDer("}");
            
                if(tipo2 == null){
                    astDeMetodo = new DeclaraciondeMetodoProd1(Reser1, Reser2, tipo1, ident1,
                                                                DevarLista, ManifiestoLista, Exp1, Dli1,
                                                                Dli2, Dld1, Dld2, fne);
                    return astDeMetodo;
                }
                else if(tipo2 !=null){
                    astDeMetodo = new DeclaraciondeMetodoProd1(Reser1, Reser2, Reser3, tipo1,
                                                                tipo2, ident1, ident2, tipo3Lista,
                                                                identLista, DevarLista, ManifiestoLista,
                                                                Exp1, Dli1, Dli2, Dld1, Dld2, fne);
                    return astDeMetodo;
                }
            }
            default : 
                 throw new RuntimeException("Error de sintaxis");
        }
        
    }
     public Tipo parse_Tipo(){
         return null;
     }
     public Expresion1 parse_Expresion1(){
        return null;
    }
    public identificador parse_identificador(){
       return null;
        
    }
    public DeclaraciondeVariable parse_DeclaraciondeVariable(){
        return null;
    }
    
}
