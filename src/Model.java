import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Model {
    private  HashMap<String,List<Edge>> edges;
    private  HashMap<String,Node> nodes;
    private  Node start;
    private Node goal;
    public Model(String fileName){
        this.edges=new HashMap<>();
        this.nodes= new HashMap<>();
        loadmap(fileName);
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
                }
            }
        }
        return edgesWithName1.get(0).getStart();
    }
    public boolean goalTest(Node node){
        return node.equals(goal);
    }

}
