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
    
    private ArrayList<Sorpresa> mazo = new ArrayList<>();
    
    public ArrayList getMazo(){
        return this.mazo;
    }
    
    public void inicializarCartasSorpresa(){
        this.mazo.add(new Sorpresa ("Sube el bitcoin. Ganas 100 euros.", 1, TipoSorpresa.PAGARCOBRAR));
        this.mazo.add(new Sorpresa ("Tienes tanta hambre que te comes tu billete de 200 euros. Ups.", 2, TipoSorpresa.PAGARCOBRAR));
        this.mazo.add(new Sorpresa ("Día de la marmota. Vuelve a la salida.", 3, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Tienes que comprar tomates en el Mercadona. Ve al Parking.", 4, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Te han pillado haciendo el dab en público, das "
                + "tanto cringe que te meten en la cárcel.", 5, TipoSorpresa.IRACASILLA));
        this.mazo.add(new Sorpresa ("Tus casas están infestadas de abejas. Pagas 50 euros por cada casa u hotel.", 6, TipoSorpresa.PORCASAHOTEL));
        this.mazo.add(new Sorpresa ("Explota la burbuja, inundando tus propiedades. Ahora son spas. Ganas 50 por cada casa u hotel.", 7, TipoSorpresa.PORCASAHOTEL));
        this.mazo.add(new Sorpresa ("Los otros jugadores te confunden con una máquina expendedora pr culpa de las drogas."
                + " Te roban 8,5789 euros cada uno.", 8, TipoSorpresa.PORJUGADOR));
        this.mazo.add(new Sorpresa ("Compras un aspirador mu tocho. Le robas 9 euros a cada jugador.", 9, TipoSorpresa.PORJUGADOR));
        this.mazo.add(new Sorpresa ("Practicas tus mortales hacia atrás hasta que puedes saltar muros. Sales de la cárcel.", 10, TipoSorpresa.SALIRCARCEL));
    }
}

