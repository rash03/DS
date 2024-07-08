package ds.example;

import java.util.ArrayList;
import java.util.List;

public class LinearProbing {

    String[] hashtable;
    int usedCellNumber;

    public LinearProbing(int size){
        hashtable = new String[size];
        usedCellNumber = 0;
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
        double loadFactor = usedCellNumber * 1.0/hashtable.length;
        return loadFactor;
    }

    //Rehash

    public void rehashKeys(String word) {
        usedCellNumber = 0;
        List<String> data = new ArrayList<>();
        for (String s : hashtable) {
            data.add(s);
        }
        data.add(word);
        hashtable = new String[hashtable.length * 2];
        for (String s : data) {
            insertInHashTable(s);
        }
    }

    public void insertInHashTable(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor  >= 0.75){
            rehashKeys(word);
        }else{
            int index = modASCIIHashFunction(word,hashtable.length);
            for(int i = index;i<index+hashtable.length;i++){
                int newIndex = i%hashtable.length;
                if(hashtable[newIndex] == null){
                    hashtable[newIndex] = word;
                    System.out.println("The " + word + " successfully inserted at location: "+newIndex);
                    break;
                }else{
                    System.out.println(newIndex+" is already occupied . Trying next empty cell");
                }
            }
        }
        usedCellNumber++;
    }

    public boolean search(String word){
        int index = modASCIIHashFunction(word,hashtable.length);
        for(int i = index; i <index+hashtable.length;i++){
            int newIndex = i%hashtable.length;
            if(hashtable[newIndex]!=null && hashtable[newIndex].equals(word)){
                System.out.println("The " + word + " successfully found at location: "+newIndex);
                return true;
            }
        }
        System.out.println("The " + word + " successfully not found in HashTable: ");
        return false;
    }

    public void delete(String word){
        int index = modASCIIHashFunction(word,hashtable.length);
        for(int i = index; i <index+hashtable.length;i++){
            int newIndex = i%hashtable.length;
            if(hashtable[newIndex]!=null && hashtable[newIndex].equals(word)){
                hashtable[newIndex] = null;
                System.out.println("The " + word + " successfully deleted at location: "+newIndex);
                usedCellNumber--;
                return;
            }
        }
        System.out.println("The " + word + " not found in hashTable");
    }
}
