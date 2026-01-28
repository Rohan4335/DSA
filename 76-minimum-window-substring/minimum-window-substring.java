class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] ch = s.toCharArray();
        int low = 0, high = 0;
        int count = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;

        while (high < ch.length) {
            if (map[ch[high]]-- > 0) {
                count++;
            }

            while (count == t.length()) {
                if (high - low + 1 < minLen) {
                    minLen = high - low + 1;
                    startIndex = low;
                }

                map[ch[low]]++;   // FIX
                if (map[ch[low]] > 0) {
                    count--;
                }
                low++;            // FIX
            }
            high++;
        }

        return startIndex == -1 ? "" 
               : s.substring(startIndex, startIndex + minLen);
    }
}
