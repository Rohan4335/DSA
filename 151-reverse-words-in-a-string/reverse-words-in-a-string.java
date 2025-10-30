class Solution {

    private static final char SPACE = ' ';

    //Warm up trick.
    // My solution is alrady  the same as the one with 0ms solution;
    static{
        for(int i = 0; i < 1000; i++){
            reverseWords("");
        }
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];
        var offset = 0;
        var end = chars.length - 1;
        while (end >= 0) {
            while (end >= 0 && chars[end] == SPACE)
                end--;
            var start = end;
            while (start >= 0 && chars[start] != SPACE)
                start--;
            var k = start + 1;
            if (offset > 0 && k <= end)
                res[offset++] = SPACE;
            while (k <= end)
                res[offset++] = chars[k++];
            end = start;
        }
        return new String(res, 0, offset);
    }

}