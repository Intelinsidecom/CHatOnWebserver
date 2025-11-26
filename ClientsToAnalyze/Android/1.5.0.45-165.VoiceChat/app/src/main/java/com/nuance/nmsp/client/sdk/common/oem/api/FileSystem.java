package com.nuance.nmsp.client.sdk.common.oem.api;

/* loaded from: classes.dex */
public interface FileSystem {

    public static class FileMode {
        public static final FileMode READ = new FileMode();
        public static final FileMode WRITE = new FileMode();
        public static final FileMode APPEND = new FileMode();

        private FileMode() {
        }
    }

    void close();

    boolean exist();

    boolean open(String str, FileMode fileMode);

    int read(byte[] bArr, int i, int i2);

    boolean remove();

    boolean rename(String str);

    long size();

    long skip(long j);

    int write(byte[] bArr, int i, int i2);
}
