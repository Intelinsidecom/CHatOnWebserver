package com.sec.chaton.buddy;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.y */
/* loaded from: classes.dex */
public class C0449y {

    /* renamed from: a */
    CheckBox f1704a;

    /* renamed from: b */
    ImageView f1705b;

    /* renamed from: c */
    ImageView f1706c;

    /* renamed from: d */
    TextView f1707d;

    /* renamed from: e */
    TextView f1708e;

    /* renamed from: f */
    RelativeLayout f1709f;

    /* renamed from: g */
    LinearLayout f1710g;

    /* renamed from: h */
    RelativeLayout f1711h;

    /* renamed from: i */
    ImageView f1712i;

    /* renamed from: j */
    ImageView f1713j;

    /* renamed from: k */
    Button f1714k;

    /* renamed from: l */
    ImageView f1715l;

    public C0449y(RelativeLayout relativeLayout) {
        this.f1709f = relativeLayout;
        this.f1704a = (CheckBox) this.f1709f.findViewById(R.id.buddy_child_check);
        this.f1705b = (ImageView) this.f1709f.findViewById(R.id.buddy_child_profile);
        this.f1707d = (TextView) this.f1709f.findViewById(R.id.buddy_child_name);
        this.f1708e = (TextView) this.f1709f.findViewById(R.id.buddy_child_status_msg);
    }

    public C0449y(LinearLayout linearLayout) {
        this.f1710g = linearLayout;
        this.f1704a = (CheckBox) this.f1710g.findViewById(R.id.buddy_child_check);
        this.f1705b = (ImageView) this.f1710g.findViewById(R.id.buddy_child_profile);
        this.f1706c = (ImageView) this.f1710g.findViewById(R.id.buddy_like_badge);
        this.f1707d = (TextView) this.f1710g.findViewById(R.id.buddy_child_name);
        this.f1708e = (TextView) this.f1710g.findViewById(R.id.buddy_child_status_msg);
        this.f1711h = (RelativeLayout) this.f1710g.findViewById(R.id.buddy_child_profile_outline);
        this.f1712i = (ImageView) this.f1710g.findViewById(R.id.buddy_selector);
        this.f1713j = (ImageView) this.f1710g.findViewById(R.id.buddy_chat_button);
        this.f1714k = (Button) this.f1710g.findViewById(R.id.buddy_add_button);
        this.f1715l = (ImageView) this.f1710g.findViewById(R.id.buddy_unselector);
    }
}
