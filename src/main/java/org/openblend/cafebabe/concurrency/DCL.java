/**
 * OpenBlend 2015
 */
package org.openblend.cafebabe.concurrency;

/**
 * @author wikipedia
 */
public class DCL {
    private volatile Helper helper;

    public synchronized Helper getHelper1() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }

    public Helper getHelper2() {
        Helper result = helper; // NOTE: result variable (only single access to volatile helper, 25% gain)
        if (result == null) {
            synchronized (this) {
                result = helper;
                if (result == null) {
                    helper = result = new Helper();
                }
            }
        }
        return result;
    }

    public Helper getHelper3() {
        return HelperHolder.helper;
    }

    private static class Helper {
    }

    private static class HelperHolder {
        public static final Helper helper = new Helper();
    }

}