class MyCircularQueue {
    class Node
    {
        int val;
        Node next;

        Node(int val)
        {
            this.val=val;
        }
    }
    Node front,rear;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        capacity=k;
        size=0;
        front=rear=null;    
    }
    
    public boolean enQueue(int value) {
        if(isFull())
        {
            return false;
        }
        Node newNode=new Node(value);

        if(isEmpty()){
            front=rear=newNode;
            rear.next=front;
        }
        else{
            rear.next=newNode;
            rear=newNode;
            rear.next=front;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
        return false;
        if(front==rear)
        {
            front=rear=null;
        }
        else{
            front=front.next;
            rear.next=front;
        }
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty()? -1:front.val;
    }
    
    public int Rear() {
        return isEmpty()? -1:rear.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */