import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by johan_000 on 20-03-2018.
 */
public class Logic_State implements State {
    private Clause clause;
    private double f;
    private double h;
    private  double g;
    List<String> path;
    public Logic_State(Clause clause, double g, double h) {
        this.clause=clause;
        this.g=g;
        this.h=h;
        this.f=g+h;
        this.path= new LinkedList<>();

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
        path.add(edgeName);
        setPath(path);
    }

    @Override
    public List<String> getPath() {
        return path;
    }

    @Override
    public void setG(double g) {
        this.g = g;
        this.f=this.g+this.h;
    }

    @Override
    public void setH(double h) {
        this.h = h;
        this.f=this.g+this.h;
    }

    @Override
    public double getF() {
        return f;
    }

    @Override
    public double getG() {
        return g;
    }

    public Set<String> getPositive() {
        return clause.getPositive();
    }

    public Set<String> getNegative() {
        return clause.getNegative();
    }


    public boolean equals(Logic_State state){
       return  state.getPositive().equals(this.clause.getPositive())&&state.getNegative().equals(this.clause.getNegative());
    }
}
