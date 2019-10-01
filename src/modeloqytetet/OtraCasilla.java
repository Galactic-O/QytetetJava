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
public class OtraCasilla extends Casilla{
    private TipoCasilla tipo;
    
    public OtraCasilla(int numeroCasilla, TipoCasilla tipo)  {
        super(numeroCasilla);
        this.tipo = tipo;
    }
    
    @Override
    public TipoCasilla getTipo() {
        return tipo;
    }

    @Override
    boolean soyEdificable() {
        return false;
    }
    
    @Override
    boolean tengoPropietario() {
        return false;
    }

    @Override
    int getCoste() {
        return 5002;
    }

    @Override
    TituloPropiedad getTitulo() {
        return null;
    }

    @Override
    int pagarAlquiler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    TituloPropiedad asignarPropietario(Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "Casilla:" + tipo + "\nNumeroCasilla= " + numeroCasilla;
    }
}
