package practice1.lambda.ex1;

import java.util.ArrayList;

public class WordContainer extends ArrayList<Word> {

    public void addOrIncrementForWord(String word) {
        Word existingWord = null;
        for (Word w : this) {
            if (w.getContent().equals(word)) {
                existingWord = w;
                break;
            }
        }

        if (existingWord == null) {
            Word w = new Word();
            w.setContent(word);
            w.setFrequency(1);
            add(w);
        } else {
            existingWord.setFrequency(existingWord.getFrequency() + 1);
        }
    }

}
