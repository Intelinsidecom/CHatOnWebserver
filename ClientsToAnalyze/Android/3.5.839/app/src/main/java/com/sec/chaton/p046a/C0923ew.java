package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ew */
/* loaded from: classes.dex */
public final class C0923ew extends GeneratedMessageLite.Builder<C0922ev, C0923ew> implements InterfaceC0924ex {

    /* renamed from: a */
    private int f2887a;

    /* renamed from: b */
    private Object f2888b = "";

    /* renamed from: c */
    private List<C0925ey> f2889c = Collections.emptyList();

    /* renamed from: d */
    private long f2890d;

    private C0923ew() {
        m5020g();
    }

    /* renamed from: g */
    private void m5020g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0923ew m5021h() {
        return new C0923ew();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0923ew clear() {
        super.clear();
        this.f2888b = "";
        this.f2887a &= -2;
        this.f2889c = Collections.emptyList();
        this.f2887a &= -3;
        this.f2890d = 0L;
        this.f2887a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0923ew mo19949clone() {
        return m5021h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0922ev getDefaultInstanceForType() {
        return C0922ev.m5002a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0922ev build() {
        C0922ev c0922evBuildPartial = buildPartial();
        if (!c0922evBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0922evBuildPartial);
        }
        return c0922evBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0922ev m5022i() throws InvalidProtocolBufferException {
        C0922ev c0922evBuildPartial = buildPartial();
        if (!c0922evBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0922evBuildPartial).asInvalidProtocolBufferException();
        }
        return c0922evBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0922ev buildPartial() {
        C0922ev c0922ev = new C0922ev(this);
        int i = this.f2887a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0922ev.f2882c = this.f2888b;
        if ((this.f2887a & 2) == 2) {
            this.f2889c = Collections.unmodifiableList(this.f2889c);
            this.f2887a &= -3;
        }
        c0922ev.f2883d = this.f2889c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0922ev.f2884e = this.f2890d;
        c0922ev.f2881b = i2;
        return c0922ev;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0923ew mergeFrom(C0922ev c0922ev) {
        if (c0922ev != C0922ev.m5002a()) {
            if (c0922ev.m5011c()) {
                m5029a(c0922ev.m5012d());
            }
            if (!c0922ev.f2883d.isEmpty()) {
                if (this.f2889c.isEmpty()) {
                    this.f2889c = c0922ev.f2883d;
                    this.f2887a &= -3;
                } else {
                    m5023j();
                    this.f2889c.addAll(c0922ev.f2883d);
                }
            }
            if (c0922ev.m5014f()) {
                m5025a(c0922ev.m5015g());
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
    public C0923ew mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2887a |= 1;
                    this.f2888b = codedInputStream.readBytes();
                    break;
                case 18:
                    C0926ez c0926ezNewBuilder = C0925ey.newBuilder();
                    codedInputStream.readMessage(c0926ezNewBuilder, extensionRegistryLite);
                    m5028a(c0926ezNewBuilder.buildPartial());
                    break;
                case 24:
                    this.f2887a |= 4;
                    this.f2890d = codedInputStream.readInt64();
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
    public C0923ew m5029a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2887a |= 1;
        this.f2888b = str;
        return this;
    }

    /* renamed from: j */
    private void m5023j() {
        if ((this.f2887a & 2) != 2) {
            this.f2889c = new ArrayList(this.f2889c);
            this.f2887a |= 2;
        }
    }

    /* renamed from: a */
    public C0923ew m5028a(C0925ey c0925ey) {
        if (c0925ey == null) {
            throw new NullPointerException();
        }
        m5023j();
        this.f2889c.add(c0925ey);
        return this;
    }

    /* renamed from: a */
    public C0923ew m5025a(long j) {
        this.f2887a |= 4;
        this.f2890d = j;
        return this;
    }
}
