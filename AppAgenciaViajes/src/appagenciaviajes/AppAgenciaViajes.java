/*
*Fecha de creación: 31/10/2021

*OBS. Es importante tener en cuenta que hay un primer cliente y empleado en el sistema, en la pocision 0 de sus respectivos arreglos,
*esto hecho con el fin de hacer pruebas en el sistema, así, primero se debe accede a registrar usuario tanto para cliente como para empleado
*y con esto se tendran ya registrados en el sistema los dos usuarios, sus datos se encuentran en la clase Usuarios en los metodos clientDefault() 
empleDefault().

*Esta clase presenta un menú para poder ingresar al sistema,
*crear un usuario o salir del programa, es la encargada de dar ejecución y desarrollo al programa llamando metodos de otras clases,
*logrando así acceder a sus funcionalidades y/o atributos.
*/
package appagenciaviajes;
import java.util.Scanner;
/**
 * @author Juan David
 */
public class AppAgenciaViajes {

    public static void main(String[] args) {
        int opcMenu, contHoteles = 0, contVuelos = 0, contReservas = 0;
        String nombreUsuario, contrasegna;
        Hotel hoteles[] = new Hotel[1000];
        VueloCharter vuelos[] = new VueloCharter[1000];
        Reserva reservas[] = new Reserva[1000];
        Reserva reser = new Reserva();
        Usuario userCliente = new Usuario();
        Usuario userEmpleado = new Usuario();
        Cliente client = new Cliente();
        Empleado emple = new Empleado();

        Scanner sc = new Scanner(System.in);
        /*
        *El siguiente ciclo se encarga de ir mostrando los respectivos menús al usuario
         */
        do {
            System.out.println("Bienvenido, elija una de las opciones del siguiente menú:\n"
                    + "1.Ingresar a la aplicación\n"
                    + "2.Crear cuenta\n"
                    + "3.Salir de la aplicación\n");
            opcMenu = sc.nextInt();
            /*
            *Este ciclo me permite 1.Ingresar a la aplicación y seguidamente navegar en ella, 2.Crear una cuenta de usuario o 3.Salir de la aplicación
             */
            switch (opcMenu) {                
                case 1:
                    int opcCase1;
                    System.out.println("Ingrese su tipo de usuario(1.Cliente/2.Empleado)");
                    opcCase1 = sc.nextInt();
                    if (opcCase1 != 1 && opcCase1 != 2) {
                        while (opcCase1 != 1 && opcCase1 != 2) {
                            System.out.println("Error!,por favor ingrese una opción permitida");
                            System.out.println("Ingrese su tipo de usuario(1.Cliente/2.Empleado)");
                            opcCase1 = sc.nextInt();
                        }
                    }
                    System.out.println("Nombre de usuario: ");
                    nombreUsuario = sc.next();
                    System.out.println("Contraseña: ");
                    contrasegna = sc.next();
                    /*
                    *Para cualquier usuario que quiera ingresar al sistema, se debe verificar que el 
                    *usuario(cliente o empleado) este registrado en el sistema y que sus datos sean correctos 
                     */
                    do {
                        switch (opcCase1) {
                            /*
                            *Este caso se encarga de presentar las opciones para el usuario tipo cliente
                            *Verificando incialmente su registro en el sistema
                             */
                            case 1:
                                /*
                                    *Este condicional obtiene lso datos del cliente por defecto
                                */
                                if (userCliente.contClientesRegistrados == 0) {
                                    userCliente.clientDefault();
                                }
                                userCliente.nombreUsuario = nombreUsuario;
                                userCliente.contrasegna = contrasegna;
                                /*
                                *Se procede a verificar el registro del cliente
                                */
                                userCliente.verificarRegistroCliente();
                                if (userCliente.verificarRegistroCliente() == true) {
                                    do {
                                        /*
                                        *Se genera el menú para el cliente el cual tiene 4 opciones
                                        */
                                        client.generarMenuCliente();
                                        switch (client.opcCliente) {
                                            /*
                                            *Este caso permite al cliente crear una reserva o paquete turístico
                                            */
                                            case 1:
                                                System.out.println("Se creara una reserva...");
                                                /*
                                                *Atributos utilizados exclusivamente en el caso 1 
                                                 */
                                                String nombreClienteReserva,
                                                 fechaViajeIda = "",
                                                 fechaViajeRegreso = "",
                                                 ciudadSalida = "",
                                                 ciudadDestino = "";
                                                int indiceCliente = 0;
                                                /*
                                                *Se procede a buscar la posicion del cliente en arreglo de clientes 
                                                */
                                                nombreClienteReserva = nombreUsuario;
                                                for (int j = 0; j < userCliente.contClientesRegistrados; j++) {
                                                    if (userCliente.clientes[j].usuario.equals(nombreClienteReserva)) {
                                                        indiceCliente = j;
                                                        break;
                                                    }
                                                }
                                                /*
                                                *Ahora, se piden los datos para generar la reserva
                                                */
                                                reser.pedirDatos();
                                                int banderaDispTotal = 0,
                                                 indiceVuelo = 0,
                                                 indiceHotel = 0,
                                                 dispVuelo = 0,
                                                 dispHotel = 0,
                                                 dispHabitacion = 0;
                                                String listHabitacionesDisp = "",
                                                 listaHoteles = "";
                                                /*
                                                    *Este ciclo inicia una serie de chequeos por los cuales se debe pasar para poder generar la reserva
                                                    *con los datos ingresados anteriormente para la misma, en este primer ciclo se comprueba que 
                                                    *existe un vuelo cuya ciudad destino y fecha de salida sean iguales a las ingresadas anteriormente para la reserva,
                                                    *además se debe comprobar que haya disponibilidad del vuelo chárter
                                                */
                                                for (int i = 0; i < contVuelos; i++) {
                                                    if (reser.ciudadDestino.equalsIgnoreCase(vuelos[i].ciudadDestino) && reser.fechaIda.equalsIgnoreCase(vuelos[i].fechaSalida) && vuelos[i].contReservasVuelo <= vuelos[i].capacidadMaxima) {
                                                        dispVuelo = 1;
                                                        fechaViajeIda = reser.fechaIda;
                                                        fechaViajeRegreso = reser.fechaRegreso;
                                                        indiceVuelo = i;
                                                        /*
                                                            *Se procede ahora con el siguiente ciclo, a verificar que existe un hotel en la ciudad destino ingresada para la reserva y 
                                                            *que la catergoría de el cliente es igual a la categoría del hotel (pueden existir varios hoteles que cumplan estas condiciones)
                                                        */
                                                        for (int k = 0; k < contHoteles; k++) {
                                                            
                                                            if (reser.ciudadDestino.equalsIgnoreCase(hoteles[k].ciudad) && userCliente.clientes[indiceCliente].tipoCliente.equalsIgnoreCase(hoteles[k].categoria)) {
                                                                dispHotel = 1;
                                                                ciudadDestino = reser.ciudadDestino;
                                                                ciudadSalida = reser.ciudadSalida;
                                                                for (int h = k; h < contHoteles; h++) {
                                                                    if (hoteles[h].ciudad.equalsIgnoreCase(hoteles[k].ciudad) && hoteles[h].categoria.equalsIgnoreCase(hoteles[k].categoria)) {
                                                                        /*
                                                                            *Se crea una lista con los hoteles que cumplen las condicioens anteriores
                                                                        */
                                                                        listaHoteles += "\n" + h + "." + hoteles[h].nombreHotel;
                                                                    }
                                                                }
                                                                /*
                                                                    *Se mostrara la lista de hoteles que cumplen la condición anterior, para que el usuario
                                                                    *elija uno de ellos
                                                                 */
                                                                System.out.println("Elija uno de los hoteles: ");
                                                                System.out.println(listaHoteles);
                                                                indiceHotel = sc.nextInt();
                                                                /*
                                                                    *Ahora, se debe verificar que existen habitaciones disponibles en el hotel elegido anteriormente
                                                                */
                                                                for (int s = 0; s < hoteles[indiceHotel].numHabitaciones; s++) {
                                                                    if (hoteles[indiceHotel].hb[s].dispHabitacion == 0) {
                                                                        /*
                                                                               *En este punto se han revisado todas las condiciones para poder generar una reserva, por el momento solo se creara la 
                                                                               *lista de habitaciones disponibles y se cambiara el estado de la disponibilidad total de los requisitos para generar la reserva
                                                                         */
                                                                        dispHabitacion = 1;
                                                                        banderaDispTotal = 1;
                                                                        listHabitacionesDisp += "Habitación número " + s + " disponible\n";
                                                                    }
                                                                }
                                                                if (dispHabitacion == 0) {
                                                                    System.out.println("No hay habitaciones disponibles para los datos ingresados...");
                                                                    break;
                                                                }
                                                                break;
                                                            }

                                                        }
                                                        if (dispHotel == 0) {
                                                            System.out.println("No se encontró hotel acorde a los datos ingresados"
                                                                    + "\ngracias por visitarnos, te esperamos pronto...");
                                                            break;
                                                        }
                                                        break;
                                                    }

                                                }
                                                if (dispVuelo == 0) {
                                                    System.out.println("No hay vuelos disponibles para los datos ingresados"
                                                            + "\ngracias por visitarnos, te esperamos pronto...");
                                                    break;
                                                }

                                                if (banderaDispTotal == 1) {
                                                    int numHabitacionReserva;
                                                    /*
                                                            *Se procedera a mostrar el listado de habitaciones disponibles y posteriormente a crear la reserva
                                                     */
                                                    System.out.println("\t\t**LISTADO HABITACIONES DISPONIBLES**");
                                                    System.out.println(listHabitacionesDisp);
                                                    System.out.println("Ingrese el número de la habitación a reservar: ");
                                                    numHabitacionReserva = sc.nextInt();
                                                    /*
                                                            *Se procede finalmente a crear el paquete y luego crear la reserva del vuelo y de la habitación del 
                                                            *hotel
                                                     */
                                                    System.out.println("Se procede a crear el paquete turistico...");
                                                    reservas[contReservas] = new Reserva();
                                                    reservas[contReservas].crearPaquete(indiceCliente, indiceVuelo, indiceHotel, numHabitacionReserva, fechaViajeIda, fechaViajeRegreso, ciudadSalida, ciudadDestino, reser.fechaReserva);
                                                    vuelos[indiceVuelo].reservarVuelo();

                                                    hoteles[indiceHotel].hb[numHabitacionReserva].reservarHabitacion();
                                                    System.out.println("El paquete turistico se ha creado de manera exitosa...");
                                                    reservas[contReservas].generarFactura(userCliente.clientes[indiceCliente], vuelos[indiceVuelo], hoteles[indiceHotel], numHabitacionReserva, reser.totalNochesEstadia);
                                                    contReservas++;

                                                }

                                                break;
                                            case 2:
                                                /*
                                                    *Este caso permite al cliente consultar la información de sus reservas activas
                                                */
                                                System.out.println("Cargando información de reservas activas...");
                                                indiceCliente = 0;
                                                /*
                                                    *Se busca la posición del cliente en el arreglo de clientes
                                                */
                                                for (int j = 0; j < userCliente.contClientesRegistrados; j++) {
                                                    if (userCliente.clientes[j].usuario.equals(nombreUsuario)) {
                                                        indiceCliente = j;
                                                        break;
                                                    }
                                                }
                                                /*
                                                    *Una vez tengamos la posición del cliente en el arreglo, procedemos a mostrar las reservas
                                                    *que tienen el mismo indice del cliente, es decir, las que pertenecen a este cliente
                                                */
                                                for (int i = 0; i < contReservas; i++) {
                                                    if (reservas[i].indiceCliente == indiceCliente) {
                                                        System.out.println("RESERVA #" + (i + 1)
                                                                + "\n------------------------------------------------------------------"
                                                                + "\nCliente: " + userCliente.clientes[reservas[i].indiceCliente].nombre
                                                                + "\nNúmero vuelo: " + vuelos[reservas[i].indiceVueloIda].numeroVuelo
                                                                + "\nNombre hotel: " + hoteles[reservas[i].indiceHotel].nombreHotel
                                                                + "\nNúmero habitación: " + reservas[i].indiceHabitacion
                                                                + "\nFecha viaje: " + vuelos[reservas[i].indiceVueloIda].fechaSalida
                                                                + "\nFecha creacion: " + reservas[i].fechaReserva
                                                                + "\nCiudad destino: " + hoteles[reservas[i].indiceHotel].ciudad
                                                                + "\nCosto: " + reservas[i].totalPago
                                                                + "\nIva pagado(19%): " + reservas[i].totalFacturado * 0.19
                                                                + "\n-------------------------------------------------------------------");
                                                    }
                                                }

                                                break;
                                            case 3:
                                                System.out.println("Cancelación de reserva...");

                                                break;
                                            case 4:
                                                System.out.println("Regresando al menú anterior...");
                                                break;
                                            default:
                                                System.out.println("Por favor, ingrese una opción valida...");
                                                client.generarMenuCliente();

                                        }
                                    } while (client.opcCliente != 4);
                                }
                                break;
                            /*
                            *Este caso se encarga de presentar las opciones para el usuario tipo empleado
                            *Verificando incialmente su registro en el sistema
                             */
                            case 2:
                                /*
                                    *Este condicional obtiene los datos del empleado por defecto
                                */
                                if (userEmpleado.contEmpleadosRegistrados == 0) {
                                    userEmpleado.empleDefault();
                                }
                                userEmpleado.nombreUsuario = nombreUsuario;
                                userEmpleado.contrasegna = contrasegna;
                                /*
                                *Se procede a verificar el registro del empleado
                                */
                                userEmpleado.verificarRegistroEmpleado();
                                if (userEmpleado.verificarRegistroEmpleado() == true) {
                                    do {
                                        /*
                                            *Se genera el menú del empleado el cual contiene 11 opciones 
                                        */
                                        emple.generarMenuEmpleado();
                                        switch (emple.opcEmpleado) {
                                            case 1:
                                                boolean banderaClienteEncontrado = false;
                                                int numClienteEncontrado = 0;
                                                System.out.println("Escriba el nombre de usuario del cliente que desea consultar información...");
                                                userCliente.nombreUsuario = sc.next();
                                                for (int i = 0; i < userCliente.contClientesRegistrados; i++) {
                                                    if (userCliente.clientes[i].usuario.equals(userCliente.nombreUsuario)) {
                                                        banderaClienteEncontrado = true;
                                                        numClienteEncontrado = i;
                                                    }
                                                    
                                                }
                                                if (banderaClienteEncontrado == false) {
                                                    System.out.println("Cliente no encontrado...");
                                                } else {
                                                    userCliente.clientes[numClienteEncontrado].mostrarDatosCliente();
                                                }
                                                System.out.println("-------------------------------------------------------------------");
                                                System.out.println("\nCargando información de reservas activas...\n");                                   
                                                for (int i = 0; i < contReservas; i++) {
                                                    if (reservas[i].indiceCliente == numClienteEncontrado) {
                                                        System.out.println("RESERVA #" + (i + 1)
                                                                + "\n------------------------------------------------------------------"
                                                                + "\nCliente: " + userCliente.clientes[reservas[i].indiceCliente].nombre
                                                                + "\nNúmero vuelo: " + vuelos[reservas[i].indiceVueloIda].numeroVuelo
                                                                + "\nNombre hotel: " + hoteles[reservas[i].indiceHotel].nombreHotel
                                                                + "\nNúmero habitación: " + reservas[i].indiceHabitacion
                                                                + "\nFecha viaje: " + vuelos[reservas[i].indiceVueloIda].fechaSalida
                                                                + "\nFecha creacion: " + reservas[i].fechaReserva
                                                                + "\nCiudad destino: " + hoteles[reservas[i].indiceHotel].ciudad
                                                                + "\nCosto: " + reservas[i].totalPago
                                                                + "\nIva pagado(19%): " + reservas[i].totalFacturado * 0.19
                                                                + "\n-------------------------------------------------------------------");
                                                    }
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Mostrando información de los hoteles creados...");
                                                System.out.println(contHoteles);
                                                for (int i = 0; i < contHoteles; i++) {
                                                    System.out.println("\t\t**INFORMACIÓN HOTEL " + (i + 1) + "**\n");
                                                    hoteles[i].mostrarInformacionHotel();
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Mostrando hoteles con habitaciones disponibles(falta)...");
                                                
                                                break;
                                            case 4:
                                                int numVuelo;
                                                int indiceVuelo = -1;
                                                System.out.println("Consultando disponibilidad de un vuelo chárter...");
                                                System.out.println("Escriba el número del vuelo chárter: ");
                                                numVuelo = sc.nextInt();
                                                for (int i = 0; i < contVuelos; i++) {
                                                    if (vuelos[i].numeroVuelo == numVuelo) {
                                                        indiceVuelo = i;
                                                        break;
                                                    }
                                                }
                                                if (indiceVuelo == -1) {
                                                    System.out.println("El número de vuelo ingresado no se encuentra en el sistema");
                                                } else {
                                                    if (vuelos[indiceVuelo].contReservasVuelo < vuelos[indiceVuelo].capacidadMaxima) {
                                                        System.out.println("Aún queda disponibilidad en vuelo chárter con número " + numVuelo);
                                                    } else {
                                                        System.out.println("No queda disponibilidad en vuelo chárter con número " + numVuelo + ", o el vuelo no esta en el sistema");
                                                    }
                                                }
                                                break;
                                            case 5:
                                                String fecha = "";
                                                int indiceBuscado = 0;
                                                
                                                System.out.println("Desde que fecha quiere ver la lista de reservas?");
                                                fecha = sc.next();
                                                for (int h = 0; h < contReservas; h++) {
                                                    if (reservas[h].fechaReserva.equalsIgnoreCase(fecha)) {
                                                        indiceBuscado = h;
                                                        break;
                                                    }
                                                }
                                                System.out.println("Generando listado de reservas...");
                                                System.out.println("\t\t***DATOS RESERVAS***"
                                                        + "\n");
                                                for (int i = indiceBuscado; i < contReservas; i++) {
                                                    System.out.println("RESERVA #" + (i + 1)
                                                            + "\n------------------------------------------------------------------"
                                                            + "\nCliente: " + userCliente.clientes[reservas[i].indiceCliente].nombre
                                                            + "\nNúmero vuelo: " + vuelos[reservas[i].indiceVueloIda].numeroVuelo
                                                            + "\nNombre hotel: " + hoteles[reservas[i].indiceHotel].nombreHotel
                                                            + "\nNúmero habitación: " + reservas[i].indiceHabitacion
                                                            + "\nFecha viaje: " + vuelos[reservas[i].indiceVueloIda].fechaSalida
                                                            + "\nFecha creacion: " + reservas[i].fechaReserva
                                                            + "\nCiudad destino: " + hoteles[reservas[i].indiceHotel].ciudad
                                                            + "\nCosto: " + reservas[i].totalPago
                                                            + "\nIva pagado(19%): " + reservas[i].totalFacturado * 0.19
                                                            + "\n-------------------------------------------------------------------");

                                                }
                                                System.out.println("Fin listado reservas...");
                                                break;

                                            case 6:
                                                /*
                                                *Atributos utilizados exclusivamente en el caso 6 
                                                 */
                                                String nombreClienteReserva,
                                                 fechaViajeIda = "",
                                                 fechaViajeRegreso = "",
                                                 ciudadSalida = "",
                                                 ciudadDestino = "";

                                                int banderaCliente = 0,
                                                 indiceCliente = 0;

                                                System.out.println("Ingrese el nombre de usuario del cliente para el cual desea hacer la reserva");
                                                nombreClienteReserva = sc.next();
                                                /*Se debe buscar en el arreglo de clientes a este usuario, de existir de continua pero antes se guarda su indice 
                                                *(ubicación en el arreglo) para ser usado mas adelante  
                                                 */
                                                for (int j = 0; j < userCliente.contClientesRegistrados; j++) {
                                                    if (userCliente.clientes[j].usuario.equals(nombreClienteReserva)) {
                                                        System.out.println("Se encontró el cliente en la signación " + (j + 1) + " de " + userCliente.contClientesRegistrados);
                                                        indiceCliente = j;
                                                        banderaCliente = 1;
                                                        break;
                                                    }
                                                }
                                                /*
                                                *Si se encontró el cliente, se procede a seguir con el proceso para crear la reserva
                                                 */
                                                if (banderaCliente == 1) {

                                                    reser.pedirDatos();

                                                    int banderaDispTotal = 0, indiceHotel = 0, dispVuelo = 0, dispHotel = 0, dispHabitacion = 0;
                                                    indiceVuelo = 0 ;
                                                    String listHabitacionesDisp = "", listaHoteles = "";
                                                    for (int i = 0; i < contVuelos; i++) {
                                                        if (reser.ciudadDestino.equalsIgnoreCase(vuelos[i].ciudadDestino) && reser.fechaIda.equalsIgnoreCase(vuelos[i].fechaSalida) && vuelos[i].contReservasVuelo <= vuelos[i].capacidadMaxima) {
                                                            dispVuelo = 1;
                                                            fechaViajeIda = reser.fechaIda;
                                                            fechaViajeRegreso = reser.fechaRegreso;
                                                            indiceVuelo = i;

                                                            for (int k = 0; k < contHoteles; k++) {

                                                                if (reser.ciudadDestino.equalsIgnoreCase(hoteles[k].ciudad) && userCliente.clientes[indiceCliente].tipoCliente.equalsIgnoreCase(hoteles[k].categoria)) {
                                                                    dispHotel = 1;
                                                                    ciudadDestino = reser.ciudadDestino;
                                                                    ciudadSalida = reser.ciudadSalida;
                                                                    for (int h = k; h < contHoteles; h++) {
                                                                        if (hoteles[h].ciudad.equalsIgnoreCase(hoteles[k].ciudad) && hoteles[h].categoria.equalsIgnoreCase(hoteles[k].categoria)) {
                                                                            listaHoteles += "\n" + h + "." + hoteles[h].nombreHotel;
                                                                        }
                                                                    }
                                                                    /*
                                                                    *Se mostrara la lista de hoteles que cumplen la condición anterior, para que el usuario
                                                                    *elija uno de ellos
                                                                     */
                                                                    System.out.println("Elija uno de los hoteles: ");
                                                                    System.out.println(listaHoteles);
                                                                    indiceHotel = sc.nextInt();
                                                                    for (int s = 0; s < hoteles[indiceHotel].numHabitaciones; s++) {
                                                                        if (hoteles[indiceHotel].hb[s].dispHabitacion == 0) {
                                                                            /*
                                                                               *En este punto se han revisado todas las condiciones para poder generar una reserva, por el momento solo se creara la 
                                                                               *lista de habitaciones disponibles y se cambiara el estado de la disponibilidad total de los requisitos para generar la reserva
                                                                             */
                                                                            dispHabitacion = 1;
                                                                            banderaDispTotal = 1;
                                                                            listHabitacionesDisp += "Habitación número " + s + " disponible\n";
                                                                        }
                                                                    }
                                                                    if (dispHabitacion == 0) {
                                                                        System.out.println("No hay habitaciones disponibles para los datos ingresados...");
                                                                        break;
                                                                    }
                                                                    break;
                                                                }

                                                            }
                                                            if (dispHotel == 0) {
                                                                System.out.println("No se encontró hotel acorde a los datos ingresados"
                                                                        + "\ngracias por visitarnos, te esperamos pronto...");
                                                                break;
                                                            }
                                                            break;
                                                        }

                                                    }
                                                    if (dispVuelo == 0) {
                                                        System.out.println("No hay vuelos disponibles para los datos ingresados"
                                                                + "\ngracias por visitarnos, te esperamos pronto...");
                                                        break;
                                                    }

                                                    if (banderaDispTotal == 1) {
                                                        int numHabitacionReserva;
                                                        /*
                                                            *Se procedera a mostrar el listado de habitaciones disponibles y posteriormente a crear la reserva
                                                         */
                                                        System.out.println("\t\t**LISTADO HABITACIONES DISPONIBLES**");
                                                        System.out.println(listHabitacionesDisp);
                                                        System.out.println("Ingrese el número de la habitación a reservar: ");
                                                        numHabitacionReserva = sc.nextInt();
                                                        /*
                                                            *Se procede finalmente a crear el paquete y luego crear la reserva del vuelo y de la habitación del 
                                                            *hotel
                                                         */
                                                        System.out.println("Se procede a crear el paquete turistico...");
                                                        reservas[contReservas] = new Reserva();
                                                        reservas[contReservas].crearPaquete(indiceCliente, indiceVuelo, indiceHotel, numHabitacionReserva, fechaViajeIda, fechaViajeRegreso, ciudadSalida, ciudadDestino, reser.fechaReserva);
                                                        vuelos[indiceVuelo].reservarVuelo();

                                                        hoteles[indiceHotel].hb[numHabitacionReserva].reservarHabitacion();
                                                        System.out.println("El paquete turistico se ha creado de manera exitosa...");
                                                        reservas[contReservas].generarFactura(userCliente.clientes[indiceCliente], vuelos[indiceVuelo], hoteles[indiceHotel], numHabitacionReserva, reser.totalNochesEstadia);
                                                        contReservas++;

                                                    }
                                                } else {
                                                    System.out.println("Cliente no encontrado en el sistema");
                                                }
                                                break;
                                            case 7:
                                                System.out.println("Ingrese los datos solicitados para cancelar reserva(falta)...");
                                                break;
                                            case 8:
                                                System.out.println("Ingrese los datos solicitados para crear un cliente...");
                                                userCliente.clientes[userCliente.contClientesRegistrados] = new Cliente();
                                                userCliente.clientes[userCliente.contClientesRegistrados].pedirDatosCliente();
                                                userCliente.contClientesRegistrados++;
                                                break;
                                            case 9:
                                                System.out.println("Ingrese la información solicitada para agregar un hotel al sistema...");
                                                hoteles[contHoteles] = new Hotel();
                                                hoteles[contHoteles].pedirDatosHotel();
                                                contHoteles++;
                                                break;
                                            case 10:
                                                System.out.println("Ingrese la información solicitada para crear un vuelo chárter...");
                                                vuelos[contVuelos] = new VueloCharter();
                                                vuelos[contVuelos].pedirDatosVuelo();
                                                contVuelos++;
                                                break;
                                            case 11:
                                                System.out.println("Regresando al menú anterior...");
                                                break;
                                            default:
                                                System.out.println("Por favor, ingrese una opción valida...");
                                                emple.generarMenuEmpleado();

                                        }
                                    } while (emple.opcEmpleado != 11);
                                }
                                break;
                        }
                    } while (opcCase1 != 3 && opcCase1 != 2 && opcCase1 != 1);
                    break;
                /*
                    *Para el registro de un usuario se consideran dos casos, 1. el usuario es tipo cliente y 2. el usuario es tipo empleado
                    *Ademas, primero se piden los datos del usuario y posteriormente se deben almacenar o "registrar" en el sistema 
                 */
                case 2:
                    int opcCase2;
                    System.out.println("\t\t**REGISTRO USUARIO**");
                    System.out.println("Ingrese el tipo de usuario(1.Cliente/2.Empleado)\n"
                            + "o pulse 3. para regresar:\n");
                    opcCase2 = sc.nextInt();
                    do {
                        switch (opcCase2) {
                            case 1:
                                if (userCliente.contClientesRegistrados == 0) {
                                    userCliente.clientDefault();
                                } else {
                                    userCliente.pedirDatosUsuario();
                                    userCliente.registrarCliente();
                                }
                                break;
                            case 2:
                                if (userEmpleado.contEmpleadosRegistrados == 0) {
                                    userEmpleado.empleDefault();
                                } else {
                                    userEmpleado.pedirDatosUsuario();
                                    userEmpleado.registrarEmpleado();
                                }
                                break;
                            case 3:
                                System.out.println("Regresando...");
                                break;
                            default:
                                System.out.println("Error!, ingrese por favor un valor valido");
                                System.out.println("\t\t**REGISTRO USUARIO**");
                                System.out.println("Ingrese el tipo de usuario(1.Cliente/2.Empleado)\n"
                                        + "o pulse 3. para regresar:\n");
                                opcCase2 = sc.nextInt();

                        }
                    } while (opcCase2 != 3 && opcCase2 != 2 && opcCase2 != 1);
                    break;

                case 3:
                    System.out.println("Gracias por visitarnos, te esperamos pronto!");
                    break;

                default:

                    System.out.println("Error!,por favor ingresar una opción valida");

            }
        } while (opcMenu != 3);
    }

}
