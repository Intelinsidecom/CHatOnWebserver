package com.sec.chaton.p046a;

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
/* renamed from: com.sec.chaton.a.gj */
/* loaded from: classes.dex */
public final class C0964gj extends GeneratedMessageLite.Builder<C0963gi, C0964gj> implements InterfaceC0965gk {

    /* renamed from: a */
    private int f3102a;

    /* renamed from: b */
    private long f3103b;

    /* renamed from: c */
    private LazyStringList f3104c = LazyStringArrayList.EMPTY;

    /* renamed from: d */
    private List<C0892ds> f3105d = Collections.emptyList();

    /* renamed from: e */
    private Object f3106e = "";

    private C0964gj() {
        m5630g();
    }

    /* renamed from: g */
    private void m5630g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0964gj m5631h() {
        return new C0964gj();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0964gj clear() {
        super.clear();
        this.f3103b = 0L;
        this.f3102a &= -2;
        this.f3104c = LazyStringArrayList.EMPTY;
        this.f3102a &= -3;
        this.f3105d = Collections.emptyList();
        this.f3102a &= -5;
        this.f3106e = "";
        this.f3102a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0964gj mo19949clone() {
        return m5631h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0963gi getDefaultInstanceForType() {
        return C0963gi.m5611a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0963gi build() {
        C0963gi c0963giBuildPartial = buildPartial();
        if (!c0963giBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0963giBuildPartial);
        }
        return c0963giBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0963gi buildPartial() {
        C0963gi c0963gi = new C0963gi(this);
        int i = this.f3102a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0963gi.f3096c = this.f3103b;
        if ((this.f3102a & 2) == 2) {
            this.f3104c = new UnmodifiableLazyStringList(this.f3104c);
            this.f3102a &= -3;
        }
        c0963gi.f3097d = this.f3104c;
        if ((this.f3102a & 4) == 4) {
            this.f3105d = Collections.unmodifiableList(this.f3105d);
            this.f3102a &= -5;
        }
        c0963gi.f3098e = this.f3105d;
        if ((i & 8) == 8) {
            i2 |= 2;
        }
        c0963gi.f3099f = this.f3106e;
        c0963gi.f3095b = i2;
        return c0963gi;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0964gj mergeFrom(C0963gi c0963gi) {
        if (c0963gi != C0963gi.m5611a()) {
            if (c0963gi.m5620c()) {
                m5635a(c0963gi.m5621d());
            }
            if (!c0963gi.f3097d.isEmpty()) {
                if (this.f3104c.isEmpty()) {
                    this.f3104c = c0963gi.f3097d;
                    this.f3102a &= -3;
                } else {
                    m5632i();
                    this.f3104c.addAll(c0963gi.f3097d);
                }
            }
            if (!c0963gi.f3098e.isEmpty()) {
                if (this.f3105d.isEmpty()) {
                    this.f3105d = c0963gi.f3098e;
                    this.f3102a &= -5;
                } else {
                    m5633j();
                    this.f3105d.addAll(c0963gi.f3098e);
                }
            }
            if (c0963gi.m5625h()) {
                m5639a(c0963gi.m5626i());
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
    public C0964gj mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3102a |= 1;
                    this.f3103b = codedInputStream.readInt64();
                    break;
                case 18:
                    m5632i();
                    this.f3104c.add(codedInputStream.readBytes());
                    break;
                case 26:
                    C0893dt c0893dtNewBuilder = C0892ds.newBuilder();
                    codedInputStream.readMessage(c0893dtNewBuilder, extensionRegistryLite);
                    m5637a(c0893dtNewBuilder.buildPartial());
                    break;
                case 34:
                    this.f3102a |= 8;
                    this.f3106e = codedInputStream.readBytes();
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
    public C0964gj m5635a(long j) {
        this.f3102a |= 1;
        this.f3103b = j;
        return this;
    }

    /* renamed from: i */
    private void m5632i() {
        if ((this.f3102a & 2) != 2) {
            this.f3104c = new LazyStringArrayList(this.f3104c);
            this.f3102a |= 2;
        }
    }

    /* renamed from: j */
    private void m5633j() {
        if ((this.f3102a & 4) != 4) {
            this.f3105d = new ArrayList(this.f3105d);
            this.f3102a |= 4;
        }
    }

    /* renamed from: a */
    public C0964gj m5637a(C0892ds c0892ds) {
        if (c0892ds == null) {
            throw new NullPointerException();
        }
        m5633j();
        this.f3105d.add(c0892ds);
        return this;
    }

    /* renamed from: a */
    public C0964gj m5639a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3102a |= 8;
        this.f3106e = str;
        return this;
    }
}
