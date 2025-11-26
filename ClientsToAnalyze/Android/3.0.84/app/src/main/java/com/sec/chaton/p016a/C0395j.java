package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.j */
/* loaded from: classes.dex */
public final class C0395j extends GeneratedMessageLite.Builder<C0394i, C0395j> implements InterfaceC0396k {

    /* renamed from: a */
    private int f1406a;

    /* renamed from: b */
    private long f1407b;

    /* renamed from: f */
    private long f1411f;

    /* renamed from: c */
    private Object f1408c = "";

    /* renamed from: d */
    private List<C0283ag> f1409d = Collections.emptyList();

    /* renamed from: e */
    private LazyStringList f1410e = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private Object f1412g = "";

    private C0395j() {
        m2849g();
    }

    /* renamed from: g */
    private void m2849g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0395j m2850h() {
        return new C0395j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0395j clear() {
        super.clear();
        this.f1407b = 0L;
        this.f1406a &= -2;
        this.f1408c = "";
        this.f1406a &= -3;
        this.f1409d = Collections.emptyList();
        this.f1406a &= -5;
        this.f1410e = LazyStringArrayList.EMPTY;
        this.f1406a &= -9;
        this.f1411f = 0L;
        this.f1406a &= -17;
        this.f1412g = "";
        this.f1406a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0395j mo13386clone() {
        return m2850h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0394i getDefaultInstanceForType() {
        return C0394i.m2819a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0394i build() {
        C0394i c0394iBuildPartial = buildPartial();
        if (!c0394iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0394iBuildPartial);
        }
        return c0394iBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0394i m2851i() throws InvalidProtocolBufferException {
        C0394i c0394iBuildPartial = buildPartial();
        if (!c0394iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0394iBuildPartial).asInvalidProtocolBufferException();
        }
        return c0394iBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0394i buildPartial() {
        C0394i c0394i = new C0394i(this);
        int i = this.f1406a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0394i.f1398c = this.f1407b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0394i.f1399d = this.f1408c;
        if ((this.f1406a & 4) == 4) {
            this.f1409d = Collections.unmodifiableList(this.f1409d);
            this.f1406a &= -5;
        }
        c0394i.f1400e = this.f1409d;
        if ((this.f1406a & 8) == 8) {
            this.f1410e = new UnmodifiableLazyStringList(this.f1410e);
            this.f1406a &= -9;
        }
        c0394i.f1401f = this.f1410e;
        if ((i & 16) == 16) {
            i2 |= 4;
        }
        c0394i.f1402g = this.f1411f;
        if ((i & 32) == 32) {
            i2 |= 8;
        }
        c0394i.f1403h = this.f1412g;
        c0394i.f1397b = i2;
        return c0394i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0395j mergeFrom(C0394i c0394i) {
        if (c0394i != C0394i.m2819a()) {
            if (c0394i.m2833c()) {
                m2855a(c0394i.m2834d());
            }
            if (c0394i.m2835e()) {
                m2859a(c0394i.m2836f());
            }
            if (!c0394i.f1400e.isEmpty()) {
                if (this.f1409d.isEmpty()) {
                    this.f1409d = c0394i.f1400e;
                    this.f1406a &= -5;
                } else {
                    m2852j();
                    this.f1409d.addAll(c0394i.f1400e);
                }
            }
            if (!c0394i.f1401f.isEmpty()) {
                if (this.f1410e.isEmpty()) {
                    this.f1410e = c0394i.f1401f;
                    this.f1406a &= -9;
                } else {
                    m2853k();
                    this.f1410e.addAll(c0394i.f1401f);
                }
            }
            if (c0394i.m2841k()) {
                m2861b(c0394i.m2842l());
            }
            if (c0394i.m2843m()) {
                m2862b(c0394i.m2844n());
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
    public C0395j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1406a |= 1;
                    this.f1407b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f1406a |= 2;
                    this.f1408c = codedInputStream.readBytes();
                    break;
                case 26:
                    C0284ah c0284ahNewBuilder = C0283ag.newBuilder();
                    codedInputStream.readMessage(c0284ahNewBuilder, extensionRegistryLite);
                    m2857a(c0284ahNewBuilder.buildPartial());
                    break;
                case 34:
                    m2853k();
                    this.f1410e.add(codedInputStream.readBytes());
                    break;
                case 40:
                    this.f1406a |= 16;
                    this.f1411f = codedInputStream.readInt64();
                    break;
                case 50:
                    this.f1406a |= 32;
                    this.f1412g = codedInputStream.readBytes();
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
    public C0395j m2855a(long j) {
        this.f1406a |= 1;
        this.f1407b = j;
        return this;
    }

    /* renamed from: a */
    public C0395j m2859a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1406a |= 2;
        this.f1408c = str;
        return this;
    }

    /* renamed from: j */
    private void m2852j() {
        if ((this.f1406a & 4) != 4) {
            this.f1409d = new ArrayList(this.f1409d);
            this.f1406a |= 4;
        }
    }

    /* renamed from: a */
    public C0395j m2857a(C0283ag c0283ag) {
        if (c0283ag == null) {
            throw new NullPointerException();
        }
        m2852j();
        this.f1409d.add(c0283ag);
        return this;
    }

    /* renamed from: k */
    private void m2853k() {
        if ((this.f1406a & 8) != 8) {
            this.f1410e = new LazyStringArrayList(this.f1410e);
            this.f1406a |= 8;
        }
    }

    /* renamed from: b */
    public C0395j m2861b(long j) {
        this.f1406a |= 16;
        this.f1411f = j;
        return this;
    }

    /* renamed from: b */
    public C0395j m2862b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1406a |= 32;
        this.f1412g = str;
        return this;
    }
}
