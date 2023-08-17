/*
*Fecha creación: 08/11/2021
*Esta clase es la encargada de administrar toda la información referente a un Hotel, que puede ser creado por un empleado, cuenta con metodos como pedir
*datos, el cual permite ingresar datos de un hotel para su registro en el sistema, tiene también un listado de habitacioens y un listado de
*habitaciones reservadas.
*/
package appagenciaviajes;
import java.util.Scanner;
/**
 *
 * @author Juan David
 */
public class Hotel {
    String nombreHotel="", ciudad="", direccion="", email="", categoria="", listadoHabitaciones="", listadoHabitacionesReservadas="";
    int telefonoHotel, numHabitaciones, contHoteles=0;
    Scanner sc = new Scanner(System.in);
    Habitacion hb[];  
    
    /*
    *Este método se encarga de pedir todos los datos relacionados con un hotel
    */
    void pedirDatosHotel(){
        
        System.out.println("*****INGRESE LOS DATOS SOLICITADOS DEL HOTEL*****");
        System.out.println("Nombre: ");
        nombreHotel = sc.next();
        System.out.println("Ciudad: ");
        ciudad = sc.next();
        System.out.println("Dirección: ");
        direccion = sc.next();
        System.out.println("Teléfono: ");
        telefonoHotel = sc.nextInt();
        System.out.println("Email: ");
        email = sc.next();
        System.out.println("Categoría: (platino, oro o plata)");                  
        categoria = sc.next();
        System.out.println("número de habitaciones: "); 
        numHabitaciones = sc.nextInt();
        hb = new Habitacion[numHabitaciones];
        
        /*Este ciclo recorre el arreglo de habitaciones creado anteriormente y 
        *se encarga de pedir los datos para cada una de ellas
        */
        
        for(int i=0; i < numHabitaciones;i++){
            hb[i]=new Habitacion();
            hb[i].obtenerDatosHabitacion();             
        }
        
        System.out.println("Hotel creado exitosamente...");
        contHoteles++;
    }
    void mostrarInformacionHotel(){
        System.out.println("Nombre: "+ nombreHotel);
        System.out.println("Ciudad: "+ ciudad);
        System.out.println("Dirección: "+ direccion);
        System.out.println("Teléfono:"+ telefonoHotel);
        System.out.println("Email:"+ email);
        System.out.println("Categoria: "+ categoria);
        System.out.println("Número habitaciones: "+numHabitaciones);    
    }
    /*
    *Este método crea la lista de habitaciones en un hotel
    */
    void listarHabitaciones(){
        System.out.println("*****LISTADO HABITACIONES DEL HOTEL*****\n");
        System.out.println("#\t DESCRIPCION\t\t\t\t PRECIO NOCHE\n");
        for (int i=1;i<=numHabitaciones;i++){
            listadoHabitaciones = listadoHabitaciones +i+"\t"+hb[i].descripcion+"\t\t\t\t"+hb[i].precioNoche+"\n";
        }
        System.out.println(listadoHabitaciones);
    }
    /*
    *Este método es el encargado de listar las reservas activas, indicando que habitaciones estan reservadas, en que fechas y porque cliente
    */
    String listarHabitacionesReservadas(){
        System.out.println("*****LISTADO DE HABITACIONES CON RESERVAS ACTIVAS*****\n");
        for (int i=1; i<=numHabitaciones; i++){
            if (hb[i].dispHabitacion==1){                     
                listadoHabitacionesReservadas = listadoHabitacionesReservadas + i +"."+hb[i].descripcion;   
            }
        }
        return listadoHabitacionesReservadas;
    }
    
}
