package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import com.sec.chaton.C0229at;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.p */
/* loaded from: classes.dex */
public final class C0087p extends GeneratedMessageLite.Builder implements InterfaceC0088q {

    /* renamed from: a */
    private int f157a;

    /* renamed from: b */
    private Object f158b = "";

    /* renamed from: c */
    private LazyStringList f159c = LazyStringArrayList.EMPTY;

    private C0087p() {
        m442g();
    }

    /* renamed from: g */
    private void m442g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0087p m443h() {
        return new C0087p();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0087p clear() {
        super.clear();
        this.f158b = "";
        this.f157a &= -2;
        this.f159c = LazyStringArrayList.EMPTY;
        this.f157a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0087p mo7542clone() {
        return m443h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0086o getDefaultInstanceForType() {
        return C0086o.m427a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0086o build() {
        C0086o c0086oBuildPartial = buildPartial();
        if (!c0086oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0086oBuildPartial);
        }
        return c0086oBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0086o m444i() throws InvalidProtocolBufferException {
        C0086o c0086oBuildPartial = buildPartial();
        if (!c0086oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0086oBuildPartial).asInvalidProtocolBufferException();
        }
        return c0086oBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0086o buildPartial() {
        C0086o c0086o = new C0086o(this);
        int i = (this.f157a & 1) != 1 ? 0 : 1;
        c0086o.f153c = this.f158b;
        if ((this.f157a & 2) == 2) {
            this.f159c = new UnmodifiableLazyStringList(this.f159c);
            this.f157a &= -3;
        }
        c0086o.f154d = this.f159c;
        c0086o.f152b = i;
        return c0086o;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0087p mergeFrom(C0086o c0086o) {
        if (c0086o != C0086o.m427a()) {
            if (c0086o.m435c()) {
                m449a(c0086o.m436d());
            }
            if (!c0086o.f154d.isEmpty()) {
                if (this.f159c.isEmpty()) {
                    this.f159c = c0086o.f154d;
                    this.f157a &= -3;
                } else {
                    m445j();
                    this.f159c.addAll(c0086o.f154d);
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
    public C0087p mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f157a |= 1;
                    this.f158b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    m445j();
                    this.f159c.add(codedInputStream.readBytes());
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
    public C0087p m449a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f157a |= 1;
        this.f158b = str;
        return this;
    }

    /* renamed from: j */
    private void m445j() {
        if ((this.f157a & 2) != 2) {
            this.f159c = new LazyStringArrayList(this.f159c);
            this.f157a |= 2;
        }
    }

    /* renamed from: b */
    public C0087p m451b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m445j();
        this.f159c.add((LazyStringList) str);
        return this;
    }
}
