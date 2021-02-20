import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class main {

    public static String datos() { // Funcion para la toma de datos -----dato es el nombre de la funcion----
        Scanner sc = new Scanner(System.in);

        String result = "";
        System.out.println("Ingrese su direccion");
        result += "Direccion: " + sc.nextLine() + "\n";
        System.out.println("Ingrese su numero telefonico");
        result += "Telefono: " + sc.nextLine() + "\n";
        System.out.println("Ingrese su DNI");
        result += "DNI: " + sc.nextLine() + "\n";
        System.out.println("Ingrese su Nacionalidad");
        result += "Nacionalidad: " + sc.nextLine() + "\n";

        return result;
    }

    public static String pedido() { // funcion con un map como menu de la aplicacion
        Scanner sc = new Scanner(System.in);
        int orden;
        HashMap<Integer, String> food = new HashMap<Integer, String>(); // se definio el map con valores de enteros y cadenas (el map tiene un nombre de food)
        food.put(1, "Sushi sakana");
        food.put(2, "Ramen estilo Kioto");
        food.put(3, "Onigiri oishii");

        System.out.println(
                "\n Seleccione el pedido que desea realizar: \n 1. Sushi sakana \n 2. Ramen estilo kioto \n 3. Onigiri oishii");
        orden = sc.nextInt();
        return food.get(orden);

    }

    public static String horaPedido() {
        String format = "HH:mm";
        DateTimeFormatter formateo = DateTimeFormatter.ofPattern(format);
        LocalDateTime horaActual = LocalDateTime.now();
        return formateo.format(horaActual);
    }

    public static void main(String[] args) {
        int option, opt2;
        String userInput, passwordInput, password, usuarioActual, datos, pedido = "";

        // datos de usuario y passwords
        List<String> passwords = new ArrayList<String>();
        List<String> users = new ArrayList<String>();
        passwords.add("2020");
        users.add("pedro2001");

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n Bienvenido \n 1. registrarse \n 2. inicio de sesion \n");
            opt2 = sc.nextInt();
            sc.nextLine();

            if (opt2 == 1) {
                System.out.println("Ingrese el nombre de usuario para su cuenta");
                users.add(sc.nextLine());
                System.out.println("Ingrese su contraseña para la cuenta");
                passwords.add(sc.nextLine());

                System.out.println("Cuenta creada con exito!!");

            } else if (opt2 == 2) {
                System.out.println("\n Ingrese su nombre de Usuario");
                userInput = sc.nextLine();
                System.out.println("Ingrese su Contraseña");
                passwordInput = sc.nextLine();

                usuarioActual = userInput;

                if (users.contains(userInput) && passwords.contains(passwordInput)) {

                    System.out.println("\n\nBienvenido al Sistema" + " " + usuarioActual); // caso el usuario ingresa al
                                                                                       // sistema

                    do {
                        System.out.println(
                                "\n Menu\n 1. Cambiar la contraseña \n 2. Llenar información \n 3. Pedido \n 4. Salir \n");  // Menu
                        option = sc.nextInt();
                        sc.nextLine();
                        switch (option){
                            case 1: 
                                System.out.println("Ingrese su nueva contraseña: ");
                                password = sc.nextLine();
                                                 
                                for(int i = 0; i <= passwords.size()-1; i++ ){

                                    if (passwords.get(i).equals(passwordInput) ){
                                        passwords.set(i, password);
                                    }
                                }
                                System.out.println(
                                                "\n Su contraseña a sido actualizada a: " + password + " " + "con exito!!");
                                System.out.println(passwords);
                                break;
                            case 2:
                                datos = datos();
                                System.out.println("\n Sus datos son: \n" + datos);
                                break;
                            case 3:
                                pedido = pedido();
                                System.out.println("\n Ha seleccionado: \n" + pedido);
                                break;
                            case 4:
                                if (pedido.equals("")) {
                                    System.out.println("Esperamos verte pronto. cierre de sesion a las: " + horaPedido());
                                } else {
                                    System.out.println("\n Su pedido de: " + pedido + " se realizo con exito a la hora: "
                                            + horaPedido() + " El mismo sera enviado a domicilio, Disfrute su compra :D");
                                }
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida");
                                break;
                            }
                        
                    } while (option != 4);

                } else if (users.contains(userInput)) {
                    System.out.println("Error, la contraseña es incorrecta!!"); // caso que la contraseña es incorrecta
                } else {
                    System.out.println("Error, el usuario es incorrecto!!"); // caso donde el usuario es incorrecto
                }

            }
        } while (opt2 != 2);
    }

}