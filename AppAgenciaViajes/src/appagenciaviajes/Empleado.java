/*
 * Fecha creación: 31/10/2021
 * Esta clase se encarga de tratar los datos como el nombre de usuario y la contraseña que pertenece a un empleado, además, esta clase tiene un metodo
 * el cual permite obtener el menú para los empleados, con las diferentes acciones que estos pueden realizar dentro del sistema  
 */
package appagenciaviajes;
import java.util.Scanner;
/**
 *
 * @author Juan David
 */
public class Empleado {

    String nombreUsuario, contrasegna;
    int opcEmpleado;
    Scanner sc = new Scanner(System.in);

    /*
    *Este método se encarga de generar un menú para un empleado, el cual le permitirá navegar por el sistema,
    *seleccionando alguna de las diferentes acciones que el empleado tiene permitidas desarrollar 
     */
    void generarMenuEmpleado() {
        System.out.println("\t\tBIENVENIDO COLEGA!! \n\t\t *MENÚ EMPLEADO*\n"
                + "1.  Consultar información de un cliente\n"
                + "2.  Consultar información de los hoteles\n"
                + "3.  Consultar hoteles y habitaciones disponibles\n"
                + "4.  Consultar disponibilidad de un vuelo\n"
                + "5.  Generar listado de reservas desde una fecha especifica\n"
                + "6.  Reservar paquete turistico\n"
                + "7.  Cancelar reserva de un paquete\n"
                + "8.  Crear cliente\n" 
                + "9.  Crear hotel\n"
                + "10. Crear vuelo chárter\n"
                + "11. Atras\n");
        opcEmpleado = sc.nextInt();
    }

}
