/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASTjavatropicalizado;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class DeclaraciondeClaseProd1 extends DeclaraciondeClase{
    public Reservada A,B;
    public identificador I1,I2;
    public DelimitadorIzq Di;
    public DelimitadorDer Dd;
    public ArrayList<DeclaraciondeVariable> DvLista;
    public ArrayList<DeclaraciondeMetodo> DmLista;

    public DeclaraciondeClaseProd1(Reservada A, identificador I1, DelimitadorIzq Di, DelimitadorDer Dd, ArrayList<DeclaraciondeVariable> DvLista, ArrayList<DeclaraciondeMetodo> DmLista) {
        this.A = A;
        this.I1 = I1;
        this.Di = Di;
        this.Dd = Dd;
        this.DvLista = DvLista;
        this.DmLista = DmLista;
    }

    public DeclaraciondeClaseProd1(Reservada A, Reservada B, identificador I1, identificador I2, DelimitadorIzq Di, DelimitadorDer Dd, ArrayList<DeclaraciondeVariable> DvLista, ArrayList<DeclaraciondeMetodo> DmLista) {
        this.A = A;
        this.B = B;
        this.I1 = I1;
        this.I2 = I2;
        this.Di = Di;
        this.Dd = Dd;
        this.DvLista = DvLista;
        this.DmLista = DmLista;
    }

    
    
}
