package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ai */
/* loaded from: classes.dex */
public final class C0075ai extends GeneratedMessageLite.Builder implements InterfaceC0091j {

    /* renamed from: a */
    private int f85a;

    /* renamed from: b */
    private int f86b;

    /* renamed from: c */
    private long f87c;

    /* renamed from: d */
    private int f88d;

    private C0075ai() {
        m237g();
    }

    /* renamed from: g */
    private void m237g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0075ai m238h() {
        return new C0075ai();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0075ai clear() {
        super.clear();
        this.f86b = 0;
        this.f85a &= -2;
        this.f87c = 0L;
        this.f85a &= -3;
        this.f88d = 0;
        this.f85a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0075ai mo5946clone() {
        return m238h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0104w getDefaultInstanceForType() {
        return C0104w.m548a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0104w build() {
        C0104w c0104wBuildPartial = buildPartial();
        if (!c0104wBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0104wBuildPartial);
        }
        return c0104wBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0104w m239i() throws InvalidProtocolBufferException {
        C0104w c0104wBuildPartial = buildPartial();
        if (!c0104wBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0104wBuildPartial).asInvalidProtocolBufferException();
        }
        return c0104wBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0104w buildPartial() {
        C0104w c0104w = new C0104w(this);
        int i = this.f85a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0104w.f193c = this.f86b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0104w.f194d = this.f87c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0104w.f195e = this.f88d;
        c0104w.f192b = i2;
        return c0104w;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0075ai mergeFrom(C0104w c0104w) {
        if (c0104w != C0104w.m548a()) {
            if (c0104w.m554c()) {
                m241a(c0104w.m555d());
            }
            if (c0104w.m556e()) {
                m242a(c0104w.m557f());
            }
            if (c0104w.m558g()) {
                m246b(c0104w.m559h());
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
    public C0075ai mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f85a |= 1;
                    this.f86b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f85a |= 2;
                    this.f87c = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    this.f85a |= 4;
                    this.f88d = codedInputStream.readInt32();
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
    public C0075ai m241a(int i) {
        this.f85a |= 1;
        this.f86b = i;
        return this;
    }

    /* renamed from: a */
    public C0075ai m242a(long j) {
        this.f85a |= 2;
        this.f87c = j;
        return this;
    }

    /* renamed from: b */
    public C0075ai m246b(int i) {
        this.f85a |= 4;
        this.f88d = i;
        return this;
    }
}
