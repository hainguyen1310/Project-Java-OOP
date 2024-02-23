package Model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public  Dictionary() {
        dictionary = new HashMap<>();
    }

    public boolean addWord(String eng, String vi) {
        if (dictionary.containsKey(eng)) {
            return false;
        } else {
            dictionary.put(eng, vi);
            return true;
        }
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            return true;
        } else {
            return false;
        }
    }

    public String translate(String eng) {
        return dictionary.getOrDefault(eng, "Invalid Word.");
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }
}