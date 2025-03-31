package tallerpolinomios;


public class PolinomioF3 {
    private Nodo punta;
    
    public PolinomioF3(){
        punta = null;
    }
    public void insertarDesendente(Nodo n) {//ingresando nodo de forma descendente
        Nodo p,ant;
        p = punta;
        ant = null;
        
        if (p == null || n.getExp() > punta.getExp()) {//si la lista esta vacia o el nuevo nodo tiene un exponente mayor que el primero
            n.setLiga(punta);//el nuevo nodo apuntara hacia el antiguo primer nodo
            punta = n;//la punta ahora es el nuevo nodo
            return;
        }
        //busca la posicion en dodne insertar el nuevo nodo
        while (p != null && n.getExp() < p.getExp()) {
            ant = p;//guarda el nodo actual como anterior
            p = p.getLiga();//y avana al siguiente nodo
        }
       
        if (p == null || n.getExp() != p.getExp()) {
            ant.setLiga(n);
            n.setLiga(p);
        }else{
           
            if ( n.getCoef()  +   p.getCoef() != 0) {
               p.setCoef(n.getCoef()  +   p.getCoef());
                
            }else{
                eliminar(p,ant);
            }
        }        
    
}
    public void eliminar(Nodo p, Nodo ant){
     
            if(p == punta){
                punta = p.getLiga();
            }else{
              ant.setLiga(p.getLiga());
            }
             p.setLiga( null);

        
    }
    public PolinomioF3 sumar(PolinomioF3 b){
         PolinomioF3 suma = new PolinomioF3();
         Nodo PolinomioA = this.punta;
         Nodo PolinomioB = b.punta;
         
         while(PolinomioA != null || PolinomioB != null){
             if (PolinomioA != null && (PolinomioB == null || PolinomioA.getExp() > PolinomioB.getExp())) {
                 suma.insertarDesendente(new Nodo(PolinomioA.getCoef(),PolinomioA.getExp()));
                 PolinomioA = PolinomioA.getLiga();
             }else if(PolinomioB != null && (PolinomioA == null || PolinomioA.getExp() < PolinomioB.getExp())){
                 suma.insertarDesendente(new Nodo(PolinomioB.getCoef(),PolinomioB.getExp()));
                 PolinomioB = PolinomioB.getLiga();
             }else{
                 int coef = PolinomioA.getCoef() + PolinomioB.getCoef();
                 if(coef != 0){
                     suma.insertarDesendente(new Nodo(coef,PolinomioA.getExp()));
                 }
                 PolinomioA = PolinomioA.getLiga();
                 PolinomioB = PolinomioB.getLiga();
             }
        }
         return suma;
    }
    public PolinomioF3 multiplicar(PolinomioF3 b) {
    PolinomioF3 multi = new PolinomioF3(); 
    Nodo PolinomioA = this.punta; 
    int coef,exp;
    
    while (PolinomioA != null) {
        Nodo PolinomioB = b.punta; 
      
        while (PolinomioB != null) {
            coef = PolinomioA.getCoef() * PolinomioB.getCoef(); 
             exp = PolinomioA.getExp() + PolinomioB.getExp(); 
            multi.insertarDesendente(new Nodo(coef, exp)); 
            PolinomioB = PolinomioB.getLiga(); 
        }
        PolinomioA = PolinomioA.getLiga(); 
    }
    return multi; 
}
    public String mostrar() {
        String lista = "";

        Nodo p = punta;
        while (p != null) {
            lista += "|Coef " + p.getCoef() + " | Exp: "+ p.getExp()+ "| ->";
            p = p.getLiga();
        }
        lista += "null";
        return lista;
    }
     public PolinomioF1 convertirA_F1() {
        PolinomioF1 polF1 = new PolinomioF1();
        Nodo p = punta;
        while (p != null) {
            polF1.insertarTermino(p.getCoef(), p.getExp());
            p = p.getLiga();
        }
        return polF1;
    }

    public PolinomioF2 convertirA_F2() {
        PolinomioF2 polF2 = new PolinomioF2();
        Nodo p = punta;
        while (p != null) {
            Termino t = new Termino(p.getExp(), p.getCoef());
            polF2.insertarTermino(t);
            p = p.getLiga();
        }
        return polF2;
    }
   public PolinomioF1 derivar() {
        PolinomioF1 derivada = new PolinomioF1();
        Nodo p = punta;
        while (p != null) {
            if (p.getExp() != 0) {
                derivada.insertarTermino(p.getCoef() * p.getExp(), p.getExp() - 1);
            }
            p = p.getLiga();
        }
        return derivada;
    }
   public PolinomioF1 multiplicar(PolinomioF2 b) { 
        return this.multiplicar(b.convertirA_F3()).convertirA_F1(); 
    } 
}
