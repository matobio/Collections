package com.tobio.performance.collections.lists.tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class ListsTestPerformance {

    public static void main(String[] args) {

        int samples = 100000;
        performanceTest(samples);
        // performanceTest(samples * 5);
        // performanceTest(samples * 10);
        // performanceTest(samples * 100);

        System.exit(0);
    }


    private static void performanceTest(int samples) {

        System.out.println(">>>> Samples:  " + samples);

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Vector<Integer> vectorList = new Vector<>();

        operationAdd(samples, arrayList, linkedList, vectorList);

        operationGet(samples, arrayList, linkedList, vectorList);

        operationRemove(samples, arrayList, linkedList, vectorList);

        System.out.println();
    }


    private static void operationAdd(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {

        System.out.println(">> Operation <add>:  ");

        listAdd("ArrayList add", samples, arrayList);
        listAdd("LinkedList add", samples, linkedList);
        listAdd("Vector add", samples, vectorList);

        System.out.println();
    }


    private static void operationGet(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {

        System.out.println(">> Operation <get>:  ");

        listGet("ArrayList get", samples, arrayList);
        listGet("LinkedList get", samples, linkedList);
        listGet("Vector get", samples, vectorList);

        System.out.println();
    }


    private static void operationRemove(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {

        System.out.println(">> Operation <remove>:  ");

        listRemove("ArrayList remove", samples, arrayList);
        listRemove("LinkedList remove", samples, linkedList);
        listRemove("Vector remove", samples, vectorList);

        System.out.println();
    }


    private static void printResults(String type, long startTime, long endTime) {

        long duration = endTime - startTime;
        double elapsedTime = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        System.out.println(type + ":  " + duration + ", " + elapsedTime + "ms");
    }


    private static void listGet(String type, int samples, List<Integer> list) {

        long startTime;
        long endTime;

        startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        printResults(type, startTime, endTime);
    }


    private static void listAdd(String type, int samples, List<Integer> list) {

        long startTime = System.nanoTime();

        for (int i = 0; i < samples; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        printResults(type, startTime, endTime);
    }


    private static void listRemove(String type, int samples, List<Integer> list) {

        long startTime;
        long endTime;

        startTime = System.nanoTime();

        for (int i = samples - 1; i >= 0; i--) {
            list.remove(i);
        }
        endTime = System.nanoTime();
        printResults(type, startTime, endTime);
    }

}
