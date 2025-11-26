package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bs */
/* loaded from: classes.dex */
public final class C0306bs extends GeneratedMessageLite.Builder implements InterfaceC0336j {

    /* renamed from: a */
    private int f846a;

    /* renamed from: b */
    private long f847b;

    /* renamed from: c */
    private C0313bz f848c = C0313bz.m1619a();

    private C0306bs() {
        m1521i();
    }

    /* renamed from: i */
    private void m1521i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0306bs m1522j() {
        return new C0306bs();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0306bs clear() {
        super.clear();
        this.f847b = 0L;
        this.f846a &= -2;
        this.f848c = C0313bz.m1619a();
        this.f846a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0306bs mo5946clone() {
        return m1522j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0339m getDefaultInstanceForType() {
        return C0339m.m1935a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0339m build() {
        C0339m c0339mBuildPartial = buildPartial();
        if (!c0339mBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0339mBuildPartial);
        }
        return c0339mBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0339m m1523k() throws InvalidProtocolBufferException {
        C0339m c0339mBuildPartial = buildPartial();
        if (!c0339mBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0339mBuildPartial).asInvalidProtocolBufferException();
        }
        return c0339mBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0339m buildPartial() {
        C0339m c0339m = new C0339m(this);
        int i = this.f846a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0339m.f978c = this.f847b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0339m.f979d = this.f848c;
        c0339m.f977b = i2;
        return c0339m;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0306bs mergeFrom(C0339m c0339m) {
        if (c0339m != C0339m.m1935a()) {
            if (c0339m.m1939c()) {
                m1525a(c0339m.m1940d());
            }
            if (c0339m.m1941e()) {
                m1530b(c0339m.m1942f());
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
    public C0306bs mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f846a |= 1;
                    this.f847b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1534f()) {
                        c0312byNewBuilder.mergeFrom(m1535g());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1527a(c0312byNewBuilder.buildPartial());
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
    public C0306bs m1525a(long j) {
        this.f846a |= 1;
        this.f847b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1534f() {
        return (this.f846a & 2) == 2;
    }

    /* renamed from: g */
    public C0313bz m1535g() {
        return this.f848c;
    }

    /* renamed from: a */
    public C0306bs m1527a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f848c = c0313bz;
        this.f846a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0306bs m1530b(C0313bz c0313bz) {
        if ((this.f846a & 2) == 2 && this.f848c != C0313bz.m1619a()) {
            this.f848c = C0313bz.m1618a(this.f848c).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f848c = c0313bz;
        }
        this.f846a |= 2;
        return this;
    }
}
