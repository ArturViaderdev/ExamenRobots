import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RobotsTest {
    @Test
    public void newTerrestrialRobotTest()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String textDate = "2025 09 06";
        LocalDate buildDate = LocalDate.parse(textDate,formatter);
        Terrestrial tankbot = new Terrestrial("Tankbot" ,"Robocorp", Year.of(2022),buildDate,40,Traction.ORUGAS);

       Assertions.assertEquals(tankbot.getTechnicalDescription(),"Tankbot fabricado por Robocorp en 2022, usa tracción ORUGAS y alcanza hasta 40 km/h");

    }

    @Test
    public void newAquaticRobotTest()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String textDate = "2021 09 06";
        LocalDate buildDate = LocalDate.parse(textDate,formatter);
        Aquatic aquaRunner = new Aquatic("AquaRunner","AquaTech", Year.of(2021),buildDate,500,Propulsion.HELICE);
        Assertions.assertEquals(aquaRunner.getTechnicalDescription(),"AquaRunner alcanza una profundidad de 500 con propulsión tipo HELICE. Fabricado por AquaTech en 2021.");
    }

    @Test
    public void newAerialRobotTest()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String textDate = "2023 09 06";
        LocalDate buildDate = LocalDate.parse(textDate,formatter);
        Aerial skyDancer = new Aerial("SkyDancer","AeroDynamics",Year.of(2023),buildDate,3000,90);
        Assertions.assertEquals(skyDancer.getTechnicalDescription(),"SkyDancer vuela hasta 3000m durante 90 minutos. Fabricado en 2023 por AeroDynamics.");

    }

    @Test
    public void evaluableRobotsTest()
    {
        RobotsManager robotsManager = new RobotsManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String textDate = "2025 09 06";
        LocalDate buildDate = LocalDate.parse(textDate,formatter);
        Terrestrial tankbot = new Terrestrial("Tankbot" ,"Robocorp",Year.of(2022),buildDate,40,Traction.ORUGAS);
        robotsManager.addRobot(tankbot);
        textDate = "2021 09 06";
        buildDate = LocalDate.parse(textDate,formatter);
        Aquatic aquaRunner = new Aquatic("AquaRunner","AquaTech", Year.of(2021),buildDate,500,Propulsion.HELICE);
        robotsManager.addRobot(aquaRunner);
        textDate = "2023 09 06";
        buildDate = LocalDate.parse(textDate,formatter);
        Aerial skyDancer = new Aerial("SkyDancer","AeroDynamics",Year.of(2023),buildDate,3000,90);
        robotsManager.addRobot(skyDancer);
        List<Robot> evaluable = robotsManager.filterEvaluable();

        boolean ok = true;
        for(Robot robot:evaluable)
        {
            if(robot instanceof Aquatic)
            {
                ok = false;
                break;
            }
        }

    }

    @Test
    public void filterRobotsTest()
    {
        RobotsManager robotsManager = new RobotsManager();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String textDate = "2025 09 06";
        LocalDate buildDate = LocalDate.parse(textDate,formatter);
        Terrestrial tankbot = new Terrestrial("Tankbot" ,"Robocorp",Year.of(2022),buildDate,40,Traction.ORUGAS);
        robotsManager.addRobot(tankbot);
        textDate = "2021 09 06";
        buildDate = LocalDate.parse(textDate,formatter);
        Aquatic aquaRunner = new Aquatic("AquaRunner","AquaTech", Year.of(2021),buildDate,500,Propulsion.HELICE);
        robotsManager.addRobot(aquaRunner);
        textDate = "2023 09 06";
        buildDate = LocalDate.parse(textDate,formatter);
        Aerial skyDancer = new Aerial("SkyDancer","AeroDynamics",Year.of(2023),buildDate,3000,90);
        robotsManager.addRobot(skyDancer);
        List<Robot> filtered = robotsManager.searchRobotByBuilder("Robocorp");
        boolean ok = true;
        for(Robot robot:filtered)
        {
            if(!(robot.getBuilder().equals("Robocorp")))
            {
                ok = false;
                break;
            }
        }
        Assertions.assertTrue(ok);
    }
}
