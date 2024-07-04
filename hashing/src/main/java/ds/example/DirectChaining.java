package ds.example;

import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    DirectChaining(int size){
        hashTable = new LinkedList[size];
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

    public void insertHashTable(String word){
        int newindex = modASCIIHashFunction(word,hashTable.length);
        if(hashTable[newindex] == null){
            hashTable[newindex] = new LinkedList<>();
            hashTable[newindex].add(word);
        }else{
            hashTable[newindex].add(word);
        }
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

    public boolean searchHashTable(String word){
        int newIndex = modASCIIHashFunction(word,hashTable.length);

        if(hashTable[newIndex] !=null && hashTable[newIndex].contains(word)){
            System.out.println("\n"+"\""+word+"\""+ " is found in HashTable at location "+newIndex);
            return true;
        }else{
            System.out.println("\n"+"\""+word+"\""+ " is not found in HashTable ");
            return false;
        }
    }

    public void deleteKeyHashTable(String word){
        int newIndex = modASCIIHashFunction(word,hashTable.length);
        boolean result = searchHashTable(word);
        if(result){
            hashTable[newIndex].remove(word);
            System.out.println("\n"+"\""+word+"\""+ " is has been deleted from HashTable");
        }
    }
}
