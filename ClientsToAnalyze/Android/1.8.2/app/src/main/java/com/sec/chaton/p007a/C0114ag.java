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
/* renamed from: com.sec.chaton.a.ag */
/* loaded from: classes.dex */
public final class C0114ag extends GeneratedMessageLite.Builder implements InterfaceC0115ah {

    /* renamed from: a */
    private int f380a;

    /* renamed from: b */
    private long f381b;

    /* renamed from: c */
    private EnumC0159by f382c = EnumC0159by.TEXT;

    /* renamed from: d */
    private EnumC0116ai f383d = EnumC0116ai.SINGLE;

    /* renamed from: e */
    private Object f384e = "";

    /* renamed from: f */
    private Object f385f = "";

    /* renamed from: g */
    private LazyStringList f386g = LazyStringArrayList.EMPTY;

    /* renamed from: h */
    private Object f387h = "";

    /* renamed from: i */
    private Object f388i = "";

    /* renamed from: j */
    private Object f389j = "";

    /* renamed from: k */
    private Object f390k = "";

    private C0114ag() {
        m785n();
    }

    /* renamed from: n */
    private void m785n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static C0114ag m786o() {
        return new C0114ag();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0114ag clear() {
        super.clear();
        this.f381b = 0L;
        this.f380a &= -2;
        this.f382c = EnumC0159by.TEXT;
        this.f380a &= -3;
        this.f383d = EnumC0116ai.SINGLE;
        this.f380a &= -5;
        this.f384e = "";
        this.f380a &= -9;
        this.f385f = "";
        this.f380a &= -17;
        this.f386g = LazyStringArrayList.EMPTY;
        this.f380a &= -33;
        this.f387h = "";
        this.f380a &= -65;
        this.f388i = "";
        this.f380a &= -129;
        this.f389j = "";
        this.f380a &= -257;
        this.f390k = "";
        this.f380a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0114ag mo7542clone() {
        return m786o().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0113af getDefaultInstanceForType() {
        return C0113af.m746a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0113af build() {
        C0113af c0113afBuildPartial = buildPartial();
        if (!c0113afBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0113afBuildPartial);
        }
        return c0113afBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public C0113af m787p() throws InvalidProtocolBufferException {
        C0113af c0113afBuildPartial = buildPartial();
        if (!c0113afBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0113afBuildPartial).asInvalidProtocolBufferException();
        }
        return c0113afBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0113af buildPartial() {
        C0113af c0113af = new C0113af(this);
        int i = this.f380a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0113af.f368c = this.f381b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0113af.f369d = this.f382c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0113af.f370e = this.f383d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0113af.f371f = this.f384e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0113af.f372g = this.f385f;
        if ((this.f380a & 32) == 32) {
            this.f386g = new UnmodifiableLazyStringList(this.f386g);
            this.f380a &= -33;
        }
        c0113af.f373h = this.f386g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0113af.f374i = this.f387h;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
            i2 |= 64;
        }
        c0113af.f375j = this.f388i;
        if ((i & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256) {
            i2 |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
        }
        c0113af.f376k = this.f389j;
        if ((i & 512) == 512) {
            i2 |= AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
        }
        c0113af.f377l = this.f390k;
        c0113af.f367b = i2;
        return c0113af;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0114ag mergeFrom(C0113af c0113af) {
        if (c0113af != C0113af.m746a()) {
            if (c0113af.m762c()) {
                m790a(c0113af.m763d());
            }
            if (c0113af.m764e()) {
                m794a(c0113af.m765f());
            }
            if (c0113af.m766g()) {
                m793a(c0113af.m767h());
            }
            if (c0113af.m768i()) {
                m795a(c0113af.m769j());
            }
            if (c0113af.m770k()) {
                m797b(c0113af.m771l());
            }
            if (!c0113af.f373h.isEmpty()) {
                if (this.f386g.isEmpty()) {
                    this.f386g = c0113af.f373h;
                    this.f380a &= -33;
                } else {
                    m788q();
                    this.f386g.addAll(c0113af.f373h);
                }
            }
            if (c0113af.m773n()) {
                m801d(c0113af.m774o());
            }
            if (c0113af.m775p()) {
                m803e(c0113af.m776q());
            }
            if (c0113af.m777r()) {
                m805f(c0113af.m778s());
            }
            if (c0113af.m779t()) {
                m806g(c0113af.m780u());
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
    public C0114ag mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f380a |= 1;
                    this.f381b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    EnumC0159by enumC0159byM1347a = EnumC0159by.m1347a(codedInputStream.readEnum());
                    if (enumC0159byM1347a == null) {
                        break;
                    } else {
                        this.f380a |= 2;
                        this.f382c = enumC0159byM1347a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    EnumC0116ai enumC0116aiM813a = EnumC0116ai.m813a(codedInputStream.readEnum());
                    if (enumC0116aiM813a == null) {
                        break;
                    } else {
                        this.f380a |= 4;
                        this.f383d = enumC0116aiM813a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f380a |= 8;
                    this.f384e = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    this.f380a |= 16;
                    this.f385f = codedInputStream.readBytes();
                    break;
                case 50:
                    m788q();
                    this.f386g.add(codedInputStream.readBytes());
                    break;
                case 58:
                    this.f380a |= 64;
                    this.f387h = codedInputStream.readBytes();
                    break;
                case 66:
                    this.f380a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
                    this.f388i = codedInputStream.readBytes();
                    break;
                case 74:
                    this.f380a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
                    this.f389j = codedInputStream.readBytes();
                    break;
                case 82:
                    this.f380a |= 512;
                    this.f390k = codedInputStream.readBytes();
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
    public long m804f() {
        return this.f381b;
    }

    /* renamed from: a */
    public C0114ag m790a(long j) {
        this.f380a |= 1;
        this.f381b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0159by m807g() {
        return this.f382c;
    }

    /* renamed from: a */
    public C0114ag m794a(EnumC0159by enumC0159by) {
        if (enumC0159by == null) {
            throw new NullPointerException();
        }
        this.f380a |= 2;
        this.f382c = enumC0159by;
        return this;
    }

    /* renamed from: h */
    public EnumC0116ai m808h() {
        return this.f383d;
    }

    /* renamed from: a */
    public C0114ag m793a(EnumC0116ai enumC0116ai) {
        if (enumC0116ai == null) {
            throw new NullPointerException();
        }
        this.f380a |= 4;
        this.f383d = enumC0116ai;
        return this;
    }

    /* renamed from: i */
    public String m809i() {
        Object obj = this.f384e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f384e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0114ag m795a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f380a |= 8;
        this.f384e = str;
        return this;
    }

    /* renamed from: j */
    public String m810j() {
        Object obj = this.f385f;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f385f = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0114ag m797b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f380a |= 16;
        this.f385f = str;
        return this;
    }

    /* renamed from: q */
    private void m788q() {
        if ((this.f380a & 32) != 32) {
            this.f386g = new LazyStringArrayList(this.f386g);
            this.f380a |= 32;
        }
    }

    /* renamed from: k */
    public List m811k() {
        return Collections.unmodifiableList(this.f386g);
    }

    /* renamed from: c */
    public C0114ag m799c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m788q();
        this.f386g.add((LazyStringList) str);
        return this;
    }

    /* renamed from: d */
    public C0114ag m801d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f380a |= 64;
        this.f387h = str;
        return this;
    }

    /* renamed from: e */
    public C0114ag m803e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f380a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER;
        this.f388i = str;
        return this;
    }

    /* renamed from: l */
    public String m812l() {
        Object obj = this.f389j;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f389j = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: f */
    public C0114ag m805f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f380a |= AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT;
        this.f389j = str;
        return this;
    }

    /* renamed from: g */
    public C0114ag m806g(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f380a |= 512;
        this.f390k = str;
        return this;
    }
}
