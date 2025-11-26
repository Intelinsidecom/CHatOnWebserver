package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ae */
/* loaded from: classes.dex */
public final class C0265ae extends GeneratedMessageLite.Builder implements InterfaceC0318cd {

    /* renamed from: a */
    private int f661a;

    /* renamed from: b */
    private long f662b;

    /* renamed from: d */
    private long f664d;

    /* renamed from: c */
    private Object f663c = "";

    /* renamed from: e */
    private C0308bu f665e = C0308bu.m1552a();

    /* renamed from: f */
    private C0313bz f666f = C0313bz.m1619a();

    private C0265ae() {
        m1014k();
    }

    /* renamed from: k */
    private void m1014k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0265ae m1015l() {
        return new C0265ae();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0265ae clear() {
        super.clear();
        this.f662b = 0L;
        this.f661a &= -2;
        this.f663c = "";
        this.f661a &= -3;
        this.f664d = 0L;
        this.f661a &= -5;
        this.f665e = C0308bu.m1552a();
        this.f661a &= -9;
        this.f666f = C0313bz.m1619a();
        this.f661a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0265ae mo5946clone() {
        return m1015l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0277aq getDefaultInstanceForType() {
        return C0277aq.m1191a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0277aq build() {
        C0277aq c0277aqBuildPartial = buildPartial();
        if (!c0277aqBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0277aqBuildPartial);
        }
        return c0277aqBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0277aq m1016m() throws InvalidProtocolBufferException {
        C0277aq c0277aqBuildPartial = buildPartial();
        if (!c0277aqBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0277aqBuildPartial).asInvalidProtocolBufferException();
        }
        return c0277aqBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0277aq buildPartial() {
        C0277aq c0277aq = new C0277aq(this);
        int i = this.f661a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0277aq.f727c = this.f662b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0277aq.f728d = this.f663c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0277aq.f729e = this.f664d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0277aq.f730f = this.f665e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0277aq.f731g = this.f666f;
        c0277aq.f726b = i2;
        return c0277aq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0265ae mergeFrom(C0277aq c0277aq) {
        if (c0277aq != C0277aq.m1191a()) {
            if (c0277aq.m1200c()) {
                m1018a(c0277aq.m1201d());
            }
            if (c0277aq.m1202e()) {
                m1023a(c0277aq.m1203f());
            }
            if (c0277aq.m1204g()) {
                m1025b(c0277aq.m1205h());
            }
            if (c0277aq.m1206i()) {
                m1026b(c0277aq.m1207j());
            }
            if (c0277aq.m1208k()) {
                m1027b(c0277aq.m1209l());
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
    public C0265ae mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f661a |= 1;
                    this.f662b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f661a |= 2;
                    this.f663c = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    this.f661a |= 4;
                    this.f664d = codedInputStream.readInt64();
                    break;
                case MREvent.SHAKE /* 34 */:
                    C0273am c0273amNewBuilder = C0308bu.newBuilder();
                    if (m1031f()) {
                        c0273amNewBuilder.mergeFrom(m1032g());
                    }
                    codedInputStream.readMessage(c0273amNewBuilder, extensionRegistryLite);
                    m1021a(c0273amNewBuilder.buildPartial());
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1033h()) {
                        c0312byNewBuilder.mergeFrom(m1034i());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1022a(c0312byNewBuilder.buildPartial());
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
    public C0265ae m1018a(long j) {
        this.f661a |= 1;
        this.f662b = j;
        return this;
    }

    /* renamed from: a */
    public C0265ae m1023a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f661a |= 2;
        this.f663c = str;
        return this;
    }

    /* renamed from: b */
    public C0265ae m1025b(long j) {
        this.f661a |= 4;
        this.f664d = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1031f() {
        return (this.f661a & 8) == 8;
    }

    /* renamed from: g */
    public C0308bu m1032g() {
        return this.f665e;
    }

    /* renamed from: a */
    public C0265ae m1021a(C0308bu c0308bu) {
        if (c0308bu == null) {
            throw new NullPointerException();
        }
        this.f665e = c0308bu;
        this.f661a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0265ae m1026b(C0308bu c0308bu) {
        if ((this.f661a & 8) == 8 && this.f665e != C0308bu.m1552a()) {
            this.f665e = C0308bu.m1551a(this.f665e).mergeFrom(c0308bu).buildPartial();
        } else {
            this.f665e = c0308bu;
        }
        this.f661a |= 8;
        return this;
    }

    /* renamed from: h */
    public boolean m1033h() {
        return (this.f661a & 16) == 16;
    }

    /* renamed from: i */
    public C0313bz m1034i() {
        return this.f666f;
    }

    /* renamed from: a */
    public C0265ae m1022a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f666f = c0313bz;
        this.f661a |= 16;
        return this;
    }

    /* renamed from: b */
    public C0265ae m1027b(C0313bz c0313bz) {
        if ((this.f661a & 16) == 16 && this.f666f != C0313bz.m1619a()) {
            this.f666f = C0313bz.m1618a(this.f666f).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f666f = c0313bz;
        }
        this.f661a |= 16;
        return this;
    }
}
