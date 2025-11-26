package com.sec.chaton.buddy;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.at */
/* loaded from: classes.dex */
public class C0535at {

    /* renamed from: a */
    TextView f2491a;

    /* renamed from: b */
    ViewGroup f2492b;

    /* renamed from: c */
    View f2493c;

    /* renamed from: d */
    View f2494d;

    public C0535at(ViewGroup viewGroup) {
        this.f2492b = viewGroup;
        this.f2491a = (TextView) viewGroup.findViewById(R.id.text1);
        this.f2493c = viewGroup.findViewById(R.id.rootLayout);
        this.f2494d = viewGroup.findViewById(R.id.chat_unselector);
    }
}
