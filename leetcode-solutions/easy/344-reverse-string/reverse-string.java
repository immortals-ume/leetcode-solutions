class Solution {
    public void reverseString(char[] s) {
        int start=0 ; int end = s.length-1; revStr(s,start,end);
    }
   public void revStr(char[] s, int h, int l) { if(h > l) return; 

        char temp = s[h];
        s[h] = s[l];
        s[l] = temp;
        revStr(s, h+1, l-1);
    }
}