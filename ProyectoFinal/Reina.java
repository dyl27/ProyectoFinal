/**
 * la Clase Reina representa una reina en el tablero de ajedrez.
 * @author Dylan juarez.
 * @version 1.0
 */
public class Reina extends Piezas{
	//atributo.
	private char forma = 'A';
	//Metodos Constructores.
	/**
	 * Constructor de un reina apartir de su color.
	 * @param color - valor del color de la reina.
	 * @param numeroPieza - valor del numero de pieza.
	 */
	public Reina(String color,int numeroPieza){
      super(color, numeroPieza);
      asignarColor(color);
      asignarNumeroPieza(numeroPieza);
	}

	//Metodos de acceso.
	/**
	 * Metodo para obtener la forma de la reina.
	 * @return String - valor de la forma de la reina.
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
        //Si las coordenadas exceden los limites del tablero.
        if(posicionX >= tablero.obtenerTablero().length || posicionY >= tablero.obtenerTablero().length){
        	throw new LimitesTablero("Valor de coordenadas invalido!!");
        }
        //Si se ingresan coordenadas negativas.
        if(posicionX < 0 || posicionY < 0){
           throw new LimitesTablero("No puedes introducir numeros negativos!!");
        }
        if(posicionX == tablero.obtenerCoordenadaX(this) && posicionY == tablero.obtenerCoordenadaY(this)){
          throw new movimientoInvalido("Debes mover la pieza!!");
        }
        //Si existe una pieza de  tu mismo color en la casillas donde deseas ir.
	    if(tablero.valorPosicion(posicionX,posicionY) && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals(tablero.obtenerReferenciaObjeto(posicionX,posicionY).obtenerColor())){
         throw new movimientoInvalido("Existe una pieza de tu miso color en las coordenadas donde deseas mover a la  Reina!!");
	    }

        //Si existe una pieza de su mismo color enfrente piezas blancas.
       if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m")){
	    if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this)+1 ,tablero.obtenerCoordenadaY(this)) && posicionX > tablero.obtenerCoordenadaX(this)+1  &&tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this)+1 ,tablero.obtenerCoordenadaY(this)).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
         throw new movimientoInvalido("Tienes una pieza de tu  mismo color enfrente!!");
	    }
	    
       }
       //Si existe una pieza de su mismo color enfrente piezas negras.
        if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m")){
	    if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this)-1 ,tablero.obtenerCoordenadaY(this)) && posicionX < tablero.obtenerCoordenadaX(this)-1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this)-1 ,tablero.obtenerCoordenadaY(this)).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
	      throw new movimientoInvalido("Tienes una pieza de tu mismo color enfrente!!");
	     }
	    
       }

    
        if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && tablero.obtenerCoordenadaY(this) > tablero.obtenerTablero().length){
       	//Si la Reina se desea mover a una posicion donde tiene alado una pieza de su mismo color no se podra mover.
	    //para Reinas blancas.
	    if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)+1) && posicionY >= tablero.obtenerTablero().length&& posicionY > tablero.obtenerCoordenadaY(this)+1|| posicionY == tablero.obtenerCoordenadaY(this)+1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)+1).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
	   	 throw new movimientoInvalido("Tienes una pieza de tu mismo color a tu derecha!!");
	    }
       }

       if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && tablero.obtenerCoordenadaY(this) > 0){
       	if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)-1)  && tablero.obtenerCoordenadaY(this)-1 == posicionY|| posicionY < tablero.obtenerCoordenadaY(this)-1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)-1).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
         throw new movimientoInvalido("Tienes una pieza de tu mismo color a tu izquierda!!");
	    }
       }

        if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaY(this) > tablero.obtenerTablero().length){
       	 //Si la Reina  se desea mover a una posicion donde tiene alado una pieza de su mismo color no se podra mover.
	      //para Reina negras.
	      if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)+1) && posicionY >= tablero.obtenerTablero().length&& posicionY > tablero.obtenerCoordenadaY(this)+1|| posicionY == tablero.obtenerCoordenadaY(this)+1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)+1).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
	     	 throw new movimientoInvalido("Tienes una pieza de tu mismo color a tu derecha!!");
	       }
       }

       if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaY(this) > 0 ){
       	if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)-1) && tablero.obtenerCoordenadaY(this)-1 == posicionY|| posicionY < tablero.obtenerCoordenadaY(this)-1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)-1).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
         throw new movimientoInvalido("Tienes una pieza de tu mismo color a tu izquierda!!");
	      }
       }


	    //Restricciones de la Reina.
	    //Reina blanca y negra.
	    if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") || tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m")){
	       if(!(tablero.obtenerCoordenadaX(this) < tablero.obtenerTablero().length && tablero.obtenerCoordenadaY(this) == posicionY) && !(tablero.obtenerCoordenadaY(this) < tablero.obtenerTablero().length && tablero.obtenerCoordenadaX(this) == posicionX)){
             throw new movimientoInvalido("La Reina no puede realizar ese movimiento!!");
	       }	
	    }










		//dibujar a la Reina.
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