package ds.example;

import java.util.ArrayList;
import java.util.List;

public class DoubleHashing {

    String[] hashTable;

    int usedCellNumber;

    public DoubleHashing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    public void displayHashTable(){
        if(hashTable ==null){
            System.out.println("hashtable does not exist");
            return;
        }else{
            for (int i=0;i<hashTable.length;i++){
                System.out.println("Index "+i+"key: "+hashTable[i]);
            }
        }
    }
    public int modASCIIHashFunction(String word, int M){
        char ch[];
        ch = word.toCharArray();
        int i,sum;
        for(sum=0,i=0; i<word.length();i++){
            sum+= ch[i];
        }
        return sum%M;
    }
    public double getLoadFactor(){
        double loadFactor = usedCellNumber * 1.0/hashTable.length;
        return loadFactor;
    }

    public void rehashKeys(String word) {
        usedCellNumber = 0;
        List<String> data = new ArrayList<>();
        for (String s : hashTable) {
            data.add(s);
        }
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            //insertInHashTable(s);
        }
    }

    public void insertInHashTable(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor  >= 0.75){
            rehashKeys(word);
        }else{
            int index = modASCIIHashFunction(word,hashTable.length);
            int counter = 0;
            for(int i = index;i<index+hashTable.length;i++){
                int newIndex = (index+(counter*counter))%hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println("The " + word + " successfully inserted at location: "+newIndex);
                    break;
                }else{
                    System.out.println(newIndex+" is already occupied . Trying next empty cell");
                }
                counter++;
            }
        }
        usedCellNumber++;
    }
}
