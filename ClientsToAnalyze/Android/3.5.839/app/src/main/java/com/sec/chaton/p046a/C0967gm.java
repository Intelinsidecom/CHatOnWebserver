package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.gm */
/* loaded from: classes.dex */
public final class C0967gm extends GeneratedMessageLite.Builder<C0966gl, C0967gm> implements InterfaceC0968gn {

    /* renamed from: a */
    private int f3116a;

    /* renamed from: d */
    private long f3119d;

    /* renamed from: e */
    private long f3120e;

    /* renamed from: b */
    private Object f3117b = "";

    /* renamed from: c */
    private Object f3118c = "";

    /* renamed from: f */
    private LazyStringList f3121f = LazyStringArrayList.EMPTY;

    private C0967gm() {
        m5671g();
    }

    /* renamed from: g */
    private void m5671g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0967gm m5672h() {
        return new C0967gm();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0967gm clear() {
        super.clear();
        this.f3117b = "";
        this.f3116a &= -2;
        this.f3118c = "";
        this.f3116a &= -3;
        this.f3119d = 0L;
        this.f3116a &= -5;
        this.f3120e = 0L;
        this.f3116a &= -9;
        this.f3121f = LazyStringArrayList.EMPTY;
        this.f3116a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0967gm mo19949clone() {
        return m5672h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0966gl getDefaultInstanceForType() {
        return C0966gl.m5647a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0966gl build() {
        C0966gl c0966glBuildPartial = buildPartial();
        if (!c0966glBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0966glBuildPartial);
        }
        return c0966glBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0966gl m5673i() throws InvalidProtocolBufferException {
        C0966gl c0966glBuildPartial = buildPartial();
        if (!c0966glBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0966glBuildPartial).asInvalidProtocolBufferException();
        }
        return c0966glBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0966gl buildPartial() {
        C0966gl c0966gl = new C0966gl(this);
        int i = this.f3116a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0966gl.f3109c = this.f3117b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0966gl.f3110d = this.f3118c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0966gl.f3111e = this.f3119d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0966gl.f3112f = this.f3120e;
        if ((this.f3116a & 16) == 16) {
            this.f3121f = new UnmodifiableLazyStringList(this.f3121f);
            this.f3116a &= -17;
        }
        c0966gl.f3113g = this.f3121f;
        c0966gl.f3108b = i2;
        return c0966gl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0967gm mergeFrom(C0966gl c0966gl) {
        if (c0966gl != C0966gl.m5647a()) {
            if (c0966gl.m5658c()) {
                m5679a(c0966gl.m5659d());
            }
            if (c0966gl.m5660e()) {
                m5682b(c0966gl.m5661f());
            }
            if (c0966gl.m5662g()) {
                m5676a(c0966gl.m5663h());
            }
            if (c0966gl.m5664i()) {
                m5681b(c0966gl.m5665j());
            }
            if (!c0966gl.f3113g.isEmpty()) {
                if (this.f3121f.isEmpty()) {
                    this.f3121f = c0966gl.f3113g;
                    this.f3116a &= -17;
                } else {
                    m5674j();
                    this.f3121f.addAll(c0966gl.f3113g);
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
    public C0967gm mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f3116a |= 1;
                    this.f3117b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f3116a |= 2;
                    this.f3118c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f3116a |= 4;
                    this.f3119d = codedInputStream.readInt64();
                    break;
                case 32:
                    this.f3116a |= 8;
                    this.f3120e = codedInputStream.readInt64();
                    break;
                case 42:
                    m5674j();
                    this.f3121f.add(codedInputStream.readBytes());
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
    public C0967gm m5679a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3116a |= 1;
        this.f3117b = str;
        return this;
    }

    /* renamed from: b */
    public C0967gm m5682b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3116a |= 2;
        this.f3118c = str;
        return this;
    }

    /* renamed from: a */
    public C0967gm m5676a(long j) {
        this.f3116a |= 4;
        this.f3119d = j;
        return this;
    }

    /* renamed from: b */
    public C0967gm m5681b(long j) {
        this.f3116a |= 8;
        this.f3120e = j;
        return this;
    }

    /* renamed from: j */
    private void m5674j() {
        if ((this.f3116a & 16) != 16) {
            this.f3121f = new LazyStringArrayList(this.f3121f);
            this.f3116a |= 16;
        }
    }
}
