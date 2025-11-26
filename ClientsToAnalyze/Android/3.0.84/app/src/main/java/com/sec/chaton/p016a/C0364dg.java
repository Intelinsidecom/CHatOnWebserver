package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dg */
/* loaded from: classes.dex */
public final class C0364dg extends GeneratedMessageLite.Builder<C0363df, C0364dg> implements InterfaceC0365dh {

    /* renamed from: a */
    private int f1269a;

    /* renamed from: b */
    private long f1270b;

    /* renamed from: c */
    private LazyStringList f1271c = LazyStringArrayList.EMPTY;

    private C0364dg() {
        m2450g();
    }

    /* renamed from: g */
    private void m2450g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0364dg m2451h() {
        return new C0364dg();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0364dg clear() {
        super.clear();
        this.f1270b = 0L;
        this.f1269a &= -2;
        this.f1271c = LazyStringArrayList.EMPTY;
        this.f1269a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0364dg mo13386clone() {
        return m2451h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0363df getDefaultInstanceForType() {
        return C0363df.m2437a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0363df build() {
        C0363df c0363dfBuildPartial = buildPartial();
        if (!c0363dfBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0363dfBuildPartial);
        }
        return c0363dfBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0363df m2452i() throws InvalidProtocolBufferException {
        C0363df c0363dfBuildPartial = buildPartial();
        if (!c0363dfBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0363dfBuildPartial).asInvalidProtocolBufferException();
        }
        return c0363dfBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0363df buildPartial() {
        C0363df c0363df = new C0363df(this);
        int i = (this.f1269a & 1) != 1 ? 0 : 1;
        c0363df.f1265c = this.f1270b;
        if ((this.f1269a & 2) == 2) {
            this.f1271c = new UnmodifiableLazyStringList(this.f1271c);
            this.f1269a &= -3;
        }
        c0363df.f1266d = this.f1271c;
        c0363df.f1264b = i;
        return c0363df;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0364dg mergeFrom(C0363df c0363df) {
        if (c0363df != C0363df.m2437a()) {
            if (c0363df.m2443c()) {
                m2455a(c0363df.m2444d());
            }
            if (!c0363df.f1266d.isEmpty()) {
                if (this.f1271c.isEmpty()) {
                    this.f1271c = c0363df.f1266d;
                    this.f1269a &= -3;
                } else {
                    m2453j();
                    this.f1271c.addAll(c0363df.f1266d);
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
    public C0364dg mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1269a |= 1;
                    this.f1270b = codedInputStream.readInt64();
                    break;
                case 18:
                    m2453j();
                    this.f1271c.add(codedInputStream.readBytes());
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
    public C0364dg m2455a(long j) {
        this.f1269a |= 1;
        this.f1270b = j;
        return this;
    }

    /* renamed from: j */
    private void m2453j() {
        if ((this.f1269a & 2) != 2) {
            this.f1271c = new LazyStringArrayList(this.f1271c);
            this.f1269a |= 2;
        }
    }
}
