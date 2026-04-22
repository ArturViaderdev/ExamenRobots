import java.time.LocalDate;
import java.time.Year;

public abstract class Robot {
    private String name;
    private String builder;
    private int year;
    private LocalDate registerDate;

    abstract String getTechnicalDescription();

    public Robot(String name, String builder,int year, LocalDate registerDate)
    {
        if(name.isEmpty())
        {
            throw new EmptyFieldException();
        }
        this.name = name;
        this.builder = builder;
        this.year = year;
        this.registerDate = registerDate;
    }

    public String getName() {
        return name;
    }

    public String getBuilder() {
        return builder;
    }

    public int getYear() {
        return year;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }
}
