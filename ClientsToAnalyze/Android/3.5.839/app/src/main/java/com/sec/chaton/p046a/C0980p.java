package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.p */
/* loaded from: classes.dex */
public final class C0980p extends GeneratedMessageLite.Builder<C0979o, C0980p> implements InterfaceC0981q {

    /* renamed from: a */
    private int f3203a;

    /* renamed from: b */
    private long f3204b;

    /* renamed from: c */
    private C0935fh f3205c = C0935fh.m5211a();

    /* renamed from: d */
    private Object f3206d = "";

    /* renamed from: e */
    private long f3207e;

    private C0980p() {
        m5904j();
    }

    /* renamed from: j */
    private void m5904j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static C0980p m5905k() {
        return new C0980p();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0980p clear() {
        super.clear();
        this.f3204b = 0L;
        this.f3203a &= -2;
        this.f3205c = C0935fh.m5211a();
        this.f3203a &= -3;
        this.f3206d = "";
        this.f3203a &= -5;
        this.f3207e = 0L;
        this.f3203a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0980p mo19949clone() {
        return m5905k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0979o getDefaultInstanceForType() {
        return C0979o.m5884a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0979o build() {
        C0979o c0979oBuildPartial = buildPartial();
        if (!c0979oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0979oBuildPartial);
        }
        return c0979oBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public C0979o m5906l() throws InvalidProtocolBufferException {
        C0979o c0979oBuildPartial = buildPartial();
        if (!c0979oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0979oBuildPartial).asInvalidProtocolBufferException();
        }
        return c0979oBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0979o buildPartial() {
        C0979o c0979o = new C0979o(this);
        int i = this.f3203a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0979o.f3197c = this.f3204b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0979o.f3198d = this.f3205c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0979o.f3199e = this.f3206d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0979o.f3200f = this.f3207e;
        c0979o.f3196b = i2;
        return c0979o;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0980p mergeFrom(C0979o c0979o) {
        if (c0979o != C0979o.m5884a()) {
            if (c0979o.m5892c()) {
                m5908a(c0979o.m5893d());
            }
            if (c0979o.m5894e()) {
                m5916b(c0979o.m5895f());
            }
            if (c0979o.m5896g()) {
                m5913a(c0979o.m5897h());
            }
            if (c0979o.m5898i()) {
                m5915b(c0979o.m5899j());
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
    public C0980p mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3203a |= 1;
                    this.f3204b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m5921g()) {
                        c0936fiNewBuilder.mergeFrom(m5922h());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m5910a(c0936fiNewBuilder.buildPartial());
                    break;
                case 26:
                    this.f3203a |= 4;
                    this.f3206d = codedInputStream.readBytes();
                    break;
                case 32:
                    this.f3203a |= 8;
                    this.f3207e = codedInputStream.readInt64();
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
    public long m5920f() {
        return this.f3204b;
    }

    /* renamed from: a */
    public C0980p m5908a(long j) {
        this.f3203a |= 1;
        this.f3204b = j;
        return this;
    }

    /* renamed from: g */
    public boolean m5921g() {
        return (this.f3203a & 2) == 2;
    }

    /* renamed from: h */
    public C0935fh m5922h() {
        return this.f3205c;
    }

    /* renamed from: a */
    public C0980p m5910a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f3205c = c0935fh;
        this.f3203a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0980p m5911a(C0936fi c0936fi) {
        this.f3205c = c0936fi.build();
        this.f3203a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0980p m5916b(C0935fh c0935fh) {
        if ((this.f3203a & 2) == 2 && this.f3205c != C0935fh.m5211a()) {
            this.f3205c = C0935fh.m5212a(this.f3205c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f3205c = c0935fh;
        }
        this.f3203a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0980p m5913a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3203a |= 4;
        this.f3206d = str;
        return this;
    }

    /* renamed from: b */
    public C0980p m5915b(long j) {
        this.f3203a |= 8;
        this.f3207e = j;
        return this;
    }
}
