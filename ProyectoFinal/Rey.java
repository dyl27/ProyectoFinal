/**
 * Rey representa un rey en el juego de ajedrez.
 * @author Dylan Juarez.
 * @version 1.0
 */
public class Rey extends Piezas{
	//atributo.
	private char forma = 'R';
	//Metodos Constructores.
	/**
	 * Constructor de un rey apartir de su color.
	 * @param color - valor del color del rey.
	 * @param numeroPieza - valor del numero de pieza.
	 */
	public Rey(String color, int numeroPieza){
      super(color,numeroPieza);
      asignarColor(color);
      asignarNumeroPieza(numeroPieza);
	}

	//Metodos de acceso.
	/**
	 * Metodo para obtener la forma del rey.
	 * @return String - valor de la forma del rey.
	 */
	@Override
	public String obtenerPieza(){
		return obtenerColor() + this.forma ;
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
		//Si existe una pieza  del mismo color en la casilla donde deseamos mover a nuestra Torre no podra moverse.
	   if(tablero.valorPosicion(posicionX,posicionY) && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals(tablero.obtenerReferenciaObjeto(posicionX,posicionY).obtenerColor())){
         throw new movimientoInvalido("Existe una pieza de tu miso color en las coordenadas donde deseas mover al Rey!!");
	   }
	   

        //Restricciones Rey blanco.
	    //restriccion en la parte superior del  tablero.
        if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && tablero.obtenerCoordenadaX(this) == 0 && tablero.obtenerCoordenadaY(this) > 0 && tablero.obtenerCoordenadaY(this) <=4){
          if(!(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this) == posicionX) && !(tablero.obtenerCoordenadaY(this)-1 == posicionY && tablero.obtenerCoordenadaX(this)== posicionX) && !(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)== posicionY) && !(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-1== posicionY)){
            throw new movimientoInvalido("El Rey no puede realizar ese movimiento!!");
          }  
        }
                 
        //restriccion en la parte de enmedio del tablero.
        if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") || tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaX(this) >= 1 && tablero.obtenerCoordenadaX(this) <=4 && tablero.obtenerCoordenadaY(this) >0 && tablero.obtenerCoordenadaY(this) <=4){
          if(!(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this) == posicionY) && !(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this) == posicionY) && !(tablero.obtenerCoordenadaY(this)-1 == posicionY && tablero.obtenerCoordenadaX(this) == posicionX) && !(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this) == posicionX) && !(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)){
          	throw new movimientoInvalido("El Rey no puede realizar ese movimiento!!");
          }
        }

         
        //restriccion en la parte inferior del tablero.
        if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && tablero.obtenerCoordenadaX(this) == 5 && tablero.obtenerCoordenadaY(this) > 0 && tablero.obtenerCoordenadaY(this) <=4){
          if(!(tablero.obtenerCoordenadaY(this)+1 == posicionY && tablero.obtenerCoordenadaX(this) == posicionX) && !(tablero.obtenerCoordenadaY(this)-1 == posicionY && tablero.obtenerCoordenadaX(this) == posicionX) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this) == posicionY) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)){
            throw new movimientoInvalido("El Rey no puede realizar ese movimiento!!");
          } 	
        }
   


        //Restricciones Rey negro.
        //restriccion en la parte superior del tablero.
        if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaX(this) == 0 && tablero.obtenerCoordenadaY(this) > 0 && tablero.obtenerCoordenadaY(this) <=4){
          if(!(tablero.obtenerCoordenadaY(this)+1 == posicionY) && !(tablero.obtenerCoordenadaY(this)-1 == posicionY) && !(tablero.obtenerCoordenadaX(this)+1 == posicionX) && !(tablero.obtenerCoordenadaX(this)+1 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-1== posicionY)){
            throw new movimientoInvalido("El Rey no puede realizar ese movimiento!!");
          }  
        }
        

        //restriccion en la parte inferior del tablero.
        if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaX(this) == 5 && tablero.obtenerCoordenadaY(this) > 0 && tablero.obtenerCoordenadaY(this) <=4){
          if(!(tablero.obtenerCoordenadaY(this)+1 == posicionY) && !(tablero.obtenerCoordenadaY(this)-1 == posicionY) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)+1 == posicionY) && !(tablero.obtenerCoordenadaX(this)-1 == posicionX && tablero.obtenerCoordenadaY(this)-1 == posicionY)){
            throw new movimientoInvalido("El Rey no puede realizar ese movimiento!!");
          } 	
        }



        //if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && tablero.obtenerCoordenadaX(this) == 5){}

     //dibujar al rey.
     tablero.eliminar(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this));
     tablero.dibujar(posicionX, posicionY, this);

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