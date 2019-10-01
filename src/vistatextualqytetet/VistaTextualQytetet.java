/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistatextualqytetet;

import java.util.ArrayList;
import java.util.Scanner;
import modeloqytetet.Qytetet;
import controladorqytetet.*;

/**
 *
 * @author Pablo ~(u_u~)
 */
public class VistaTextualQytetet {
    static ControladorQytetet controlador;
    
    static final Scanner in = new Scanner (System.in); 
    
    public VistaTextualQytetet() {
        controlador = ControladorQytetet.getInstance();
    }
    
    public ArrayList<String> obtenerNombreJugadores() {
        System.out.println("Numero de jugadores: ");
        int numJugadores = in.nextInt();
        in.nextLine();
        
        ArrayList<String> nombres = new ArrayList<>();
        
        
        System.out.println("Inserta los nombres: ");
        for(int i=0; i<numJugadores; i++){
            System.out.println("Nombre del jugador " + i + ": ");
            String s = in.nextLine();
            nombres.add(s);
            //System.out.println(nombres);
        }
        
        return nombres;
    }
    
    public int elegirCasilla(int opcionMenu) {
        ArrayList<Integer> casillasValidas = controlador.obtenerCasillasValidas(opcionMenu);
        if(casillasValidas.isEmpty()){
            return -1;
        } else {
            System.out.print("\nIndica la casilla que deseas cambiar: ");
            ArrayList<String> stringValidas = new ArrayList<>();
            for(int i = 0; i < casillasValidas.size(); ++i){
                System.out.print(casillasValidas.get(i) + " ");
                stringValidas.add(Integer.toString(casillasValidas.get(i)));
            }
            return Integer.parseInt(this.leerValorCorrecto(stringValidas));
        }
    }
    
    public String leerValorCorrecto (ArrayList<String> valoresCorrectos) {
        String orden = "";
        boolean correcto = false;
        Scanner sc = new Scanner(System.in);        
        
        while(!correcto){
            System.out.print("\nIntroduce tu orden: ");
            orden = sc.nextLine();
            
            for(int i = 0; i < valoresCorrectos.size() && !correcto; ++i){
                if(orden.equals(valoresCorrectos.get(i)))
                    correcto = true;
            }
            
            if(!correcto)
                System.out.println("Orden no valida, vuelve a intentarlo.");
        }
        
        return orden;
    }
    
    int elegirOperacion() {
        ArrayList<Integer> validas = controlador.obtenerOperacionesJuegoValidas();
        ArrayList<String> stringValidas = new ArrayList<>();
        
        System.out.print("\nÓrdenes: ");
        for(int num: validas){
            System.out.print(OpcionMenu.values()[num] + "(" + num + ")" + " ");
            stringValidas.add(Integer.toString(num));
        }
        
        return Integer.parseInt(this.leerValorCorrecto(stringValidas));
    }
        
    public static void main(String[] args) {
        VistaTextualQytetet ui = new VistaTextualQytetet();
        controlador.setNombreJugadores(ui.obtenerNombreJugadores());
        int operacionElegida, casillaElegida = 0;
        boolean necesitaElegirCasilla;
        do {
            operacionElegida = ui.elegirOperacion();
            necesitaElegirCasilla = ui.controlador.necesitaElegirCasilla(operacionElegida);
            if (necesitaElegirCasilla)
                casillaElegida = ui.elegirCasilla(operacionElegida);
            if (!necesitaElegirCasilla || casillaElegida >= 0)
                System.out.println(ui.controlador.realizarOperacion(operacionElegida, casillaElegida));
        } while (1 == 1);
    }
    
}
