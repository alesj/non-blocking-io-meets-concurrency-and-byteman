/**
 * OpenBlend 2015
 */
package org.openblend.cafebabe.concurrency;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author Ales Justin
 */
public class Atomics {
    private static final AtomicReferenceFieldUpdater<Atomics, Foo> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Atomics.class, Foo.class, "foo");

    private volatile Foo foo;
    private AtomicReference<Foo> fooAR = new AtomicReference<>();

    public static void main(String[] args) {
        Atomics atomics = new Atomics();
        atomics.foo = new Foo(2);
        atomics.fooAR.set(new Foo(1));

        Foo foo1 = new Foo(1);
        Foo foo2 = new Foo(2);

        Foo x = fieldUpdater.get(atomics);
        System.out.println(x);
        System.out.println(fieldUpdater.compareAndSet(atomics, foo2, foo1)); // NOTE: equals!!
        System.out.println(fieldUpdater.compareAndSet(atomics, x, foo1));
        System.out.println(atomics.foo);

        System.out.println("----");

        Foo y = atomics.fooAR.get();
        System.out.println(y);
        System.out.println(atomics.fooAR.compareAndSet(y, foo2));
        System.out.println(atomics.fooAR);
    }

    private static class Foo {
        private int n;

        public Foo(int n) {
            this.n = n;
        }

        @Override
        public String toString() {
            return "n:" + n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Foo foo1 = (Foo) o;

            return n == foo1.n;

        }

        @Override
        public int hashCode() {
            return n;
        }
    }
}
