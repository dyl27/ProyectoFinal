/**
 * La clase Relleno representa el objeto relleno para nuestro teclado.
 * @author Dylan Juarez.
 * @version 1.0
 */
public class Relleno extends Piezas{
	//Metodos Constructores.
	/**
	 * Metodo para construir un relleno.
	 * @param color - valor del color del relleno.
	 */
	public Relleno(String color,int numeroPieza){
     super(color,numeroPieza);
     asignarColor(color);
     asignarNumeroPieza(numeroPieza);
	}
	//Metodos de acceso.
	/**
	 * Metodo para obtener la forma del Relleno.
	 * @return char - valor de la forma del Relleno.
	 */
	@Override
	public String obtenerPieza(){
		return  ".";
	}
	@Override
	public  void movimientoPieza(Tablero tablero, int posicionX, int posicionY) throws movimientoInvalido, LimitesTablero{
		System.out.println("No tiene metodos al ser una pieza de relleno");
	}
    @Override
    public  void eliminacionPieza(Tablero tablero, int posicionX, int posicionY)throws EliminacionInvalida{
    	System.out.println("No tiene metodos la ser una pieza de relleno");
    }
}