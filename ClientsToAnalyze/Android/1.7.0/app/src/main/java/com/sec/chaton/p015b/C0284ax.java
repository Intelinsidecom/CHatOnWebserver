package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ax */
/* loaded from: classes.dex */
public final class C0284ax extends GeneratedMessageLite.Builder implements InterfaceC0288ba {

    /* renamed from: a */
    private int f752a;

    /* renamed from: b */
    private EnumC0274an f753b = EnumC0274an.ENTER;

    /* renamed from: c */
    private Object f754c = "";

    /* renamed from: d */
    private Object f755d = "";

    private C0284ax() {
        m1263g();
    }

    /* renamed from: g */
    private void m1263g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0284ax m1264h() {
        return new C0284ax();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0284ax clear() {
        super.clear();
        this.f753b = EnumC0274an.ENTER;
        this.f752a &= -2;
        this.f754c = "";
        this.f752a &= -3;
        this.f755d = "";
        this.f752a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0284ax mo5946clone() {
        return m1264h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0333g getDefaultInstanceForType() {
        return C0333g.m1915a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0333g build() {
        C0333g c0333gBuildPartial = buildPartial();
        if (!c0333gBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0333gBuildPartial);
        }
        return c0333gBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0333g buildPartial() {
        C0333g c0333g = new C0333g(this);
        int i = this.f752a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0333g.f971c = this.f753b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0333g.f972d = this.f754c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0333g.f973e = this.f755d;
        c0333g.f970b = i2;
        return c0333g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0284ax mergeFrom(C0333g c0333g) {
        if (c0333g != C0333g.m1915a()) {
            if (c0333g.m1922c()) {
                m1267a(c0333g.m1923d());
            }
            if (c0333g.m1924e()) {
                m1269a(c0333g.m1925f());
            }
            if (c0333g.m1926g()) {
                m1271b(c0333g.m1927h());
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
    public C0284ax mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    EnumC0274an enumC0274anM1169a = EnumC0274an.m1169a(codedInputStream.readEnum());
                    if (enumC0274anM1169a == null) {
                        break;
                    } else {
                        this.f752a |= 1;
                        this.f753b = enumC0274anM1169a;
                        break;
                    }
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f752a |= 2;
                    this.f754c = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f752a |= 4;
                    this.f755d = codedInputStream.readBytes();
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
    public C0284ax m1267a(EnumC0274an enumC0274an) {
        if (enumC0274an == null) {
            throw new NullPointerException();
        }
        this.f752a |= 1;
        this.f753b = enumC0274an;
        return this;
    }

    /* renamed from: a */
    public C0284ax m1269a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f752a |= 2;
        this.f754c = str;
        return this;
    }

    /* renamed from: b */
    public C0284ax m1271b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f752a |= 4;
        this.f755d = str;
        return this;
    }
}
