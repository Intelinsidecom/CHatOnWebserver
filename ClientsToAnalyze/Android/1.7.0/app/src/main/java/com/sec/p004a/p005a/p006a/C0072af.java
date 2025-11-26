package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.af */
/* loaded from: classes.dex */
public final class C0072af extends GeneratedMessageLite.Builder implements InterfaceC0078al {

    /* renamed from: a */
    private int f70a;

    /* renamed from: b */
    private int f71b;

    /* renamed from: c */
    private long f72c;

    /* renamed from: d */
    private int f73d;

    private C0072af() {
        m184g();
    }

    /* renamed from: g */
    private void m184g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0072af m185h() {
        return new C0072af();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0072af clear() {
        super.clear();
        this.f71b = 0;
        this.f70a &= -2;
        this.f72c = 0L;
        this.f70a &= -3;
        this.f73d = 0;
        this.f70a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0072af mo5946clone() {
        return m185h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0094m getDefaultInstanceForType() {
        return C0094m.m428a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0094m build() {
        C0094m c0094mBuildPartial = buildPartial();
        if (!c0094mBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0094mBuildPartial);
        }
        return c0094mBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0094m m186i() throws InvalidProtocolBufferException {
        C0094m c0094mBuildPartial = buildPartial();
        if (!c0094mBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0094mBuildPartial).asInvalidProtocolBufferException();
        }
        return c0094mBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0094m buildPartial() {
        C0094m c0094m = new C0094m(this);
        int i = this.f70a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0094m.f155c = this.f71b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0094m.f156d = this.f72c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0094m.f157e = this.f73d;
        c0094m.f154b = i2;
        return c0094m;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0072af mergeFrom(C0094m c0094m) {
        if (c0094m != C0094m.m428a()) {
            if (c0094m.m434c()) {
                m188a(c0094m.m435d());
            }
            if (c0094m.m436e()) {
                m189a(c0094m.m437f());
            }
            if (c0094m.m438g()) {
                m193b(c0094m.m439h());
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
    public C0072af mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f70a |= 1;
                    this.f71b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f70a |= 2;
                    this.f72c = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    this.f70a |= 4;
                    this.f73d = codedInputStream.readInt32();
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
    public C0072af m188a(int i) {
        this.f70a |= 1;
        this.f71b = i;
        return this;
    }

    /* renamed from: a */
    public C0072af m189a(long j) {
        this.f70a |= 2;
        this.f72c = j;
        return this;
    }

    /* renamed from: b */
    public C0072af m193b(int i) {
        this.f70a |= 4;
        this.f73d = i;
        return this;
    }
}
