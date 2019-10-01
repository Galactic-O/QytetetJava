/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author Pablo ~(u_u~)
 */
public abstract class Casilla {
    protected int numeroCasilla;
    
    Casilla(int numeroCasilla) {
        this.numeroCasilla = numeroCasilla;
    }
    
    public int getNumeroCasilla() {
        return numeroCasilla;
    }
    
    abstract int getCoste();
    abstract TipoCasilla getTipo();
    abstract TituloPropiedad getTitulo();
    abstract TituloPropiedad asignarPropietario(Jugador jugador);
    
    abstract boolean soyEdificable();
    abstract boolean tengoPropietario();
    abstract int pagarAlquiler();
    
    @Override
    public String toString() {
        return "Casilla:" + "\nNumeroCasilla= " + numeroCasilla;
    }
    
    
}

