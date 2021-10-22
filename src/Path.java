import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {

    List<String> nodelist = new ArrayList<>();

    public void add(String node){
            nodelist.add(node);
    }

    @Override
    public String toString() {
        String output ="";
        for(var item : nodelist) output+= item + " -> ";
        return output.substring(0,output.length()-4);
    }
}
