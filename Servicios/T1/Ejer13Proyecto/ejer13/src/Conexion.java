import com.db4o.*; 

public class Conexion {

    final static String BDPer = "EMPLEDEP.YAP";
    static ObjectContainer db;

    static {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
    }

    public static ObjectContainer getDBConexion() {
        return db;
    }

    static void cerrarConexion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
} // Fin Conexion
