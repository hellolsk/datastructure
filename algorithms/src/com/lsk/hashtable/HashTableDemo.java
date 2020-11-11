package com.lsk.hashtable;

import java.util.Scanner;

/**
 * hashtable的实现形式是一个存放链表的数组，链表的头指针执行实体(可以是一串链表)
 * @author hellolsk
 *
 */
public class HashTableDemo {
	public static void main(String []args) {
		Hashtable hashtable = new Hashtable(7);
		String key ="";
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("add");
			System.out.println("list");
			System.out.println("find");
			System.out.println("exit");
			key = sc.next();
			switch (key) {
				case "add":
					System.out.println("input id");
					int id = sc.nextInt();
					System.out.println("input name");
					String name = sc.next();
					Employee employee = new Employee(id, name);
					hashtable.add(employee);
					break;
				case "list":
					hashtable.list();
					break;
				case "find":
					System.out.println("input id for find");
					id = sc.nextInt();
					hashtable.findById(id);
					break;
				case "exit":
					sc.close();
					System.exit(0);
					break;
			}
		}
	}
}

//雇员类
class Employee{
	public int id;
	public String name;
	public Employee next;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}

//创建hashtable，管理链表
class Hashtable{
	private EmpLinkedList[] array;
	private int size;	//链表条数
	//构造器初始化
	public Hashtable(int size) {
		this.size = size;
		array= new EmpLinkedList[size];
		for(int i=0;i<array.length;i++) {
			array[i]=new EmpLinkedList();
		}
	}
	public void add(Employee employee) {
		int hashNo = hash(employee.id);
		array[hashNo].add(employee);
	}
	//遍历数组，遍历hashtable
	public void list() {
		for(int i=0;i<size;i++) {
			array[i].list(i);
		}
	}
	//查找by id
	public void findById(int id) {
		int hashNo =  hash(id);
		Employee employee = array[hashNo].findById(id);
		if(employee!=null) {
			System.out.printf("第%d条链表中找到雇员id为%d\n",(hashNo+1),id);
		}else {
			System.out.println("没有找到");
		}
	}
	//取模法实现散列函数
	public int hash(int id) {
		return id%size;
	}
}

//链表结构
class EmpLinkedList{
	private Employee head;
	/**
	 * 添加员工方法，默认是顺序添加在尾部,不存在头结点
	 */
	public void add(Employee employee) {
		if(head==null) {
			head = employee;
			return;
		}
		//找到尾部添加
		Employee currEmp = head;
		while(currEmp.next!=null) {
			currEmp=currEmp.next;
		}
		currEmp.next = employee;
	}

	/**
	 *遍历信息
	 */
	public void list(int no) {
		if(head==null) {
			System.out.println("第"+(no+1)+"链表为空");
			return;
		}
		System.out.print("第"+(no+1)+"链表的员工信息为");
		Employee currEmp = head;
		while(true) {
			System.out.printf("——>id=%d,name=%s\t",currEmp.id,currEmp.name);
			if(currEmp.next==null) {
				break;
			}
			currEmp = currEmp.next;
		}
		System.out.println();
	}

	/**
	 * 查找
	 */
	public Employee findById(int id) {
		if(head==null) {
			System.out.println("链表为空");
			return null;
		}
		Employee currEmp = head;
		while(true) {
			if(currEmp.id == id) {
				break;
			}
			if(currEmp.next==null) {//遍历完没有找到
				currEmp=null;
				break;
			}
			currEmp=currEmp.next;
		}
		return currEmp;
	}
}
