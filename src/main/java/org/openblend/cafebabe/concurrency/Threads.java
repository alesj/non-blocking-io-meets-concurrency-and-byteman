/**
 * OpenBlend 2015
 */
package org.openblend.cafebabe.concurrency;

/**
 * @author Ales Justin
 */
public class Threads {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("CafeBabe!");
        Thread thread = new Thread(runnable);
        thread.start();
    }
}