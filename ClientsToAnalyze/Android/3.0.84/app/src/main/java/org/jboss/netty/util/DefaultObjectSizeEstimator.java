package org.jboss.netty.util;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.util.internal.ConcurrentIdentityWeakKeyHashMap;

/* loaded from: classes.dex */
public class DefaultObjectSizeEstimator implements ObjectSizeEstimator {
    private final ConcurrentMap<Class<?>, Integer> class2size = new ConcurrentIdentityWeakKeyHashMap();

    public DefaultObjectSizeEstimator() {
        this.class2size.put(Boolean.TYPE, 4);
        this.class2size.put(Byte.TYPE, 1);
        this.class2size.put(Character.TYPE, 2);
        this.class2size.put(Integer.TYPE, 4);
        this.class2size.put(Short.TYPE, 2);
        this.class2size.put(Long.TYPE, 8);
        this.class2size.put(Float.TYPE, 4);
        this.class2size.put(Double.TYPE, 8);
        this.class2size.put(Void.TYPE, 0);
    }

    @Override // org.jboss.netty.util.ObjectSizeEstimator
    public int estimateSize(Object obj) {
        if (obj == null) {
            return 8;
        }
        int iEstimateSize = estimateSize(obj.getClass(), null) + 8;
        if (obj instanceof EstimatableObjectWrapper) {
            iEstimateSize += estimateSize(((EstimatableObjectWrapper) obj).unwrap());
        } else if (obj instanceof MessageEvent) {
            iEstimateSize += estimateSize(((MessageEvent) obj).getMessage());
        } else if (obj instanceof ChannelBuffer) {
            iEstimateSize += ((ChannelBuffer) obj).capacity();
        } else if (obj instanceof byte[]) {
            iEstimateSize += ((byte[]) obj).length;
        } else if (obj instanceof ByteBuffer) {
            iEstimateSize += ((ByteBuffer) obj).remaining();
        } else if (obj instanceof CharSequence) {
            iEstimateSize += ((CharSequence) obj).length() << 1;
        } else if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                iEstimateSize += estimateSize(it.next());
            }
        }
        return align(iEstimateSize);
    }

    private int estimateSize(Class<?> cls, Set<Class<?>> set) {
        Integer num = this.class2size.get(cls);
        if (num != null) {
            return num.intValue();
        }
        if (set != null) {
            if (set.contains(cls)) {
                return 0;
            }
        } else {
            set = new HashSet<>();
        }
        set.add(cls);
        int iEstimateSize = 8;
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                if ((field.getModifiers() & 8) == 0) {
                    iEstimateSize += estimateSize(field.getType(), set);
                }
            }
        }
        set.remove(cls);
        int iAlign = align(iEstimateSize);
        this.class2size.putIfAbsent(cls, Integer.valueOf(iAlign));
        return iAlign;
    }

    private static int align(int i) {
        int i2 = i % 8;
        if (i2 != 0) {
            return i + (8 - i2);
        }
        return i;
    }
}
