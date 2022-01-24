// Runtime: 3 ms, faster than 32.84% of Java online submissions for Detect Capital.
// Memory Usage: 39.2 MB, less than 26.92% of Java online submissions for Detect Capital.
// 2022.1.24

class Solution {
    public boolean detectCapitalUse(String word) {
        char Z = 'Z';
        if (word.length() == 1){
            return true;
        }
        char firstChar = word.charAt(0);
        char secondChar = word.charAt(1);
        // first chat is capital
        if (firstChar <= Z){
            if (secondChar <= Z){
                for (int i = 1; i<word.length(); i++){
                    if (word.charAt(i) > Z){
                        return false;
                    }
                }
                return true;
            }
            else{
                for (int i = 1; i<word.length(); i++){
                    if (word.charAt(i) <= Z){
                        return false;
                    }
                }
                return true;
            }
        }
        //first char is not captial
        else{
            for (int i = 1; i<word.length(); i++){
                    if (word.charAt(i) <= Z){
                        return false;
                    }
                }
                return true;
        }
    }
}
