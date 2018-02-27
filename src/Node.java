import java.util.LinkedList;
import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Node {
    private int x;
    private int y;
    private double g;
    private double h;
    private List<Edge> edges;
    private List<String> path;
    public Node(int x, int y, double g, double h, List<Edge> edges){
        this.x=x;
        this.y=y;
        this.g=g;
        this.h=h;
        this.edges=edges;
        this.path = new LinkedList<>();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getG(){
        return g;
    }
    public double getH(){
        return h;
    }
    public void setPath(List<String> currentPath ,String edgeName){
        for(String s : currentPath) {
            path.add(s);
        }
        if(path.size()==0||!path.get(path.size() - 1).equals(edgeName)){
            path.add(edgeName);
        }
    }
    public  List<String> getPath(){
        return path;
    }
    public List<Edge> getEdges(){
        return edges;
    }
    public void addEdge(Edge edge){
        edges.add(edge);
    }
    public boolean equals(Node node){
        return (node.x==x)&(node.y==y);
    }
    public String toString(){
        return Integer.toString(x)+"s"+Integer.toString(y);
    }
}
