package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.p */
/* loaded from: classes.dex */
public final class C0251p extends GeneratedMessageLite.Builder<C0250o, C0251p> implements InterfaceC0252q {

    /* renamed from: a */
    private int f580a;

    /* renamed from: b */
    private Object f581b = "";

    /* renamed from: c */
    private LazyStringList f582c = LazyStringArrayList.EMPTY;

    private C0251p() {
        m954g();
    }

    /* renamed from: g */
    private void m954g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0251p m955h() {
        return new C0251p();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0251p clear() {
        super.clear();
        this.f581b = "";
        this.f580a &= -2;
        this.f582c = LazyStringArrayList.EMPTY;
        this.f580a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0251p mo13386clone() {
        return m955h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0250o getDefaultInstanceForType() {
        return C0250o.m939a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0250o build() {
        C0250o c0250oBuildPartial = buildPartial();
        if (!c0250oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0250oBuildPartial);
        }
        return c0250oBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0250o m956i() throws InvalidProtocolBufferException {
        C0250o c0250oBuildPartial = buildPartial();
        if (!c0250oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0250oBuildPartial).asInvalidProtocolBufferException();
        }
        return c0250oBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0250o buildPartial() {
        C0250o c0250o = new C0250o(this);
        int i = (this.f580a & 1) != 1 ? 0 : 1;
        c0250o.f576c = this.f581b;
        if ((this.f580a & 2) == 2) {
            this.f582c = new UnmodifiableLazyStringList(this.f582c);
            this.f580a &= -3;
        }
        c0250o.f577d = this.f582c;
        c0250o.f575b = i;
        return c0250o;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0251p mergeFrom(C0250o c0250o) {
        if (c0250o != C0250o.m939a()) {
            if (c0250o.m947c()) {
                m961a(c0250o.m948d());
            }
            if (!c0250o.f577d.isEmpty()) {
                if (this.f582c.isEmpty()) {
                    this.f582c = c0250o.f577d;
                    this.f580a &= -3;
                } else {
                    m957j();
                    this.f582c.addAll(c0250o.f577d);
                }
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
    public C0251p mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f580a |= 1;
                    this.f581b = codedInputStream.readBytes();
                    break;
                case 18:
                    m957j();
                    this.f582c.add(codedInputStream.readBytes());
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
    public C0251p m961a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f580a |= 1;
        this.f581b = str;
        return this;
    }

    /* renamed from: j */
    private void m957j() {
        if ((this.f580a & 2) != 2) {
            this.f582c = new LazyStringArrayList(this.f582c);
            this.f580a |= 2;
        }
    }

    /* renamed from: b */
    public C0251p m963b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m957j();
        this.f582c.add((LazyStringList) str);
        return this;
    }
}
