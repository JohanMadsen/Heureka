import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Map_Model extends Model<Map_State,Map_Action> {
    private  HashMap<String,List<Map_Action>> actions;
    private  HashMap<String, Map_State> states;
    public Map_Model(String fileName){
        this.actions=new HashMap<>();
        this.states= new HashMap<>();
        loadmap(fileName);
    }


    @Override
    double stepCost(Map_State s, Map_Action a) {
        return 0;
    }

    @Override
    List<Map_Action> actions(Map_State s) {
        return  s.getActions();
    }

    @Override
    Map_State results(Map_State s, Map_Action a) {
        return a.getEnd();
    }

    @Override
    boolean goalTest(Map_State s) {
        return s.equals(getGoalState());
    }


    private void loadmap(String fileName){
        try{
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] split=strLine.split("\\s+");
                for (int i = 0; i <2 ; i++) {
                    String key=split[i*3]+"s"+split[1+i*3];
                    if(!states.containsKey(key)){
                        Map_State node = new Map_State(Integer.parseInt(split[i*3]),Integer.parseInt(split[i*3+1]),0,0);
                        states.put(node.toString(),node);
                    }
                }
                String key1=split[0]+"s"+split[1];
                String key2=split[3]+"s"+split[4];
                Map_State start=states.get(key1);
                Map_State end = states.get(key2);
                Map_Action action = new Map_Action(start,end,split[2]);
                start.addAction(action);
                if(!actions.containsKey(action.getName())){
                    actions.put(action.getName(),new ArrayList<>());
                    actions.get(action.getName()).add(action);

                }
                else {
                    actions.get(action.getName()).add(action);
                }
            }
            in.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return;
    }
    public Map_State findNode(String street1, String street2){
        List<Map_Action> edgesWithName1=actions.get(street1);
        List<Map_Action> edgesWithName2=actions.get(street2);
        for (Map_Action e1:edgesWithName1) {
            for (Map_Action e2:edgesWithName2){
                if(e1.getStart().equals(e2.getStart())||e1.getStart().equals(e2.getEnd())){
                    return e1.getStart();
                }
                else if(e1.getEnd().equals(e2.getStart())||e1.getEnd().equals(e2.getEnd())){
                    return e1.getEnd();
                }
            }
        }
        return edgesWithName1.get(0).getStart();
    }


}
