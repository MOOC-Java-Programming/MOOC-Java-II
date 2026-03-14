package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
    private HashMap<String, String> dictionary;
    private String file;
    
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file){
        this.file = file;
        this.dictionary = new HashMap<>();
    }

    public boolean load(){
        try(Scanner fileScanner = new Scanner(Paths.get(file))){
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(":");
                add(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save(){
        try(PrintWriter printWriter = new PrintWriter(file)){
            ArrayList<String> alreadySaved = new ArrayList<>();
            
            for (String word : dictionary.keySet()) {
                String translation = dictionary.get(word);
                if(!alreadySaved.contains(word) && !alreadySaved.contains(translation)){
                    printWriter.println(word + ":" + translation);
                    alreadySaved.add(word);
                    alreadySaved.add(translation);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void add(String word, String translation){
        dictionary.putIfAbsent(word, translation);
        dictionary.putIfAbsent(translation, word);
    }

    public String translate(String word){
        return dictionary.get(word);
    }

    public void delete(String word){
        dictionary.remove(word);
        dictionary.values().remove(word);
    }
}
