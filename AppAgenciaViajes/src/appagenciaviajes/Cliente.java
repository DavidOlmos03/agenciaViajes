/*
*Fecha creación: 31/10/2021
*Esta clase almacena todos los datos de un empleado, al igual permite editar estos datos, tambien posee un metodo que genera un menú 
*en el que se presentan todas las funcionalidades que puede cumplir un usuario tipo cliente dentro del sistema.
*/
package appagenciaviajes;
import java.util.Scanner;
/**
 *
 * @author Juan David
 */
public class Cliente {
    String nombre="", tipoDocumento="", email="", tipoCliente="", nombreContactoEmer="",usuario="",contrasegna="";
    int Id=0, numeroContactoEmer=0, telefono=0,opcCliente;
    Scanner sc = new Scanner(System.in); 
    /*
    *Este método es el encargado de pedir los datos del cliente he irlos almacenando en un arreglo
    */
    void pedirDatosCliente(){
        System.out.println("*****INGRESE LOS DATOS SOLICITADOS DEL CLIENTE*****");
        System.out.println("Tipo cliente (Platino, Oro y Plata): ");     
        tipoCliente = sc.next();
        System.out.println("Nombre: ");
        nombre = sc.next();
        System.out.println("Tipo de documento (CC, TI, Pasaporte o CE): "); 
        tipoDocumento = sc.next();
        System.out.println("Id: ");
        Id = sc.nextInt();
        System.out.println("Teléfono: ");
        telefono = sc.nextInt();
        System.out.println("Email: ");
        email = sc.next();
        System.out.println("Nombre de un contacto de emergencia: ");
        nombreContactoEmer = sc.next();
        System.out.println("Número de un contacto de emergencia: ");
        numeroContactoEmer = sc.nextInt();
        System.out.println("Ingrese nombre de usuario: ");
        usuario = sc.next();
        System.out.println("Ingrese contraseña: ");
        contrasegna = sc.next();
    }
   
    /*
    *Este método se encarga de generar un menú para un cliente, el cual le permitirá navegar por el sistema,
    *seleccionando alguna de las diferentes acciones que el cliente tiene permitidas desarrollar 
    */
    void generarMenuCliente() {
        System.out.println("\tBIENVENIDO APRECIADO CLIENTE!! \n\t\t*MENÚ CLIENTE*\n"
                + "1. Crear reserva\n"
                + "2. Consultar información de sus reservas activas\n"
                + "3. Cancelar una reserva\n"
                + "4. Atras\n");
        opcCliente = sc.nextInt();            
    }
    /*
    *Este método permite obtener toda la información almacenada de un cliente, mediante este el acceso a la información 
    *del cliente sera mucho mas rapido si se solicita toda la información de dicho cliente
    */
    void mostrarDatosCliente(){
        System.out.println("\t\t**INFORMACIÓN DEL CLIENTE**");
        System.out.println("Nombre: "+nombre);
        System.out.println("Tipo Id: "+tipoDocumento);
        System.out.println("Id: "+Id);
        System.out.println("Tipo de cliente: "+tipoCliente);
        System.out.println("email: "+email);
        System.out.println("Teléfono: "+telefono);
        System.out.println("Usuario: "+usuario);
        System.out.println("Contraseña: "+contrasegna);
        System.out.println("Nombre contacto de emergencia: "+nombreContactoEmer);
        System.out.println("Número contacto de emergencia: "+numeroContactoEmer);
       
    }
}
