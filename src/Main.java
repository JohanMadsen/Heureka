import java.util.List;

/**
 * Created by johan_000 on 27-02-2018.
 */
public class Main {

    public static void main(String[] args) {

        String fileName = "manhattan.txt";
        Map_Model mapModel = new Map_Model(fileName,"street_0","avenue_0","street_3","avenue_3");
        List<String> path = mapModel.graphSearch();
        System.out.println(path);

        String fileName2 = "copenhagen.txt";
        Map_Model mapModel2 = new Map_Model(fileName2,"LarslejStraede","Noerrevoldgade","Larsbjoernsstraede","Vestergade");
        List<String> path2 = mapModel2.graphSearch();
        System.out.println(path2);
        Map_Model mapModel3= new Map_Model(fileName2,"LarslejStraede","Noerrevoldgade","Larsbjoernsstraede","Vestergade");
        List<String> path3 = mapModel3.graphSearch();
        System.out.println(path3);



    }

}
