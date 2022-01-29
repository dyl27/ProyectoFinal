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