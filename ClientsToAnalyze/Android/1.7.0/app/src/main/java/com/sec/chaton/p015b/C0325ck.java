package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ck */
/* loaded from: classes.dex */
public final class C0325ck extends GeneratedMessageLite.Builder implements InterfaceC0320cf {

    /* renamed from: a */
    private int f922a;

    /* renamed from: d */
    private long f925d;

    /* renamed from: b */
    private Object f923b = "";

    /* renamed from: c */
    private Object f924c = "";

    /* renamed from: e */
    private EnumC0275ao f926e = EnumC0275ao.TEXT;

    private C0325ck() {
        m1774g();
    }

    /* renamed from: g */
    private void m1774g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0325ck m1775h() {
        return new C0325ck();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0325ck clear() {
        super.clear();
        this.f923b = "";
        this.f922a &= -2;
        this.f924c = "";
        this.f922a &= -3;
        this.f925d = 0L;
        this.f922a &= -5;
        this.f926e = EnumC0275ao.TEXT;
        this.f922a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0325ck mo5946clone() {
        return m1775h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0285ay getDefaultInstanceForType() {
        return C0285ay.m1278a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0285ay build() {
        C0285ay c0285ayBuildPartial = buildPartial();
        if (!c0285ayBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0285ayBuildPartial);
        }
        return c0285ayBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0285ay buildPartial() {
        C0285ay c0285ay = new C0285ay(this);
        int i = this.f922a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0285ay.f758c = this.f923b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0285ay.f759d = this.f924c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0285ay.f760e = this.f925d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0285ay.f761f = this.f926e;
        c0285ay.f757b = i2;
        return c0285ay;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0325ck mergeFrom(C0285ay c0285ay) {
        if (c0285ay != C0285ay.m1278a()) {
            if (c0285ay.m1286c()) {
                m1781a(c0285ay.m1287d());
            }
            if (c0285ay.m1288e()) {
                m1783b(c0285ay.m1289f());
            }
            if (c0285ay.m1290g()) {
                m1777a(c0285ay.m1291h());
            }
            if (c0285ay.m1292i()) {
                m1779a(c0285ay.m1293j());
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
    public C0325ck mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f922a |= 1;
                    this.f923b = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f922a |= 2;
                    this.f924c = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    this.f922a |= 4;
                    this.f925d = codedInputStream.readInt64();
                    break;
                case 32:
                    EnumC0275ao enumC0275aoM1170a = EnumC0275ao.m1170a(codedInputStream.readEnum());
                    if (enumC0275aoM1170a == null) {
                        break;
                    } else {
                        this.f922a |= 8;
                        this.f926e = enumC0275aoM1170a;
                        break;
                    }
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
    public C0325ck m1781a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f922a |= 1;
        this.f923b = str;
        return this;
    }

    /* renamed from: b */
    public C0325ck m1783b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f922a |= 2;
        this.f924c = str;
        return this;
    }

    /* renamed from: a */
    public C0325ck m1777a(long j) {
        this.f922a |= 4;
        this.f925d = j;
        return this;
    }

    /* renamed from: a */
    public C0325ck m1779a(EnumC0275ao enumC0275ao) {
        if (enumC0275ao == null) {
            throw new NullPointerException();
        }
        this.f922a |= 8;
        this.f926e = enumC0275ao;
        return this;
    }
}
