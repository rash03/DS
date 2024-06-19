package ds.example;

public class TDArray {

    int[][] arr2D;

    public TDArray(int row, int col){
        arr2D = new int[row][col];
        for(int i = 0 ; i<row; i++){
            for(int j=0;j<col;j++){
                arr2D[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void insert(int row, int col, int value){
        try{
            if (arr2D[row][col] == Integer.MIN_VALUE){
                arr2D[row][col] = value;
                System.out.println("value is inserted");
            }else{
                System.out.println("cell is already occupied");
            }
        }catch (ArrayIndexOutOfBoundsException exp){
            System.out.println("invalid index");
        }
    }

    public int access (int row, int col){
        int value = 0;
        try{
            value =  arr2D[row][col];
        }catch (ArrayIndexOutOfBoundsException exp){
            System.out.println("invalid index");
        }
        return value;
    }

    public void traverse(){
        for (int row = 0; row<arr2D.length;row++){
            for (int col = 0 ; col < arr2D[0].length; col++){
                System.out.println(arr2D[row][col]);
            }
            System.out.println("");
        }
    }

    public void search(int value){

        for (int row = 0; row<arr2D.length;row++){
            for (int col = 0 ; col < arr2D[0].length; col++) {
                if (arr2D[row][col] == value) {
                    System.out.println("element found at row:" + row+ " col: "+col);
                    return;
                }
            }
        }
        System.out.println("element not found");
    }

    public void deleteValue (int value){
        for (int row = 0; row<arr2D.length;row++){
            for (int col = 0 ; col < arr2D[0].length; col++) {
                if (arr2D[row][col] == value) {
                    arr2D[row][col] = Integer.MIN_VALUE;
                    System.out.println("element found and deleted at row:" + row+ " col: "+col);
                    return;
                }
            }
        }
        System.out.println("element not found");
    }

    public void delete (int row, int col){
        try{
            arr2D[row][col] = Integer.MIN_VALUE;
        }catch (ArrayIndexOutOfBoundsException exp){
            System.out.println("invalid index");
        }
    }

}
