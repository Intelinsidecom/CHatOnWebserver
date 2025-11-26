package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.an */
/* loaded from: classes.dex */
public final class C0080an extends GeneratedMessageLite.Builder implements InterfaceC0099r {

    /* renamed from: a */
    private int f99a;

    /* renamed from: b */
    private int f100b;

    /* renamed from: c */
    private int f101c;

    /* renamed from: d */
    private Object f102d = "";

    private C0080an() {
        m278g();
    }

    /* renamed from: g */
    private void m278g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0080an m279h() {
        return new C0080an();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0080an clear() {
        super.clear();
        this.f100b = 0;
        this.f99a &= -2;
        this.f101c = 0;
        this.f99a &= -3;
        this.f102d = "";
        this.f99a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0080an mo5946clone() {
        return m279h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0084c getDefaultInstanceForType() {
        return C0084c.m330a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0084c build() {
        C0084c c0084cBuildPartial = buildPartial();
        if (!c0084cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0084cBuildPartial);
        }
        return c0084cBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0084c m280i() throws InvalidProtocolBufferException {
        C0084c c0084cBuildPartial = buildPartial();
        if (!c0084cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0084cBuildPartial).asInvalidProtocolBufferException();
        }
        return c0084cBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0084c buildPartial() {
        C0084c c0084c = new C0084c(this);
        int i = this.f99a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0084c.f120c = this.f100b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0084c.f121d = this.f101c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0084c.f122e = this.f102d;
        c0084c.f119b = i2;
        return c0084c;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0080an mergeFrom(C0084c c0084c) {
        if (c0084c != C0084c.m330a()) {
            if (c0084c.m338c()) {
                m282a(c0084c.m339d());
            }
            if (c0084c.m340e()) {
                m287b(c0084c.m341f());
            }
            if (c0084c.m342g()) {
                m285a(c0084c.m343h());
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
    public C0080an mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f99a |= 1;
                    this.f100b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f99a |= 2;
                    this.f101c = codedInputStream.readInt32();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f99a |= 4;
                    this.f102d = codedInputStream.readBytes();
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
    public C0080an m282a(int i) {
        this.f99a |= 1;
        this.f100b = i;
        return this;
    }

    /* renamed from: b */
    public C0080an m287b(int i) {
        this.f99a |= 2;
        this.f101c = i;
        return this;
    }

    /* renamed from: a */
    public C0080an m285a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f99a |= 4;
        this.f102d = str;
        return this;
    }
}
