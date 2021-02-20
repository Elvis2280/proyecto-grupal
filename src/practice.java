import org.graalvm.compiler.nodes.NodeView.Default;

public class practice {
    switch (option){
        case 1: 
            System.out.println("Ingrese su nueva contraseña");
            password = sc.nextInt();
            System.out.println(
                            "\n Su contraseña a sido actualizada a: " + password + " " + "con exito!!");
        case 2:
            datos = datos();
            System.out.println("\n Sus datos son: \n" + datos);
        case 3:
            pedido = pedido();
            System.out.println("\n Ha seleccionado: \n" + pedido);
        case 4:
            if (pedido.equals("")) {
                System.out.println("Esperamos verte pronto. cierre de sesion a las: " + horaPedido());
            } else {
                System.out.println("\n Su pedido de: " + pedido + " se realizo con exito a la hora: "
                        + horaPedido() + " El mismo sera enviado a domicilio, Disfrute su compra :D");
        default:
            System.out.println("Ingrese una opcion valida");
        }
    }
    
}
