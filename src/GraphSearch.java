import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class GraphSearch {
    public static List<String> graphSearch(Model model){
        HashSet<String> expandedNodes = new HashSet<>();
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(model.getStart());
        while (frontier.size()>0){
            Node n = frontier.remove();
            if(model.goalTest(n)){
                return n.getPath();
            }
            List<Edge> edges = n.getEdges();
            for (Edge edge:edges) {
                System.out.println(edge.getStart().toString()+ " "+n.toString());
                System.out.println(frontier.contains(edge.getEnd()));
                if((!frontier.contains(edge.getEnd()))&(!expandedNodes.contains(edge.getEnd().toString()))){
                    edge.getEnd().setPath(edge.getEnd().getPath(),edge.getName());
                    frontier.add(edge.getEnd());
                }
            }
            expandedNodes.add(n.toString());

        }
        return null;
    }
}
