package org.jboss.netty.handler.codec.serialization;

import java.util.Map;

/* loaded from: classes.dex */
class CachingClassResolver implements ClassResolver {
    private final Map classCache;
    private final ClassResolver delegate;

    CachingClassResolver(ClassResolver classResolver, Map map) {
        this.delegate = classResolver;
        this.classCache = map;
    }

    @Override // org.jboss.netty.handler.codec.serialization.ClassResolver
    public Class resolve(String str) {
        Class cls = (Class) this.classCache.get(str);
        if (cls == null) {
            Class clsResolve = this.delegate.resolve(str);
            this.classCache.put(str, clsResolve);
            return clsResolve;
        }
        return cls;
    }
}
