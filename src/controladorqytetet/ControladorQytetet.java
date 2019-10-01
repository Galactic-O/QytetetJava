/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorqytetet;

import java.util.ArrayList;
import modeloqytetet.EstadoJuego;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;
import controladorqytetet.*;

/**
 *
 * @author Pablo ~(u_u~)
 */
public class ControladorQytetet {
    private ArrayList<String> nombreJugadores;
    static ControladorQytetet instance = new ControladorQytetet();
    private Qytetet modelo = Qytetet.getInstance();
    
    public void setNombreJugadores(ArrayList<String> nombreJugadores) {
        this.nombreJugadores = nombreJugadores;
    }
    
    public ArrayList<Integer> obtenerOperacionesJuegoValidas() {
        ArrayList<Integer> validas = new ArrayList<>();
        
        if(modelo.getJugadores().isEmpty())
            validas.add(OpcionMenu.INICIARJUEGO.ordinal());
        else{
            if(modelo.getEstadoJuego() == EstadoJuego.ALGUNJUGADORENBANCARROTA){
                validas.add(OpcionMenu.OBTENERRANKING.ordinal());
            }else if(modelo.getEstadoJuego() == EstadoJuego.JA_PREPARADO){
                validas.add(OpcionMenu.JUGAR.ordinal());
            }else if(modelo.getEstadoJuego() == EstadoJuego.JA_PUEDEGESTIONAR){
                validas.add(OpcionMenu.PASARTURNO.ordinal());
                validas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                validas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                validas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                validas.add(OpcionMenu.EDIFICARCASA.ordinal());
                validas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                validas.add(OpcionMenu.PASARTURNO.ordinal());
            }else if(modelo.getEstadoJuego() == EstadoJuego.JA_PUEDECOMPRAROGESTIONAR){
                validas.add(OpcionMenu.COMPRARTITULOPROPIEDAD.ordinal());
                validas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                validas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                validas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                validas.add(OpcionMenu.EDIFICARCASA.ordinal());
                validas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                validas.add(OpcionMenu.PASARTURNO.ordinal());
            }else if(modelo.getEstadoJuego() == EstadoJuego.JA_CONSORPRESA){
                validas.add(OpcionMenu.APLICARSORPRESA.ordinal());
            }else if(modelo.getEstadoJuego() == EstadoJuego.JA_ENCARCELADO){
                validas.add(OpcionMenu.PASARTURNO.ordinal());
            }else if(modelo.getEstadoJuego() == EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD){
                validas.add(OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD.ordinal());
                validas.add(OpcionMenu.INTENTARSALIRCARCELTIRANDODADO.ordinal());
            }
            validas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
            validas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
            validas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
            validas.add(OpcionMenu.TERMINARJUEGO.ordinal());
        }   
        
        return validas;
    }
    
    public boolean necesitaElegirCasilla(int opcionMenu) {
        OpcionMenu op = OpcionMenu.values()[opcionMenu];
        return op == OpcionMenu.HIPOTECARPROPIEDAD || op == OpcionMenu.CANCELARHIPOTECA || 
               op == OpcionMenu.EDIFICARCASA || op == OpcionMenu.EDIFICARHOTEL ||
               op == OpcionMenu.VENDERPROPIEDAD;
    }
    
    public ArrayList<Integer> obtenerCasillasValidas(int opcionMenu) {
        OpcionMenu op = OpcionMenu.values()[opcionMenu];
        if(op == OpcionMenu.HIPOTECARPROPIEDAD)
            return modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(false);
        else if(op == OpcionMenu.CANCELARHIPOTECA)
            return modelo.obtenerPropiedadesJugadorSegunEstadoHipoteca(true);
        else if(op == OpcionMenu.EDIFICARCASA)
            return modelo.obtenerPropiedadesJugador();
        else if(op == OpcionMenu.EDIFICARHOTEL)
            return modelo.obtenerPropiedadesJugador();
        else if(op == OpcionMenu.VENDERPROPIEDAD)
            return modelo.obtenerPropiedadesJugador();
            
        return null;
    }
    
    public String realizarOperacion(int opcionElegida, int casillaElegida) {
        OpcionMenu op = OpcionMenu.values()[opcionElegida];
        String mensaje = "";
        
        if (op == OpcionMenu.INICIARJUEGO) {
            modelo.inicializarJuego(this.nombreJugadores); 
        } else if (op == OpcionMenu.JUGAR) {
            modelo.jugar();
            mensaje = "El dado ha sido tirado y ha salido un: " + modelo.getValorDado()+ ".\n" + modelo.obtenerCasillaJugadorActual();
        } else if (op == OpcionMenu.APLICARSORPRESA) {
            modelo.aplicarSorpresa();
            mensaje = "Sorpresa aplicada:\n" + modelo.getCartaActual();
        } else if (op == OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD) {
            modelo.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
            if(modelo.getJugadorActual().getEncarcelado()==true)
                mensaje = "No has podido salir de la cárcel.";
        } else if (op == OpcionMenu.INTENTARSALIRCARCELTIRANDODADO) {
            modelo.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
            if(modelo.getJugadorActual().getEncarcelado()==true)
                mensaje = "No se pudo salir de la cárcel.";
        } else if (op == OpcionMenu.COMPRARTITULOPROPIEDAD) {
            modelo.comprarTituloPropiedad();
        } else if (op == OpcionMenu.HIPOTECARPROPIEDAD) {
            modelo.hipotecarPropiedad(casillaElegida);
        } else if (op == OpcionMenu.CANCELARHIPOTECA) {
            modelo.cancelarHipoteca(casillaElegida);
        } else if (op == OpcionMenu.EDIFICARCASA) {
            modelo.edificarCasa(casillaElegida);
        } else if (op == OpcionMenu.EDIFICARHOTEL) {
            modelo.edificarHotel(casillaElegida);
        } else if (op == OpcionMenu.VENDERPROPIEDAD) {
            modelo.venderPropiedad(casillaElegida);
        } else if (op == OpcionMenu.PASARTURNO) {
            modelo.siguienteJugador();
            mensaje = "Ahora es el turno del jugador " + modelo.getJugadorActual().getNombre();
        } else if (op == OpcionMenu.OBTENERRANKING) {
            modelo.obtenerRanking();
        } else if (op == OpcionMenu.TERMINARJUEGO) {
            System.exit(0);
        } else if (op == OpcionMenu.MOSTRARJUGADORACTUAL) {
            mensaje = modelo.getJugadorActual().toString();
        } else if (op == OpcionMenu.MOSTRARJUGADORES) {
            mensaje = modelo.getJugadores().toString();
        } else if (op == OpcionMenu.MOSTRARTABLERO) {
            mensaje = modelo.getTablero().toString();
        }

        return mensaje;
    }

    public static ControladorQytetet getInstance() {
        return instance;
    }
}
