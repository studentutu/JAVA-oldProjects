public class IntList {

    private class ListNode {
        int elem;
        ListNode next = null;

        ListNode(int elem, ListNode next) {
            //TODO add code here
            this.elem=elem;
            this.next=next; //2 mal null?

        }

        int getElem() {
            return this.elem;
        }

        ListNode getNext() {
            return this.next;
        }

        void add(int elem) {
            //TODO add code here
            ListNode n = new ListNode(elem, null);
            next = n;
        }

        ListNode reverseR() {
            //TODO add code here

            if(this.next.next==null){
                this.next.next=this;
                System.out.println("There is last element = " + this.next.elem);
               return this.next;//-----this.last.head will be the head

            } else{
                //System.out.println("Problem was here becouse of head! Always use this!");
                ListNode will=this.next.reverseR();

                System.out.println("Must be last element = " + will.elem);
                this.next.next=this;

                return will;
            }

        }

        public String toString() {
            return this.elem + ((this.next == null) ? "-|" : "->" + this.next);
        }

    }

    private ListNode head = null;

    public boolean empty() {
        return this.head == null;
    }

    public void add(int elem) {
        //TODO add code here
        ListNode newnode=new ListNode(elem,head);//2 mal elem?
        head=newnode;

    }

    public boolean search(int value) {
        //TODO add code here
        ListNode current=head;
        while(current.getNext()!=null) {

            if (current.getElem() == value) {return true;}
            current=current.getNext();

        }
        return false;
    }

    public void reverseI() {
        //TODO add code here
       ListNode current=head;
        while(current.getNext()!=null){
            current=current.getNext();
        }

        ListNode last=head;
        head=current;

        //bereits bei letzte element,letzte element ist null
        while(current!=last){
            ListNode current2=last;
            while(current2.getNext()!=current){
                current2=current2.getNext();
            }
            current.next=current2;
            current=current2;
        }
        last.next=null;

    }

    public void reverseR() {
        //TODO add code here
        System.out.println("Call: last elem = will be head");
        ListNode willbe=head.next.reverseR();
        head.next.next=head;
        head.next=null;
        head=willbe;

    }


    public String toString() {
        return "[" + this.head + "]";
    }
}