package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ad */
/* loaded from: classes.dex */
public final class C0264ad extends GeneratedMessageLite.Builder implements InterfaceC0343q {

    /* renamed from: a */
    private int f657a;

    /* renamed from: b */
    private long f658b;

    /* renamed from: c */
    private EnumC0286az f659c = EnumC0286az.TIMEOUT;

    /* renamed from: d */
    private Object f660d = "";

    private C0264ad() {
        m999g();
    }

    /* renamed from: g */
    private void m999g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0264ad m1000h() {
        return new C0264ad();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0264ad clear() {
        super.clear();
        this.f658b = 0L;
        this.f657a &= -2;
        this.f659c = EnumC0286az.TIMEOUT;
        this.f657a &= -3;
        this.f660d = "";
        this.f657a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0264ad mo5946clone() {
        return m1000h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0270aj getDefaultInstanceForType() {
        return C0270aj.m1142a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0270aj build() {
        C0270aj c0270ajBuildPartial = buildPartial();
        if (!c0270ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0270ajBuildPartial);
        }
        return c0270ajBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0270aj m1001i() throws InvalidProtocolBufferException {
        C0270aj c0270ajBuildPartial = buildPartial();
        if (!c0270ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0270ajBuildPartial).asInvalidProtocolBufferException();
        }
        return c0270ajBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0270aj buildPartial() {
        C0270aj c0270aj = new C0270aj(this);
        int i = this.f657a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0270aj.f702c = this.f658b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0270aj.f703d = this.f659c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0270aj.f704e = this.f660d;
        c0270aj.f701b = i2;
        return c0270aj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0264ad mergeFrom(C0270aj c0270aj) {
        if (c0270aj != C0270aj.m1142a()) {
            if (c0270aj.m1149c()) {
                m1003a(c0270aj.m1150d());
            }
            if (c0270aj.m1151e()) {
                m1006a(c0270aj.m1152f());
            }
            if (c0270aj.m1153g()) {
                m1007a(c0270aj.m1154h());
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
    public C0264ad mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f657a |= 1;
                    this.f658b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0286az enumC0286azM1296a = EnumC0286az.m1296a(codedInputStream.readEnum());
                    if (enumC0286azM1296a == null) {
                        break;
                    } else {
                        this.f657a |= 2;
                        this.f659c = enumC0286azM1296a;
                        break;
                    }
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f657a |= 4;
                    this.f660d = codedInputStream.readBytes();
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
    public C0264ad m1003a(long j) {
        this.f657a |= 1;
        this.f658b = j;
        return this;
    }

    /* renamed from: a */
    public C0264ad m1006a(EnumC0286az enumC0286az) {
        if (enumC0286az == null) {
            throw new NullPointerException();
        }
        this.f657a |= 2;
        this.f659c = enumC0286az;
        return this;
    }

    /* renamed from: a */
    public C0264ad m1007a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f657a |= 4;
        this.f660d = str;
        return this;
    }
}
