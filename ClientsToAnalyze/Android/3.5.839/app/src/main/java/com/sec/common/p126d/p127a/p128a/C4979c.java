package com.sec.common.p126d.p127a.p128a;

import android.os.Handler;
import android.os.Message;
import com.sec.common.C4996f;
import com.sec.common.p126d.p127a.AbstractCallableC4983b;
import com.sec.common.util.C5048n;
import com.sec.common.util.C5052r;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.common.d.a.a.c */
/* loaded from: classes.dex */
public class C4979c extends AbstractCallableC4983b<Void, C4977a, C4978b> {

    /* renamed from: a */
    private static final Random f18177a = new Random(System.currentTimeMillis());

    /* renamed from: b */
    private ReadWriteLock f18178b;

    /* renamed from: c */
    private Lock f18179c;

    /* renamed from: d */
    private Lock f18180d;

    /* renamed from: e */
    private int f18181e;

    /* renamed from: g */
    private WeakReference<Handler> f18182g;

    public C4979c(C4977a c4977a) {
        this(c4977a, -1, null);
    }

    public C4979c(C4977a c4977a, int i, Handler handler) {
        super(c4977a);
        this.f18178b = new ReentrantReadWriteLock(true);
        this.f18179c = this.f18178b.readLock();
        this.f18180d = this.f18178b.writeLock();
        m18903a(i, handler);
    }

    /* renamed from: a */
    public Handler m18901a() {
        this.f18179c.lock();
        try {
            return this.f18182g.get();
        } finally {
            this.f18179c.unlock();
        }
    }

    /* renamed from: a */
    public void m18903a(int i, Handler handler) {
        this.f18180d.lock();
        try {
            this.f18181e = i;
            this.f18182g = new WeakReference<>(handler);
        } finally {
            this.f18180d.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void mo6150b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo6149a(C4978b c4978b) {
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: b */
    protected void mo10418b(HttpURLConnection httpURLConnection, InputStream inputStream) throws Throwable {
        File file;
        BufferedOutputStream bufferedOutputStream;
        File file2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                int contentLength = httpURLConnection.getContentLength();
                byte[] bArr = new byte[1024];
                File fileM18897a = m18918h().m18897a();
                if (httpURLConnection.getResponseCode() == 204) {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(this.f18194f, "Response code is 204");
                    }
                    if (!fileM18897a.createNewFile()) {
                        throw new IOException("Can't create empty file.");
                    }
                    C5048n.m19195a((OutputStream) null);
                    return;
                }
                File parentFile = fileM18897a.getParentFile();
                file = new File(parentFile, String.valueOf(f18177a.nextLong()));
                try {
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(this.f18194f, C5052r.m19199a("Save to ", fileM18897a.getAbsolutePath(), ", temp file ", file.getAbsolutePath()));
                    }
                    if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                        throw new IOException("Can't create directory. " + parentFile);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file));
                    int i = 0;
                    while (!Thread.interrupted()) {
                        try {
                            int i2 = inputStream.read(bArr);
                            if (Thread.interrupted()) {
                                throw new InterruptedException("readFromInputStream is interrupted.");
                            }
                            if (i2 == -1) {
                                bufferedOutputStream3.flush();
                                if (file.length() <= 0) {
                                    throw new IOException("File length is 0.");
                                }
                                if (!file.renameTo(fileM18897a)) {
                                    throw new IOException("Can't rename file.");
                                }
                                C5048n.m19195a(bufferedOutputStream3);
                                return;
                            }
                            i += i2;
                            m18900a(i, contentLength);
                            bufferedOutputStream3.write(bArr, 0, i2);
                        } catch (IOException e) {
                            e = e;
                            file2 = file;
                            bufferedOutputStream = bufferedOutputStream3;
                            try {
                                if (C4996f.f18229a.f18174f) {
                                    C4996f.f18229a.mo18649a(this.f18194f, e.getMessage(), e);
                                }
                                if (file2 != null) {
                                    try {
                                        file2.delete();
                                    } catch (Exception e2) {
                                    }
                                }
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                bufferedOutputStream2 = bufferedOutputStream;
                                C5048n.m19195a(bufferedOutputStream2);
                                throw th;
                            }
                        } catch (InterruptedException e3) {
                            e = e3;
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception e4) {
                                }
                            }
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream2 = bufferedOutputStream3;
                            C5048n.m19195a(bufferedOutputStream2);
                            throw th;
                        }
                    }
                    throw new InterruptedException("readFromInputStream is interrupted.");
                } catch (IOException e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    file2 = file;
                } catch (InterruptedException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedOutputStream = null;
            } catch (InterruptedException e8) {
                e = e8;
                file = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    protected void mo9167a(HttpURLConnection httpURLConnection, OutputStream outputStream) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4978b mo6146a(C4977a c4977a) {
        return new C4978b(c4977a);
    }

    /* renamed from: a */
    private void m18900a(int i, int i2) {
        this.f18179c.lock();
        try {
            Handler handlerM18901a = m18901a();
            if (handlerM18901a != null) {
                handlerM18901a.sendMessage(Message.obtain(handlerM18901a, this.f18181e, i, i2));
            }
        } finally {
            this.f18179c.unlock();
        }
    }
}
