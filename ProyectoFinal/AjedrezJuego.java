import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Scanner;
/**
 * La clase AjedrezJuego representa una partida del juego de ajedrez.
 * @author Dylan Juarez.
 * @version 1.0
 */
public class AjedrezJuego{
	public static void main(String[] args){
   //si la cantidad de jugadores no es apropiada.
    if(args.length == 2){
      jugar(args[0], args[1]);
    }
    if(args.length == 0){
      menu();
    }
    if(args.length != 2){
      System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir  dos jugadores!!" + "\u001B[0m" + "\u001B[0m");
      System.exit(0);
    }

  }
  //Menu.
  public static void menu(){
   boolean salidaMenu = false;
   do{ 
    Scanner preguntaMenu = new Scanner(System.in);
    System.out.println("Selecciona una opcion: ");
    System.out.println("\t" + "1" + " ⇨ " + "Ver Puntajes");
    System.out.println("\t" + "2" + " ⇨ " + "Salir");
    System.out.println("\t" + "3" + " ⇨ " + "Jugar");
    int repuestaMenu = preguntaMenu.nextInt();
   
    switch(repuestaMenu){
     case 1:
      puntajeParticipantes();
      System.exit(0);
      break;
     case 2:
      salir();
     case 3:
      Scanner preguntaJugar = new Scanner(System.in);
      System.out.println("\033[44;37m" + "  Inserte un nombre para el primer jugador:  " + "\033[0m" );
      String nombre1 = preguntaJugar.nextLine();
      System.out.println("\033[44;37m" + "  Inserte un nombre para el segundo jugador:  " + "\033[0m" );
      String nombre2 = preguntaJugar.nextLine();
      jugar(nombre1, nombre2);
      break;
     default:
     System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes ingresar un valor valido!!" + "\u001B[0m" + "\u001B[0m");
     salidaMenu = true; 
   
    }

   }while(salidaMenu);

  }//Fin Menu.

  //Jugar.
  public static void jugar(String nombreJugador1, String nombreJugador2){
    //Creamos el tablero para jugar.
    Tablero tablero = new Tablero(6,6, "azul Marino");
    //Piezas del jugador 1.
    Piezas[] piezasJugador1 = new Piezas[12];
    //Peones.
    piezasJugador1[0] = new Peones("blanco", 1);
    piezasJugador1[1] = new Peones("blanco", 2);
    piezasJugador1[2] = new Peones("blanco", 3);
    piezasJugador1[3] = new Peones("blanco", 4);
    piezasJugador1[4] = new Peones("blanco", 5);
    piezasJugador1[5] = new Peones("blanco", 6);
    //Rey.
    piezasJugador1[6] = new Rey("blanco",1);
    //Reina.
    piezasJugador1[7] = new Reina("blanco",1);
    //Torres.
    piezasJugador1[8] =new Torres("blanco",1);
    piezasJugador1[9] = new Torres("blanco",2);
    //Caballos.
    piezasJugador1[10] = new Caballos("blanco",1);
    piezasJugador1[11] = new Caballos("blanco",2);
    
    //Pizas del jugador  2.
    Piezas[] piezasJugador2 = new Piezas[12];
    //Peones.
    piezasJugador2[0] = new Peones("negro",1);
    piezasJugador2[1] = new Peones("negro",2);
    piezasJugador2[2] = new Peones("negro",3);
    piezasJugador2[3] = new Peones("negro",4);
    piezasJugador2[4] = new Peones("negro",5);
    piezasJugador2[5] = new Peones("negro",6);
    //Rey.

    piezasJugador2[6] = new Rey("negro",1);
    //Reina.
    piezasJugador2[7] = new Reina("negro",1);
    //Torres.
    piezasJugador2[8] =new Torres("negro",1);
    piezasJugador2[9] = new Torres("negro",2);
    //Caballos.
    piezasJugador2[10] = new Caballos("negro",1);
    piezasJugador2[11] = new Caballos("negro",2);
   
    //dibujamos las piezas.
    //Piezas del jugador 1 Peones blancos.
     for(int i = 0; i < tablero.obtenerTablero().length; i++){
      for(int j = 0; j < tablero.obtenerTablero()[i].length; j++){
        if(i == 1 && j < tablero.obtenerTablero()[i].length){
           tablero.dibujar(i,j, piezasJugador1[j]); 
        }
      }
     }
     //Piezas del jugador 1 Caballos blancos.
     tablero.dibujar(0,1, piezasJugador1[10]);
     tablero.dibujar(0,4, piezasJugador1[11]);
     //Piezas del jugador 1 Torres blancas.
     tablero.dibujar(0,0, piezasJugador1[8]);
     tablero.dibujar(0,5, piezasJugador1[9]);
     //Piezas del jugador 1 Rey y Reina blancas.
     tablero.dibujar(0,2, piezasJugador1[6]);
     tablero.dibujar(0,3, piezasJugador1[7]);


    //Piezas del jugador 2 Peones negros.
     for(int i = 0; i<tablero.obtenerTablero().length; i++){
      for(int j = 0; j<tablero.obtenerTablero()[i].length; j++){
        if(i== 4 && j <tablero.obtenerTablero()[i].length){
          tablero.dibujar(i,j, piezasJugador2[j]);
        }
      }
     }
     //Piezas del jugador 1 Caballos blancos.
     tablero.dibujar(5,1, piezasJugador2[10]);
     tablero.dibujar(5,4, piezasJugador2[11]);
     //Piezas del jugador 2 Torres blancas.
     tablero.dibujar(5,0, piezasJugador2[8]);
     tablero.dibujar(5,5, piezasJugador2[9]);
      //Piezas del jugador 1 Torres blancas.
     tablero.dibujar(5,2, piezasJugador2[6]);
     tablero.dibujar(5,3, piezasJugador2[7]);
     System.out.println();

    int turnos = 0; 
    tablero.obtenerTableroCompleto();
    while(turnos < 8){ 
    System.out.println();
    turnoJugador1(tablero, nombreJugador1, piezasJugador1);
    System.out.println();
    turnoJugador2(tablero, nombreJugador2, piezasJugador2);
    turnos++;
    }
  }

  //Opcion2 Salir.
  public static void salir(){
   System.out.println("\033[46;30m"+"Gracias por jugar vuelva pronto"+ "\033[0m"); 
   System.exit(0);
  }

  //Opcion1.
  public static void puntajeParticipantes(){
    System.out.println("en breve se realizara jajaja");
  }



  //Turno del jugador uno. 

  public static void turnoJugador1(Tablero tablero,String nombreJugador1, Piezas[] piezas)throws InputMismatchException, ArrayIndexOutOfBoundsException{
    //Piezas del primer jugador que seran de color blanco.
    String[] piezasMenu = new String[5];
    piezasMenu[0] = "Peones(P)";
    piezasMenu[1] = "Rey(R)";
    piezasMenu[2] = "Reina(A)";
    piezasMenu[3] = "Torres(T)";
    piezasMenu[4] = "Caballos(C)";
    boolean salidaMenuPiezas = false;
    do{
    //Seleccion de piezas a tirar.
    System.out.println();  
    System.out.println("\033[42;30m"+"\033[37m" + "Selecciona la pieza a tirar " + nombreJugador1+": Piezas blancas" + "\033[0m");
    System.out.println();
    for(int i = 0; i<piezasMenu.length; i++){
      System.out.print("\t" + (i+1)  + " ⇨ " + piezasMenu[i]);

    }
    System.out.println();
    Scanner preguntaPieza = new Scanner(System.in);
    int tirarPieza = preguntaPieza.nextInt();
    switch(tirarPieza){
     case 1 : //movimiento Peon.
      boolean salidatiroPeon = true;
      while(salidatiroPeon){ 
       try{ 
        Scanner seleccionarPeon = new Scanner(System.in);
        System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador1 + ": Peones blancos" + " " + "\033[0m" );
        System.out.println();
        System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra el peon que deseas mover: ");
        int peonF = seleccionarPeon.nextInt();
        System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra el peon que deseas mover: ");
        int peonC = seleccionarPeon.nextInt();
        if(peonF >= tablero.obtenerTablero().length && peonC >= tablero.obtenerTablero().length){
          throw new LimitesTablero("Valor invalido para coordenadas!!");
        }
        //existencia Peon.
        if(!(tablero.obtenerReferenciaObjeto(peonF,peonC) instanceof Peones)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ningun Peon"); 
         }
         //verificar que la pieza sea blanca.
         if(!(tablero.obtenerReferenciaObjeto(peonF,peonC).obtenerColor().equals("\u001B[37m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
   
        Scanner coordenadas = new Scanner(System.in);
        System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover al peon seleccionado: ");
         int coordenaF = coordenadas.nextInt();
        System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover al peon seleccionado: ");
        int coordenaC = coordenadas.nextInt();
        int indicePieza = indicePieza(tablero,piezas,peonF,peonC);
        piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);    
        salidatiroPeon=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(LimitesTablero e){//Error al introducir una coordenada fuera de los limites del tablero.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){//Error al realizar un movimiento invalido.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidatiroPeon = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidatiroPeon = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "El valor que tecleaste no forma parte del tablero!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }
     
     }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;

     case 2 : //movimiento Rey.
       boolean salidaRey = true;
      while(salidaRey){
       try{
         Scanner seleccionarRey = new Scanner(System.in);
         System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador1 + ": Rey blanco" + " " + "\033[0m" );
         System.out.println();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra la Rey que deseas mover: ");
         int reyF = seleccionarRey.nextInt();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra la Rey que deseas mover: ");
         int reyC = seleccionarRey.nextInt();
         if(reyC >= tablero.obtenerTablero().length && reyF >= tablero.obtenerTablero().length){
           throw new LimitesTablero("Valores invalidos para coordenadas!!");
         }
         //existencia Rey.
         if(!(tablero.obtenerReferenciaObjeto(reyF,reyC) instanceof Rey)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ningun Rey"); 
         }
         //verificar que la pieza sea blanca.
         if(!(tablero.obtenerReferenciaObjeto(reyF,reyC).obtenerColor().equals("\u001B[37m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
         Scanner coordenadas = new Scanner(System.in);
         System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover la Rey seleccionado: ");
         int coordenaF = coordenadas.nextInt();
         System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover la Rey seleccionado: ");
         int coordenaC = coordenadas.nextInt(); 
         int indicePieza = indicePieza(tablero,piezas,reyF,reyC);
         piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);   
        salidaRey=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidaRey = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidaRey = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(LimitesTablero e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "El valor que tecleaste no forma parte del tablero!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }

      }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;
     case 3 : 
      boolean salidaReina = true;
      while(salidaReina){
       try{
         Scanner seleccionarReina = new Scanner(System.in);
         System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador1 + ": Reina blanca" + " " + "\033[0m" );
         System.out.println();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra la Reina que deseas mover: ");
         int reinaF = seleccionarReina.nextInt();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra la Reina que deseas mover: ");
         int reinaC = seleccionarReina.nextInt();
         if(reinaC >= tablero.obtenerTablero().length && reinaF >= tablero.obtenerTablero().length){
           throw new LimitesTablero("Valores invalidos para coordenadas!!");
         }
         //existencia Rey.
         if(!(tablero.obtenerReferenciaObjeto(reinaF,reinaC) instanceof Reina)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ninguna Reina"); 
         }
         //verificar que la pieza sea blanca.
         if(!(tablero.obtenerReferenciaObjeto(reinaF,reinaC).obtenerColor().equals("\u001B[37m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
         Scanner coordenadas = new Scanner(System.in);
         System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover a la Reina seleccionado: ");
         int coordenaF = coordenadas.nextInt();
         System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover a la Reina seleccionado: ");
         int coordenaC = coordenadas.nextInt(); 
         int indicePieza = indicePieza(tablero,piezas,reinaF,reinaC);
         piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);   
        salidaReina=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidaReina = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidaRey = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(LimitesTablero e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "El valor que tecleaste no forma parte del tablero!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }

      }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;
     case 4 : //movimiento Torres.
      boolean salidaTorres = true;
      while(salidaTorres){
       try{
         Scanner seleccionarTorre = new Scanner(System.in);
         System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador1 + ": Torres blancas" + " " + "\033[0m" );
         System.out.println();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra la Torre que deseas mover: ");
         int torreF = seleccionarTorre.nextInt();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra la Torre que deseas mover: ");
         int torreC = seleccionarTorre.nextInt();
         if(torreC >= tablero.obtenerTablero().length && torreF >= tablero.obtenerTablero().length){
           throw new LimitesTablero("Valores invalidos para coordenadas!!");
         }
         //existencia Torre.
         if(!(tablero.obtenerReferenciaObjeto(torreF,torreC) instanceof Torres)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ninguna Torre"); 
         }
         if(!(tablero.obtenerReferenciaObjeto(torreF,torreC).obtenerColor().equals("\u001B[37m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
         Scanner coordenadas = new Scanner(System.in);
         System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover la Torre seleccionado: ");
         int coordenaF = coordenadas.nextInt();
         System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover la Torre seleccionado: ");
         int coordenaC = coordenadas.nextInt(); 
         int indicePieza = indicePieza(tablero,piezas,torreF,torreC);
         piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);   
        salidaTorres=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidaTorres = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidaTorres = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(LimitesTablero e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "El valor que tecleaste no forma parte del tablero!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }

      }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;
      case 5 : //movimiento Caballos.
       boolean salidaCaballos = true;
      while(salidaCaballos){
       try{
         Scanner seleccionarCaballos = new Scanner(System.in);
         System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador1 + ": Caballos blancos" + " " + "\033[0m" );
         System.out.println();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra el caballo que deseas mover: ");
         int caballosF = seleccionarCaballos.nextInt();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra el caballo que deseas mover: ");
         int caballosC = seleccionarCaballos.nextInt();
         if(caballosC >= tablero.obtenerTablero().length && caballosF >= tablero.obtenerTablero().length){
           throw new LimitesTablero("Valores invalidos para coordenadas!!");
         }
         //existencia caballo.
         if(!(tablero.obtenerReferenciaObjeto(caballosF,caballosC) instanceof Caballos)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ningun Caballo"); 
         }
         if(!(tablero.obtenerReferenciaObjeto(caballosF,caballosC).obtenerColor().equals("\u001B[37m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
         Scanner coordenadas = new Scanner(System.in);
         System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover el Caballo seleccionado: ");
         int coordenaF = coordenadas.nextInt();
         System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover el Caballo seleccionado: ");
         int coordenaC = coordenadas.nextInt(); 
         int indicePieza = indicePieza(tablero,piezas,caballosF,caballosC);
         piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);   
        salidaCaballos=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidaCaballos = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidaCaballos = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(LimitesTablero e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "El valor que tecleaste no forma parte del tablero!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }

      }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;

     default:
      System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes ingresar un valor apropiado!!" + "\u001B[0m" + "\u001B[0m");
      salidaMenuPiezas = true;
    
    }

  
   }while(salidaMenuPiezas);
   

  }//fin del turno del jugador 1.

  //Turno del jugador dos.
  public static void turnoJugador2(Tablero tablero, String nombreJugador2, Piezas[] piezas)throws InputMismatchException,ArrayIndexOutOfBoundsException{
    //Piezas del segundo jugador que seran de color negro.
    String[] piezasMenu = new String[5];
    piezasMenu[0] = "Peones(P)";
    piezasMenu[1] = "Rey(R)";
    piezasMenu[2] = "Reina(A)";
    piezasMenu[3] = "Torres(T)";
    piezasMenu[4] = "Caballos(C)";
    boolean salidaMenuPiezas = false;
    do{
    //Seleccion de piezas a tirar.
    System.out.println(); 
    System.out.println("\033[44;37m "+"\033[37m" + "Selecciona la pieza a tirar " + nombreJugador2+": Piezas negras" + "\033[0m");
    System.out.println();
    for(int i = 0; i<piezasMenu.length; i++){
      System.out.print("\t" + (i+1)  + "⇨ " + piezasMenu[i]);

    }
    System.out.println();
    Scanner preguntaPieza = new Scanner(System.in);
    int tirarPieza = preguntaPieza.nextInt();
    switch(tirarPieza){
     case 1 : //movimiento Peon.
      boolean salidatiroPeon = true;
      while(salidatiroPeon){ 
       try{ 
        Scanner seleccionarPeon = new Scanner(System.in);
        System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador2 + ": Peones negros" + " " + "\033[0m" );
        System.out.println();
        System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra el peon que deseas mover: ");
        int peonF = seleccionarPeon.nextInt();
        System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra el peon que deseas mover: ");
        int peonC = seleccionarPeon.nextInt();
        if(peonF >= tablero.obtenerTablero().length && peonC >= tablero.obtenerTablero().length){
          throw new LimitesTablero("Valor invalido para coordenadas!!");
        }
        //existencia Peon.
        if(!(tablero.obtenerReferenciaObjeto(peonF,peonC) instanceof Peones)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ningun Peon"); 
         }
         //verificar que la pieza sea blanca.
         if(!(tablero.obtenerReferenciaObjeto(peonF,peonC).obtenerColor().equals("\u001B[30m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
   
        Scanner coordenadas = new Scanner(System.in);
        System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover al peon seleccionado: ");
         int coordenaF = coordenadas.nextInt();
        System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover al peon seleccionado: ");
        int coordenaC = coordenadas.nextInt();
        int indicePieza = indicePieza(tablero,piezas,peonF,peonC);
        piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);    
        salidatiroPeon=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(LimitesTablero e){//Error al introducir una coordenada fuera de los limites del tablero.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){//Error al realizar un movimiento invalido.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidatiroPeon = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidatiroPeon = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "No puedes introducir numeros negativos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }
     
     }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;

     case 2 : //movimiento Rey.
      boolean salidaRey = true;
      while(salidaRey){
       try{
         Scanner seleccionarRey = new Scanner(System.in);
         System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador2 + ": Rey negro" + " " + "\033[0m" );
         System.out.println();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra la Rey que deseas mover: ");
         int reyF = seleccionarRey.nextInt();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra la Rey que deseas mover: ");
         int reyC = seleccionarRey.nextInt();
         if(reyC >= tablero.obtenerTablero().length && reyF >= tablero.obtenerTablero().length){
           throw new LimitesTablero("Valores invalidos para coordenadas!!");
         }
         //existencia Torre.
         if(!(tablero.obtenerReferenciaObjeto(reyF,reyC) instanceof Rey)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ningun Rey"); 
         }
         //verificar que la pieza sea negra.
         if(!(tablero.obtenerReferenciaObjeto(reyF,reyC).obtenerColor().equals("\u001B[30m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
         Scanner coordenadas = new Scanner(System.in);
         System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover la Rey seleccionado: ");
         int coordenaF = coordenadas.nextInt();
         System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover la Rey seleccionado: ");
         int coordenaC = coordenadas.nextInt(); 
         int indicePieza = indicePieza(tablero,piezas,reyF,reyC);
         piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);   
        salidaRey=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidaRey = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidaRey = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(LimitesTablero e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "El valor que tecleaste no forma parte del tablero!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }

      }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;
     case 3 : 
      boolean salidaReina = true;
      while(salidaReina){
       try{
         Scanner seleccionarReina = new Scanner(System.in);
         System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador2 + ": Reina negra" + " " + "\033[0m" );
         System.out.println();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra la Reina que deseas mover: ");
         int reinaF = seleccionarReina.nextInt();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra la Reina que deseas mover: ");
         int reinaC = seleccionarReina.nextInt();
         if(reinaC >= tablero.obtenerTablero().length && reinaF >= tablero.obtenerTablero().length){
           throw new LimitesTablero("Valores invalidos para coordenadas!!");
         }
         //existencia Rey.
         if(!(tablero.obtenerReferenciaObjeto(reinaF,reinaC) instanceof Reina)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ninguna Reina"); 
         }
         //verificar que la pieza sea blanca.
         if(!(tablero.obtenerReferenciaObjeto(reinaF,reinaC).obtenerColor().equals("\u001B[30m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
         Scanner coordenadas = new Scanner(System.in);
         System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover a la Reina seleccionado: ");
         int coordenaF = coordenadas.nextInt();
         System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover a la Reina seleccionado: ");
         int coordenaC = coordenadas.nextInt(); 
         int indicePieza = indicePieza(tablero,piezas,reinaF,reinaC);
         piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);   
        salidaReina=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidaReina = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidaRey = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(LimitesTablero e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "El valor que tecleaste no forma parte del tablero!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }

      }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;
     case 4 : //movimiento Torres.
       boolean salidaTorres = true;
      while(salidaTorres){
       try{
         Scanner seleccionarTorre = new Scanner(System.in);
         System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador2 + ": Torres blancas" + " " + "\033[0m" );
         System.out.println();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra la Torre que deseas mover: ");
         int torreF = seleccionarTorre.nextInt();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra la Torre que deseas mover: ");
         int torreC = seleccionarTorre.nextInt();
         if(torreC >= tablero.obtenerTablero().length && torreF >= tablero.obtenerTablero().length){
           throw new LimitesTablero("Valores invalidos para coordenadas!!");
         }
          //existencia Torre.
         if(!(tablero.obtenerReferenciaObjeto(torreF,torreC) instanceof Torres)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ninguna Torre"); 
         }
         if(!(tablero.obtenerReferenciaObjeto(torreF,torreC).obtenerColor().equals("\u001B[30m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
         Scanner coordenadas = new Scanner(System.in);
         System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover la Torre seleccionado: ");
         int coordenaF = coordenadas.nextInt();
         System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover la Torre seleccionado: ");
         int coordenaC = coordenadas.nextInt(); 
         int indicePieza = indicePieza(tablero,piezas,torreF,torreC);
         piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);   
         salidaTorres=false; 
         salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidaTorres = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidaTorres = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(LimitesTablero e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "No puedes introducir numeros negativos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }
      

      }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break;
     case 5 : //movimiento Caballos.
        boolean salidaCaballos = true;
      while(salidaCaballos){
       try{
         Scanner seleccionarCaballos = new Scanner(System.in);
         System.out.println("\033[44;37m" + " " + "Selecciona las coordenadas " + nombreJugador2 + ": Caballos negros" + " " + "\033[0m" );
         System.out.println();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" + " donde se encuentra el caballo que deseas mover: ");
         int caballosF = seleccionarCaballos.nextInt();
         System.out.println("Introduce el valor de la Columna "+ "\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" + " donde se encuentra el caballo que deseas mover: ");
         int caballosC = seleccionarCaballos.nextInt();
         if(caballosC >= tablero.obtenerTablero().length && caballosF >= tablero.obtenerTablero().length){
           throw new LimitesTablero("Valores invalidos para coordenadas!!");
         }
         //existencia caballos.
         if(!(tablero.obtenerReferenciaObjeto(caballosF,caballosC) instanceof Caballos)){
          throw new movimientoInvalido("En las coordenadas que elegiste no existe ningun Caballo"); 
         }
         if(!(tablero.obtenerReferenciaObjeto(caballosF,caballosC).obtenerColor().equals("\u001B[30m"))){
           throw new movimientoInvalido("Esa pieza no es de tu equipo!!");  
         }
         Scanner coordenadas = new Scanner(System.in);
         System.out.println("Introduce una coordenada en la filas "+ "\033[45;30m"+"\033[37m"+ " F "+ "\033[0m" + "\033[0m" +" donde deseas mover el Caballo seleccionado: ");
         int coordenaF = coordenadas.nextInt();
         System.out.println("Introduce una coordenada en las columnas  " +"\033[45;30m"+"\033[37m"+ " C "+ "\033[0m" + "\033[0m" +" donde seas mover el Caballo seleccionado: ");
         int coordenaC = coordenadas.nextInt(); 
         int indicePieza = indicePieza(tablero,piezas,caballosF,caballosC);
         piezas[indicePieza].movimientoPieza(tablero,coordenaF,coordenaC);   
        salidaCaballos=false; 
        salidaMenuPiezas = false;

       }catch(InputMismatchException e){//error al introducir valores no numericos.
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes introducir valores numericos!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(movimientoInvalido e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
         boolean salidaPregunta = true;
         while(salidaPregunta){ 
         Scanner preguntaSalida = new Scanner(System.in);
         System.out.println("Deseas seleccionar otra pieza?");
         String respuesta = preguntaSalida.nextLine();
         if(respuesta.equals("si")){
          salidaCaballos = false;
          salidaPregunta = false;
          salidaMenuPiezas = true;

          break;
         }else if(respuesta.equals("no")){
           salidaCaballos = true;
           salidaPregunta = false;
           break;
         }else{
           System.out.println("Debes responder si o no!!");
           salidaPregunta = true;
           break;
         }

         }
       }catch(LimitesTablero e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + e + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("\u001B[40;30m" + "\u001B[31m" + "El valor que tecleaste no forma parte del tablero!!" + "\u001B[0m" + "\u001B[0m");
         System.out.println();
       }

      }
      tablero.obtenerTableroCompleto();
      System.out.println();
      break; 
     default:
      System.out.println("\u001B[40;30m" + "\u001B[31m" + "Debes ingresar un valor apropiado!!" + "\u001B[0m" + "\u001B[0m");
      salidaMenuPiezas = true;
    
    }

  
   }while(salidaMenuPiezas);
   System.out.println();
    
  }//Fin del turno del jugador 2.

  public static int indicePieza(Tablero tablero, Piezas[] piezas, int posicionX, int posicionY){
    for(int i = 0; i<piezas.length; i++){
       if(tablero.obtenerReferenciaObjeto(posicionX,posicionY).obtenerPieza().equals(piezas[i].obtenerPieza()) && piezas[i].obtenerNumeroPieza() == tablero.obtenerReferenciaObjeto(posicionX,posicionY).obtenerNumeroPieza()){
        return i;
       }
    }
    return -1;
  }
  
    
}//fin de la clase AjedrezJuegoCompleto.


