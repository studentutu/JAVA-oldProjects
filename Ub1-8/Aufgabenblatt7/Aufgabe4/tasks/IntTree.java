class IntTree {

    private class Node {

        int elem;
        Node left = null;
        Node right = null;

        Node(int elem) {
            this.elem = elem;
        }

        void add(int elem) {
            //TODO add code here
            if(elem<this.elem){//this.elem< elem

                if(this.left==null){
                    this.left=new Node(elem);
                }else{
                    this.left.add(elem);
                }

            }else{//this.elem>=elem
                if(this.right==null){
                    this.right=new Node(elem);
                }else{
                    this.right.add(elem);
                }

            }
        }

        int countNodes() {
            //TODO add code here
            if(left==null && right==null){

                return 1;//leaves

            }else if(left==null && right!=null){

                return 1+right.countNodes();//count in right Tree

            }else if(right==null&&left!=null){

                return 1+left.countNodes();//count in left Tree

            }else {
                return 1+left.countNodes()+right.countNodes();//count in left Tree and in right Tree

            }

        }

        int countLeaves() {
            //TODO add code here

            if(right==null && left==null){

                return 1;//leave

            }else if(left==null && right!=null){

                return right.countLeaves();//count leaves in right Subtree

            }else if(right==null && left!=null){

                return left.countLeaves();//count leaves in left Subtree

            }else{
                return left.countLeaves()+right.countLeaves();

            }

        }

        int height() {
            //TODO add code here

            return 0;
        }
    }

    private Node root = null;

    public void add(int elem) {
        //TODO add code here
        if(empty()){
            root=new Node(elem);
        } else{
            root.add(elem);
        }
    }

    public boolean empty() {
        return this.root == null;
    }

    public int countNodes() {
        //TODO add code here
        if(root==null){return 0;}else
        if(root.left==null&&root.right==null){return 1;}
        else {
            return 1+root.left.countNodes() + root.right.countNodes();
        }

    }

    public int countLeaves() {
        //TODO add code here
        if(root==null){return 0;}else
        if (root.left==null&&root.right==null){return 1;}
        else{
            return root.left.countLeaves()+root.right.countLeaves();
        }

    }

    public int height() {
        //TODO add code here
        if(root==null){return 0;}else{

            return  root.left.countNodes()>=root.right.countNodes()? root.left.countNodes():root.right.countNodes();
        }

    }
}