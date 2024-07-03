package ds.example.binaryHeap;

public class BinaryHeap {
    int arr[];
    int sizeofTree;

    public BinaryHeap(int size){
        arr = new int[size+1];
        sizeofTree = 0;
        System.out.println("Binary Tree has been created");
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[1];
    }

    public boolean isEmpty(){
        if(sizeofTree == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return sizeofTree;
    }

    public void levelOrder(){
        if(isEmpty()){
            System.out.println("Tree is empty");
        }else{
            for(int i =1;i<sizeofTree;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("\n");
        }
    }

    public void heapifyBottomToTop(int index, String heapType){
        int parent = index/2;
        if(index <=1){
            return;
        }
        if(heapType.equals("min")){
            if(arr[index] < arr[parent]){
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }else if(heapType.equals("max")){
            if(arr[index] > arr[parent]){
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }
        heapifyBottomToTop(parent,heapType);
    }

    public void insert(int value, String typeOfHeap){
        arr[sizeofTree+1] = value;
        sizeofTree++;
        heapifyBottomToTop(sizeofTree, typeOfHeap);
        System.out.println("value "+value+ " successfully inserted");
    }

    public int extractHeadOfHeap(String heapType){
        if(isEmpty()){
            return -1;
        }else{
            int extractedValue = arr[1];
            arr[1] = arr[sizeofTree];
            sizeofTree--;
            heapifyTopToBottom(1,heapType);
            return extractedValue;
        }

    }

    public void heapifyTopToBottom(int index, String heapType){
        int left = index*2;
        int  right = index*2+1;
        int swapChild=-1;
        if(left > sizeofTree){
            return;
        }
//        if(heapType.equals("min")){
//            if(arr[parent] > arr[leftChild]){
//                int temp = arr[parent];
//                arr[parent] = arr[leftChild];
//                arr[leftChild] = temp;
//            }
//        }
        if(heapType.equals("max")){
            /**
             * Two cases
             * 1. only Left child => left=sizeOfTree
             * 2. left and right child
             */
            if(left == sizeofTree){
                if(arr[index] < arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else{
                if(arr[left] > arr[right]){
                    swapChild = left;
                }else{
                    swapChild = right;
                }
                if(arr[index] < arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }

        }else if (heapType.equals("min")){
            if(left == sizeofTree){
                if(arr[index] > arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else{
                if(arr[left] < arr[right]){
                    swapChild = left;
                }else{
                    swapChild = right;
                }
                if(arr[index] > arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }
    heapifyTopToBottom(swapChild,heapType);
    }

    public void deleteBinaryHeap(){
        arr = null;
        System.out.println("Binary Heap is successfully deleted");
    }
}
