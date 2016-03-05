/*
lintcode 40:  Implement Queue by Two Stacks Show result 

As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.

Have you met this question in a real interview? Yes
Example
Challenge
Tags
Related Problems
 Notes
push(1)
pop()     // return 1
push(2)
push(3)
top()     // return 2
pop()     // return 2
*/

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        while(!stack1.empty())
        {
            stack2.push(stack1.pop());
        }
        int top = stack2.pop();
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        return top;
    }

    public int top() {
        // write your code here
        while(!stack1.empty())
        {
            stack2.push(stack1.pop());
        }
        int top = stack2.peek();
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        return top;
    }
}