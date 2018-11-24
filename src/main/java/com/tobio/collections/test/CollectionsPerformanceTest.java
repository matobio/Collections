package com.tobio.collections.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class CollectionsPerformanceTest {

    public static void main(String[] args) {

        int samples = 100000;
        // performanceTest(samples);
        // performanceTest(samples * 5);
        // performanceTest(samples * 10);
        performanceTest(samples * 100);

        System.exit(0);
    }


    private static void performanceTest(int samples) {

        System.out.println(">>>> Samples:  " + samples);

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Vector<Integer> vectorList = new Vector<>();
        HashSet<Integer> hashSet = new HashSet<>();

        operationAdd(samples, arrayList, linkedList, vectorList, hashSet);

        operationGet(samples, arrayList, linkedList, vectorList, hashSet);

        operationRemove(samples, arrayList, linkedList, vectorList, hashSet);

    }


    private static void operationAdd(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList, HashSet<Integer> hashSet) {

        System.err.println(">> Operation <add>:  ");
        // arrayListAdd(samples, arrayList);

        // linkedListAdd(samples, linkedList);

        // vectorAdd(samples, vectorList);

        hashSetAdd(samples, hashSet);

    }


    private static void operationGet(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList, HashSet<Integer> hashSet) {

        System.err.println(">> Operation <get>:  ");

        arrayListGet(samples, arrayList);

        // linkedListGet(samples, linkedList);

        // vectorGet(samples, vectorList);
    }


    private static void operationRemove(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList, HashSet<Integer> hashSet) {

        System.err.println(">> Operation <remove>:  ");
        // arrayListRemove(samples, arrayList);

        // linkedListRemove(samples, linkedList);

        // vectorRemove(samples, vectorList);

        hashSetRemove(samples, hashSet);
    }


    private static void arrayListRemove(int samples, ArrayList<Integer> arrayList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // ArrayList remove

        startTime = System.nanoTime();

        for (int i = samples - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("ArrayList remove", elapsedTimeInSeconds, duration);
    }


    private static void hashSetRemove(int samples, HashSet<Integer> hashSet) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // ArrayList remove

        startTime = System.nanoTime();

        for (int i = samples - 1; i >= 0; i--) {
            hashSet.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("ArrayList remove", elapsedTimeInSeconds, duration);
    }


    private static void linkedListRemove(int samples, LinkedList<Integer> linkedList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // LinkedList remove
        startTime = System.nanoTime();

        for (int i = samples - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedList remove", elapsedTimeInSeconds, duration);
    }


    private static void vectorRemove(int samples, Vector<Integer> vectorList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // Vector remove
        startTime = System.nanoTime();

        for (int i = samples - 1; i >= 0; i--) {
            vectorList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Vector remove", elapsedTimeInSeconds, duration);
    }


    private static void printResult(String type, double elapsedTimeInSeconds, long duration) {
        System.out.println(type + ":  " + duration + ", " + elapsedTimeInSeconds + "ms");
    }


    private static void arrayListGet(int samples, ArrayList<Integer> arrayList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // ArrayList get

        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("ArrayList get", elapsedTimeInSeconds, duration);
    }


    private static void linkedListGet(int samples, LinkedList<Integer> linkedList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // LinkedList get
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedList get", elapsedTimeInSeconds, duration);
    }


    private static void vectorGet(int samples, Vector<Integer> vectorList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // Vector get
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            vectorList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Vector get", elapsedTimeInSeconds, duration);
    }


    private static void arrayListAdd(int samples, ArrayList<Integer> arrayList) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("ArrayList add", elapsedTimeInSeconds, duration);
    }


    private static void hashSetAdd(int samples, HashSet<Integer> hashSet) {
        double elapsedTimeInSeconds;

        long startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            hashSet.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("HashSet add", elapsedTimeInSeconds, duration);
    }


    private static void vectorAdd(int samples, Vector<Integer> vectorList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            vectorList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Vector add", elapsedTimeInSeconds, duration);
    }


    private static void linkedListAdd(int samples, LinkedList<Integer> linkedList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedList add", elapsedTimeInSeconds, duration);
    }
}
