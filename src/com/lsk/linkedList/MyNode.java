package com.lsk.linkedList;

/**
 * @Author:${六月的雨}
 * @Date:2020/6/25 17:59
 * @Description:20data_structure com.lsk.linkedList
 */
public class MyNode extends Node {
    public String name;
    public String nickName;

    public MyNode(int no,String name, String nickName) {
        this.data = no;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "MyNode{" +
                "no=" + data +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
