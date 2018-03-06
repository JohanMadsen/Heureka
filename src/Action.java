import java.util.List;

/**
 * Created by johan_000 on 06-03-2018.
 */
public abstract class Action {
     String name;
    private double cost;

    public Action(String name, double cost){
        this.name=name;
        this.cost=cost;
    }

    public String getName(){
        return name;
    }
    public double getCost(){
        return cost;
    }
}