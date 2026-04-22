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

    public void listAllRobots()
    {
        for(Robot robot:robots)
        {
            System.out.println(robot.getTechnicalDescription());
        }
    }

    public void listListOfRobots(List<Robot> robotsList)
    {
        for(Robot robot:robotsList)
        {
            System.out.println(robot.getTechnicalDescription());
        }
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
            if(robot instanceof Terrestrial || robot instanceof Aerial)
            {
                filtered.add(robot);
            }
        }
        return filtered;
    }

    private void printEvaluable(List<Robot> filteredRobots)
    {
        for(Robot robot:filteredRobots)
        {
            if(robot instanceof Terrestrial)
            {
                System.out.println(((Terrestrial) robot).getResistanceReport());
            }
            else if(robot instanceof Aerial)
            {
                System.out.println(((Aerial) robot).getResistanceReport());
            }
        }
    }

    public List<Terrestrial> findRobotsSpeed(int speed)
    {
        List<Terrestrial> filtered = new ArrayList<>();
        for(Robot robot:robots)
        {
            if(robot instanceof Terrestrial)
            {
                filtered.add((Terrestrial) robot);
            }
        }
        List<Terrestrial> faster = filtered.stream().filter(o->o.getMaxSpeed()>speed).toList();
        return faster;
    }

    public void showTerrestrial(List<Terrestrial> faster)
    {
        for(Robot robot:faster)
        {
            System.out.println(robot.getTechnicalDescription());
        }
    }
}
