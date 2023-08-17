/*
*Fecha creación: 31/10/2021
*Esta clase se encarga de gestionar toda la información referente a un vuelo chárter, ya sea reservando un vuelo (alterando así su disponibilidad) 
*o pidiendo los datos necesarios para la creación o reserva de un vuelo chárter.
*/
package appagenciaviajes;
import java.util.Scanner;
/**
 *
 * @author Juan David
 */
public class VueloCharter {
    String ciudadOrigen="", ciudadDestino="", horaSalida="", nombrePiloto="", fechaSalida="";
    int numeroVuelo=0, capacidadMaxima, dispVuelo=1, contReservasVuelo;
    double costoVuelo;
    Scanner sc = new Scanner(System.in);
    
    /*
    *Este método hace que se ocupe un cupo del vuelo chárter, siempre que haya disponibilidad de cupos 
    */
    void reservarVuelo(){                
        System.out.println("Reserva del vuelo creada exitosamente!");
        contReservasVuelo++;           
    }
    /*
    *Este método pide los datos de un vuelo chárter
    */
    void pedirDatosVuelo(){
        System.out.println("*****INGRESE LOS DATOS SOLICITADOS DEL VUELO CHÁRTER*****");
        System.out.println("Número de vuelo: ");
        numeroVuelo = sc.nextInt();
        System.out.println("Costo: ");
        costoVuelo = sc.nextDouble();
        System.out.println("Ciudad origen: ");
        ciudadOrigen = sc.next();
        System.out.println("Ciudad destino: ");
        ciudadDestino = sc.next();
        System.out.println("Fecha salida: ");
        fechaSalida = sc.next();
        System.out.println("Hora salida: ");
        horaSalida = sc.next();
        System.out.println("Capacidad máxima: ");
        capacidadMaxima = sc.nextInt();
        System.out.println("Nombre piloto: ");
        nombrePiloto = sc.next();
        System.out.println("Vuelo chárter creado exitosamente...");
        
    }
    
}
