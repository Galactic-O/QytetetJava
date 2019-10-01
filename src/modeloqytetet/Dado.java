/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.Random;

/**
 *
 * @author Pablo ~(u_u~)
 */
public class Dado {
    private int valor;
    
    private static final Dado instance = new Dado();
    
    private Dado() {}
    
    int tirar() {
        Random r = new Random();
        int val = r.nextInt(5)+1;
        this.valor = val;
        return val;
    }

    public int getValor() {
        return valor;
    }
    
    public static Dado getInstance() {
        return instance;
    }
}
