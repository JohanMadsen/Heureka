import java.util.List;

/**
 * Created by johan_000 on 06-03-2018.
 */

public abstract class Model {

    // declare fields
    private State goalState;
    private State startState;
    // declare nonabstract methods
    abstract boolean goalTest(State s);
    abstract List[] actions(State s );
    abstract double stepCost(State s ,Action a);
    abstract State results(State s,Action a);

    public Model(){

    }

}
