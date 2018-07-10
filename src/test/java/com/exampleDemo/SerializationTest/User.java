package com.exampleDemo.SerializationTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User extends SuperUser implements Serializable,Cloneable {
    private String name;
    private int age;
    private static String desc;
    private Shirt shirt;
    private transient String emotion;

    //序列化对象
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(emotion);
    }

    //反序列化对象
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        emotion = (String) objectInputStream.readObject();
    }

    public static String getDesc() {
        return desc;
    }

    public static void setDesc(String desc) {
        User.desc = desc;
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    protected User deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (User) objectInputStream.readObject();
    }
}
