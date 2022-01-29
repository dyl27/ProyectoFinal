/**
 * La clase piezas representa las piezas de un tablero de ajedrez.
 * @author Dylan Juarez.
 * @version 1.0
 */
public abstract class Piezas{
	//atributos.
	protected String color;
	protected int numeroPieza;
    //Metodo Construtor.
    /**
     * Constructor de una pieza apartir de su color.
     * @param color - valor del color de la pieza.
     * @param numeroPieza - valor del numero de pieza.
     */
	public Piezas(String color, int numeroPieza){
	 asignarColor(color);
	 asignarNumeroPieza(numeroPieza); 
		
	}


	//Metodos de acceso.
	/**
	 * Metodo para obtener el valor de color.
	 * @return String - valor de color.
	 */
	public String obtenerColor(){
		return this.color;
	}
	/**
	 * Metodo para obtener el valor del numero de pieza.
	 * @return int - valor del numero pieza.
	 */
	public int obtenerNumeroPieza(){
		return this.numeroPieza;
	}
		
	//Metodos de asignacion.
	/**
	 * Metodo para asignar valor a color.
	 * @param color - valor del color.
	 */
	public void asignarColor(String color){
	    if(color.equals("blanco")){
           this.color = "\u001B[37m";
	    }else if(color.equals("negro")){
           this.color = "\u001B[30m";
	    }else{
           this.color = "\u001B[0m";
	    }
	}
	/**
	 * Metodo para asignar valor al numero de pieza.
	 * @param numeroPieza - valor del numero de pieza.
	 */
	public void asignarNumeroPieza(int numeroPieza){
		this.numeroPieza = numeroPieza;
	}
	
	
    //Metodo abstracto. 
    /**
     * Metodo para obtener la pieza.
     * @return String - valor de la pieza.
     */
    public abstract String obtenerPieza();
	/**
	 * Metodo para mover una pieza.
	 * @param tablero - tablero.
	 * @param posicionX - valor de la posicion en el eje X.
	 * @param posicionY - valor de la posicion en el eje Y.
	 * @throws movimientoInvalido - si la pieza realiza un movimiento no permitido.
	 * @throws LimitesTablero - si la pieza realiza un movimiento en ejes coordenados no permitidos.
	 */
	public abstract void movimientoPieza(Tablero tablero, int posicionX, int posicionY) throws movimientoInvalido, LimitesTablero;
    
    /**
     * Metodo para que una pieza elimine a otra.
     * @param tablero - tablero.
     * @param posicionX - valor de la posicion en el eje x de la pieza a eliminar.
     * @param posicionY - valor de la posicion en el eje y de la pieza a eliminar.
     * @throws EliminacionInvalida - si la pieza desea realizar una eliminacion no permitida. 
     */ 
	public abstract void eliminacionPieza(Tablero tablero, int posicionX, int posicionY)throws EliminacionInvalida;

	

}