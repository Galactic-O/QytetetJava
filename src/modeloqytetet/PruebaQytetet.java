/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pvr999
 */
public class PruebaQytetet {
    private static final Scanner in = new Scanner (System.in); 
    
    private static ArrayList getMasQueCero(ArrayList<Sorpresa> mazo){
        
        ArrayList<Sorpresa> nuevo_mazo = new ArrayList<>();
                
        for(int i=0; i<mazo.size(); i++){
            if(mazo.get(i).getValor() > 0){
                nuevo_mazo.add(mazo.get(i));
            }
        }
        
        return nuevo_mazo;
    }
    
    private static ArrayList getIrACasilla(ArrayList<Sorpresa> mazo){
        
        ArrayList<Sorpresa> nuevo_mazo = new ArrayList<>();
                
        for(int i=0; i<mazo.size(); i++){
            if(mazo.get(i).getTipo() == TipoSorpresa.IRACASILLA){
                nuevo_mazo.add(mazo.get(i));
            }
        }
        
        return nuevo_mazo;
    }
    
    private static ArrayList getSorpresa(ArrayList<Sorpresa> mazo, TipoSorpresa tipo){
        ArrayList<Sorpresa> nuevo_mazo = new ArrayList<>();
                
        for(int i=0; i<mazo.size(); i++){
            if(mazo.get(i).getTipo() == tipo){
                nuevo_mazo.add(mazo.get(i));
            }
        }
        
        return nuevo_mazo;
    }
    
    private static ArrayList<String> getNombreJugadores(){
        
        System.out.println("Numero de jugadores: ");
        int numJugadores = in.nextInt();
        in.nextLine();
        
        ArrayList<String> nombres = new ArrayList<>();
        
        System.out.println("Nombre de los jugadores: ");
        for(int i=0; i<numJugadores; i++){
            String s = in.nextLine();
            nombres.add(s);
            System.out.println(nombres);
        }
        
        return nombres;
    }
    
    public static void main(String[] args) {
        Qytetet juego = Qytetet.getInstance();
        juego.inicializarJuego(getNombreJugadores());
        
        System.out.println("Esto es una prueba.\n");
        
        
        /*
        for(int i=0; i<juego.getMazo().size(); i++){
            System.out.println(juego.getMazo().get(i).toString());
        }
        
        System.out.println("Mas que cero");
        ArrayList<Sorpresa> mazo_mas_cero = getMasQueCero(juego.getMazo());
        for(int i=0; i<mazo_mas_cero.size(); i++){
            System.out.println(mazo_mas_cero.get(i).toString());
        }
        
        System.out.println("Ir casilla");
        ArrayList<Sorpresa> mazo_ir_casilla = getIrACasilla(juego.getMazo());
        for(int i=0; i<mazo_ir_casilla.size(); i++){
            System.out.println(mazo_ir_casilla.get(i).toString());
        }
        
        System.out.println("Pagar cobrar");
        ArrayList<Sorpresa> mazo_sorpresa = getSorpresa(juego.getMazo(), TipoSorpresa.IRACASILLA);
        for(int i=0; i<mazo_sorpresa.size(); i++){
            System.out.println(mazo_sorpresa.get(i).toString());
        }
        
        System.out.println(juego.getTablero().toString());
        */
        System.out.println(juego.getJugadores().toString());
    }
}
