package org.jboss.netty.util.internal;

import com.sec.chaton.trunk.database.DatabaseConstant;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public class LinkedTransferQueue extends AbstractQueue implements Serializable, BlockingQueue {
    private static final int ASYNC = 1;
    private static final int CHAINED_SPINS = 64;
    private static final int FRONT_SPINS = 128;

    /* renamed from: MP */
    private static final boolean f4591MP;
    private static final int NOW = 0;
    static final int SWEEP_THRESHOLD = 32;
    private static final int SYNC = 2;
    private static final int TIMED = 3;
    private static final AtomicReferenceFieldUpdater headUpdater;
    private static final long serialVersionUID = -3223113410248163686L;
    private static final AtomicIntegerFieldUpdater sweepVotesUpdater;
    private static final AtomicReferenceFieldUpdater tailUpdater;
    volatile transient Node head;
    volatile transient int sweepVotes;
    volatile transient Node tail;

    final class Itr implements Iterator {
        private Node lastPred;
        private Node lastRet;
        private Object nextItem;
        private Node nextNode;

        Itr() {
            advance(null);
        }

        private void advance(Node node) {
            this.lastPred = this.lastRet;
            this.lastRet = node;
            Node nodeSucc = node == null ? LinkedTransferQueue.this.head : LinkedTransferQueue.this.succ(node);
            while (nodeSucc != null) {
                Object obj = nodeSucc.item;
                if (nodeSucc.isData) {
                    if (obj != null && obj != nodeSucc) {
                        this.nextItem = LinkedTransferQueue.cast(obj);
                        this.nextNode = nodeSucc;
                        return;
                    }
                } else if (obj == null) {
                    break;
                }
                nodeSucc = LinkedTransferQueue.this.succ(nodeSucc);
            }
            this.nextNode = null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.nextNode != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Node node = this.nextNode;
            if (node == null) {
                throw new NoSuchElementException();
            }
            Object obj = this.nextItem;
            advance(node);
            return obj;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node node = this.lastRet;
            if (node == null) {
                throw new IllegalStateException();
            }
            if (node.tryMatchData()) {
                LinkedTransferQueue.this.unsplice(this.lastPred, node);
            }
        }
    }

    final class Node {
        private static final long serialVersionUID = -3375979862319811754L;
        final boolean isData;
        volatile Object item;
        volatile Node next;
        volatile Thread waiter;
        private static final AtomicReferenceFieldUpdater nextUpdater = AtomicFieldUpdaterUtil.newRefUpdater(Node.class, Node.class, "next");
        private static final AtomicReferenceFieldUpdater itemUpdater = AtomicFieldUpdaterUtil.newRefUpdater(Node.class, Object.class, DatabaseConstant.TrunkCommentTable.PATH_ITEM);

        Node(Object obj, boolean z) {
            this.item = obj;
            this.isData = z;
        }

        final boolean cannotPrecede(boolean z) {
            Object obj;
            boolean z2 = this.isData;
            if (z2 != z && (obj = this.item) != this) {
                if ((obj != null) == z2) {
                    return true;
                }
            }
            return false;
        }

        final boolean casItem(Object obj, Object obj2) {
            boolean z;
            if (AtomicFieldUpdaterUtil.isAvailable()) {
                return itemUpdater.compareAndSet(this, obj, obj2);
            }
            synchronized (this) {
                if (this.item == obj) {
                    this.item = obj2;
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }

        final boolean casNext(Node node, Node node2) {
            boolean z;
            if (AtomicFieldUpdaterUtil.isAvailable()) {
                return nextUpdater.compareAndSet(this, node, node2);
            }
            synchronized (this) {
                if (this.next == node) {
                    this.next = node2;
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }

        final void forgetContents() {
            this.item = this;
            this.waiter = null;
        }

        final void forgetNext() {
            this.next = this;
        }

        final boolean isMatched() {
            Object obj = this.item;
            if (obj != this) {
                if ((obj == null) != this.isData) {
                    return false;
                }
            }
            return true;
        }

        final boolean isUnmatchedRequest() {
            return !this.isData && this.item == null;
        }

        final boolean tryMatchData() {
            Object obj = this.item;
            if (obj == null || obj == this || !casItem(obj, null)) {
                return false;
            }
            LockSupport.unpark(this.waiter);
            return true;
        }
    }

    static {
        f4591MP = Runtime.getRuntime().availableProcessors() > 1;
        headUpdater = AtomicFieldUpdaterUtil.newRefUpdater(LinkedTransferQueue.class, Node.class, "head");
        tailUpdater = AtomicFieldUpdaterUtil.newRefUpdater(LinkedTransferQueue.class, Node.class, "tail");
        sweepVotesUpdater = AtomicFieldUpdaterUtil.newIntUpdater(LinkedTransferQueue.class, "sweepVotes");
    }

    public LinkedTransferQueue() {
    }

    public LinkedTransferQueue(Collection collection) {
        this();
        addAll(collection);
    }

    private Object awaitMatch(Node node, Node node2, Object obj, boolean z, long j) {
        long jNanoTime = z ? System.nanoTime() : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        long j2 = j;
        long j3 = jNanoTime;
        int iSpinsFor = -1;
        ThreadLocalRandom threadLocalRandomCurrent = null;
        long j4 = j3;
        while (true) {
            Object obj2 = node.item;
            if (obj2 != obj) {
                node.forgetContents();
                return cast(obj2);
            }
            if ((threadCurrentThread.isInterrupted() || (z && j2 <= 0)) && node.casItem(obj, node)) {
                unsplice(node2, node);
                return obj;
            }
            if (iSpinsFor < 0) {
                iSpinsFor = spinsFor(node2, node.isData);
                if (iSpinsFor > 0) {
                    threadLocalRandomCurrent = ThreadLocalRandom.current();
                }
            } else if (iSpinsFor > 0) {
                iSpinsFor--;
                if (threadLocalRandomCurrent.nextInt(CHAINED_SPINS) == 0) {
                    Thread.yield();
                }
            } else if (node.waiter == null) {
                node.waiter = threadCurrentThread;
            } else if (z) {
                long jNanoTime2 = System.nanoTime();
                long j5 = j2 - (jNanoTime2 - j4);
                if (j5 > 0) {
                    LockSupport.parkNanos(j5);
                }
                j2 = j5;
                j4 = jNanoTime2;
            } else {
                LockSupport.park();
            }
        }
    }

    private boolean casHead(Node node, Node node2) {
        boolean z;
        if (AtomicFieldUpdaterUtil.isAvailable()) {
            return headUpdater.compareAndSet(this, node, node2);
        }
        synchronized (this) {
            if (this.head == node) {
                this.head = node2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private boolean casSweepVotes(int i, int i2) {
        boolean z;
        if (AtomicFieldUpdaterUtil.isAvailable()) {
            return sweepVotesUpdater.compareAndSet(this, i, i2);
        }
        synchronized (this) {
            if (this.sweepVotes == i) {
                this.sweepVotes = i2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private boolean casTail(Node node, Node node2) {
        boolean z;
        if (AtomicFieldUpdaterUtil.isAvailable()) {
            return tailUpdater.compareAndSet(this, node, node2);
        }
        synchronized (this) {
            if (this.tail == node) {
                this.tail = node2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    static Object cast(Object obj) {
        return obj;
    }

    private int countOfMode(boolean z) {
        Node node = this.head;
        int i = 0;
        while (node != null) {
            if (!node.isMatched()) {
                if (node.isData != z) {
                    return 0;
                }
                i++;
                if (i == Integer.MAX_VALUE) {
                    return i;
                }
            }
            Node node2 = node.next;
            if (node2 != node) {
                node = node2;
            } else {
                node = this.head;
                i = 0;
            }
        }
        return i;
    }

    private boolean findAndRemove(Object obj) {
        if (obj != null) {
            Node node = this.head;
            Node node2 = null;
            while (node != null) {
                Object obj2 = node.item;
                if (!node.isData) {
                    if (obj2 == null) {
                        break;
                    }
                } else if (obj2 != null && obj2 != node && obj.equals(obj2) && node.tryMatchData()) {
                    unsplice(node2, node);
                    return true;
                }
                Node node3 = node.next;
                if (node3 == node) {
                    node = this.head;
                    node2 = null;
                } else {
                    node2 = node;
                    node = node3;
                }
            }
        }
        return false;
    }

    private Object firstDataItem() {
        Node nodeSucc = this.head;
        while (nodeSucc != null) {
            Object obj = nodeSucc.item;
            if (nodeSucc.isData) {
                if (obj != null && obj != nodeSucc) {
                    return cast(obj);
                }
            } else if (obj == null) {
                return null;
            }
            nodeSucc = succ(nodeSucc);
        }
        return null;
    }

    private Node firstOfMode(boolean z) {
        Node nodeSucc = this.head;
        while (nodeSucc != null) {
            if (!nodeSucc.isMatched()) {
                if (nodeSucc.isData == z) {
                    return nodeSucc;
                }
                return null;
            }
            nodeSucc = succ(nodeSucc);
        }
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                offer(object);
            }
        }
    }

    private static int spinsFor(Node node, boolean z) {
        if (f4591MP && node != null) {
            if (node.isData != z) {
                return 192;
            }
            if (node.isMatched()) {
                return FRONT_SPINS;
            }
            if (node.waiter == null) {
                return CHAINED_SPINS;
            }
        }
        return 0;
    }

    private void sweep() {
        Node node = this.head;
        while (node != null) {
            Node node2 = node.next;
            if (node2 == null) {
                return;
            }
            if (node2.isMatched()) {
                Node node3 = node2.next;
                if (node3 == null) {
                    return;
                }
                if (node2 == node3) {
                    node = this.head;
                } else {
                    node.casNext(node2, node3);
                }
            } else {
                node = node2;
            }
        }
    }

    private Node tryAppend(Node node, boolean z) {
        Node node2;
        Node node3;
        Node node4 = this.tail;
        Node node5 = node4;
        while (true) {
            if (node4 == null) {
                node4 = this.head;
                if (node4 == null) {
                    if (casHead(null, node)) {
                        return node;
                    }
                }
            }
            if (node4.cannotPrecede(z)) {
                return null;
            }
            Node node6 = node4.next;
            if (node6 != null) {
                if (node4 == node5 || node5 == (node2 = this.tail)) {
                    node4 = node4 != node6 ? node6 : null;
                } else {
                    node4 = node2;
                    node5 = node2;
                }
            } else {
                if (node4.casNext(null, node)) {
                    if (node4 == node5) {
                        return node4;
                    }
                    Node node7 = node;
                    do {
                        if ((this.tail == node5 && casTail(node5, node7)) || (node5 = this.tail) == null || (node3 = node5.next) == null || (node7 = node3.next) == null) {
                            return node4;
                        }
                    } while (node7 != node5);
                    return node4;
                }
                node4 = node4.next;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeObject(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
    
        return r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object xfer(java.lang.Object r10, boolean r11, int r12, long r13) {
        /*
            r9 = this;
            r7 = 0
            r6 = 1
            if (r11 == 0) goto Lc
            if (r10 != 0) goto Lc
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        Lc:
            r0 = 0
        Ld:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r1 = r9.head
            r2 = r1
        L10:
            if (r1 == 0) goto L1f
            boolean r3 = r1.isData
            java.lang.Object r4 = r1.item
            if (r4 == r1) goto L6b
            if (r4 == 0) goto L31
            r5 = r6
        L1b:
            if (r5 != r3) goto L6b
            if (r3 != r11) goto L33
        L1f:
            if (r12 == 0) goto L85
            if (r0 != 0) goto L87
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r0 = new org.jboss.netty.util.internal.LinkedTransferQueue$Node
            r0.<init>(r10, r11)
            r1 = r0
        L29:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r2 = r9.tryAppend(r1, r11)
            if (r2 != 0) goto L75
            r0 = r1
            goto Ld
        L31:
            r5 = r7
            goto L1b
        L33:
            boolean r3 = r1.casItem(r4, r10)
            if (r3 == 0) goto L6b
            r0 = r1
        L3a:
            if (r0 == r2) goto L4d
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r3 = r0.next
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r5 = r9.head
            if (r5 != r2) goto L59
            if (r3 != 0) goto L57
        L44:
            boolean r0 = r9.casHead(r2, r0)
            if (r0 == 0) goto L59
            r2.forgetNext()
        L4d:
            java.lang.Thread r0 = r1.waiter
            java.util.concurrent.locks.LockSupport.unpark(r0)
            java.lang.Object r0 = cast(r4)
        L56:
            return r0
        L57:
            r0 = r3
            goto L44
        L59:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r0 = r9.head
            if (r0 == 0) goto L4d
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r2 = r0.next
            if (r2 == 0) goto L4d
            boolean r3 = r2.isMatched()
            if (r3 == 0) goto L4d
            r8 = r2
            r2 = r0
            r0 = r8
            goto L3a
        L6b:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r3 = r1.next
            if (r1 == r3) goto L71
            r1 = r3
            goto L10
        L71:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r1 = r9.head
            r2 = r1
            goto L10
        L75:
            if (r12 == r6) goto L85
            r0 = 3
            if (r12 != r0) goto L83
            r4 = r6
        L7b:
            r0 = r9
            r3 = r10
            r5 = r13
            java.lang.Object r0 = r0.awaitMatch(r1, r2, r3, r4, r5)
            goto L56
        L83:
            r4 = r7
            goto L7b
        L85:
            r0 = r10
            goto L56
        L87:
            r1 = r0
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.LinkedTransferQueue.xfer(java.lang.Object, boolean, int, long):java.lang.Object");
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean add(Object obj) {
        xfer(obj, true, 1, 0L);
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        while (true) {
            Object objPoll = poll();
            if (objPoll == null) {
                return i;
            }
            collection.add(objPoll);
            i++;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        while (i2 < i) {
            Object objPoll = poll();
            if (objPoll == null) {
                break;
            }
            collection.add(objPoll);
            i2++;
        }
        return i2;
    }

    public int getWaitingConsumerCount() {
        return countOfMode(false);
    }

    public boolean hasWaitingConsumer() {
        return firstOfMode(false) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        Node nodeSucc = this.head;
        while (nodeSucc != null) {
            if (!nodeSucc.isMatched()) {
                return !nodeSucc.isData;
            }
            nodeSucc = succ(nodeSucc);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Itr();
    }

    public boolean offer(Object obj) {
        xfer(obj, true, 1, 0L);
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(Object obj, long j, TimeUnit timeUnit) {
        xfer(obj, true, 1, 0L);
        return true;
    }

    @Override // java.util.Queue
    public Object peek() {
        return firstDataItem();
    }

    public Object poll() {
        return xfer(null, false, 0, 0L);
    }

    @Override // java.util.concurrent.BlockingQueue
    public Object poll(long j, TimeUnit timeUnit) throws InterruptedException {
        Object objXfer = xfer(null, false, 3, timeUnit.toNanos(j));
        if (objXfer == null && Thread.interrupted()) {
            throw new InterruptedException();
        }
        return objXfer;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(Object obj) {
        xfer(obj, true, 1, 0L);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        return findAndRemove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return countOfMode(true);
    }

    final Node succ(Node node) {
        Node node2 = node.next;
        return node == node2 ? this.head : node2;
    }

    @Override // java.util.concurrent.BlockingQueue
    public Object take() throws InterruptedException {
        Object objXfer = xfer(null, false, 2, 0L);
        if (objXfer != null) {
            return objXfer;
        }
        Thread.interrupted();
        throw new InterruptedException();
    }

    public void transfer(Object obj) throws InterruptedException {
        if (xfer(obj, true, 2, 0L) != null) {
            Thread.interrupted();
            throw new InterruptedException();
        }
    }

    public boolean tryTransfer(Object obj) {
        return xfer(obj, true, 0, 0L) == null;
    }

    public boolean tryTransfer(Object obj, long j, TimeUnit timeUnit) throws InterruptedException {
        if (xfer(obj, true, 3, timeUnit.toNanos(j)) == null) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return false;
    }

    final void unsplice(Node node, Node node2) {
        node2.forgetContents();
        if (node == null || node == node2 || node.next != node2) {
            return;
        }
        Node node3 = node2.next;
        if (node3 != null && (node3 == node2 || !node.casNext(node2, node3) || !node.isMatched())) {
            return;
        }
        while (true) {
            Node node4 = this.head;
            if (node4 == node || node4 == node2 || node4 == null) {
                return;
            }
            if (node4.isMatched()) {
                Node node5 = node4.next;
                if (node5 == null) {
                    return;
                }
                if (node5 != node4 && casHead(node4, node5)) {
                    node4.forgetNext();
                }
            } else {
                if (node.next == node || node2.next == node2) {
                    return;
                }
                while (true) {
                    int i = this.sweepVotes;
                    if (i < SWEEP_THRESHOLD) {
                        if (casSweepVotes(i, i + 1)) {
                            return;
                        }
                    } else if (casSweepVotes(i, 0)) {
                        sweep();
                        return;
                    }
                }
            }
        }
    }
}
