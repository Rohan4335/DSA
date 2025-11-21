class MinStack {
    List<int[]> list ;
    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        int[] top = list.isEmpty()? new int[]{val, val} :list.get(list.size() - 1);
        int min = top[1];
        if(min > val){
            min = val;
        }
        list.add(new int[]{val, min});
    }
    
    public void pop() {
        list.remove(list.size() -1);
    }
    
    public int top() {
        return list.isEmpty()? -1: list.get(list.size()-1)[0];
    }
    
    public int getMin() {
        return list.isEmpty()? -1: list.get(list.size()-1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */