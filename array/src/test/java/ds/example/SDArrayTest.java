package ds.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SDArrayTest {

    @Test
    void insert() {
        SDArray sdArr = new SDArray(4);
        sdArr.insert(0,24);
        assert (sdArr.arr[0] == 24);
        System.out.println(Arrays.toString(sdArr.arr));
    }

}
