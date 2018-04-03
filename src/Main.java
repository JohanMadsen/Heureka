import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Main {

    public static void main(String[] args) {
        /*String fileName = "Simple.txt";
        Set<String> positive = new HashSet<>();
        Set<String> negative = new HashSet<>();
        //negative.add("a");
        positive.add("a");
        Clause clause = new Clause(positive,negative);
        Logic_Model logic_model = new Logic_Model(fileName,clause);
        List<String> pathL =logic_model.graphSearch();
        System.out.println(pathL);
        */
        /*
        String fileName = "manhattan.txt";
        Map_Model mapModel = new Map_Model(fileName,"street_0","avenue_0","street_9","avenue_9");
        List<String> path = mapModel.graphSearch();
        System.out.println(path);
        */
        String fileName2 = "copenhagen.txt";
        Map_Model mapModel2 = new Map_Model(fileName2,"Vestervoldgade","Noerrevoldgade","Noerregade","Vestergade"); //Google Maps same way but length is off because of data set cordinates
        List<String> path2 = mapModel2.graphSearch();
        System.out.println(path2);

        Map_Model mapModel3= new Map_Model(fileName2,"SktPedersStraede","Larsbjoernsstraede","Larsbjoernsstraede","Studiestraede"); //We don't have all the roads maps does, but we use oneway roads correctly
        List<String> path3 = mapModel3.graphSearch();
        System.out.println(path3);



    }

}
