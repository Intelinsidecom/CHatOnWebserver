package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ag */
/* loaded from: classes.dex */
public final class C0073ag extends GeneratedMessageLite.Builder implements InterfaceC0105x {

    /* renamed from: a */
    private int f74a;

    /* renamed from: b */
    private Object f75b = "";

    /* renamed from: c */
    private LazyStringList f76c = LazyStringArrayList.EMPTY;

    private C0073ag() {
        m199g();
    }

    /* renamed from: g */
    private void m199g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0073ag m200h() {
        return new C0073ag();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0073ag clear() {
        super.clear();
        this.f75b = "";
        this.f74a &= -2;
        this.f76c = LazyStringArrayList.EMPTY;
        this.f74a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0073ag mo5946clone() {
        return m200h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0076aj getDefaultInstanceForType() {
        return C0076aj.m253a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0076aj build() {
        C0076aj c0076ajBuildPartial = buildPartial();
        if (!c0076ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0076ajBuildPartial);
        }
        return c0076ajBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0076aj m201i() throws InvalidProtocolBufferException {
        C0076aj c0076ajBuildPartial = buildPartial();
        if (!c0076ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0076ajBuildPartial).asInvalidProtocolBufferException();
        }
        return c0076ajBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0076aj buildPartial() {
        C0076aj c0076aj = new C0076aj(this);
        int i = (this.f74a & 1) != 1 ? 0 : 1;
        c0076aj.f91c = this.f75b;
        if ((this.f74a & 2) == 2) {
            this.f76c = new UnmodifiableLazyStringList(this.f76c);
            this.f74a &= -3;
        }
        c0076aj.f92d = this.f76c;
        c0076aj.f90b = i;
        return c0076aj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0073ag mergeFrom(C0076aj c0076aj) {
        if (c0076aj != C0076aj.m253a()) {
            if (c0076aj.m260c()) {
                m206a(c0076aj.m261d());
            }
            if (!c0076aj.f92d.isEmpty()) {
                if (this.f76c.isEmpty()) {
                    this.f76c = c0076aj.f92d;
                    this.f74a &= -3;
                } else {
                    m202j();
                    this.f76c.addAll(c0076aj.f92d);
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
    public C0073ag mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f74a |= 1;
                    this.f75b = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    m202j();
                    this.f76c.add(codedInputStream.readBytes());
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
    public C0073ag m206a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f74a |= 1;
        this.f75b = str;
        return this;
    }

    /* renamed from: j */
    private void m202j() {
        if ((this.f74a & 2) != 2) {
            this.f76c = new LazyStringArrayList(this.f76c);
            this.f74a |= 2;
        }
    }

    /* renamed from: b */
    public C0073ag m208b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m202j();
        this.f76c.add((LazyStringList) str);
        return this;
    }
}
