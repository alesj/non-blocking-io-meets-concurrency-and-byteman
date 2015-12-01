/**
 * OpenBlend 2015
 */
package org.openblend.cafebabe.concurrency;

/**
 * @author oracle.com
 */
public class Guarded {
    private boolean joy;

    /*
    public void guardedJoy() {
        // Simple loop guard. Wastes processor time. Don't do this!
        while(!joy) {}
        System.out.println("Joy has been achieved!");
    }
    */

    public synchronized void guardedJoy() {
        // This guard only loops once for each special event, which may not
        // be the event we're waiting for.
        while(!joy) {
            try {
                wait();
            } catch (InterruptedException ignore) {}
        }
        System.out.println("Joy and efficiency have been achieved!");
    }

    public synchronized void notifyJoy() {
        joy = true;
        notifyAll();
    }
}