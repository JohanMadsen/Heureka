import java.util.List;

/**
 * Created by johan_000 on 06-03-2018.
 */

public abstract class Model<S extends State,A extends Action> {

    // declare fields
    private S goalState;
    private S startState;
    abstract boolean goalTest(S s);
    abstract List<A> actions(S s );
    abstract double stepCost(S s ,A a);
    abstract S results(S s,A a);

    public Model(){

    }
    public void setGoalState(S s){
        goalState=s;
    }
    public void setStartState(S s){
        startState=s;
    }
    public S getGoalState(){
        return goalState;
    }
    public S getStartState(){
        return startState;
    }

}
