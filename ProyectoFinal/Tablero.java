/**
 * La clase Tablero representa un tablero de ajedrez.
 * @author Dylan Juarez.
 * @version 1.0
 */
public class Tablero{
	//fondos.
	public static final String morado = "\033[45;30m";
	public static final String azul = "\033[46;30m";
	public static final String azulFuerte ="\033[44;37m"; 
	public static final String verde ="\033[42;30m";
	public  static final String reset ="\033[0m";
	//atributos. 
	private Piezas[][] tablero;
	private String color;
	

	//Metodos constructores.
	/**
	 * Constructor de un tablero partir de su relleno,color,anchura, altura.
	 * @param ejeX - valor de la anchura.
	 * @param ejeY - valor de la altura.
	 * @param color  - valor del color del tablero.
	 */
	public Tablero(int ejeX, int ejeY, String color){
	   asignarTablero(ejeX,ejeY);	
       asignarColor(color); 
      
	}
	//Metodos de asignacion.
	/**
	 * Metodo para asignar valor al alto, ancho y relleno del tablero.
	 * @param ejeX - valor del eje x.
	 * @param ejeY - valor del eje y.
	 * */
	public void asignarTablero(int ejeX, int ejeY){
	  this.tablero = new Piezas[ejeX][ejeY];	
	  rellenarTablero(this.tablero);
	}

	/**
	 * Metodo para asignar valor al color.
	 * @param color - valor del color.
	 */
	public void asignarColor(String color){
     if(color.equals("morado")){
        this.color = morado;
     }else if(color.equals("azul")){
        this.color = azul;
     }else if(color.equals("azul Marino")){
        this.color = azulFuerte;
     }else if(color.equals("verde")){
        this.color = verde;
     }else{
        this.color = reset;
     }
	  
	}
	

	//Metodos de acceso.
	/**
	 * Metodo para obtener el valor del tablero.
	 * @return char[][] - valor de la matriz.
	 */
	public Piezas[][] obtenerTablero(){
		return this.tablero;
	}
	/**
     * Metodo para obtener el valor del color.
     * @return String - valor del color.
     */
	public String obtenerColor(){
		return this.color;
	}
	

    //Metodo que nos devuelve el tablero.
    /**
     * Metodo que  obtiene el tablero ya creado.
     */
	public void obtenerTableroCompleto(){	  	
	  mostrarMatriz(this.tablero);
	}
	/* Metodo para rellanar el tablero.
     * Se le agrega valor a cada columna y fila del tablero.
	 */
     private  void rellenarTablero(Piezas[][] tablero){
	 for(int i = 0; i<tablero.length; i++){
	 	for(int j = 0; j<tablero[i].length; j++){
	 		tablero[i][j] = new Relleno("Defecto",1);
	 	}
     }
   }

    /* Metodo para mostrar el tablero completo.
     * El color, anchura y altura son agregados al tablero. 
     */
     private  void  mostrarMatriz(Piezas[][] a){
     	 //numeros horizontales.
    	 for(int i = 0; i<a.length; i++){
         if(i == 0){
           System.out.print("                   "+"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m"+ this.color  + " "+ i );
         }
         if(i<10 && i>0){
           System.out.print(this.color +"  "+ i + reset);
         }
         if(i>=10){
           System.out.print(this.color +" "+ i + reset);	
         }

    	 }
    	 System.out.println();
       //Linea superior
            for(int i = 0; i <= ((a.length*3) + 4) - 3; i++) {
            	  if(i == 0){
            	   System.out.print("                    ╔");	
            	  }
                System.out.print("═");
                if(i == ((a.length*3) + 4) - 3){
                 System.out.print("╗" + " "+"\033[45;30m"+"\033[37m"+" F " +"\033[0m"+"\033[0m");
                }
            }
            System.out.println();
           
            //centro de la forma
            for(int i = 0; i <= a.length-1; i++) {
                System.out.print("                    ║" + " ");
                for(int j = 0; j <= a.length-1; j++) {
                  if(j >= 0 && i >= 0 && j <=a.length && i<=a.length){
                  	 
                  	 if(j%2 == 0 && i%2==0 || j%2 != 0 && i%2 != 0){
                       System.out.print("\033[42;30m"+ "\u001B[30m"  + " "+"\033[32m"+a[i][j].obtenerPieza()+ " " + "\u001B[0m"+ "\033[42;30m" ); // blanca.  

                  	 }else{
                  	   System.out.print("\033[43;30m" + "\u001B[37m" + " " +"\033[33m"+a[i][j].obtenerPieza()+ " "  + "\u001B[0m"+ "\033[42;30m"); // negra.
                     }  


                  } 

                }
                System.out.println(reset + " " +"║" + " " + this.color + " "+ i+ " " + reset);
                
            }
            //Linea inferior
            for(int i = 0; i <= ((a.length*3) + 4) - 3; i++) {
            	  if(i == 0){
            	   System.out.print("                    ╚");	
            	  }
                System.out.print("═");
                if(i == ((a.length*3) + 4) - 3){
                 System.out.print("╝");
                }
            }
    
          

    }



