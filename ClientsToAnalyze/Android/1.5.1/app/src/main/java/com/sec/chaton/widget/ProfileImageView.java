package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ProfileImageLoader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ProfileImageView extends ImageView {

    /* renamed from: a */
    int f3795a;

    /* renamed from: b */
    ArrayList f3796b;

    /* renamed from: c */
    private Context f3797c;

    /* renamed from: d */
    private String f3798d;

    /* renamed from: e */
    private String f3799e;

    /* renamed from: f */
    private View.OnClickListener f3800f;

    /* renamed from: g */
    private View.OnClickListener f3801g;

    public ProfileImageView(Context context) {
        super(context);
        this.f3799e = null;
        this.f3795a = 0;
        this.f3796b = new ArrayList();
        this.f3800f = new ViewOnClickListenerC0623d(this);
        this.f3801g = new ViewOnClickListenerC0621b(this);
        this.f3797c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3799e = null;
        this.f3795a = 0;
        this.f3796b = new ArrayList();
        this.f3800f = new ViewOnClickListenerC0623d(this);
        this.f3801g = new ViewOnClickListenerC0621b(this);
        this.f3797c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3799e = null;
        this.f3795a = 0;
        this.f3796b = new ArrayList();
        this.f3800f = new ViewOnClickListenerC0623d(this);
        this.f3801g = new ViewOnClickListenerC0621b(this);
        this.f3797c = context;
    }

    public void init(View view, ChatONContract.InBoxTable.ChatType chatType) {
        switch (chatType) {
            case ONETOONE:
                ProfileImageLoader.m3610a(getContext()).m3622a((ImageView) view, ProfileImageLoader.ImageType.BUDDY);
                setOnClickListener(this.f3801g);
                break;
            case GROUPCHAT:
                ProfileImageLoader.m3610a(getContext()).m3622a((ImageView) view, ProfileImageLoader.ImageType.GROUP);
                setOnClickListener(this.f3800f);
                break;
            case BROADCAST:
                ProfileImageLoader.m3610a(getContext()).m3622a((ImageView) view, ProfileImageLoader.ImageType.BROADCAST);
                setOnClickListener(this.f3800f);
                break;
        }
    }

    public void setBuddyName(String str) {
        this.f3799e = str;
    }

    public void setBuddyNo(String str) {
        this.f3798d = str;
    }
}
