package com.lsk.tree;

/**
 * 线索二叉树
 */
public class ThreadedBinaryTree {
    private MyThreadedNode root;
    //记录前一个结点便于线索化
    private MyThreadedNode preNode = null;

    public MyThreadedNode getRoot() {
        return root;
    }

    public void setRoot(MyThreadedNode root) {
        this.root = root;
    }

    public MyThreadedNode getPreNode() {
        return preNode;
    }

    public void setPreNode(MyThreadedNode preNode) {
        this.preNode = preNode;
    }

    /**
     * 重载线索化方法
     */
    public void threaded(){
        this.threaded(root);
    }
    public void preThreaded(){
        this.preThreaded(root);
    }
    public void postThreaded(){
        this.postThreaded(root);
    }


    /**
     * 前序线索化二叉树
     * @param node
     */
    public void preThreaded(MyThreadedNode node){
        if(node==null){
            return;
        }
        //判断当前结点是否线索化结点
        //当前结点没有前驱，那么它的前驱就是上一个结点
        if(node.getLeft()==null){
            node.setLeft(preNode);
            node.setLeftType(1);
        }
        //前一结点不为空，且没有后继，其后继便指向当前结点
        if(preNode!=null && preNode.getRight()==null ){
            preNode.setRight(node);
            preNode.setRightType(1);
        }
        preNode = node;

        //注意哦：一个结点的线索化并不是在一次递归中完成的
        //线索化左子树
        if(node.getLeftType()==0){
            preThreaded(node.getLeft());
        }
        //线索化右子树
        if(node.getRightType()==0){
            preThreaded(node.getRight());
        }
    }
    /**
     * 中序线索化二叉树
     * @param node 二叉树的根节点
     */
    public void threaded(MyThreadedNode node){
        //结点为空
        if(node==null){
            return;
        }
        /**
         * 递归
         * 1,线索化左子树
         * 2,线索化当前结点
         * 3,线索化右子树
         */

        threaded(node.getLeft());

        //叶子结点时，前驱置为空
        if(node.getLeft()==null){
            node.setLeft(preNode);//置空，也即置为preNode
            node.setLeftType(1);
        }
        //前驱结点不为空，且前驱结点为叶子结点时，后继指向当前结点
        if(preNode!=null && preNode.getRight()==null ){
            preNode.setRight(node);
            preNode.setRightType(1);
        }
        //更新preNode
        preNode = node;

        threaded(node.getRight());

    }


    /**
     * 后序线索化二叉树
     * @param node
     */
    public void postThreaded(MyThreadedNode node){
        if(node==null){
            return;
        }
        postThreaded(node.getLeft());
        postThreaded(node.getRight());

        if(node.getLeft()==null){
            node.setLeft(preNode);
            node.setLeftType(1);
        }
        if(preNode!=null && preNode.getRight()==null){
            preNode.setRight(node);
            preNode.setRightType(1);
        }
        preNode = node;
    }

    /**
     * 前序遍历
     */
    public void threadedListPre(){
        MyThreadedNode node = root;
        while(node!=null){
            //先打印没有线索化的结点
            while(node.getLeftType()==0){
                System.out.println(node);
                node = node.getLeft();
            }
            //退出时打印当前线索结点
            System.out.println(node);
            //向后寻找
            node = node.getRight();
        }
    }
    /**
     * 按照中序线索化的形式遍历
     */
    public void threadedList(){
        MyThreadedNode node = root;
        while (node!=null){
            //直到找到线索化的结点，叶子结点
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            System.out.println(node);
            //当前结点存在后继结点便打印
            while(node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }

    /**
     * 后续线索化遍历
     */
    public void threadedListPost(){
        MyThreadedNode node = root;
        //找到第一个线索化的结点
        while(node!=null && node.getLeftType()==0){
            node = node.getLeft();
        }
        while(node!=null){
            //后继已经线索化的直接打印
            if(node.getRightType()==1){
                System.out.println(node);
                preNode = node;
                node = node.getRight();
            }else{
                //未被线索化结点，其实是一个子树的根节点，此时要区分：
                //如果当前结点后继是上一结点,即右子树回调的直接打印
                if(node.getRight()==preNode){
                    System.out.println(node);
                    //注意如果这个子树的根节点为树的根节点，遍历结束
                    if(node==root){
                        return;
                    }
                    preNode = node;
                    //且当前结点置换为父节点，否则继续右线索会导致死循环
                    node = node.getParent();
                }else {
                    //左子树回调的则不会有死循环的风险，直接左线索遍历
                    node = node.getRight();
                    while(node!=null && node.getLeftType()==0){
                        node = node.getLeft();
                    }
                }
            }
        }
    }
}

/**
 * 线索二叉树结点
 */
class MyThreadedNode {
    private int no;
    private String name;
    private MyThreadedNode left;
    private MyThreadedNode right;
    //后续线索化遍历中用于区分左、右子树遍历，记录他们的父节点
    private MyThreadedNode parent;
    //约定：leftType=0表示指向左子树，=1表示指向前驱结点
    //rightType=0表示指向右子树，=1表示指向后驱结点
    private int leftType;
    private int rightType;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyThreadedNode getLeft() {
        return left;
    }

    public void setLeft(MyThreadedNode left) {
        this.left = left;
    }

    public MyThreadedNode getRight() {
        return right;
    }

    public void setRight(MyThreadedNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public MyThreadedNode getParent() {
        return parent;
    }

    public void setParent(MyThreadedNode parent) {
        this.parent = parent;
    }

    public MyThreadedNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}
