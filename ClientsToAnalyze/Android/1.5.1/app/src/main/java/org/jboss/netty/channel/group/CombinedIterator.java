package org.jboss.netty.channel.group;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class CombinedIterator implements Iterator {
    private Iterator currentIterator;

    /* renamed from: i1 */
    private final Iterator f4560i1;

    /* renamed from: i2 */
    private final Iterator f4561i2;

    CombinedIterator(Iterator it, Iterator it2) {
        if (it == null) {
            throw new NullPointerException("i1");
        }
        if (it2 == null) {
            throw new NullPointerException("i2");
        }
        this.f4560i1 = it;
        this.f4561i2 = it2;
        this.currentIterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.currentIterator.hasNext()) {
            return true;
        }
        if (this.currentIterator != this.f4560i1) {
            return false;
        }
        this.currentIterator = this.f4561i2;
        return hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            return this.currentIterator.next();
        } catch (NoSuchElementException e) {
            if (this.currentIterator != this.f4560i1) {
                throw e;
            }
            this.currentIterator = this.f4561i2;
            return next();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentIterator.remove();
    }
}
