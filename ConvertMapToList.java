package first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertMapToList {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException {

        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        Constructor<ConvertMapToList> constructor = ConvertMapToList.class.getDeclaredConstructor();
        ConvertMapToList aCMtoL = constructor.newInstance();
        
        FileInputStream fi = new FileInputStream("a.txt");
        ObjectInputStream input = new ObjectInputStream(fi);
        ConvertMapToList obj = (ConvertMapToList)input.readObject();
        
        Class cls = Class.forName("ConvertMapToList");
        cls.newInstance();
        
        
        System.out.println("\n1. Export Map Key to List...");

        List<Integer> result = new ArrayList(map.keySet());

        result.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");

        List<String> result2 = new ArrayList(map.values());

        result2.forEach(System.out::println);

    }

}