package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.be */
/* loaded from: classes.dex */
public final class C0139be extends GeneratedMessageLite.Builder implements InterfaceC0140bf {

    /* renamed from: a */
    private int f474a;

    /* renamed from: b */
    private long f475b;

    /* renamed from: c */
    private C0171cj f476c = C0171cj.m1459a();

    private C0139be() {
        m1027i();
    }

    /* renamed from: i */
    private void m1027i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0139be m1028j() {
        return new C0139be();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0139be clear() {
        super.clear();
        this.f475b = 0L;
        this.f474a &= -2;
        this.f476c = C0171cj.m1459a();
        this.f474a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0139be mo7542clone() {
        return m1028j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0138bd getDefaultInstanceForType() {
        return C0138bd.m1013a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0138bd build() {
        C0138bd c0138bdBuildPartial = buildPartial();
        if (!c0138bdBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0138bdBuildPartial);
        }
        return c0138bdBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0138bd m1029k() throws InvalidProtocolBufferException {
        C0138bd c0138bdBuildPartial = buildPartial();
        if (!c0138bdBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0138bdBuildPartial).asInvalidProtocolBufferException();
        }
        return c0138bdBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0138bd buildPartial() {
        C0138bd c0138bd = new C0138bd(this);
        int i = this.f474a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0138bd.f470c = this.f475b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0138bd.f471d = this.f476c;
        c0138bd.f469b = i2;
        return c0138bd;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0139be mergeFrom(C0138bd c0138bd) {
        if (c0138bd != C0138bd.m1013a()) {
            if (c0138bd.m1019c()) {
                m1031a(c0138bd.m1020d());
            }
            if (c0138bd.m1021e()) {
                m1036b(c0138bd.m1022f());
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
    public C0139be mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f474a |= 1;
                    this.f475b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m1040f()) {
                        c0172ckNewBuilder.mergeFrom(m1041g());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m1034a(c0172ckNewBuilder.buildPartial());
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
    public C0139be m1031a(long j) {
        this.f474a |= 1;
        this.f475b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1040f() {
        return (this.f474a & 2) == 2;
    }

    /* renamed from: g */
    public C0171cj m1041g() {
        return this.f476c;
    }

    /* renamed from: a */
    public C0139be m1034a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f476c = c0171cj;
        this.f474a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0139be m1036b(C0171cj c0171cj) {
        if ((this.f474a & 2) == 2 && this.f476c != C0171cj.m1459a()) {
            this.f476c = C0171cj.m1460a(this.f476c).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f476c = c0171cj;
        }
        this.f474a |= 2;
        return this;
    }
}
