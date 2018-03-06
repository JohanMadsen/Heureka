import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class GraphSearch {
    public static List<String> graphSearch(Model model){
/*
        HashSet<String> expandedNodes = new HashSet<>();
        Queue<State> frontier = new LinkedList<>();
        frontier.add(model.getStartState());

        while (frontier.size()>0){
            State n = frontier.remove();

            if(model.goalTest(n)){
                return n.getPath();
            }

            List<model.> actions = model.actions(n);
            for (int i =0; i<edges.size();i++) {
                Edge edge = edges.get(i);
                if((!frontier.contains(edge.getEnd())) && (!expandedNodes.contains(edge.getEnd().toString()))){
                    edge.getEnd().setPath(n.getPath(),edge.getName());
                    frontier.add(edge.getEnd());
                }
            }
            expandedNodes.add(n.toString());
        }
        */
        return null;

    }

}
