package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bj */
/* loaded from: classes.dex */
public final class C0297bj extends GeneratedMessageLite.Builder implements InterfaceC0335i {

    /* renamed from: a */
    private int f781a;

    /* renamed from: d */
    private long f784d;

    /* renamed from: f */
    private long f786f;

    /* renamed from: b */
    private Object f782b = "";

    /* renamed from: c */
    private LazyStringList f783c = LazyStringArrayList.EMPTY;

    /* renamed from: e */
    private Object f785e = "";

    /* renamed from: g */
    private EnumC0275ao f787g = EnumC0275ao.TEXT;

    /* renamed from: h */
    private EnumC0323ci f788h = EnumC0323ci.SINGLE;

    private C0297bj() {
        m1341g();
    }

    /* renamed from: g */
    private void m1341g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0297bj m1342h() {
        return new C0297bj();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0297bj clear() {
        super.clear();
        this.f782b = "";
        this.f781a &= -2;
        this.f783c = LazyStringArrayList.EMPTY;
        this.f781a &= -3;
        this.f784d = 0L;
        this.f781a &= -5;
        this.f785e = "";
        this.f781a &= -9;
        this.f786f = 0L;
        this.f781a &= -17;
        this.f787g = EnumC0275ao.TEXT;
        this.f781a &= -33;
        this.f788h = EnumC0323ci.SINGLE;
        this.f781a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0297bj mo5946clone() {
        return m1342h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0329co getDefaultInstanceForType() {
        return C0329co.m1807a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0329co build() {
        C0329co c0329coBuildPartial = buildPartial();
        if (!c0329coBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0329coBuildPartial);
        }
        return c0329coBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0329co buildPartial() {
        C0329co c0329co = new C0329co(this);
        int i = this.f781a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0329co.f935c = this.f782b;
        if ((this.f781a & 2) == 2) {
            this.f783c = new UnmodifiableLazyStringList(this.f783c);
            this.f781a &= -3;
        }
        c0329co.f936d = this.f783c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0329co.f937e = this.f784d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0329co.f938f = this.f785e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0329co.f939g = this.f786f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0329co.f940h = this.f787g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0329co.f941i = this.f788h;
        c0329co.f934b = i2;
        return c0329co;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0297bj mergeFrom(C0329co c0329co) {
        if (c0329co != C0329co.m1807a()) {
            if (c0329co.m1817c()) {
                m1350a(c0329co.m1818d());
            }
            if (!c0329co.f936d.isEmpty()) {
                if (this.f783c.isEmpty()) {
                    this.f783c = c0329co.f936d;
                    this.f781a &= -3;
                } else {
                    m1343i();
                    this.f783c.addAll(c0329co.f936d);
                }
            }
            if (c0329co.m1821g()) {
                m1345a(c0329co.m1822h());
            }
            if (c0329co.m1823i()) {
                m1353b(c0329co.m1824j());
            }
            if (c0329co.m1825k()) {
                m1352b(c0329co.m1826l());
            }
            if (c0329co.m1827m()) {
                m1347a(c0329co.m1828n());
            }
            if (c0329co.m1829o()) {
                m1348a(c0329co.m1830p());
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
    public C0297bj mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f781a |= 1;
                    this.f782b = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    m1343i();
                    this.f783c.add(codedInputStream.readBytes());
                    break;
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    this.f781a |= 4;
                    this.f784d = codedInputStream.readInt64();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f781a |= 8;
                    this.f785e = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_RECEIVE_READY /* 40 */:
                    this.f781a |= 16;
                    this.f786f = codedInputStream.readInt64();
                    break;
                case MREvent.SNAP1_X_NEGATIVE /* 48 */:
                    EnumC0275ao enumC0275aoM1170a = EnumC0275ao.m1170a(codedInputStream.readEnum());
                    if (enumC0275aoM1170a == null) {
                        break;
                    } else {
                        this.f781a |= 32;
                        this.f787g = enumC0275aoM1170a;
                        break;
                    }
                case MREvent.SNAP2_Y_NEGATIVE /* 56 */:
                    EnumC0323ci enumC0323ciM1750a = EnumC0323ci.m1750a(codedInputStream.readEnum());
                    if (enumC0323ciM1750a == null) {
                        break;
                    } else {
                        this.f781a |= 64;
                        this.f788h = enumC0323ciM1750a;
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
    public C0297bj m1350a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f781a |= 1;
        this.f782b = str;
        return this;
    }

    /* renamed from: i */
    private void m1343i() {
        if ((this.f781a & 2) != 2) {
            this.f783c = new LazyStringArrayList(this.f783c);
            this.f781a |= 2;
        }
    }

    /* renamed from: a */
    public C0297bj m1345a(long j) {
        this.f781a |= 4;
        this.f784d = j;
        return this;
    }

    /* renamed from: b */
    public C0297bj m1353b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f781a |= 8;
        this.f785e = str;
        return this;
    }

    /* renamed from: b */
    public C0297bj m1352b(long j) {
        this.f781a |= 16;
        this.f786f = j;
        return this;
    }

    /* renamed from: a */
    public C0297bj m1347a(EnumC0275ao enumC0275ao) {
        if (enumC0275ao == null) {
            throw new NullPointerException();
        }
        this.f781a |= 32;
        this.f787g = enumC0275ao;
        return this;
    }

    /* renamed from: a */
    public C0297bj m1348a(EnumC0323ci enumC0323ci) {
        if (enumC0323ci == null) {
            throw new NullPointerException();
        }
        this.f781a |= 64;
        this.f788h = enumC0323ci;
        return this;
    }
}
