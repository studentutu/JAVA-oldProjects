class CharList {

    private class ListNode {
        char elem;
        ListNode next = null;
        ListNode prev = null;

        ListNode(char elem, ListNode next, ListNode prev) {
            //TODO add code here
            this.elem=elem;
            this.next=next;
            this.prev=prev;

        }

        int getElem() {
            return this.elem;
        }
        ListNode getNext() {
            return this.next;
        }
        ListNode getPrev() {
            return this.prev;
        }

        void add(char elem) {
            //TODO add code here
               if(getNext()!=null){
                  this.next.add(elem);
               } else{
            ListNode  last=new ListNode(elem,null,this);
            this.next=last;
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

    public void add(char elem) {
        //TODO add code here}
        if(!empty()){
            head.add(elem);
        }else{
            head= new ListNode(elem,null,head);
        }

    }

    public boolean search(char value) {
        //TODO add code here
        ListNode temprory=head;
        while(temprory.getNext()!=null){

            if(temprory.getElem()==value){return true;}else{
                temprory=temprory.getNext();
            }

        }
        return false;
    }

    public boolean insert(char value) {
        //TODO add code here
        ListNode temprory=head;

        if(temprory.getElem()>value ) {
            ListNode willbehead=new ListNode(value,temprory,null);
            head=willbehead;
            return true;
        }
        while(temprory.getNext()!=null){
           if(temprory.getElem()>value ){
               ListNode zwischen=new ListNode(value,temprory.next,temprory);
               temprory.next.prev=zwischen;
               temprory.next=zwischen;
               return true;

           }else{
               temprory=temprory.getNext();
           }
        }
        //temprory.next==null neue node here!
        ListNode last=new ListNode(value,null,temprory);
        temprory.next=last;
        return true;
    }

    public String toString() {
        return "[" + this.head + "]";
    }
}
