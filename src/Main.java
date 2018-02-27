import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Main {

    public static void main(String[] args) {
        String fileName = "manhattan.txt";
        Model model = new Model(fileName);
        Node node=model.findNode("street_0","avenue_0");
        model.setStart(node);
        node=model.findNode("street_6","avenue_7");
        model.setGoal(node);
        List<String> path = GraphSearch.graphSearch(model);
        System.out.println(path);
    }

}
