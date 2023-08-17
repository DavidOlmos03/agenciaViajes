/*
*Fecha creación: 08/11/2021
*Esta clase es la encargada tratar toda la información referente a una habitación, tal información se refiere a una descripción y un precio por noche
*de esta, además permite reservar una habitación, cambiando así su estado de disponibilidad.
*/
package appagenciaviajes;
import java.util.Scanner;
/**
 *
 * @author Juan David
 */
public class Habitacion {
    String descripcion="";
    double precioNoche=0;
    int dispHabitacion=0;  
    Scanner sc = new Scanner(System.in);  
    /*
    *Este método se encarga de obtener los datos de una habitación y su disponibilidad
    */
    void obtenerDatosHabitacion() {
        System.out.println("\t\t**DATOS HABITACIÓN**");
        System.out.println("Ingrese descripción de la habitación: ");
        descripcion = sc.next();
        System.out.println("Ingrese el precio por noche: ");
        precioNoche = sc.nextDouble();          
    }
    /*
    *Este método se encarga de cambiar la disponibilidad de una habitación a reservada
    */
    void reservarHabitacion(){
        dispHabitacion = 1;
        System.out.println("Reserva de habitación exitosa!");      
    }       
}
