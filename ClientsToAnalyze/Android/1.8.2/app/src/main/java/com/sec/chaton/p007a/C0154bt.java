package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bt */
/* loaded from: classes.dex */
public final class C0154bt extends GeneratedMessageLite.Builder implements InterfaceC0155bu {

    /* renamed from: a */
    private int f558a;

    /* renamed from: b */
    private long f559b;

    /* renamed from: c */
    private C0171cj f560c = C0171cj.m1459a();

    /* renamed from: d */
    private long f561d;

    private C0154bt() {
        m1277i();
    }

    /* renamed from: i */
    private void m1277i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0154bt m1278j() {
        return new C0154bt();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0154bt clear() {
        super.clear();
        this.f559b = 0L;
        this.f558a &= -2;
        this.f560c = C0171cj.m1459a();
        this.f558a &= -3;
        this.f561d = 0L;
        this.f558a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0154bt mo7542clone() {
        return m1278j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0153bs getDefaultInstanceForType() {
        return C0153bs.m1260a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0153bs build() {
        C0153bs c0153bsBuildPartial = buildPartial();
        if (!c0153bsBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0153bsBuildPartial);
        }
        return c0153bsBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0153bs m1279k() throws InvalidProtocolBufferException {
        C0153bs c0153bsBuildPartial = buildPartial();
        if (!c0153bsBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0153bsBuildPartial).asInvalidProtocolBufferException();
        }
        return c0153bsBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0153bs buildPartial() {
        C0153bs c0153bs = new C0153bs(this);
        int i = this.f558a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0153bs.f553c = this.f559b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0153bs.f554d = this.f560c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0153bs.f555e = this.f561d;
        c0153bs.f552b = i2;
        return c0153bs;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0154bt mergeFrom(C0153bs c0153bs) {
        if (c0153bs != C0153bs.m1260a()) {
            if (c0153bs.m1267c()) {
                m1281a(c0153bs.m1268d());
            }
            if (c0153bs.m1269e()) {
                m1287b(c0153bs.m1270f());
            }
            if (c0153bs.m1271g()) {
                m1286b(c0153bs.m1272h());
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
    public C0154bt mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f558a |= 1;
                    this.f559b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m1291f()) {
                        c0172ckNewBuilder.mergeFrom(m1292g());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m1284a(c0172ckNewBuilder.buildPartial());
                    break;
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    this.f558a |= 4;
                    this.f561d = codedInputStream.readInt64();
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
    public C0154bt m1281a(long j) {
        this.f558a |= 1;
        this.f559b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1291f() {
        return (this.f558a & 2) == 2;
    }

    /* renamed from: g */
    public C0171cj m1292g() {
        return this.f560c;
    }

    /* renamed from: a */
    public C0154bt m1284a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f560c = c0171cj;
        this.f558a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0154bt m1287b(C0171cj c0171cj) {
        if ((this.f558a & 2) == 2 && this.f560c != C0171cj.m1459a()) {
            this.f560c = C0171cj.m1460a(this.f560c).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f560c = c0171cj;
        }
        this.f558a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0154bt m1286b(long j) {
        this.f558a |= 4;
        this.f561d = j;
        return this;
    }
}
