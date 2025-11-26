package com.sec.chaton.buddy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.sec.chaton.R;

/* compiled from: TellFriendsFragment.java */
/* renamed from: com.sec.chaton.buddy.is */
/* loaded from: classes.dex */
public class C0789is {

    /* renamed from: a */
    private Drawable f3074a;

    /* renamed from: b */
    private String f3075b;

    /* renamed from: c */
    private Intent f3076c;

    public C0789is(Drawable drawable, CharSequence charSequence) {
        this.f3074a = drawable;
        this.f3075b = charSequence.toString();
    }

    /* renamed from: a */
    public void m4354a(Context context, String str) {
        this.f3076c = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", context.getString(R.string.sns_invite_message, " www.ChatON.com/invite.html "));
        this.f3076c.setPackage(str);
    }

    /* renamed from: a */
    public Drawable m4353a() {
        return this.f3074a;
    }

    /* renamed from: b */
    public String m4355b() {
        return this.f3075b;
    }

    /* renamed from: c */
    public Intent m4356c() {
        return this.f3076c;
    }
}
