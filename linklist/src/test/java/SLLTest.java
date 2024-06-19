import ds.example.SLL;
import org.junit.jupiter.api.Test;

public class SLLTest {

    @Test
    public void sllTraverse(){
        SLL sll = new SLL();
        sll.insertNodeInLL(0,23);
        sll.insertNodeInLL(1,24);
        sll.insertNodeInLL(2,25);
        sll.insertNodeInLL(3,26);
        sll.insertNodeInLL(4,27);
        sll.traverseSLL();
    }
}
