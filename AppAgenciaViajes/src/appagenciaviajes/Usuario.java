/*
*Fecha de cleación: 31/10/2021
*Esta clase se encarga de tratar con la información de todos los usuarios, posee las erramientas para la creacción de un usuario, sea de tipo
*cliente o de tipo empleado, además, tambien permite registrar la información de los usuaios (cliente o empleado), al igual que 
*posee un metodo el cuál permitiria verificar la exitencia de un usuario (cliente o empleado)que desea ingresar al sistema.
*/
package appagenciaviajes;
import java.util.Scanner;
/**
 * @author Juan David
 */
public class Usuario {

    String nombreUsuario, contrasegna;
    int contEmpleadosRegistrados = 0, contClientesRegistrados = 0;
    Scanner sc = new Scanner(System.in);
    Cliente clientes[] = new Cliente[100];
    Empleado empleados[] = new Empleado[100];
    
    /*
    *Cliente default para pruebas
    */
    void clientDefault(){
        clientes[0] = new Cliente(); 
        clientes[0].usuario = "Carlos";
        clientes[0].contrasegna = "1234";
        clientes[0].nombre = "Carlos";
        clientes[0].Id = 1020150021;
        clientes[0].tipoCliente = "oro";
        clientes[0].email = "Carlos01@gmail.com";
        clientes[0].nombreContactoEmer = "Luis Rojas";
        clientes[0].numeroContactoEmer = 5091231;
        contClientesRegistrados++;
        System.out.println("Usuario creado con exito! Gracias por elegirnos...");
    }
    /*
    *Usuario default para pruebas
    */
    void empleDefault(){
        empleados[0] = new Empleado(); 
        empleados[0].nombreUsuario = "Sara";
        empleados[0].contrasegna = "1234";
        contEmpleadosRegistrados++;
        System.out.println("Usuario creado con exito! Gracias por elegirnos...");
    }
    /*
    *Este método se encarga de pedir los datos a un usuario que intente crear o ingresar a una cuenta
    */
    void pedirDatosUsuario() {
        System.out.println("Ingrese su nombre de usuario: ");
        nombreUsuario = sc.next();
        System.out.println("Ingrese su contraseña: ");
        contrasegna = sc.next();

    }
    /*
    *Este método permite registar un usuario de tipo cliente en el sistema, con un nombre de usuario y contraseña
    */
    void registrarCliente() {
        clientes[contClientesRegistrados] = new Cliente();
        clientes[contClientesRegistrados].usuario = nombreUsuario;
        clientes[contClientesRegistrados].contrasegna = contrasegna;
        contClientesRegistrados++;
        System.out.println("Usuario creado con exito! Gracias por elegirnos...");

    }
    /*
    *Este método me permite conocer mediante un valor de verdad, si el usuario tipo cliente que intenta ingresar al sistema, ya ha sido creado
    *al igual que verifica si los datos que ingresa de nombre de usuario y estan registrados en el sistema, de no ser así, presenta unas opciones 
    *a elegir para el usuario
    */
    boolean verificarRegistroCliente() {
        boolean userEncontrado = false;
        int opc;
        while (userEncontrado == false) {
            for (int i = 0; i < contClientesRegistrados; i++) {
                if (nombreUsuario.equals(clientes[i].usuario) && contrasegna.equals(clientes[i].contrasegna)) {
                    
                    userEncontrado = true;
                
                }
            }
            if (userEncontrado == false) {
                do {
                    System.out.println("El Usuario no existe/Usuario o contraseña erroneos...");
                    System.out.println("Desea: \n"
                            + "1.Reintentar\n"
                            + "2.Volver al menú anterior\n");
                    opc = sc.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.println("Por favor ingrese nuevamente los datos...");
                            System.out.println("Ingrese su nombre de usuario: ");
                            nombreUsuario = sc.next();
                            System.out.println("Ingrese su contraseña: ");
                            contrasegna = sc.next();
                            for (int i = 0; i < contClientesRegistrados; i++) {
                                if (nombreUsuario.equals(clientes[i].usuario) && contrasegna.equals(clientes[i].contrasegna)) {
                                    userEncontrado = true;
                                    opc = 2;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Volviendo al menú principal...");
                            
                            break;

                        default:
                            System.out.println("Por favor, ingrese una de las opciones permitidas");
                              
                    }
                } while (opc != 2);
                break;
            }

        }
        return userEncontrado;
    }
    /*
    *Este método permite registar un usuario de tipo empleado en el sistema, con un nombre de usuario y contraseña
    */
    void registrarEmpleado() {
        empleados[contEmpleadosRegistrados] = new Empleado();
        empleados[contEmpleadosRegistrados].nombreUsuario = nombreUsuario;
        empleados[contEmpleadosRegistrados].contrasegna = contrasegna;
        contEmpleadosRegistrados++;
        System.out.println("Usuario creado con exito! Sera un gusto tenerte en nuestro equipo...");
    }
    /*
    *Este método me permite conocer mediante un valor de verdad, si el usuario tipo usuario que intenta ingresar al sistema, ya ha sido creado
    *al igual que verifica si los datos que ingresa de nombre de usuario y estan registrados en el sistema, de no ser asi presenta unas opciones 
    *a elegir para el usuario
    */
    boolean verificarRegistroEmpleado() {
        boolean userEncontrado = false;
        int opc;
        while (userEncontrado == false) {
            for (int i = 0; i < contEmpleadosRegistrados; i++) {
                if (nombreUsuario.equals(empleados[i].nombreUsuario) && contrasegna.equals(empleados[i].contrasegna)) {   
                    userEncontrado = true;                
                }
            }
            if (userEncontrado == false) {
                do {
                    System.out.println("El usuario no existe/Usuario o contraseña erroneos...");
                    System.out.println("Desea: \n"
                            + "1.Reintentar\n"
                            + "2.Volver al menú anterior\n");
                    opc = sc.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.println("Por favor ingrese nuevamente los datos...");
                            System.out.println("Ingrese su nombre de usuario: ");
                            nombreUsuario = sc.next();
                            System.out.println("Ingrese su contraseña: ");
                            contrasegna = sc.next();
                            for (int i = 0; i < contEmpleadosRegistrados; i++) {
                                if (nombreUsuario.equals(empleados[i].nombreUsuario) && contrasegna.equals(empleados[i].contrasegna)) {
                                    userEncontrado = true;
                                    opc = 2;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Volviendo al menú principal...");
                            break;

                        default:
                            System.out.println("Por favor, ingrese una de las opciones permitidas");
                            
                    }
                } while (opc != 2);
                break;
            }

        }
        return userEncontrado;
    }

}
