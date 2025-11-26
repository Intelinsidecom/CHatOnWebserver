package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ap */
/* loaded from: classes.dex */
public final class C0276ap extends GeneratedMessageLite.Builder implements InterfaceC0271ak {

    /* renamed from: a */
    private int f722a;

    /* renamed from: b */
    private long f723b;

    /* renamed from: c */
    private C0313bz f724c = C0313bz.m1619a();

    private C0276ap() {
        m1173i();
    }

    /* renamed from: i */
    private void m1173i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0276ap m1174j() {
        return new C0276ap();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0276ap clear() {
        super.clear();
        this.f723b = 0L;
        this.f722a &= -2;
        this.f724c = C0313bz.m1619a();
        this.f722a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0276ap mo5946clone() {
        return m1174j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0263ac getDefaultInstanceForType() {
        return C0263ac.m985a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0263ac build() {
        C0263ac c0263acBuildPartial = buildPartial();
        if (!c0263acBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0263acBuildPartial);
        }
        return c0263acBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0263ac m1175k() throws InvalidProtocolBufferException {
        C0263ac c0263acBuildPartial = buildPartial();
        if (!c0263acBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0263acBuildPartial).asInvalidProtocolBufferException();
        }
        return c0263acBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0263ac buildPartial() {
        C0263ac c0263ac = new C0263ac(this);
        int i = this.f722a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0263ac.f653c = this.f723b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0263ac.f654d = this.f724c;
        c0263ac.f652b = i2;
        return c0263ac;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0276ap mergeFrom(C0263ac c0263ac) {
        if (c0263ac != C0263ac.m985a()) {
            if (c0263ac.m991c()) {
                m1177a(c0263ac.m992d());
            }
            if (c0263ac.m993e()) {
                m1182b(c0263ac.m994f());
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
    public C0276ap mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f722a |= 1;
                    this.f723b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1186f()) {
                        c0312byNewBuilder.mergeFrom(m1187g());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1180a(c0312byNewBuilder.buildPartial());
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
    public C0276ap m1177a(long j) {
        this.f722a |= 1;
        this.f723b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1186f() {
        return (this.f722a & 2) == 2;
    }

    /* renamed from: g */
    public C0313bz m1187g() {
        return this.f724c;
    }

    /* renamed from: a */
    public C0276ap m1180a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f724c = c0313bz;
        this.f722a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0276ap m1182b(C0313bz c0313bz) {
        if ((this.f722a & 2) == 2 && this.f724c != C0313bz.m1619a()) {
            this.f724c = C0313bz.m1618a(this.f724c).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f724c = c0313bz;
        }
        this.f722a |= 2;
        return this;
    }
}
