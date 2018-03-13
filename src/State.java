import java.util.List;

/**
 * Created by johan_000 on 06-03-2018.
 */

interface State{
    double getF();
    void setG(double newG);
    void setH(double newH);
    double getG();
    List<String> getPath();
    void setPath(List<String> newPath);
    void extendPath(List<String> currentPath, String actionName);

}



