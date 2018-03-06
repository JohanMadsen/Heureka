/**
 * Created by johan_000 on 06-03-2018.
 */
public class Map_Action implements Action {
    private Map_State start;
    private Map_State end;
    private double cost;
    private String name;
    public Map_Action(Map_State start,Map_State  end,String name){
        this.name=name;
        this.cost=Math.sqrt(Math.abs(end.getX()-start.getX())+Math.abs(end.getY()-start.getY()));
        this.start=start;
        this.end=end;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    public Map_State getStart(){
        return start;
    }
    public Map_State getEnd(){
        return end;
    }
}
