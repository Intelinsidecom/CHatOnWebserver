package com.vlingo.sdk.internal.recognizer.reader;

import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class InputStreamLogger extends InputStream {
    private ByteArrayOutputStream mByteArrayOutputStream = new ByteArrayOutputStream();
    private InputStream mInputStream;

    InputStreamLogger(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int b = this.mInputStream.read();
        if (b > -1) {
            this.mByteArrayOutputStream.write(b);
        }
        return this.mInputStream.read();
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] buffer, int offset, int length) throws IOException {
        int bytesRead;
        bytesRead = this.mInputStream.read(buffer, offset, length);
        if (bytesRead > 0) {
            this.mByteArrayOutputStream.write(buffer, offset, bytesRead);
        }
        return bytesRead;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] buffer) throws IOException {
        int bytesRead;
        bytesRead = this.mInputStream.read(buffer);
        if (bytesRead > 0) {
            this.mByteArrayOutputStream.write(buffer, 0, bytesRead);
        }
        return bytesRead;
    }

    synchronized void writeLog(String guttID) {
        if (this.mByteArrayOutputStream.size() > 0) {
            FileOutputStream fos = null;
            try {
                if (guttID == null) {
                    guttID = "null-ID";
                }
                try {
                    File root = Environment.getExternalStorageDirectory();
                    if (root.canWrite()) {
                        File audfile = new File(root, "vlingo_" + guttID + ".raw");
                        FileOutputStream fos2 = new FileOutputStream(audfile);
                        try {
                            fos2.write(this.mByteArrayOutputStream.toByteArray());
                            fos2.flush();
                            fos = fos2;
                        } catch (IOException e) {
                            e = e;
                            fos = fos2;
                            e.printStackTrace();
                            if (fos != null) {
                                try {
                                    fos.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fos = fos2;
                            if (fos != null) {
                                try {
                                    fos.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
