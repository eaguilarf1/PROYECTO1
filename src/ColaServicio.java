import jdk.swing.interop.SwingInterOpUtils;
/**
 * Este programa fue creado como un proyecto para la administración del reporte de inconsistencias,
 * bugs y errores relacionados a los servicios que se proporcionan en un Sistema que se utiliza para
 * la venta de productos online.
 * La clase ColaServico es la clase principal y se encarga de ejecutar todos los ArrayList
 * que se implementaron para la creación del programa así como tambien almacena variables y
 * mensajes que se mostraran en pantalla al usuario.
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class ColaServicio {
    /**
     * @param args metodo principal
     */
    public static void main(String[] args) {

        /**
         * @author Edward Aguilar
         */

        //Se crean los ArrayList para cada cola
        ArrayList<Ticket> cola = new ArrayList<Ticket>();
        ArrayList<Ticket> colaMesa = new ArrayList<Ticket>();
        ArrayList<Ticket> colaSoporte = new ArrayList<Ticket>();
        ArrayList<Ticket> colaDesarrollo = new ArrayList<Ticket>();

        Scanner leer = new Scanner(System.in); //Se define el Scanner para la obtención de valores del usuario
        int opcion; //Variables que tomaran los datos de entrada del usuario
        int eleccion;
        int eleccionEscalacion;

        System.out.println("**ACCESO AL SISTEMA**"); //Primer menú que se muestra para acceder al sistema
        System.out.println("Digite su nit");
        String nitUsuario = leer.nextLine(); //nitUsuario guarda el nit el usuario que ingresara el sistema
        System.out.println("Seleccione su rol");
        System.out.println("1. Cola Mesa");
        System.out.println("2. Cola Soporte");
        System.out.println("3. Cola Desarrollo");
        String rolUsuario = leer.nextLine(); //rolUsuario guarda el rol del usuario que ingresara al sistema

        int contador = 0; // contador para el # de correlativo

        String bitacoraCrearTicket = ""; //Variables que guardaran los cambios y se mostraran en bitacora
        String bitacoraAsignar = "";
        String bitacoraMover = "";
        String bitacoraSolucion = "";

        /**
         * Inicio de ciclo While
         */
        do {

            menu(); //metodo que muestra el menú con las acciones que puede realizar en el sistema
            opcion = leer.nextInt();

            /**
             * Inicio de switch
             */
            switch (opcion) {
                case 1:
                    leer.nextLine(); //Ingreso de datos para crear un nuevo ticket
                    System.out.println("Ingrese su nit");
                    String nit = leer.nextLine();
                    System.out.println("Ingrese su nombre");
                    String nombre = leer.nextLine();
                    System.out.println("Describa el problema");
                    String problema = leer.nextLine();
                    System.out.println("*Ticket enviado*");

                    //INICIO CODIGO PARA MOSTRAR CORRELATIVO
                    String mostrarContador="";
                    contador++; //Se asigna una máscara al numero de correlativo
                        if (contador>=0 && contador<=9){
                            mostrarContador = Integer.toString(contador);
                            mostrarContador = "00000"+mostrarContador; //Si el correlativo es de un digito se muestra 000001
                        }else if (contador>=10 && contador<=99){
                            mostrarContador = Integer.toString(contador);
                            mostrarContador = "0000"+mostrarContador; //Si el correlativo es de dos digitos se muestra 000012
                        }else if(contador>=100 && contador<=999){
                            mostrarContador = Integer.toString(contador);
                            mostrarContador = "000"+mostrarContador; //Si el correlativo es de tres digitos se muestra 000123
                        }else if (contador>=1000 && contador<=9999){
                            mostrarContador = Integer.toString(contador);
                            mostrarContador = "00"+mostrarContador; //Si el correlativo es de cuatro digitos se muestra 001234
                        }else if (contador>=10000 && contador<=99999){
                            mostrarContador = Integer.toString(contador);
                            mostrarContador = "0"+mostrarContador; //Si el correlativo es de cinco digitos se muestra 012345
                        }else if(contador>=100000){
                            mostrarContador = Integer.toString(contador); //Si el correlativo es de seis o mas digitos se muestra 123456
                        }
                    //FINALIZA CODIGO PARA MOSTRAR CORRELATIVO

                    //INICIA CODIGO PARA MOSTRAR FECHA Y HORA
                    String horaActual; //Se definen variables que guaradaran la fecha y hora en tipo String
                    String fechaActual;

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm"); // Se define el formato de la hora
                    LocalTime hora = LocalTime.parse(LocalTime.now().format(dtf));
                    horaActual = hora.toString(); //Se convierte la hora de LocalTime a String y se guarda en horaActual

                    LocalDate fecha = LocalDate.now();
                    fechaActual = fecha.toString(); //Se convierte la fecha de LocalDate a String y se guarda en fechaActual
                    //FINALIZA CODIGO PARA MOSTRAR FECHA Y HORA

                    //Se crean los objetos y se asignan los datos de los parametros de cada ArrayList
                    //con la información que el usuario ha ingresado.
                    cola.add(new Ticket(mostrarContador, nit, nombre, problema, fechaActual, horaActual, "creado"));
                    colaMesa.add(new Ticket(mostrarContador,nit,nombre,problema, fechaActual, horaActual, "cola mesa"));
                    colaSoporte.add(new Ticket(mostrarContador, nit, nombre, problema, fechaActual, horaActual, "cola soporte"));
                    colaDesarrollo.add(new Ticket(mostrarContador, nit, nombre, problema, fechaActual, horaActual, "cola desarrollo"));

                    //Se guarda la acción realizada en la variable bitacoraCrearTicket para se mostrada despues
                    bitacoraCrearTicket = "Ticket No. " + mostrarContador + " creado por " + nombre + " de fecha " + fechaActual + " y hora "+ horaActual;
                    break;

                case 2:
                    for (int i = 0; i < cola.size(); i++) { //Ciclo for que muestra los objetos del ArrayList al usuario
                        System.out.println(cola.get(i));
                    }
                    break;

                case 3:
                    int aleatorio = 0; //Variable que guarda un numero al azar
                    aleatorio = (int) (Math.random() * cola.size()); //Se define un objeto al azar el ArrayList para trabajar
                    System.out.println(cola.get(aleatorio)); // Se muestra el objeto seleccionado y se muestra en pantalla
                    bitacoraAsignar = "Ticket asignado"; //Se guarda la acción realizada en la variable bitacoraAsignar para se mostrada despues
                    System.out.println("1. Marcar el ticket como resuelto"); //Menú para tomar la siguiente acción sobre el ticket seleccionado
                    System.out.println("2. Escalar ticket");
                    System.out.println("3. Regresar");
                    eleccion = leer.nextInt();

                    if (eleccion==1){ //El ticket se marca como solucionado
                        bitacoraSolucion = "Ticket solucionado"; //Se guarda la acción realizada en la variable bitacoraSolucion para se mostrada despues
                        cola.remove(aleatorio); // Se elimina y se muestra mensaje de confirmación
                        System.out.println("*Ticket resuelto y cerrado*");

                    }else if (eleccion==2){ //El ticket se escala
                        bitacoraMover = "Ticket escalado";  //Se guarda la acción realizada en la variable bitacoraMover para se mostrada despues
                        System.out.println("¿A donde desea escalar?"); //El usuario selecciona la cola para escalar el ticket
                        System.out.println("1. Cola Mesa");
                        System.out.println("2. Cola Soporte");
                        System.out.println("3. Cola Desarrollo");
                        eleccionEscalacion = leer.nextInt();
                        if (eleccionEscalacion==1){
                            System.out.println(colaMesa.get(aleatorio)); //Se muestra el ticket con la informacion de la escalación
                            cola.remove(aleatorio);
                        } else if (eleccionEscalacion==2) {
                            System.out.println(colaSoporte.get(aleatorio)); //Se muestra el ticket con la informacion de la escalación
                            cola.remove(aleatorio);
                        } else if (eleccionEscalacion==3) {
                            System.out.println(colaDesarrollo.get(aleatorio)); //Se muestra el ticket con la informacion de la escalación
                            cola.remove(aleatorio);
                        }
                        System.out.println("*Se ha escalado y asignado nuevo estado*"); //Se muestra mensaje de confirmación
                    } else if (eleccion==3) {
                        break;
                    }
                    break;
                case 4: //Bitacora
                    if (bitacoraCrearTicket!=""){ //Si bitacoraCrearTicket tine información se muestra en pantalla
                        System.out.println(bitacoraCrearTicket);
                    }else{ // sino tiene información no se muestra
                        break;
                    }
                    if (bitacoraAsignar!=""){ //Si bitacoraAsignar tine información se muestra en pantalla
                        System.out.println(bitacoraAsignar);
                    }else{ // sino tiene información no se muestra
                        break;
                    }
                    if (bitacoraMover!=""){ //Si bitacoraMover tine información se muestra en pantalla
                        System.out.println(bitacoraMover);
                    }else{ // sino tiene información no se muestra
                        break;
                    }if (bitacoraSolucion!=""){ //Si bitacoraSolucion tine información se muestra en pantalla
                    System.out.println(bitacoraSolucion);
                }else{ // sino tiene información no se muestra
                        break;
                }


            }
            /**
             * Fin de switch
             */
        } while (opcion != 5); //While termina si el usuarion selecciona la opción 5
        /**
         * fin de ciclo while
         */

    }

    /**
     * Metodo que muestra el menú principal al usuario
     */
    public static void menu() {
        System.out.println("1. Ingresar nuevo ticket");
        System.out.println("2. Lista de tickets");
        System.out.println("3. Trabajar ticket");
        System.out.println("4. Mostrar bitacora");
        System.out.println("5. Salir");
    }


}
