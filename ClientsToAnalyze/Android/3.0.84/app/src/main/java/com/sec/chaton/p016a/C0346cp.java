package com.sec.chaton.p016a;

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
/* renamed from: com.sec.chaton.a.cp */
/* loaded from: classes.dex */
public final class C0346cp extends GeneratedMessageLite.Builder<C0345co, C0346cp> implements InterfaceC0347cq {

    /* renamed from: a */
    private int f1198a;

    /* renamed from: b */
    private long f1199b;

    /* renamed from: c */
    private EnumC0354cx f1200c = EnumC0354cx.TEXT;

    /* renamed from: d */
    private Object f1201d = "";

    /* renamed from: e */
    private Object f1202e = "";

    /* renamed from: f */
    private LazyStringList f1203f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private LazyStringList f1204g = LazyStringArrayList.EMPTY;

    /* renamed from: h */
    private long f1205h;

    private C0346cp() {
        m2252n();
    }

    /* renamed from: n */
    private void m2252n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static C0346cp m2253o() {
        return new C0346cp();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0346cp clear() {
        super.clear();
        this.f1199b = 0L;
        this.f1198a &= -2;
        this.f1200c = EnumC0354cx.TEXT;
        this.f1198a &= -3;
        this.f1201d = "";
        this.f1198a &= -5;
        this.f1202e = "";
        this.f1198a &= -9;
        this.f1203f = LazyStringArrayList.EMPTY;
        this.f1198a &= -17;
        this.f1204g = LazyStringArrayList.EMPTY;
        this.f1198a &= -33;
        this.f1205h = 0L;
        this.f1198a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0346cp mo13386clone() {
        return m2253o().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0345co getDefaultInstanceForType() {
        return C0345co.m2222a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0345co build() {
        C0345co c0345coBuildPartial = buildPartial();
        if (!c0345coBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0345coBuildPartial);
        }
        return c0345coBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public C0345co m2254p() throws InvalidProtocolBufferException {
        C0345co c0345coBuildPartial = buildPartial();
        if (!c0345coBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0345coBuildPartial).asInvalidProtocolBufferException();
        }
        return c0345coBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0345co buildPartial() {
        C0345co c0345co = new C0345co(this);
        int i = this.f1198a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0345co.f1189c = this.f1199b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0345co.f1190d = this.f1200c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0345co.f1191e = this.f1201d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0345co.f1192f = this.f1202e;
        if ((this.f1198a & 16) == 16) {
            this.f1203f = new UnmodifiableLazyStringList(this.f1203f);
            this.f1198a &= -17;
        }
        c0345co.f1193g = this.f1203f;
        if ((this.f1198a & 32) == 32) {
            this.f1204g = new UnmodifiableLazyStringList(this.f1204g);
            this.f1198a &= -33;
        }
        c0345co.f1194h = this.f1204g;
        if ((i & 64) == 64) {
            i2 |= 16;
        }
        c0345co.f1195i = this.f1205h;
        c0345co.f1188b = i2;
        return c0345co;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0346cp mergeFrom(C0345co c0345co) {
        if (c0345co != C0345co.m2222a()) {
            if (c0345co.m2236c()) {
                m2258a(c0345co.m2237d());
            }
            if (c0345co.m2238e()) {
                m2261a(c0345co.m2239f());
            }
            if (c0345co.m2240g()) {
                m2262a(c0345co.m2241h());
            }
            if (c0345co.m2242i()) {
                m2265b(c0345co.m2243j());
            }
            if (!c0345co.f1193g.isEmpty()) {
                if (this.f1203f.isEmpty()) {
                    this.f1203f = c0345co.f1193g;
                    this.f1198a &= -17;
                } else {
                    m2255q();
                    this.f1203f.addAll(c0345co.f1193g);
                }
            }
            if (!c0345co.f1194h.isEmpty()) {
                if (this.f1204g.isEmpty()) {
                    this.f1204g = c0345co.f1194h;
                    this.f1198a &= -33;
                } else {
                    m2256r();
                    this.f1204g.addAll(c0345co.f1194h);
                }
            }
            if (c0345co.m2246m()) {
                m2264b(c0345co.m2247n());
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
    public C0346cp mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1198a |= 1;
                    this.f1199b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0354cx enumC0354cxM2352a = EnumC0354cx.m2352a(codedInputStream.readEnum());
                    if (enumC0354cxM2352a == null) {
                        break;
                    } else {
                        this.f1198a |= 2;
                        this.f1200c = enumC0354cxM2352a;
                        break;
                    }
                case 26:
                    this.f1198a |= 4;
                    this.f1201d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1198a |= 8;
                    this.f1202e = codedInputStream.readBytes();
                    break;
                case 42:
                    m2255q();
                    this.f1203f.add(codedInputStream.readBytes());
                    break;
                case 50:
                    m2256r();
                    this.f1204g.add(codedInputStream.readBytes());
                    break;
                case 56:
                    this.f1198a |= 64;
                    this.f1205h = codedInputStream.readInt64();
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
    public long m2271f() {
        return this.f1199b;
    }

    /* renamed from: a */
    public C0346cp m2258a(long j) {
        this.f1198a |= 1;
        this.f1199b = j;
        return this;
    }

    /* renamed from: a */
    public C0346cp m2261a(EnumC0354cx enumC0354cx) {
        if (enumC0354cx == null) {
            throw new NullPointerException();
        }
        this.f1198a |= 2;
        this.f1200c = enumC0354cx;
        return this;
    }

    /* renamed from: a */
    public C0346cp m2262a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1198a |= 4;
        this.f1201d = str;
        return this;
    }

    /* renamed from: g */
    public String m2272g() {
        Object obj = this.f1202e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f1202e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0346cp m2265b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1198a |= 8;
        this.f1202e = str;
        return this;
    }

    /* renamed from: q */
    private void m2255q() {
        if ((this.f1198a & 16) != 16) {
            this.f1203f = new LazyStringArrayList(this.f1203f);
            this.f1198a |= 16;
        }
    }

    /* renamed from: h */
    public List<String> m2273h() {
        return Collections.unmodifiableList(this.f1203f);
    }

    /* renamed from: i */
    public int m2274i() {
        return this.f1203f.size();
    }

    /* renamed from: c */
    public C0346cp m2267c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m2255q();
        this.f1203f.add((LazyStringList) str);
        return this;
    }

    /* renamed from: r */
    private void m2256r() {
        if ((this.f1198a & 32) != 32) {
            this.f1204g = new LazyStringArrayList(this.f1204g);
            this.f1198a |= 32;
        }
    }

    /* renamed from: j */
    public List<String> m2275j() {
        return Collections.unmodifiableList(this.f1204g);
    }

    /* renamed from: k */
    public int m2276k() {
        return this.f1204g.size();
    }

    /* renamed from: d */
    public C0346cp m2269d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m2256r();
        this.f1204g.add((LazyStringList) str);
        return this;
    }

    /* renamed from: l */
    public long m2277l() {
        return this.f1205h;
    }

    /* renamed from: b */
    public C0346cp m2264b(long j) {
        this.f1198a |= 64;
        this.f1205h = j;
        return this;
    }
}
