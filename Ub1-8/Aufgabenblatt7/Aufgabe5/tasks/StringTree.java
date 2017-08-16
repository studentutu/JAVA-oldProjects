class StringTree {

    private class Node {

        String elem;
        Node left = null;
        Node right = null;

        Node(String elem) {
            this.elem = elem;
        }

        void add(String elem) {
            //TODO add code here

             if(this.elem.compareTo(elem)>=0&&right!=null){
                    right.add(elem);
                 //System.out.println("Goes Right");
             }else if(this.elem.compareTo(elem)>=0&&right==null){
                 Node s=new Node(elem);
                 right=s;
                 //System.out.println("To Rigth tree");

             }else if(this.elem.compareTo(elem)<0&&left!=null){
                 left.add(elem);
                 //System.out.println("Goes Left");
             }else if(this.elem.compareTo(elem)<0 && left==null){
                 Node s=new Node(elem);
                 left=s;
                 //System.out.println("To Left tree");
             }



        }

        int height() {
            //TODO add code here
            if(this.left==null&&this.right==null){
                return 1;
            }else if(this.left!=null){
                return 1 + this.left.height();
            }else if(this.right!=null){
                return 1+ this.right.height();
            }else{
                return 1+this.left.height()>=this.right.height()?this.left.height():this.right.height();
            }


        }

        void printLeaves() {
            //TODO add code here
            if(this.left==null&&this.right==null){
                System.out.println(this.elem);
            }else{
                if(this.right!=null){ this.right.printLeaves();}
                if(this.left!=null){ this.left.printLeaves();}
            }
        }

        void printInOrderUp() {
            //TODO add code here
            if(this.left!=null && this.right!=null){
            this.left.printInOrderUp();
                this.right.printInOrderUp();
                System.out.println(this.elem);
            }else if(this.left==null && this.right!=null){
                this.right.printInOrderUp();
                System.out.println(this.elem);
            }else if(this.right==null && this.left!=null ){this.left.printInOrderUp();
                System.out.println(this.elem);
            }else {System.out.println(this.elem);}
        }

        void printPostOrder() {
            //TODO add code here
            if(this.left!=null && this.right!=null){

                this.left.printPostOrder();
                this.right.printPostOrder();
                System.out.println(this.elem);

            }else if(this.left==null&& this.right!=null){
                this.right.printPostOrder();
                System.out.println(this.elem);
            }else if(this.left!=null && this.right==null){
                this.left.printPostOrder();
                System.out.println(this.elem);
            }else {
                System.out.println(this.elem);
            }

        }
        public String toString() {
            return this.elem + ((this.left == null)&&(this.right==null) ? " RealEnd| " : this.left==null?" left|Over To right ->" +this.right: this.right==null?" right|Over  To left <-"+this.left: " down in \n " + this.right+" <fromright " + this.left+" <fromLeft" );
        }
    }

    private Node root = null;

    public void add(String elem) {
        //TODO add code here
        if(empty()){root=new Node(elem);}else{

            root.add(elem);
        }

    }

    public boolean empty() {
        return this.root == null;
    }

    public int height() {
        //TODO add code here
        if (empty()){return 0;}else
        if(root.right==null && root.left==null){return 1;}else{

          return root.left.height()>=root.right.height()?root.left.height() +1:root.right.height()+1;

        }

    }

    public void printLeaves() {
        //TODO add code here
        if(empty()){
            System.out.println("Realy nothing");
        }else if(root.left==null && root.right==null){
            System.out.println(root.elem);
        }else {
            root.right.printLeaves();
            root.left.printLeaves();

        }
    }

    public void printInOrderUp() {
        //TODO add code here
        if(empty()){
            System.out.println("There is no Tree");
        }else{

            root.left.printInOrderUp();
            System.out.println(root.elem);
            root.right.printInOrderUp();



            }
    }

    public void printPostOrder(){
        //TODO add code here
        if(empty()){
            System.out.println("There is no Tree");
        }else{

            root.right.printPostOrder();
            root.left.printPostOrder();
            System.out.println(root.elem);

        }
    }
    public String toString() {
        return "[" + this.root + "]";
    }
}
