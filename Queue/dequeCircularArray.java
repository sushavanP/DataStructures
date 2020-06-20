package dataStructures.Queue;

public class dequeCircularArray
{
    static final int MAX = 100;
    int arr[], front, rear, size;

    public dequeCircularArray(int size){
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }
    int isFull(){
        if((front == 0 && rear == size - 1))
            return 1;
        if(front == rear + 1)
            return 1;
        else
            return 0;
    }
    boolean isEmpty(){
        return (front == -1);
    }
    void insertFront(int key){
        if(isFull() == 1){
            System.out.println("Overflow");
            return;
        }
        if(front == -1){
            front = 0;
            rear = 0;
        }
        else if(front == 0)
            front = size - 1;
        else
            front = front - 1;
        arr[front] = key;
    }
    void insertRear(int key){
        if(isFull() == 1){
            System.out.println("Overflow");
            return;
        }
        if(front == -1){
            front = 0;
            rear = 0;
        }
        else if(rear == size - 1)
            rear = 0;
        else
            rear = rear + 1;
        arr[rear] = key;
    }
    void deleteFront(){
        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else
            if(front == size -1)
                front = 0;
            else
                front = front + 1;
    }
    void deleteRear(){
        if(isEmpty()){
            System.out.println("Underflow");
            return;
        }
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else if(rear == 0)
            rear = size - 1;
        else
            rear = rear - 1;
    }
    int getFront(){
        if(isEmpty()){
            System.out.println("underflow");
            return -1;
        }
        return arr[front];
    }
    int getRear(){
        if(isEmpty() || rear < 0){
            System.out.println("Underflow");
            return -1;
        }
        return arr[rear];
    }
    public static void main(String[] args){
        dequeCircularArray dq = new dequeCircularArray(5);
        System.out.println("Insert element at rear end  : 5");
        dq.insertRear(5);

        System.out.println("insert element at rear end : 10 ");
        dq.insertRear(10);

        System.out.println("get rear element : "+ dq.getRear());

        dq.deleteRear();
        System.out.println("After delete rear element new rear become : " +
                dq.getRear());

        System.out.println("inserting element at front end");
        dq.insertFront(15);

        System.out.println("get front element: " +dq.getFront());

        dq.deleteFront();

        System.out.println("After delete front element new front become : " +
                +  dq.getFront());

    }
}
