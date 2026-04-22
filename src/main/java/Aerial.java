import java.time.LocalDate;
import java.time.Year;

public class Aerial extends Robot implements ResistanceOk{
    private int altitude;
    private int autonomy;

    public Aerial(String name, String builder, int year, LocalDate registerDate, int altitude, int autonomy) {
        this.altitude = altitude;
        this.autonomy = autonomy;
        super(name, builder, year, registerDate);
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + " vuela hasta " + altitude + "m durante " + autonomy + " minutos. Fabricado en " + getYear() + " por " + getBuilder()+ ".";
    }

    @Override
    public String getResistanceReport() {
        if(autonomy>=60)
        {
            return "Autonomía de " + autonomy + " minutos. Apto para la competición.";
        }
        else
        {
            return "Autonomía de " + autonomy + " minutos. No apto para la competición.";
        }
    }
}
