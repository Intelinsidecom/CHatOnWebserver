package org.jboss.netty.util.internal;

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
public class LinkedTransferQueue<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {

    /* renamed from: MP */
    private static final boolean f19100MP;
    private static final AtomicReferenceFieldUpdater<LinkedTransferQueue, Node> headUpdater;
    private static final AtomicIntegerFieldUpdater<LinkedTransferQueue> sweepVotesUpdater;
    private static final AtomicReferenceFieldUpdater<LinkedTransferQueue, Node> tailUpdater;
    volatile transient Node head;
    volatile transient int sweepVotes;
    volatile transient Node tail;

    static {
        f19100MP = Runtime.getRuntime().availableProcessors() > 1;
        headUpdater = AtomicFieldUpdaterUtil.newRefUpdater(LinkedTransferQueue.class, Node.class, "head");
        tailUpdater = AtomicFieldUpdaterUtil.newRefUpdater(LinkedTransferQueue.class, Node.class, "tail");
        sweepVotesUpdater = AtomicFieldUpdaterUtil.newIntUpdater(LinkedTransferQueue.class, "sweepVotes");
    }

    final class Node {
        final boolean isData;
        volatile Object item;
        volatile Node next;
        volatile Thread waiter;
        private static final AtomicReferenceFieldUpdater<Node, Node> nextUpdater = AtomicFieldUpdaterUtil.newRefUpdater(Node.class, Node.class, "next");
        private static final AtomicReferenceFieldUpdater<Node, Object> itemUpdater = AtomicFieldUpdaterUtil.newRefUpdater(Node.class, Object.class, "item");

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

        Node(Object obj, boolean z) {
            this.item = obj;
            this.isData = z;
        }

        final void forgetNext() {
            this.next = this;
        }

