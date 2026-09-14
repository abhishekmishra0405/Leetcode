class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) { // O(n)
        q.add(x);
        int n = q.size();
        for(int i = 1 ; i <= n-1; i++ ){
            q.add(q.remove());
        }
    }

    public int pop() { // O(1)
        return q.remove();
    }

    public int top() { // O(n)
        
        return q.peek();
    }

    public boolean empty() {
        return (q.size() == 0);
    }
}