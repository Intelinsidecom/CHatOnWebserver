package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dw */
/* loaded from: classes.dex */
public final class C0896dw extends GeneratedMessageLite.Builder<C0895dv, C0896dw> implements InterfaceC0897dx {

    /* renamed from: a */
    private int f2770a;

    /* renamed from: b */
    private long f2771b;

    /* renamed from: c */
    private Object f2772c = "";

    /* renamed from: d */
    private C0935fh f2773d = C0935fh.m5211a();

    /* renamed from: e */
    private long f2774e;

    private C0896dw() {
        m4708i();
    }

    /* renamed from: i */
    private void m4708i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0896dw m4709j() {
        return new C0896dw();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0896dw clear() {
        super.clear();
        this.f2771b = 0L;
        this.f2770a &= -2;
        this.f2772c = "";
        this.f2770a &= -3;
        this.f2773d = C0935fh.m5211a();
        this.f2770a &= -5;
        this.f2774e = 0L;
        this.f2770a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0896dw mo19949clone() {
        return m4709j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0895dv getDefaultInstanceForType() {
        return C0895dv.m4687a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0895dv build() {
        C0895dv c0895dvBuildPartial = buildPartial();
        if (!c0895dvBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0895dvBuildPartial);
        }
        return c0895dvBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0895dv m4710k() throws InvalidProtocolBufferException {
        C0895dv c0895dvBuildPartial = buildPartial();
        if (!c0895dvBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0895dvBuildPartial).asInvalidProtocolBufferException();
        }
        return c0895dvBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0895dv buildPartial() {
        C0895dv c0895dv = new C0895dv(this);
        int i = this.f2770a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0895dv.f2764c = this.f2771b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0895dv.f2765d = this.f2772c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0895dv.f2766e = this.f2773d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0895dv.f2767f = this.f2774e;
        c0895dv.f2763b = i2;
        return c0895dv;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0896dw mergeFrom(C0895dv c0895dv) {
        if (c0895dv != C0895dv.m4687a()) {
            if (c0895dv.m4696c()) {
                m4712a(c0895dv.m4697d());
            }
            if (c0895dv.m4698e()) {
                m4716a(c0895dv.m4699f());
            }
            if (c0895dv.m4700g()) {
                m4719b(c0895dv.m4701h());
            }
            if (c0895dv.m4702i()) {
                m4718b(c0895dv.m4703j());
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
    public C0896dw mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2770a |= 1;
                    this.f2771b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f2770a |= 2;
                    this.f2772c = codedInputStream.readBytes();
                    break;
                case 26:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m4723f()) {
                        c0936fiNewBuilder.mergeFrom(m4724g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m4715a(c0936fiNewBuilder.buildPartial());
                    break;
                case 32:
                    this.f2770a |= 8;
                    this.f2774e = codedInputStream.readInt64();
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
    public C0896dw m4712a(long j) {
        this.f2770a |= 1;
        this.f2771b = j;
        return this;
    }

    /* renamed from: a */
    public C0896dw m4716a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2770a |= 2;
        this.f2772c = str;
        return this;
    }

    /* renamed from: f */
    public boolean m4723f() {
        return (this.f2770a & 4) == 4;
    }

    /* renamed from: g */
    public C0935fh m4724g() {
        return this.f2773d;
    }

    /* renamed from: a */
    public C0896dw m4715a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2773d = c0935fh;
        this.f2770a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0896dw m4719b(C0935fh c0935fh) {
        if ((this.f2770a & 4) == 4 && this.f2773d != C0935fh.m5211a()) {
            this.f2773d = C0935fh.m5212a(this.f2773d).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2773d = c0935fh;
        }
        this.f2770a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0896dw m4718b(long j) {
        this.f2770a |= 8;
        this.f2774e = j;
        return this;
    }
}
