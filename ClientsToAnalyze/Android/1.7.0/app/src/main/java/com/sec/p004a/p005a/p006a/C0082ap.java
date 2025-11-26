package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ap */
/* loaded from: classes.dex */
public final class C0082ap extends GeneratedMessageLite.Builder implements InterfaceC0107z {

    /* renamed from: a */
    private int f103a;

    /* renamed from: b */
    private int f104b;

    /* renamed from: e */
    private int f107e;

    /* renamed from: g */
    private int f109g;

    /* renamed from: h */
    private int f110h;

    /* renamed from: c */
    private Object f105c = "";

    /* renamed from: d */
    private Object f106d = "";

    /* renamed from: f */
    private Object f108f = "";

    /* renamed from: i */
    private Object f111i = "";

    private C0082ap() {
        m293g();
    }

    /* renamed from: g */
    private void m293g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0082ap m294h() {
        return new C0082ap();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0082ap clear() {
        super.clear();
        this.f104b = 0;
        this.f103a &= -2;
        this.f105c = "";
        this.f103a &= -3;
        this.f106d = "";
        this.f103a &= -5;
        this.f107e = 0;
        this.f103a &= -9;
        this.f108f = "";
        this.f103a &= -17;
        this.f109g = 0;
        this.f103a &= -33;
        this.f110h = 0;
        this.f103a &= -65;
        this.f111i = "";
        this.f103a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0082ap mo5946clone() {
        return m294h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0069ac getDefaultInstanceForType() {
        return C0069ac.m109a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0069ac build() {
        C0069ac c0069acBuildPartial = buildPartial();
        if (!c0069acBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0069acBuildPartial);
        }
        return c0069acBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0069ac m295i() throws InvalidProtocolBufferException {
        C0069ac c0069acBuildPartial = buildPartial();
        if (!c0069acBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0069acBuildPartial).asInvalidProtocolBufferException();
        }
        return c0069acBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0069ac buildPartial() {
        C0069ac c0069ac = new C0069ac(this);
        int i = this.f103a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0069ac.f44c = this.f104b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0069ac.f45d = this.f105c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0069ac.f46e = this.f106d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0069ac.f47f = this.f107e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0069ac.f48g = this.f108f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0069ac.f49h = this.f109g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0069ac.f50i = this.f110h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0069ac.f51j = this.f111i;
        c0069ac.f43b = i2;
        return c0069ac;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0082ap mergeFrom(C0069ac c0069ac) {
        if (c0069ac != C0069ac.m109a()) {
            if (c0069ac.m126c()) {
                m297a(c0069ac.m127d());
            }
            if (c0069ac.m128e()) {
                m300a(c0069ac.m129f());
            }
            if (c0069ac.m130g()) {
                m303b(c0069ac.m131h());
            }
            if (c0069ac.m132i()) {
                m302b(c0069ac.m133j());
            }
            if (c0069ac.m134k()) {
                m306c(c0069ac.m135l());
            }
            if (c0069ac.m136m()) {
                m305c(c0069ac.m137n());
            }
            if (c0069ac.m138o()) {
                m308d(c0069ac.m139p());
            }
            if (c0069ac.m140q()) {
                m309d(c0069ac.m141r());
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
    public C0082ap mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 16:
                    this.f103a |= 1;
                    this.f104b = codedInputStream.readInt32();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f103a |= 2;
                    this.f105c = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f103a |= 4;
                    this.f106d = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_RECEIVE_READY /* 40 */:
                    this.f103a |= 8;
                    this.f107e = codedInputStream.readInt32();
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    this.f103a |= 16;
                    this.f108f = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP2_Y_NEGATIVE /* 56 */:
                    this.f103a |= 32;
                    this.f109g = codedInputStream.readInt32();
                    break;
                case 64:
                    this.f103a |= 64;
                    this.f110h = codedInputStream.readInt32();
                    break;
                case MREvent.LOCK_EXECUTE_CAMERA_R /* 74 */:
                    this.f103a |= 128;
                    this.f111i = codedInputStream.readBytes();
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
    public C0082ap m297a(int i) {
        this.f103a |= 1;
        this.f104b = i;
        return this;
    }

    /* renamed from: a */
    public C0082ap m300a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f103a |= 2;
        this.f105c = str;
        return this;
    }

    /* renamed from: b */
    public C0082ap m303b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f103a |= 4;
        this.f106d = str;
        return this;
    }

    /* renamed from: b */
    public C0082ap m302b(int i) {
        this.f103a |= 8;
        this.f107e = i;
        return this;
    }

    /* renamed from: c */
    public C0082ap m306c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f103a |= 16;
        this.f108f = str;
        return this;
    }

    /* renamed from: c */
    public C0082ap m305c(int i) {
        this.f103a |= 32;
        this.f109g = i;
        return this;
    }

    /* renamed from: d */
    public C0082ap m308d(int i) {
        this.f103a |= 64;
        this.f110h = i;
        return this;
    }

    /* renamed from: d */
    public C0082ap m309d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f103a |= 128;
        this.f111i = str;
        return this;
    }
}
