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
public class Jugador {
    private boolean encarcelado;
    private String nombre;
    private int saldo;
    
    private Casilla casillaActual;
    private Sorpresa cartaLibertad;
    private ArrayList<TituloPropiedad> propiedades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.saldo = 7500;
        this.encarcelado = false;
        
        this.casillaActual = null;
        this.cartaLibertad = null;
        this.propiedades = new ArrayList();
    }
    
    boolean cancelarHipoteca(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean comprarTituloPropiedad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int cuantasCasasHotelesTengo(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean deboPagarAlquiler(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Sorpresa devolverCartaLibertad(){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean edificarCasa(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean edificarHotel(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void eliminarDeMisPropiedades(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean esDeMiPropiedad(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");    
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
    
    boolean getEncarcelado() {
        return encarcelado;
    }

    String getNombre() {
        return nombre;
    }

    ArrayList<TituloPropiedad> getPropiedades() {
        return propiedades;
    }
    
    public int getSaldo() {
        return saldo;
    }
    
    boolean hipotecarPropiedad(TituloPropiedad titulo){
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void irACarcel(Casilla carcel) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int modificarSaldo(int cantidad) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int obtenerCapital() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    ArrayList<TituloPropiedad> obtenerPropiedades(boolean hipotecada) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarAlquiler() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarImpuesto() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void pagarLibertad(int cantidad) {
        throw new UnsupportedOperationException("Sin implementar");
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
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private boolean tengoSaldo(int cantidad) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    boolean venderPropiedad(Casilla casilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    @Override
    public String toString() {
        return "\n--Jugador--" + "\nNombre: " + nombre + "\nEncarcelado: " + encarcelado + "\nSaldo: " + saldo + "\n";
    }
    
    
}
