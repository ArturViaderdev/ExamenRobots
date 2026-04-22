import java.time.LocalDate;

public abstract class Robot {
    private String name;
    private String builder;
    private int year;
    private LocalDate registerDate;

    abstract String getTechnicalDescription();
    abstract String getResistanceReport();

    public Robot(String name, String builder,int year, LocalDate registerDate)
    {
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
