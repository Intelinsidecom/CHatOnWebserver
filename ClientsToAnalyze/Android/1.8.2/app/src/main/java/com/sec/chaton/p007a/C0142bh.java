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
/* renamed from: com.sec.chaton.a.bh */
/* loaded from: classes.dex */
public final class C0142bh extends GeneratedMessageLite.Builder implements InterfaceC0143bi {

    /* renamed from: a */
    private int f487a;

    /* renamed from: b */
    private long f488b;

    /* renamed from: c */
    private EnumC0116ai f489c = EnumC0116ai.SINGLE;

    /* renamed from: d */
    private Object f490d = "";

    /* renamed from: e */
    private Object f491e = "";

    /* renamed from: f */
    private Object f492f = "";

    /* renamed from: g */
    private LazyStringList f493g = LazyStringArrayList.EMPTY;

    private C0142bh() {
        m1073l();
    }

    /* renamed from: l */
    private void m1073l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static C0142bh m1074m() {
        return new C0142bh();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0142bh clear() {
        super.clear();
        this.f488b = 0L;
        this.f487a &= -2;
        this.f489c = EnumC0116ai.SINGLE;
        this.f487a &= -3;
        this.f490d = "";
        this.f487a &= -5;
        this.f491e = "";
        this.f487a &= -9;
        this.f492f = "";
        this.f487a &= -17;
        this.f493g = LazyStringArrayList.EMPTY;
        this.f487a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0142bh mo7542clone() {
        return m1074m().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0141bg getDefaultInstanceForType() {
        return C0141bg.m1046a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0141bg build() {
        C0141bg c0141bgBuildPartial = buildPartial();
        if (!c0141bgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0141bgBuildPartial);
        }
        return c0141bgBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public C0141bg m1075n() throws InvalidProtocolBufferException {
        C0141bg c0141bgBuildPartial = buildPartial();
        if (!c0141bgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0141bgBuildPartial).asInvalidProtocolBufferException();
        }
        return c0141bgBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0141bg buildPartial() {
        C0141bg c0141bg = new C0141bg(this);
        int i = this.f487a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0141bg.f479c = this.f488b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0141bg.f480d = this.f489c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0141bg.f481e = this.f490d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0141bg.f482f = this.f491e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0141bg.f483g = this.f492f;
        if ((this.f487a & 32) == 32) {
            this.f493g = new UnmodifiableLazyStringList(this.f493g);
            this.f487a &= -33;
        }
        c0141bg.f484h = this.f493g;
        c0141bg.f478b = i2;
        return c0141bg;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0142bh mergeFrom(C0141bg c0141bg) {
        if (c0141bg != C0141bg.m1046a()) {
            if (c0141bg.m1058c()) {
                m1078a(c0141bg.m1059d());
            }
            if (c0141bg.m1060e()) {
                m1080a(c0141bg.m1061f());
            }
            if (c0141bg.m1062g()) {
                m1082a(c0141bg.m1063h());
            }
            if (c0141bg.m1064i()) {
                m1084b(c0141bg.m1065j());
            }
            if (c0141bg.m1066k()) {
                m1086c(c0141bg.m1067l());
            }
            if (!c0141bg.f484h.isEmpty()) {
                if (this.f493g.isEmpty()) {
                    this.f493g = c0141bg.f484h;
                    this.f487a &= -33;
                } else {
                    m1076o();
                    this.f493g.addAll(c0141bg.f484h);
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
    public C0142bh mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f487a |= 1;
                    this.f488b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    EnumC0116ai enumC0116aiM813a = EnumC0116ai.m813a(codedInputStream.readEnum());
                    if (enumC0116aiM813a == null) {
                        break;
                    } else {
                        this.f487a |= 2;
                        this.f489c = enumC0116aiM813a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f487a |= 4;
                    this.f490d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f487a |= 8;
                    this.f491e = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    this.f487a |= 16;
                    this.f492f = codedInputStream.readBytes();
                    break;
                case 50:
                    m1076o();
                    this.f493g.add(codedInputStream.readBytes());
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
    public long m1090f() {
        return this.f488b;
    }

    /* renamed from: a */
    public C0142bh m1078a(long j) {
        this.f487a |= 1;
        this.f488b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0116ai m1091g() {
        return this.f489c;
    }

    /* renamed from: a */
    public C0142bh m1080a(EnumC0116ai enumC0116ai) {
        if (enumC0116ai == null) {
            throw new NullPointerException();
        }
        this.f487a |= 2;
        this.f489c = enumC0116ai;
        return this;
    }

    /* renamed from: h */
    public String m1092h() {
        Object obj = this.f490d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f490d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0142bh m1082a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f487a |= 4;
        this.f490d = str;
        return this;
    }

    /* renamed from: b */
    public C0142bh m1084b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f487a |= 8;
        this.f491e = str;
        return this;
    }

    /* renamed from: i */
    public String m1093i() {
        Object obj = this.f492f;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f492f = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0142bh m1086c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f487a |= 16;
        this.f492f = str;
        return this;
    }

    /* renamed from: o */
    private void m1076o() {
        if ((this.f487a & 32) != 32) {
            this.f493g = new LazyStringArrayList(this.f493g);
            this.f487a |= 32;
        }
    }

    /* renamed from: j */
    public List m1094j() {
        return Collections.unmodifiableList(this.f493g);
    }

    /* renamed from: d */
    public C0142bh m1088d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1076o();
        this.f493g.add((LazyStringList) str);
        return this;
    }
}
