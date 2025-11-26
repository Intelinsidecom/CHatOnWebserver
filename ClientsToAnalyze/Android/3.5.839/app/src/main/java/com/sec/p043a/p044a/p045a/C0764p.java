package com.sec.p043a.p044a.p045a;

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
public final class C0764p extends GeneratedMessageLite.Builder<C0763o, C0764p> implements InterfaceC0765q {

    /* renamed from: a */
    private int f1816a;

    /* renamed from: b */
    private Object f1817b = "";

    /* renamed from: c */
    private LazyStringList f1818c = LazyStringArrayList.EMPTY;

    private C0764p() {
        m2686g();
    }

    /* renamed from: g */
    private void m2686g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0764p m2687h() {
        return new C0764p();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0764p clear() {
        super.clear();
        this.f1817b = "";
        this.f1816a &= -2;
        this.f1818c = LazyStringArrayList.EMPTY;
        this.f1816a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0764p mo19949clone() {
        return m2687h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0763o getDefaultInstanceForType() {
        return C0763o.m2671a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0763o build() {
        C0763o c0763oBuildPartial = buildPartial();
        if (!c0763oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0763oBuildPartial);
        }
        return c0763oBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0763o m2688i() throws InvalidProtocolBufferException {
        C0763o c0763oBuildPartial = buildPartial();
        if (!c0763oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0763oBuildPartial).asInvalidProtocolBufferException();
        }
        return c0763oBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0763o buildPartial() {
        C0763o c0763o = new C0763o(this);
        int i = (this.f1816a & 1) != 1 ? 0 : 1;
        c0763o.f1812c = this.f1817b;
        if ((this.f1816a & 2) == 2) {
            this.f1818c = new UnmodifiableLazyStringList(this.f1818c);
            this.f1816a &= -3;
        }
        c0763o.f1813d = this.f1818c;
        c0763o.f1811b = i;
        return c0763o;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0764p mergeFrom(C0763o c0763o) {
        if (c0763o != C0763o.m2671a()) {
            if (c0763o.m2679c()) {
                m2693a(c0763o.m2680d());
            }
            if (!c0763o.f1813d.isEmpty()) {
                if (this.f1818c.isEmpty()) {
                    this.f1818c = c0763o.f1813d;
                    this.f1816a &= -3;
                } else {
                    m2689j();
                    this.f1818c.addAll(c0763o.f1813d);
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
    public C0764p mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1816a |= 1;
                    this.f1817b = codedInputStream.readBytes();
                    break;
                case 18:
                    m2689j();
                    this.f1818c.add(codedInputStream.readBytes());
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
    public C0764p m2693a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1816a |= 1;
        this.f1817b = str;
        return this;
    }

    /* renamed from: j */
    private void m2689j() {
        if ((this.f1816a & 2) != 2) {
            this.f1818c = new LazyStringArrayList(this.f1818c);
            this.f1816a |= 2;
        }
    }

    /* renamed from: b */
    public C0764p m2695b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m2689j();
        this.f1818c.add((LazyStringList) str);
        return this;
    }
}
