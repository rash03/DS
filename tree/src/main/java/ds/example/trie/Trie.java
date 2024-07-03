package ds.example.trie;

public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
        System.out.println("New Trie Node has been created");
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node ==null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Success fully inserted"+ word+" in Trie");
    }

    public boolean search(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node ==null){
                System.out.println("Search word: "+word+" does not exist in Trie");
                return false;
            }
            current = node;
        }
        if(current!=null && current.endOfString){
            System.out.println("Search word: "+word+" does not exist in Trie or is a Prefix of another string");
        }else{
            System.out.println("Search word: "+word+" does exist in Trie");
        }
        return current.endOfString;
    }
}
