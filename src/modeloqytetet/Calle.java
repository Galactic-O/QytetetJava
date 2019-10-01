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
public class Calle extends Casilla {
    private int coste; 
    private TipoCasilla tipo;
    private TituloPropiedad titulo;

    
    public Calle(int numeroCasilla, TituloPropiedad titulo)  {
        super(numeroCasilla);
        this.titulo = titulo;
        this.coste = this.titulo.getPrecioCompra();
        this.tipo = TipoCasilla.CALLE;
    }
    
    @Override
    public int getCoste() {
        return this.coste;
    }
    
    @Override
    public TituloPropiedad getTitulo() {
        return this.titulo;
    }
    
    @Override
    public TipoCasilla getTipo() {
        return this.tipo;
    }
    
    private void setTitulo(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
    @Override
    int pagarAlquiler() {
        int costeAlquiler = this.titulo.pagarAlquiler();
        return costeAlquiler;
    }
    
    boolean propietarioEncarcelado() {
        return (this.titulo.propietarioEncarcelado());
    }
    
    @Override
    boolean soyEdificable() {
        return true;
    }

    @Override
    boolean tengoPropietario() {
        return (this.titulo.tengoPropietario());
    }
    
    @Override
    TituloPropiedad asignarPropietario(Jugador jugador) {
        this.titulo.setPropietario(jugador);
        return this.titulo;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n - Tipo: CALLE\n - Titulo:\n" + titulo;
    }
}
