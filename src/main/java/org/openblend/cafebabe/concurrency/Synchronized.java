/**
 * OpenBlend 2015
 */
package org.openblend.cafebabe.concurrency;

/**
 * @author Ales Justin
 */
public class Synchronized {
    private int x;
    private final Object lock = new Object();

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public void doA() {
        synchronized (lock) {
            // A
        }
    }

    public void doB() {
        synchronized (lock) {
            // B
        }
    }

    public static synchronized void complexCalc() {
        // some complex calc ...
    }
}