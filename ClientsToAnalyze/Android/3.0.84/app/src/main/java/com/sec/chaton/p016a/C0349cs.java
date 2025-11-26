package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cs */
/* loaded from: classes.dex */
public final class C0349cs extends GeneratedMessageLite.Builder<C0348cr, C0349cs> implements InterfaceC0350ct {

    /* renamed from: a */
    private int f1216a;

    /* renamed from: b */
    private EnumC0302az f1217b = EnumC0302az.SINGLE;

    /* renamed from: c */
    private Object f1218c = "";

    /* renamed from: d */
    private Object f1219d = "";

    /* renamed from: e */
    private Object f1220e = "";

    /* renamed from: f */
    private EnumC0305bb f1221f = EnumC0305bb.CONTENT_TEXT;

    /* renamed from: g */
    private int f1222g;

    private C0349cs() {
        m2309g();
    }

    /* renamed from: g */
    private void m2309g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0349cs m2310h() {
        return new C0349cs();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0349cs clear() {
        super.clear();
        this.f1217b = EnumC0302az.SINGLE;
        this.f1216a &= -2;
        this.f1218c = "";
        this.f1216a &= -3;
        this.f1219d = "";
        this.f1216a &= -5;
        this.f1220e = "";
        this.f1216a &= -9;
        this.f1221f = EnumC0305bb.CONTENT_TEXT;
        this.f1216a &= -17;
        this.f1222g = 0;
        this.f1216a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0349cs mo13386clone() {
        return m2310h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0348cr getDefaultInstanceForType() {
        return C0348cr.m2281a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0348cr build() {
        C0348cr c0348crBuildPartial = buildPartial();
        if (!c0348crBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0348crBuildPartial);
        }
        return c0348crBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0348cr m2311i() throws InvalidProtocolBufferException {
        C0348cr c0348crBuildPartial = buildPartial();
        if (!c0348crBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0348crBuildPartial).asInvalidProtocolBufferException();
        }
        return c0348crBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0348cr buildPartial() {
        C0348cr c0348cr = new C0348cr(this);
        int i = this.f1216a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0348cr.f1208c = this.f1217b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0348cr.f1209d = this.f1218c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0348cr.f1210e = this.f1219d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0348cr.f1211f = this.f1220e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0348cr.f1212g = this.f1221f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0348cr.f1213h = this.f1222g;
        c0348cr.f1207b = i2;
        return c0348cr;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0349cs mergeFrom(C0348cr c0348cr) {
        if (c0348cr != C0348cr.m2281a()) {
            if (c0348cr.m2293c()) {
                m2315a(c0348cr.m2294d());
            }
            if (c0348cr.m2295e()) {
                m2318a(c0348cr.m2296f());
            }
            if (c0348cr.m2297g()) {
                m2320b(c0348cr.m2298h());
            }
            if (c0348cr.m2299i()) {
                m2322c(c0348cr.m2300j());
            }
            if (c0348cr.m2301k()) {
                m2316a(c0348cr.m2302l());
            }
            if (c0348cr.m2303m()) {
                m2313a(c0348cr.m2304n());
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
    public C0349cs mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f1216a |= 1;
                        this.f1217b = enumC0302azM1704a;
                        break;
                    }
                case 18:
                    this.f1216a |= 2;
                    this.f1218c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f1216a |= 4;
                    this.f1219d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1216a |= 8;
                    this.f1220e = codedInputStream.readBytes();
                    break;
                case 40:
                    EnumC0305bb enumC0305bbM1706a = EnumC0305bb.m1706a(codedInputStream.readEnum());
                    if (enumC0305bbM1706a == null) {
                        break;
                    } else {
                        this.f1216a |= 16;
                        this.f1221f = enumC0305bbM1706a;
                        break;
                    }
                case 48:
                    this.f1216a |= 32;
                    this.f1222g = codedInputStream.readInt32();
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
    public C0349cs m2315a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f1216a |= 1;
        this.f1217b = enumC0302az;
        return this;
    }

    /* renamed from: a */
    public C0349cs m2318a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1216a |= 2;
        this.f1218c = str;
        return this;
    }

    /* renamed from: b */
    public C0349cs m2320b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1216a |= 4;
        this.f1219d = str;
        return this;
    }

    /* renamed from: c */
    public C0349cs m2322c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1216a |= 8;
        this.f1220e = str;
        return this;
    }

    /* renamed from: a */
    public C0349cs m2316a(EnumC0305bb enumC0305bb) {
        if (enumC0305bb == null) {
            throw new NullPointerException();
        }
        this.f1216a |= 16;
        this.f1221f = enumC0305bb;
        return this;
    }

    /* renamed from: a */
    public C0349cs m2313a(int i) {
        this.f1216a |= 32;
        this.f1222g = i;
        return this;
    }
}
