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
public class DeclaraciondeMetodoProd1 extends DeclaraciondeMetodo {
    public Reservada A,B,C;
    public Tipo T1,T2;
    public identificador I1,I2;
    public ArrayList<Tipo> T3Lista;
    public ArrayList<identificador> ILista;
    public ArrayList<DeclaraciondeVariable> DvLista;
    public ArrayList<Manifiesto> MnLista;
    public Expresion Ex;
    public DelimitadorIzq Di1,Di2;
    public DelimitadorDer Dd1,Dd2;
    public FinEjecucion fe;

    public DeclaraciondeMetodoProd1(Reservada A, Reservada B, Tipo T1, identificador I1, ArrayList<DeclaraciondeVariable> DvLista, ArrayList<Manifiesto> MnLista, Expresion Ex, DelimitadorIzq Di1, DelimitadorIzq Di2, DelimitadorDer Dd1, DelimitadorDer Dd2, FinEjecucion fe) {
        this.A = A;
        this.B = B;
        this.T1 = T1;
        this.I1 = I1;
        this.DvLista = DvLista;
        this.MnLista = MnLista;
        this.Ex = Ex;
        this.Di1 = Di1;
        this.Di2 = Di2;
        this.Dd1 = Dd1;
        this.Dd2 = Dd2;
        this.fe = fe;
    }

    public DeclaraciondeMetodoProd1(Reservada A, Reservada B, Reservada C, Tipo T1, Tipo T2, identificador I1, identificador I2, ArrayList<Tipo> T3Lista, ArrayList<identificador> ILista, ArrayList<DeclaraciondeVariable> DvLista, ArrayList<Manifiesto> MnLista, Expresion Ex, DelimitadorIzq Di1, DelimitadorIzq Di2, DelimitadorDer Dd1, DelimitadorDer Dd2, FinEjecucion fe) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.T1 = T1;
        this.T2 = T2;
        this.I1 = I1;
        this.I2 = I2;
        this.T3Lista = T3Lista;
        this.ILista = ILista;
        this.DvLista = DvLista;
        this.MnLista = MnLista;
        this.Ex = Ex;
        this.Di1 = Di1;
        this.Di2 = Di2;
        this.Dd1 = Dd1;
        this.Dd2 = Dd2;
        this.fe = fe;
    }

    

    
    
}
