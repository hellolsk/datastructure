package com.lsk.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 赫夫曼数的构建思路：
 * 定义：带有权值路劲之和最小的二叉树即为赫夫曼树
 * 思路：1，将节点排序，选出权值最小的两个的节点；
 * 		2，将权值之和作为新的父节点，组成了一棵新的二叉树
 * 		3，再将新的二叉树加入权值排序，继续组件新的二叉树；
 * 		4，重复1、2、3；直到所有节点都被处理组建成一个根结点时*/

public class HuffmanTree {
	public static void main(String[] args) {
		int[] arr = { 13, 7, 8, 3, 29, 6, 1};
		Node root = createhuffmanTree(arr);
		preOrder(root);
	}

//	 * 前序遍历赫夫曼树
	public static void preOrder(Node root)
	{
		if(root!=null) {
			root.preOrder();
		}else {
			System.out.println("该树为空！");
		}
	}


//	 * 创建赫夫曼树

	public static Node createhuffmanTree(int[] arr) {
		// arr的每一个元素即为一个node节点
		// 将node放入list中以便施工sort方法
		List<Node> node = new ArrayList<>();
		for (int weight : arr) {
			node.add(new Node(weight));
		}

//		System.out.println(node);

		while(node.size()>1)
		{
			Collections.sort(node);
			Node leftNode = node.get(0);	//较小的位于左子树
			Node rightNode = node.get(1);
			Node parent = new Node(leftNode.weight + rightNode.weight);	//组建新树
			parent.left = leftNode;		//分别链接到左右子树
			parent.right = rightNode;
			node.add(parent);	//加入节点中重新排序
			node.remove(leftNode);
			node.remove(rightNode);
		}
//		System.out.println("组建后："+node);
		//返回赫夫曼树
		return node.get(0);
	}

}


// 节点类 为了让node结点能实现排序功能，这里继承Comparable

class Node implements Comparable<Node> {
	Node left; // 左子树
	Node right;// 右子树
	byte data; // 存放数据
	int weight;// 权值


	public Node(int weight) {
		super();
		this.weight = weight;
	}

	public Node(byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}


//	前序遍历结点

	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null)
		{
			this.right.preOrder();
		}
	}


	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}
	@Override
	public int compareTo(Node o) {
		// 实现从小到大排序
		return this.weight - o.weight;
	}
}
