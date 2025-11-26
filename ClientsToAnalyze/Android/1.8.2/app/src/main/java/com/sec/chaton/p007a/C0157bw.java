package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import com.sec.chaton.C0229at;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bw */
/* loaded from: classes.dex */
public final class C0157bw extends GeneratedMessageLite.Builder implements InterfaceC0158bx {

    /* renamed from: a */
    private int f572a;

    /* renamed from: b */
    private long f573b;

    /* renamed from: c */
    private EnumC0159by f574c = EnumC0159by.TEXT;

    /* renamed from: d */
    private Object f575d = "";

    /* renamed from: e */
    private Object f576e = "";

    /* renamed from: f */
    private LazyStringList f577f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private LazyStringList f578g = LazyStringArrayList.EMPTY;

    private C0157bw() {
        m1323m();
    }

    /* renamed from: m */
    private void m1323m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static C0157bw m1324n() {
        return new C0157bw();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0157bw clear() {
        super.clear();
        this.f573b = 0L;
        this.f572a &= -2;
        this.f574c = EnumC0159by.TEXT;
        this.f572a &= -3;
        this.f575d = "";
        this.f572a &= -5;
        this.f576e = "";
        this.f572a &= -9;
        this.f577f = LazyStringArrayList.EMPTY;
        this.f572a &= -17;
        this.f578g = LazyStringArrayList.EMPTY;
        this.f572a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0157bw mo7542clone() {
        return m1324n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0156bv getDefaultInstanceForType() {
        return C0156bv.m1296a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0156bv build() {
        C0156bv c0156bvBuildPartial = buildPartial();
        if (!c0156bvBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0156bvBuildPartial);
        }
        return c0156bvBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public C0156bv m1325o() throws InvalidProtocolBufferException {
        C0156bv c0156bvBuildPartial = buildPartial();
        if (!c0156bvBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0156bvBuildPartial).asInvalidProtocolBufferException();
        }
        return c0156bvBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0156bv buildPartial() {
        C0156bv c0156bv = new C0156bv(this);
        int i = this.f572a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0156bv.f564c = this.f573b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0156bv.f565d = this.f574c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0156bv.f566e = this.f575d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0156bv.f567f = this.f576e;
        if ((this.f572a & 16) == 16) {
            this.f577f = new UnmodifiableLazyStringList(this.f577f);
            this.f572a &= -17;
        }
        c0156bv.f568g = this.f577f;
        if ((this.f572a & 32) == 32) {
            this.f578g = new UnmodifiableLazyStringList(this.f578g);
            this.f572a &= -33;
        }
        c0156bv.f569h = this.f578g;
        c0156bv.f563b = i2;
        return c0156bv;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0157bw mergeFrom(C0156bv c0156bv) {
        if (c0156bv != C0156bv.m1296a()) {
            if (c0156bv.m1309c()) {
                m1329a(c0156bv.m1310d());
            }
            if (c0156bv.m1311e()) {
                m1332a(c0156bv.m1312f());
            }
            if (c0156bv.m1313g()) {
                m1333a(c0156bv.m1314h());
            }
            if (c0156bv.m1315i()) {
                m1335b(c0156bv.m1316j());
            }
            if (!c0156bv.f568g.isEmpty()) {
                if (this.f577f.isEmpty()) {
                    this.f577f = c0156bv.f568g;
                    this.f572a &= -17;
                } else {
                    m1326p();
                    this.f577f.addAll(c0156bv.f568g);
                }
            }
            if (!c0156bv.f569h.isEmpty()) {
                if (this.f578g.isEmpty()) {
                    this.f578g = c0156bv.f569h;
                    this.f572a &= -33;
                } else {
                    m1327q();
                    this.f578g.addAll(c0156bv.f569h);
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
    public C0157bw mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f572a |= 1;
                    this.f573b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    EnumC0159by enumC0159byM1347a = EnumC0159by.m1347a(codedInputStream.readEnum());
                    if (enumC0159byM1347a == null) {
                        break;
                    } else {
                        this.f572a |= 2;
                        this.f574c = enumC0159byM1347a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f572a |= 4;
                    this.f575d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f572a |= 8;
                    this.f576e = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    m1326p();
                    this.f577f.add(codedInputStream.readBytes());
                    break;
                case 50:
                    m1327q();
                    this.f578g.add(codedInputStream.readBytes());
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

    /* renamed from: f */
    public long m1341f() {
        return this.f573b;
    }

    /* renamed from: a */
    public C0157bw m1329a(long j) {
        this.f572a |= 1;
        this.f573b = j;
        return this;
    }

    /* renamed from: a */
    public C0157bw m1332a(EnumC0159by enumC0159by) {
        if (enumC0159by == null) {
            throw new NullPointerException();
        }
        this.f572a |= 2;
        this.f574c = enumC0159by;
        return this;
    }

    /* renamed from: a */
    public C0157bw m1333a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f572a |= 4;
        this.f575d = str;
        return this;
    }

    /* renamed from: g */
    public String m1342g() {
        Object obj = this.f576e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f576e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0157bw m1335b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f572a |= 8;
        this.f576e = str;
        return this;
    }

    /* renamed from: p */
    private void m1326p() {
        if ((this.f572a & 16) != 16) {
            this.f577f = new LazyStringArrayList(this.f577f);
            this.f572a |= 16;
        }
    }

    /* renamed from: h */
    public List m1343h() {
        return Collections.unmodifiableList(this.f577f);
    }

    /* renamed from: i */
    public int m1344i() {
        return this.f577f.size();
    }

    /* renamed from: c */
    public C0157bw m1337c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1326p();
        this.f577f.add((LazyStringList) str);
        return this;
    }

    /* renamed from: q */
    private void m1327q() {
        if ((this.f572a & 32) != 32) {
            this.f578g = new LazyStringArrayList(this.f578g);
            this.f572a |= 32;
        }
    }

    /* renamed from: j */
    public List m1345j() {
        return Collections.unmodifiableList(this.f578g);
    }

    /* renamed from: k */
    public int m1346k() {
        return this.f578g.size();
    }

    /* renamed from: d */
    public C0157bw m1339d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1327q();
        this.f578g.add((LazyStringList) str);
        return this;
    }
}
