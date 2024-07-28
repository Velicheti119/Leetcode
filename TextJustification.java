class Solution {

    public String leftJustify(String[] copiedWords, int maxWidth) {
        int wordCount = copiedWords.length;
        int flagLength = wordCount - 1;
        int charsLength = 0;
        for (String s : copiedWords) {
            charsLength = charsLength + s.length();
        }
        int whitespaces = maxWidth - charsLength;
        StringBuilder retVal = new StringBuilder();
        for (String s : copiedWords) {
            retVal.append(s);
            if(whitespaces > 0) {
                retVal.append(" ");
                whitespaces--;
            }
        }
        while (whitespaces > 0) {
            retVal.append(" ");
            whitespaces--;
        }
        return retVal.toString();
    }

    public String justifyLine(String[] copiedWords, int maxWidth) {
        int wordCount = copiedWords.length;
        int flagLength = wordCount - 1;
        int charsLength = 0;
        for (String s : copiedWords) {
            charsLength = charsLength + s.length();
        }
        StringBuilder retVal = new StringBuilder();
        int whitespaces = maxWidth - charsLength;
        // System.out.println(flagLength);
        // System.out.println(whitespaces);
        retVal.append(copiedWords[0]);
        if(flagLength > 0) {
            int[] padding = new int[flagLength];
            for(int i = 0; i < whitespaces; i++) {
                padding[i % flagLength]++;
            }
            for(int j = 1; j < wordCount; j++){
                int spaces = padding[j-1];
                while(spaces > 0) {
                    retVal.append(" ");
                    spaces--;
                }
                retVal.append(copiedWords[j]);
            }
        } else {
            while(whitespaces > 0) {
                retVal.append(" ");
                whitespaces--;
            }
        }
        return retVal.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int wordsLen = words.length;
        int startIndex = 0;
        int endIndex = 0;
        int charCount = 0;
        while (endIndex < wordsLen) {
            String word = words[endIndex];
            int wordLength = word.length();
            charCount = charCount + wordLength;
            if (charCount > maxWidth) {
                String[] subWords = Arrays.copyOfRange(words, startIndex, endIndex);
                String line = justifyLine(subWords, maxWidth);
                result.add(line);
                startIndex = endIndex;
                charCount = 0;
            } else {
                charCount++;
                endIndex++;
            }
        }
        String[] subWords = Arrays.copyOfRange(words, startIndex, endIndex);
        String line = leftJustify(subWords, maxWidth);
        result.add(line);
        return result;
    }
}
