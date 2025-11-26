package com.sec.common.p126d.p127a.p128a;

import android.os.Handler;
import android.os.Message;
import com.sec.common.p126d.p127a.AbstractCallableC4983b;
import com.sec.common.util.C5048n;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: FileUploadTask.java */
/* renamed from: com.sec.common.d.a.a.f */
/* loaded from: classes.dex */
public class C4982f extends AbstractCallableC4983b<File, C4980d, C4981e> {

    /* renamed from: a */
    private ReadWriteLock f18184a;

    /* renamed from: b */
    private Lock f18185b;

    /* renamed from: c */
    private Lock f18186c;

    /* renamed from: d */
    private int f18187d;

    /* renamed from: e */
    private WeakReference<Handler> f18188e;

    public C4982f(C4980d c4980d, int i, Handler handler) {
        super(c4980d);
        this.f18184a = new ReentrantReadWriteLock(true);
        this.f18185b = this.f18184a.readLock();
        this.f18186c = this.f18184a.writeLock();
        m18910a(i, handler);
    }

    /* renamed from: a */
    public int m18909a() {
        this.f18185b.lock();
        try {
            return this.f18187d;
        } finally {
            this.f18185b.unlock();
        }
    }

    /* renamed from: c */
    public Handler m18912c() {
        this.f18185b.lock();
        try {
            return this.f18188e.get();
        } finally {
            this.f18185b.unlock();
        }
    }

    /* renamed from: a */
    public void m18910a(int i, Handler handler) {
        this.f18186c.lock();
        try {
            this.f18187d = i;
            this.f18188e = new WeakReference<>(handler);
        } finally {
            this.f18186c.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C4981e mo6146a(C4980d c4980d) {
        return new C4981e(c4980d);
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    protected void mo10415a(HttpURLConnection httpURLConnection) throws ProtocolException {
        super.mo10415a(httpURLConnection);
        httpURLConnection.setFixedLengthStreamingMode((int) m18920j().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public File mo6150b() {
        File fileM18907b = m18918h().m18907b();
        if (fileM18907b == null) {
            throw new IllegalArgumentException("The local file can't be null.");
        }
        return fileM18907b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo6149a(C4981e c4981e) {
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: b */
    protected void mo10418b(HttpURLConnection httpURLConnection, InputStream inputStream) {
    }

    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a */
    protected void mo9167a(HttpURLConnection httpURLConnection, OutputStream outputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        File fileJ = m18920j();
        try {
            int length = (int) fileJ.length();
            byte[] bArr = new byte[1024];
            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileJ));
            int i = 0;
            while (!Thread.interrupted()) {
                try {
                    int i2 = bufferedInputStream.read(bArr);
                    if (i2 != -1) {
                        outputStream.write(bArr, 0, i2);
                        if (Thread.interrupted()) {
                            throw new InterruptedException("writeToOutputStream is interrupted.");
                        }
                        i += i2;
                        m18908a(i, length);
                    } else {
                        C5048n.m19194a(bufferedInputStream);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    C5048n.m19194a(bufferedInputStream);
                    throw th;
                }
            }
            throw new InterruptedException("writeToOutputStream is interrupted.");
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    /* renamed from: a */
    private void m18908a(int i, int i2) {
        this.f18185b.lock();
        try {
            Handler handlerM18912c = m18912c();
            if (handlerM18912c != null) {
                handlerM18912c.sendMessage(Message.obtain(handlerM18912c, this.f18187d, i, i2));
            }
        } finally {
            this.f18185b.unlock();
        }
    }
}
