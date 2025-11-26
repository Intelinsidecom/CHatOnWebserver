package org.jboss.netty.handler.codec.serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
class CompactObjectInputStream extends ObjectInputStream {
    private final Map classCache;
    private final ClassLoader classLoader;

    CompactObjectInputStream(InputStream inputStream) {
        this(inputStream, null);
    }

    CompactObjectInputStream(InputStream inputStream, ClassLoader classLoader) {
        super(inputStream);
        this.classCache = new HashMap();
        this.classLoader = classLoader;
    }

    @Override // java.io.ObjectInputStream
    protected void readStreamHeader() throws StreamCorruptedException {
        int i = readByte() & 255;
        if (i != 5) {
            throw new StreamCorruptedException("Unsupported version: " + i);
        }
    }

    @Override // java.io.ObjectInputStream
    protected ObjectStreamClass readClassDescriptor() throws StreamCorruptedException, EOFException {
        int i = read();
        if (i < 0) {
            throw new EOFException();
        }
        switch (i) {
            case 0:
                return super.readClassDescriptor();
            case 1:
                return ObjectStreamClass.lookupAny(loadClass(readUTF()));
            default:
                throw new StreamCorruptedException("Unexpected class descriptor type: " + i);
        }
    }

    @Override // java.io.ObjectInputStream
    protected Class resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        String name = objectStreamClass.getName();
        Class<?> clsResolveClass = (Class) this.classCache.get(name);
        if (clsResolveClass == null) {
            try {
                clsResolveClass = loadClass(name);
            } catch (ClassNotFoundException e) {
                clsResolveClass = super.resolveClass(objectStreamClass);
            }
            this.classCache.put(name, clsResolveClass);
        }
        return clsResolveClass;
    }

    protected Class loadClass(String str) throws ClassNotFoundException {
        Class<?> cls = (Class) this.classCache.get(str);
        if (cls == null) {
            ClassLoader contextClassLoader = this.classLoader;
            if (contextClassLoader == null) {
                contextClassLoader = Thread.currentThread().getContextClassLoader();
            }
            if (contextClassLoader != null) {
                cls = contextClassLoader.loadClass(str);
            } else {
                cls = Class.forName(str);
            }
            this.classCache.put(str, cls);
        }
        return cls;
    }
}
