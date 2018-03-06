import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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



    public  List<String> graphSearch(){
        HashSet<String> expandedNodes = new HashSet<>();
        Queue<S> frontier = new LinkedList<>();
        frontier.add(getStartState());

        while (frontier.size()>0){
            S n = frontier.remove();
            if(goalTest(n)){
                return n.getPath();
            }

            List<A> possibleActions = actions(n);

            for (int i =0; i<possibleActions.size();i++) {
                A action = possibleActions.get(i);
                S child =results(n,action);
                if((!frontier.contains(child)) && (!expandedNodes.contains(child.toString()))){
                    child.extendPath(n.getPath(),action.getName());
                    frontier.add(child);
                }
            }
            expandedNodes.add(n.toString());
        }
        return null;

    }







}
