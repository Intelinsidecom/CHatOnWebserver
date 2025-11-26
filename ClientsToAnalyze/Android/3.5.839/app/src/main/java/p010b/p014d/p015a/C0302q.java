package p010b.p014d.p015a;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* compiled from: StreamingGZIPInputStream.java */
/* renamed from: b.d.a.q */
/* loaded from: classes.dex */
final class C0302q extends GZIPInputStream {

    /* renamed from: a */
    private final InputStream f681a;

    public C0302q(InputStream inputStream) {
        super(inputStream);
        this.f681a = inputStream;
    }

    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.f681a.available();
    }
}
