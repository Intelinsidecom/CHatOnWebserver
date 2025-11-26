package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.cg */
/* loaded from: classes.dex */
public final class C0321cg extends GeneratedMessageLite.Builder implements InterfaceC0296bi {

    /* renamed from: a */
    private int f904a;

    /* renamed from: b */
    private long f905b;

    /* renamed from: c */
    private EnumC0341o f906c = EnumC0341o.CLOSE;

    /* renamed from: d */
    private C0313bz f907d = C0313bz.m1619a();

    private C0321cg() {
        m1720k();
    }

    /* renamed from: k */
    private void m1720k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0321cg m1721l() {
        return new C0321cg();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0321cg clear() {
        super.clear();
        this.f905b = 0L;
        this.f904a &= -2;
        this.f906c = EnumC0341o.CLOSE;
        this.f904a &= -3;
        this.f907d = C0313bz.m1619a();
        this.f904a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0321cg mo5946clone() {
        return m1721l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0266af getDefaultInstanceForType() {
        return C0266af.m1037a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0266af build() {
        C0266af c0266afBuildPartial = buildPartial();
        if (!c0266afBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0266afBuildPartial);
        }
        return c0266afBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0266af m1722m() throws InvalidProtocolBufferException {
        C0266af c0266afBuildPartial = buildPartial();
        if (!c0266afBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0266afBuildPartial).asInvalidProtocolBufferException();
        }
        return c0266afBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0266af buildPartial() {
        C0266af c0266af = new C0266af(this);
        int i = this.f904a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0266af.f669c = this.f905b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0266af.f670d = this.f906c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0266af.f671e = this.f907d;
        c0266af.f668b = i2;
        return c0266af;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0321cg mergeFrom(C0266af c0266af) {
        if (c0266af != C0266af.m1037a()) {
            if (c0266af.m1044c()) {
                m1724a(c0266af.m1045d());
            }
            if (c0266af.m1046e()) {
                m1728a(c0266af.m1047f());
            }
            if (c0266af.m1048g()) {
                m1730b(c0266af.m1049h());
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
    public C0321cg mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f904a |= 1;
                    this.f905b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0341o enumC0341oM1946a = EnumC0341o.m1946a(codedInputStream.readEnum());
                    if (enumC0341oM1946a == null) {
                        break;
                    } else {
                        this.f904a |= 2;
                        this.f906c = enumC0341oM1946a;
                        break;
                    }
                case MREvent.TILT_RIGHT /* 26 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1736h()) {
                        c0312byNewBuilder.mergeFrom(m1737i());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1727a(c0312byNewBuilder.buildPartial());
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

    /* renamed from: f */
    public long m1734f() {
        return this.f905b;
    }

    /* renamed from: a */
    public C0321cg m1724a(long j) {
        this.f904a |= 1;
        this.f905b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0341o m1735g() {
        return this.f906c;
    }

    /* renamed from: a */
    public C0321cg m1728a(EnumC0341o enumC0341o) {
        if (enumC0341o == null) {
            throw new NullPointerException();
        }
        this.f904a |= 2;
        this.f906c = enumC0341o;
        return this;
    }

    /* renamed from: h */
    public boolean m1736h() {
        return (this.f904a & 4) == 4;
    }

    /* renamed from: i */
    public C0313bz m1737i() {
        return this.f907d;
    }

    /* renamed from: a */
    public C0321cg m1727a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f907d = c0313bz;
        this.f904a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0321cg m1730b(C0313bz c0313bz) {
        if ((this.f904a & 4) == 4 && this.f907d != C0313bz.m1619a()) {
            this.f907d = C0313bz.m1618a(this.f907d).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f907d = c0313bz;
        }
        this.f904a |= 4;
        return this;
    }
}
