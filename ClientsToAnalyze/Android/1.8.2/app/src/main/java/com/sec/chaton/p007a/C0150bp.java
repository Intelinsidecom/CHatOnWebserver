package com.sec.chaton.p007a;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bp */
/* loaded from: classes.dex */
public final class C0150bp extends GeneratedMessageLite implements InterfaceC0152br {

    /* renamed from: a */
    private static final C0150bp f528a = new C0150bp(true);

    /* renamed from: b */
    private int f529b;

    /* renamed from: c */
    private long f530c;

    /* renamed from: d */
    private EnumC0159by f531d;

    /* renamed from: e */
    private EnumC0116ai f532e;

    /* renamed from: f */
    private Object f533f;

    /* renamed from: g */
    private Object f534g;

    /* renamed from: h */
    private long f535h;

    /* renamed from: i */
    private Object f536i;

    /* renamed from: j */
    private LazyStringList f537j;

    /* renamed from: k */
    private Object f538k;

    /* renamed from: l */
    private byte f539l;

    /* renamed from: m */
    private int f540m;

    private C0150bp(C0151bq c0151bq) {
        super(c0151bq);
        this.f539l = (byte) -1;
        this.f540m = -1;
    }

    private C0150bp(boolean z) {
        this.f539l = (byte) -1;
        this.f540m = -1;
    }

    /* renamed from: a */
    public static C0150bp m1195a() {
        return f528a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0150bp getDefaultInstanceForType() {
        return f528a;
    }

    /* renamed from: c */
    public boolean m1211c() {
        return (this.f529b & 1) == 1;
    }

    /* renamed from: d */
    public long m1212d() {
        return this.f530c;
    }

    /* renamed from: e */
    public boolean m1213e() {
        return (this.f529b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0159by m1214f() {
        return this.f531d;
    }

    /* renamed from: g */
    public boolean m1215g() {
        return (this.f529b & 4) == 4;
    }

    /* renamed from: h */
    public EnumC0116ai m1216h() {
        return this.f532e;
    }

    /* renamed from: i */
    public boolean m1217i() {
        return (this.f529b & 8) == 8;
    }

    /* renamed from: j */
    public String m1218j() {
        Object obj = this.f533f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f533f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m1205v() {
        Object obj = this.f533f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f533f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1219k() {
        return (this.f529b & 16) == 16;
    }

    /* renamed from: l */
    public String m1220l() {
        Object obj = this.f534g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f534g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m1206w() {
        Object obj = this.f534g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f534g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m1221m() {
        return (this.f529b & 32) == 32;
    }

    /* renamed from: n */
    public long m1222n() {
        return this.f535h;
    }

    /* renamed from: o */
    public boolean m1223o() {
        return (this.f529b & 64) == 64;
    }

    /* renamed from: p */
    public String m1224p() {
        Object obj = this.f536i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f536i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m1207x() {
        Object obj = this.f536i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f536i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public List m1225q() {
        return this.f537j;
    }

    /* renamed from: r */
    public boolean m1226r() {
        return (this.f529b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128;
    }

    /* renamed from: s */
    public String m1227s() {
        Object obj = this.f538k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f538k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m1208y() {
        Object obj = this.f538k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f538k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: z */
    private void m1209z() {
        this.f530c = 0L;
        this.f531d = EnumC0159by.TEXT;
        this.f532e = EnumC0116ai.SINGLE;
        this.f533f = "";
        this.f534g = "";
        this.f535h = 0L;
        this.f536i = "";
        this.f537j = LazyStringArrayList.EMPTY;
        this.f538k = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f539l;
        if (b != -1) {
            return b == 1;
        }
        this.f539l = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f529b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f530c);
        }
        if ((this.f529b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f531d.getNumber());
        }
        if ((this.f529b & 4) == 4) {
            codedOutputStream.writeEnum(3, this.f532e.getNumber());
        }
        if ((this.f529b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1205v());
        }
        if ((this.f529b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1206w());
        }
        if ((this.f529b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f535h);
        }
        if ((this.f529b & 64) == 64) {
            codedOutputStream.writeBytes(7, m1207x());
        }
        for (int i = 0; i < this.f537j.size(); i++) {
            codedOutputStream.writeBytes(8, this.f537j.getByteString(i));
        }
        if ((this.f529b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
            codedOutputStream.writeBytes(9, m1208y());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f540m;
        if (size == -1) {
            int iComputeInt64Size = (this.f529b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f530c) + 0 : 0;
            if ((this.f529b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f531d.getNumber());
            }
            if ((this.f529b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(3, this.f532e.getNumber());
            }
            if ((this.f529b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1205v());
            }
            if ((this.f529b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1206w());
            }
            if ((this.f529b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(6, this.f535h);
            }
            if ((this.f529b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m1207x());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f537j.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f537j.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1225q().size() * 1);
            if ((this.f529b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m1208y());
            }
            this.f540m = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0150bp m1196a(byte[] bArr) {
        return ((C0151bq) newBuilder().mergeFrom(bArr)).m1234o();
    }

    public static C0151bq newBuilder() {
        return C0151bq.m1233n();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0151bq newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0151bq m1197a(C0150bp c0150bp) {
        return newBuilder().mergeFrom(c0150bp);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C0151bq toBuilder() {
        return m1197a(this);
    }

    static {
        f528a.m1209z();
    }
}
