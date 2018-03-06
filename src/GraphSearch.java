import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class GraphSearch {
    public static List<String> graphSearch(Map_Model mapModel){

        HashSet<String> expandedNodes = new HashSet<>();
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(mapModel.getStart());

        while (frontier.size()>0){
            Node n = frontier.remove();

            if(mapModel.goalTest(n)){
                return n.getPath();
            }

            List<Edge> edges = n.getEdges();
            for (int i =0; i<edges.size();i++) {
                Edge edge = edges.get(i);
                if((!frontier.contains(edge.getEnd())) && (!expandedNodes.contains(edge.getEnd().toString()))){
                    edge.getEnd().setPath(n.getPath(),edge.getName());
                    frontier.add(edge.getEnd());
                }
            }
            expandedNodes.add(n.toString());
        }
        return null;
    }
}
