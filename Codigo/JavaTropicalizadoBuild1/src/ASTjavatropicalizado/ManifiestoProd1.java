/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjavatropicalizado;

/**
 *
 * @author carlo
 */
public class ManifiestoProd1 extends Manifiesto {
    public Reservada A,B;
    public Expresion Ex;
    public DelimitadorIzq Di;
    public DelimitadorDer Dd;
    public Manifiesto Mn1,Mn2;

    public ManifiestoProd1(Reservada A, Reservada B, Expresion Ex, DelimitadorIzq Di, DelimitadorDer Dd, Manifiesto Mn1, Manifiesto Mn2) {
        this.A = A;
        this.B = B;
        this.Ex = Ex;
        this.Di = Di;
        this.Dd = Dd;
        this.Mn1 = Mn1;
        this.Mn2 = Mn2;
    }
    
}
