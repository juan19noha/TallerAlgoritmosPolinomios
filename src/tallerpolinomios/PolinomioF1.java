package tallerpolinomios;


public class PolinomioF1 {
    
   private int grado;
   private int polinomio[];
    
   public PolinomioF1(){
       
        grado = -1;
        polinomio = new int [grado+2];
        polinomio [0] = grado;
    
   }
   public void insertarTermino(int coef,int exp){
       if(exp > grado){//si el exponente es mayor que el grado actual
            polinomio = redimensionar(true,exp);// llama al metodo redimensionar para a umentar el tamaño del arreglo
            polinomio [0] = exp;//establece el nuevo grado 
            polinomio [1] = coef;//almacena el coeficiente 
            grado = exp;  //actualiza el grado del polinmio 
        }else if(exp == grado){
            if(coef + polinomio[1] == 0){//si la suma del coeficiente ingresado y el coeficiente actual es cero se elimina el termino
                polinomio = redimensionar(false,coef); // llama al redimensionar y reduce el tamaño del polinomio
            }else{//si no e scero se suma el coeficiente al existente
                polinomio [1] += coef;
            }
        }else{//si el exponente es menor que el grado
            polinomio[grado+1-exp] += coef;//suma el coeficiente al existente en la piscion 1
        }
   }
   public int[] redimensionar(boolean bandera,int exp){
       int []aux;
        //crecer
        if(bandera){//si se esta aumentando el tamaño
            aux = new int[exp + 2];//crea un nuevo arreglo con el nuevo tamaño
            aux = pasarDatos(1,aux,exp);//copia los datos del polinomio existente a aux
            return aux; //devuelve el nuevo arreglo
        //decrecer
        }else{
            grado = decrecer();//llama al metodo decrecer para actualizar el grado
            aux = new int[grado+2];
            if(grado != -1){//si el grado no es -1,copia todos los datos del polinomio existente a aux
                aux = pasarDatos(polinomio.length-1-grado,aux);
            }
            aux[0] = grado;//almacena el nuevo grado 
            return aux;
        }
    }
    public int decrecer(){
        for (int i = 2; i < polinomio.length; i++) {//recorre el arreglo desde el indice 2
            if(polinomio[i] != 0){//si encientra un coeficiente diferente de cero 
                return(polinomio.length-1-i); //retorna el nuevo grado
            }
        }
        return -1;//si no e
       
   }
    public int[] pasarDatos(int pos,int[]aux){
        int j= aux.length-1;//inicializa j en el ultimo indice de aux
        for (int i = polinomio.length-1; i >= pos; i--) {//recorre el  polinoio desde el grado hacia abajo
            aux[j]= polinomio[i];//copia el valor a aux
            j--;  //decrementa j 
        }
        return aux;
        
    }
    public int[] pasarDatos (int pos, int[]aux, int exp){
         for (int i = pos; i < polinomio.length; i++) {//recorre el arreglo polinomio desde pos hasta el final
            aux [i+exp-grado] = polinomio[i]; //copia los valores de polinomio a aux
        }
        return aux;
    }
    public String mostrar(){
        String pol = " | ";//inicializa una cadena pol con un separador para mostrar el polinomio
        for (int i = 0; i < polinomio.length; i++) {
            pol += polinomio[i] +" | ";//agrega cada coeficiente a la cadena pol
            
        }
        return pol;
    }
    public PolinomioF1 sumar(PolinomioF1 b){
        PolinomioF1 suma = new PolinomioF1();//se crea un nuevo poliomio para la suma
        
        suma.polinomio = polinomio.clone();//clona el polinomio actual
        suma.grado = grado;//establece el grado de la suma
        
        for (int i = 1; i < b.grado+2; i++) {
            if (b.polinomio[i] != 0) {//si el coeficiente es diferente de cero
                suma.insertarTermino(b.polinomio[i],b.grado+1-i);//inserta el termino en la suma
                
            }
            
        }
        return suma;//d
        
    }
     public PolinomioF1 multiplicar(PolinomioF1 b){
         PolinomioF1  multiplicar = new PolinomioF1();
        
        int coef, exp;
        for (int i = 1; i < grado+2; i++) {
            for (int j = 1; j < b.grado+2; j++) {
                coef = polinomio[i]*b.polinomio[j];//multiplica coeficiente
                exp = (grado+1-i)+(b.grado+1-j);//suma los exponentes
                multiplicar.insertarTermino(coef, exp);//inserta el termino en el polinomio multiplicado
            }
            
        }
        return multiplicar;
     }
   public PolinomioF2 convertirA_F2() {
        PolinomioF2 polF2 = new PolinomioF2();
        for (int i = 1; i < polinomio.length; i++) {
            if (polinomio[i] != 0) {
                Termino t = new Termino(polinomio[i],grado + 1 - i);
                polF2.insertarTermino(t);
            }
        }
        return polF2;
    }

    public PolinomioF3 convertirA_F3() {
        PolinomioF3 polF3 = new PolinomioF3();
        for (int i = 1; i < polinomio.length; i++) {
            if (polinomio[i] != 0) {
                Nodo nodo = new Nodo(polinomio[i], grado + 1 - i);
                polF3.insertarDesendente(nodo);
            }
        }
        return polF3;
    }

}

