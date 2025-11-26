package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.az */
/* loaded from: classes.dex */
public final class C0133az extends GeneratedMessageLite.Builder implements InterfaceC0135ba {

    /* renamed from: a */
    private int f459a;

    /* renamed from: b */
    private long f460b;

    /* renamed from: c */
    private EnumC0136bb f461c = EnumC0136bb.TIMEOUT;

    /* renamed from: d */
    private Object f462d = "";

    private C0133az() {
        m996g();
    }

    /* renamed from: g */
    private void m996g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0133az m997h() {
        return new C0133az();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0133az clear() {
        super.clear();
        this.f460b = 0L;
        this.f459a &= -2;
        this.f461c = EnumC0136bb.TIMEOUT;
        this.f459a &= -3;
        this.f462d = "";
        this.f459a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0133az mo7542clone() {
        return m997h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0132ay getDefaultInstanceForType() {
        return C0132ay.m978a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0132ay build() {
        C0132ay c0132ayBuildPartial = buildPartial();
        if (!c0132ayBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0132ayBuildPartial);
        }
        return c0132ayBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0132ay m998i() throws InvalidProtocolBufferException {
        C0132ay c0132ayBuildPartial = buildPartial();
        if (!c0132ayBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0132ayBuildPartial).asInvalidProtocolBufferException();
        }
        return c0132ayBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0132ay buildPartial() {
        C0132ay c0132ay = new C0132ay(this);
        int i = this.f459a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0132ay.f454c = this.f460b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0132ay.f455d = this.f461c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0132ay.f456e = this.f462d;
        c0132ay.f453b = i2;
        return c0132ay;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0133az mergeFrom(C0132ay c0132ay) {
        if (c0132ay != C0132ay.m978a()) {
            if (c0132ay.m986c()) {
                m1000a(c0132ay.m987d());
            }
            if (c0132ay.m988e()) {
                m1003a(c0132ay.m989f());
            }
            if (c0132ay.m990g()) {
                m1004a(c0132ay.m991h());
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
    public C0133az mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f459a |= 1;
                    this.f460b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    EnumC0136bb enumC0136bbM1009a = EnumC0136bb.m1009a(codedInputStream.readEnum());
                    if (enumC0136bbM1009a == null) {
                        break;
                    } else {
                        this.f459a |= 2;
                        this.f461c = enumC0136bbM1009a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f459a |= 4;
                    this.f462d = codedInputStream.readBytes();
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
    public C0133az m1000a(long j) {
        this.f459a |= 1;
        this.f460b = j;
        return this;
    }

    /* renamed from: a */
    public C0133az m1003a(EnumC0136bb enumC0136bb) {
        if (enumC0136bb == null) {
            throw new NullPointerException();
        }
        this.f459a |= 2;
        this.f461c = enumC0136bb;
        return this;
    }

    /* renamed from: a */
    public C0133az m1004a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f459a |= 4;
        this.f462d = str;
        return this;
    }
}
