import java.util.HashMap;

public class TrieNode {


    private char c;
    //private HashMap<Character, TrieNode> children = new HashMap<>();
    private TrieNode [] children = new TrieNode[26];
    private boolean isEndOfWord;
    private int prefixFrequency = 0;


    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }


    public TrieNode[] getChildren(){
        return children;
    }

    public void setChildren(TrieNode[] children){
        this.children = children;
    }
    /*
    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }
*/
    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public int prefixFrequency() {
        return prefixFrequency;
    }

    public void setPrefixFrequency(int prefixFrequency) {
        this.prefixFrequency = prefixFrequency;
    }


}
