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
/* renamed from: com.sec.chaton.a.ee */
/* loaded from: classes.dex */
public final class C0389ee extends GeneratedMessageLite.Builder<C0388ed, C0389ee> implements InterfaceC0390ef {

    /* renamed from: a */
    private int f1366a;

    /* renamed from: b */
    private long f1367b;

    /* renamed from: c */
    private LazyStringList f1368c = LazyStringArrayList.EMPTY;

    /* renamed from: d */
    private List<C0351cu> f1369d = Collections.emptyList();

    /* renamed from: e */
    private Object f1370e = "";

    private C0389ee() {
        m2737g();
    }

    /* renamed from: g */
    private void m2737g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0389ee m2738h() {
        return new C0389ee();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0389ee clear() {
        super.clear();
        this.f1367b = 0L;
        this.f1366a &= -2;
        this.f1368c = LazyStringArrayList.EMPTY;
        this.f1366a &= -3;
        this.f1369d = Collections.emptyList();
        this.f1366a &= -5;
        this.f1370e = "";
        this.f1366a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0389ee mo13386clone() {
        return m2738h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0388ed getDefaultInstanceForType() {
        return C0388ed.m2718a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0388ed build() {
        C0388ed c0388edBuildPartial = buildPartial();
        if (!c0388edBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0388edBuildPartial);
        }
        return c0388edBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0388ed buildPartial() {
        C0388ed c0388ed = new C0388ed(this);
        int i = this.f1366a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0388ed.f1360c = this.f1367b;
        if ((this.f1366a & 2) == 2) {
            this.f1368c = new UnmodifiableLazyStringList(this.f1368c);
            this.f1366a &= -3;
        }
        c0388ed.f1361d = this.f1368c;
        if ((this.f1366a & 4) == 4) {
            this.f1369d = Collections.unmodifiableList(this.f1369d);
            this.f1366a &= -5;
        }
        c0388ed.f1362e = this.f1369d;
        if ((i & 8) == 8) {
            i2 |= 2;
        }
        c0388ed.f1363f = this.f1370e;
        c0388ed.f1359b = i2;
        return c0388ed;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0389ee mergeFrom(C0388ed c0388ed) {
        if (c0388ed != C0388ed.m2718a()) {
            if (c0388ed.m2727c()) {
                m2742a(c0388ed.m2728d());
            }
            if (!c0388ed.f1361d.isEmpty()) {
                if (this.f1368c.isEmpty()) {
                    this.f1368c = c0388ed.f1361d;
                    this.f1366a &= -3;
                } else {
                    m2739i();
                    this.f1368c.addAll(c0388ed.f1361d);
                }
            }
            if (!c0388ed.f1362e.isEmpty()) {
                if (this.f1369d.isEmpty()) {
                    this.f1369d = c0388ed.f1362e;
                    this.f1366a &= -5;
                } else {
                    m2740j();
                    this.f1369d.addAll(c0388ed.f1362e);
                }
            }
            if (c0388ed.m2732h()) {
                m2746a(c0388ed.m2733i());
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
    public C0389ee mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1366a |= 1;
                    this.f1367b = codedInputStream.readInt64();
                    break;
                case 18:
                    m2739i();
                    this.f1368c.add(codedInputStream.readBytes());
                    break;
                case 26:
                    C0352cv c0352cvNewBuilder = C0351cu.newBuilder();
                    codedInputStream.readMessage(c0352cvNewBuilder, extensionRegistryLite);
                    m2744a(c0352cvNewBuilder.buildPartial());
                    break;
                case 34:
                    this.f1366a |= 8;
                    this.f1370e = codedInputStream.readBytes();
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
    public C0389ee m2742a(long j) {
        this.f1366a |= 1;
        this.f1367b = j;
        return this;
    }

    /* renamed from: i */
    private void m2739i() {
        if ((this.f1366a & 2) != 2) {
            this.f1368c = new LazyStringArrayList(this.f1368c);
            this.f1366a |= 2;
        }
    }

    /* renamed from: j */
    private void m2740j() {
        if ((this.f1366a & 4) != 4) {
            this.f1369d = new ArrayList(this.f1369d);
            this.f1366a |= 4;
        }
    }

    /* renamed from: a */
    public C0389ee m2744a(C0351cu c0351cu) {
        if (c0351cu == null) {
            throw new NullPointerException();
        }
        m2740j();
        this.f1369d.add(c0351cu);
        return this;
    }

    /* renamed from: a */
    public C0389ee m2746a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1366a |= 8;
        this.f1370e = str;
        return this;
    }
}
