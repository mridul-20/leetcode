class Solution {
    private int expandFromCenter(String s , int l , int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;             
        }
        return r - l - 1;
    }
    public String longestPalindrome(String s) {
        int start = 0; 
        int end = 0;
        for(int center = 0; center < s.length() ; center++){
            int oddLen = expandFromCenter(s , center , center);
            int evenLen = expandFromCenter(s, center , center + 1);

            int maxLen = Math.max(oddLen , evenLen);

            if(maxLen > end - start){
                start = center - (maxLen-1)/2;
                end = center + maxLen/2;
            } 
        }
        return s.substring(start , end+1);
    }
}