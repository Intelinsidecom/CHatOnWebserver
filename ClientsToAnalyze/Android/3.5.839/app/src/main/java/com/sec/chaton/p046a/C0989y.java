package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.y */
/* loaded from: classes.dex */
public final class C0989y extends GeneratedMessageLite.Builder<C0988x, C0989y> implements InterfaceC0990z {

    /* renamed from: a */
    private int f3241a;

    /* renamed from: b */
    private Object f3242b = "";

    /* renamed from: c */
    private long f3243c;

    /* renamed from: d */
    private long f3244d;

    private C0989y() {
        m6025g();
    }

    /* renamed from: g */
    private void m6025g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0989y m6026h() {
        return new C0989y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0989y clear() {
        super.clear();
        this.f3242b = "";
        this.f3241a &= -2;
        this.f3243c = 0L;
        this.f3241a &= -3;
        this.f3244d = 0L;
        this.f3241a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0989y mo19949clone() {
        return m6026h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0988x getDefaultInstanceForType() {
        return C0988x.m6009a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0988x build() {
        C0988x c0988xBuildPartial = buildPartial();
        if (!c0988xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0988xBuildPartial);
        }
        return c0988xBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0988x buildPartial() {
        C0988x c0988x = new C0988x(this);
        int i = this.f3241a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0988x.f3236c = this.f3242b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0988x.f3237d = this.f3243c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0988x.f3238e = this.f3244d;
        c0988x.f3235b = i2;
        return c0988x;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0989y mergeFrom(C0988x c0988x) {
        if (c0988x != C0988x.m6009a()) {
            if (c0988x.m6016c()) {
                m6031a(c0988x.m6017d());
            }
            if (c0988x.m6018e()) {
                m6028a(c0988x.m6019f());
            }
            if (c0988x.m6020g()) {
                m6033b(c0988x.m6021h());
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
    public C0989y mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f3241a |= 1;
                    this.f3242b = codedInputStream.readBytes();
                    break;
                case 16:
                    this.f3241a |= 2;
                    this.f3243c = codedInputStream.readInt64();
                    break;
                case 24:
                    this.f3241a |= 4;
                    this.f3244d = codedInputStream.readInt64();
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
    public C0989y m6031a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3241a |= 1;
        this.f3242b = str;
        return this;
    }

    /* renamed from: a */
    public C0989y m6028a(long j) {
        this.f3241a |= 2;
        this.f3243c = j;
        return this;
    }

    /* renamed from: b */
    public C0989y m6033b(long j) {
        this.f3241a |= 4;
        this.f3244d = j;
        return this;
    }
}
