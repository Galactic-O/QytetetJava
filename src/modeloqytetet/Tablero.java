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
    static int NUM_CASILLAS = 23;

    Tablero() {
        inicializar();
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
    
    private void inicializar() {
        casillas = new ArrayList<>();
        
        this.casillas.add(new Casilla (0,TipoCasilla.SALIDA));
        
        this.casillas.add(new Casilla(1,new TituloPropiedad("Calle Champiñon", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(2,new TituloPropiedad("Barrio Hyrule", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(3,TipoCasilla.SORPRESA));
        this.casillas.add(new Casilla(4,new TituloPropiedad("Avenida Alola", 600, 60, (float) 10, 300, 400)));
        
        this.casillas.add(new Casilla(5,TipoCasilla.CARCEL));
        
        this.casillas.add(new Casilla(6,new TituloPropiedad("Calle Inalámbrica", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(7,TipoCasilla.SORPRESA));
        this.casillas.add(new Casilla(8,new TituloPropiedad("Vertedero Ruby", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(9,new TituloPropiedad("Callejón DeepWeb", 600, 60, (float) 10, 300, 400)));
        
        this.casillas.add(new Casilla(10,TipoCasilla.PARKING));
        
        this.casillas.add(new Casilla(11,new TituloPropiedad("Avenida Chicle", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(12,TipoCasilla.IMPUESTO));
        this.casillas.add(new Casilla(13,new TituloPropiedad("Urbanizacion Bocadillo", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(14,new TituloPropiedad("Hotel Frusfrus", 600, 60, (float) 10, 300, 400)));
        
        this.casillas.add(new Casilla(15,TipoCasilla.JUEZ));
        
        this.casillas.add(new Casilla(16,new TituloPropiedad("Calle Sin Ideas", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(17,new TituloPropiedad("Acera Copiapega", 600, 60, (float) 10, 300, 400)));
        this.casillas.add(new Casilla(18,TipoCasilla.SORPRESA));
        this.casillas.add(new Casilla(19,new TituloPropiedad("Calle Homicidio", 600, 60, (float) 10, 300, 400)));
    
        carcel = casillas.get(6);
    }
    
    Casilla obtenerCasillaFinal(Casilla casilla, int desplazamiento) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    Casilla obtenerCasillaNumero(int NumeroCasilla) {
        throw new UnsupportedOperationException("Sin implementar");
    }
    
    @Override
    public String toString() {
        return "---TABLERO---" + "\n-Casillas-\n" + casillas + "\n-Carcel-\n" + carcel;
    }
}
