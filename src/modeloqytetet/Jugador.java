/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;

/**
 *
 * @author Pablo ~(u_u~)
 */
public class Jugador implements Comparable {
    protected boolean encarcelado;
    protected String nombre;
    protected int saldo;
    
    protected Casilla casillaActual;
    protected Sorpresa cartaLibertad;
    protected ArrayList<TituloPropiedad> propiedades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.saldo = 7500;
        this.encarcelado = false;
        
        this.casillaActual = null;
        this.cartaLibertad = null;
        this.propiedades = new ArrayList();
    }
    
    protected Jugador(Jugador otroJugador) {
        this.nombre = otroJugador.nombre;
        this.saldo = otroJugador.saldo;
        this.encarcelado = otroJugador.encarcelado;
        
        this.casillaActual = otroJugador.casillaActual;
        this.cartaLibertad = otroJugador.cartaLibertad;
        this.propiedades = otroJugador.propiedades;
    }
    
    @Override
    public int compareTo(Object otroJugador) {
        int otroCapital = ((Jugador) otroJugador).obtenerCapital();
        return otroCapital - obtenerCapital();
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        boolean cancelada = false;
        
        int costeCancelar = titulo.calcularCosteCancelar();
        
        if (saldo >= costeCancelar){
            modificarSaldo(-costeCancelar);
            
            
            titulo.cancelarHipoteca();
                        
            cancelada = true;
        }
        
        return cancelada;
    }
    
    boolean comprarTituloPropiedad(){
        boolean comprado = false;
        int costeCompra = this.casillaActual.getCoste();
        if (costeCompra < this.saldo)
        {
            TituloPropiedad titulo = this.casillaActual.asignarPropietario(this);
            comprado = true;
            this.propiedades.add(titulo);
            modificarSaldo(-costeCompra);
        }
        return comprado;
    }
    
    protected Especulador convertirme(int fianza) {
        Especulador especulador = new Especulador(this, fianza);
        
        return especulador;
    }
    
    int cuantasCasasHotelesTengo(){
        int c=0, h=0;
        for (TituloPropiedad propiedad : propiedades){
            c=c+propiedad.getNumCasas();
            h=h+propiedad.getNumHoteles();
        }
        return c+h;
    }
    
    protected boolean deboIrACarcel() {
        return !(this.tengoCartaLibertad());
    }
    
    boolean deboPagarAlquiler(){
        TituloPropiedad titulo = this.casillaActual.getTitulo();
        boolean esDeMiPropiedad = esDeMiPropiedad(titulo);
        boolean tienePropietario = titulo.tengoPropietario();
        boolean encarcelado = titulo.propietarioEncarcelado();
        boolean estaHipotecada = titulo.isHipotecada();

        return (!esDeMiPropiedad && tienePropietario && !encarcelado && !estaHipotecada);
    }
    
    Sorpresa devolverCartaLibertad(){
        Sorpresa carta = this.cartaLibertad;
        this.cartaLibertad = null;
        return carta;
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        boolean edificable = puedoEdificarCasa(titulo);
        if (edificable) 
        {
            int costeEdificarCasa = titulo.getPrecioEdificar();
            boolean tengoSaldo = tengoSaldo(costeEdificarCasa);
            if (tengoSaldo)
            {
                titulo.edificarCasa();
                modificarSaldo(-costeEdificarCasa);
            }
        }
        return edificable;
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        boolean edificable = puedoEdificarHotel(titulo);
        if (edificable) 
        {
            int costeEdificarHotel = titulo.getPrecioEdificar();
            boolean tengoSaldo = tengoSaldo(costeEdificarHotel);
            if (tengoSaldo)
            {
                titulo.edificarHotel();
                modificarSaldo(-costeEdificarHotel);
            }
        }
        return edificable;
    }
    
    void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean esDeMiPropiedad(TituloPropiedad titulo){
        boolean encontrado = false;
        for(TituloPropiedad propiedad : propiedades){
            if(titulo == propiedad) encontrado = true;
        }
        return encontrado;   
    }
    
    boolean estoyEnCalleLibre(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa getCartaLibertad() {
        return cartaLibertad;
    }
    
    Casilla getCasillaActual() {
        return casillaActual;
    }
    
    public boolean getEncarcelado() {
        return encarcelado;
    }

    public String getNombre() {
        return nombre;
    }

    ArrayList<TituloPropiedad> getPropiedades() {
        return propiedades;
    }
    
    public int getSaldo() {
        return saldo;
    }
    
    void hipotecarPropiedad(TituloPropiedad titulo){
        int costeHipoteca = titulo.hipotecar();
        modificarSaldo(costeHipoteca);
    }

    void irACarcel(Casilla carcel) {
        setCasillaActual(carcel);
        setEncarcelado(true);
    }
    
    int modificarSaldo(int cantidad) {
        this.saldo = this.saldo + cantidad;
        return this.saldo;
    }
    
    int obtenerCapital() {
        int capital = 0;
        capital = capital + this.saldo;
        for (TituloPropiedad propiedad : propiedades) {
            capital = capital + propiedad.getPrecioCompra() + 
                    ( propiedad.getPrecioEdificar() * (propiedad.getNumCasas() + propiedad.getNumHoteles()) );
            if(propiedad.isHipotecada()) capital = capital - propiedad.getHipotecaBase();
        }
        return capital;
    }
    
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada) {
        ArrayList<TituloPropiedad> aux = new ArrayList<>();
        for(TituloPropiedad propiedad :propiedades){
            if(propiedad.isHipotecada() == hipotecada){
                    aux.add(propiedad);
            }
        }    
        return aux;
    }
    
    void pagarAlquiler() {
        int costeAlquiler = this.casillaActual.pagarAlquiler();
        modificarSaldo(-costeAlquiler);
    }
    
    void pagarImpuesto() {
        this.saldo = this.saldo - this.casillaActual.getCoste();
    }
    
    void pagarLibertad(int cantidad) {
        boolean tengoSaldo = tengoSaldo(cantidad);
        if (tengoSaldo)
        {
            setEncarcelado(false);
            modificarSaldo(-cantidad);
        }
    }
    
    protected boolean puedoEdificarCasa(TituloPropiedad titulo) {
        boolean edificable = false;
        int numCasas = titulo.getNumCasas();
        if (numCasas < 4) 
        {
            edificable = true;
        }
        return edificable;
    }
    
    protected boolean puedoEdificarHotel(TituloPropiedad titulo) {
        boolean edificable = false;
        int numCasas = titulo.getNumCasas();
        int numHoteles = titulo.getNumHoteles();
        if (numCasas >= 4 && numHoteles < 4) 
        {
            edificable = true;
        }
        return edificable;
    }
    
    void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }

    void setCasillaActual(Casilla casillaActual) {
        this.casillaActual = casillaActual;
    }

    void setCartaLibertad(Sorpresa cartaLibertad) {
        this.cartaLibertad = cartaLibertad;
    }
    
    boolean tengoCartaLibertad() {
        return (this.cartaLibertad != null);
    }
    
    private boolean tengoSaldo(int cantidad) {
        return (this.saldo > cantidad);
    }
    
    void venderPropiedad(Casilla casilla) {
        TituloPropiedad titulo = casilla.getTitulo();
        this.propiedades.remove(titulo);
        titulo.setPropietario(null);
    }

    @Override
    public String toString() {
        return "\n--Jugador--" + "\nNombre: " + nombre + "\nEncarcelado: " + encarcelado + "\nSaldo: " + saldo + "\nCapital: " + obtenerCapital() + "\n";
    }
    
    
}
