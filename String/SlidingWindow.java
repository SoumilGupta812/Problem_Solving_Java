package String;
import java.util.*;
public class SlidingWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        HashMap<Character ,Integer> tMAP=new HashMap<>();
        HashMap<Character ,Integer> window=new HashMap<>();
        for(char c:t.toCharArray())
            tMAP.put(c,tMAP.getOrDefault(c,0)+1);
        int minLeft=0,minLength=Integer.MAX_VALUE;
        int left = 0, have = 0,need= tMAP.size();
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(tMAP.containsKey(c) && window.get(c).equals(tMAP.get(c)))
                have++;

            while(have==need){
                if(right-left+1<minLength){
                    minLength=right-left+1;
                    minLeft=left;
                }
                char l=s.charAt(left);
                window.put(l,window.get(l)-1);
                if(tMAP.containsKey(l) && window.get(l) < (tMAP.get(l)))
                    have--;
                left++;

            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(minLeft,minLeft+minLength);
    }
    public int characterReplacement(String s, int k) {
        int result=0;
        int left=0;
        int[] freq=new int[26];
        int maxFreq=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
            if((right-left+1-maxFreq)>k){
                char l=s.charAt(left);
                freq[l-'A']--;
                left++;
            }
            result=right-left+1;
        }
        return result;
    }
}
