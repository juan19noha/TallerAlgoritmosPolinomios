package tallerpolinomios;


public class Nodo {
    
    private int coef;
    private int exp;
    private Nodo liga;

    public Nodo(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        liga = null;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
    
    
}
