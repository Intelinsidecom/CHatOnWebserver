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
/* renamed from: com.sec.chaton.a.af */
/* loaded from: classes.dex */
public final class C0113af extends GeneratedMessageLite implements InterfaceC0115ah {

    /* renamed from: a */
    private static final C0113af f366a = new C0113af(true);

    /* renamed from: b */
    private int f367b;

    /* renamed from: c */
    private long f368c;

    /* renamed from: d */
    private EnumC0159by f369d;

    /* renamed from: e */
    private EnumC0116ai f370e;

    /* renamed from: f */
    private Object f371f;

    /* renamed from: g */
    private Object f372g;

    /* renamed from: h */
    private LazyStringList f373h;

    /* renamed from: i */
    private Object f374i;

    /* renamed from: j */
    private Object f375j;

    /* renamed from: k */
    private Object f376k;

    /* renamed from: l */
    private Object f377l;

    /* renamed from: m */
    private byte f378m;

    /* renamed from: n */
    private int f379n;

    private C0113af(C0114ag c0114ag) {
        super(c0114ag);
        this.f378m = (byte) -1;
        this.f379n = -1;
    }

    private C0113af(boolean z) {
        this.f378m = (byte) -1;
        this.f379n = -1;
    }

    /* renamed from: a */
    public static C0113af m746a() {
        return f366a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0113af getDefaultInstanceForType() {
        return f366a;
    }

    /* renamed from: c */
    public boolean m762c() {
        return (this.f367b & 1) == 1;
    }

    /* renamed from: d */
    public long m763d() {
        return this.f368c;
    }

    /* renamed from: e */
    public boolean m764e() {
        return (this.f367b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0159by m765f() {
        return this.f369d;
    }

    /* renamed from: g */
    public boolean m766g() {
        return (this.f367b & 4) == 4;
    }

    /* renamed from: h */
    public EnumC0116ai m767h() {
        return this.f370e;
    }

    /* renamed from: i */
    public boolean m768i() {
        return (this.f367b & 8) == 8;
    }

    /* renamed from: j */
    public String m769j() {
        Object obj = this.f371f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f371f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m758x() {
        Object obj = this.f371f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f371f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m770k() {
        return (this.f367b & 16) == 16;
    }

    /* renamed from: l */
    public String m771l() {
        Object obj = this.f372g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f372g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m759y() {
        Object obj = this.f372g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f372g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List m772m() {
        return this.f373h;
    }

    /* renamed from: n */
    public boolean m773n() {
        return (this.f367b & 32) == 32;
    }

    /* renamed from: o */
    public String m774o() {
        Object obj = this.f374i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f374i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m760z() {
        Object obj = this.f374i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f374i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    public boolean m775p() {
        return (this.f367b & 64) == 64;
    }

    /* renamed from: q */
    public String m776q() {
        Object obj = this.f375j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f375j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m739A() {
        Object obj = this.f375j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f375j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: r */
    public boolean m777r() {
        return (this.f367b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128;
    }

    /* renamed from: s */
    public String m778s() {
        Object obj = this.f376k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f376k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m740B() {
        Object obj = this.f376k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f376k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    public boolean m779t() {
        return (this.f367b & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256;
    }

    /* renamed from: u */
    public String m780u() {
        Object obj = this.f377l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f377l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m741C() {
        Object obj = this.f377l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f377l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: D */
    private void m742D() {
        this.f368c = 0L;
        this.f369d = EnumC0159by.TEXT;
        this.f370e = EnumC0116ai.SINGLE;
        this.f371f = "";
        this.f372g = "";
        this.f373h = LazyStringArrayList.EMPTY;
        this.f374i = "";
        this.f375j = "";
        this.f376k = "";
        this.f377l = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f378m;
        if (b != -1) {
            return b == 1;
        }
        this.f378m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f367b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f368c);
        }
        if ((this.f367b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f369d.getNumber());
        }
        if ((this.f367b & 4) == 4) {
            codedOutputStream.writeEnum(3, this.f370e.getNumber());
        }
        if ((this.f367b & 8) == 8) {
            codedOutputStream.writeBytes(4, m758x());
        }
        if ((this.f367b & 16) == 16) {
            codedOutputStream.writeBytes(5, m759y());
        }
        for (int i = 0; i < this.f373h.size(); i++) {
            codedOutputStream.writeBytes(6, this.f373h.getByteString(i));
        }
        if ((this.f367b & 32) == 32) {
            codedOutputStream.writeBytes(7, m760z());
        }
        if ((this.f367b & 64) == 64) {
            codedOutputStream.writeBytes(8, m739A());
        }
        if ((this.f367b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
            codedOutputStream.writeBytes(9, m740B());
        }
        if ((this.f367b & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256) {
            codedOutputStream.writeBytes(10, m741C());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f379n;
        if (size == -1) {
            int iComputeInt64Size = (this.f367b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f368c) + 0 : 0;
            if ((this.f367b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f369d.getNumber());
            }
            if ((this.f367b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(3, this.f370e.getNumber());
            }
            if ((this.f367b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m758x());
            }
            if ((this.f367b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m759y());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f373h.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f373h.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m772m().size() * 1);
            if ((this.f367b & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(7, m760z());
            }
            if ((this.f367b & 64) == 64) {
                size += CodedOutputStream.computeBytesSize(8, m739A());
            }
            if ((this.f367b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m740B());
            }
            if ((this.f367b & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256) {
                size += CodedOutputStream.computeBytesSize(10, m741C());
            }
            this.f379n = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0113af m747a(byte[] bArr) {
        return ((C0114ag) newBuilder().mergeFrom(bArr)).m787p();
    }

    public static C0114ag newBuilder() {
        return C0114ag.m786o();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public C0114ag newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0114ag m748a(C0113af c0113af) {
        return newBuilder().mergeFrom(c0113af);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0114ag toBuilder() {
        return m748a(this);
    }

    static {
        f366a.m742D();
    }
}
