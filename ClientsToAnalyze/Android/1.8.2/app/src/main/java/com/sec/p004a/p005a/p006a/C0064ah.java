package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ah */
/* loaded from: classes.dex */
public final class C0064ah extends GeneratedMessageLite.Builder implements InterfaceC0065ai {

    /* renamed from: a */
    private int f71a;

    /* renamed from: b */
    private Object f72b = "";

    /* renamed from: c */
    private Object f73c = "";

    /* renamed from: d */
    private Object f74d = "";

    /* renamed from: e */
    private Object f75e = "";

    /* renamed from: f */
    private Object f76f = "";

    private C0064ah() {
        m185g();
    }

    /* renamed from: g */
    private void m185g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0064ah m186h() {
        return new C0064ah();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0064ah clear() {
        super.clear();
        this.f72b = "";
        this.f71a &= -2;
        this.f73c = "";
        this.f71a &= -3;
        this.f74d = "";
        this.f71a &= -5;
        this.f75e = "";
        this.f71a &= -9;
        this.f76f = "";
        this.f71a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0064ah mo7542clone() {
        return m186h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0063ag getDefaultInstanceForType() {
        return C0063ag.m156a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0063ag build() {
        C0063ag c0063agBuildPartial = buildPartial();
        if (!c0063agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0063agBuildPartial);
        }
        return c0063agBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0063ag m187i() throws InvalidProtocolBufferException {
        C0063ag c0063agBuildPartial = buildPartial();
        if (!c0063agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0063agBuildPartial).asInvalidProtocolBufferException();
        }
        return c0063agBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0063ag buildPartial() {
        C0063ag c0063ag = new C0063ag(this);
        int i = this.f71a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0063ag.f64c = this.f72b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0063ag.f65d = this.f73c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0063ag.f66e = this.f74d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0063ag.f67f = this.f75e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0063ag.f68g = this.f76f;
        c0063ag.f63b = i2;
        return c0063ag;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0064ah mergeFrom(C0063ag c0063ag) {
        if (c0063ag != C0063ag.m156a()) {
            if (c0063ag.m171c()) {
                m191a(c0063ag.m172d());
            }
            if (c0063ag.m173e()) {
                m193b(c0063ag.m174f());
            }
            if (c0063ag.m175g()) {
                m195c(c0063ag.m176h());
            }
            if (c0063ag.m177i()) {
                m197d(c0063ag.m178j());
            }
            if (c0063ag.m179k()) {
                m199e(c0063ag.m180l());
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
    public C0064ah mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f71a |= 1;
                    this.f72b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f71a |= 2;
                    this.f73c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f71a |= 4;
                    this.f74d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    this.f71a |= 8;
                    this.f75e = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f71a |= 16;
                    this.f76f = codedInputStream.readBytes();
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
    public C0064ah m191a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f71a |= 1;
        this.f72b = str;
        return this;
    }

    /* renamed from: b */
    public C0064ah m193b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f71a |= 2;
        this.f73c = str;
        return this;
    }

    /* renamed from: c */
    public C0064ah m195c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f71a |= 4;
        this.f74d = str;
        return this;
    }

    /* renamed from: d */
    public C0064ah m197d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f71a |= 8;
        this.f75e = str;
        return this;
    }

    /* renamed from: e */
    public C0064ah m199e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f71a |= 16;
        this.f76f = str;
        return this;
    }
}
