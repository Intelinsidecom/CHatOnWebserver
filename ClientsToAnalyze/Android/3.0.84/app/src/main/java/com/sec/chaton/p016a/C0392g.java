package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.g */
/* loaded from: classes.dex */
public final class C0392g extends GeneratedMessageLite.Builder<C0391f, C0392g> implements InterfaceC0393h {

    /* renamed from: a */
    private int f1385a;

    /* renamed from: b */
    private long f1386b;

    /* renamed from: c */
    private EnumC0302az f1387c = EnumC0302az.SINGLE;

    /* renamed from: d */
    private Object f1388d = "";

    /* renamed from: e */
    private Object f1389e = "";

    /* renamed from: f */
    private Object f1390f = "";

    /* renamed from: g */
    private Object f1391g = "";

    /* renamed from: h */
    private Object f1392h = "";

    /* renamed from: i */
    private int f1393i;

    /* renamed from: j */
    private long f1394j;

    /* renamed from: k */
    private long f1395k;

    private C0392g() {
        m2796g();
    }

    /* renamed from: g */
    private void m2796g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0392g m2797h() {
        return new C0392g();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0392g clear() {
        super.clear();
        this.f1386b = 0L;
        this.f1385a &= -2;
        this.f1387c = EnumC0302az.SINGLE;
        this.f1385a &= -3;
        this.f1388d = "";
        this.f1385a &= -5;
        this.f1389e = "";
        this.f1385a &= -9;
        this.f1390f = "";
        this.f1385a &= -17;
        this.f1391g = "";
        this.f1385a &= -33;
        this.f1392h = "";
        this.f1385a &= -65;
        this.f1393i = 0;
        this.f1385a &= -129;
        this.f1394j = 0L;
        this.f1385a &= -257;
        this.f1395k = 0L;
        this.f1385a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0392g mo13386clone() {
        return m2797h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0391f getDefaultInstanceForType() {
        return C0391f.m2758a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0391f build() {
        C0391f c0391fBuildPartial = buildPartial();
        if (!c0391fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0391fBuildPartial);
        }
        return c0391fBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0391f m2798i() throws InvalidProtocolBufferException {
        C0391f c0391fBuildPartial = buildPartial();
        if (!c0391fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0391fBuildPartial).asInvalidProtocolBufferException();
        }
        return c0391fBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0391f buildPartial() {
        C0391f c0391f = new C0391f(this);
        int i = this.f1385a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0391f.f1373c = this.f1386b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0391f.f1374d = this.f1387c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0391f.f1375e = this.f1388d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0391f.f1376f = this.f1389e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0391f.f1377g = this.f1390f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0391f.f1378h = this.f1391g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0391f.f1379i = this.f1392h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0391f.f1380j = this.f1393i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        c0391f.f1381k = this.f1394j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        c0391f.f1382l = this.f1395k;
        c0391f.f1372b = i2;
        return c0391f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0392g mergeFrom(C0391f c0391f) {
        if (c0391f != C0391f.m2758a()) {
            if (c0391f.m2772c()) {
                m2801a(c0391f.m2773d());
            }
            if (c0391f.m2774e()) {
                m2803a(c0391f.m2775f());
            }
            if (c0391f.m2776g()) {
                m2805a(c0391f.m2777h());
            }
            if (c0391f.m2778i()) {
                m2808b(c0391f.m2779j());
            }
            if (c0391f.m2780k()) {
                m2811c(c0391f.m2781l());
            }
            if (c0391f.m2782m()) {
                m2813d(c0391f.m2783n());
            }
            if (c0391f.m2784o()) {
                m2815e(c0391f.m2785p());
            }
            if (c0391f.m2786q()) {
                m2800a(c0391f.m2787r());
            }
            if (c0391f.m2788s()) {
                m2807b(c0391f.m2789t());
            }
            if (c0391f.m2790u()) {
                m2810c(c0391f.m2791v());
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
    public C0392g mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1385a |= 1;
                    this.f1386b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f1385a |= 2;
                        this.f1387c = enumC0302azM1704a;
                        break;
                    }
                case 26:
                    this.f1385a |= 4;
                    this.f1388d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1385a |= 8;
                    this.f1389e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f1385a |= 16;
                    this.f1390f = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f1385a |= 32;
                    this.f1391g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f1385a |= 64;
                    this.f1392h = codedInputStream.readBytes();
                    break;
                case 64:
                    this.f1385a |= 128;
                    this.f1393i = codedInputStream.readInt32();
                    break;
                case 72:
                    this.f1385a |= 256;
                    this.f1394j = codedInputStream.readInt64();
                    break;
                case 80:
                    this.f1385a |= 512;
                    this.f1395k = codedInputStream.readInt64();
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
    public C0392g m2801a(long j) {
        this.f1385a |= 1;
        this.f1386b = j;
        return this;
    }

    /* renamed from: a */
    public C0392g m2803a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f1385a |= 2;
        this.f1387c = enumC0302az;
        return this;
    }

    /* renamed from: a */
    public C0392g m2805a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1385a |= 4;
        this.f1388d = str;
        return this;
    }

    /* renamed from: b */
    public C0392g m2808b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1385a |= 8;
        this.f1389e = str;
        return this;
    }

    /* renamed from: c */
    public C0392g m2811c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1385a |= 16;
        this.f1390f = str;
        return this;
    }

    /* renamed from: d */
    public C0392g m2813d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1385a |= 32;
        this.f1391g = str;
        return this;
    }

    /* renamed from: e */
    public C0392g m2815e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1385a |= 64;
        this.f1392h = str;
        return this;
    }

    /* renamed from: a */
    public C0392g m2800a(int i) {
        this.f1385a |= 128;
        this.f1393i = i;
        return this;
    }

    /* renamed from: b */
    public C0392g m2807b(long j) {
        this.f1385a |= 256;
        this.f1394j = j;
        return this;
    }

    /* renamed from: c */
    public C0392g m2810c(long j) {
        this.f1385a |= 512;
        this.f1395k = j;
        return this;
    }
}
