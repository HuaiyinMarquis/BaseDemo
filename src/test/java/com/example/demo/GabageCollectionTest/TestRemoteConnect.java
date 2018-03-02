package com.example.demo.GabageCollectionTest;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by ChenMP on 2017/12/19.
 */
public class TestRemoteConnect {
    public static void main(String[] args) throws IOException, IntrospectionException, InstanceNotFoundException, ReflectionException {
        //用户名、密码
        Map<String, String[]> map = new HashMap<>();
        map.put("jmx.remote.credentials", new String[] { "monitorRole", "QED" });
        String jmxURL = "service:jmx:rmi:///jndi/rmi://112.74.185.65:12345/jmxrmi";

        JMXServiceURL serviceURL = new JMXServiceURL(jmxURL);
        JMXConnector connector = JMXConnectorFactory.connect(serviceURL, map);
        MBeanServerConnection mbsc = connector.getMBeanServerConnection();
        Set MBeanset = mbsc.queryMBeans(null, null);
        Iterator MBeansetIterator = MBeanset.iterator();
        while (MBeansetIterator.hasNext()) {
            ObjectInstance objectInstance = (ObjectInstance) MBeansetIterator
                    .next();
            ObjectName objectName = objectInstance.getObjectName();
            MBeanInfo objectInfo = mbsc.getMBeanInfo(objectName);
            System.out.print("ObjectName:" + objectName.getCanonicalName()
                    + ".");
            System.out.print("mehtodName:");
            for (int i = 0; i < objectInfo.getAttributes().length; i++) {
                System.out.print(objectInfo.getAttributes()[i].getName() + ",");
            }
            System.out.println();
        }
    }
}
