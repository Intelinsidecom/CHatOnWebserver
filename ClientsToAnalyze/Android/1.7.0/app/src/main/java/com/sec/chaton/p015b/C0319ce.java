package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ce */
/* loaded from: classes.dex */
public final class C0319ce extends GeneratedMessageLite.Builder implements InterfaceC0327cm {

    /* renamed from: a */
    private int f900a;

    /* renamed from: b */
    private long f901b;

    /* renamed from: c */
    private C0313bz f902c = C0313bz.m1619a();

    /* renamed from: d */
    private long f903d;

    private C0319ce() {
        m1702i();
    }

    /* renamed from: i */
    private void m1702i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0319ce m1703j() {
        return new C0319ce();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0319ce clear() {
        super.clear();
        this.f901b = 0L;
        this.f900a &= -2;
        this.f902c = C0313bz.m1619a();
        this.f900a &= -3;
        this.f903d = 0L;
        this.f900a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0319ce mo5946clone() {
        return m1703j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0348v getDefaultInstanceForType() {
        return C0348v.m2000a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0348v build() {
        C0348v c0348vBuildPartial = buildPartial();
        if (!c0348vBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0348vBuildPartial);
        }
        return c0348vBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0348v m1704k() throws InvalidProtocolBufferException {
        C0348v c0348vBuildPartial = buildPartial();
        if (!c0348vBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0348vBuildPartial).asInvalidProtocolBufferException();
        }
        return c0348vBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0348v buildPartial() {
        C0348v c0348v = new C0348v(this);
        int i = this.f900a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0348v.f1004c = this.f901b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0348v.f1005d = this.f902c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0348v.f1006e = this.f903d;
        c0348v.f1003b = i2;
        return c0348v;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0319ce mergeFrom(C0348v c0348v) {
        if (c0348v != C0348v.m2000a()) {
            if (c0348v.m2005c()) {
                m1706a(c0348v.m2006d());
            }
            if (c0348v.m2007e()) {
                m1712b(c0348v.m2008f());
            }
            if (c0348v.m2009g()) {
                m1711b(c0348v.m2010h());
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
    public C0319ce mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f900a |= 1;
                    this.f901b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1716f()) {
                        c0312byNewBuilder.mergeFrom(m1717g());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1708a(c0312byNewBuilder.buildPartial());
                    break;
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    this.f900a |= 4;
                    this.f903d = codedInputStream.readInt64();
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
    public C0319ce m1706a(long j) {
        this.f900a |= 1;
        this.f901b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1716f() {
        return (this.f900a & 2) == 2;
    }

    /* renamed from: g */
    public C0313bz m1717g() {
        return this.f902c;
    }

    /* renamed from: a */
    public C0319ce m1708a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f902c = c0313bz;
        this.f900a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0319ce m1712b(C0313bz c0313bz) {
        if ((this.f900a & 2) == 2 && this.f902c != C0313bz.m1619a()) {
            this.f902c = C0313bz.m1618a(this.f902c).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f902c = c0313bz;
        }
        this.f900a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0319ce m1711b(long j) {
        this.f900a |= 4;
        this.f903d = j;
        return this;
    }
}
