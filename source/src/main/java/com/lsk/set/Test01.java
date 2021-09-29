package com.lsk.set;

import java.util.ArrayList;

/**
 * @Author:林立可
 * @Date:2021/8/21 16:04
 * @PackageName:20data_structure com.lsk.set
 * @Description:
 */

/*按要求实现:
        (1)封装一个新闻类，包含标题和内容属性，提供get、set方法，重马toString方法，打印对象时只打印标题;
        (2)只提供一个带参数的构造器，实例化对象时，只初始化标题;并且实例化两个对象:
        新闻一:新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧
        新闻二:男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生
        (3)将新闻对象添加到ArrayList集合中，并且进行倒序遍历;
        (4)在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后在后边加“.….”(5)在控制台打印遍历出经过处理的新闻标题;*/

public class Test01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        int size = arrayList.size();

        while (size > 0) {
            News s = (News)arrayList.get(--size);
            if(s.getTitle().length()>=15){
                s.setTitle(s.getTitle().substring(0,15)+"...");
            }
            System.out.println(s);
        }
    }

}


class News {
    private String Title;
    private String content;

    public News(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  Title;
    }
}
