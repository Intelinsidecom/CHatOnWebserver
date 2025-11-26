package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ak */
/* loaded from: classes.dex */
public final class C0067ak extends GeneratedMessageLite.Builder implements InterfaceC0068al {

    /* renamed from: a */
    private int f86a;

    /* renamed from: b */
    private int f87b;

    /* renamed from: c */
    private int f88c;

    /* renamed from: d */
    private Object f89d = "";

    /* renamed from: e */
    private Object f90e = "";

    /* renamed from: f */
    private Object f91f = "";

    private C0067ak() {
        m228g();
    }

    /* renamed from: g */
    private void m228g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0067ak m229h() {
        return new C0067ak();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0067ak clear() {
        super.clear();
        this.f87b = 0;
        this.f86a &= -2;
        this.f88c = 0;
        this.f86a &= -3;
        this.f89d = "";
        this.f86a &= -5;
        this.f90e = "";
        this.f86a &= -9;
        this.f91f = "";
        this.f86a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0067ak mo7542clone() {
        return m229h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0066aj getDefaultInstanceForType() {
        return C0066aj.m201a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0066aj build() {
        C0066aj c0066ajBuildPartial = buildPartial();
        if (!c0066ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0066ajBuildPartial);
        }
        return c0066ajBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0066aj m230i() throws InvalidProtocolBufferException {
        C0066aj c0066ajBuildPartial = buildPartial();
        if (!c0066ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0066ajBuildPartial).asInvalidProtocolBufferException();
        }
        return c0066ajBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0066aj buildPartial() {
        C0066aj c0066aj = new C0066aj(this);
        int i = this.f86a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0066aj.f79c = this.f87b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0066aj.f80d = this.f88c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0066aj.f81e = this.f89d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0066aj.f82f = this.f90e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0066aj.f83g = this.f91f;
        c0066aj.f78b = i2;
        return c0066aj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0067ak mergeFrom(C0066aj c0066aj) {
        if (c0066aj != C0066aj.m201a()) {
            if (c0066aj.m214c()) {
                m232a(c0066aj.m215d());
            }
            if (c0066aj.m216e()) {
                m237b(c0066aj.m217f());
            }
            if (c0066aj.m218g()) {
                m235a(c0066aj.m219h());
            }
            if (c0066aj.m220i()) {
                m238b(c0066aj.m221j());
            }
            if (c0066aj.m222k()) {
                m240c(c0066aj.m223l());
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
    public C0067ak mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f86a |= 1;
                    this.f87b = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    this.f86a |= 2;
                    this.f88c = codedInputStream.readInt32();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f86a |= 4;
                    this.f89d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f86a |= 8;
                    this.f90e = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    this.f86a |= 16;
                    this.f91f = codedInputStream.readBytes();
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
    public C0067ak m232a(int i) {
        this.f86a |= 1;
        this.f87b = i;
        return this;
    }

    /* renamed from: b */
    public C0067ak m237b(int i) {
        this.f86a |= 2;
        this.f88c = i;
        return this;
    }

    /* renamed from: a */
    public C0067ak m235a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f86a |= 4;
        this.f89d = str;
        return this;
    }

    /* renamed from: b */
    public C0067ak m238b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f86a |= 8;
        this.f90e = str;
        return this;
    }

    /* renamed from: c */
    public C0067ak m240c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f86a |= 16;
        this.f91f = str;
        return this;
    }
}
