import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by johan_000 on 20-03-2018.
 */
public class Logic_Model extends Model<Logic_State,Logic_Action> {
    Clause start;
    Set<Logic_Action> knowledgeBase;
    private String fileName;
    public Logic_Model(String fileName, Clause clause ){
        this.fileName=fileName;
        this.start = new Clause(clause.getNegative(),clause.getPositive());
        this.knowledgeBase =new HashSet<>();
        setStartState(new Logic_State(start,0,clause.getPositive().size()+clause.getNegative().size()));
        setup();
    }


    @Override
    boolean goalTest(Logic_State logic_state) {
        return logic_state.getPositive().isEmpty()&&logic_state.getNegative().isEmpty();
    }

    @Override
    List<Logic_Action> actions(Logic_State logic_state) {
        List<Logic_Action> actions = new LinkedList<>();
        Iterator<Logic_Action> kbIter = knowledgeBase.iterator();
        while (kbIter.hasNext()) {
            Logic_Action action = kbIter.next();
            Iterator<String> positiveIter = logic_state.getPositive().iterator();
            while (positiveIter.hasNext()){
                String p=positiveIter.next();
                if(action.getNegative().contains(p)){
                    actions.add(action);
                    break;
                }
            }
            Iterator<String> negativeIter = logic_state.getNegative().iterator();
            while (negativeIter.hasNext()){
                String p=negativeIter.next();
                if(action.getPositive().contains(p)){
                    actions.add(action);
                    break;
                }
            }
        }
        return actions;
    }

    @Override
    double stepCost(Logic_State logic_state, Logic_Action logic_action) {
        return logic_action.getCost();
    }

    @Override
    Logic_State results(Logic_State logic_state, Logic_Action logic_action) {
        Set<String> positive = new HashSet<>(logic_state.getPositive());
        positive.addAll(logic_action.getPositive());
        Set<String> negative = new HashSet<>(logic_state.getNegative());
        negative.addAll(logic_action.getNegative());
        Set<String> intersection = new HashSet<>(positive);
        intersection.retainAll(negative);
        positive.removeAll(intersection);
        negative.removeAll(intersection);


        Clause clause = new Clause(positive,negative);
        Logic_State result=new Logic_State(clause,logic_state.getG()+stepCost(logic_state,logic_action),positive.size()+negative.size());
        Logic_Action action=new Logic_Action(clause,clause.toString());
        if(!knowledgeBase.contains(action)){
            knowledgeBase.add(action);
        }
        return result;
    }
    private void setup(){
        try{
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                Set<String> positive= new HashSet<>();
                Set<String> negative= new HashSet<>();
                String[] split=strLine.split("\\s+");

                int ifposition=-1;
                for (int i = 0; i <split.length ; i++) {
                    if(split[i].equals("if"))ifposition=i;
                }
                if(ifposition==-1){
                    for (int i = 0; i <split.length ; i++) {
                        positive.add(split[i]);
                    }
                }
                else {
                    for (int i = 0; i <ifposition ; i++) {
                        positive.add(split[i]);
                    }
                    for (int i = ifposition+1; i <split.length ; i++) {
                        negative.add(split[i]);
                    }
                }
                Set<String>intersection = new HashSet<>(positive);
                intersection.retainAll(negative);
                positive.removeAll(intersection);
                negative.removeAll(intersection);

                Clause clause = new Clause(positive,negative);
                Logic_Action action=new Logic_Action(clause,clause.toString());
                knowledgeBase.add(action);
            }
            in.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }


}

