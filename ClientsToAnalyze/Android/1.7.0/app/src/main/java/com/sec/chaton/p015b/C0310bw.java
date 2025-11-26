package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bw */
/* loaded from: classes.dex */
public final class C0310bw extends GeneratedMessageLite.Builder implements InterfaceC0351y {

    /* renamed from: a */
    private int f864a;

    /* renamed from: b */
    private long f865b;

    /* renamed from: c */
    private LazyStringList f866c = LazyStringArrayList.EMPTY;

    private C0310bw() {
        m1592g();
    }

    /* renamed from: g */
    private void m1592g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0310bw m1593h() {
        return new C0310bw();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0310bw clear() {
        super.clear();
        this.f865b = 0L;
        this.f864a &= -2;
        this.f866c = LazyStringArrayList.EMPTY;
        this.f864a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0310bw mo5946clone() {
        return m1593h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0280at getDefaultInstanceForType() {
        return C0280at.m1215a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0280at build() {
        C0280at c0280atBuildPartial = buildPartial();
        if (!c0280atBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0280atBuildPartial);
        }
        return c0280atBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0280at m1594i() throws InvalidProtocolBufferException {
        C0280at c0280atBuildPartial = buildPartial();
        if (!c0280atBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0280atBuildPartial).asInvalidProtocolBufferException();
        }
        return c0280atBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0280at buildPartial() {
        C0280at c0280at = new C0280at(this);
        int i = (this.f864a & 1) != 1 ? 0 : 1;
        c0280at.f736c = this.f865b;
        if ((this.f864a & 2) == 2) {
            this.f866c = new UnmodifiableLazyStringList(this.f866c);
            this.f864a &= -3;
        }
        c0280at.f737d = this.f866c;
        c0280at.f735b = i;
        return c0280at;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0310bw mergeFrom(C0280at c0280at) {
        if (c0280at != C0280at.m1215a()) {
            if (c0280at.m1221c()) {
                m1597a(c0280at.m1222d());
            }
            if (!c0280at.f737d.isEmpty()) {
                if (this.f866c.isEmpty()) {
                    this.f866c = c0280at.f737d;
                    this.f864a &= -3;
                } else {
                    m1595j();
                    this.f866c.addAll(c0280at.f737d);
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
    public C0310bw mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f864a |= 1;
                    this.f865b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    m1595j();
                    this.f866c.add(codedInputStream.readBytes());
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
    public C0310bw m1597a(long j) {
        this.f864a |= 1;
        this.f865b = j;
        return this;
    }

    /* renamed from: j */
    private void m1595j() {
        if ((this.f864a & 2) != 2) {
            this.f866c = new LazyStringArrayList(this.f866c);
            this.f864a |= 2;
        }
    }
}
