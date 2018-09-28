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
public class PruebaQytetet {
    
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
    
    public static void main(String[] args) {
        
        Qytetet juego = new Qytetet();

        juego.inicializarCartasSorpresa();

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
        ArrayList<Sorpresa> mazo_sorpresa = getSorpresa(juego.getMazo(), TipoSorpresa.PAGARCOBRAR);
        for(int i=0; i<mazo_sorpresa.size(); i++){
            System.out.println(mazo_sorpresa.get(i).toString());
        }
       
    }
    
}
