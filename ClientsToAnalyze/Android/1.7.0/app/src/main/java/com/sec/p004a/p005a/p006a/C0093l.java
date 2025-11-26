package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.l */
/* loaded from: classes.dex */
public final class C0093l extends GeneratedMessageLite.Builder implements InterfaceC0087f {

    /* renamed from: a */
    private int f148a;

    /* renamed from: b */
    private int f149b;

    /* renamed from: c */
    private Object f150c = "";

    /* renamed from: d */
    private Object f151d = "";

    /* renamed from: e */
    private Object f152e = "";

    private C0093l() {
        m411g();
    }

    /* renamed from: g */
    private void m411g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0093l m412h() {
        return new C0093l();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0093l clear() {
        super.clear();
        this.f149b = 0;
        this.f148a &= -2;
        this.f150c = "";
        this.f148a &= -3;
        this.f151d = "";
        this.f148a &= -5;
        this.f152e = "";
        this.f148a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0093l mo5946clone() {
        return m412h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0074ah getDefaultInstanceForType() {
        return C0074ah.m213a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0074ah build() {
        C0074ah c0074ahBuildPartial = buildPartial();
        if (!c0074ahBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0074ahBuildPartial);
        }
        return c0074ahBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0074ah m413i() throws InvalidProtocolBufferException {
        C0074ah c0074ahBuildPartial = buildPartial();
        if (!c0074ahBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0074ahBuildPartial).asInvalidProtocolBufferException();
        }
        return c0074ahBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0074ah buildPartial() {
        C0074ah c0074ah = new C0074ah(this);
        int i = this.f148a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0074ah.f79c = this.f149b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0074ah.f80d = this.f150c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0074ah.f81e = this.f151d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0074ah.f82f = this.f152e;
        c0074ah.f78b = i2;
        return c0074ah;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0093l mergeFrom(C0074ah c0074ah) {
        if (c0074ah != C0074ah.m213a()) {
            if (c0074ah.m225c()) {
                m415a(c0074ah.m226d());
            }
            if (c0074ah.m227e()) {
                m418a(c0074ah.m228f());
            }
            if (c0074ah.m229g()) {
                m420b(c0074ah.m230h());
            }
            if (c0074ah.m231i()) {
                m422c(c0074ah.m232j());
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
    public C0093l mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f148a |= 1;
                    this.f149b = codedInputStream.readInt32();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f148a |= 2;
                    this.f150c = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f148a |= 4;
                    this.f151d = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f148a |= 8;
                    this.f152e = codedInputStream.readBytes();
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
    public C0093l m415a(int i) {
        this.f148a |= 1;
        this.f149b = i;
        return this;
    }

    /* renamed from: a */
    public C0093l m418a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f148a |= 2;
        this.f150c = str;
        return this;
    }

    /* renamed from: b */
    public C0093l m420b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f148a |= 4;
        this.f151d = str;
        return this;
    }

    /* renamed from: c */
    public C0093l m422c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f148a |= 8;
        this.f152e = str;
        return this;
    }
}
