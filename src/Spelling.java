import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Spelling extends Trie2{



    public static void main(String [] args){

        String path = "/Users/frankieg/Desktop/unigram_freq.csv";
        String line = "";

        Trie2 dictionary = new Trie2();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine(); //skip the first line
            while((line = br.readLine()) != null){
                String []values = line.split(",");
                //int frequency = Integer.parseInt(values[1]);
                dictionary.insert(values[0]);
            }
        }




        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
