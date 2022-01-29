/**
 * La clase caballos representa un cabello en el tablero de ajedrez.
 * @author Dylan Juarez.
 * @version 1.0
 */
public class Caballos extends Piezas{
	//atributo.
	private char forma = 'C';
	//Metodos Constructores.
	/**
	 * Constructor de un Caballo apartir de su color.
	 * @param color - valor del color del caballo.
	 * @param numeroPieza - valor del numero de  pieza.
	 */
	public Caballos(String color, int numeroPieza){
      super(color,numeroPieza);
      asignarColor(color);
      asignarNumeroPieza(numeroPieza);
	}

	/**
	 * Metodo para obtener la forma del Caballo.
	 * @return String - valor de la forma del Caballo.
	 */
	@Override
	public String obtenerPieza(){
	  return obtenerColor() + this.forma;
	
	}

	//Metodo que mueve la pieza.
	/**
	 * Metodo que mueve la pieza.
	 * @param tipo - tipo de pieza(Peones).
	 * @param tablero - tablero.
	 * @param posicionX - valor de la posicion en el eje X.
	 * @param posicionY - valor de la posicion en el eje Y.
     * @throws movimientoInvalido - si la pieza realiza un movimiento no permitido.
	 * @throws LimitesTablero - si la pieza realiza un movimiento en ejes coordenados no permitidos.
	 */
	@Override
	public void movimientoPieza(Tablero tablero, int posicionX, int posicionY)throws movimientoInvalido, LimitesTablero{
		//Exceptiones LimitesTablero.
		//Si la posicion de las coordenadas elegidas exceden los limites del tablero.
		if(posicionX >= tablero.obtenerTablero().length || posicionY >= tablero.obtenerTablero().length){
		   throw new LimitesTablero("valor de coordenadas invalido!!");
		}
		//Si las coordenas son negativas.
		if(posicionX < 0 || posicionY < 0){
           throw new LimitesTablero("No puedes ingresar numeros negativos!!"); 
		}
		//Exceptiones movimientoInvalido.
		//Si no se mueve la pieza.
		if(posicionX == tablero.obtenerCoordenadaX(this) && posicionY == tablero.obtenerCoordenadaY(this)){
          throw new movimientoInvalido("debes mover la pieza!!");
		}

		//Si el caballo desea moverse a una posicion donde existe un pieza de su mismo color.
		if(tablero.valorPosicion(posicionX,posicionY) && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals(tablero.obtenerReferenciaObjeto(posicionX,posicionY).obtenerColor())){
         throw new movimientoInvalido("Existe una pieza de tu miso color en las coordenadas donde deseas mover el caballo!!");
	    }
        

    if(!(posicionX > tablero.obtenerCoordenadaX(this)) && !(tablero.obtenerCoordenadaX(this) > posicionX) ){
       throw new movimientoInvalido("El caballo no puede realizar ese movimiento!!Y");
    }

		//Avanze piezas blancas.
        if(tablero.obtenerCoordenadaY(this) >= 0 && tablero.obtenerCoordenadaY(this) <=1  && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && posicionX > tablero.obtenerCoordenadaX(this)){
         if(!(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)+2 == posicionY) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this)+2 == posicionX)&& !(tablero.obtenerCoordenadaY(this)-1 == posicionY && tablero.obtenerCoordenadaX(this)+2 == posicionX)){
          throw new movimientoInvalido("El caballo no puede realizar ese moviento3!!");
         }
        }


         
        if(tablero.obtenerCoordenadaY(this) >=4 && tablero.obtenerCoordenadaY(this) <=5 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && posicionX > tablero.obtenerCoordenadaX(this)){ 
         if(!(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)-2 == posicionY) && !(tablero.obtenerCoordenadaX(this)+2 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)&& !(tablero.obtenerCoordenadaX(this)+2 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY)){
          throw new movimientoInvalido("El caballo no puede realizar ese movientos4!!");
         }
        }


        if(tablero.obtenerCoordenadaY(this) >=2 &&tablero.obtenerCoordenadaY(this) <= 3 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && posicionX > tablero.obtenerCoordenadaX(this)){     
           if(!(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)-2 == posicionY) && !(tablero.obtenerCoordenadaX(this)+2 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)  && !(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)+2 == posicionY) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this)+2 == posicionX)){
           throw new movimientoInvalido("El caballo no puede realizar ese moviento5!!");
           }

        }



        //Avance piezas negras.
        if( tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaY(this) >= 0 && tablero.obtenerCoordenadaY(this) <= 1  &&  tablero.obtenerCoordenadaX(this) > posicionX){
          if(!(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)+2 == posicionY) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this)-2 == posicionX) && !(tablero.obtenerCoordenadaY(this)-1 == posicionY && tablero.obtenerCoordenadaX(this)-2 == posicionX)){
           	 throw new  movimientoInvalido("El caballo no puede realizar ese movimiento!!");	
          }	
        }


        if(tablero.obtenerCoordenadaY(this) >=4 && tablero.obtenerCoordenadaY(this) <=5 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") &&  tablero.obtenerCoordenadaX(this) > posicionX){ 
         if(!(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-2 == posicionY) && !(tablero.obtenerCoordenadaX(this)-2 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY) && !(tablero.obtenerCoordenadaX(this)-2 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY)){
          throw new movimientoInvalido("El caballo no puede realizar ese moviento!!");
         }
        }


        if(tablero.obtenerCoordenadaY(this) >=2 && tablero.obtenerCoordenadaY(this) <= 3 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaX(this) > posicionX ){     
           if(!(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)+2 == posicionY) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this)-2 == posicionX) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-2 == posicionY) && !(tablero.obtenerCoordenadaX(this)-2 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)){
            throw new movimientoInvalido("El caballo no puede realizar ese movientoz");
           }

        }








        //Retroceso piezas blancas.
        if(tablero.obtenerCoordenadaX(this) >=1 && tablero.obtenerCoordenadaX(this) <= 4 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && tablero.obtenerCoordenadaX(this) > posicionX){
           if(!(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)+2 == posicionY) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this)-2 == posicionX) && !(tablero.obtenerCoordenadaY(this)-1 == posicionY && tablero.obtenerCoordenadaX(this)-2 == posicionX)){
             throw new  movimientoInvalido("El caballo no puede realizar ese movimiento!!");  
           } 
         }


        if(tablero.obtenerCoordenadaY(this) >=4 && tablero.obtenerCoordenadaY(this) <=5 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") &&  tablero.obtenerCoordenadaX(this) > posicionX){ 
         if(!(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-2 == posicionY) && !(tablero.obtenerCoordenadaX(this)-2 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY) && !(tablero.obtenerCoordenadaX(this)-2 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY)){
          throw new movimientoInvalido("El caballo no puede realizar ese moviento!!");
         }
        }


        if(tablero.obtenerCoordenadaY(this) >=2 && tablero.obtenerCoordenadaY(this) <= 3 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaX(this) > posicionX ){     
           if(!(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)+2 == posicionY) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this)-2 == posicionX) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-2 == posicionY) && !(tablero.obtenerCoordenadaX(this)-2 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)){
            throw new movimientoInvalido("El caballo no puede realizar ese moviento");
           }
        

        }




        //Retroceso piezas negras.
        if(tablero.obtenerCoordenadaX(this) >=1 && tablero.obtenerCoordenadaX(this) <= 4 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && posicionX > tablero.obtenerCoordenadaX(this)){
         if(!(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)+2 == posicionY) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this)+2 == posicionX)&& !(tablero.obtenerCoordenadaY(this)-1 == posicionY && tablero.obtenerCoordenadaX(this)+2 == posicionX)){
          throw new movimientoInvalido("El caballo no puede realizar ese moviento!!");
         }
        }


         
        if(tablero.obtenerCoordenadaY(this) >=4 && tablero.obtenerCoordenadaY(this) <=5 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && posicionX > tablero.obtenerCoordenadaX(this)){ 
         if(!(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)-2 == posicionY) && !(tablero.obtenerCoordenadaX(this)+2 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)&& !(tablero.obtenerCoordenadaX(this)+2 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY)){
          throw new movimientoInvalido("El caballo no puede realizar ese movientos!!");
         }
        }


        if(tablero.obtenerCoordenadaY(this) >=2 &&tablero.obtenerCoordenadaY(this) <= 3 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && posicionX > tablero.obtenerCoordenadaX(this)){     
           if(!(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)-2 == posicionY) && !(tablero.obtenerCoordenadaX(this)+2 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)  && !(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)+2 == posicionY) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this)+2 == posicionX)){
           throw new movimientoInvalido("El caballo no puede realizar ese moviento!!");
           }


        }
        
       //Dibujamos el caballo en el tablero.
	   tablero.eliminar(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this));
	   tablero.dibujar(posicionX,posicionY, this);	

	}

	/**
     * Metodo para que una pieza elimine a otra.
     * @param tablero - tablero.
     * @param posicionX - valor de la posicion en el eje x de la pieza a eliminar.
     * @param posicionY - valor de la posicion en el eje y de la pieza a eliminar.
     * @throws EliminacionInvalida - si la pieza desea realizar una eliminacion no permitida. 
     */ 
    @Override
	public void eliminacionPieza(Tablero tablero, int posicionX, int posicionY)throws EliminacionInvalida{ }


}