
public class Usuario {
    private String usuario;
    private String pass;
    private String email;
    public static int userlength = 0;
    public static boolean verif = false;
    public static boolean adminverif = false;
    public static Usuario[] usuarios = new Usuario[10];
    public static Usuario[] Admon = { new Usuario("Admin", "232122") };

    public Usuario() {
        this("Daniel", "123", "aaa@gmail.com");
        usuarios[userlength] = this;
        userlength++;
    }

    public Usuario(String a, String p) {
        this.usuario = a;
        this.pass = p;
    }

    public Usuario(String u, String p, String e) {
        this.usuario = u;
        this.email = e;
        this.pass = p;
        if (userlength > 0) {
            System.out.println("\nEl usuario ha sido registrado correctamente.\n");
        }
        usuarios[userlength] = this;
        userlength++;
    }

    /**
     * @param u
     * @param p
     */
    public static void verificacionAdmin(String u, String p) {
        int cont = 0;
        do {
            if (u.equals(Admon[0].usuario)) {
                if (p.equals(Usuario.Admon[0].getPass())) {
                    Usuario.adminverif = true;
                    System.out.println("Has ingresado con éxito en modo administrador.");
                    cont = 1;
                    break;
                } else if (!p.equals(Usuario.Admon[0].getPass())) {
                    System.out.println("Contraseña de acceso administrador equivocada.");
                    cont++;
                }
            } else {
                System.out.println(verificacion(u, p));
                cont++;
                break;
            }
        } while (cont == 0);
    }

    public static String verificacion(String u, String p) {
        boolean check1 = false;
        for (int i = 0; i < userlength; i++) {
            if (usuarios[i].usuario.equals(u) && usuarios[i].pass.equals(p)) {
                check1 = true;
            }
        }

        if (check1) {
            verif = true;
            check1 = false;
            return "Has iniciado sesión exitosamente.";

        } else {
            return "Inicio de sesión fallido";
        }

    }

    public String getUser() {
        return this.usuario;
    }

    public String getPass() {
        return this.pass;
    }

}
