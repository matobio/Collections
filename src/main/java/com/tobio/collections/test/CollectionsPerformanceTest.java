package com.tobio.collections.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class CollectionsPerformanceTest {

    public static void main(String[] args) {

        performanceTest(100000);
        performanceTest(1000000);
        performanceTest(100000000);

        System.exit(0);
    }


    private static void performanceTest(int samples) {

        System.out.println(">>>> Samples:  " + samples);

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Vector<Integer> vectorList = new Vector<Integer>();

        operationAdd(samples, arrayList, linkedList, vectorList);

        operationGet(samples, arrayList, linkedList, vectorList);

        operationRemove(samples, arrayList, linkedList, vectorList);

    }


    private static void operationRemove(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // ArrayList remove
        System.out.println(">> Operation <remove>:  ");
        startTime = System.nanoTime();

        for (int i = samples - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("ArrayList", elapsedTimeInSeconds, duration);

        // LinkedList remove
        startTime = System.nanoTime();

        for (int i = samples - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedList", elapsedTimeInSeconds, duration);

        // Vector remove
        startTime = System.nanoTime();

        for (int i = samples - 1; i >= 0; i--) {
            vectorList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Vector", elapsedTimeInSeconds, duration);
    }


    private static void printResult(String type, double elapsedTimeInSeconds, long duration) {
        System.out.println(type + ":  " + duration + "ns, " + elapsedTimeInSeconds + "ms");
    }


    private static void operationGet(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {
        double elapsedTimeInSeconds;
        long startTime;
        long endTime;
        long duration;
        // ArrayList get
        System.out.println(">> Operation <get>:  ");
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("ArrayList", elapsedTimeInSeconds, duration);

        // LinkedList get
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedList", elapsedTimeInSeconds, duration);

        // Vector get
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            vectorList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Vector", elapsedTimeInSeconds, duration);
    }


    private static void operationAdd(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {
        double elapsedTimeInSeconds;
        // ArrayList add
        System.out.println(">> Operation <add>:  ");
        long startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("ArrayList", elapsedTimeInSeconds, duration);

        // LinkedList add
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("LinkedList", elapsedTimeInSeconds, duration);

        // Vector add
        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            vectorList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        elapsedTimeInSeconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        printResult("Vector", elapsedTimeInSeconds, duration);
    }
}
