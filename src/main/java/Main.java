import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        RobotsManager robotsManager = new RobotsManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String textDate = "2025 09 06";
        LocalDate buildDate = LocalDate.parse(textDate,formatter);
        Terrestrial tankbot = new Terrestrial("Tankbot" ,"Robocorp", Year.of(2022),buildDate,40,Traction.ORUGAS);
        robotsManager.addRobot(tankbot);
        textDate = "2021 09 06";
        buildDate = LocalDate.parse(textDate,formatter);
        Aquatic aquaRunner = new Aquatic("AquaRunner","AquaTech", Year.of(2021),buildDate,500,Propulsion.HELICE);
        robotsManager.addRobot(aquaRunner);
        textDate = "2023 09 06";
        buildDate = LocalDate.parse(textDate,formatter);
        Aerial skyDancer = new Aerial("SkyDancer","AeroDynamics",Year.of(2023),buildDate,3000,90);
        robotsManager.addRobot(skyDancer);
        List<String> descriptions = robotsManager.listAllRobots();
        consoleOutput.writeList(descriptions);
        System.out.println("Buscando robots de Robocorp");
        List<Robot> builderRobots = robotsManager.searchRobotByBuilder("Robocorp");
        descriptions = robotsManager.listListOfRobots(builderRobots);
        consoleOutput.writeList(descriptions);
        System.out.println("Filtrando robots evaluables.");
        List<Robot> evaluables = robotsManager.filterEvaluable();
        List<String> evaluations = robotsManager.printEvaluable(evaluables);
        consoleOutput.writeList(evaluations);
        System.out.println("Robots que van a más de 10 kmh");
        List<Terrestrial> faster =  robotsManager.findRobotsSpeed(10);
        descriptions = robotsManager.showTerrestrial(faster);
        consoleOutput.writeList(descriptions);
    }


}
