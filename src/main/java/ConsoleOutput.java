import java.util.List;

public class ConsoleOutput {
    public ConsoleOutput()
    {

    }

    public void writeList(List<String> list)
    {
        for(String element:list)
        {
            System.out.println(element);
        }
    }
}
