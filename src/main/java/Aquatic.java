import java.time.LocalDate;
import java.time.Year;

public class Aquatic extends Robot{
    private int depth;
    private Propulsion propulsion;

    public Aquatic(String name, String builder, int year, LocalDate registerDate, int depth, Propulsion propulsion) {
        this.depth = depth;
        this.propulsion = propulsion;
        super(name, builder, year, registerDate);
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + " alcanza una profundidad de " + depth + " con propulsión tipo " + propulsion.toString() + ". Fabricado por " + getBuilder() + " en " + getYear() + ".";
    }
}
