public class Receta {
    private String nomRec;
    private String pasRec;
    private int calRec;
    public static Receta[] recetas = new Receta[5];
    public static int CantRecetas = 0;

    public Receta() {
        this("Arroz con pollo.",
                "Coloque la pechuga de pollo, 5 tazas de agua y el resto de ingredientes para el caldo en una olla mediana.Poner a hervir, tapar y bajar el fuego a medio-bajo.\n Cocine durante 20 a 25 minutos. Apague el fuego y deje el pollo en la olla durante unos 15 minutos cubierto. Dejar enfriar, desmechar y reservar.\n Colar el caldo de pollo y medir 2 y ½ tazas y reservarlo.\n En una olla mediana, caliente el aceite de oliva a fuego medio-alto.\n Añadir la cebolla, el pimentón verde, el ajo y el pimientón rojo. Cocine hasta que la cebolla estué transparente, unos 4 a 5 minutos.\n Añadir el arroz, la pasta de tomate, el caldo de pollo y sazón. Revuelva hasta que el arroz esté bien cubierto unos 3 minutos.\n Añadir el caldo de pollo y poner a hervir. Luego, reduzca el fuego a bajo.\n Tape y cocine a fuego lento durante unos 15 minutos. Añadir las arvejas, las zanahorias y las habichuelas y cocinar durante 7 minutos muás, añadir el pollo y el cilantro picado, mezclar bien con un tenedor, tapar y cocinar por 5 minutos más.\n");
    }

    public Receta(String n, String p) {
        this.nomRec = n;
        this.pasRec = p;
        if (CantRecetas > 0) {
            System.out.println("\nLa receta ha sido añadida correctamente.\n");
        }
        recetas[CantRecetas] = this;
        CantRecetas++;
    }

    @Override
    public String toString() {
        return nomRec + "\n" + pasRec;
    }

    public static String mostrarRecetas() {
        String str = "";
        for (int i = 0; i < CantRecetas; i++) {
            str += "Receta: " + (i + 1) + ". " + recetas[i].toString() + "\n\n";
        }
        return str;
    }

    public static String buscarReceta(String b) {
        String str = "";
        for (int i = 0; i < CantRecetas; i++) {
            if (b == recetas[i].nomRec) {
                str += recetas[i].toString();
            }
        }
        return str;
    }

    public void delete() {
        this.nomRec = "";
        this.pasRec = "";

    }
}
