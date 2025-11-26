package com.sec.p004a.p005a.p006a;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.s */
/* loaded from: classes.dex */
public final class C0090s extends GeneratedMessageLite.Builder implements InterfaceC0091t {

    /* renamed from: a */
    private int f174a;

    /* renamed from: d */
    private int f177d;

    /* renamed from: e */
    private int f178e;

    /* renamed from: i */
    private long f182i;

    /* renamed from: j */
    private int f183j;

    /* renamed from: b */
    private Object f175b = "";

    /* renamed from: c */
    private Object f176c = "";

    /* renamed from: f */
    private Object f179f = "";

    /* renamed from: g */
    private Object f180g = "";

    /* renamed from: h */
    private Object f181h = "";

    /* renamed from: k */
    private Object f184k = "";

    private C0090s() {
        m501g();
    }

    /* renamed from: g */
    private void m501g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0090s m502h() {
        return new C0090s();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0090s clear() {
        super.clear();
        this.f175b = "";
        this.f174a &= -2;
        this.f176c = "";
        this.f174a &= -3;
        this.f177d = 0;
        this.f174a &= -5;
        this.f178e = 0;
        this.f174a &= -9;
        this.f179f = "";
        this.f174a &= -17;
        this.f180g = "";
        this.f174a &= -33;
        this.f181h = "";
        this.f174a &= -65;
        this.f182i = 0L;
        this.f174a &= -129;
        this.f183j = 0;
        this.f174a &= -257;
        this.f184k = "";
        this.f174a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0090s mo7542clone() {
        return m502h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0089r getDefaultInstanceForType() {
        return C0089r.m462a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0089r build() {
        C0089r c0089rBuildPartial = buildPartial();
        if (!c0089rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0089rBuildPartial);
        }
        return c0089rBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0089r m503i() throws InvalidProtocolBufferException {
        C0089r c0089rBuildPartial = buildPartial();
        if (!c0089rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0089rBuildPartial).asInvalidProtocolBufferException();
        }
        return c0089rBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0089r buildPartial() {
        C0089r c0089r = new C0089r(this);
        int i = this.f174a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0089r.f162c = this.f175b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0089r.f163d = this.f176c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0089r.f164e = this.f177d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0089r.f165f = this.f178e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0089r.f166g = this.f179f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0089r.f167h = this.f180g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0089r.f168i = this.f181h;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
            i2 |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
        }
        c0089r.f169j = this.f182i;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256) {
            i2 |= AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
        }
        c0089r.f170k = this.f183j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        c0089r.f171l = this.f184k;
        c0089r.f161b = i2;
        return c0089r;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0090s mergeFrom(C0089r c0089r) {
        if (c0089r != C0089r.m462a()) {
            if (c0089r.m477c()) {
                m509a(c0089r.m478d());
            }
            if (c0089r.m479e()) {
                m512b(c0089r.m480f());
            }
            if (c0089r.m481g()) {
                m505a(c0089r.m482h());
            }
            if (c0089r.m483i()) {
                m511b(c0089r.m484j());
            }
            if (c0089r.m485k()) {
                m515c(c0089r.m486l());
            }
            if (c0089r.m487m()) {
                m517d(c0089r.m488n());
            }
            if (c0089r.m489o()) {
                m519e(c0089r.m490p());
            }
            if (c0089r.m491q()) {
                m506a(c0089r.m492r());
            }
            if (c0089r.m493s()) {
                m514c(c0089r.m494t());
            }
            if (c0089r.m495u()) {
                m520f(c0089r.m496v());
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
    public C0090s mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f174a |= 1;
                    this.f175b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f174a |= 2;
                    this.f176c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    this.f174a |= 4;
                    this.f177d = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_drawingCacheQuality /* 32 */:
                    this.f174a |= 8;
                    this.f178e = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    this.f174a |= 16;
                    this.f179f = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f174a |= 32;
                    this.f180g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f174a |= 64;
                    this.f181h = codedInputStream.readBytes();
                    break;
                case 88:
                    this.f174a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
                    this.f182i = codedInputStream.readInt64();
                    break;
                case 96:
                    this.f174a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
                    this.f183j = codedInputStream.readInt32();
                    break;
                case 106:
                    this.f174a |= 512;
                    this.f184k = codedInputStream.readBytes();
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
    public C0090s m509a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f174a |= 1;
        this.f175b = str;
        return this;
    }

    /* renamed from: b */
    public C0090s m512b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f174a |= 2;
        this.f176c = str;
        return this;
    }

    /* renamed from: a */
    public C0090s m505a(int i) {
        this.f174a |= 4;
        this.f177d = i;
        return this;
    }

    /* renamed from: b */
    public C0090s m511b(int i) {
        this.f174a |= 8;
        this.f178e = i;
        return this;
    }

    /* renamed from: c */
    public C0090s m515c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f174a |= 16;
        this.f179f = str;
        return this;
    }

    /* renamed from: d */
    public C0090s m517d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f174a |= 32;
        this.f180g = str;
        return this;
    }

    /* renamed from: e */
    public C0090s m519e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f174a |= 64;
        this.f181h = str;
        return this;
    }

    /* renamed from: a */
    public C0090s m506a(long j) {
        this.f174a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
        this.f182i = j;
        return this;
    }

    /* renamed from: c */
    public C0090s m514c(int i) {
        this.f174a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
        this.f183j = i;
        return this;
    }

    /* renamed from: f */
    public C0090s m520f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f174a |= 512;
        this.f184k = str;
        return this;
    }
}
