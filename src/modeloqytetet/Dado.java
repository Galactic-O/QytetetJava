/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author Pablo ~(u_u~)
 */
public class Dado {
    private int valor;
    
    private static final Dado instance = new Dado();
    
    private Dado() {}
    
    int tirar() {
        throw new UnsupportedOperationException("Sin implementar");
    }

    public int getValor() {
        return valor;
    }
    
    public static Dado getInstance() {
        return instance;
    }
}
