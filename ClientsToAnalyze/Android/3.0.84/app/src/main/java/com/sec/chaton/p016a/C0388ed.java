package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ed */
/* loaded from: classes.dex */
public final class C0388ed extends GeneratedMessageLite implements InterfaceC0390ef {

    /* renamed from: a */
    private static final C0388ed f1358a = new C0388ed(true);

    /* renamed from: b */
    private int f1359b;

    /* renamed from: c */
    private long f1360c;

    /* renamed from: d */
    private LazyStringList f1361d;

    /* renamed from: e */
    private List<C0351cu> f1362e;

    /* renamed from: f */
    private Object f1363f;

    /* renamed from: g */
    private byte f1364g;

    /* renamed from: h */
    private int f1365h;

    private C0388ed(C0389ee c0389ee) {
        super(c0389ee);
        this.f1364g = (byte) -1;
        this.f1365h = -1;
    }

    private C0388ed(boolean z) {
        this.f1364g = (byte) -1;
        this.f1365h = -1;
    }

    /* renamed from: a */
    public static C0388ed m2718a() {
        return f1358a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0388ed getDefaultInstanceForType() {
        return f1358a;
    }

    /* renamed from: c */
    public boolean m2727c() {
        return (this.f1359b & 1) == 1;
    }

    /* renamed from: d */
    public long m2728d() {
        return this.f1360c;
    }

    /* renamed from: e */
    public List<String> m2729e() {
        return this.f1361d;
    }

    /* renamed from: f */
    public int m2730f() {
        return this.f1361d.size();
    }

    /* renamed from: g */
    public List<C0351cu> m2731g() {
        return this.f1362e;
    }

    /* renamed from: h */
    public boolean m2732h() {
        return (this.f1359b & 2) == 2;
    }

    /* renamed from: i */
    public String m2733i() {
        Object obj = this.f1363f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1363f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m2724l() {
        Object obj = this.f1363f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1363f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    private void m2725m() {
        this.f1360c = 0L;
        this.f1361d = LazyStringArrayList.EMPTY;
        this.f1362e = Collections.emptyList();
        this.f1363f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1364g;
        if (b != -1) {
            return b == 1;
        }
        this.f1364g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1359b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1360c);
        }
        for (int i = 0; i < this.f1361d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f1361d.getByteString(i));
        }
        for (int i2 = 0; i2 < this.f1362e.size(); i2++) {
            codedOutputStream.writeMessage(3, this.f1362e.get(i2));
        }
        if ((this.f1359b & 2) == 2) {
            codedOutputStream.writeBytes(4, m2724l());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeBytesSize = this.f1365h;
        if (iComputeBytesSize == -1) {
            int iComputeInt64Size = (this.f1359b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1360c) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f1361d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1361d.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m2729e().size() * 1);
            while (true) {
                iComputeBytesSize = size;
                if (i >= this.f1362e.size()) {
                    break;
                }
                size = CodedOutputStream.computeMessageSize(3, this.f1362e.get(i)) + iComputeBytesSize;
                i++;
            }
            if ((this.f1359b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(4, m2724l());
            }
            this.f1365h = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0389ee newBuilder() {
        return C0389ee.m2738h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0389ee newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0389ee m2719a(C0388ed c0388ed) {
        return newBuilder().mergeFrom(c0388ed);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0389ee toBuilder() {
        return m2719a(this);
    }

    static {
        f1358a.m2725m();
    }
}
