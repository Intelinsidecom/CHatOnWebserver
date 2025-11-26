package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.aa */
/* loaded from: classes.dex */
public final class C0067aa extends GeneratedMessageLite.Builder implements InterfaceC0088g {

    /* renamed from: a */
    private int f39a;

    /* renamed from: b */
    private int f40b;

    /* renamed from: c */
    private Object f41c = "";

    private C0067aa() {
        m92g();
    }

    /* renamed from: g */
    private void m92g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0067aa m93h() {
        return new C0067aa();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0067aa clear() {
        super.clear();
        this.f40b = 0;
        this.f39a &= -2;
        this.f41c = "";
        this.f39a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0067aa mo5946clone() {
        return m93h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0092k getDefaultInstanceForType() {
        return C0092k.m396a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0092k build() {
        C0092k c0092kBuildPartial = buildPartial();
        if (!c0092kBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0092kBuildPartial);
        }
        return c0092kBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0092k m94i() throws InvalidProtocolBufferException {
        C0092k c0092kBuildPartial = buildPartial();
        if (!c0092kBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0092kBuildPartial).asInvalidProtocolBufferException();
        }
        return c0092kBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0092k buildPartial() {
        C0092k c0092k = new C0092k(this);
        int i = this.f39a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0092k.f144c = this.f40b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0092k.f145d = this.f41c;
        c0092k.f143b = i2;
        return c0092k;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0067aa mergeFrom(C0092k c0092k) {
        if (c0092k != C0092k.m396a()) {
            if (c0092k.m403c()) {
                m96a(c0092k.m404d());
            }
            if (c0092k.m405e()) {
                m99a(c0092k.m406f());
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
    public C0067aa mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f39a |= 1;
                    this.f40b = codedInputStream.readInt32();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f39a |= 2;
                    this.f41c = codedInputStream.readBytes();
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
    public C0067aa m96a(int i) {
        this.f39a |= 1;
        this.f40b = i;
        return this;
    }

    /* renamed from: a */
    public C0067aa m99a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f39a |= 2;
        this.f41c = str;
        return this;
    }
}
