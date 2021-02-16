import java.util.Scanner;
import javax.swing.text.PasswordView;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class main {

    public static String datos() { // Funcion para la toma de datos
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
        HashMap<Integer, String> food = new HashMap<Integer, String>();
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

        String user = "pedro2001";
        int password = 2020; // Data Usuario y contraseña
        int passwordInput, option;
        String userInput, datos, pedido = "";

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre de Usuario");
        userInput = sc.nextLine();
        System.out.println("Ingrese su Contraseña");
        passwordInput = sc.nextInt();

        if (userInput.equals(user) && passwordInput == password) {

            System.out.println("Bienvenido al Sistema" + " " + user); // caso el usuario ingresa al sistema

            do {
                System.out.println(
                        "\n Menu\n 1. Cambiar la contraseña \n 2. Llenar información \n 3. Pedido \n 4. Salir");
                option = sc.nextInt();

                if (option == 1) {
                    System.out.println("Ingrese su nueva contraseña");
                    password = sc.nextInt();
                    System.out.println("\n Su contraseña a sido actualizada a: " + password + " " + "con exito!!");
                } else if (option == 2) {
                    datos = datos();
                    System.out.println("\n Sus datos son: \n" + datos);
                } else if (option == 3) {
                    pedido = pedido();
                    System.out.println("\n Ha seleccionado: \n" + pedido);
                } else if (option == 4) {
                    if (pedido.equals("")) {
                        System.out.println("Esperamos verte pronto. cierre de sesion a las: " + horaPedido());
                    } else {
                        System.out.println("\n Su pedido de: " + pedido + " se realizo con exito a la hora: "
                                + horaPedido() + " El mismo sera enviado a domicilio, Disfrute su compra :D");
                    }

                } else {
                    System.out.println("Ingrese una opcion valida");
                }
            } while (option != 4);

        } else if (userInput.equals(user)) {
            System.out.println("Error, la contraseña es incorrecta!!"); // caso que la contraseña es incorrecta
        } else {
            System.out.println("Error, el usuario es incorrecto!!"); // caso donde el usuario es incorrecto
        }

    }

}