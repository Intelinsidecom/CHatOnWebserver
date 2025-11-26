package org.jboss.netty.handler.codec.serialization;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* loaded from: classes.dex */
class CompactObjectInputStream extends ObjectInputStream {
    private final ClassLoader classLoader;

    CompactObjectInputStream(InputStream inputStream) {
        this(inputStream, null);
    }

    CompactObjectInputStream(InputStream inputStream, ClassLoader classLoader) {
        super(inputStream);
        this.classLoader = classLoader;
    }

    protected Class loadClass(String str) {
        ClassLoader contextClassLoader = this.classLoader;
        if (contextClassLoader == null) {
            contextClassLoader = Thread.currentThread().getContextClassLoader();
        }
        return contextClassLoader != null ? contextClassLoader.loadClass(str) : Class.forName(str);
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
                return ObjectStreamClass.lookup(loadClass(readUTF()));
            default:
                throw new StreamCorruptedException("Unexpected class descriptor type: " + i);
        }
    }

    @Override // java.io.ObjectInputStream
    protected void readStreamHeader() throws StreamCorruptedException {
        int i = readByte() & 255;
        if (i != 5) {
            throw new StreamCorruptedException("Unsupported version: " + i);
        }
    }

    @Override // java.io.ObjectInputStream
    protected Class resolveClass(ObjectStreamClass objectStreamClass) {
        try {
            return loadClass(objectStreamClass.getName());
        } catch (ClassNotFoundException e) {
            return super.resolveClass(objectStreamClass);
        }
    }
}
