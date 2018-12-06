package com.tobio.performance.collections.lists.tests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class ListsTestPerformance {

    protected static final boolean ADD_AT_THE_BEGINNING = true;
    protected static final boolean ADD_AT_THE_MIDDLE    = false;
    protected static final boolean ADD_AT_THE_END       = false;


    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            int samples = 100000;
            // performanceTest(samples);
            // performanceTest(samples * 5);
            // performanceTest(samples * 10);
            performanceTest(samples * 100);
        }
        System.exit(0);
    }


    private static void performanceTest(int samples) {

        System.out.println(">>>> Samples:  " + samples);

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Vector<Integer> vectorList = new Vector<>();

        operationAdd(samples, arrayList, linkedList, vectorList);

        // operationGet(samples, arrayList, linkedList, vectorList);

        // operationRemove(samples, arrayList, linkedList, vectorList);

        System.out.println();
    }


    private static void operationAdd(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {

        System.out.println(">> Operation <add>:  ");

        if (ADD_AT_THE_BEGINNING) {
            // listAddAtTheBeginning("ArrayList add", samples, arrayList);
            listAddAtTheBeginning("LinkedList add", samples, linkedList);
            // listAddAtTheBeginning("Vector add", samples, vectorList);
        }
        else if (ADD_AT_THE_MIDDLE) {
            listAddAtInTheMiddle("ArrayList add", samples, arrayList);
            listAddAtInTheMiddle("LinkedList add", samples, linkedList);
            listAddAtInTheMiddle("Vector add", samples, vectorList);
        }
        else if (ADD_AT_THE_END) {
            listAddAtTheEnd("ArrayList add", samples, arrayList);
            listAddAtTheEnd("LinkedList add", samples, linkedList);
            listAddAtTheEnd("Vector add", samples, vectorList);
        }

        System.out.println();
    }


    private static void operationGet(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {

        System.out.println(">> Operation <get>:  ");

        listGet("ArrayList get", arrayList);
        listGet("LinkedList get", linkedList);
        listGet("Vector get", vectorList);

        System.out.println();
    }


    private static void operationRemove(int samples, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, Vector<Integer> vectorList) {

        System.out.println(">> Operation <remove>:  ");

        listRemove("ArrayList remove", arrayList);
        listRemove("LinkedList remove", linkedList);
        listRemove("Vector remove", vectorList);

        System.out.println();
    }


    private static void printResults(String type, long startTime, long endTime) {

        long duration = endTime - startTime;
        double elapsedTime = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS) / 1000.0;
        System.out.println(type + ":  " + duration + ", " + elapsedTime + "ms");
    }


    private static void listGet(String type, List<Integer> list) {

        int size = list.size();
        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        printResults(type, startTime, endTime);
    }


    private static void listAddAtTheEnd(String type, int size, List<Integer> list) {

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        printResults(type, startTime, endTime);
    }


    private static void listAddAtTheBeginning(String type, int size, List<Integer> list) {

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            list.add(0, i);
        }
        long endTime = System.nanoTime();
        printResults(type, startTime, endTime);
    }


    private static void listAddAtInTheMiddle(String type, int size, List<Integer> list) {

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            list.add(i / 2, i);
        }
        long endTime = System.nanoTime();
        printResults(type, startTime, endTime);
    }


    private static void listRemove(String type, List<Integer> list) {

        int size = list.size();
        long startTime = System.nanoTime();

        for (int i = size - 1; i >= 0; i--) {
            list.remove(i);
        }
        long endTime = System.nanoTime();
        printResults(type, startTime, endTime);
    }

}
