
public class resolucionEcuacion {

    public static void main(String[] args) {

        double a = 2;
        double b = 3;
        double c = 1;
        double d = 2;
        double e = 5;
        double f = 4;

        double determinante = a * d - b * c;

        if (determinante == 0) {
            System.out.println("El sistema no tiene solución única.");
        } else {
            double x = (e * d - b * f) / determinante;
            double y = (a * f - e * c) / determinante;

            System.out.println("La solución del sistema es:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println();
        }

        double[][] matriz = pedirMatrizCoeficientes2x2();
        double[] terminos = pedirTerminosIndependientes2x1();
        mostrarSolucion(matriz, terminos);

    }

    public static double[][] pedirMatrizCoeficientes2x2() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double[][] matriz = new double[2][2];

        System.out.println("Ingrese los coeficientes de la matriz 2x2:");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        return matriz;
    }

    public static double[] pedirTerminosIndependientes2x1() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double[] terminos = new double[2];

        System.out.println("Ingrese los términos independientes:");

        for (int i = 0; i < 2; i++) {
            System.out.print("Término independiente [" + (i + 1) + "]: ");
            terminos[i] = scanner.nextDouble();
        }

        return terminos;
    }

    public static double determinante2x2(double[][] matriz) {
        return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
    }

    public static double[] resolverEcuacion2x2(double[][] matriz, double[][] terminos) {
        double det = determinante2x2(matriz);
        if (det == 0) {
            return null; // o lanzar una excepción
        }

        double[][] inversa = new double[2][2];
        inversa[0][0] = matriz[1][1] / det;
        inversa[0][1] = -matriz[0][1] / det;
        inversa[1][0] = -matriz[1][0] / det;
        inversa[1][1] = matriz[0][0] / det;

        double[] resultado = new double[2];
        resultado[0] = inversa[0][0] * terminos[0][0] + inversa[0][1] * terminos[1][0];
        resultado[1] = inversa[1][0] * terminos[0][0] + inversa[1][1] * terminos[1][0];

        return resultado;
    }

    public static double determinanteX(double[][] matriz, double[] terminos) {
        return terminos[0] * matriz[1][1] - matriz[0][1] * terminos[1];
    }

    public static double determinanteY(double[][] matriz, double[] terminos) {
        return matriz[0][0] * terminos[1] - terminos[0] * matriz[1][0];
    }

    public static void mostrarSolucion(double[][] matriz, double[] terminos) {
        double det = determinante2x2(matriz);
        if (det == 0) {
            System.out.println("El sistema no tiene solución única.");
            return;
        }

        double detX = determinanteX(matriz, terminos);
        double detY = determinanteY(matriz, terminos);

        double x = detX / det;
        double y = detY / det;

        System.out.println("La solución del sistema es:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);

    }

    // Tres ecuaciones y tres incognitas (3x3) 
    // a1x + b1y + c1z = d1
    // a2x + b2y + c2z = d2
    // a3x + b3y + c3z = d3
    public static double[][] pedirMatrizCoeficientes3x3() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double[][] matriz = new double[3][3];

        System.out.println("Ingrese los coeficientes de la matriz 3x3:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        return matriz;
    }

    public static double[] pedirTerminosIndependientes3x1() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double[] terminos = new double[3];

        System.out.println("Ingrese los términos independientes:");

        for (int i = 0; i < 3; i++) {
            System.out.print("Término independiente [" + (i + 1) + "]: ");
            terminos[i] = scanner.nextDouble();
        }

        return terminos;
    }

    public static double determinante3x3(double[][] matriz) {
        return matriz[0][0] * (matriz[1][1] * matriz[2][2] - matriz[1][2] * matriz[2][1])
                - matriz[0][1] * (matriz[1][0] * matriz[2][2] - matriz[1][2] * matriz[2][0])
                + matriz[0][2] * (matriz[1][0] * matriz[2][1] - matriz[1][1] * matriz[2][0]);
    }

    public static double determinanteX3(double[][] matriz, double[] terminos) {
        return terminos[0] * (matriz[1][1] * matriz[2][2] - matriz[1][2] * matriz[2][1])
                - matriz[0][1] * (terminos[1] * matriz[2][2] - matriz[1][2] * terminos[2])
                + matriz[0][2] * (terminos[1] * matriz[2][1] - matriz[1][1] * terminos[2]);
    }

    public static double determinanteY3(double[][] matriz, double[] terminos) {
        return matriz[0][0] * (terminos[1] * matriz[2][2] - matriz[1][2] * terminos[2])
                - terminos[0] * (matriz[1][0] * matriz[2][2] - matriz[1][2] * matriz[2][0])
                + matriz[0][2] * (matriz[1][0] * terminos[2] - terminos[1] * matriz[2][0]);
    }

    public static double determinanteZ3(double[][] matriz, double[] terminos) {
        return matriz[0][0] * (matriz[1][1] * terminos[2] - terminos[1] * matriz[2][1])
                - matriz[0][1] * (matriz[1][0] * terminos[2] - terminos[1] * matriz[2][0])
                + terminos[0] * (matriz[1][0] * matriz[2][1] - matriz[1][1] * matriz[2][0]);
    }

    public static double[][] pedirMatrizCoeficientes3x3UnoaUno() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double[][] matriz = new double[3][3];

        System.out.println("Ingrese los coeficientes de la matriz 3x3 uno a uno:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        return matriz;
    }

    public static double[] pedirTerminosIndependientes3x1UnoaUno() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double[] terminos = new double[3];

        System.out.println("Ingrese los términos independientes uno a uno:");

        for (int i = 0; i < 3; i++) {
            System.out.print("Término independiente [" + (i + 1) + "]: ");
            terminos[i] = scanner.nextDouble();
        }

        return terminos;
    }

    public static double[] resolverEcuacion3x3(double[][] matriz, double[] terminos) {
        double det = determinante3x3(matriz);
        if (det == 0) {
            return null; // o lanzar una excepción
        }

        double detX = determinanteX3(matriz, terminos);
        double detY = determinanteY3(matriz, terminos);
        double detZ = determinanteZ3(matriz, terminos);

        double[] resultado = new double[3];
        resultado[0] = detX / det;
        resultado[1] = detY / det;
        resultado[2] = detZ / det;

        return resultado;
    }

    public static void mostrarSoluciones3x3(double[][] matriz, double[] terminos) {
        double det = determinante3x3(matriz);
        if (det == 0) {
            System.out.println("El sistema no tiene solución única.");
            return;
        }

        double detX = determinanteX3(matriz, terminos);
        double detY = determinanteY3(matriz, terminos);
        double detZ = determinanteZ3(matriz, terminos);

        double x = detX / det;
        double y = detY / det;
        double z = detZ / det;

        System.out.println("La solución del sistema es:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);

    }

}