        final void forgetContents() {
            this.item = this;
            this.waiter = null;
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

        final boolean tryMatchData() {
            Object obj = this.item;
            if (obj == null || obj == this || !casItem(obj, null)) {
                return false;
            }
            LockSupport.unpark(this.waiter);
            return true;
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    static <E> E cast(Object obj) {
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private E xfer(E r9, boolean r10, int r11, long r12) {
        /*
            r8 = this;
            r3 = 0
            r4 = 1
            if (r10 == 0) goto Lc
            if (r9 != 0) goto Lc
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        Lc:
            r1 = 0
        Ld:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r5 = r8.head
            r2 = r5
        L10:
            if (r5 == 0) goto L1f
            boolean r6 = r5.isData
            java.lang.Object r7 = r5.item
            if (r7 == r5) goto L72
            if (r7 == 0) goto L3b
            r0 = r4
        L1b:
            if (r0 != r6) goto L72
            if (r6 != r10) goto L3d
        L1f:
            if (r11 == 0) goto L3a
            if (r1 != 0) goto L28
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r1 = new org.jboss.netty.util.internal.LinkedTransferQueue$Node
            r1.<init>(r9, r10)
        L28:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r2 = r8.tryAppend(r1, r10)
            if (r2 == 0) goto Ld
            if (r11 == r4) goto L3a
            r0 = 3
            if (r11 != r0) goto L7c
        L33:
            r0 = r8
            r3 = r9
            r5 = r12
            java.lang.Object r9 = r0.awaitMatch(r1, r2, r3, r4, r5)
        L3a:
            return r9
        L3b:
            r0 = r3
            goto L1b
        L3d:
            boolean r0 = r5.casItem(r7, r9)
            if (r0 == 0) goto L72
            r0 = r5
        L44:
            if (r0 == r2) goto L57
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r1 = r0.next
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r3 = r8.head
            if (r3 != r2) goto L63
            if (r1 != 0) goto L61
        L4e:
            boolean r0 = r8.casHead(r2, r0)
            if (r0 == 0) goto L63
            r2.forgetNext()
        L57:
            java.lang.Thread r0 = r5.waiter
            java.util.concurrent.locks.LockSupport.unpark(r0)
            java.lang.Object r9 = cast(r7)
            goto L3a
        L61:
            r0 = r1
            goto L4e
        L63:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r2 = r8.head
            if (r2 == 0) goto L57
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r0 = r2.next
            if (r0 == 0) goto L57
            boolean r1 = r0.isMatched()
            if (r1 != 0) goto L44
            goto L57
        L72:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r0 = r5.next
            if (r5 == r0) goto L78
        L76:
            r5 = r0
            goto L10
        L78:
            org.jboss.netty.util.internal.LinkedTransferQueue$Node r0 = r8.head
            r2 = r0
            goto L76
        L7c:
            r4 = r3
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.LinkedTransferQueue.xfer(java.lang.Object, boolean, int, long):java.lang.Object");
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
                if (node4 != node5 && node5 != (node2 = this.tail)) {
                    node4 = node2;
                } else if (node4 != node6) {
                    node4 = node6;
                    node2 = node5;
                } else {
                    node4 = null;
                    node2 = node5;
                }
                node5 = node2;
            } else if (!node4.casNext(null, node)) {
                node4 = node4.next;
            } else {
                if (node4 != node5) {
                    do {
                        if ((this.tail == node5 && casTail(node5, node)) || (node5 = this.tail) == null || (node3 = node5.next) == null || (node = node3.next) == null) {
                            break;
                        }
                    } while (node != node5);
                }
                return node4;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0080 A[PHI: r1
  0x0080: PHI (r1v3 int) = (r1v2 int), (r1v6 int) binds: [B:25:0x0055, B:20:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private E awaitMatch(org.jboss.netty.util.internal.LinkedTransferQueue.Node r13, org.jboss.netty.util.internal.LinkedTransferQueue.Node r14, E r15, boolean r16, long r17) {
        /*
            r12 = this;
            if (r16 == 0) goto L1f
            long r0 = java.lang.System.nanoTime()
        L6:
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r3 = -1
            r2 = 0
            r6 = r17
            r9 = r3
            r10 = r0
            r1 = r9
            r0 = r2
            r2 = r10
        L13:
            java.lang.Object r4 = r13.item
            if (r4 == r15) goto L22
            r13.forgetContents()
            java.lang.Object r15 = cast(r4)
        L1e:
            return r15
        L1f:
            r0 = 0
            goto L6
        L22:
            boolean r4 = r8.isInterrupted()
            if (r4 != 0) goto L30
            if (r16 == 0) goto L3a
            r4 = 0
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 > 0) goto L3a
        L30:
            boolean r4 = r13.casItem(r15, r13)
            if (r4 == 0) goto L3a
            r12.unsplice(r14, r13)
            goto L1e
        L3a:
            if (r1 >= 0) goto L4b
            boolean r1 = r13.isData
            int r1 = spinsFor(r14, r1)
            if (r1 <= 0) goto L80
            org.jboss.netty.util.internal.ThreadLocalRandom r0 = org.jboss.netty.util.internal.ThreadLocalRandom.current()
            r4 = r6
        L49:
            r6 = r4
            goto L13
        L4b:
            if (r1 <= 0) goto L5c
            int r1 = r1 + (-1)
            r4 = 64
            int r4 = r0.nextInt(r4)
            if (r4 != 0) goto L80
            java.lang.Thread.yield()
            r4 = r6
            goto L49
        L5c:
            java.lang.Thread r4 = r13.waiter
            if (r4 != 0) goto L64
            r13.waiter = r8
            r4 = r6
            goto L49
        L64:
            if (r16 == 0) goto L7b
            long r4 = java.lang.System.nanoTime()
            long r2 = r4 - r2
            long r2 = r6 - r2
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 <= 0) goto L77
            java.util.concurrent.locks.LockSupport.parkNanos(r2)
        L77:
            r9 = r4
            r4 = r2
            r2 = r9
            goto L49
        L7b:
            r4 = r6
            java.util.concurrent.locks.LockSupport.park()
            goto L49
        L80:
            r4 = r6
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.LinkedTransferQueue.awaitMatch(org.jboss.netty.util.internal.LinkedTransferQueue$Node, org.jboss.netty.util.internal.LinkedTransferQueue$Node, java.lang.Object, boolean, long):java.lang.Object");
    }

    private static int spinsFor(Node node, boolean z) {
        if (f19100MP && node != null) {
            if (node.isData != z) {
                return 192;
            }
            if (node.isMatched()) {
                return 128;
            }
            if (node.waiter == null) {
                return 64;
            }
        }
        return 0;
    }

    final Node succ(Node node) {
        Node node2 = node.next;
        return node == node2 ? this.head : node2;
    }

    private E firstDataItem() {
        Node nodeSucc = this.head;
        while (nodeSucc != null) {
            Object obj = nodeSucc.item;
            if (nodeSucc.isData) {
                if (obj != null && obj != nodeSucc) {
                    return (E) cast(obj);
                }
            } else if (obj == null) {
                return null;
            }
            nodeSucc = succ(nodeSucc);
        }
        return null;
    }

    private int countOfMode(boolean z) {
        Node node;
        int i;
        Node node2 = this.head;
        int i2 = 0;
        while (node2 != null) {
            if (!node2.isMatched()) {
                if (node2.isData == z) {
                    i2++;
                    if (i2 == Integer.MAX_VALUE) {
                        break;
                    }
                } else {
                    return 0;
                }
            }
            Node node3 = node2.next;
            if (node3 != node2) {
                i = i2;
                node = node3;
            } else {
                node = this.head;
                i = 0;
            }
            node2 = node;
            i2 = i;
        }
        return i2;
    }

    final class Itr implements Iterator<E> {
        private Node lastPred;
        private Node lastRet;
        private E nextItem;
        private Node nextNode;

        private void advance(Node node) {
            this.lastPred = this.lastRet;
            this.lastRet = node;
            Node nodeSucc = node == null ? LinkedTransferQueue.this.head : LinkedTransferQueue.this.succ(node);
            while (nodeSucc != null) {
                Object obj = nodeSucc.item;
                if (nodeSucc.isData) {
                    if (obj != null && obj != nodeSucc) {
                        this.nextItem = (E) LinkedTransferQueue.cast(obj);
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

        Itr() {
            advance(null);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.nextNode != null;
        }

        @Override // java.util.Iterator
        public final E next() {
            Node node = this.nextNode;
            if (node == null) {
                throw new NoSuchElementException();
            }
            E e = this.nextItem;
            advance(node);
            return e;
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

    final void unsplice(Node node, Node node2) {
        node2.forgetContents();
        if (node != null && node != node2 && node.next == node2) {
            Node node3 = node2.next;
            if (node3 != null && (node3 == node2 || !node.casNext(node2, node3) || !node.isMatched())) {
                return;
            }
            while (true) {
                Node node4 = this.head;
                if (node4 != node && node4 != node2 && node4 != null) {
                    if (node4.isMatched()) {
                        Node node5 = node4.next;
                        if (node5 != null) {
                            if (node5 != node4 && casHead(node4, node5)) {
                                node4.forgetNext();
                            }
                        } else {
                            return;
                        }
                    } else {
                        if (node.next == node || node2.next == node2) {
                            return;
                        }
                        while (true) {
                            int i = this.sweepVotes;
                            if (i < 32) {
                                if (casSweepVotes(i, i + 1)) {
                                    return;
                                }
                            } else if (casSweepVotes(i, 0)) {
                                sweep();
                                return;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void sweep() {
        Node node = this.head;
        while (node != null) {
            Node node2 = node.next;
            if (node2 != null) {
                if (node2.isMatched()) {
                    Node node3 = node2.next;
                    if (node3 != null) {
                        if (node2 == node3) {
                            node = this.head;
                        } else {
                            node.casNext(node2, node3);
                        }
                    } else {
                        return;
                    }
                } else {
                    node = node2;
                }
            } else {
                return;
            }
        }
    }

    private boolean findAndRemove(Object obj) {
        if (obj != null) {
            Node node = this.head;
            Node node2 = null;
            while (node != null) {
                Object obj2 = node.item;
                if (node.isData) {
                    if (obj2 != null && obj2 != node && obj.equals(obj2) && node.tryMatchData()) {
                        unsplice(node2, node);
                        return true;
                    }
                } else if (obj2 == null) {
                    break;
                }
                Node node3 = node.next;
                if (node3 == node) {
                    node3 = this.head;
                    node = null;
                }
                Node node4 = node3;
                node2 = node;
                node = node4;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) {
        xfer(e, true, 1, 0L);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) {
        xfer(e, true, 1, 0L);
        return true;
    }

    public boolean offer(E e) {
        xfer(e, true, 1, 0L);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean add(E e) {
        xfer(e, true, 1, 0L);
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        E eXfer = xfer(null, false, 2, 0L);
        if (eXfer != null) {
            return eXfer;
        }
        Thread.interrupted();
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        E eXfer = xfer(null, false, 3, timeUnit.toNanos(j));
        if (eXfer != null || !Thread.interrupted()) {
            return eXfer;
        }
        throw new InterruptedException();
    }

    public E poll() {
        return xfer(null, false, 0, 0L);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        while (true) {
            E ePoll = poll();
            if (ePoll != null) {
                collection.add(ePoll);
                i++;
            } else {
                return i;
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        while (i2 < i) {
            E ePoll = poll();
            if (ePoll == null) {
                break;
            }
            collection.add(ePoll);
            i2++;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override // java.util.Queue
    public E peek() {
        return firstDataItem();
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

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return countOfMode(true);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        return findAndRemove(obj);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }
}
