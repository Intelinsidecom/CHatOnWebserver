package com.sec.chaton.hide;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: HideImpl.java */
/* renamed from: com.sec.chaton.hide.g */
/* loaded from: classes.dex */
public class C1516g {

    /* renamed from: b */
    ProgressDialog f5576b;

    /* renamed from: d */
    View f5578d;

    /* renamed from: g */
    TextView f5581g;

    /* renamed from: h */
    private ListView f5582h;

    /* renamed from: i */
    private ArrayList<C1515f> f5583i;

    /* renamed from: j */
    private C1510a f5584j;

    /* renamed from: k */
    private LinearLayout f5585k;

    /* renamed from: l */
    private ImageView f5586l;

    /* renamed from: m */
    private TextView f5587m;

    /* renamed from: n */
    private TextView f5588n;

    /* renamed from: o */
    private Activity f5589o;

    /* renamed from: s */
    private InterfaceC1513d f5593s;

    /* renamed from: a */
    boolean f5575a = false;

    /* renamed from: c */
    Dialog f5577c = null;

    /* renamed from: p */
    private MenuItem f5590p = null;

    /* renamed from: q */
    private MenuItem f5591q = null;

    /* renamed from: e */
    String[] f5579e = null;

    /* renamed from: f */
    public int f5580f = 63;

    /* renamed from: r */
    private C1521l f5592r = null;

    /* renamed from: t */
    private MenuItem.OnMenuItemClickListener f5594t = null;

