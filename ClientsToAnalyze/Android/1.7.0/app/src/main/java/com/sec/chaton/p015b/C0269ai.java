package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ai */
/* loaded from: classes.dex */
public final class C0269ai extends GeneratedMessageLite.Builder implements InterfaceC0292be {

    /* renamed from: a */
    private int f697a;

    /* renamed from: b */
    private long f698b;

    /* renamed from: c */
    private C0313bz f699c = C0313bz.m1619a();

    private C0269ai() {
        m1122j();
    }

    /* renamed from: j */
    private void m1122j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static C0269ai m1123k() {
        return new C0269ai();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0269ai clear() {
        super.clear();
        this.f698b = 0L;
        this.f697a &= -2;
        this.f699c = C0313bz.m1619a();
        this.f697a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0269ai mo5946clone() {
        return m1123k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0328cn getDefaultInstanceForType() {
        return C0328cn.m1791a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0328cn build() {
        C0328cn c0328cnBuildPartial = buildPartial();
        if (!c0328cnBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0328cnBuildPartial);
        }
        return c0328cnBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public C0328cn m1124l() throws InvalidProtocolBufferException {
        C0328cn c0328cnBuildPartial = buildPartial();
        if (!c0328cnBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0328cnBuildPartial).asInvalidProtocolBufferException();
        }
        return c0328cnBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0328cn buildPartial() {
        C0328cn c0328cn = new C0328cn(this);
        int i = this.f697a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0328cn.f929c = this.f698b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0328cn.f930d = this.f699c;
        c0328cn.f928b = i2;
        return c0328cn;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0269ai mergeFrom(C0328cn c0328cn) {
        if (c0328cn != C0328cn.m1791a()) {
            if (c0328cn.m1795c()) {
                m1126a(c0328cn.m1796d());
            }
            if (c0328cn.m1797e()) {
                m1132b(c0328cn.m1798f());
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
    public C0269ai mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f697a |= 1;
                    this.f698b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1137g()) {
                        c0312byNewBuilder.mergeFrom(m1138h());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1129a(c0312byNewBuilder.buildPartial());
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
    public long m1136f() {
        return this.f698b;
    }

    /* renamed from: a */
    public C0269ai m1126a(long j) {
        this.f697a |= 1;
        this.f698b = j;
        return this;
    }

    /* renamed from: g */
    public boolean m1137g() {
        return (this.f697a & 2) == 2;
    }

    /* renamed from: h */
    public C0313bz m1138h() {
        return this.f699c;
    }

    /* renamed from: a */
    public C0269ai m1129a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f699c = c0313bz;
        this.f697a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0269ai m1128a(C0312by c0312by) {
        this.f699c = c0312by.build();
        this.f697a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0269ai m1132b(C0313bz c0313bz) {
        if ((this.f697a & 2) == 2 && this.f699c != C0313bz.m1619a()) {
            this.f699c = C0313bz.m1618a(this.f699c).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f699c = c0313bz;
        }
        this.f697a |= 2;
        return this;
    }
}
