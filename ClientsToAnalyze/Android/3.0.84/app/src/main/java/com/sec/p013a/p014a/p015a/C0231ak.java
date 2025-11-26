package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ak */
/* loaded from: classes.dex */
public final class C0231ak extends GeneratedMessageLite.Builder<C0230aj, C0231ak> implements InterfaceC0232al {

    /* renamed from: a */
    private int f509a;

    /* renamed from: b */
    private int f510b;

    /* renamed from: c */
    private int f511c;

    /* renamed from: d */
    private Object f512d = "";

    /* renamed from: e */
    private Object f513e = "";

    /* renamed from: f */
    private Object f514f = "";

    private C0231ak() {
        m740g();
    }

    /* renamed from: g */
    private void m740g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0231ak m741h() {
        return new C0231ak();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0231ak clear() {
        super.clear();
        this.f510b = 0;
        this.f509a &= -2;
        this.f511c = 0;
        this.f509a &= -3;
        this.f512d = "";
        this.f509a &= -5;
        this.f513e = "";
        this.f509a &= -9;
        this.f514f = "";
        this.f509a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0231ak mo13386clone() {
        return m741h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0230aj getDefaultInstanceForType() {
        return C0230aj.m713a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0230aj build() {
        C0230aj c0230ajBuildPartial = buildPartial();
        if (!c0230ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0230ajBuildPartial);
        }
        return c0230ajBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0230aj m742i() throws InvalidProtocolBufferException {
        C0230aj c0230ajBuildPartial = buildPartial();
        if (!c0230ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0230ajBuildPartial).asInvalidProtocolBufferException();
        }
        return c0230ajBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0230aj buildPartial() {
        C0230aj c0230aj = new C0230aj(this);
        int i = this.f509a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0230aj.f502c = this.f510b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0230aj.f503d = this.f511c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0230aj.f504e = this.f512d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0230aj.f505f = this.f513e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0230aj.f506g = this.f514f;
        c0230aj.f501b = i2;
        return c0230aj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0231ak mergeFrom(C0230aj c0230aj) {
        if (c0230aj != C0230aj.m713a()) {
            if (c0230aj.m726c()) {
                m744a(c0230aj.m727d());
            }
            if (c0230aj.m728e()) {
                m749b(c0230aj.m729f());
            }
            if (c0230aj.m730g()) {
                m747a(c0230aj.m731h());
            }
            if (c0230aj.m732i()) {
                m750b(c0230aj.m733j());
            }
            if (c0230aj.m734k()) {
                m752c(c0230aj.m735l());
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
    public C0231ak mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f509a |= 1;
                    this.f510b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f509a |= 2;
                    this.f511c = codedInputStream.readInt32();
                    break;
                case 26:
                    this.f509a |= 4;
                    this.f512d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f509a |= 8;
                    this.f513e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f509a |= 16;
                    this.f514f = codedInputStream.readBytes();
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
    public C0231ak m744a(int i) {
        this.f509a |= 1;
        this.f510b = i;
        return this;
    }

    /* renamed from: b */
    public C0231ak m749b(int i) {
        this.f509a |= 2;
        this.f511c = i;
        return this;
    }

    /* renamed from: a */
    public C0231ak m747a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f509a |= 4;
        this.f512d = str;
        return this;
    }

    /* renamed from: b */
    public C0231ak m750b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f509a |= 8;
        this.f513e = str;
        return this;
    }

    /* renamed from: c */
    public C0231ak m752c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f509a |= 16;
        this.f514f = str;
        return this;
    }
}