   //Metodo Para dibujar en el tablero.
   /**
    * Metodo para dibujar algo en una coordena determinada.
    * @param posicionX - valor en el ejeX.
    * @param posicionY - valor en el ejeY.
    * @param simbolo - simbolo a dibujar.
    */
    public void dibujar(int posicionX,int posicionY, Piezas pieza){
      for(int i = 0; i<obtenerTablero().length;i++){
      	for(int j = 0; j<obtenerTablero()[i].length; j++){
      	  if(i == posicionX && j == posicionY){
      	  	obtenerTablero()[i][j] = pieza; 
      	  }	
      	}
      }
    }
   
    //Metodo para verificar dibujo.
    /**
     * Metodo para verificar si en la coordena  del tablero no existe alguno otro dibujo.
     * @param posicionX - valor de la coordenada en x.
     * @param posicionY - valor de la coordenada en y.
     * @return boolean - valor de verdad. 
     */
    public boolean valorPosicion(int posicionX, int posicionY){
       if(!(obtenerTablero()[posicionX][posicionY].obtenerPieza() == ".")){
       	  return true;
       }else{
       	  return false;
       }	
    }

    /**
     * Metodo para verificar si un objeto  esta en alguna coordenada X y Y.
     * @param posicionX - valor de la posicion X.
     * @param posicionY - valor de la posicion Y.
     * @param pieza - objeto a buscar en las coordenadas.
     * @return boolean -  valor de verdad en caso de que exista dicho objeto en las coordenadas.
     */
    public boolean valorPosicionPieza(int posicionX, int posicionY, Piezas pieza){
      if(obtenerTablero()[posicionX][posicionY].obtenerPieza().equals(pieza.obtenerPieza()) && obtenerTablero()[posicionX][posicionY].obtenerNumeroPieza() == pieza.obtenerNumeroPieza()){
          return true;
      }else{
          return false;
      }
    }

    //Metodo para borrar un valor dibujado.
    /**
     * Metodo para quitar un caracter dibujado.
     * @param posicionX - valor en la coordena en X.
     * @param posicionY - valor en la coordena en Y.
     */
    public void eliminar(int posicionX, int posicionY){
       obtenerTablero()[posicionX][posicionY] = new Relleno("Defecto",2);
    }
    
    //Metodo que obtiene las coordenas de un dibujo.
    /**
     * Metodo que obtiene la coordenada en el ejeX.
     * @param  pieza - valor de la  pieza a buscar.
     * @param  numeroPieza - valor del numero  de la pieza.
     * @return int - valor de la coordenada en X.
     * @return int - valor de -1 por si el elemento no esta en el tablero.
     */
    public int obtenerCoordenadaX(Piezas pieza){
      for(int i = 0; i<obtenerTablero().length; i++){
      	for(int j = 0; j<obtenerTablero()[i].length; j++){
            Piezas piezaComparar2 = obtenerTablero()[i][j];
      		if(obtenerTablero()[i][j].obtenerPieza().equals(pieza.obtenerPieza()) && pieza.obtenerNumeroPieza() == obtenerTablero()[i][j].obtenerNumeroPieza()){
      			return i;  
      		}
      	}
      }
       
      return -1; 

    }
    /**
     * Metodo para que obtiene la coordenada en el ejeY.
     * @param  pieza - valor de la  pieza a buscar.
     * @param  numeroPieza - valor del numero  de la pieza.
     * @return int - posicion en el eje Y.
     * @return int - valor de -1 por si el elemento no esta en el tablero.
     */
    public int obtenerCoordenadaY(Piezas pieza){
      Piezas piezaComparar = pieza;  
      for(int i = 0; i<obtenerTablero().length; i++){
        for(int j = 0; j<obtenerTablero()[i].length; j++){
            if(obtenerTablero()[i][j].obtenerPieza().equals(pieza.obtenerPieza()) && pieza.obtenerNumeroPieza() == obtenerTablero()[i][j].obtenerNumeroPieza()){
                return j;
            }
        }
      }
       return  -1;
    }

   /**
    * Metodo para obtener un objeto de la clase Piezas apartir de sus coordenadas.
    * @param posicionX - valor de la posicion X.
    * @param posicionY - valor de la posicion Y.
    * @return Piezas - objeto de la clase  Piezas.
    * @return Piezas - en caso de no existir el objeto devolvera un objeto de la Clase Relleno.
    */
    public Piezas obtenerReferenciaObjeto(int posicionX, int posicionY){
     
      for(int i = 0; i<obtenerTablero().length; i++){
        for(int j = 0; j<obtenerTablero()[i].length; j++){
          if(obtenerTablero()[i][j].obtenerPieza().equals(obtenerTablero()[posicionX][posicionY].obtenerPieza()) && obtenerTablero()[i][j].obtenerNumeroPieza() == obtenerTablero()[posicionX][posicionY].obtenerNumeroPieza()){
              return obtenerTablero()[i][j];
          }

        }
      }
      return new Relleno("Defecto", 0);
    }

}















