package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.an */
/* loaded from: classes.dex */
public final class C0070an extends GeneratedMessageLite.Builder implements InterfaceC0071ao {

    /* renamed from: a */
    private int f100a;

    /* renamed from: b */
    private int f101b;

    /* renamed from: c */
    private Object f102c = "";

    /* renamed from: d */
    private Object f103d = "";

    /* renamed from: e */
    private Object f104e = "";

    private C0070an() {
        m268g();
    }

    /* renamed from: g */
    private void m268g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0070an m269h() {
        return new C0070an();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0070an clear() {
        super.clear();
        this.f101b = 0;
        this.f100a &= -2;
        this.f102c = "";
        this.f100a &= -3;
        this.f103d = "";
        this.f100a &= -5;
        this.f104e = "";
        this.f100a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0070an mo7542clone() {
        return m269h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0069am getDefaultInstanceForType() {
        return C0069am.m244a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0069am build() {
        C0069am c0069amBuildPartial = buildPartial();
        if (!c0069amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0069amBuildPartial);
        }
        return c0069amBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0069am m270i() throws InvalidProtocolBufferException {
        C0069am c0069amBuildPartial = buildPartial();
        if (!c0069amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0069amBuildPartial).asInvalidProtocolBufferException();
        }
        return c0069amBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0069am buildPartial() {
        C0069am c0069am = new C0069am(this);
        int i = this.f100a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0069am.f94c = this.f101b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0069am.f95d = this.f102c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0069am.f96e = this.f103d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0069am.f97f = this.f104e;
        c0069am.f93b = i2;
        return c0069am;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0070an mergeFrom(C0069am c0069am) {
        if (c0069am != C0069am.m244a()) {
            if (c0069am.m256c()) {
                m272a(c0069am.m257d());
            }
            if (c0069am.m258e()) {
                m275a(c0069am.m259f());
            }
            if (c0069am.m260g()) {
                m277b(c0069am.m261h());
            }
            if (c0069am.m262i()) {
                m279c(c0069am.m263j());
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
    public C0070an mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f100a |= 1;
                    this.f101b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f100a |= 2;
                    this.f102c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f100a |= 4;
                    this.f103d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f100a |= 8;
                    this.f104e = codedInputStream.readBytes();
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
    public C0070an m272a(int i) {
        this.f100a |= 1;
        this.f101b = i;
        return this;
    }

    /* renamed from: a */
    public C0070an m275a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f100a |= 2;
        this.f102c = str;
        return this;
    }

    /* renamed from: b */
    public C0070an m277b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f100a |= 4;
        this.f103d = str;
        return this;
    }

    /* renamed from: c */
    public C0070an m279c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f100a |= 8;
        this.f104e = str;
        return this;
    }
}
