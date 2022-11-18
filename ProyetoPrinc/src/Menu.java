
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opt;
        Usuario u = new Usuario();
        Receta r = new Receta();
        System.out.println("********************¡Bienvenido!********************" + "\n");
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("(1): Crear cuenta");
            System.out.println("(2): Iniciar sesión");
            System.out.println("(0): Salir");
            opt = Integer.parseInt(br.readLine());
            switch (opt) {
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 0:
                    System.out.println("Has seleccionado salir, Adiós.");
                    break;
                default:
                    System.out.println("Opción no válida, vuelva a intentar.");
            }

        } while (opt != 0);
        br.close();
    }

    public static void iniciarSesion() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cont = 0;
        do {
            System.out.println("\n" + "Ingrese el nombre de usuario.");
            String user = br.readLine();
            System.out.println("Ingrese la contraseña.");
            String pass = br.readLine();
            Usuario.verificacionAdmin(user, pass);
            if (Usuario.adminverif == true) {
                mostrarMenuAdmin();
                cont++;
                break;

            } else if (Usuario.verif == true) {
                mostrarMenu();
                cont++;
                break;
            }

        } while (cont == 0);
    }

    public static void crearUsuario() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = "";
        System.out.println("Ingrese el nombre del nuevo usuario.");
        String u = br.readLine();
        System.out.println("Ingrese el correo electrónico.");
        String e = br.readLine();
        boolean check = false;
        do {
            System.out.println("Ingrese la contraseña.");
            String p1 = br.readLine();
            System.out.println("Confirme la contraseña");
            String p2 = br.readLine();
            if (p1.equals(p2)) {
                p = p1;
                check = true;
                break;
            } else {
                System.out.println("Error, vuelva a intentar");
                try {
                    Thread.sleep(1500);
                } catch (Exception x) {
                }
            }
        } while (check == false);

        Usuario u1 = new Usuario(u, p, e);
    }

    public static void mostrarMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\n***********Bienvenido al menú, ¿Que desea hacer?***********");
        int opc;
        do {
            System.out.println("(1): Ver recetas recomendadas.");
            System.out.println("(2): Buscar una receta.");
            System.out.println("(0): Salir.");
            opc = Integer.parseInt(br.readLine());
            switch (opc) {
                case 1:
                    System.out.println("Las recetas son: ");
                    System.out.println(Receta.mostrarRecetas());
                    break;
                case 2:
                    System.out.println("Ingrese el nombre exacto de la receta.");
                    String busq = br.readLine();
                    System.out.println(Receta.buscarReceta(busq));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    Usuario.verif = false;
                    break;
                default:
                    System.out.println("Opción no válida, vuelva a intentar.");
            }
        } while (opc != 0);
    }

    public static void mostrarMenuAdmin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("************************Bienvenido, Administrador************************\n");
        int opc;
        do {
            System.out.println("(1): Añadir una receta.");
            System.out.println("(2): Remover una receta.");
            System.out.println("(0): Salir");
            opc = Integer.parseInt(br.readLine());
            switch (opc) {
                case 1:
                    System.out.println("Ingrese el nombre de la receta: ");
                    String nom = br.readLine();
                    System.out.println("Ingrese los pasos de la receta: ");
                    String pas = br.readLine();
                    Receta r1 = new Receta(nom, pas);
                    break;
                case 2:
                    System.out.println("¿Cuál receta quiere eliminar?");
                    System.out.println(Receta.mostrarRecetas() + "\n");
                    int elirec = Integer.parseInt(br.readLine());
                    if (elirec > Receta.CantRecetas) {
                        System.out.println("Esta receta no existe.");
                    } else {
                        Receta.recetas[elirec - 1].delete();
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    Usuario.adminverif = false;
                    break;
                default:
                    System.out.println("Opción no valida, vuelva a intentar.");
            }
        } while (opc != 0);

    }

}
