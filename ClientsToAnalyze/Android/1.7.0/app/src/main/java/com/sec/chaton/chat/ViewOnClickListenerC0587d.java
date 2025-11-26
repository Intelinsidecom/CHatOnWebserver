package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.widget.ProfileImageView;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.d */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0587d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0603t f2016a;

    /* renamed from: b */
    private ProfileImageView f2017b;

    /* renamed from: c */
    private String f2018c;

    /* renamed from: d */
    private String f2019d;

    public ViewOnClickListenerC0587d(ViewOnClickListenerC0603t viewOnClickListenerC0603t, ProfileImageView profileImageView, String str, String str2) {
        this.f2016a = viewOnClickListenerC0603t;
        this.f2017b = profileImageView;
        this.f2018c = str;
        this.f2019d = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2016a.f2085y.mo2692a(view, this.f2017b, this.f2018c, this.f2019d);
    }
}
