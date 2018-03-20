import java.util.Arrays;
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

    @Override
    public String toString() {
        String string;
        String[] pos = new String[positive.size()];
        int count=0;
        for(String l : positive){
            pos[count]=l;
            count++;
        }
        Arrays.sort(pos);
        String[] neg = new String[negative.size()];
        count=0;
        for(String l : negative){
            neg[count]=l;
            count++;
        }
        Arrays.sort(neg);
        string = Arrays.toString(pos)+"1"+Arrays.toString(neg);
        return string;
    }
}
