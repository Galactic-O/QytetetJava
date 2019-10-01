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
public class Especulador extends Jugador {
    private int fianza;
    
    public Especulador(Jugador unJugador, int fianza)  {
        super(unJugador);
        this.fianza = fianza;
    }
    
    
    @Override
    protected void pagarImpuesto() {
        this.saldo = this.saldo - (this.casillaActual.getCoste() / 2);
    }
    
    @Override
    protected boolean deboIrACarcel() {
        return  !(this.pagarFianza()) && !(this.tengoCartaLibertad());

    }
    
    @Override
    protected Especulador convertirme(int fianza) {
        return this;
    }
    
    private boolean pagarFianza() {
        boolean ret;
        if (this.saldo > this.fianza){
            this.saldo = this.saldo - this.fianza;
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }
    
    @Override
    protected boolean puedoEdificarCasa(TituloPropiedad titulo) {
        boolean edificable = false;
        int numCasas = titulo.getNumCasas();
        if (numCasas < 8) 
        {
            edificable = true;
        }
        return edificable;
    }

    @Override
    protected boolean puedoEdificarHotel(TituloPropiedad titulo) {
        boolean edificable = false;
        int numCasas = titulo.getNumCasas();
        int numHoteles = titulo.getNumHoteles();
        if (numCasas >= 4 && numHoteles < 8) 
        {
            edificable = true;
        }
        return edificable;
    }
    
    // POR HACER - toString
}

