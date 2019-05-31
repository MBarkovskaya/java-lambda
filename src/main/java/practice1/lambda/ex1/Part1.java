package practice1.lambda.ex1;

import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        WordContainer words = readInputAndParseToList();
        words.sort((o1, o2) -> {
            int res = Integer.compare(o2.getFrequency(), o1.getFrequency());
            return res != 0 ? res : o1.getContent().compareTo(o2.getContent());
        });
        for (Word word : words) {
            System.out.println(word.getContent() + " : " + word.getFrequency());
        }
    }

    private static WordContainer readInputAndParseToList() {
        WordContainer wordContainer = new WordContainer();
        Scanner input = new Scanner(System.in);
        String lineNew;

        while (input.hasNextLine()) {
            lineNew = input.nextLine();
            boolean containsStop = false;
            for (String word : lineNew.split(" ")) {
                if (word.equals("stop")) {
                    containsStop = true;
                    break;
                } else wordContainer.addOrIncrementForWord(word);
            }
            if (containsStop) break;
        }
        return wordContainer;
    }

}
