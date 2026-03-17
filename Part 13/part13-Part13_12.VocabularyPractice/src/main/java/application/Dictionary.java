package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Dictionary {
    private List<String> words;
    private Map<String, String> translations;
    private Random random;

    public Dictionary(){
        words = new ArrayList<>();
        translations = new HashMap<>();
        random = new Random();
        add("sana", "word");
    }

    public String get(String word) {
        return translations.get(word);
    }

    public void add(String word, String translation){
        if(!translations.containsKey(word)){
            words.add(word);
        }
        translations.put(word, translation);
    }

    public String getRandomWord(){
        return words.get(random.nextInt(words.size()));
    }
}
