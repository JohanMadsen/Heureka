import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Main {

    public static void main(String[] args) {
        String fileName = "manhattan.txt";
        Map_Model mapModel = new Map_Model(fileName);
        Map_State node= mapModel.findNode("street_0","avenue_0");
        mapModel.setStartState(node);
        node= mapModel.findNode("street_0","avenue_3");
        mapModel.setGoalState(node);
        System.out.println(mapModel.actions(mapModel.getStartState()).get(1).getName());
        //List<String> path = GraphSearch.graphSearch(mapModel);
        //System.out.println(path);
    }

}
