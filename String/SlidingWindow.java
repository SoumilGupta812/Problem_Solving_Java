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
    public int longestOnes(int[] nums, int k) {
        int zeroCounter=0,left=0,result=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0)
                zeroCounter++;
            if(zeroCounter>k)
            {
                if(nums[left]==0)
                    zeroCounter--;
                left++;

            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordmap = new HashMap<>();
        HashMap<String, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (String word : words)
            wordmap.put(word, wordmap.getOrDefault(word, 0) + 1);
        int left = 0, have = 0, need = wordmap.size();
        int wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) {
            left = i;
            have = 0;
            window = new HashMap<>();
            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String cur = s.substring(right, right + wordLen);
                if (!wordmap.containsKey(cur)) {
                    window.clear();
                    have = 0;
                    left = right + wordLen;
                } else {
                    window.put(cur, window.getOrDefault(cur, 0) + 1);
                    if (wordmap.get(cur).equals(window.get(cur)))
                        have++;
                    while (window.get(cur) > wordmap.get(cur)) {
                        String leftWord = s.substring(left, left + wordLen);
                        if (wordmap.get(leftWord).equals(window.get(leftWord)))
                            have--;
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                    }
                    if (have == need) {
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        if (wordmap.get(leftWord).equals(window.get(leftWord)))
                            have--;
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                    }
                }
            }
        }
        return res;
    }

}
