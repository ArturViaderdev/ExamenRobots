import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<Robot> robots = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String textDate = "2025 09 06";
        LocalDate buildDate = LocalDate.parse(textDate,formatter);
        Terrestrial tankbot = new Terrestrial("Tankbot" ,"Robocorp",2022,buildDate,40,Traction.ORUGAS);
        robots.add(tankbot);
        textDate = "2021 09 06";
        buildDate = LocalDate.parse(textDate,formatter);
        Aquatic aquaRunner = new Aquatic("AquaRunner","AquaTech", 2021,buildDate,500,Propulsion.HELICE);
        robots.add(aquaRunner);
        textDate = "2023 09 06";
        buildDate = LocalDate.parse(textDate,formatter);
        Aerial skyDancer = new Aerial("SkyDancer","AeroDynamics",2023,buildDate,3000,90);
        robots.add(skyDancer);
        listAllRobots(robots);
        System.out.println("Buscando robots de Robocorp");
        searchRobotByBuilder("Robocorp", robots);
        System.out.println("Filtrando robots evaluables.");
        List<Robot> evaluable = filterEvaluable(robots);
        printResistance(evaluable);
    }

    public static void printResistance(List<Robot> robots)
    {
        for(Robot robot:robots)
        {
            System.out.println(robot.getResistanceReport());
        }
    }

    public static List<Robot> filterEvaluable(List<Robot> robots)
    {
        List<Robot> filtered = new ArrayList<>();
        for(Robot robot:robots)
        {
            if(robot instanceof Terrestrial || robot instanceof Aerial)
            {
                filtered.add(robot);
            }
        }
        return filtered;
    }

    public static void searchRobotByBuilder(String builder, List<Robot> robots)
    {
        List<Robot> filtered = robots.stream().filter(e -> e.getBuilder().equals(builder)).toList();
        listAllRobots(filtered);
    }

    public static void listAllRobots(List<Robot> robots)
    {
        for(Robot robot:robots)
        {
            System.out.println(robot.getTechnicalDescription());
        }
    }

}
