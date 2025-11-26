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
/* renamed from: com.sec.chaton.a.ds */
/* loaded from: classes.dex */
public final class C0376ds extends GeneratedMessageLite.Builder<C0375dr, C0376ds> implements InterfaceC0377dt {

    /* renamed from: a */
    private int f1317a;

    /* renamed from: b */
    private long f1318b;

    /* renamed from: i */
    private long f1325i;

    /* renamed from: c */
    private EnumC0302az f1319c = EnumC0302az.SINGLE;

    /* renamed from: d */
    private Object f1320d = "";

    /* renamed from: e */
    private Object f1321e = "";

    /* renamed from: f */
    private LazyStringList f1322f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private Object f1323g = "";

    /* renamed from: h */
    private Object f1324h = "";

    /* renamed from: j */
    private List<C0378du> f1326j = Collections.emptyList();

    private C0376ds() {
        m2605g();
    }

    /* renamed from: g */
    private void m2605g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0376ds m2606h() {
        return new C0376ds();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0376ds clear() {
        super.clear();
        this.f1318b = 0L;
        this.f1317a &= -2;
        this.f1319c = EnumC0302az.SINGLE;
        this.f1317a &= -3;
        this.f1320d = "";
        this.f1317a &= -5;
        this.f1321e = "";
        this.f1317a &= -9;
        this.f1322f = LazyStringArrayList.EMPTY;
        this.f1317a &= -17;
        this.f1323g = "";
        this.f1317a &= -33;
        this.f1324h = "";
        this.f1317a &= -65;
        this.f1325i = 0L;
        this.f1317a &= -129;
        this.f1326j = Collections.emptyList();
        this.f1317a &= -257;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0376ds mo13386clone() {
        return m2606h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0375dr getDefaultInstanceForType() {
        return C0375dr.m2568a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0375dr build() {
        C0375dr c0375drBuildPartial = buildPartial();
        if (!c0375drBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0375drBuildPartial);
        }
        return c0375drBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0375dr m2607i() throws InvalidProtocolBufferException {
        C0375dr c0375drBuildPartial = buildPartial();
        if (!c0375drBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0375drBuildPartial).asInvalidProtocolBufferException();
        }
        return c0375drBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0375dr buildPartial() {
        C0375dr c0375dr = new C0375dr(this);
        int i = this.f1317a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0375dr.f1306c = this.f1318b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0375dr.f1307d = this.f1319c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0375dr.f1308e = this.f1320d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0375dr.f1309f = this.f1321e;
        if ((this.f1317a & 16) == 16) {
            this.f1322f = new UnmodifiableLazyStringList(this.f1322f);
            this.f1317a &= -17;
        }
        c0375dr.f1310g = this.f1322f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0375dr.f1311h = this.f1323g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0375dr.f1312i = this.f1324h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0375dr.f1313j = this.f1325i;
        if ((this.f1317a & 256) == 256) {
            this.f1326j = Collections.unmodifiableList(this.f1326j);
            this.f1317a &= -257;
        }
        c0375dr.f1314k = this.f1326j;
        c0375dr.f1305b = i2;
        return c0375dr;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0376ds mergeFrom(C0375dr c0375dr) {
        if (c0375dr != C0375dr.m2568a()) {
            if (c0375dr.m2585c()) {
                m2611a(c0375dr.m2586d());
            }
            if (c0375dr.m2587e()) {
                m2613a(c0375dr.m2588f());
            }
            if (c0375dr.m2589g()) {
                m2617a(c0375dr.m2590h());
            }
            if (c0375dr.m2591i()) {
                m2620b(c0375dr.m2592j());
            }
            if (!c0375dr.f1310g.isEmpty()) {
                if (this.f1322f.isEmpty()) {
                    this.f1322f = c0375dr.f1310g;
                    this.f1317a &= -17;
                } else {
                    m2608j();
                    this.f1322f.addAll(c0375dr.f1310g);
                }
            }
            if (c0375dr.m2594l()) {
                m2624d(c0375dr.m2595m());
            }
            if (c0375dr.m2596n()) {
                m2626e(c0375dr.m2597o());
            }
            if (c0375dr.m2598p()) {
                m2619b(c0375dr.m2599q());
            }
            if (!c0375dr.f1314k.isEmpty()) {
                if (this.f1326j.isEmpty()) {
                    this.f1326j = c0375dr.f1314k;
                    this.f1317a &= -257;
                } else {
                    m2609k();
                    this.f1326j.addAll(c0375dr.f1314k);
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
    public C0376ds mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1317a |= 1;
                    this.f1318b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f1317a |= 2;
                        this.f1319c = enumC0302azM1704a;
                        break;
                    }
                case 26:
                    this.f1317a |= 4;
                    this.f1320d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1317a |= 8;
                    this.f1321e = codedInputStream.readBytes();
                    break;
                case 42:
                    m2608j();
                    this.f1322f.add(codedInputStream.readBytes());
                    break;
                case 50:
                    this.f1317a |= 32;
                    this.f1323g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f1317a |= 64;
                    this.f1324h = codedInputStream.readBytes();
                    break;
                case 64:
                    this.f1317a |= 128;
                    this.f1325i = codedInputStream.readInt64();
                    break;
                case 74:
                    C0379dv c0379dvNewBuilder = C0378du.newBuilder();
                    codedInputStream.readMessage(c0379dvNewBuilder, extensionRegistryLite);
                    m2615a(c0379dvNewBuilder.buildPartial());
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
    public C0376ds m2611a(long j) {
        this.f1317a |= 1;
        this.f1318b = j;
        return this;
    }

    /* renamed from: a */
    public C0376ds m2613a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f1317a |= 2;
        this.f1319c = enumC0302az;
        return this;
    }

    /* renamed from: a */
    public C0376ds m2617a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1317a |= 4;
        this.f1320d = str;
        return this;
    }

    /* renamed from: b */
    public C0376ds m2620b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1317a |= 8;
        this.f1321e = str;
        return this;
    }

    /* renamed from: j */
    private void m2608j() {
        if ((this.f1317a & 16) != 16) {
            this.f1322f = new LazyStringArrayList(this.f1322f);
            this.f1317a |= 16;
        }
    }

    /* renamed from: c */
    public C0376ds m2622c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m2608j();
        this.f1322f.add((LazyStringList) str);
        return this;
    }

    /* renamed from: d */
    public C0376ds m2624d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1317a |= 32;
        this.f1323g = str;
        return this;
    }

    /* renamed from: e */
    public C0376ds m2626e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1317a |= 64;
        this.f1324h = str;
        return this;
    }

    /* renamed from: b */
    public C0376ds m2619b(long j) {
        this.f1317a |= 128;
        this.f1325i = j;
        return this;
    }

    /* renamed from: k */
    private void m2609k() {
        if ((this.f1317a & 256) != 256) {
            this.f1326j = new ArrayList(this.f1326j);
            this.f1317a |= 256;
        }
    }

    /* renamed from: a */
    public C0376ds m2615a(C0378du c0378du) {
        if (c0378du == null) {
            throw new NullPointerException();
        }
        m2609k();
        this.f1326j.add(c0378du);
        return this;
    }

    /* renamed from: a */
    public C0376ds m2616a(C0379dv c0379dv) {
        m2609k();
        this.f1326j.add(c0379dv.build());
        return this;
    }
}
