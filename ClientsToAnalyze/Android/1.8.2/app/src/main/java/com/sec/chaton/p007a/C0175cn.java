package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cn */
/* loaded from: classes.dex */
public final class C0175cn extends GeneratedMessageLite.Builder implements InterfaceC0176co {

    /* renamed from: a */
    private int f636a;

    /* renamed from: b */
    private Object f637b = "";

    /* renamed from: c */
    private int f638c;

    private C0175cn() {
        m1499g();
    }

    /* renamed from: g */
    private void m1499g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0175cn m1500h() {
        return new C0175cn();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0175cn clear() {
        super.clear();
        this.f637b = "";
        this.f636a &= -2;
        this.f638c = 0;
        this.f636a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0175cn mo7542clone() {
        return m1500h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0174cm getDefaultInstanceForType() {
        return C0174cm.m1485a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0174cm build() {
        C0174cm c0174cmBuildPartial = buildPartial();
        if (!c0174cmBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0174cmBuildPartial);
        }
        return c0174cmBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0174cm buildPartial() {
        C0174cm c0174cm = new C0174cm(this);
        int i = this.f636a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0174cm.f632c = this.f637b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0174cm.f633d = this.f638c;
        c0174cm.f631b = i2;
        return c0174cm;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0175cn mergeFrom(C0174cm c0174cm) {
        if (c0174cm != C0174cm.m1485a()) {
            if (c0174cm.m1492c()) {
                m1505a(c0174cm.m1493d());
            }
            if (c0174cm.m1494e()) {
                m1502a(c0174cm.m1495f());
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
    public C0175cn mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f636a |= 1;
                    this.f637b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    this.f636a |= 2;
                    this.f638c = codedInputStream.readInt32();
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
    public C0175cn m1505a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f636a |= 1;
        this.f637b = str;
        return this;
    }

    /* renamed from: a */
    public C0175cn m1502a(int i) {
        this.f636a |= 2;
        this.f638c = i;
        return this;
    }
}
