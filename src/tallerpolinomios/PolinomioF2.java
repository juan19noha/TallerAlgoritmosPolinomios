package tallerpolinomios;

import java.util.Arrays;
import java.util.Comparator;

public class PolinomioF2 {
    
    private Termino[] polinomio;
    
    public PolinomioF2(){
        polinomio = new Termino[1];//inicializa el arreglo con tamaño de 1
        polinomio[0] = new Termino(0,0);
    }
    public void insertarTermino(Termino t){
       
       int pos;
       //validar= si el polinomio esta vacio+
       if (polinomio[0].getCoef() == 0) {
           polinomio[0] = t; 
           //el polinomio no esta avcio
        }else{
           pos = buscar(t.getExp());//busca la posicion del exponente del polinomio
           
           //existe el exp
           if (pos != -1) {
               if (t.getCoef()+polinomio[pos].getCoef() != 0) {//si la suma de coeficiente no es cero, se actualiza el coeficiente
                   polinomio[pos].setCoef(t.getCoef()+polinomio[pos].getCoef()); //se suma el coeficiente existente con el nuevo
           }else{
               polinomio = redimensionar(pos);//elimina el termino si la suma da cero
           }
       }else{
               polinomio = redimensionar(t);//si el exponente no existe se redimenciona para agregar un nuevo termino
           }
       }
}
public PolinomioF2 sumar(PolinomioF2 b){
     PolinomioF2 suma = new PolinomioF2();
     suma.polinomio = polinomio.clone();//clona el polinomio actual para la suma
     
    for (int i = 0; i < b.polinomio.length; i++) {
         suma.insertarTermino(b.polinomio[i]);//inserta cada termino del polinomio b en el polinomio suma
     }
     return suma;
 }  
public PolinomioF2 multiplicar(PolinomioF2 b){
     PolinomioF2 mult = new PolinomioF2();
     int coef,exp;
     
     for (int i = 0; i < polinomio.length; i++) {
       for (int j = 0; j < b.polinomio.length; j++) {
         coef = polinomio[i].getCoef() * b.polinomio[j].getCoef();//multiplica los coeficientes de los terminos
         exp = polinomio[i].getExp() + b.polinomio[j].getExp();//suma los exponentes de los terminos
         mult.insertarTermino(new Termino(coef,exp));//inserta el nuevo termini resultante de la multiplicacion
       } 
    }
    return mult;
 }  
public Termino[] redimensionar(Termino t){
       Termino[] aux = Arrays.copyOf(polinomio,polinomio.length+1);//aumenta el tamaño del arreglo  en 1
       aux[aux.length-1] = t;//agrega el nuevo termino al final del arrglo
       //aux = ordenar(aux); metodo de ordenamiento,METODO SORT
       Arrays.sort(aux,Comparator.comparingInt(Termino :: getExp).reversed());//ordena los terminos por exponente en orden ascendente
       return aux;
    }
public Termino[] redimensionar(int pos){
       Termino[] aux;
       //si hay mas de un termino en el polinomio
       if (polinomio.length > 1) {
           aux = new Termino[polinomio.length -1];//crea un nuevo arreglo con un tamaño menor
           int j = 0;
           for (int i = 0; i < polinomio.length; i++) {
               //si no es el termino que se quiere eliminar
               if (i != pos) {
                   aux [j] = polinomio[i];//copia el termino al nuevo arreglo
                   j++;  //incrementa el indice 
               } 
           }   
       }else{
           //si solo hay untermino, crea un nuevo arreglo vacio
           aux = new Termino[1];
           aux [0] = new Termino(0,0);
       }
       return aux;
   }
 public int  buscar(int exp){
        int i=0;
     //inetras haya un termino en el polinomio
        while(i < polinomio.length){
            //si el exponente es mayor o igual al exponente del termino actual
            if (exp >= polinomio[i].getExp()) {
                break;//7encuentra la posicion correcta para el exponente
                
            }
            i++;
        }
        if (i < polinomio.length) {
            //si el exponente buscado es igual con el exponente del termino actual
            if (exp == polinomio[i].getExp()) {
                return i;//retorna la posicion del exponente  si ya existe
                
            }
           
       }
        return -1;//si el exponente no se encuentra
            
   }
 public String mostrar(){
       String pol = "|";
       for (int i = 0; i < polinomio.length ; i++) {
           pol +=  "coef: " + polinomio[i].getCoef() 
                   + "exp:"+ polinomio[i].getExp() + "|";
       }
       return pol;
   }
  public PolinomioF1 convertirA_F1() {
        PolinomioF1 polF1 = new PolinomioF1();
        for (int i = 0; i < polinomio.length; i++) {
            polF1.insertarTermino(polinomio[i].getCoef(), polinomio[i].getExp());
        }
        return polF1;
    }
    // Conversión de PolF2 a PolF3

    public PolinomioF3 convertirA_F3() {
        PolinomioF3 polF3 = new PolinomioF3();
        for (int i = 0; i < polinomio.length; i++) {
            Nodo nodo = new Nodo(polinomio[i].getCoef(), polinomio[i].getExp());
            polF3.insertarDesendente(nodo);
        }
        return polF3;
    }
    public boolean esSimetrico() {
    for (Termino termino : polinomio) {
        if (termino.getExp() % 2 != 0 && termino.getCoef() != 0) {
            return false;
        }
    }
    return true;
    } 
   
}
