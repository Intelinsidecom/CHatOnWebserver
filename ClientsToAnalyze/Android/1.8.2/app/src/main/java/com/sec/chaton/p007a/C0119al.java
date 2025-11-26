package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.al */
/* loaded from: classes.dex */
public final class C0119al extends GeneratedMessageLite.Builder implements InterfaceC0120am {

    /* renamed from: a */
    private int f406a;

    /* renamed from: b */
    private Object f407b = "";

    /* renamed from: c */
    private EnumC0116ai f408c = EnumC0116ai.SINGLE;

    /* renamed from: d */
    private List f409d = Collections.emptyList();

    /* renamed from: e */
    private Object f410e = "";

    /* renamed from: f */
    private boolean f411f;

    private C0119al() {
        m844g();
    }

    /* renamed from: g */
    private void m844g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0119al m845h() {
        return new C0119al();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0119al clear() {
        super.clear();
        this.f407b = "";
        this.f406a &= -2;
        this.f408c = EnumC0116ai.SINGLE;
        this.f406a &= -3;
        this.f409d = Collections.emptyList();
        this.f406a &= -5;
        this.f410e = "";
        this.f406a &= -9;
        this.f411f = false;
        this.f406a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0119al mo7542clone() {
        return m845h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0118ak getDefaultInstanceForType() {
        return C0118ak.m817a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0118ak build() {
        C0118ak c0118akBuildPartial = buildPartial();
        if (!c0118akBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0118akBuildPartial);
        }
        return c0118akBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0118ak m846i() throws InvalidProtocolBufferException {
        C0118ak c0118akBuildPartial = buildPartial();
        if (!c0118akBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0118akBuildPartial).asInvalidProtocolBufferException();
        }
        return c0118akBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0118ak buildPartial() {
        C0118ak c0118ak = new C0118ak(this);
        int i = this.f406a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0118ak.f399c = this.f407b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0118ak.f400d = this.f408c;
        if ((this.f406a & 4) == 4) {
            this.f409d = Collections.unmodifiableList(this.f409d);
            this.f406a &= -5;
        }
        c0118ak.f401e = this.f409d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0118ak.f402f = this.f410e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0118ak.f403g = this.f411f;
        c0118ak.f398b = i2;
        return c0118ak;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0119al mergeFrom(C0118ak c0118ak) {
        if (c0118ak != C0118ak.m817a()) {
            if (c0118ak.m830c()) {
                m853a(c0118ak.m831d());
            }
            if (c0118ak.m832e()) {
                m850a(c0118ak.m833f());
            }
            if (!c0118ak.f401e.isEmpty()) {
                if (this.f409d.isEmpty()) {
                    this.f409d = c0118ak.f401e;
                    this.f406a &= -5;
                } else {
                    m847j();
                    this.f409d.addAll(c0118ak.f401e);
                }
            }
            if (c0118ak.m836i()) {
                m856b(c0118ak.m837j());
            }
            if (c0118ak.m838k()) {
                m854a(c0118ak.m839l());
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
    public C0119al mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f406a |= 1;
                    this.f407b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    EnumC0116ai enumC0116aiM813a = EnumC0116ai.m813a(codedInputStream.readEnum());
                    if (enumC0116aiM813a == null) {
                        break;
                    } else {
                        this.f406a |= 2;
                        this.f408c = enumC0116aiM813a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    C0145bk c0145bkNewBuilder = C0144bj.newBuilder();
                    codedInputStream.readMessage(c0145bkNewBuilder, extensionRegistryLite);
                    m852a(c0145bkNewBuilder.buildPartial());
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f406a |= 8;
                    this.f410e = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_onClick /* 40 */:
                    this.f406a |= 16;
                    this.f411f = codedInputStream.readBool();
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
    public C0119al m853a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f406a |= 1;
        this.f407b = str;
        return this;
    }

    /* renamed from: a */
    public C0119al m850a(EnumC0116ai enumC0116ai) {
        if (enumC0116ai == null) {
            throw new NullPointerException();
        }
        this.f406a |= 2;
        this.f408c = enumC0116ai;
        return this;
    }

    /* renamed from: j */
    private void m847j() {
        if ((this.f406a & 4) != 4) {
            this.f409d = new ArrayList(this.f409d);
            this.f406a |= 4;
        }
    }

    /* renamed from: a */
    public C0119al m852a(C0144bj c0144bj) {
        if (c0144bj == null) {
            throw new NullPointerException();
        }
        m847j();
        this.f409d.add(c0144bj);
        return this;
    }

    /* renamed from: b */
    public C0119al m856b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f406a |= 8;
        this.f410e = str;
        return this;
    }

    /* renamed from: a */
    public C0119al m854a(boolean z) {
        this.f406a |= 16;
        this.f411f = z;
        return this;
    }
}
