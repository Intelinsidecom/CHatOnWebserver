package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.v */
/* loaded from: classes.dex */
public final class C0986v extends GeneratedMessageLite.Builder<C0985u, C0986v> implements InterfaceC0987w {

    /* renamed from: a */
    private int f3228a;

    /* renamed from: b */
    private Object f3229b = "";

    /* renamed from: c */
    private List<C0988x> f3230c = Collections.emptyList();

    /* renamed from: d */
    private C0935fh f3231d = C0935fh.m5211a();

    /* renamed from: e */
    private Object f3232e = "";

    /* renamed from: f */
    private long f3233f;

    private C0986v() {
        m5985k();
    }

    /* renamed from: k */
    private void m5985k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0986v m5986l() {
        return new C0986v();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0986v clear() {
        super.clear();
        this.f3229b = "";
        this.f3228a &= -2;
        this.f3230c = Collections.emptyList();
        this.f3228a &= -3;
        this.f3231d = C0935fh.m5211a();
        this.f3228a &= -5;
        this.f3232e = "";
        this.f3228a &= -9;
        this.f3233f = 0L;
        this.f3228a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0986v mo19949clone() {
        return m5986l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0985u getDefaultInstanceForType() {
        return C0985u.m5962a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0985u build() {
        C0985u c0985uBuildPartial = buildPartial();
        if (!c0985uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0985uBuildPartial);
        }
        return c0985uBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0985u m5987m() throws InvalidProtocolBufferException {
        C0985u c0985uBuildPartial = buildPartial();
        if (!c0985uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0985uBuildPartial).asInvalidProtocolBufferException();
        }
        return c0985uBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0985u buildPartial() {
        C0985u c0985u = new C0985u(this);
        int i = this.f3228a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0985u.f3221c = this.f3229b;
        if ((this.f3228a & 2) == 2) {
            this.f3230c = Collections.unmodifiableList(this.f3230c);
            this.f3228a &= -3;
        }
        c0985u.f3222d = this.f3230c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0985u.f3223e = this.f3231d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0985u.f3224f = this.f3232e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0985u.f3225g = this.f3233f;
        c0985u.f3220b = i2;
        return c0985u;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0986v mergeFrom(C0985u c0985u) {
        if (c0985u != C0985u.m5962a()) {
            if (c0985u.m5973c()) {
                m5995a(c0985u.m5974d());
            }
            if (!c0985u.f3222d.isEmpty()) {
                if (this.f3230c.isEmpty()) {
                    this.f3230c = c0985u.f3222d;
                    this.f3228a &= -3;
                } else {
                    m5988n();
                    this.f3230c.addAll(c0985u.f3222d);
                }
            }
            if (c0985u.m5975e()) {
                m5998b(c0985u.m5976f());
            }
            if (c0985u.m5977g()) {
                m5999b(c0985u.m5978h());
            }
            if (c0985u.m5979i()) {
                m5990a(c0985u.m5980j());
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
    public C0986v mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f3228a |= 1;
                    this.f3229b = codedInputStream.readBytes();
                    break;
                case 18:
                    MessageLite.Builder builderNewBuilder = C0988x.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m5994a(builderNewBuilder.buildPartial());
                    break;
                case 26:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m6005h()) {
                        c0936fiNewBuilder.mergeFrom(m6006i());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m5992a(c0936fiNewBuilder.buildPartial());
                    break;
                case 34:
                    this.f3228a |= 8;
                    this.f3232e = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f3228a |= 16;
                    this.f3233f = codedInputStream.readInt64();
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
    public C0986v m5995a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3228a |= 1;
        this.f3229b = str;
        return this;
    }

    /* renamed from: n */
    private void m5988n() {
        if ((this.f3228a & 2) != 2) {
            this.f3230c = new ArrayList(this.f3230c);
            this.f3228a |= 2;
        }
    }

    /* renamed from: f */
    public List<C0988x> m6003f() {
        return Collections.unmodifiableList(this.f3230c);
    }

    /* renamed from: g */
    public int m6004g() {
        return this.f3230c.size();
    }

    /* renamed from: a */
    public C0988x m5996a(int i) {
        return this.f3230c.get(i);
    }

    /* renamed from: a */
    public C0986v m5994a(C0988x c0988x) {
        if (c0988x == null) {
            throw new NullPointerException();
        }
        m5988n();
        this.f3230c.add(c0988x);
        return this;
    }

    /* renamed from: h */
    public boolean m6005h() {
        return (this.f3228a & 4) == 4;
    }

    /* renamed from: i */
    public C0935fh m6006i() {
        return this.f3231d;
    }

    /* renamed from: a */
    public C0986v m5992a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f3231d = c0935fh;
        this.f3228a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0986v m5998b(C0935fh c0935fh) {
        if ((this.f3228a & 4) == 4 && this.f3231d != C0935fh.m5211a()) {
            this.f3231d = C0935fh.m5212a(this.f3231d).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f3231d = c0935fh;
        }
        this.f3228a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0986v m5999b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3228a |= 8;
        this.f3232e = str;
        return this;
    }

    /* renamed from: a */
    public C0986v m5990a(long j) {
        this.f3228a |= 16;
        this.f3233f = j;
        return this;
    }
}
