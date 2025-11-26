package com.sec.chaton.chat;

import android.database.Cursor;
import com.p137vk.sdk.api.VKApiConst;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.gc */
/* loaded from: classes.dex */
public class C1730gc {

    /* renamed from: A */
    public int f6482A;

    /* renamed from: B */
    public int f6483B;

    /* renamed from: C */
    public int f6484C;

    /* renamed from: D */
    public int f6485D;

    /* renamed from: E */
    public int f6486E;

    /* renamed from: F */
    public int f6487F;

    /* renamed from: G */
    public int f6488G;

    /* renamed from: H */
    public int f6489H;

    /* renamed from: I */
    public int f6490I;

    /* renamed from: J */
    public int f6491J;

    /* renamed from: K */
    public int f6492K;

    /* renamed from: L */
    public int f6493L;

    /* renamed from: M */
    public int f6494M;

    /* renamed from: N */
    public int f6495N;

    /* renamed from: O */
    public int f6496O;

    /* renamed from: a */
    public int f6497a;

    /* renamed from: b */
    public int f6498b;

    /* renamed from: c */
    public int f6499c;

    /* renamed from: d */
    public int f6500d;

    /* renamed from: e */
    public int f6501e;

    /* renamed from: f */
    public int f6502f;

    /* renamed from: g */
    public int f6503g;

    /* renamed from: h */
    public int f6504h;

    /* renamed from: i */
    public int f6505i;

    /* renamed from: j */
    public int f6506j;

    /* renamed from: k */
    public int f6507k;

    /* renamed from: l */
    public int f6508l;

    /* renamed from: m */
    public int f6509m;

    /* renamed from: n */
    public int f6510n;

    /* renamed from: o */
    public int f6511o;

    /* renamed from: p */
    public int f6512p;

    /* renamed from: q */
    public int f6513q;

    /* renamed from: r */
    public int f6514r;

    /* renamed from: s */
    public int f6515s;

    /* renamed from: t */
    public int f6516t;

    /* renamed from: u */
    public int f6517u;

    /* renamed from: v */
    public int f6518v;

    /* renamed from: w */
    public int f6519w;

    /* renamed from: x */
    public int f6520x;

    /* renamed from: y */
    public int f6521y;

    /* renamed from: z */
    public int f6522z;

    public C1730gc() {
        this.f6497a = 0;
        this.f6498b = 1;
        this.f6499c = 2;
        this.f6500d = 3;
        this.f6501e = 4;
        this.f6502f = 5;
        this.f6503g = 7;
        this.f6504h = 8;
        this.f6505i = 9;
        this.f6506j = 10;
        this.f6507k = 11;
        this.f6508l = 12;
        this.f6509m = 15;
        this.f6510n = 16;
        this.f6511o = 17;
        this.f6512p = 18;
        this.f6513q = 19;
        this.f6514r = 20;
        this.f6515s = 21;
        this.f6516t = 22;
    }

