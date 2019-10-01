/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

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
    private int numJugadorActual;
    private EstadoJuego estadoJuego;
    
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
        boolean deboPagar = this.jugadorActual.deboPagarAlquiler();
        if (deboPagar) {
            this.jugadorActual.pagarAlquiler();
            if (this.jugadorActual.getSaldo() <= 0) {
                setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
            }
        }

        Casilla casilla = obtenerCasillaJugadorActual();
        boolean tengoPropietario = casilla.tengoPropietario();
        if(estadoJuego != EstadoJuego.ALGUNJUGADORENBANCARROTA) {
            if(tengoPropietario) {
                setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
            } else {
                setEstadoJuego(EstadoJuego.JA_PUEDECOMPRAROGESTIONAR);
            }
        }
    }
    
    void actuarSiEnCasillaNoEdificable() {
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        Casilla casillaActual = this.jugadorActual.getCasillaActual();

        if (casillaActual.getTipo() == TipoCasilla.IMPUESTO) 
        {
            System.out.println("El jugador " + getJugadorActual().getNombre() +  " ha caido en una casilla de IMPUESTOS.");
            jugadorActual.pagarImpuesto();
            if (this.jugadorActual.getSaldo() <= 0) 
            {
                setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
            }
        } 
        else if (casillaActual.getTipo() == TipoCasilla.JUEZ) 
        {
            System.out.println("El jugador " + getJugadorActual().getNombre() +  " ha caido en una casilla JUEZ, y se va a la carcel.");
            encarcelarJugador();
        } 
        else if (casillaActual.getTipo() == TipoCasilla.SORPRESA) 
        {
            System.out.println("El jugador " + getJugadorActual().getNombre() +  " ha caido en una casilla SORPRESA.");
            cartaActual = mazo.get(0);
            mazo.remove(0);
            setEstadoJuego(EstadoJuego.JA_CONSORPRESA);
        }

        
    }
    
    public void aplicarSorpresa() 
    {
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        if(this.cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL)
        {
            this.jugadorActual.setCartaLibertad(cartaActual);
        } 
        else 
        {
            mazo.add(this.cartaActual);
            if (this.cartaActual.getTipo()==TipoSorpresa.PAGARCOBRAR) 
            {
                this.jugadorActual.modificarSaldo(this.cartaActual.getValor());
                if (this.jugadorActual.getSaldo() <= 0) 
                {
                    setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                }
            } 
            else if (this.cartaActual.getTipo()==TipoSorpresa.IRACASILLA) 
            {
                int valor = this.cartaActual.getValor();
                boolean casillaCarcel = this.tablero.esCasillaCarcel(valor);
                if (casillaCarcel) 
                {
                    encarcelarJugador();
                } 
                else 
                {
                    mover(valor);
                }
            } 
            else if (this.cartaActual.getTipo()==TipoSorpresa.PORCASAHOTEL) 
            {
                int cantidad = this.cartaActual.getValor();
                int numeroTotal = this.jugadorActual.cuantasCasasHotelesTengo();
                this.jugadorActual.modificarSaldo(cantidad*numeroTotal);
                if (this.jugadorActual.getSaldo() <= 0) 
                {
                    setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                }
            } 
            else if (this.cartaActual.getTipo()==TipoSorpresa.PORJUGADOR) 
            {
                for(int i=0; i<this.jugadores.size(); i++) 
                {
                    if (this.jugadores.get(i) != this.jugadorActual) 
                    {
                        this.jugadores.get(i).modificarSaldo(this.cartaActual.getValor());
                        if (this.jugadores.get(i).getSaldo() <= 0) 
                        {
                            setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                        }
                        this.jugadorActual.modificarSaldo(-(this.cartaActual.getValor()));
                        if (this.jugadorActual.getSaldo() <= 0) 
                        {
                            setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                        }
                    }
                }
            }
            else if (this.cartaActual.getTipo()==TipoSorpresa.CONVERTIRME) 
            {
                Especulador especulador = this.jugadorActual.convertirme(this.cartaActual.getValor());
                this.jugadores.set(jugadores.indexOf(this.jugadorActual), especulador);
                this.jugadorActual = especulador;
            }
        }
    }
    
    public boolean cancelarHipoteca(int numeroCasilla){
        boolean cancelada = false;
        
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        
        TituloPropiedad titulo = casilla.getTitulo();
        
        cancelada = jugadorActual.cancelarHipoteca(titulo);
        
        setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        
        return cancelada;
    }
    
    public boolean comprarTituloPropiedad() {
        boolean comprado = this.jugadorActual.comprarTituloPropiedad();
        if (comprado)
        {
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
            System.out.println("El jugador " + getJugadorActual().getNombre() +  " ha comprado una propiedad.");
        }
        return comprado;
    }
    
    public boolean edificarCasa(int numeroCasilla) {
        boolean edificada = false;
        Casilla casilla = this.tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        edificada = this.jugadorActual.edificarCasa(titulo);
        if (edificada) 
        {
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        return edificada;
    }
    
    public boolean edificarHotel(int numeroCasilla) {
        boolean edificada = false;
        Casilla casilla = this.tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        edificada = this.jugadorActual.edificarHotel(titulo);
        if (edificada) 
        {
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        return edificada;
    }
    
    private void encarcelarJugador() {
        if (this.jugadorActual.deboIrACarcel()) 
        {
            Casilla casillaCarcel = this.tablero.getCarcel();
            this.jugadorActual.irACarcel(casillaCarcel);
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        } 
        else
        {
            Sorpresa carta = this.jugadorActual.devolverCartaLibertad();
            this.mazo.add(carta);
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
    }
    
    public Sorpresa getCartaActual() {
        return cartaActual;
    }
    
    public Dado getDado() {
        return dado;
    }
    
    public EstadoJuego getEstadoJuego() {
        return estadoJuego;
    }
    
    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    public ArrayList getMazo(){
        return this.mazo;
    }
    
    public int getValorDado() {
        return dado.getValor();
    }
    
    public Tablero getTablero() {
        return tablero;
    }
    
    public void hipotecarPropiedad(int numeroCasilla) {
        Casilla casilla = this.tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        this.jugadorActual.hipotecarPropiedad(titulo);
    }

    private void inicializarCartasSorpresa(){
        this.mazo.add(new Sorpresa ("Parece que invertir en criptomonedas te ha salido rentable, ganas 500 euros.", 500, TipoSorpresa.PAGARCOBRAR));
        this.mazo.add(new Sorpresa ("La criptomoneda ha caido. Ups. Pierdes 400 euros", -400, TipoSorpresa.PAGARCOBRAR));
        this.mazo.add(new Sorpresa ("Día de la marmota. Vuelve a la salida.", 0, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Tienes que comprar tomates en el Mercadona. Ve al Parking.", 12, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Te han pillado haciendo el dab en público, das "
                + "tanto cringe que te meten en la cárcel.", 6, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Pagas 50 euros por cada casa u hotel, porque la vida es asi de injusta.", 50, TipoSorpresa.PORCASAHOTEL));
        this.mazo.add(new Sorpresa ("Explota la burbuja, inundando tus propiedades. Ahora son spas. Ganas 50 por cada casa u hotel.", 50, TipoSorpresa.PORCASAHOTEL));
        this.mazo.add(new Sorpresa ("Hoy te sientes comunista, y decides compartir la alegría del dinero entre todos tus amienemigos." + 
                " Le regalas 100 euros a cada jugador", -100, TipoSorpresa.PORJUGADOR));
        this.mazo.add(new Sorpresa ("Tus tendencias cleptómanas te llevan a robar 100 euros a cada jugador.", 100, TipoSorpresa.PORJUGADOR));
        this.mazo.add(new Sorpresa ("Practicas tus mortales hacia atrás hasta que puedes saltar muros. Sales de la cárcel.", 0, TipoSorpresa.SALIRCARCEL));
        this.mazo.add(new Sorpresa ("Los rumores dicen que eres la repera en lo que consta especular. Ahora eres un Especulador 3000.", 3000, TipoSorpresa.CONVERTIRME));
        this.mazo.add(new Sorpresa ("Los rumores dicen que eres la repera en lo que consta especular. Ahora eres un Especulador 5000.", 5000, TipoSorpresa.CONVERTIRME));
        Collections.shuffle(mazo);
    
    }
    
    private void inicializarTablero() {
        this.tablero = new Tablero();
    }
    
    public void inicializarJuego(ArrayList<String> nombres) {
        inicializarJugadores(nombres);
        inicializarTablero();
        inicializarCartasSorpresa();
        salidaJugadores();
    }
    
    private void inicializarJugadores(ArrayList<String> nombres) {
        for(int i=0; i<nombres.size(); i++) {
            Jugador jugador = new Jugador(nombres.get(i));
            jugadores.add(jugador);
        }
    }
    
    public boolean intentarSalirCarcel(MetodoSalirCarcel metodo) {
        if (metodo == MetodoSalirCarcel.TIRANDODADO) 
        {
            int resultado = tirarDado();
            if (resultado >= 5)
            {
                this.jugadorActual.setEncarcelado(false);
            }
        }
        else if (metodo == MetodoSalirCarcel.PAGANDOLIBERTAD)
        {
            this.jugadorActual.pagarLibertad(PRECIO_LIBERTAD);
        }

        boolean encarcelado = this.jugadorActual.getEncarcelado();
        if (encarcelado)
        {
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        }
        else
        {
            setEstadoJuego(EstadoJuego.JA_PREPARADO);
        }
        return !encarcelado;
    }
    
    public void jugar() {
        int valor = tirarDado();
        Casilla casillaFinal =  this.tablero.obtenerCasillaFinal(this.jugadorActual.getCasillaActual(), valor);
        mover(casillaFinal.getNumeroCasilla());
    }
    
    void mover(int numCasillaDestino) {
        Casilla casillaInicial = this.jugadorActual.getCasillaActual();
        Casilla casillaFinal = this.tablero.obtenerCasillaNumero(numCasillaDestino);
        this.jugadorActual.setCasillaActual(casillaFinal);

        if (numCasillaDestino < casillaInicial.getNumeroCasilla())
        {
            this.jugadorActual.modificarSaldo(SALDO_SALIDA);
        }

        if (casillaFinal.soyEdificable()) 
        {
            actuarSiEnCasillaEdificable();
        }
        else
        {
            actuarSiEnCasillaNoEdificable();
        }
    }
    
    public Casilla obtenerCasillaJugadorActual() {
        return this.jugadorActual.getCasillaActual();
    }
    
    public ArrayList<Casilla> obtenerCasillasTablero() {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugador() {
        ArrayList<Integer> propJugador = new ArrayList<>();
        boolean encontrado;

        for (int i=0; i<this.jugadorActual.getPropiedades().size(); i++) {
            encontrado = false;
            
            for (int j=0; j<this.tablero.getCasillas().size() && !encontrado; j++) {
                if ( jugadorActual.getPropiedades().get(i) == this.tablero.getCasillas().get(j).getTitulo() ) {
                    propJugador.add(this.tablero.getCasillas().get(j).getNumeroCasilla());
                    encontrado = true;
                }
            }
        }

        return propJugador;
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugadorSegunEstadoHipoteca(boolean estadoHipoteca) {
        ArrayList<Integer> propJugador = new ArrayList<>();
        boolean encontrado;

        for (int i=0; i<this.jugadorActual.getPropiedades().size(); i++) {
            encontrado = false;
            
            for (int j=0; j<this.tablero.getCasillas().size() && !encontrado; j++) {
                if ( jugadorActual.getPropiedades().get(i) == this.tablero.getCasillas().get(j).getTitulo() ) {
                    encontrado = true;
                    if ( jugadorActual.getPropiedades().get(i).isHipotecada() == estadoHipoteca ) {
                        propJugador.add(this.tablero.getCasillas().get(j).getNumeroCasilla());
                    }
                }
            }
        }

        return propJugador;
    }
    
    public void obtenerRanking() {
        ArrayList<Jugador> posiciones = jugadores;
        for(int i=0;i<posiciones.size();i++){
            for(int j=i+1;j<posiciones.size()-1;j++){
                if(posiciones.get(i).compareTo(posiciones.get(j))<=0){
                    Jugador aux = posiciones.get(j);
                    posiciones.set(j,posiciones.get(i));
                    posiciones.set(i,aux);
                }
            }
        }
        
        for(int i=0;i<posiciones.size();i++){
            System.out.println("Posicion " + i+1 + ": " + posiciones.get(i));
        }
    }
    
    public int obtenerSaldoJugadorActual() {
        return this.jugadorActual.getSaldo();
    }
    
    private void salidaJugadores() {
        for (int i=0; i<jugadores.size(); i++) {
            jugadores.get(i).setCasillaActual( tablero.obtenerCasillaNumero(0) );
        }

        Random r = new Random();
        int numero = r.nextInt(1);
        jugadorActual = jugadores.get(numero);

        setEstadoJuego(EstadoJuego.JA_PREPARADO);
    }
    
    private void setCartaActual(Sorpresa cartaActual) {
        this.cartaActual = cartaActual;
    }
    
    private void setEstadoJuego(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

    public void siguienteJugador() {
        int numSiguiente = 0;
        boolean encontrado = false;
        for(int i=0; i<jugadores.size() && !encontrado; i++)
        {
            if(jugadores.get(i)==jugadorActual) numSiguiente = i+1; 
            encontrado = true;
        }
        if(numSiguiente > jugadores.size()) numSiguiente = numSiguiente % jugadores.size();
        
        jugadorActual = jugadores.get(numSiguiente);

        if (jugadorActual.getEncarcelado()) this.estadoJuego = EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD;
        else this.estadoJuego = EstadoJuego.JA_PREPARADO;
    }
    
    int tirarDado() {
        return this.dado.tirar();
    }
    
    public void venderPropiedad(int numeroCasilla) {
        Casilla casilla = this.tablero.obtenerCasillaNumero(numeroCasilla);
        this.jugadorActual.venderPropiedad(casilla);
        int precioVenta = casilla.getTitulo().calcularPrecioVenta();
        this.jugadorActual.modificarSaldo(precioVenta);
    }
    
    /*Getter de instancia*/
    public static Qytetet getInstance() {
        return instance;
    }
}

