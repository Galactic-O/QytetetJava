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
public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;

    public Tablero() {
        Inicializar();
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public Casilla getCarcel() {
        return carcel;
    }

    @Override
    public String toString() {
        return "Tablero{" + "casillas=" + casillas + ", carcel=" + carcel + '}';
    }
    
    private void Inicializar() {
        casillas = new ArrayList<>();
        
        this.casillas.add(new Casilla (0,TipoCasilla.SALIDA));
        
        this.casillas.add(new Casilla(1,new TituloPropiedad("Calle Champiñon", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(2,new TituloPropiedad("Barrio Hyrule", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(3,TipoCasilla.SORPRESA));
        this.casillas.add(new Casilla(4,new TituloPropiedad("Dreamland", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(5,new TituloPropiedad("Avenida Alola", 600, 60, (float) 10, 300, 400)));
        
        this.casillas.add(new Casilla(6,TipoCasilla.CARCEL));
        
        this.casillas.add(new Casilla(7,new TituloPropiedad("Barrio SJW", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(8,TipoCasilla.SORPRESA));
        this.casillas.add(new Casilla(9,new TituloPropiedad("Vertedero 4Chan", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(10,new TituloPropiedad("Calle Los Furros", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(11,new TituloPropiedad("Calle DeepWeb", 600, 60, (float) 10, 300, 400)));
        
        this.casillas.add(new Casilla(12,TipoCasilla.PARKING));
        
        this.casillas.add(new Casilla(13,new TituloPropiedad("Avenida Chicle", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(14,new TituloPropiedad("Callejón Galleta", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(15,TipoCasilla.IMPUESTO));
        this.casillas.add(new Casilla(16,new TituloPropiedad("Urbanizacion Bocadillo", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(17,new TituloPropiedad("Hotel Frusfrus", 600, 60, (float) 10, 300, 400)));
        
        this.casillas.add(new Casilla(18,TipoCasilla.JUEZ));
        
        this.casillas.add(new Casilla(19,new TituloPropiedad("Calle Sin Ideas", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(20,new TituloPropiedad("Acera Copiapega", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(21,new TituloPropiedad("Barrio Corregido", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(22,TipoCasilla.SORPRESA));
        this.casillas.add(new Casilla(23,new TituloPropiedad("Calle Homicidio", 600, 60, (float) 10, 300, 400)));
    
        carcel = casillas.get(6);
    }
}
