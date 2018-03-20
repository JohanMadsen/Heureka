import java.util.Set;

/**
 * Created by johan_000 on 20-03-2018.
 */
public class Logic_Action implements Action{
    private Clause clause;
    private double cost;
    private String name;

    public Logic_Action(Clause clause,String name){
        this.name=name;
        this.cost=1.0;
        this.clause=clause;
    }

    @Override
    public double getCost() {
        return cost;
    }

    public Set<String> getPositive() {
        return clause.getPositive();
    }

    public Set<String> getNegative() {
        return clause.getNegative();
    }

    @Override
    public String getName() {
        return name;
    }
}
