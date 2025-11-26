package com.sec.chaton.p007a;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
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
/* renamed from: com.sec.chaton.a.bq */
/* loaded from: classes.dex */
public final class C0151bq extends GeneratedMessageLite.Builder implements InterfaceC0152br {

    /* renamed from: a */
    private int f541a;

    /* renamed from: b */
    private long f542b;

    /* renamed from: g */
    private long f547g;

    /* renamed from: c */
    private EnumC0159by f543c = EnumC0159by.TEXT;

    /* renamed from: d */
    private EnumC0116ai f544d = EnumC0116ai.SINGLE;

    /* renamed from: e */
    private Object f545e = "";

    /* renamed from: f */
    private Object f546f = "";

    /* renamed from: h */
    private Object f548h = "";

    /* renamed from: i */
    private LazyStringList f549i = LazyStringArrayList.EMPTY;

    /* renamed from: j */
    private Object f550j = "";

    private C0151bq() {
        m1232m();
    }

    /* renamed from: m */
    private void m1232m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static C0151bq m1233n() {
        return new C0151bq();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0151bq clear() {
        super.clear();
        this.f542b = 0L;
        this.f541a &= -2;
        this.f543c = EnumC0159by.TEXT;
        this.f541a &= -3;
        this.f544d = EnumC0116ai.SINGLE;
        this.f541a &= -5;
        this.f545e = "";
        this.f541a &= -9;
        this.f546f = "";
        this.f541a &= -17;
        this.f547g = 0L;
        this.f541a &= -33;
        this.f548h = "";
        this.f541a &= -65;
        this.f549i = LazyStringArrayList.EMPTY;
        this.f541a &= -129;
        this.f550j = "";
        this.f541a &= -257;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0151bq mo7542clone() {
        return m1233n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0150bp getDefaultInstanceForType() {
        return C0150bp.m1195a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0150bp build() {
        C0150bp c0150bpBuildPartial = buildPartial();
        if (!c0150bpBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0150bpBuildPartial);
        }
        return c0150bpBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public C0150bp m1234o() throws InvalidProtocolBufferException {
        C0150bp c0150bpBuildPartial = buildPartial();
        if (!c0150bpBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0150bpBuildPartial).asInvalidProtocolBufferException();
        }
        return c0150bpBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0150bp buildPartial() {
        C0150bp c0150bp = new C0150bp(this);
        int i = this.f541a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0150bp.f530c = this.f542b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0150bp.f531d = this.f543c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0150bp.f532e = this.f544d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0150bp.f533f = this.f545e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0150bp.f534g = this.f546f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0150bp.f535h = this.f547g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0150bp.f536i = this.f548h;
        if ((this.f541a & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
            this.f549i = new UnmodifiableLazyStringList(this.f549i);
            this.f541a &= -129;
        }
        c0150bp.f537j = this.f549i;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256) {
            i2 |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
        }
        c0150bp.f538k = this.f550j;
        c0150bp.f529b = i2;
        return c0150bp;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0151bq mergeFrom(C0150bp c0150bp) {
        if (c0150bp != C0150bp.m1195a()) {
            if (c0150bp.m1211c()) {
                m1237a(c0150bp.m1212d());
            }
            if (c0150bp.m1213e()) {
                m1241a(c0150bp.m1214f());
            }
            if (c0150bp.m1215g()) {
                m1239a(c0150bp.m1216h());
            }
            if (c0150bp.m1217i()) {
                m1242a(c0150bp.m1218j());
            }
            if (c0150bp.m1219k()) {
                m1245b(c0150bp.m1220l());
            }
            if (c0150bp.m1221m()) {
                m1244b(c0150bp.m1222n());
            }
            if (c0150bp.m1223o()) {
                m1247c(c0150bp.m1224p());
            }
            if (!c0150bp.f537j.isEmpty()) {
                if (this.f549i.isEmpty()) {
                    this.f549i = c0150bp.f537j;
                    this.f541a &= -129;
                } else {
                    m1235p();
                    this.f549i.addAll(c0150bp.f537j);
                }
            }
            if (c0150bp.m1226r()) {
                m1251e(c0150bp.m1227s());
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
    public C0151bq mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f541a |= 1;
                    this.f542b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    EnumC0159by enumC0159byM1347a = EnumC0159by.m1347a(codedInputStream.readEnum());
                    if (enumC0159byM1347a == null) {
                        break;
                    } else {
                        this.f541a |= 2;
                        this.f543c = enumC0159byM1347a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    EnumC0116ai enumC0116aiM813a = EnumC0116ai.m813a(codedInputStream.readEnum());
                    if (enumC0116aiM813a == null) {
                        break;
                    } else {
                        this.f541a |= 4;
                        this.f544d = enumC0116aiM813a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f541a |= 8;
                    this.f545e = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    this.f541a |= 16;
                    this.f546f = codedInputStream.readBytes();
                    break;
                case 48:
                    this.f541a |= 32;
                    this.f547g = codedInputStream.readInt64();
                    break;
                case 58:
                    this.f541a |= 64;
                    this.f548h = codedInputStream.readBytes();
                    break;
                case 66:
                    m1235p();
                    this.f549i.add(codedInputStream.readBytes());
                    break;
                case 74:
                    this.f541a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
                    this.f550j = codedInputStream.readBytes();
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
    public long m1252f() {
        return this.f542b;
    }

    /* renamed from: a */
    public C0151bq m1237a(long j) {
        this.f541a |= 1;
        this.f542b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0159by m1253g() {
        return this.f543c;
    }

    /* renamed from: a */
    public C0151bq m1241a(EnumC0159by enumC0159by) {
        if (enumC0159by == null) {
            throw new NullPointerException();
        }
        this.f541a |= 2;
        this.f543c = enumC0159by;
        return this;
    }

    /* renamed from: h */
    public EnumC0116ai m1254h() {
        return this.f544d;
    }

    /* renamed from: a */
    public C0151bq m1239a(EnumC0116ai enumC0116ai) {
        if (enumC0116ai == null) {
            throw new NullPointerException();
        }
        this.f541a |= 4;
        this.f544d = enumC0116ai;
        return this;
    }

    /* renamed from: a */
    public C0151bq m1242a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f541a |= 8;
        this.f545e = str;
        return this;
    }

    /* renamed from: b */
    public C0151bq m1245b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f541a |= 16;
        this.f546f = str;
        return this;
    }

    /* renamed from: b */
    public C0151bq m1244b(long j) {
        this.f541a |= 32;
        this.f547g = j;
        return this;
    }

    /* renamed from: i */
    public String m1255i() {
        Object obj = this.f548h;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f548h = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0151bq m1247c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f541a |= 64;
        this.f548h = str;
        return this;
    }

    /* renamed from: p */
    private void m1235p() {
        if ((this.f541a & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) != 128) {
            this.f549i = new LazyStringArrayList(this.f549i);
            this.f541a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
        }
    }

    /* renamed from: j */
    public List m1256j() {
        return Collections.unmodifiableList(this.f549i);
    }

    /* renamed from: d */
    public C0151bq m1249d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1235p();
        this.f549i.add((LazyStringList) str);
        return this;
    }

    /* renamed from: k */
    public String m1257k() {
        Object obj = this.f550j;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f550j = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: e */
    public C0151bq m1251e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f541a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
        this.f550j = str;
        return this;
    }
}
