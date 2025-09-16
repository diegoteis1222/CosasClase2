public class testHerencia {

    public static void main(String[] args) {

        productos producto = new productos("mañana", 1);
        productosFrescos fresco = new productosFrescos("hoy", 2, "ayer", "Andorra");
        productosRefrigerados refrigerado = new productosRefrigerados("nose", 3, 12);
        productosCongelados congelado = new productosCongelados("algun dia", 134, 0);
        congeladosAgua agua = new congeladosAgua("si", 1231, 1, "algo");
        congeladosAire aire = new congeladosAire("paco", 83574, 4, "hola");
        congeladosNitrogeno nitrogeno = new congeladosNitrogeno("yolo", 1284747, 4, "si", 12);

        System.out.println("=== Producto ===");
        System.out.println(producto);

        System.out.println("\n=== Producto Fresco ===");
        System.out.println(fresco);

        System.out.println("\n=== Producto Refrigerado ===");
        System.out.println(refrigerado);

        System.out.println("\n=== Producto Congelado ===");
        System.out.println(congelado);

        System.out.println("\n=== Congelado por Aire ===");
        System.out.println(aire);

        System.out.println("\n=== Congelado por Agua ===");
        System.out.println(agua);

        System.out.println("\n=== Congelado por Nitrógeno ===");
        System.out.println(nitrogeno);

    }

}
