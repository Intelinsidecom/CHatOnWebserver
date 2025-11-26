package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.m */
/* loaded from: classes.dex */
public final class C0084m extends GeneratedMessageLite.Builder implements InterfaceC0085n {

    /* renamed from: a */
    private int f148a;

    /* renamed from: b */
    private int f149b;

    /* renamed from: c */
    private Object f150c = "";

    private C0084m() {
        m413g();
    }

    /* renamed from: g */
    private void m413g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0084m m414h() {
        return new C0084m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0084m clear() {
        super.clear();
        this.f149b = 0;
        this.f148a &= -2;
        this.f150c = "";
        this.f148a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0084m mo7542clone() {
        return m414h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0083l getDefaultInstanceForType() {
        return C0083l.m397a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0083l build() {
        C0083l c0083lBuildPartial = buildPartial();
        if (!c0083lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0083lBuildPartial);
        }
        return c0083lBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0083l m415i() throws InvalidProtocolBufferException {
        C0083l c0083lBuildPartial = buildPartial();
        if (!c0083lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0083lBuildPartial).asInvalidProtocolBufferException();
        }
        return c0083lBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0083l buildPartial() {
        C0083l c0083l = new C0083l(this);
        int i = this.f148a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0083l.f144c = this.f149b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0083l.f145d = this.f150c;
        c0083l.f143b = i2;
        return c0083l;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0084m mergeFrom(C0083l c0083l) {
        if (c0083l != C0083l.m397a()) {
            if (c0083l.m405c()) {
                m417a(c0083l.m406d());
            }
            if (c0083l.m407e()) {
                m420a(c0083l.m408f());
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
    public C0084m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f148a |= 1;
                    this.f149b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f148a |= 2;
                    this.f150c = codedInputStream.readBytes();
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
    public C0084m m417a(int i) {
        this.f148a |= 1;
        this.f149b = i;
        return this;
    }

    /* renamed from: a */
    public C0084m m420a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f148a |= 2;
        this.f150c = str;
        return this;
    }
}
