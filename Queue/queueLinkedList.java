package dataStructures.Queue;

class Queue {
    int key;
    Queue next;

    public Queue(int key) {
        this.key = key;
        this.next = null;
    }
}
public class queueLinkedList
{
    Queue front, rear;
    queueLinkedList(){
        this.front = this.rear = null;
    }
    void enqueue(int key){
        Queue temp = new Queue(key);
        if(this.rear == null){
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }
    void dequeue(){
        if(this.front == null)
            return;
        Queue temp = this.front;
        this.front = this.front.next;

        if(this.front == null)
            this.rear = null;
    }
    public static void main(String[] args){
        queueLinkedList q = new queueLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front: " + q.front.key);
        System.out.println("Queue Rear: " + q.rear.key);
    }
}
