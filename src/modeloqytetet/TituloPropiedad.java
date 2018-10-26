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
public class TituloPropiedad {
    private String nombre;
    private boolean hipotecada;
    
    private int precioCompra;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    
    private int precioEdificar;
    private int numHoteles;
    private int numCasas;
    
    private Jugador propietario = null;

    
    TituloPropiedad(String nombre, int precioCompra, int alquilerBase, float factorRevalorizacion, int hipotecaBase, int precioEdificar) {
        this.hipotecada = false;
        this.numHoteles = 0;
        this.numCasas = 0;
        
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizacion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
    }

    

    public String getNombre() {
        return nombre;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public int getAlquilerBase() {
        return alquilerBase;
    }

    public float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }

    public int getHipotecaBase() {
        return hipotecaBase;
    }

    public int getPrecioEdificar() {
        return precioEdificar;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    public int getNumCasas() {
        return numCasas;
    }

    @Override
    public String toString() {
        return "TituloPropiedad:" + "\n Nombre=" + nombre + "\n hipotecada=" + hipotecada + "\n PrecioCompra=" + precioCompra + "\n AlquilerBase=" + alquilerBase + "\n FactorRevalorizacion=" + factorRevalorizacion + "\n HipotecaBase=" + hipotecaBase + "\n PrecioEdificar=" + precioEdificar + "\n NumHoteles=" + numHoteles + "\n NumCasas=" + numCasas + "\n";
    }
    
    
}
