package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.j */
/* loaded from: classes.dex */
public final class C0245j extends GeneratedMessageLite.Builder<C0244i, C0245j> implements InterfaceC0246k {

    /* renamed from: a */
    private int f561a;

    /* renamed from: b */
    private int f562b;

    /* renamed from: c */
    private int f563c;

    /* renamed from: d */
    private Object f564d = "";

    private C0245j() {
        m895g();
    }

    /* renamed from: g */
    private void m895g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0245j m896h() {
        return new C0245j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0245j clear() {
        super.clear();
        this.f562b = 0;
        this.f561a &= -2;
        this.f563c = 0;
        this.f561a &= -3;
        this.f564d = "";
        this.f561a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0245j mo13386clone() {
        return m896h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0244i getDefaultInstanceForType() {
        return C0244i.m876a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0244i build() {
        C0244i c0244iBuildPartial = buildPartial();
        if (!c0244iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0244iBuildPartial);
        }
        return c0244iBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0244i m897i() throws InvalidProtocolBufferException {
        C0244i c0244iBuildPartial = buildPartial();
        if (!c0244iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0244iBuildPartial).asInvalidProtocolBufferException();
        }
        return c0244iBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0244i buildPartial() {
        C0244i c0244i = new C0244i(this);
        int i = this.f561a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0244i.f556c = this.f562b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0244i.f557d = this.f563c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0244i.f558e = this.f564d;
        c0244i.f555b = i2;
        return c0244i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0245j mergeFrom(C0244i c0244i) {
        if (c0244i != C0244i.m876a()) {
            if (c0244i.m885c()) {
                m899a(c0244i.m886d());
            }
            if (c0244i.m887e()) {
                m904b(c0244i.m888f());
            }
            if (c0244i.m889g()) {
                m902a(c0244i.m890h());
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
    public C0245j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f561a |= 1;
                    this.f562b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f561a |= 2;
                    this.f563c = codedInputStream.readInt32();
                    break;
                case 26:
                    this.f561a |= 4;
                    this.f564d = codedInputStream.readBytes();
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
    public C0245j m899a(int i) {
        this.f561a |= 1;
        this.f562b = i;
        return this;
    }

    /* renamed from: b */
    public C0245j m904b(int i) {
        this.f561a |= 2;
        this.f563c = i;
        return this;
    }

    /* renamed from: a */
    public C0245j m902a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f561a |= 4;
        this.f564d = str;
        return this;
    }
}
