package org.deb.codesignal.practice;

public class StringUtil {


    public String buildPalindrome(String st) {
        int i = 0;
        int l = st.length();
        String o = st;
        StringBuilder sb = new StringBuilder();
        while (!isPalindrome(st) && st.length() > 0){
            sb.append(st.charAt(0));
            i++;
            st = st.substring(1);

        }
        return o+sb.reverse().toString();
    }

    public boolean isPalindrome(String s){
        int l = s.length();
        int m = l/2;
        for (int i = 0; i < m; i++){
            if (s.charAt(i) != s.charAt(l-i-1)){
                return false;
            }
        }
        return true;
    }
}
