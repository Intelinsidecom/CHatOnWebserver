package org.jboss.netty.channel.group;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class CombinedIterator implements Iterator {
    private Iterator currentIterator;

    /* renamed from: i1 */
    private final Iterator f5789i1;

    /* renamed from: i2 */
    private final Iterator f5790i2;

    CombinedIterator(Iterator it, Iterator it2) {
        if (it == null) {
            throw new NullPointerException("i1");
        }
        if (it2 == null) {
            throw new NullPointerException("i2");
        }
        this.f5789i1 = it;
        this.f5790i2 = it2;
        this.currentIterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.currentIterator.hasNext()) {
            return true;
        }
        if (this.currentIterator == this.f5789i1) {
            this.currentIterator = this.f5790i2;
            return hasNext();
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            return this.currentIterator.next();
        } catch (NoSuchElementException e) {
            if (this.currentIterator == this.f5789i1) {
                this.currentIterator = this.f5790i2;
                return next();
            }
            throw e;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentIterator.remove();
    }
}
