/**
 * Peones representa un peon en un tablero de ajedrez.
 * @author Dylan Juarez.
 * @version 1.0
 */
public class Peones extends Piezas{
	//atributo.
	private char forma = 'P';
	//Metodos Constructores.
	/**
	 * Constructor de un peon apartir de su color.
	 * @param color - valor del color del peon.
	 * @param numeroPieza - valor del numero de pieza.
	 */
	public Peones(String color, int numeroPieza){
      super(color, numeroPieza);
      asignarColor(color);
      asignarNumeroPieza(numeroPieza);
  
	}

	//Metodos de acceso.
	/**
	 * Metodo para obtener la forma del Peon.
	 * @return String - valor de la forma del Peon.
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
	public void movimientoPieza(Tablero tablero, int posicionX, int posicionY)throws movimientoInvalido, LimitesTablero {	
    
	   if(posicionX >= tablero.obtenerTablero().length || posicionY >= tablero.obtenerTablero().length){
	   	 throw new LimitesTablero("Valor de coordenadas invalido!");
	   } 
	   if(posicionY < 0 || posicionX < 0){
	   	throw new  LimitesTablero("No puedes ingresar numeros negativos!!");
	   }
	   
	   if(posicionY != tablero.obtenerCoordenadaY(this) ){
	   	 
	   	  throw new movimientoInvalido("El peon se mueve en linea recta!!");
	     
	   }


	   if(posicionX > tablero.obtenerCoordenadaX(this)+1 && (tablero.obtenerTablero().length/2) > tablero.obtenerCoordenadaX(this) && obtenerColor().equals("\u001B[37m") || tablero.obtenerCoordenadaX(this)-1 > posicionX && tablero.obtenerCoordenadaX(this) > (tablero.obtenerTablero().length/2) && obtenerColor().equals("\u001B[30m")){
	   	 throw new movimientoInvalido("El peon solo se mueve una casilla a la vez!!");
	   }
	   if(tablero.obtenerCoordenadaX(this) == (tablero.obtenerTablero().length/2) && posicionX > tablero.obtenerCoordenadaX(this)+1 && obtenerColor().equals("\u001B[37m")  || tablero.obtenerCoordenadaX(this) == (tablero.obtenerTablero().length/2) && tablero.obtenerCoordenadaX(this)-1 > posicionX && obtenerColor().equals("\u001B[30m")){
	   	 throw new movimientoInvalido("El peon solo se mueve una casilla a la vez!!");
	   }
       
	   
	   if(posicionY == tablero.obtenerCoordenadaY(this) && posicionX == tablero.obtenerCoordenadaX(this)){
         throw new movimientoInvalido("Debes mover la pieza!!");
	   }

	   if((tablero.obtenerTablero().length/2) > tablero.obtenerCoordenadaX(this) && tablero.obtenerCoordenadaX(this) > posicionX || (tablero.obtenerTablero().length/2) < tablero.obtenerCoordenadaX(this) && posicionX > tablero.obtenerCoordenadaX(this) ){
	   	throw new movimientoInvalido("No puedes retroceder!!");
	   }
	   if(tablero.obtenerCoordenadaX(this) == (tablero.obtenerTablero().length/2) && tablero.obtenerCoordenadaX(this) > posicionX && obtenerColor().equals("\u001B[37m")){
	   	throw new movimientoInvalido("No puedes retroceder!!");
	   }
	   if(tablero.obtenerCoordenadaX(this) == (tablero.obtenerTablero().length/2) && posicionX > tablero.obtenerCoordenadaX(this) && obtenerColor().equals("\u001B[30m")){
	   	throw new movimientoInvalido("No puedes retroceder!!");
	   }
	   if(obtenerColor().equals("\u001B[37m")){
       if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this)+1, tablero.obtenerCoordenadaY(this))){
        throw new movimientoInvalido("Tienes una pieza enfrente no puedes avanzar!!");
       }

       }  

       if(obtenerColor().equals("\u001B[30m")){
       	if(tablero.valorPosicion(tablero.obtenerCoordenadaX(this)-1, tablero.obtenerCoordenadaY(this))){
         throw new movimientoInvalido("Tienes una pieza enfrente no puedes avanzar");
       	}
       }

     
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