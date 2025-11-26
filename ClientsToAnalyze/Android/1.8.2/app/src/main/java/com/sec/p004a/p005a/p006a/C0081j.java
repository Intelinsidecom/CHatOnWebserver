package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.j */
/* loaded from: classes.dex */
public final class C0081j extends GeneratedMessageLite.Builder implements InterfaceC0082k {

    /* renamed from: a */
    private int f138a;

    /* renamed from: b */
    private int f139b;

    /* renamed from: c */
    private int f140c;

    /* renamed from: d */
    private Object f141d = "";

    private C0081j() {
        m383g();
    }

    /* renamed from: g */
    private void m383g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0081j m384h() {
        return new C0081j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0081j clear() {
        super.clear();
        this.f139b = 0;
        this.f138a &= -2;
        this.f140c = 0;
        this.f138a &= -3;
        this.f141d = "";
        this.f138a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0081j mo7542clone() {
        return m384h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0080i getDefaultInstanceForType() {
        return C0080i.m364a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0080i build() {
        C0080i c0080iBuildPartial = buildPartial();
        if (!c0080iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0080iBuildPartial);
        }
        return c0080iBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0080i m385i() throws InvalidProtocolBufferException {
        C0080i c0080iBuildPartial = buildPartial();
        if (!c0080iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0080iBuildPartial).asInvalidProtocolBufferException();
        }
        return c0080iBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0080i buildPartial() {
        C0080i c0080i = new C0080i(this);
        int i = this.f138a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0080i.f133c = this.f139b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0080i.f134d = this.f140c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0080i.f135e = this.f141d;
        c0080i.f132b = i2;
        return c0080i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0081j mergeFrom(C0080i c0080i) {
        if (c0080i != C0080i.m364a()) {
            if (c0080i.m373c()) {
                m387a(c0080i.m374d());
            }
            if (c0080i.m375e()) {
                m392b(c0080i.m376f());
            }
            if (c0080i.m377g()) {
                m390a(c0080i.m378h());
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
    public C0081j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f138a |= 1;
                    this.f139b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    this.f138a |= 2;
                    this.f140c = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f138a |= 4;
                    this.f141d = codedInputStream.readBytes();
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
    public C0081j m387a(int i) {
        this.f138a |= 1;
        this.f139b = i;
        return this;
    }

    /* renamed from: b */
    public C0081j m392b(int i) {
        this.f138a |= 2;
        this.f140c = i;
        return this;
    }

    /* renamed from: a */
    public C0081j m390a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f138a |= 4;
        this.f141d = str;
        return this;
    }
}
