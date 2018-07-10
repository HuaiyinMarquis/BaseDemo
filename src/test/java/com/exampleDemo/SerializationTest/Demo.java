package com.exampleDemo.SerializationTest;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        User user = new User();
        user.setName("Huaiyinmarquis").setAge(28).setEmotion("Happy").setDesc("some static");
        user.setShirt(new Shirt().setColor("Red").setSize(185));
        user.setSex("男");

/**********************************类的二进制转换************************************/
//        byte[] serialize = NormalSerializationUtil.serialize(user);
//        User copy = NormalSerializationUtil.deserialize(serialize, User.class);
//        System.out.println(copy);
/**********************************证明说明静态属性不参与序列化************************************/
//        NormalSerializationUtil.persistSerialize(user);
//        User copy = NormalSerializationUtil.persistDeserialize(User.class);
//        System.out.println(copy + "->" + copy.getDesc());
/*********证明没有实现序列化的父类属性不参与序列化,实现了序列化的父类的子类继承了父类的序列化***********/
//        NormalSerializationUtil.persistSerialize(user);
//        User copy = NormalSerializationUtil.persistDeserialize(User.class);
//        System.out.println(copy + "->" + copy.getSex());
/**********************************跳过transient序列化其修饰的属性以及浅克隆************************************/
//        User clone = user.clone();
//        user.getShirt().setColor("green");
//        System.out.println(clone);//浅克隆只是简单的复制了内存地址，对于复杂的成员变量没有实现深度克隆
/**********************************深克隆************************************/
        User clone = user.deepClone();
        user.getShirt().setColor("green");
        System.out.println(clone);//深克隆实现了包括其成员对象的克隆
    }
}
