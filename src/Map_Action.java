/**
 * Created by johan_000 on 06-03-2018.
 */
public class Map_Action extends Action {
    private Map_State start;
    private Map_State end;
    public Map_Action(Map_State start,Map_State  end,String name){
        super(name,Math.sqrt(Math.abs(end.getX()-start.getX())+Math.abs(end.getY()-start.getY())));
        this.start=start;
        this.end=end;
    }

    public Map_State getStart(){
        return start;
    }
    public Map_State getEnd(){
        return end;
    }
}
