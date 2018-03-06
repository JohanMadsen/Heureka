import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Map_Model extends Model {
    private  HashMap<String,List<Edge>> edges;
    private  HashMap<String,Node> nodes;
    private  Node start;
    private Node goal;
    public Map_Model(String fileName){
        this.edges=new HashMap<>();
        this.nodes= new HashMap<>();
        loadmap(fileName);
    }

    public class Map_State extends State {
        private int x;
        private int y;
        private double g;
        private double h;
        private List<Map_Action> edges;
        private List<String> path;
        public Map_State(int x, int y, double g, double h, List<Edge> edges) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
            this.edges = edges;
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




    public class Map_Action extends Action{

    }


    @Override
    double stepCost(State s, Action a) {
        return 0;
    }

    @Override
    List[] actions(State s) {
        return new List[0];
    }

    @Override
    State results(State s, Action a) {
        return null;
    }

    @Override
    boolean goalTest(State s) {
        return s.equals(goal);
    }

    public void setStart(Node node){
        start=node;
    }
    public void setGoal(Node node){
        goal=node;
    }
    public Node getStart(){
        return start;
    }
    public Node getGoal(){
        return goal;
    }

    private void loadmap(String fileName){
        try{
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] split=strLine.split("\\s+");
                for (int i = 0; i <2 ; i++) {
                    String key=split[i*3]+"s"+split[1+i*3];
                    if(!nodes.containsKey(key)){
                        Node node = new Node(Integer.parseInt(split[i*3]),Integer.parseInt(split[i*3+1]),0,0,new ArrayList<>());
                        nodes.put(node.toString(),node);
                    }
                }
                String key1=split[0]+"s"+split[1];
                String key2=split[3]+"s"+split[4];
                Node start=nodes.get(key1);
                Node end = nodes.get(key2);
                Edge edge = new Edge(start,end,split[2]);
                start.addEdge(edge);
                if(!edges.containsKey(edge.getName())){
                    edges.put(edge.getName(),new ArrayList<>());
                    edges.get(edge.getName()).add(edge);

                }
                else {
                    edges.get(edge.getName()).add(edge);
                }
            }
            in.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return;
    }
    public Node findNode(String street1, String street2){
        List<Edge> edgesWithName1=edges.get(street1);
        List<Edge> edgesWithName2=edges.get(street2);
        for (Edge e1:edgesWithName1) {
            for (Edge e2:edgesWithName2){
                if(e1.getStart().equals(e2.getStart())||e1.getStart().equals(e2.getEnd())){
                    return e1.getStart();
                }
                else if(e1.getEnd().equals(e2.getStart())||e1.getEnd().equals(e2.getEnd())){
                    return e1.getEnd();
                    return e1.getEnd();
                }
            }
        }
        return edgesWithName1.get(0).getStart();
    }


}
