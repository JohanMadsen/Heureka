
/**
 * Created by johan_000 on 27-02-2018.
 */
public class Edge {
    private Node start;
    private Node end;
    private String name;
    private double length;
    public Edge(Node start,Node end,String name){
        this.start=start;
        this.end=end;
        this.name=name;
        this.length=Math.sqrt(Math.abs(end.getX()-start.getX())+Math.abs(end.getY()-start.getY()));
    }
}