    public C1730gc(Cursor cursor) {
        try {
            this.f6497a = cursor.getColumnIndexOrThrow("transport_type");
        } catch (IllegalArgumentException e) {
        }
        try {
            this.f6498b = cursor.getColumnIndexOrThrow("_id");
        } catch (IllegalArgumentException e2) {
        }
        try {
            this.f6499c = cursor.getColumnIndexOrThrow("thread_id");
        } catch (IllegalArgumentException e3) {
        }
        try {
            this.f6500d = cursor.getColumnIndexOrThrow("address");
        } catch (IllegalArgumentException e4) {
        }
        try {
            this.f6501e = cursor.getColumnIndexOrThrow("body");
        } catch (IllegalArgumentException e5) {
        }
        try {
            this.f6502f = cursor.getColumnIndexOrThrow("date");
        } catch (IllegalArgumentException e6) {
        }
        try {
            this.f6503g = cursor.getColumnIndexOrThrow("type");
        } catch (IllegalArgumentException e7) {
        }
        try {
            this.f6504h = cursor.getColumnIndexOrThrow("status");
        } catch (IllegalArgumentException e8) {
        }
        try {
            this.f6505i = cursor.getColumnIndexOrThrow("locked");
        } catch (IllegalArgumentException e9) {
        }
        try {
            this.f6506j = cursor.getColumnIndexOrThrow(VKApiConst.ERROR_CODE);
        } catch (IllegalArgumentException e10) {
        }
        try {
            this.f6507k = cursor.getColumnIndexOrThrow("sub");
        } catch (IllegalArgumentException e11) {
        }
        try {
            this.f6508l = cursor.getColumnIndexOrThrow("sub_cs");
        } catch (IllegalArgumentException e12) {
        }
        try {
            this.f6509m = cursor.getColumnIndexOrThrow("m_type");
        } catch (IllegalArgumentException e13) {
        }
        try {
            this.f6510n = cursor.getColumnIndexOrThrow("msg_box");
        } catch (IllegalArgumentException e14) {
        }
        try {
            this.f6511o = cursor.getColumnIndexOrThrow("d_rpt");
        } catch (IllegalArgumentException e15) {
        }
        try {
            this.f6512p = cursor.getColumnIndexOrThrow("rr");
        } catch (IllegalArgumentException e16) {
        }
        try {
            this.f6513q = cursor.getColumnIndexOrThrow("err_type");
        } catch (IllegalArgumentException e17) {
        }
        try {
            this.f6514r = cursor.getColumnIndexOrThrow("locked");
        } catch (IllegalArgumentException e18) {
        }
        try {
            this.f6515s = 21;
        } catch (IllegalArgumentException e19) {
        }
        try {
            this.f6516t = 22;
        } catch (IllegalArgumentException e20) {
        }
        try {
            this.f6517u = cursor.getColumnIndexOrThrow("_id");
        } catch (IllegalArgumentException e21) {
        }
        try {
            this.f6518v = cursor.getColumnIndexOrThrow("message_sever_id");
        } catch (IllegalArgumentException e22) {
        }
        try {
            this.f6519w = cursor.getColumnIndexOrThrow("message_time");
        } catch (IllegalArgumentException e23) {
        }
        try {
            this.f6522z = cursor.getColumnIndexOrThrow("message_sender");
        } catch (IllegalArgumentException e24) {
        }
        try {
            this.f6482A = cursor.getColumnIndexOrThrow("message_session_id");
        } catch (IllegalArgumentException e25) {
        }
        try {
            this.f6483B = cursor.getColumnIndexOrThrow("message_inbox_no");
        } catch (IllegalArgumentException e26) {
        }
        try {
            this.f6484C = cursor.getColumnIndexOrThrow("message_formatted");
        } catch (IllegalArgumentException e27) {
        }
        try {
            this.f6485D = cursor.getColumnIndexOrThrow("message_sender");
        } catch (IllegalArgumentException e28) {
        }
        try {
            this.f6486E = cursor.getColumnIndexOrThrow("buddy_name");
        } catch (IllegalArgumentException e29) {
        }
        try {
            this.f6487F = cursor.getColumnIndexOrThrow("buddy_profile_status");
        } catch (IllegalArgumentException e30) {
        }
        try {
            this.f6488G = cursor.getColumnIndexOrThrow("message_content");
        } catch (IllegalArgumentException e31) {
        }
        try {
            this.f6489H = cursor.getColumnIndexOrThrow("message_content_translated");
        } catch (IllegalArgumentException e32) {
        }
        try {
            this.f6490I = cursor.getColumnIndexOrThrow("message_download_uri");
        } catch (IllegalArgumentException e33) {
        }
        try {
            this.f6491J = cursor.getColumnIndexOrThrow("message_from_lang");
            this.f6492K = cursor.getColumnIndexOrThrow("message_to_lang");
            this.f6493L = cursor.getColumnIndexOrThrow("message_is_spoken");
            this.f6494M = cursor.getColumnIndexOrThrow("message_is_failed");
            this.f6495N = cursor.getColumnIndexOrThrow("message_read_status");
        } catch (IllegalArgumentException e34) {
        }
        try {
            this.f6520x = cursor.getColumnIndexOrThrow("message_content_type");
        } catch (IllegalArgumentException e35) {
        }
        try {
            this.f6521y = cursor.getColumnIndexOrThrow("message_type");
        } catch (IllegalArgumentException e36) {
        }
        try {
            this.f6496O = cursor.getColumnIndexOrThrow("message_status");
        } catch (IllegalArgumentException e37) {
        }
    }
}
