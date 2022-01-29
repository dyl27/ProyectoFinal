/**
 * La clase Torres representa un torre en el juego de ajedrez.
 * @author Dylan juarez.
 * @version 1.0 
 */
public class Torres extends Piezas{
	//atributo.
	private char forma = 'T';
   //Metodos constructores.
   /**
    * Constructor de una torre mediante parametros.
    * @param color - color de la torre.
    * @param numeroPieza - valor del numero de pieza.
    */
	public Torres(String color, int numeroPieza){
      super(color, numeroPieza);
      asignarColor(color);
      asignarNumeroPieza(numeroPieza);
	} 
    //Metodo de obtencion.
    /**
     * Metodo para obtener la forma de la Torre.
     * @return String - valor de la forma de la torre.
     */
	@Override
	public String obtenerPieza(){
		
		return  obtenerColor() + this.forma;

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

		//si las coordenadas son erroneas.
		if(posicionX >= tablero.obtenerTablero().length || posicionY >= tablero.obtenerTablero().length){
	   	 throw new LimitesTablero("Valor de coordenadas invalido!");
	   } 
	   // si las coordenadas son numeros negativos.
	   if(posicionY < 0 || posicionX < 0){
	   	throw new  LimitesTablero("No puedes ingresar numeros negativos!!");
	   }
       

	   //si no se mueve la pieza.
	   if(posicionX == tablero.obtenerCoordenadaX(this) && posicionY == tablero.obtenerCoordenadaY(this)){
	   	 throw new movimientoInvalido("Debes mover la pieza!!");
	   }
	   //Si existe una pieza  del mismo color en la casilla donde deseamos mover a nuestra Torre no podra moverse.
	   if(tablero.valorPosicion(posicionX,posicionY) && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this)).obtenerColor().equals(tablero.obtenerReferenciaObjeto(posicionX,posicionY).obtenerColor())){
         throw new movimientoInvalido("Existe una pieza de tu miso color en las coordenadas donde deseas mover la Torre!!");
	   }

       
	   //si la Torre se desea mover a una posicion donde tiene una enfrente un pieza de mismo color no se podra mover.
	   //para Torres blancas.
	   if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m")){
	    if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this)+1 ,tablero.obtenerCoordenadaY(this)) && posicionX > tablero.obtenerCoordenadaX(this)+1  &&tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this)+1 ,tablero.obtenerCoordenadaY(this)).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
         throw new movimientoInvalido("Tienes una pieza de tu  mismo color enfrente!!");
	    }
	    
       }

       if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && tablero.obtenerCoordenadaY(this) > tablero.obtenerTablero().length){
       	//Si la Torre se desea mover a una posicion donde tiene alado una pieza de su mismo color no se podra mover.
	    //para Torre blancas.
	    if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)+1) && posicionY >= tablero.obtenerTablero().length&& posicionY > tablero.obtenerCoordenadaY(this)+1|| posicionY == tablero.obtenerCoordenadaY(this)+1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)+1).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
	   	 throw new movimientoInvalido("Tienes una pieza de tu mismo color a tu derecha!!");
	    }
       }

       if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[37m") && tablero.obtenerCoordenadaY(this) > 0){
       	if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)-1)  && tablero.obtenerCoordenadaY(this)-1 == posicionY|| posicionY < tablero.obtenerCoordenadaY(this)-1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)-1).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
         throw new movimientoInvalido("Tienes una pieza de tu mismo color a tu izquierda!!");
	    }
       }


	   
	   //Si la Torre se desea mover a una posicion donde tiene una enfrente una pieza de su mismo color no se podra mover.
	   //para Torres negras.

	   if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m")){
	    if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this)-1 ,tablero.obtenerCoordenadaY(this)) && posicionX < tablero.obtenerCoordenadaX(this)-1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this)-1 ,tablero.obtenerCoordenadaY(this)).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
	      throw new movimientoInvalido("Tienes una pieza de tu mismo color enfrente!!");
	     }
	    
       }

        
       if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaY(this) > tablero.obtenerTablero().length){
       	 //Si la Torre se desea mover a una posicion donde tiene alado una pieza de su mismo color no se podra mover.
	      //para Torre negras.
	      if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)+1) && posicionY >= tablero.obtenerTablero().length&& posicionY > tablero.obtenerCoordenadaY(this)+1|| posicionY == tablero.obtenerCoordenadaY(this)+1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)+1).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
	     	 throw new movimientoInvalido("Tienes una pieza de tu mismo color a tu derecha!!");
	       }
       }

       if(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)).obtenerColor().equals("\u001B[30m") && tablero.obtenerCoordenadaY(this) > 0 ){
       	if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)-1) && tablero.obtenerCoordenadaY(this)-1 == posicionY|| posicionY < tablero.obtenerCoordenadaY(this)-1 && tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this), tablero.obtenerCoordenadaY(this)-1).obtenerColor().equals(tablero.obtenerReferenciaObjeto(tablero.obtenerCoordenadaX(this) ,tablero.obtenerCoordenadaY(this)).obtenerColor())){
         throw new movimientoInvalido("Tienes una pieza de tu mismo color a tu izquierda!!");
	      }
       }

       


	   //si tiene una pieza adelante de su mismo color no puede avanzar.
	   //para las piezas blancas.
	  
       //verificar si existe una Torre en la fila especificada.
        //dibujamos la Torre en el tablero.
        tablero.eliminar(tablero.obtenerCoordenadaX(this),tablero.obtenerCoordenadaY(this));
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

