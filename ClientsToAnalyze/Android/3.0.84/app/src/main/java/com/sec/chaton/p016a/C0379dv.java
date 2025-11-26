package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dv */
/* loaded from: classes.dex */
public final class C0379dv extends GeneratedMessageLite.Builder<C0378du, C0379dv> implements InterfaceC0380dw {

    /* renamed from: a */
    private int f1334a;

    /* renamed from: b */
    private long f1335b;

    /* renamed from: c */
    private EnumC0354cx f1336c = EnumC0354cx.TEXT;

    /* renamed from: d */
    private Object f1337d = "";

    private C0379dv() {
        m2645g();
    }

    /* renamed from: g */
    private void m2645g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0379dv m2646h() {
        return new C0379dv();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0379dv clear() {
        super.clear();
        this.f1335b = 0L;
        this.f1334a &= -2;
        this.f1336c = EnumC0354cx.TEXT;
        this.f1334a &= -3;
        this.f1337d = "";
        this.f1334a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0379dv mo13386clone() {
        return m2646h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0378du getDefaultInstanceForType() {
        return C0378du.m2630a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0378du build() {
        C0378du c0378duBuildPartial = buildPartial();
        if (!c0378duBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0378duBuildPartial);
        }
        return c0378duBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0378du buildPartial() {
        C0378du c0378du = new C0378du(this);
        int i = this.f1334a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0378du.f1329c = this.f1335b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0378du.f1330d = this.f1336c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0378du.f1331e = this.f1337d;
        c0378du.f1328b = i2;
        return c0378du;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0379dv mergeFrom(C0378du c0378du) {
        if (c0378du != C0378du.m2630a()) {
            if (c0378du.m2636c()) {
                m2648a(c0378du.m2637d());
            }
            if (c0378du.m2638e()) {
                m2650a(c0378du.m2639f());
            }
            if (c0378du.m2640g()) {
                m2652a(c0378du.m2641h());
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
    public C0379dv mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1334a |= 1;
                    this.f1335b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0354cx enumC0354cxM2352a = EnumC0354cx.m2352a(codedInputStream.readEnum());
                    if (enumC0354cxM2352a == null) {
                        break;
                    } else {
                        this.f1334a |= 2;
                        this.f1336c = enumC0354cxM2352a;
                        break;
                    }
                case 26:
                    this.f1334a |= 4;
                    this.f1337d = codedInputStream.readBytes();
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
    public C0379dv m2648a(long j) {
        this.f1334a |= 1;
        this.f1335b = j;
        return this;
    }

    /* renamed from: a */
    public C0379dv m2650a(EnumC0354cx enumC0354cx) {
        if (enumC0354cx == null) {
            throw new NullPointerException();
        }
        this.f1334a |= 2;
        this.f1336c = enumC0354cx;
        return this;
    }

    /* renamed from: a */
    public C0379dv m2652a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1334a |= 4;
        this.f1337d = str;
        return this;
    }
}
