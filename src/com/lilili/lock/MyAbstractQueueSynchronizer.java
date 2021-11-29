package com.lilili.lock;

import sun.misc.Unsafe;

import java.io.Serializable;

/**
 * @Author LiYuan
 * @Date 2021/8/5
 **/
public abstract class MyAbstractQueueSynchronizer extends MyAbstractOwnableSynchronizer implements Serializable {
    private static final long serialVersionUID = -5339076984701839541L;

    static final class Node {
        static final Node SHARED = new Node();
        static final Node EXCLUSIVE = null;
        static final int CANCELLED = 1;
        static final int SIGNAL = -1;
        static final int CONDITION = -2;
        static final int PROPAGATE = -3;

        volatile int waitStatus;
        volatile Node prev;
        volatile Node next;
        volatile Thread thread;
        volatile Node nextWaiter;

        public boolean isShared() {
            return this.nextWaiter == SHARED;
        }

        public Node predecessor() {
            Node p = prev;
            if (p == null) {
                throw new NullPointerException();
            }
            return p;
        }

        Node() {
        }

        Node(Thread thread, Node mode) {
            this.thread = thread;
            this.nextWaiter = mode;
        }

        Node(Thread thread, int waitStatus) {
            this.thread = thread;
            this.waitStatus = waitStatus;
        }

        private static final Unsafe unsafe = Unsafe.getUnsafe();
        private static final long nextOffset;
        private static final long prevOffset;
        private static final long threadOffset;
        private static final long waitStatusOffset;

        static {
            try {
                nextOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("next"));
                prevOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("prev"));
                threadOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("thread"));
                waitStatusOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("waitStatus"));
            } catch (NoSuchFieldException e) {
                throw new Error(e);
            }
        }
    }
}
