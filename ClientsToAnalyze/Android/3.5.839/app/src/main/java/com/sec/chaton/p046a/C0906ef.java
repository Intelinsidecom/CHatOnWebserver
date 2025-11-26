package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ef */
/* loaded from: classes.dex */
public final class C0906ef extends GeneratedMessageLite.Builder<C0905ee, C0906ef> implements InterfaceC0907eg {

    /* renamed from: a */
    private int f2829a;

    /* renamed from: b */
    private Object f2830b = "";

    /* renamed from: c */
    private Object f2831c = "";

    /* renamed from: d */
    private C0935fh f2832d = C0935fh.m5211a();

    /* renamed from: e */
    private long f2833e;

    private C0906ef() {
        m4870i();
    }

    /* renamed from: i */
    private void m4870i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0906ef m4871j() {
        return new C0906ef();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0906ef clear() {
        super.clear();
        this.f2830b = "";
        this.f2829a &= -2;
        this.f2831c = "";
        this.f2829a &= -3;
        this.f2832d = C0935fh.m5211a();
        this.f2829a &= -5;
        this.f2833e = 0L;
        this.f2829a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0906ef mo19949clone() {
        return m4871j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0905ee getDefaultInstanceForType() {
        return C0905ee.m4848a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0905ee build() {
        C0905ee c0905eeBuildPartial = buildPartial();
        if (!c0905eeBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0905eeBuildPartial);
        }
        return c0905eeBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0905ee m4872k() throws InvalidProtocolBufferException {
        C0905ee c0905eeBuildPartial = buildPartial();
        if (!c0905eeBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0905eeBuildPartial).asInvalidProtocolBufferException();
        }
        return c0905eeBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0905ee buildPartial() {
        C0905ee c0905ee = new C0905ee(this);
        int i = this.f2829a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0905ee.f2823c = this.f2830b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0905ee.f2824d = this.f2831c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0905ee.f2825e = this.f2832d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0905ee.f2826f = this.f2833e;
        c0905ee.f2822b = i2;
        return c0905ee;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0906ef mergeFrom(C0905ee c0905ee) {
        if (c0905ee != C0905ee.m4848a()) {
            if (c0905ee.m4858c()) {
                m4878a(c0905ee.m4859d());
            }
            if (c0905ee.m4860e()) {
                m4881b(c0905ee.m4861f());
            }
            if (c0905ee.m4862g()) {
                m4880b(c0905ee.m4863h());
            }
            if (c0905ee.m4864i()) {
                m4874a(c0905ee.m4865j());
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
    public C0906ef mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2829a |= 1;
                    this.f2830b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f2829a |= 2;
                    this.f2831c = codedInputStream.readBytes();
                    break;
                case 26:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m4885f()) {
                        c0936fiNewBuilder.mergeFrom(m4886g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m4877a(c0936fiNewBuilder.buildPartial());
                    break;
                case 32:
                    this.f2829a |= 8;
                    this.f2833e = codedInputStream.readInt64();
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
    public C0906ef m4878a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2829a |= 1;
        this.f2830b = str;
        return this;
    }

    /* renamed from: b */
    public C0906ef m4881b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2829a |= 2;
        this.f2831c = str;
        return this;
    }

    /* renamed from: f */
    public boolean m4885f() {
        return (this.f2829a & 4) == 4;
    }

    /* renamed from: g */
    public C0935fh m4886g() {
        return this.f2832d;
    }

    /* renamed from: a */
    public C0906ef m4877a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2832d = c0935fh;
        this.f2829a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0906ef m4880b(C0935fh c0935fh) {
        if ((this.f2829a & 4) == 4 && this.f2832d != C0935fh.m5211a()) {
            this.f2832d = C0935fh.m5212a(this.f2832d).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2832d = c0935fh;
        }
        this.f2829a |= 4;
        return this;
    }

    /* renamed from: a */
    public C0906ef m4874a(long j) {
        this.f2829a |= 8;
        this.f2833e = j;
        return this;
    }
}
