/*
*Fecha creación: 31/10/2021
*Esta clase es la encargada de formar y almacenar los paquetes turisticos creados por los diferentes usuarios, apartir de una ciudad de destino
*y una fecha de viaje, ademas de generar la factura del paquete turistico, completar la lista de habitaciones reservadas creada en clase Hotel
*y almacenar las reservas de los clientes
*/
package appagenciaviajes;
import java.util.Scanner;
/**
 *
 * @author Juan David
 */
public class Reserva {
    String ciudadDestino, ciudadSalida, fechaIda, fechaRegreso, factura, ciudadOrigen, fechaReserva;
    int indiceCliente,indiceVueloIda, indiceVueloRegreso,indiceHotel,indiceHabitacion,totalNochesEstadia;
    double totalFacturado,totalPago;
    VueloCharter vuelo = new VueloCharter();
    Hotel hotel = new Hotel();   
    Scanner sc = new Scanner(System.in);
    
    /*
    *Este método pide los datos necesarios para la creación de una reserva, tales como ciudad de destino y fecha del viaje
    */
    void pedirDatos(){
        System.out.println("*****INGRESE LOS DATOS SOLICITADOS PARA GENERAR LA RESERVA*****");
        System.out.println("Ciudad salida: ");
        ciudadSalida = sc.next();
        System.out.println("Ciudad de destino: ");
        ciudadDestino = sc.next();
        System.out.println("Fecha del viaje: ");
        fechaIda = sc.next();
        System.out.println("Fecha de regreso: ");
        fechaRegreso = sc.next();
        System.out.println("Fecha de creación de la reserva: ");
        fechaReserva = sc.next();
        System.out.println("Total noches de estadia: ");
        totalNochesEstadia = sc.nextInt();
    }
    /*
    *Este método es el encargado de crear el paquete turistico, almacenando todos los datos importantes para su creación 
    */
    void crearPaquete(int indiceCliente,int indiceVuelo, int indiceHotel,  int indiceHabitacion,String fechaIda,String fechaRegreso,String ciudadOrigen, String ciudadDestino,String fechaReserva){         
        this.indiceCliente = indiceCliente;
        this.indiceVueloIda = indiceVuelo;        
        this.indiceHotel = indiceHotel;
        this.indiceHabitacion = indiceHabitacion;
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;
        this.fechaReserva = fechaReserva;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;        
    }
    /*
    *Este metodo se encarga de generar y mostrar la factura de un paquete turistico
    */
    void generarFactura(Cliente cliente,VueloCharter vueloCh, Hotel hotel,int indiceHabitacion,int totalNochesEstadia){
        totalFacturado=totalNochesEstadia*hotel.hb[indiceHabitacion].precioNoche+vueloCh.costoVuelo;
        totalPago=totalFacturado+totalFacturado*0.19;
        factura = ("\t\t**FACTURA PAQUETE TURISTICO**"
                +"\n------------------------------------------------------------"
                +"\nDATOS DEL CLIENTE "
                +"\nNombre: "+cliente.nombre
                +"\nId: "+cliente.tipoDocumento+" "+cliente.Id
                +"\nTipo cliente: "+cliente.tipoCliente
                +"\nE-mail: "+cliente.email
                +"\nTeléfono: "+cliente.telefono
                +"\nNombre contacto de emergencia: "+cliente.nombreContactoEmer
                +"\nNúmero contacto de emergencia: "+cliente.numeroContactoEmer
                +"\n------------------------------------------------------------"
                +"\nDATOS DEL VUELO "
                +"\nNúmero del vuelo: "+vueloCh.numeroVuelo
                +"\nCosto: "+vueloCh.costoVuelo
                +"\nCiudad de origen: "+vueloCh.ciudadOrigen
                +"\nCiudad destino: "+vueloCh.ciudadDestino
                +"\nFecha salida: "+vueloCh.fechaSalida
                +"\nHora salida: "+vueloCh.horaSalida
                +"\nCapacidad máxima:"+vueloCh.capacidadMaxima
                +"\nNombre piloto: "+vueloCh.nombrePiloto
                +"\n------------------------------------------------------------"
                +"\nDATOS HOTEL "
                +"\nTipo habitación: "+hotel.hb[indiceHabitacion].descripcion
                +"\nCosto por noche: "+hotel.hb[indiceHabitacion].precioNoche
                +"\n------------------------------------------------------------"
                +"\nTotal facturado: "+ totalFacturado
                +"\nTotal pago: "+ totalPago);
        System.out.println(factura);
        System.out.println("Fin reserva...");
     //return factura;
    }
    /*
    *Este método se encarga de completar el listado de las habitaciones reservadas, creado en la clase hotel con el 
    *nombre listarHabitacionesReservadas(), proporcionando información que el método mencionado anteriormente no suministra,
    *tales como la fecha de la reserva y el cliente que la reservó.
    */
    void completarListaHabitacionesReservadas(){
    
    
    }
    
    /*
    *Este método es el encargado de almacenar las reservas creadas por los diferentes clientes o por los empleados para algún cliente
    */
    void almacenarResevasCliente(){
        
        
    }
       
}
