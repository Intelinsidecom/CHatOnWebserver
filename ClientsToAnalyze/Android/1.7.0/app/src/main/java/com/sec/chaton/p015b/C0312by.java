package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.by */
/* loaded from: classes.dex */
public final class C0312by extends GeneratedMessageLite.Builder implements InterfaceC0281au {

    /* renamed from: a */
    private int f867a;

    /* renamed from: b */
    private int f868b;

    /* renamed from: c */
    private Object f869c = "";

    private C0312by() {
        m1606g();
    }

    /* renamed from: g */
    private void m1606g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0312by m1607h() {
        return new C0312by();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0312by clear() {
        super.clear();
        this.f868b = 0;
        this.f867a &= -2;
        this.f869c = "";
        this.f867a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0312by mo5946clone() {
        return m1607h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0313bz getDefaultInstanceForType() {
        return C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0313bz build() {
        C0313bz c0313bzBuildPartial = buildPartial();
        if (!c0313bzBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0313bzBuildPartial);
        }
        return c0313bzBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0313bz buildPartial() {
        C0313bz c0313bz = new C0313bz(this);
        int i = this.f867a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0313bz.f872c = this.f868b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0313bz.f873d = this.f869c;
        c0313bz.f871b = i2;
        return c0313bz;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0312by mergeFrom(C0313bz c0313bz) {
        if (c0313bz != C0313bz.m1619a()) {
            if (c0313bz.m1625c()) {
                m1609a(c0313bz.m1626d());
            }
            if (c0313bz.m1627e()) {
                m1612a(c0313bz.m1628f());
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
    public C0312by mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f867a |= 1;
                    this.f868b = codedInputStream.readInt32();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f867a |= 2;
                    this.f869c = codedInputStream.readBytes();
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
    public C0312by m1609a(int i) {
        this.f867a |= 1;
        this.f868b = i;
        return this;
    }

    /* renamed from: a */
    public C0312by m1612a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f867a |= 2;
        this.f869c = str;
        return this;
    }
}
