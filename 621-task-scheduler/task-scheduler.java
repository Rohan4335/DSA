class Task implements Comparable<Task>{
    int freq;
    int exeT;
    Task(int freq, int exeT){
        this.freq = freq;
        this.exeT = exeT;
    }
    public int compareTo(Task that){
        return that.freq - this.freq;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: tasks){
            map.put(ch,map.getOrDefault(ch, 0)+ 1);
        }
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for(Character ch : map.keySet()){
            pq.offer(new Task(map.get(ch),0));
        }
        Queue<Task> queue = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Task task = pq.poll();
                task.freq--;
                if(task.freq > 0){
                    task.exeT = time + n;
                    queue.offer(task);
                }
            }
            if(!queue.isEmpty() && queue.peek().exeT == time){
                pq.offer(queue.poll());
            }
        }
     return time;
     }
}