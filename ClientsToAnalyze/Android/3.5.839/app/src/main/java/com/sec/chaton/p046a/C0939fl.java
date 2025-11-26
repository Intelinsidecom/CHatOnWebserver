package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fl */
/* loaded from: classes.dex */
public final class C0939fl extends GeneratedMessageLite.Builder<C0938fk, C0939fl> implements InterfaceC0940fm {

    /* renamed from: a */
    private int f2979a;

    /* renamed from: b */
    private long f2980b;

    /* renamed from: c */
    private C0935fh f2981c = C0935fh.m5211a();

    private C0939fl() {
        m5284i();
    }

    /* renamed from: i */
    private void m5284i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0939fl m5285j() {
        return new C0939fl();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0939fl clear() {
        super.clear();
        this.f2980b = 0L;
        this.f2979a &= -2;
        this.f2981c = C0935fh.m5211a();
        this.f2979a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0939fl mo19949clone() {
        return m5285j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0938fk getDefaultInstanceForType() {
        return C0938fk.m5271a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0938fk build() {
        C0938fk c0938fkBuildPartial = buildPartial();
        if (!c0938fkBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0938fkBuildPartial);
        }
        return c0938fkBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0938fk m5286k() throws InvalidProtocolBufferException {
        C0938fk c0938fkBuildPartial = buildPartial();
        if (!c0938fkBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0938fkBuildPartial).asInvalidProtocolBufferException();
        }
        return c0938fkBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0938fk buildPartial() {
        C0938fk c0938fk = new C0938fk(this);
        int i = this.f2979a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0938fk.f2975c = this.f2980b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0938fk.f2976d = this.f2981c;
        c0938fk.f2974b = i2;
        return c0938fk;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0939fl mergeFrom(C0938fk c0938fk) {
        if (c0938fk != C0938fk.m5271a()) {
            if (c0938fk.m5276c()) {
                m5288a(c0938fk.m5277d());
            }
            if (c0938fk.m5278e()) {
                m5293b(c0938fk.m5279f());
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
    public C0939fl mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2979a |= 1;
                    this.f2980b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m5297f()) {
                        c0936fiNewBuilder.mergeFrom(m5298g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m5290a(c0936fiNewBuilder.buildPartial());
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
    public C0939fl m5288a(long j) {
        this.f2979a |= 1;
        this.f2980b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m5297f() {
        return (this.f2979a & 2) == 2;
    }

    /* renamed from: g */
    public C0935fh m5298g() {
        return this.f2981c;
    }

    /* renamed from: a */
    public C0939fl m5290a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2981c = c0935fh;
        this.f2979a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0939fl m5293b(C0935fh c0935fh) {
        if ((this.f2979a & 2) == 2 && this.f2981c != C0935fh.m5211a()) {
            this.f2981c = C0935fh.m5212a(this.f2981c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2981c = c0935fh;
        }
        this.f2979a |= 2;
        return this;
    }
}
