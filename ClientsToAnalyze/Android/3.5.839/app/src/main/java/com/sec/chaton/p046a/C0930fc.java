package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fc */
/* loaded from: classes.dex */
public final class C0930fc extends GeneratedMessageLite.Builder<C0929fb, C0930fc> implements InterfaceC0931fd {

    /* renamed from: a */
    private int f2921a;

    /* renamed from: b */
    private long f2922b;

    /* renamed from: c */
    private C0935fh f2923c = C0935fh.m5211a();

    /* renamed from: d */
    private Object f2924d = "";

    private C0930fc() {
        m5123i();
    }

    /* renamed from: i */
    private void m5123i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0930fc m5124j() {
        return new C0930fc();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0930fc clear() {
        super.clear();
        this.f2922b = 0L;
        this.f2921a &= -2;
        this.f2923c = C0935fh.m5211a();
        this.f2921a &= -3;
        this.f2924d = "";
        this.f2921a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0930fc mo19949clone() {
        return m5124j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0929fb getDefaultInstanceForType() {
        return C0929fb.m5105a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0929fb build() {
        C0929fb c0929fbBuildPartial = buildPartial();
        if (!c0929fbBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0929fbBuildPartial);
        }
        return c0929fbBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0929fb m5125k() throws InvalidProtocolBufferException {
        C0929fb c0929fbBuildPartial = buildPartial();
        if (!c0929fbBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0929fbBuildPartial).asInvalidProtocolBufferException();
        }
        return c0929fbBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0929fb buildPartial() {
        C0929fb c0929fb = new C0929fb(this);
        int i = this.f2921a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0929fb.f2916c = this.f2922b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0929fb.f2917d = this.f2923c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0929fb.f2918e = this.f2924d;
        c0929fb.f2915b = i2;
        return c0929fb;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0930fc mergeFrom(C0929fb c0929fb) {
        if (c0929fb != C0929fb.m5105a()) {
            if (c0929fb.m5113c()) {
                m5127a(c0929fb.m5114d());
            }
            if (c0929fb.m5115e()) {
                m5133b(c0929fb.m5116f());
            }
            if (c0929fb.m5117g()) {
                m5131a(c0929fb.m5118h());
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
    public C0930fc mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2921a |= 1;
                    this.f2922b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m5137f()) {
                        c0936fiNewBuilder.mergeFrom(m5138g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m5130a(c0936fiNewBuilder.buildPartial());
                    break;
                case 26:
                    this.f2921a |= 4;
                    this.f2924d = codedInputStream.readBytes();
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
    public C0930fc m5127a(long j) {
        this.f2921a |= 1;
        this.f2922b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m5137f() {
        return (this.f2921a & 2) == 2;
    }

    /* renamed from: g */
    public C0935fh m5138g() {
        return this.f2923c;
    }

    /* renamed from: a */
    public C0930fc m5130a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2923c = c0935fh;
        this.f2921a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0930fc m5133b(C0935fh c0935fh) {
        if ((this.f2921a & 2) == 2 && this.f2923c != C0935fh.m5211a()) {
            this.f2923c = C0935fh.m5212a(this.f2923c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2923c = c0935fh;
        }
        this.f2921a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0930fc m5131a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2921a |= 4;
        this.f2924d = str;
        return this;
    }
}
