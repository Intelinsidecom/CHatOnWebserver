package com.sec.p004a.p005a.p006a;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ae */
/* loaded from: classes.dex */
public final class C0061ae extends GeneratedMessageLite.Builder implements InterfaceC0062af {

    /* renamed from: a */
    private int f53a;

    /* renamed from: b */
    private int f54b;

    /* renamed from: e */
    private int f57e;

    /* renamed from: g */
    private int f59g;

    /* renamed from: h */
    private int f60h;

    /* renamed from: c */
    private Object f55c = "";

    /* renamed from: d */
    private Object f56d = "";

    /* renamed from: f */
    private Object f58f = "";

    /* renamed from: i */
    private Object f61i = "";

    private C0061ae() {
        m137g();
    }

    /* renamed from: g */
    private void m137g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0061ae m138h() {
        return new C0061ae();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0061ae clear() {
        super.clear();
        this.f54b = 0;
        this.f53a &= -2;
        this.f55c = "";
        this.f53a &= -3;
        this.f56d = "";
        this.f53a &= -5;
        this.f57e = 0;
        this.f53a &= -9;
        this.f58f = "";
        this.f53a &= -17;
        this.f59g = 0;
        this.f53a &= -33;
        this.f60h = 0;
        this.f53a &= -65;
        this.f61i = "";
        this.f53a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0061ae mo7542clone() {
        return m138h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0060ad getDefaultInstanceForType() {
        return C0060ad.m100a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0060ad build() {
        C0060ad c0060adBuildPartial = buildPartial();
        if (!c0060adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0060adBuildPartial);
        }
        return c0060adBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0060ad m139i() throws InvalidProtocolBufferException {
        C0060ad c0060adBuildPartial = buildPartial();
        if (!c0060adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0060adBuildPartial).asInvalidProtocolBufferException();
        }
        return c0060adBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0060ad buildPartial() {
        C0060ad c0060ad = new C0060ad(this);
        int i = this.f53a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0060ad.f43c = this.f54b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0060ad.f44d = this.f55c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0060ad.f45e = this.f56d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0060ad.f46f = this.f57e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0060ad.f47g = this.f58f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0060ad.f48h = this.f59g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0060ad.f49i = this.f60h;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
            i2 |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
        }
        c0060ad.f50j = this.f61i;
        c0060ad.f42b = i2;
        return c0060ad;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0061ae mergeFrom(C0060ad c0060ad) {
        if (c0060ad != C0060ad.m100a()) {
            if (c0060ad.m117c()) {
                m141a(c0060ad.m118d());
            }
            if (c0060ad.m119e()) {
                m144a(c0060ad.m120f());
            }
            if (c0060ad.m121g()) {
                m147b(c0060ad.m122h());
            }
            if (c0060ad.m123i()) {
                m146b(c0060ad.m124j());
            }
            if (c0060ad.m125k()) {
                m150c(c0060ad.m126l());
            }
            if (c0060ad.m127m()) {
                m149c(c0060ad.m128n());
            }
            if (c0060ad.m129o()) {
                m152d(c0060ad.m130p());
            }
            if (c0060ad.m131q()) {
                m153d(c0060ad.m132r());
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
    public C0061ae mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    this.f53a |= 1;
                    this.f54b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f53a |= 2;
                    this.f55c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f53a |= 4;
                    this.f56d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_onClick /* 40 */:
                    this.f53a |= 8;
                    this.f57e = codedInputStream.readInt32();
                    break;
                case 50:
                    this.f53a |= 16;
                    this.f58f = codedInputStream.readBytes();
                    break;
                case 56:
                    this.f53a |= 32;
                    this.f59g = codedInputStream.readInt32();
                    break;
                case 64:
                    this.f53a |= 64;
                    this.f60h = codedInputStream.readInt32();
                    break;
                case 74:
                    this.f53a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
                    this.f61i = codedInputStream.readBytes();
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
    public C0061ae m141a(int i) {
        this.f53a |= 1;
        this.f54b = i;
        return this;
    }

    /* renamed from: a */
    public C0061ae m144a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f53a |= 2;
        this.f55c = str;
        return this;
    }

    /* renamed from: b */
    public C0061ae m147b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f53a |= 4;
        this.f56d = str;
        return this;
    }

    /* renamed from: b */
    public C0061ae m146b(int i) {
        this.f53a |= 8;
        this.f57e = i;
        return this;
    }

    /* renamed from: c */
    public C0061ae m150c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f53a |= 16;
        this.f58f = str;
        return this;
    }

    /* renamed from: c */
    public C0061ae m149c(int i) {
        this.f53a |= 32;
        this.f59g = i;
        return this;
    }

    /* renamed from: d */
    public C0061ae m152d(int i) {
        this.f53a |= 64;
        this.f60h = i;
        return this;
    }

    /* renamed from: d */
    public C0061ae m153d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f53a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
        this.f61i = str;
        return this;
    }
}
