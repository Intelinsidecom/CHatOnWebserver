package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ab */
/* loaded from: classes.dex */
public final class C0058ab extends GeneratedMessageLite.Builder implements InterfaceC0059ac {

    /* renamed from: a */
    private int f37a;

    /* renamed from: b */
    private int f38b;

    /* renamed from: c */
    private long f39c;

    /* renamed from: d */
    private int f40d;

    private C0058ab() {
        m86g();
    }

    /* renamed from: g */
    private void m86g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0058ab m87h() {
        return new C0058ab();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0058ab clear() {
        super.clear();
        this.f38b = 0;
        this.f37a &= -2;
        this.f39c = 0L;
        this.f37a &= -3;
        this.f40d = 0;
        this.f37a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0058ab mo7542clone() {
        return m87h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0057aa getDefaultInstanceForType() {
        return C0057aa.m69a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0057aa build() {
        C0057aa c0057aaBuildPartial = buildPartial();
        if (!c0057aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0057aaBuildPartial);
        }
        return c0057aaBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0057aa m88i() throws InvalidProtocolBufferException {
        C0057aa c0057aaBuildPartial = buildPartial();
        if (!c0057aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0057aaBuildPartial).asInvalidProtocolBufferException();
        }
        return c0057aaBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0057aa buildPartial() {
        C0057aa c0057aa = new C0057aa(this);
        int i = this.f37a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0057aa.f32c = this.f38b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0057aa.f33d = this.f39c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0057aa.f34e = this.f40d;
        c0057aa.f31b = i2;
        return c0057aa;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0058ab mergeFrom(C0057aa c0057aa) {
        if (c0057aa != C0057aa.m69a()) {
            if (c0057aa.m76c()) {
                m90a(c0057aa.m77d());
            }
            if (c0057aa.m78e()) {
                m91a(c0057aa.m79f());
            }
            if (c0057aa.m80g()) {
                m95b(c0057aa.m81h());
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
    public C0058ab mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f37a |= 1;
                    this.f38b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    this.f37a |= 2;
                    this.f39c = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    this.f37a |= 4;
                    this.f40d = codedInputStream.readInt32();
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
    public C0058ab m90a(int i) {
        this.f37a |= 1;
        this.f38b = i;
        return this;
    }

    /* renamed from: a */
    public C0058ab m91a(long j) {
        this.f37a |= 2;
        this.f39c = j;
        return this;
    }

    /* renamed from: b */
    public C0058ab m95b(int i) {
        this.f37a |= 4;
        this.f40d = i;
        return this;
    }
}
