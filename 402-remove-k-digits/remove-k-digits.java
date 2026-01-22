class Solution {
    public String removeKdigits(String num, int k) {
    Deque<Character> st = new ArrayDeque<>();
    if(k == num.length()) return "0";
    for(int i =0; i<num.length(); i++){
        char x = num.charAt(i);
        while(!st.isEmpty() && k>0 && (x < st.peekLast())){
            st.pollLast();
            k--;
        }
        st.offerLast(x);
    }

    while(k>0 && !st.isEmpty()){
        st.pollLast();
        k--;
    }

    while(!st.isEmpty() && st.peekFirst() == '0'){
        st.pollFirst();
    }
     if (st.isEmpty()) return "0";
    StringBuilder sb = new StringBuilder();
    while (!st.isEmpty()) sb.append(st.pollFirst());
    return sb.toString();
    }
}