package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.g */
/* loaded from: classes.dex */
public final class C0078g extends GeneratedMessageLite.Builder implements InterfaceC0079h {

    /* renamed from: a */
    private int f126a;

    /* renamed from: b */
    private int f127b;

    /* renamed from: c */
    private Object f128c = "";

    /* renamed from: d */
    private Object f129d = "";

    /* renamed from: e */
    private Object f130e = "";

    private C0078g() {
        m349g();
    }

    /* renamed from: g */
    private void m349g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0078g m350h() {
        return new C0078g();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0078g clear() {
        super.clear();
        this.f127b = 0;
        this.f126a &= -2;
        this.f128c = "";
        this.f126a &= -3;
        this.f129d = "";
        this.f126a &= -5;
        this.f130e = "";
        this.f126a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0078g mo7542clone() {
        return m350h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0077f getDefaultInstanceForType() {
        return C0077f.m325a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0077f build() {
        C0077f c0077fBuildPartial = buildPartial();
        if (!c0077fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0077fBuildPartial);
        }
        return c0077fBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0077f m351i() throws InvalidProtocolBufferException {
        C0077f c0077fBuildPartial = buildPartial();
        if (!c0077fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0077fBuildPartial).asInvalidProtocolBufferException();
        }
        return c0077fBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0077f buildPartial() {
        C0077f c0077f = new C0077f(this);
        int i = this.f126a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0077f.f120c = this.f127b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0077f.f121d = this.f128c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0077f.f122e = this.f129d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0077f.f123f = this.f130e;
        c0077f.f119b = i2;
        return c0077f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0078g mergeFrom(C0077f c0077f) {
        if (c0077f != C0077f.m325a()) {
            if (c0077f.m337c()) {
                m353a(c0077f.m338d());
            }
            if (c0077f.m339e()) {
                m356a(c0077f.m340f());
            }
            if (c0077f.m341g()) {
                m358b(c0077f.m342h());
            }
            if (c0077f.m343i()) {
                m360c(c0077f.m344j());
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
    public C0078g mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f126a |= 1;
                    this.f127b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f126a |= 2;
                    this.f128c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f126a |= 4;
                    this.f129d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f126a |= 8;
                    this.f130e = codedInputStream.readBytes();
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
    public C0078g m353a(int i) {
        this.f126a |= 1;
        this.f127b = i;
        return this;
    }

    /* renamed from: a */
    public C0078g m356a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f126a |= 2;
        this.f128c = str;
        return this;
    }

    /* renamed from: b */
    public C0078g m358b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f126a |= 4;
        this.f129d = str;
        return this;
    }

    /* renamed from: c */
    public C0078g m360c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f126a |= 8;
        this.f130e = str;
        return this;
    }
}
