import java.util.Set;

/**
 * Created by johan_000 on 20-03-2018.
 */
public class Clause {
    private Set<String> positive;
    private Set<String> negative;
    public Clause(Set<String> positive,Set<String> negative){
        this.positive=positive;
        this.negative=negative;

    }

    public Set<String> getPositive() {
        return positive;
    }

    public Set<String> getNegative() {
        return negative;
    }
}
