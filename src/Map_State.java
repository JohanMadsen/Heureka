import java.util.LinkedList;
import java.util.List;

/**
 * Created by johan_000 on 06-03-2018.
 */
public class Map_State extends State {
    private int x;
    private int y;
    private List<Action> actions;
    public Map_State(int x, int y, double g, double h) {
        super(g,h,new LinkedList<>());
        this.x = x;
        this.y = y;
        this.actions=new LinkedList<>();

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void extendPath(List<String> currentPath ,String edgeName){
        List<String> path=new LinkedList<>();
        for(String s : currentPath) {
            path.add(s);
        }
        if(path.size()==0||!path.get(path.size() - 1).equals(edgeName)){
            path.add(edgeName);
        }
        setPath(path);
    }
    public void addAction(Map_Action a){
        actions.add(a);
    }
    public boolean equals(Map_State s){
        return (s.x==x)&(s.y==y);
    }
    public String toString(){
        return Integer.toString(x)+"s"+Integer.toString(y);
    }
}