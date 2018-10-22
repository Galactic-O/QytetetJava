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
public class Casilla {
    private int numeroCasilla;
    private int coste; //En el caso de casillas de tipo CALLE será tomado del precioCompra de su titulo de propiedad
    private TipoCasilla tipo;
    private TituloPropiedad titulo;

    // Constructor para casillas que no son tipo CALLE
    public Casilla(int numeroCasilla, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.tipo = tipo;
        this.coste = 0;
        this.titulo = null;
    }
    
    // Constructor para casillas tipo CALLE
    public Casilla(int numeroCasilla, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        setTitulo(titulo);
        this.coste = this.titulo.getPrecioCompra();
        this.tipo = TipoCasilla.CALLE;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public int getCoste() {
        return coste;
    }

    public TipoCasilla getTipo() {
        return tipo;
    }

    public TituloPropiedad getTitulo() {
        return titulo;
    }

    public void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Casilla{" + "numeroCasilla=" + numeroCasilla + ", coste=" + coste + ", tipo=" + tipo + ", titulo=" + titulo + '}';
    }
    
    
}

