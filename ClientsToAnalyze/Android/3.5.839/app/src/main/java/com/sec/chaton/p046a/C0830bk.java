package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bk */
/* loaded from: classes.dex */
public final class C0830bk extends GeneratedMessageLite.Builder<C0829bj, C0830bk> implements InterfaceC0834bo {

    /* renamed from: a */
    private int f2395a;

    /* renamed from: e */
    private int f2399e;

    /* renamed from: f */
    private long f2400f;

    /* renamed from: b */
    private Object f2396b = "";

    /* renamed from: c */
    private List<C0831bl> f2397c = Collections.emptyList();

    /* renamed from: d */
    private C0935fh f2398d = C0935fh.m5211a();

    /* renamed from: g */
    private Object f2401g = "";

    private C0830bk() {
        m3666l();
    }

    /* renamed from: l */
    private void m3666l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static C0830bk m3667m() {
        return new C0830bk();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0830bk clear() {
        super.clear();
        this.f2396b = "";
        this.f2395a &= -2;
        this.f2397c = Collections.emptyList();
        this.f2395a &= -3;
        this.f2398d = C0935fh.m5211a();
        this.f2395a &= -5;
        this.f2399e = 0;
        this.f2395a &= -9;
        this.f2400f = 0L;
        this.f2395a &= -17;
        this.f2401g = "";
        this.f2395a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0830bk mo19949clone() {
        return m3667m().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0829bj getDefaultInstanceForType() {
        return C0829bj.m3636a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0829bj build() {
        C0829bj c0829bjBuildPartial = buildPartial();
        if (!c0829bjBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0829bjBuildPartial);
        }
        return c0829bjBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public C0829bj m3668n() throws InvalidProtocolBufferException {
        C0829bj c0829bjBuildPartial = buildPartial();
        if (!c0829bjBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0829bjBuildPartial).asInvalidProtocolBufferException();
        }
        return c0829bjBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0829bj buildPartial() {
        C0829bj c0829bj = new C0829bj(this);
        int i = this.f2395a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0829bj.f2387c = this.f2396b;
        if ((this.f2395a & 2) == 2) {
            this.f2397c = Collections.unmodifiableList(this.f2397c);
            this.f2395a &= -3;
        }
        c0829bj.f2388d = this.f2397c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0829bj.f2389e = this.f2398d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0829bj.f2390f = this.f2399e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0829bj.f2391g = this.f2400f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0829bj.f2392h = this.f2401g;
        c0829bj.f2386b = i2;
        return c0829bj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0830bk mergeFrom(C0829bj c0829bj) {
        if (c0829bj != C0829bj.m3636a()) {
            if (c0829bj.m3650c()) {
                m3676a(c0829bj.m3651d());
            }
            if (!c0829bj.f2388d.isEmpty()) {
                if (this.f2397c.isEmpty()) {
                    this.f2397c = c0829bj.f2388d;
                    this.f2395a &= -3;
                } else {
                    m3669o();
                    this.f2397c.addAll(c0829bj.f2388d);
                }
            }
            if (c0829bj.m3654g()) {
                m3680b(c0829bj.m3655h());
            }
            if (c0829bj.m3656i()) {
                m3679b(c0829bj.m3657j());
            }
            if (c0829bj.m3658k()) {
                m3671a(c0829bj.m3659l());
            }
            if (c0829bj.m3660m()) {
                m3681b(c0829bj.m3661n());
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
    public C0830bk mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2395a |= 1;
                    this.f2396b = codedInputStream.readBytes();
                    break;
                case 18:
                    MessageLite.Builder builderNewBuilder = C0831bl.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m3674a(builderNewBuilder.buildPartial());
                    break;
                case 26:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m3687h()) {
                        c0936fiNewBuilder.mergeFrom(m3688i());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m3675a(c0936fiNewBuilder.buildPartial());
                    break;
                case 32:
                    this.f2395a |= 8;
                    this.f2399e = codedInputStream.readInt32();
                    break;
                case 40:
                    this.f2395a |= 16;
                    this.f2400f = codedInputStream.readInt64();
                    break;
                case 50:
                    this.f2395a |= 32;
                    this.f2401g = codedInputStream.readBytes();
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

    /* renamed from: a */
    public C0830bk m3676a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2395a |= 1;
        this.f2396b = str;
        return this;
    }

    /* renamed from: o */
    private void m3669o() {
        if ((this.f2395a & 2) != 2) {
            this.f2397c = new ArrayList(this.f2397c);
            this.f2395a |= 2;
        }
    }

    /* renamed from: f */
    public List<C0831bl> m3685f() {
        return Collections.unmodifiableList(this.f2397c);
    }

    /* renamed from: g */
    public int m3686g() {
        return this.f2397c.size();
    }

    /* renamed from: a */
    public C0831bl m3677a(int i) {
        return this.f2397c.get(i);
    }

    /* renamed from: a */
    public C0830bk m3674a(C0831bl c0831bl) {
        if (c0831bl == null) {
            throw new NullPointerException();
        }
        m3669o();
        this.f2397c.add(c0831bl);
        return this;
    }

    /* renamed from: h */
    public boolean m3687h() {
        return (this.f2395a & 4) == 4;
    }

    /* renamed from: i */
    public C0935fh m3688i() {
        return this.f2398d;
    }

    /* renamed from: a */
    public C0830bk m3675a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2398d = c0935fh;
        this.f2395a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0830bk m3680b(C0935fh c0935fh) {
        if ((this.f2395a & 4) == 4 && this.f2398d != C0935fh.m5211a()) {
            this.f2398d = C0935fh.m5212a(this.f2398d).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2398d = c0935fh;
        }
        this.f2395a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0830bk m3679b(int i) {
        this.f2395a |= 8;
        this.f2399e = i;
        return this;
    }

    /* renamed from: a */
    public C0830bk m3671a(long j) {
        this.f2395a |= 16;
        this.f2400f = j;
        return this;
    }

    /* renamed from: j */
    public String m3689j() {
        Object obj = this.f2401g;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2401g = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0830bk m3681b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2395a |= 32;
        this.f2401g = str;
        return this;
    }
}
