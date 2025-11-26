package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.av */
/* loaded from: classes.dex */
public final class C0282av extends GeneratedMessageLite.Builder implements InterfaceC0290bc {

    /* renamed from: a */
    private int f740a;

    /* renamed from: b */
    private Object f741b = "";

    /* renamed from: c */
    private Object f742c = "";

    private C0282av() {
        m1227g();
    }

    /* renamed from: g */
    private void m1227g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0282av m1228h() {
        return new C0282av();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0282av clear() {
        super.clear();
        this.f741b = "";
        this.f740a &= -2;
        this.f742c = "";
        this.f740a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0282av mo5946clone() {
        return m1228h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0261aa getDefaultInstanceForType() {
        return C0261aa.m947a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0261aa build() {
        C0261aa c0261aaBuildPartial = buildPartial();
        if (!c0261aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0261aaBuildPartial);
        }
        return c0261aaBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0261aa buildPartial() {
        C0261aa c0261aa = new C0261aa(this);
        int i = this.f740a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0261aa.f643c = this.f741b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0261aa.f644d = this.f742c;
        c0261aa.f642b = i2;
        return c0261aa;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0282av mergeFrom(C0261aa c0261aa) {
        if (c0261aa != C0261aa.m947a()) {
            if (c0261aa.m955c()) {
                m1232a(c0261aa.m956d());
            }
            if (c0261aa.m957e()) {
                m1234b(c0261aa.m958f());
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
    public C0282av mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f740a |= 1;
                    this.f741b = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f740a |= 2;
                    this.f742c = codedInputStream.readBytes();
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
    public C0282av m1232a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f740a |= 1;
        this.f741b = str;
        return this;
    }

    /* renamed from: b */
    public C0282av m1234b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f740a |= 2;
        this.f742c = str;
        return this;
    }
}
