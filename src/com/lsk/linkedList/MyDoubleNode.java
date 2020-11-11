package com.lsk.linkedList;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/29 14:42
 * @Description:20data_structure com.lsk.linkedList
 */
public class MyDoubleNode extends DoubleNode {
    protected String name;
    protected String nickName;

    public MyDoubleNode(int no,String name, String nickName) {
        this.data = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "MyDoubleNode{" +
                " data=" + data +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\''+
                '}';
    }
}
