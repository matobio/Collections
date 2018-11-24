package com.tobio.maps.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class MapsPerformanceTest {

    protected static final boolean OPERATION_PUT      = true;
    protected static final boolean OPERATION_GET      = false;
    protected static final boolean OPERATION_REMOVE   = false;

    protected static final boolean TYPE_HASHMAP       = false;
    protected static final boolean TYPE_HASHTABLE     = true;
    protected static final boolean TYPE_LINKEDHASHMAP = false;
    protected static final boolean TYPE_TREEMAP       = false;


    public static void main(String[] args) {

        int size = 100000;

        // performanceTest(size);
        // performanceTest(size * 5);
        // performanceTest(size * 10);
        performanceTest(size * 100);

        System.exit(0);
    }


    private static void performanceTest(int size) {

        System.out.println(">>>> Size:  " + size);

        HashMap<String, Object> hashMap = new HashMap<>();
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        Hashtable<String, Object> hashtable = new Hashtable<>();
        TreeMap<String, Object> treeMap = new TreeMap<>();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(Integer.valueOf(i).toString());
        }
        Object[] array = (Object[]) list.toArray();

        if (OPERATION_PUT) {
            operationPut(array, hashMap, linkedHashMap, hashtable, treeMap);
        }
        if (OPERATION_GET) {
            operationGet(array, hashMap, linkedHashMap, hashtable, treeMap);
        }
        if (OPERATION_REMOVE) {
            operationRemove(array, hashMap, linkedHashMap, hashtable, treeMap);
        }

    }


    private static void operationRemove(Object[] array, HashMap<String, Object> hashMap, LinkedHashMap<String, Object> linkedHashMap, Hashtable<String, Object> hashtable,
            TreeMap<String, Object> treeMap) {

        System.err.println(">> Operation <remove>:  ");

        if (TYPE_HASHMAP) {
            hashMapRemove(hashMap, array);
        }
        if (TYPE_HASHTABLE) {
            hashtableRemove(hashtable, array);
        }
        if (TYPE_LINKEDHASHMAP) {
            linkedHashMapRemove(linkedHashMap, array);
        }
        if (TYPE_TREEMAP) {
            treeMapRemove(treeMap, array);
        }

    }


    private static void hashtableRemove(Hashtable<String, Object> map, Object[] array) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.remove(array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Hashtable remove", elapsedTimeInSeconds, duration);
    }


    private static void treeMapRemove(TreeMap<String, Object> map, Object[] array) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.remove(array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("TreeMap remove", elapsedTimeInSeconds, duration);
    }


    private static void linkedHashMapRemove(LinkedHashMap<String, Object> map, Object[] array) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.remove(array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedHashMap remove", elapsedTimeInSeconds, duration);
    }


    private static void hashMapRemove(HashMap<String, Object> map, Object[] array) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.remove(array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("HashMap remove", elapsedTimeInSeconds, duration);
    }


    private static void operationGet(Object[] array, HashMap<String, Object> hashMap, LinkedHashMap<String, Object> linkedHashMap, Hashtable<String, Object> hashtable,
            TreeMap<String, Object> treeMap) {

        System.err.println(">> Operation <get>:  ");

        if (TYPE_HASHMAP) {
            hashMapGet(hashMap, array);
        }
        if (TYPE_HASHTABLE) {
            hashtableGet(hashtable, array);
        }
        if (TYPE_LINKEDHASHMAP) {
            linkedHashMapGet(linkedHashMap, array);
        }
        if (TYPE_TREEMAP) {
            treeMapGet(treeMap, array);
        }
    }


    private static void treeMapGet(TreeMap<String, Object> map, Object[] array) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.get(array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("TreeMap get", elapsedTimeInSeconds, duration);
    }


    private static void linkedHashMapGet(LinkedHashMap<String, Object> map, Object[] array) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.get(array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedHashMap get", elapsedTimeInSeconds, duration);
    }


    private static void hashtableGet(Hashtable<String, Object> map, Object[] array) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.get(array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Hashtable get", elapsedTimeInSeconds, duration);
    }


    private static void hashMapGet(HashMap<String, Object> map, Object[] array) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.get(array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("HashMap get", elapsedTimeInSeconds, duration);
    }


    private static void operationPut(Object[] array, HashMap<String, Object> hashMap, LinkedHashMap<String, Object> linkedHashMap, Hashtable<String, Object> hashtable,
            TreeMap<String, Object> treeMap) {

        System.err.println(">> Operation <put>:  ");

        if (TYPE_HASHMAP) {
            hashMapPut(hashMap, array);
        }
        if (TYPE_HASHTABLE) {
            hashtablePut(hashtable, array);
        }
        if (TYPE_LINKEDHASHMAP) {
            linkedHashMapPut(linkedHashMap, array);
        }
        if (TYPE_TREEMAP) {
            treeMapPut(treeMap, array);
        }
    }


    private static void hashMapPut(HashMap<String, Object> map, Object[] array) {

        double elapsedTimeInSeconds;

        long myTotalMemoryBefore = Runtime.getRuntime().totalMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.put(Integer.valueOf(i).toString(), array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        long myTotalMemoryAfter = Runtime.getRuntime().totalMemory();
        long myHashMapMemory = myTotalMemoryAfter - myTotalMemoryBefore;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("HashMap put", elapsedTimeInSeconds, duration, myHashMapMemory);
    }


    private static void hashtablePut(Hashtable<String, Object> map, Object[] array) {

        double elapsedTimeInSeconds;

        long myTotalMemoryBefore = Runtime.getRuntime().totalMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.put(Integer.valueOf(i).toString(), array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        long myTotalMemoryAfter = Runtime.getRuntime().totalMemory();
        long myHashMapMemory = myTotalMemoryAfter - myTotalMemoryBefore;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Hashtable put", elapsedTimeInSeconds, duration, myHashMapMemory);
    }


    private static void linkedHashMapPut(LinkedHashMap<String, Object> map, Object[] array) {

        double elapsedTimeInSeconds;

        long myTotalMemoryBefore = Runtime.getRuntime().totalMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.put(Integer.valueOf(i).toString(), array[i]);
        }
        long endTime = System.nanoTime();
        long myTotalMemoryAfter = Runtime.getRuntime().totalMemory();
        long myHashMapMemory = myTotalMemoryAfter - myTotalMemoryBefore;
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedHashMap put", elapsedTimeInSeconds, duration, myHashMapMemory);
    }


    private static void treeMapPut(TreeMap<String, Object> map, Object[] array) {

        double elapsedTimeInSeconds;

        long myTotalMemoryBefore = Runtime.getRuntime().totalMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            map.put(Integer.valueOf(i).toString(), array[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        long myTotalMemoryAfter = Runtime.getRuntime().totalMemory();
        long myHashMapMemory = myTotalMemoryAfter - myTotalMemoryBefore;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("TreeMap put", elapsedTimeInSeconds, duration, myHashMapMemory);
    }


    public static void printResult(String type, double elapsedTimeInSeconds, long duration) {
        System.out.println(type + ":  " + duration + ", " + elapsedTimeInSeconds + "ms");
    }


    public static void printResult(String type, double elapsedTimeInSeconds, long duration, long memory) {
        System.out.println(type + ":  " + duration + ", " + elapsedTimeInSeconds + "ms" + ". Memory -> " + memory);
    }
}