    /* renamed from: a */
    public void m6507a(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f5594t = onMenuItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m6497f() {
        if (this.f5576b != null && this.f5576b.isShowing()) {
            try {
                this.f5576b.dismiss();
            } catch (IllegalArgumentException e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    public void m6502a() {
        if (this.f5592r != null && this.f5576b != null) {
            this.f5576b.show();
            this.f5592r.m6513a();
        }
    }

    /* renamed from: a */
    public void m6504a(Activity activity) {
        C3250y.m11450b("onAttach", getClass().getSimpleName());
        this.f5589o = activity;
    }

    /* renamed from: b */
    public void m6509b() {
        C3250y.m11450b("onDetach", getClass().getSimpleName());
        this.f5589o = null;
    }

    /* renamed from: a */
    public void m6505a(Bundle bundle) {
        C3250y.m11450b("onCreate", getClass().getSimpleName());
        this.f5592r = new C1521l(this);
    }

    /* renamed from: c */
    public void m6510c() {
        C3250y.m11450b("onResume", getClass().getSimpleName());
        if (this.f5589o != null && this.f5583i != null) {
            if (!GlobalApplication.m6456e()) {
                this.f5589o.setTitle(this.f5589o.getResources().getString(R.string.settings_hided) + " (" + Integer.toString(this.f5583i.size()) + ")");
            } else {
                this.f5581g.setText(this.f5589o.getResources().getString(R.string.settings_hided) + " (" + Integer.toString(this.f5583i.size()) + ")");
            }
            if (this.f5583i.size() == 0) {
                if (this.f5591q != null) {
                    this.f5591q.setEnabled(false);
                }
                C3228cp.m11343a(this.f5591q);
                if (this.f5585k != null) {
                    this.f5585k.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.f5585k != null) {
                this.f5585k.setVisibility(8);
            }
            if (this.f5591q != null) {
                this.f5591q.setEnabled(true);
            }
            C3228cp.m11343a(this.f5591q);
        }
    }

    /* renamed from: d */
    public void m6511d() {
        C3250y.m11450b("onDestroy", getClass().getSimpleName());
        m6497f();
    }

    /* renamed from: a */
    public View m6501a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3250y.m11450b("onCreateView", getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(R.layout.layout_hided, viewGroup, false);
        this.f5583i = new ArrayList<>();
        this.f5576b = (ProgressDialog) new C3263j(this.f5589o).m11487a(R.string.dialog_connecting_server);
        if (GlobalApplication.m6456e()) {
            View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
            TextView textView = (TextView) viewFindViewById.findViewById(R.id.breadcrumb1);
            textView.setText(R.string.manage_buddies);
            textView.setClickable(true);
            textView.setOnClickListener(new ViewOnClickListenerC1517h(this));
            this.f5581g = (TextView) viewFindViewById.findViewById(R.id.breadcrumb2);
            this.f5581g.setText(R.string.settings_hided);
            this.f5581g.setTextColor(this.f5589o.getResources().getColor(R.color.buddy_list_item_status_changed));
            ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        }
        this.f5585k = (LinearLayout) viewInflate.findViewById(R.id.no_item_layout);
        this.f5586l = (ImageView) this.f5585k.findViewById(R.id.image1);
        this.f5586l.setImageResource(R.drawable.no_contents_buddies);
        this.f5587m = (TextView) this.f5585k.findViewById(R.id.text1);
        this.f5587m.setText(this.f5589o.getResources().getString(R.string.hidden_buddies_no_buddies));
        this.f5588n = (TextView) this.f5585k.findViewById(R.id.text2);
        this.f5588n.setText(this.f5589o.getResources().getString(R.string.setting_hidden_buddies_text));
        this.f5593s = new C1518i(this);
        this.f5584j = new C1510a(this.f5589o, R.layout.list_item_common_5, this.f5583i);
        this.f5584j.m6487a(this.f5593s);
        this.f5582h = (ListView) viewInflate.findViewById(R.id.list);
        this.f5582h.setVisibility(0);
        this.f5582h.setOnItemSelectedListener(new C1519j(this));
        this.f5582h.setOnKeyListener(new ViewOnKeyListenerC1520k(this));
        this.f5582h.setAdapter((ListAdapter) this.f5584j);
        if (this.f5592r != null && this.f5576b != null) {
            this.f5576b.show();
            this.f5592r.m6513a();
        }
        return viewInflate;
    }

    /* renamed from: a */
    public void m6506a(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.hide_list_menu, menu);
        this.f5590p = menu.findItem(R.id.hidelist_menu_add);
        this.f5591q = menu.findItem(R.id.hidelist_menu_edit);
        if (this.f5590p != null) {
            if (C1360d.m6034b(this.f5589o.getContentResolver()) - C1360d.m6041c(this.f5589o.getContentResolver()) <= 0) {
                this.f5590p.setEnabled(false);
            } else {
                this.f5590p.setEnabled(true);
            }
            if (GlobalApplication.m6456e() && this.f5594t != null) {
                this.f5590p.setOnMenuItemClickListener(this.f5594t);
            }
            C3228cp.m11343a(this.f5590p);
        }
        if (GlobalApplication.m6456e() && this.f5594t != null) {
            this.f5591q.setOnMenuItemClickListener(this.f5594t);
        }
        if (this.f5583i != null && this.f5583i.size() == 0) {
            this.f5591q.setEnabled(false);
            C3228cp.m11343a(this.f5591q);
        }
    }

    /* renamed from: a */
    public boolean m6508a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.hidelist_menu_add /* 2131166614 */:
                Intent intent = new Intent(this.f5589o, (Class<?>) BuddyActivity2.class);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE", 9);
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", 2);
                this.f5589o.startActivityForResult(intent, 100);
                break;
            case R.id.hidelist_menu_edit /* 2131166615 */:
                Intent intent2 = new Intent(CommonApplication.m11493l(), (Class<?>) HideListActivity.class);
                intent2.putExtra("hide_buddy_list", this.f5583i);
                this.f5589o.startActivityForResult(intent2, HttpResponseCode.f13733OK);
                break;
        }
        return true;
    }

    /* renamed from: a */
    public void m6503a(int i, int i2, Intent intent) {
        switch (i) {
            case 100:
                if (i2 == -1) {
                    C3250y.m11456e("Remove multiple hide buddy", getClass().getSimpleName());
                    this.f5579e = (String[]) intent.getStringArrayExtra("blindlist").clone();
                    this.f5584j.m6489a(this.f5579e);
                }
                if (this.f5592r != null && this.f5576b != null) {
                    this.f5576b.show();
                    this.f5592r.m6513a();
                    break;
                }
                break;
            case HttpResponseCode.f13733OK /* 200 */:
                if (this.f5592r != null && this.f5576b != null) {
                    this.f5576b.show();
                    this.f5592r.m6513a();
                    break;
                }
                break;
        }
    }

    /* renamed from: e */
    public ArrayList<C1515f> m6512e() {
        return this.f5583i;
    }
}
