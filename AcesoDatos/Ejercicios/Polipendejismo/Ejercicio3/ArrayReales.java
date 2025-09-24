public class ArrayReales implements Estadisticas {
    private double[] array;

    public void asignar() {
        Math.random();
        array = new double[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 100;
        }
    }

    public void imprimir() {
        for (double num : array) {
            System.out.printf(num + " \n");
        }
    }

    @Override
    public double minimo() {
        double min = array[0];
        for (double num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = array[0];
        for (double num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @Override
    public double sumatorio() {
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum;
    }

}
