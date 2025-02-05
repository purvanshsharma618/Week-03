package com.linearsearch;

public class SearchWordInSentences {

    public static void main(String[] args) {
        // Array of sentences
        String[] sentences = {
                "Java is a popular programming language.",
                "Python is widely used in data science.",
                "I love solving coding questions.",
                "AI is the future.",
                "Cloud is an emerging technology."
        };

        // Word to search
        String targetWord = "coding";

        // Perform search
        String result = searchWordInSentences(sentences, targetWord);

        // Print the result
        System.out.println(result);
    }

    //Method to search sentence that contains the target word.
    public static String searchWordInSentences(String[] sentences, String targetWord) {
        for (String sentence : sentences){
            for(String str : sentence.split(" ")){
                if(str.equalsIgnoreCase(targetWord)){
                    return sentence;
                }
            }
        }
          return "Not found";
    }
}