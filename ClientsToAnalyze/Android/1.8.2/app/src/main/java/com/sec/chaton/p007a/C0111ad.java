package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ad */
/* loaded from: classes.dex */
public final class C0111ad extends GeneratedMessageLite.Builder implements InterfaceC0112ae {

    /* renamed from: a */
    private int f360a;

    /* renamed from: b */
    private long f361b;

    /* renamed from: e */
    private long f364e;

    /* renamed from: c */
    private Object f362c = "";

    /* renamed from: d */
    private C0174cm f363d = C0174cm.m1485a();

    /* renamed from: f */
    private C0171cj f365f = C0171cj.m1459a();

    private C0111ad() {
        m718k();
    }

    /* renamed from: k */
    private void m718k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0111ad m719l() {
        return new C0111ad();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0111ad clear() {
        super.clear();
        this.f361b = 0L;
        this.f360a &= -2;
        this.f362c = "";
        this.f360a &= -3;
        this.f363d = C0174cm.m1485a();
        this.f360a &= -5;
        this.f364e = 0L;
        this.f360a &= -9;
        this.f365f = C0171cj.m1459a();
        this.f360a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0111ad mo7542clone() {
        return m719l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0110ac getDefaultInstanceForType() {
        return C0110ac.m694a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0110ac build() {
        C0110ac c0110acBuildPartial = buildPartial();
        if (!c0110acBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0110acBuildPartial);
        }
        return c0110acBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0110ac m720m() throws InvalidProtocolBufferException {
        C0110ac c0110acBuildPartial = buildPartial();
        if (!c0110acBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0110acBuildPartial).asInvalidProtocolBufferException();
        }
        return c0110acBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0110ac buildPartial() {
        C0110ac c0110ac = new C0110ac(this);
        int i = this.f360a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0110ac.f353c = this.f361b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0110ac.f354d = this.f362c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0110ac.f355e = this.f363d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0110ac.f356f = this.f364e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0110ac.f357g = this.f365f;
        c0110ac.f352b = i2;
        return c0110ac;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0111ad mergeFrom(C0110ac c0110ac) {
        if (c0110ac != C0110ac.m694a()) {
            if (c0110ac.m704c()) {
                m722a(c0110ac.m705d());
            }
            if (c0110ac.m706e()) {
                m727a(c0110ac.m707f());
            }
            if (c0110ac.m708g()) {
                m731b(c0110ac.m709h());
            }
            if (c0110ac.m710i()) {
                m729b(c0110ac.m711j());
            }
            if (c0110ac.m712k()) {
                m730b(c0110ac.m713l());
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
    public C0111ad mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f360a |= 1;
                    this.f361b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f360a |= 2;
                    this.f362c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    C0175cn c0175cnNewBuilder = C0174cm.newBuilder();
                    if (m735f()) {
                        c0175cnNewBuilder.mergeFrom(m736g());
                    }
                    codedInputStream.readMessage(c0175cnNewBuilder, extensionRegistryLite);
                    m726a(c0175cnNewBuilder.buildPartial());
                    break;
                case C0229at.HorizontalSrollView_android_drawingCacheQuality /* 32 */:
                    this.f360a |= 8;
                    this.f364e = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m737h()) {
                        c0172ckNewBuilder.mergeFrom(m738i());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m725a(c0172ckNewBuilder.buildPartial());
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
    public C0111ad m722a(long j) {
        this.f360a |= 1;
        this.f361b = j;
        return this;
    }

    /* renamed from: a */
    public C0111ad m727a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f360a |= 2;
        this.f362c = str;
        return this;
    }

    /* renamed from: f */
    public boolean m735f() {
        return (this.f360a & 4) == 4;
    }

    /* renamed from: g */
    public C0174cm m736g() {
        return this.f363d;
    }

    /* renamed from: a */
    public C0111ad m726a(C0174cm c0174cm) {
        if (c0174cm == null) {
            throw new NullPointerException();
        }
        this.f363d = c0174cm;
        this.f360a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0111ad m731b(C0174cm c0174cm) {
        if ((this.f360a & 4) == 4 && this.f363d != C0174cm.m1485a()) {
            this.f363d = C0174cm.m1486a(this.f363d).mergeFrom(c0174cm).buildPartial();
        } else {
            this.f363d = c0174cm;
        }
        this.f360a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0111ad m729b(long j) {
        this.f360a |= 8;
        this.f364e = j;
        return this;
    }

    /* renamed from: h */
    public boolean m737h() {
        return (this.f360a & 16) == 16;
    }

    /* renamed from: i */
    public C0171cj m738i() {
        return this.f365f;
    }

    /* renamed from: a */
    public C0111ad m725a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f365f = c0171cj;
        this.f360a |= 16;
        return this;
    }

    /* renamed from: b */
    public C0111ad m730b(C0171cj c0171cj) {
        if ((this.f360a & 16) == 16 && this.f365f != C0171cj.m1459a()) {
            this.f365f = C0171cj.m1460a(this.f365f).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f365f = c0171cj;
        }
        this.f360a |= 16;
        return this;
    }
}
