package com.lsk.huffman;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        // 将字符串转为字节数组形式
        byte[] bytes = content.getBytes();
        //测试字节长度40，空格也算的
        System.out.println(bytes.length);
        //测试打印字节数组，分别对应ASCII编码的整型数值
        System.out.println(Arrays.toString(bytes));
        List<Node> nodes = getNodes(bytes);
        //测试转换后的Node结点对象
        System.out.println(nodes);
        //根据结点创建赫夫曼树，返回一个根结点
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历：");
        huffmanTreeRoot.preOrder();
        //getCodes(huffmanTreeRoot, "", stringBuilder);
        //根据赫夫曼树创建赫夫曼编码表
        huffmanCodes = getCodes(huffmanTreeRoot);
        System.out.println("生成的赫夫曼编码表为：" + huffmanCodes);
        //测试压缩,返回压缩后的字节数组，长度17。可见本例中压缩率为23/40=57.5%
        byte[] bytesCodes = huffmanZip(bytes);
        System.out.println(Arrays.toString(bytesCodes));
        //解压方法，返回原始字符串
        byte[] originalBytes = decode(huffmanCodes, bytesCodes);
        System.out.println(new String(originalBytes));
    }

	/**
	 * 创建赫夫曼树
	 *
	 * @param nodes 传入的node数组
	 * @return 返回一个赫夫曼树根结点
	 */
	public static Node createHuffmanTree(List<Node> nodes) {

		while (nodes.size() > 1) {
			Collections.sort(nodes);
			Node leftNode = nodes.get(0); // 较小的位于左子树
			Node rightNode = nodes.get(1);
			Node parent = new Node(null, leftNode.weight + rightNode.weight); // 组建新树
			parent.left = leftNode; // 分别链接到左右子树
			parent.right = rightNode;
			nodes.add(parent); // 加入节点中重新排序
			nodes.remove(leftNode);
			nodes.remove(rightNode);
		}
		// 返回赫夫曼树
		return nodes.get(0);
	}

	/**
	 * 遍历字节数组，将字符出现次数作为对应权值存入hashMap并转换为Node结点对象
	 *
	 * @param bytes 传入的字节数组
	 * @return 返回一个已经转换好的Node结点数组
	 */
	public static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes = new ArrayList<Node>();
		Map<Byte, Integer> elementMap = new HashMap<>();
		// 遍历字节数组拿到数据，统计每个字符出现的次数作为权值
		for (byte b : bytes) {
			// 实质上将遍历得到的每个字节当做key
			Integer count = elementMap.get(b);
			// 没有即存放，此时value为1
			if (count == null) {
				elementMap.put(b, 1);
			} else {
				elementMap.put(b, count + 1);
			}
		}

		// 再将map转为node对象：key——>data;value——>weight
		// map的遍历
		for (Map.Entry<Byte, Integer> entry : elementMap.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

    /**
     * 按照赫夫曼编码表规则将原始数据压缩成字节数组
     *
     * @param bytes
     * @param huffmanCodes
     * @return
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //将bytes数组按照赫夫曼编码规则拼接成一个二进制串
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuilder.toString());

        //定义赫夫曼压缩的字节数组的长度
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //定义赫夫曼压缩的字节数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        //对字符串8个一截取，并放入对应压缩后的字节数组中
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            //用于装载每次截取的字符串
            String str;
            if (i + 8 > stringBuilder.length()) {//某一个不够8位时
                str = stringBuilder.substring(i); //此时截取起始位置到末尾
            } else {
                str = stringBuilder.substring(i, i + 8);
            }
            //将String字符数组转换为byte
			/* 细节：以第一个8位字符串"10101000"为例（i l ' '->101 01 000）
			将它强转为byte，溢出后转换成了负数求补码，所以输出是-88*/
            huffmanCodeBytes[index] = (byte) Integer.parseInt(str, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * 封装：将原始字节数组转换为赫夫曼编码的字节数组
     *
     * @param bytes 压缩前数组
     * @return 返回压缩后数组
     */
    public static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        getCodes(huffmanTreeRoot);
        //测试赫夫曼编码
		for(Byte key : huffmanCodes.keySet()){
			System.out.println("key:"+key+"--->"+huffmanCodes.get(key));
		}
        byte[] bytesCodes = zip(bytes, huffmanCodes);
        return bytesCodes;
    }

    /**
     * 将一个字节转换成二进制字符串形式。
     * 截取：因为返回的int32位的补码形式，所以需要截取8位
     * 补位：正数不足8位时截取会造成越界异常，需要补高位，比如1，补成1 0000 0001
     * 判断：都是按8位处理的，但最后一位不需要截取和补位（可能就位数不足），比如28，1110，补成0000 1110，会造成多义性
     * @param flag 判断是否需要补高位(对正数，对最后一个不需要)
     * @param b 传入字节
     * @return
     */
	public static String byteToBitString(boolean flag,byte b){
		int temp = b;
		if(flag){
		    //不足8位时，和1 0000 0000 与运算，可以补齐前面的0
            temp |= 256;
        }
		String str = Integer.toBinaryString(temp);
		if(flag){
		    //只需要截取后面的8位即可
		    return str.substring(str.length()-8);
        }else{
            return str;
        }
	}

    /**
     * @param huffManCodes 赫夫曼编码表
     * @param huffManBytes 赫夫曼编码的字节数组
     * @return
     */
	public static byte[] decode(Map<Byte,String> huffManCodes,byte[] huffManBytes){
	    //1，首先将编码的字节数组转换为二进制串
        //2，遍历map，根据<string,byte>匹配转换成每个字节
        //3，以字节数组的形式返回
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<huffManBytes.length;i++){
            byte b = huffManBytes[i];
            //判断是否是最后一个字符，因为他可能位数不足
            boolean flag = (i==huffManBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,b));
        }
        System.out.println(stringBuilder.toString());
        //实现map翻转
        Map<String,Byte> reverseCodeMap = new HashMap<>();
        for(Map.Entry<Byte,String> entry : huffManCodes.entrySet()){
            reverseCodeMap.put(entry.getValue(),entry.getKey());
        }
        //存放匹配的字节数组
        List<Byte> byteList = new ArrayList<>();
        for(int i = 0;i<stringBuilder.length();){
            int count = 1; //第二指针，i不动，count移位
            boolean flag = true; //是否匹配的标志
            Byte b = null; //记录匹配对应的字节
            while(flag){
                String s = stringBuilder.substring(i, i + count);
                b = reverseCodeMap.get(s);
                if(b==null){
                    count++; //没有匹配的继续移动指针
                }else {
                    flag = false;
                }
            }
            byteList.add(b);
            i += count; //每次匹配在上次结束的地方开始
        }
        //list数组转换为byte数组
        byte[] originalBytes = new byte[byteList.size()];
        for(int i = 0;i<byteList.size();i++){
            originalBytes[i] = byteList.get(i);
        }
	    return originalBytes;
    }

    /**
     * 由赫夫曼树生成对应的赫夫曼编码表
     * 思路：1->赫夫曼编码表存放在Map<byte,String>中
     * 2->形如：{32(' ')=01, 97('a')=100, 100=11000, 117=11001......
     * 3->左子结点是0，右子结点是1，string一个个拼接而成(使用stringBuilder)
     */
    //1，定义一个静态map结构的huffmanCodes
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2，定义一个stringBuilder，用于存放叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 根据赫夫曼树构建赫夫曼编码表的具体算法：
     * 这是一个递归过程，将传入赫夫曼根节点的赫夫曼树生成对应的赫夫曼编码表
     *
     * @param node          待传入的赫夫曼树根节点
     * @param code          拼接规则：左子结点是0，右子结点是1
     * @param stringBuilder 拼接后的路径
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder strBuilder = new StringBuilder(stringBuilder);
        //将code拼接到strBuilder
        strBuilder.append(code);
        if (node != null) {
            //非叶子结点
            if (node.data == null) {
                //向左递归
                getCodes(node.left, "0", strBuilder);
                //向右递归
                getCodes(node.right, "1", strBuilder);
            } else {
                //遍历到了叶子结点，则存放入huffmanCodes中
                huffmanCodes.put(node.data, strBuilder.toString());
            }
        }
    }

    /**
     * 为了调用方便，对getCodes进行重载，直接返回huffmanCodes
     *
     * @param node 传入的赫夫曼树根结点
     * @return 返回一个map结构的赫夫曼编码表
     */
    public static Map<Byte, String> getCodes(Node node) {
        if (node == null) {
            return null;
        } else {
            //处理root的左子树
            getCodes(node.left, "0", stringBuilder);
            //处理root的右子树
            getCodes(node.right, "1", stringBuilder);
            return huffmanCodes;
        }
    }

    /**
     * 前序遍历赫夫曼树返回的根节点
     *
     * @param root
     */

    // 前序遍历的方法
    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }
}

/*
 * 节点类 为了让node结点能实现排序功能，这里继承Comparable
 */
class Node implements Comparable<Node> {
    Node left; // 左子树
    Node right;// 右子树
    Byte data; // 存放数据
    int weight;// 权值

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    /*
     * 前序遍历结点
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
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
