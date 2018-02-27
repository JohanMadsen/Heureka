import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Node {
    private int x;
    private int y;
    private List<Edge> edges;
    public Node(int x, int y, List<Edge> edges){
        this.x=x;
        this.y=y;
        this.edges=edges;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public List<Edge> getEdges(){
        return edges;
    }
}
