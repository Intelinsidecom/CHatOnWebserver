package com.sec.chaton.block;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.BlockControl;
import com.sec.chaton.widget.SMSProgressBar;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BlockActivity extends FragmentActivity {

    /* renamed from: a */
    static boolean f345a = false;

    /* renamed from: b */
    static ProgressDialog f346b;

    /* renamed from: d */
    Context f348d;

    /* renamed from: f */
    private ListView f350f;

    /* renamed from: g */
    private ArrayList f351g;

    /* renamed from: h */
    private BlockControl f352h;

    /* renamed from: i */
    private BlockBuddyAdapter f353i;

    /* renamed from: j */
    private LinearLayout f354j;

    /* renamed from: c */
    Dialog f347c = null;

    /* renamed from: e */
    public Handler f349e = new HandlerC0072b(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f348d = this;
        setContentView(C0062R.layout.layout_blocked);
        this.f351g = new ArrayList();
        f346b = (ProgressDialog) new SMSProgressBar(this.f348d).onCreate(C0062R.string.dialog_connecting_server);
        this.f354j = (LinearLayout) findViewById(C0062R.id.no_item_layout);
        this.f353i = new BlockBuddyAdapter(this, C0062R.layout.layout_blocked, this.f351g, this.f354j);
        this.f350f = (ListView) findViewById(C0062R.id.list);
        this.f350f.setAdapter((ListAdapter) this.f353i);
        this.f352h = new BlockControl(this.f349e);
        this.f352h.m1989a();
        f346b.show();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
