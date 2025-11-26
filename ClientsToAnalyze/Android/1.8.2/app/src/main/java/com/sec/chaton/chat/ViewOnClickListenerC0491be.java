package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.widget.ProfileImageView;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.be */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0491be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0477as f2082a;

    /* renamed from: b */
    private ProfileImageView f2083b;

    /* renamed from: c */
    private String f2084c;

    /* renamed from: d */
    private String f2085d;

    public ViewOnClickListenerC0491be(ViewOnClickListenerC0477as viewOnClickListenerC0477as, ProfileImageView profileImageView, String str, String str2) {
        this.f2082a = viewOnClickListenerC0477as;
        this.f2083b = profileImageView;
        this.f2084c = str;
        this.f2085d = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2082a.f1968G.mo2593a(view, this.f2083b, this.f2084c, this.f2085d);
    }
}
