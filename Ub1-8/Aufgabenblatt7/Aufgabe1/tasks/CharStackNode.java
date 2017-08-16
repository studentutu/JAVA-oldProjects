public class CharStackNode {

    private char elem;
    private CharStackNode next=null;

    // replace the value and next node
    public CharStackNode(char elem, CharStackNode next) {
        //TODO add code here
        this.elem=elem;
        this.next=next;
    }

    // get the value
    public char getElem() {
        //TODO add code here
        return elem;
    }

    // get the next node
    public CharStackNode getNext() {
        //TODO add code here
        return next;
    }
}
