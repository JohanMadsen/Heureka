import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Main {

    public static void main(String[] args) {
        String fileName = "manhattan.txt";
        Map_Model mapModel = new Map_Model(fileName);
        Node node= mapModel.findNode("street_0","avenue_0");
        mapModel.setStart(node);
        node= mapModel.findNode("street_0","avenue_3");
        mapModel.setGoal(node);
        List<String> path = GraphSearch.graphSearch(mapModel);
        System.out.println(path);
    }

}
