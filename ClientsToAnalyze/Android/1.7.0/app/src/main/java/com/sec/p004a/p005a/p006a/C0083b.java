package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.b */
/* loaded from: classes.dex */
public final class C0083b extends GeneratedMessageLite.Builder implements InterfaceC0079am {

    /* renamed from: a */
    private int f112a;

    /* renamed from: b */
    private Object f113b = "";

    /* renamed from: c */
    private Object f114c = "";

    /* renamed from: d */
    private Object f115d = "";

    /* renamed from: e */
    private Object f116e = "";

    /* renamed from: f */
    private Object f117f = "";

    private C0083b() {
        m313g();
    }

    /* renamed from: g */
    private void m313g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0083b m314h() {
        return new C0083b();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0083b clear() {
        super.clear();
        this.f113b = "";
        this.f112a &= -2;
        this.f114c = "";
        this.f112a &= -3;
        this.f115d = "";
        this.f112a &= -5;
        this.f116e = "";
        this.f112a &= -9;
        this.f117f = "";
        this.f112a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0083b mo5946clone() {
        return m314h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0096o getDefaultInstanceForType() {
        return C0096o.m458a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0096o build() {
        C0096o c0096oBuildPartial = buildPartial();
        if (!c0096oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0096oBuildPartial);
        }
        return c0096oBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0096o m315i() throws InvalidProtocolBufferException {
        C0096o c0096oBuildPartial = buildPartial();
        if (!c0096oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0096oBuildPartial).asInvalidProtocolBufferException();
        }
        return c0096oBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0096o buildPartial() {
        C0096o c0096o = new C0096o(this);
        int i = this.f112a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0096o.f164c = this.f113b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0096o.f165d = this.f114c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0096o.f166e = this.f115d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0096o.f167f = this.f116e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0096o.f168g = this.f117f;
        c0096o.f163b = i2;
        return c0096o;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0083b mergeFrom(C0096o c0096o) {
        if (c0096o != C0096o.m458a()) {
            if (c0096o.m472c()) {
                m319a(c0096o.m473d());
            }
            if (c0096o.m474e()) {
                m321b(c0096o.m475f());
            }
            if (c0096o.m476g()) {
                m322c(c0096o.m477h());
            }
            if (c0096o.m478i()) {
                m324d(c0096o.m479j());
            }
            if (c0096o.m480k()) {
                m326e(c0096o.m481l());
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
    public C0083b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f112a |= 1;
                    this.f113b = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f112a |= 2;
                    this.f114c = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f112a |= 4;
                    this.f115d = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    this.f112a |= 8;
                    this.f116e = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    this.f112a |= 16;
                    this.f117f = codedInputStream.readBytes();
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
    public C0083b m319a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f112a |= 1;
        this.f113b = str;
        return this;
    }

    /* renamed from: b */
    public C0083b m321b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f112a |= 2;
        this.f114c = str;
        return this;
    }

    /* renamed from: c */
    public C0083b m322c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f112a |= 4;
        this.f115d = str;
        return this;
    }

    /* renamed from: d */
    public C0083b m324d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f112a |= 8;
        this.f116e = str;
        return this;
    }

    /* renamed from: e */
    public C0083b m326e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f112a |= 16;
        this.f117f = str;
        return this;
    }
}
