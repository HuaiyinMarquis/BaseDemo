package com.exampleDemo.JavaVersionTest;

import org.junit.Test;

/**
 *1. 新增导入静态方法的功能,*表示导入该类下所有静态方法，也可以直接导入某个方法
 */
import static org.springframework.util.StringUtils.*;
import static org.springframework.util.StringUtils.isEmpty;


/**
 * Created by ChenMP on 2017/10/31.
 */
public class Java5Test {

    /**
     * 1.新增导入静态方法测试
     */
    @Test
    public void TestStaticImport() {
        String[] arr = {"a","b"};
        isEmpty(null);
        addStringToArray(arr,"cd");
    }

    /**
     * 2.增强for循环，可以使用数组和List
     */

    /**
     * 3.枚举类的实现 enum
     */

    /**
     * 4.Reflect 反射
     */
    @Test
    public void TestReflect() throws ClassNotFoundException {
        /*********************************Get Class***********************************/
//        对象的getClass()方法;
//        类的.class(最安全/性能最好)属性;
//        运用Class.forName(String className)动态加载类,className需要是类的全限定名(最常用).

        /*********************************Get Class Details***********************************/
//        构造器	Constructor<T> getConstructor(Class<?>... parameterTypes)
//        包含的方法	Method getMethod(String name, Class<?>... parameterTypes)
//        包含的属性	Field getField(String name)
//        包含的Annotation	<A extends Annotation> A getAnnotation(Class<A> annotationClass)
//        内部类	Class<?>[] getDeclaredClasses()
//        外部类	Class<?> getDeclaringClass()
//        所实现的接口	Class<?>[] getInterfaces()
//        修饰符	int getModifiers()
//        所在包	Package getPackage()
//        类名	String getName()
//        简称	String getSimpleName()

        /*********************************Get Class Type***********************************/
//        注解类型?	boolean isAnnotation()
//        使用了该Annotation修饰?	boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)
//        匿名类?	boolean isAnonymousClass()
//        数组?	boolean isArray()
//        枚举?	boolean isEnum()
//        原始类型?	boolean isPrimitive()
//        接口?	boolean isInterface()
//        obj是否是该Class的实例	boolean isInstance(Object obj)

        /*********************************Create Object***********************************/
//        使用Class对象的newInstance()方法来创建该Class对象对应类的实例(这种方式要求该Class对象的对应类有默认构造器).
//        先使用Class对象获取指定的Constructor对象, 再调用Constructor对象的newInstance()方法来创建该Class对象对应类的实例(通过这种方式可以选择指定的构造器来创建实例).
    }

    /**
     * 5.Annotation 注解
     */

    /**
     * 6.泛型
     */

    /**
     * 7.Vararg 可变参数
     * add(int)
     */
    @Test
    public void testVararg(int... nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        System.out.println(result);
    }


}
