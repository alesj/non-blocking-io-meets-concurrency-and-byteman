
Concurrency meets Byteman
=============================
<br />
<br />
<br />
<br />
<br />
<br />
<br />
Aleš Justin [ajustin@redhat.com](mailto:ajustin@redhat.com)

???

Visit http://alesj.github.io/non-blocking-io-meets-concurrency-and-byteman to see slides in presentation mode.

---

Agenda
======

### - Core concurrency concepts
### - High level concurrency objects
### - Byteman intro and its Arquillian usage


---

Core concurrency concepts
======

- Processes
- Threads
    - (Runnable::run)
    - sleep
    - interrupt
    - yield
    - join
- Executor
- synchronized keyword
    - instance
    - class
    - object
    - re-entry
- atomic access
    - all refs, most primitive (excl. long, double)
    - all volatile
- liveness
    - deadlock
    - starvation
    - livelock
- guarded blocks
    - wait (loop!), notify, notifyall
    - must have monitor / synchronized!
- immutable objects
- double checked locking
    - volatile!
    - init on demand holder idiom

---

High level concurrency objects
======

- java.util.concurrent
- Lock objects
    - Read, Write, ReadWrite, re-entrant
- Executors
    - service (lifecycle)
    - scheduled
    - Thread pools
    - Fork/Join
- Collections
    - BlockingQueue
    - ConcurrentMap
    - ConcurrentNavigableMap
    - Check Guava lib
- Atomic variables
    - AtomicX (X - Integer, Boolean, Reference, ...)
- ThreadLocalRandom
    - Better performance with Fork/Join

---

Byteman
======

- intro
    - http://byteman.jboss.org/
- Arquillian usage
    - https://github.com/GoogleCloudPlatform/appengine-tck/tree/master/core/byteman/src/test/java/com/google/appengine/tck/byteman
    - JAVA_OPTS="$JAVA_OPTS -Xbootclasspath/p:${BYTEMAN_HOME}/lib/byteman-submit.jar -javaagent:${BYTEMAN_HOME}/lib/byteman.jar=port:9091"

---

Links
=====

### References

https://docs.oracle.com/javase/tutorial/essential/concurrency/
https://en.wikipedia.org/wiki/Double-checked_locking
https://github.com/google/guava


### Presentation tool used
https://github.com/gnab/remark/

*Aleš Justin (ajustin@redhat.com, @alesj)*
