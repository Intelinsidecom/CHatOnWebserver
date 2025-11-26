package org.jboss.netty.handler.codec.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

/* loaded from: classes.dex */
class CompactObjectOutputStream extends ObjectOutputStream {
    static final int TYPE_FAT_DESCRIPTOR = 0;
    static final int TYPE_THIN_DESCRIPTOR = 1;

    CompactObjectOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.ObjectOutputStream
    protected void writeStreamHeader() {
        writeByte(5);
    }

    @Override // java.io.ObjectOutputStream
    protected void writeClassDescriptor(ObjectStreamClass objectStreamClass) throws IOException {
        Class<?> clsForClass = objectStreamClass.forClass();
        if (clsForClass.isPrimitive() || clsForClass.isArray()) {
            write(0);
            super.writeClassDescriptor(objectStreamClass);
        } else {
            write(1);
            writeUTF(objectStreamClass.getName());
        }
    }
}
