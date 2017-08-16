public class CharStack {

    private CharStackNode top = null;

    // push an element onto the stack
    public void push(char elem) {
        //TODO add code here
        CharStackNode newS=new CharStackNode(elem,top);
        top=newS;
    }

    // pop an element from the stack
    public char pop() {
        //TODO add code here
        char s=top.getElem();
        top=top.getNext();

        return s;
    }

    // true if the stack is empty
    public boolean isEmpty() {
        //TODO add code here
        return top==null;
    }
}
