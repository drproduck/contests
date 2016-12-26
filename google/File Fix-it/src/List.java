import java.util.ArrayList;

/**
 * Created by Khiem on 11/4/2016.
 */
public class List extends ArrayList<Node> {
    public List() {
        super();
    }
    @Override
    public int indexOf(Object n) {
        Node node = (Node) n;
        for (int i = 0; i < super.size(); i++){
                if (node.str.equals(super.get(i).str))
                    return i;
        }
        return -1;
    }
}
