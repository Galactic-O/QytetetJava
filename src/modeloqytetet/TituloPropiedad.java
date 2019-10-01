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

    int calcularCosteCancelar(){
        int coste;
        
        coste = (int)(calcularCosteHipotecar() * 1.10);
        
        return coste;
    }
    
    int calcularCosteHipotecar()
    {
        int costeHipoteca = (int)(this.hipotecaBase + (this.numCasas * 0.5 * this.hipotecaBase) + (this.numHoteles * this.hipotecaBase));
        return costeHipoteca;
    }
    
    int calcularImporteAlquiler()
    {
       int costeAlquiler = (int)(this.alquilerBase + (this.numCasas * 0.5 + this.numHoteles * 2));
       return costeAlquiler;
    }
    
    int calcularPrecioVenta()
    {
        return (int)(this.precioCompra + (this.numCasas + this.numHoteles) * precioEdificar * factorRevalorizacion); 
    }
    
    void cancelarHipoteca(){
        hipotecada = false;
    }
    
    void cobrarAlquiler(int coste)
    {
        
    }
    
    void edificarCasa()
    {
        this.numCasas = this.numCasas + 1;
    }
    
    void edificarHotel()
    {
        this.numHoteles = this.numHoteles + 1;
        this.numCasas = this.numCasas - 4;
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

    public int getNumCasas() {
        return numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }
    
    int hipotecar()
    {
        setHipotecada(true);
        int costeHipoteca = calcularCosteHipotecar();
        return costeHipoteca;
    }
    
    int pagarAlquiler()
    {
        int costeAlquiler = calcularImporteAlquiler();
        this.propietario.modificarSaldo(costeAlquiler);
        return costeAlquiler;
    }
    
    boolean propietarioEncarcelado()
    {
        if (propietario != null) {
            if(propietario.getEncarcelado() == true){
                return true;
            }
        }
        return false;
    }
    
    boolean tengoPropietario()
    {
        return (propietario!=null);
    }

    Jugador getPropietario() {
        return propietario;
    }

    void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    

    @Override
    public String toString() {
        return "TituloPropiedad:" + "\n Nombre=" + nombre + "\n hipotecada=" + hipotecada + "\n PrecioCompra=" + precioCompra + "\n AlquilerBase=" + alquilerBase + "\n FactorRevalorizacion=" + factorRevalorizacion + "\n HipotecaBase=" + hipotecaBase + "\n PrecioEdificar=" + precioEdificar + "\n NumHoteles=" + numHoteles + "\n NumCasas=" + numCasas + "\n";
    }
    
    
}
