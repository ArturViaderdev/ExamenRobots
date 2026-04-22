import java.time.LocalDate;

public class Terrestrial extends Robot implements ResistanceOk{
    private int maxSpeed;
    private Traction tractionType;

    public Terrestrial(String name, String builder, int year, LocalDate registerDate, int maxSpeed, Traction tractionType) {
        this.maxSpeed = maxSpeed;
        this.tractionType = tractionType;
        super(name, builder, year, registerDate);
    }

    @Override
    public String getTechnicalDescription() {
        return getName() +" fabricado por " + getBuilder() + " en " + Integer.toString(getYear()) + ", usa tracción " + tractionType.toString() + " y alcanza hasta " + maxSpeed + " km/h";
    }

    @Override
    public String getResistanceReport() {
        if(tractionType.equals(Traction.ORUGAS))
        {
            return("Tracción ORUGAS confirmada. Apto para la competición.");
        }
        else
        {
            return("No es tracción orugas. No apto para la competición.");
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
