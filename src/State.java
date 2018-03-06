import java.util.List;

/**
 * Created by johan_000 on 06-03-2018.
 */
public abstract class State {
    private double g;
    private double h;
    private double f;

    private List<String> path;

    public State(double g, double h,List<String> path){
        this.g=g;
        this.h=h;
        this.f=g+h;
        this.path=path;
    }

    public double getF(){
        return f;
    }
    public void setG(double newG){
        g=newG;
        f=g+h;
    }
    public void setF(double newF){
        f=newF;
    }
    public List<String> getPath(){
        return path;
    }
    public void setPath(List<String> newPath){
        path=newPath;
    }

}