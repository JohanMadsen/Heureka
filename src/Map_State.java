import java.util.LinkedList;
import java.util.List;

/**
 * Created by johan_000 on 06-03-2018.
 */
public class Map_State implements State {
    private int x;
    private int y;
    private double f;
    private double h;
    private  double g;
    List<String> path;
    private List<Map_Action> actions;
    public Map_State(int x, int y, double g, double h) {
        this.g=g;
        this.h=h;
        this.f=g+h;
        this.x = x;
        this.y = y;
        this.path= new LinkedList<>();
        this.actions=new LinkedList<>();

    }

    @Override
    public double getF() {
        return f;
    }

    @Override
    public void setG(double g) {
        this.g = g;
        this.f=this.g+this.h;
    }
    @Override
    public void setF(double f) {
        this.f = f;
    }

    @Override
    public List<String> getPath() {
        return path;
    }

    @Override
    public void setPath(List<String> path) {
        this.path = path;
    }

    @Override
    public void extendPath(List<String> currentPath ,String edgeName){
        for(String s : currentPath) {
            path.add(s);
        }
        if(path.size()==0||!path.get(path.size() - 1).equals(edgeName)){
            path.add(edgeName);
        }
        setPath(path);
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void addAction(Map_Action a){
        actions.add(a);
    }
    public List<Map_Action> getActions(){
        return actions;
    }

    public boolean equals(Map_State s){
        return (s.x==x)&(s.y==y);
    }
    public String toString(){
        return Integer.toString(x)+"s"+Integer.toString(y);
    }
}