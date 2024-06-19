package ds.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TDArrayTest {

    @Test
    public void insert(){
        TDArray arr2D = new TDArray(2,3);
        arr2D.insert(0,0,24);
        assert (24 == arr2D.arr2D[0][0]);
        System.out.println(Arrays.deepToString(arr2D.arr2D));
    }


    @Test
    public void access(){
        TDArray arr2D = new TDArray(2,3);
        arr2D.insert(0,0,24);
        assert (24 == arr2D.access(0,0));
        System.out.println(Arrays.deepToString(arr2D.arr2D));
    }

    @Test
    public void traverse(){
        TDArray arr2D = new TDArray(2,3);
        arr2D.insert(0,0,24);
        arr2D.insert(0,1,25);
        arr2D.insert(0,2,26);
        arr2D.insert(1,0,27);
        arr2D.insert(1,1,28);
        arr2D.insert(1,2,29);
       arr2D.traverse();
    }

    @Test
    public void search(){
        TDArray arr2D = new TDArray(2,3);
        arr2D.insert(0,0,24);
        arr2D.insert(0,1,25);
        arr2D.insert(0,2,26);
        arr2D.insert(1,0,27);
        arr2D.insert(1,1,28);
        arr2D.insert(1,2,29);
        arr2D.search(27);
    }
}
