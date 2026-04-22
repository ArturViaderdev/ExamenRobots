import java.util.ArrayList;
import java.util.List;

public class RobotsManager {
    List<Robot> robots;
    public RobotsManager()
    {
        robots = new ArrayList<>();
    }

    public void addRobot(Robot robot)
    {
        robots.add(robot);
    }

    public List<String> listAllRobots()
    {
        List<String> descriptions = new ArrayList<>();
        for(Robot robot:robots)
        {
            descriptions.add(robot.getTechnicalDescription());
        }
        return descriptions;
    }

    public List<String> listListOfRobots(List<Robot> robotsList)
    {
        List<String> descriptions = new ArrayList<>();
        for(Robot robot:robotsList)
        {
            descriptions.add(robot.getTechnicalDescription());
        }
        return descriptions;
    }

    public List<Robot> searchRobotByBuilder(String builder)
    {
        List<Robot> filtered = robots.stream().filter(e -> e.getBuilder().equals(builder)).toList();
        return filtered;
    }

    public List<Robot> filterEvaluable()
    {
        List<Robot> filtered = new ArrayList<>();
        for(Robot robot:robots)
        {
            if(robot instanceof ResistanceOk)
            {
                filtered.add(robot);
            }
        }
        return filtered;
    }

    public List<String> printEvaluable(List<Robot> filteredRobots)
    {
        List<String> resistances = new ArrayList<>();
        for(Robot robot:filteredRobots)
        {
            if(robot instanceof Terrestrial)
            {
                resistances.add(((Terrestrial) robot).getResistanceReport());
            }
            else if(robot instanceof Aerial)
            {
                resistances.add(((Aerial) robot).getResistanceReport());
            }
        }
        return resistances;
    }

    public List<Terrestrial> findRobotsSpeed(int speed)
    {
        return robots.stream().filter(o->o instanceof Terrestrial).map(o->(Terrestrial) o).filter(o->((Terrestrial) o).getMaxSpeed()>speed).toList();
    }

    public List<String> showTerrestrial(List<Terrestrial> faster)
    {
        List<String> descriptions = new ArrayList<>();
        for(Robot robot:faster)
        {
            descriptions.add(robot.getTechnicalDescription());
        }
        return descriptions;
    }
}
