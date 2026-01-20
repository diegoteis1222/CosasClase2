
public class LanzadorProcesos {

    public void ejercutar(String ruta) {
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(ruta);
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ruta = "C:\\Users\\Diego\\Documents\\Pogramas\\rufus-4.11p.exe";
        LanzadorProcesos lp = new LanzadorProcesos();
        lp.ejercutar(ruta);
    }
}
