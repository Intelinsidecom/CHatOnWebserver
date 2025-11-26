package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bv */
/* loaded from: classes.dex */
public final class C0309bv extends GeneratedMessageLite.Builder implements InterfaceC0342p {

    /* renamed from: a */
    private int f857a;

    /* renamed from: b */
    private long f858b;

    /* renamed from: c */
    private EnumC0275ao f859c = EnumC0275ao.TEXT;

    /* renamed from: d */
    private Object f860d = "";

    /* renamed from: e */
    private Object f861e = "";

    /* renamed from: f */
    private LazyStringList f862f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private LazyStringList f863g = LazyStringArrayList.EMPTY;

    private C0309bv() {
        m1566m();
    }

    /* renamed from: m */
    private void m1566m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static C0309bv m1567n() {
        return new C0309bv();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0309bv clear() {
        super.clear();
        this.f858b = 0L;
        this.f857a &= -2;
        this.f859c = EnumC0275ao.TEXT;
        this.f857a &= -3;
        this.f860d = "";
        this.f857a &= -5;
        this.f861e = "";
        this.f857a &= -9;
        this.f862f = LazyStringArrayList.EMPTY;
        this.f857a &= -17;
        this.f863g = LazyStringArrayList.EMPTY;
        this.f857a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0309bv mo5946clone() {
        return m1567n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0352z getDefaultInstanceForType() {
        return C0352z.m2018a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0352z build() {
        C0352z c0352zBuildPartial = buildPartial();
        if (!c0352zBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0352zBuildPartial);
        }
        return c0352zBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public C0352z m1568o() throws InvalidProtocolBufferException {
        C0352z c0352zBuildPartial = buildPartial();
        if (!c0352zBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0352zBuildPartial).asInvalidProtocolBufferException();
        }
        return c0352zBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0352z buildPartial() {
        C0352z c0352z = new C0352z(this);
        int i = this.f857a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0352z.f1011c = this.f858b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0352z.f1012d = this.f859c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0352z.f1013e = this.f860d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0352z.f1014f = this.f861e;
        if ((this.f857a & 16) == 16) {
            this.f862f = new UnmodifiableLazyStringList(this.f862f);
            this.f857a &= -17;
        }
        c0352z.f1015g = this.f862f;
        if ((this.f857a & 32) == 32) {
            this.f863g = new UnmodifiableLazyStringList(this.f863g);
            this.f857a &= -33;
        }
        c0352z.f1016h = this.f863g;
        c0352z.f1010b = i2;
        return c0352z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0309bv mergeFrom(C0352z c0352z) {
        if (c0352z != C0352z.m2018a()) {
            if (c0352z.m2029c()) {
                m1572a(c0352z.m2030d());
            }
            if (c0352z.m2031e()) {
                m1574a(c0352z.m2032f());
            }
            if (c0352z.m2033g()) {
                m1576a(c0352z.m2034h());
            }
            if (c0352z.m2035i()) {
                m1578b(c0352z.m2036j());
            }
            if (!c0352z.f1015g.isEmpty()) {
                if (this.f862f.isEmpty()) {
                    this.f862f = c0352z.f1015g;
                    this.f857a &= -17;
                } else {
                    m1569p();
                    this.f862f.addAll(c0352z.f1015g);
                }
            }
            if (!c0352z.f1016h.isEmpty()) {
                if (this.f863g.isEmpty()) {
                    this.f863g = c0352z.f1016h;
                    this.f857a &= -33;
                } else {
                    m1570q();
                    this.f863g.addAll(c0352z.f1016h);
                }
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0309bv mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f857a |= 1;
                    this.f858b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0275ao enumC0275aoM1170a = EnumC0275ao.m1170a(codedInputStream.readEnum());
                    if (enumC0275aoM1170a == null) {
                        break;
                    } else {
                        this.f857a |= 2;
                        this.f859c = enumC0275aoM1170a;
                        break;
                    }
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f857a |= 4;
                    this.f860d = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f857a |= 8;
                    this.f861e = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    m1569p();
                    this.f862f.add(codedInputStream.readBytes());
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    m1570q();
                    this.f863g.add(codedInputStream.readBytes());
                    break;
                default:
                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    /* renamed from: f */
    public long m1584f() {
        return this.f858b;
    }

    /* renamed from: a */
    public C0309bv m1572a(long j) {
        this.f857a |= 1;
        this.f858b = j;
        return this;
    }

    /* renamed from: a */
    public C0309bv m1574a(EnumC0275ao enumC0275ao) {
        if (enumC0275ao == null) {
            throw new NullPointerException();
        }
        this.f857a |= 2;
        this.f859c = enumC0275ao;
        return this;
    }

    /* renamed from: a */
    public C0309bv m1576a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f857a |= 4;
        this.f860d = str;
        return this;
    }

    /* renamed from: g */
    public String m1585g() {
        Object obj = this.f861e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f861e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0309bv m1578b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f857a |= 8;
        this.f861e = str;
        return this;
    }

    /* renamed from: p */
    private void m1569p() {
        if ((this.f857a & 16) != 16) {
            this.f862f = new LazyStringArrayList(this.f862f);
            this.f857a |= 16;
        }
    }

    /* renamed from: h */
    public List m1586h() {
        return Collections.unmodifiableList(this.f862f);
    }

    /* renamed from: i */
    public int m1587i() {
        return this.f862f.size();
    }

    /* renamed from: c */
    public C0309bv m1579c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1569p();
        this.f862f.add((LazyStringList) str);
        return this;
    }

    /* renamed from: q */
    private void m1570q() {
        if ((this.f857a & 32) != 32) {
            this.f863g = new LazyStringArrayList(this.f863g);
            this.f857a |= 32;
        }
    }

    /* renamed from: j */
    public List m1588j() {
        return Collections.unmodifiableList(this.f863g);
    }

    /* renamed from: k */
    public int m1589k() {
        return this.f863g.size();
    }

    /* renamed from: d */
    public C0309bv m1581d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1570q();
        this.f863g.add((LazyStringList) str);
        return this;
    }
}
