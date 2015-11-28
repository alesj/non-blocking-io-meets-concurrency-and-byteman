
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
    - most primitive
    - all volatile
- liveness
    - deadlock
    - starvation
    - livelock
- guarded blocks
    - wait (loop!), notify, notifyall
- immutable objects

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
- Atomic variables
    - AtomicX (X - Integer, Boolean, Reference, ...)
- ThreadLocalRandom
    - Better performance with Fork/Join

---

Byteman
======

- intro
- Arquillian usage

---

Links
=====

### References

https://docs.oracle.com/javase/tutorial/essential/concurrency/


### Presentation tool used
https://github.com/gnab/remark/

*Aleš Justin (ajustin@redhat.com, @alesj)*
