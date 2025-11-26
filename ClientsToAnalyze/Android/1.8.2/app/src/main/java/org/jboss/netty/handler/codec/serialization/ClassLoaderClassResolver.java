package org.jboss.netty.handler.codec.serialization;

/* loaded from: classes.dex */
class ClassLoaderClassResolver implements ClassResolver {
    private final ClassLoader classLoader;

    ClassLoaderClassResolver(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override // org.jboss.netty.handler.codec.serialization.ClassResolver
    public Class resolve(String str) {
        try {
            return this.classLoader.loadClass(str);
        } catch (ClassNotFoundException e) {
            return Class.forName(str, false, this.classLoader);
        }
    }
}
