
import java.io.Serializable;

public class casa implements Serializable {

    private int habitaciones;
    private int baños;
    private boolean trastero;



    public casa(int habitaciones, int baños, boolean trastero) {
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.trastero = trastero;
    }

    public int getHabitaciones() {
        return habitaciones;
    }



    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }



    public int getBaños() {
        return baños;
    }



    public void setBaños(int baños) {
        this.baños = baños;
    }



    public boolean isTrastero() {
        return trastero;
    }



    public void setTrastero(boolean trastero) {
        this.trastero = trastero;
    }

}
