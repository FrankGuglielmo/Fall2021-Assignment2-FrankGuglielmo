public class Trie2 extends TrieNode{

    private TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {

        //Start at the root
        TrieNode [] children = root.getChildren();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            //If there already exists a child with the character c in the trie
            if(children[c - 97] != null) {
                node = children[c - 97];
            }
            //Make a new node with the character value c and link it to the children of the parent
            else {
                node = new TrieNode(c);
                children[c - 97] = node;
            }
            //Either way, find the children of the node to keep looping through,
            //either creating a new path in the trie or following along a pre-existing one
            children = node.getChildren();
            //When you get to the end of the word, since we know that it's a word, set the last
            //character node to be the end of a word, i.e. set isEndOfWord to true
            if(i == word.length() - 1) {
                node.setEndOfWord(true);
                //Set the prefix frequency of the node so we know how many times it comes up in our .csv file
            }
        }
    }

    public boolean search(String word) {
        //Start at the root
        TrieNode [] children = root.getChildren();
        TrieNode node = null;
        //Iterate through the trie until you come across a break in the path
        //Outcome 1: You've reached a leaf node, so there are no more character nodes beyond that path
        //This is fine because we'll check to see if the node we stopped at has isEndOfWord set to true
        //If it is true, then we have a valid word
        //Outcome 2: The search function comes across a break in the path, i.e., all the letters "ran out"
        //of the word, or it couldn't find the right child the parameter was looking for. If isEndOfWord is not true,
        //and we reached the end of our search, the word does not exist in our trie.
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children[c - 97] != null) {
                node = children[c - 97];
                children = node.getChildren();
            } else {
                node = null;
                break;
            }
        }
        //Tests the node we're left with to see if it makes a valid word
        if(node != null && node.isEndOfWord()) {
            return true;
        } else {
            return false;
        }
    }
}

