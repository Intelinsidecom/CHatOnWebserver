package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.d */
/* loaded from: classes.dex */
public final class C0075d extends GeneratedMessageLite.Builder implements InterfaceC0076e {

    /* renamed from: a */
    private int f113a;

    /* renamed from: b */
    private int f114b;

    /* renamed from: c */
    private int f115c;

    /* renamed from: d */
    private Object f116d = "";

    /* renamed from: e */
    private Object f117e = "";

    private C0075d() {
        m310g();
    }

    /* renamed from: g */
    private void m310g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0075d m311h() {
        return new C0075d();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0075d clear() {
        super.clear();
        this.f114b = 0;
        this.f113a &= -2;
        this.f115c = 0;
        this.f113a &= -3;
        this.f116d = "";
        this.f113a &= -5;
        this.f117e = "";
        this.f113a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0075d mo7542clone() {
        return m311h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0074c getDefaultInstanceForType() {
        return C0074c.m287a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0074c build() {
        C0074c c0074cBuildPartial = buildPartial();
        if (!c0074cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0074cBuildPartial);
        }
        return c0074cBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0074c m312i() throws InvalidProtocolBufferException {
        C0074c c0074cBuildPartial = buildPartial();
        if (!c0074cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0074cBuildPartial).asInvalidProtocolBufferException();
        }
        return c0074cBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0074c buildPartial() {
        C0074c c0074c = new C0074c(this);
        int i = this.f113a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0074c.f107c = this.f114b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0074c.f108d = this.f115c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0074c.f109e = this.f116d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0074c.f110f = this.f117e;
        c0074c.f106b = i2;
        return c0074c;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0075d mergeFrom(C0074c c0074c) {
        if (c0074c != C0074c.m287a()) {
            if (c0074c.m298c()) {
                m314a(c0074c.m299d());
            }
            if (c0074c.m300e()) {
                m319b(c0074c.m301f());
            }
            if (c0074c.m302g()) {
                m317a(c0074c.m303h());
            }
            if (c0074c.m304i()) {
                m320b(c0074c.m305j());
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
    public C0075d mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f113a |= 1;
                    this.f114b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    this.f113a |= 2;
                    this.f115c = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f113a |= 4;
                    this.f116d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f113a |= 8;
                    this.f117e = codedInputStream.readBytes();
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
    public C0075d m314a(int i) {
        this.f113a |= 1;
        this.f114b = i;
        return this;
    }

    /* renamed from: b */
    public C0075d m319b(int i) {
        this.f113a |= 2;
        this.f115c = i;
        return this;
    }

    /* renamed from: a */
    public C0075d m317a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f113a |= 4;
        this.f116d = str;
        return this;
    }

    /* renamed from: b */
    public C0075d m320b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f113a |= 8;
        this.f117e = str;
        return this;
    }
}
