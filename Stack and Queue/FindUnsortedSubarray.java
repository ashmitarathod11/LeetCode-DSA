class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
                i++;
            } else {
              
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    // Insert the missing ')'
                    insertions++;
                    i++;
                }

                /
                if (open > 0) {
                    open--;
                } else {
                    insertions++;
                }
            }
        }

       
        insertions += open * 2;

        return insertions;
    }
}