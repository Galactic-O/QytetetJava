/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;

/**
 *
 * @author pvr999
 */

public class Qytetet {
    /*Instancia*/
    private static final Qytetet instance = new Qytetet();
    
    /*Atributos*/
    private ArrayList<Sorpresa> mazo;
    private Sorpresa cartaActual;
    private Tablero tablero;
    private Dado dado;
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorActual;
    
    public static int MAX_JUGADORES = 4;
    static int NUM_SORPRESAS = 10;
    public static int NUM_CASILLAS = 20;
    static int PRECIO_LIBERTAD = 2000;
    static int SALDO_SALIDA = 1000;
    
    /*Métodos*/
    private Qytetet(/*ArrayList<String> nombres*/) {
        this.mazo = new ArrayList<>();
        this.cartaActual = null;
        this.dado = Dado.getInstance();
        this.jugadores = new ArrayList<>();
    }
    
    void actuarSiEnCasillaEdificable() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void actuarSiEnCasillaNoEdificable() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void aplicarSorpresa() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean cancelarHipoteca(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean comprarTituloPropiedad() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarCasa(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean edificarHotel(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void encarcelarJugador() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public Sorpresa getCartaActual() {
        return cartaActual;
    }
    
    Dado getDado() {
        return dado;
    }
    
    Jugador getJugadorActual() {
        return jugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    ArrayList getMazo(){
        return this.mazo;
    }
    
    public int getValorDado() {
        throw new UnsupportedOperationException("Sin implementar.");
    }
    
    public Tablero getTablero() {
        return tablero;
    }
    
    public void hipotecarPropiedad(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }

    private void inicializarCartasSorpresa(){
        this.mazo.add(new Sorpresa ("Sube el bitcoin. Ganas 100 euros.", 1, TipoSorpresa.PAGARCOBRAR));
        this.mazo.add(new Sorpresa ("Tienes tanta hambre que te comes tu billete de 200 euros. Ups.", 2, TipoSorpresa.PAGARCOBRAR));
        this.mazo.add(new Sorpresa ("Día de la marmota. Vuelve a la salida.", 0, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Tienes que comprar tomates en el Mercadona. Ve al Parking.", 12, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Te han pillado haciendo el dab en público, das "
                + "tanto cringe que te meten en la cárcel.", 6, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Tus casas están infestadas de abejas. Pagas 50 euros por cada casa u hotel.", 50, TipoSorpresa.PORCASAHOTEL));
        this.mazo.add(new Sorpresa ("Explota la burbuja, inundando tus propiedades. Ahora son spas. Ganas 50 por cada casa u hotel.", 50, TipoSorpresa.PORCASAHOTEL));
        this.mazo.add(new Sorpresa ("Los otros jugadores te confunden con una máquina expendedora por culpa de las drogas."
                + " Te roban 8,5789 euros cada uno.", 8, TipoSorpresa.PORJUGADOR));
        this.mazo.add(new Sorpresa ("Compras un aspirador mu tocho. Le robas 9 euros a cada jugador.", 9, TipoSorpresa.PORJUGADOR));
        this.mazo.add(new Sorpresa ("Practicas tus mortales hacia atrás hasta que puedes saltar muros. Sales de la cárcel.", 0, TipoSorpresa.SALIRCARCEL));
    }
    
    private void inicializarTablero() {
        this.tablero = new Tablero();
    }
    
    public void inicializarJuego(ArrayList<String> nombres) {
        inicializarTablero();
        inicializarCartasSorpresa();
        inicializarJugadores(nombres);
    }
    
    private void inicializarJugadores(ArrayList<String> nombres) {
        for(int i=0; i<nombres.size(); i++) {
            Jugador jugador = new Jugador(nombres.get(i));
            jugadores.add(jugador);
        }
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void jugar() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    void mover(int numCasillaDestino) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public Casilla obtenerCasillaJugadorActual() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Casilla> obtenerCasillasTablero() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int[] obtenerPropiedadesJugador() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int[] obtenerPropiedadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public void obtenerRanking() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public int obtenerSaldoJugadorActual() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void salidaJugadores() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    private void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
    }
    
    public void siguienteJugador() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    int tirarDado() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public boolean verderPropiedad(int numeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    /*Getter de instancia*/
    public static Qytetet getInstance() {
        return instance;
    }
}

