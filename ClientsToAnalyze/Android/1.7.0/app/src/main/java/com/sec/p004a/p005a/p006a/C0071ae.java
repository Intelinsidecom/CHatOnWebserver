package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ae */
/* loaded from: classes.dex */
public final class C0071ae extends GeneratedMessageLite.Builder implements InterfaceC0085d {

    /* renamed from: a */
    private int f65a;

    /* renamed from: b */
    private int f66b;

    /* renamed from: c */
    private Object f67c = "";

    /* renamed from: d */
    private Object f68d = "";

    /* renamed from: e */
    private Object f69e = "";

    private C0071ae() {
        m168g();
    }

    /* renamed from: g */
    private void m168g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0071ae m169h() {
        return new C0071ae();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0071ae clear() {
        super.clear();
        this.f66b = 0;
        this.f65a &= -2;
        this.f67c = "";
        this.f65a &= -3;
        this.f68d = "";
        this.f65a &= -5;
        this.f69e = "";
        this.f65a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0071ae mo5946clone() {
        return m169h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0066a getDefaultInstanceForType() {
        return C0066a.m68a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0066a build() {
        C0066a c0066aBuildPartial = buildPartial();
        if (!c0066aBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0066aBuildPartial);
        }
        return c0066aBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0066a m170i() throws InvalidProtocolBufferException {
        C0066a c0066aBuildPartial = buildPartial();
        if (!c0066aBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0066aBuildPartial).asInvalidProtocolBufferException();
        }
        return c0066aBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0066a buildPartial() {
        C0066a c0066a = new C0066a(this);
        int i = this.f65a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0066a.f33c = this.f66b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0066a.f34d = this.f67c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0066a.f35e = this.f68d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0066a.f36f = this.f69e;
        c0066a.f32b = i2;
        return c0066a;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0071ae mergeFrom(C0066a c0066a) {
        if (c0066a != C0066a.m68a()) {
            if (c0066a.m80c()) {
                m172a(c0066a.m81d());
            }
            if (c0066a.m82e()) {
                m175a(c0066a.m83f());
            }
            if (c0066a.m84g()) {
                m177b(c0066a.m85h());
            }
            if (c0066a.m86i()) {
                m179c(c0066a.m87j());
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
    public C0071ae mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f65a |= 1;
                    this.f66b = codedInputStream.readInt32();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f65a |= 2;
                    this.f67c = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f65a |= 4;
                    this.f68d = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f65a |= 8;
                    this.f69e = codedInputStream.readBytes();
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
    public C0071ae m172a(int i) {
        this.f65a |= 1;
        this.f66b = i;
        return this;
    }

    /* renamed from: a */
    public C0071ae m175a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f65a |= 2;
        this.f67c = str;
        return this;
    }

    /* renamed from: b */
    public C0071ae m177b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f65a |= 4;
        this.f68d = str;
        return this;
    }

    /* renamed from: c */
    public C0071ae m179c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f65a |= 8;
        this.f69e = str;
        return this;
    }
}
