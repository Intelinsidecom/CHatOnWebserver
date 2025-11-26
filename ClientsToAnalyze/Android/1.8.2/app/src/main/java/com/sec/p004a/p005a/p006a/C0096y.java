package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.y */
/* loaded from: classes.dex */
public final class C0096y extends GeneratedMessageLite.Builder implements InterfaceC0097z {

    /* renamed from: a */
    private int f198a;

    /* renamed from: b */
    private int f199b;

    /* renamed from: c */
    private long f200c;

    /* renamed from: d */
    private int f201d;

    private C0096y() {
        m565g();
    }

    /* renamed from: g */
    private void m565g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0096y m566h() {
        return new C0096y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0096y clear() {
        super.clear();
        this.f199b = 0;
        this.f198a &= -2;
        this.f200c = 0L;
        this.f198a &= -3;
        this.f201d = 0;
        this.f198a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0096y mo7542clone() {
        return m566h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0095x getDefaultInstanceForType() {
        return C0095x.m548a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0095x build() {
        C0095x c0095xBuildPartial = buildPartial();
        if (!c0095xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0095xBuildPartial);
        }
        return c0095xBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0095x m567i() throws InvalidProtocolBufferException {
        C0095x c0095xBuildPartial = buildPartial();
        if (!c0095xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0095xBuildPartial).asInvalidProtocolBufferException();
        }
        return c0095xBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0095x buildPartial() {
        C0095x c0095x = new C0095x(this);
        int i = this.f198a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0095x.f193c = this.f199b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0095x.f194d = this.f200c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0095x.f195e = this.f201d;
        c0095x.f192b = i2;
        return c0095x;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0096y mergeFrom(C0095x c0095x) {
        if (c0095x != C0095x.m548a()) {
            if (c0095x.m555c()) {
                m569a(c0095x.m556d());
            }
            if (c0095x.m557e()) {
                m570a(c0095x.m558f());
            }
            if (c0095x.m559g()) {
                m574b(c0095x.m560h());
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
    public C0096y mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f198a |= 1;
                    this.f199b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    this.f198a |= 2;
                    this.f200c = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    this.f198a |= 4;
                    this.f201d = codedInputStream.readInt32();
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
    public C0096y m569a(int i) {
        this.f198a |= 1;
        this.f199b = i;
        return this;
    }

    /* renamed from: a */
    public C0096y m570a(long j) {
        this.f198a |= 2;
        this.f200c = j;
        return this;
    }

    /* renamed from: b */
    public C0096y m574b(int i) {
        this.f198a |= 4;
        this.f201d = i;
        return this;
    }
}
