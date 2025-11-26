package com.nuance.nmsp.client.sdk.components.general;

import com.google.android.gcm.GCMConstants;
import com.nuance.nmsp.client.sdk.common.util.ShortConstant;

/* loaded from: classes.dex */
public class Parameter {

    /* renamed from: a */
    private String f100a;

    /* renamed from: b */
    private Object f101b;

    /* renamed from: c */
    private Type f102c;

    public static class Type extends ShortConstant {
        public static final Type SDK = new Type(0);
        public static final Type NMSP = new Type(1);
        public static final Type APP = new Type(2);
        public static final Type NSS = new Type(3);
        public static final Type SLOG = new Type(4);
        public static final Type NSSLOG = new Type(5);
        public static final Type GWLOG = new Type(6);
        public static final Type SVSP = new Type(7);
        public static final Type SIP = new Type(8);
        public static final Type SDP = new Type(9);

        private Type(short s) {
            super(s);
        }

        public String toString() {
            if (equals((ShortConstant) NMSP)) {
                return "nmsp";
            }
            if (equals((ShortConstant) APP)) {
                return GCMConstants.EXTRA_APPLICATION_PENDING_INTENT;
            }
            if (equals((ShortConstant) NSS)) {
                return "nss";
            }
            if (equals((ShortConstant) SLOG)) {
                return "slog";
            }
            if (equals((ShortConstant) NSSLOG)) {
                return "nsslog";
            }
            if (equals((ShortConstant) GWLOG)) {
                return "gwlog";
            }
            if (equals((ShortConstant) SVSP)) {
                return "svsp";
            }
            if (equals((ShortConstant) SIP)) {
                return "sip";
            }
            if (equals((ShortConstant) SDP)) {
                return "sdp";
            }
            if (equals((ShortConstant) SDK)) {
                return "sdk";
            }
            return null;
        }
    }

    public Parameter(String str, Type type) {
        this.f100a = str;
        this.f101b = new byte[0];
        this.f102c = type;
    }

    public Parameter(String str, Object obj, Type type) {
        this.f100a = str;
        this.f101b = obj;
        this.f102c = type;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Parameter m3103clone() {
        Object obj = this.f101b;
        if (this.f101b instanceof byte[]) {
            byte[] bArr = (byte[]) this.f101b;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            obj = bArr2;
        }
        return new Parameter(this.f100a, obj, this.f102c);
    }

    public String getName() {
        return this.f100a;
    }

    public Type getType() {
        return this.f102c;
    }

    public byte[] getValue() {
        return this.f101b instanceof byte[] ? (byte[]) this.f101b : "THIS IS NOT A STRING PARAMETER!!!".getBytes();
    }

    public Object getValueRaw() {
        return this.f101b;
    }
}
