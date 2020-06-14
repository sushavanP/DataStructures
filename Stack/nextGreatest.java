package dataStructures.Stack;

public class nextGreatest
{
    static class stack{
        int top, items[] = new int[100];
        void push(int x){
            if(top == 99)
                System.out.println("Stack full.");
            else{
                items[++top] = x;
            }
        }
        int pop(){
            if(top == -1) {
                System.out.println("Stack Underflow.");
                return -1;
            }else{
                int element = items[top];
                top--;
                return element;
            }
        }
        boolean isEmpty(){
            return (top == -1) ? true : false;
        }
    }
    static void printNGE(int arr[], int n){
        int i = 0;
        stack st = new stack();
        st.top = -1;
        int element, next;

        st.push(arr[0]);
        for(i = 1; i < n; i++){
            next = arr[i];
            if(st.isEmpty() == false){
                element = st.pop();
                while(element < next){
                    System.out.println(element +" --- "+ next);
                    if(st.isEmpty() == true)
                        break;
                    element = st.pop();
                }
                if(element > next)
                    st.push(element);
            }
            st.push(next);
        }
        while(st.isEmpty() == false){
            element = st.pop();
            next = -1;
            System.out.println(element +" -- "+ next);
        }
    }
    public static void main(String[] args){
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        printNGE(arr, n);
    }
}
