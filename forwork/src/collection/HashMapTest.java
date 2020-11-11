package collection;

import java.util.*;

/**
 * 实现对hashMap的排序
 * 实现对学生对象的年龄进行逆序排序
 * @Author:${六月的雨}
 * @Date:2020/6/28 09:33
 * @Description:20data_structure PACKAGE_NAME
 */
public class HashMapTest {
    public static void main(String args[]) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        hashMap.put(1, new User(20, "张三"));
        hashMap.put(2, new User(25, "李四"));
        hashMap.put(3, new User(30, "王五"));
        System.out.println(hashMap);
        System.out.println("----------------");
        HashMap<Integer, User> sortHashMap = sortHashMap(hashMap);
        System.out.println(sortHashMap);

    }

    /**
     * 实现对hashMap进行排序
     * 要求是传入一个hashMap，返回一个hashMap
     * @param hashMap
     * @return
     */
    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> hashMap) {
        //1，拿到hashMap中的entry集合
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();
        //2,将set集合转为list，便于利用工具类
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entries);
        //3,使用内部类实现自定义排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            //逆序排序就后面减掉前面一个

            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });
        //4，将list数据存入到linkedHashMap
        LinkedHashMap<Integer,User> linkedHashMap = new LinkedHashMap<>();
        for(Map.Entry<Integer,User> entry : list){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}
