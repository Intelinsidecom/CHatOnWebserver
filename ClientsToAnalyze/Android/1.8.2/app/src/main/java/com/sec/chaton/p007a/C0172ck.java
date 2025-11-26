package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ck */
/* loaded from: classes.dex */
public final class C0172ck extends GeneratedMessageLite.Builder implements InterfaceC0173cl {

    /* renamed from: a */
    private int f627a;

    /* renamed from: b */
    private int f628b;

    /* renamed from: c */
    private Object f629c = "";

    private C0172ck() {
        m1473g();
    }

    /* renamed from: g */
    private void m1473g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0172ck m1474h() {
        return new C0172ck();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0172ck clear() {
        super.clear();
        this.f628b = 0;
        this.f627a &= -2;
        this.f629c = "";
        this.f627a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0172ck mo7542clone() {
        return m1474h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0171cj getDefaultInstanceForType() {
        return C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0171cj build() {
        C0171cj c0171cjBuildPartial = buildPartial();
        if (!c0171cjBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0171cjBuildPartial);
        }
        return c0171cjBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0171cj buildPartial() {
        C0171cj c0171cj = new C0171cj(this);
        int i = this.f627a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0171cj.f623c = this.f628b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0171cj.f624d = this.f629c;
        c0171cj.f622b = i2;
        return c0171cj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0172ck mergeFrom(C0171cj c0171cj) {
        if (c0171cj != C0171cj.m1459a()) {
            if (c0171cj.m1466c()) {
                m1476a(c0171cj.m1467d());
            }
            if (c0171cj.m1468e()) {
                m1479a(c0171cj.m1469f());
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
    public C0172ck mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f627a |= 1;
                    this.f628b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f627a |= 2;
                    this.f629c = codedInputStream.readBytes();
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
    public C0172ck m1476a(int i) {
        this.f627a |= 1;
        this.f628b = i;
        return this;
    }

    /* renamed from: a */
    public C0172ck m1479a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f627a |= 2;
        this.f629c = str;
        return this;
    }
}
