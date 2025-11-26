package com.sec.chaton.block;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.settings2.PrefFragmentBlock;
import com.sec.chaton.settings2.PrefFragmentPostONHide;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: BlockImpl.java */
/* renamed from: com.sec.chaton.block.m */
/* loaded from: classes.dex */
public class MenuItemOnMenuItemClickListenerC0487m implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    static boolean f1599a = false;

    /* renamed from: b */
    static ProgressDialog f1600b;

    /* renamed from: d */
    View f1602d;

    /* renamed from: f */
    private PrefFragmentBlock f1604f;

    /* renamed from: g */
    private ListView f1605g;

    /* renamed from: h */
    private ArrayList<C0475ac> f1606h;

    /* renamed from: i */
    private C1328f f1607i;

    /* renamed from: j */
    private C0472a f1608j;

    /* renamed from: k */
    private View f1609k;

    /* renamed from: m */
    private Activity f1611m;

    /* renamed from: p */
    private TextView f1614p;

    /* renamed from: c */
    Dialog f1601c = null;

    /* renamed from: l */
    private boolean f1610l = true;

    /* renamed from: n */
    private MenuItem f1612n = null;

    /* renamed from: o */
    private ArrayList<String> f1613o = null;

    /* renamed from: e */
    public Handler f1603e = new HandlerC0492r(this);

    public MenuItemOnMenuItemClickListenerC0487m(PrefFragmentBlock prefFragmentBlock) {
        this.f1604f = prefFragmentBlock;
    }

    /* renamed from: a */
    public void m3145a(Activity activity) {
        this.f1611m = activity;
    }

    /* renamed from: a */
    public void m3143a() {
        this.f1611m = null;
    }

    /* renamed from: a */
    public void m3148a(Menu menu, MenuInflater menuInflater) {
        Log.e("BIMA", "onCreateOptionsMenu");
        menuInflater.inflate(R.menu.block_list_menu, menu);
    }

    /* renamed from: a */
    public void m3147a(Menu menu) {
        Log.e("BIMA", "onPrepareOptionsMenu");
        this.f1612n = menu.findItem(R.id.blocklist_menu_edit);
        this.f1612n.setOnMenuItemClickListener(this);
        if (GlobalApplication.m6456e()) {
            menu.findItem(R.id.blocklist_menu_add).setOnMenuItemClickListener(this);
        }
    }

    /* renamed from: a */
    public boolean m3149a(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.blocklist_menu_add /* 2131166587 */:
                Intent intent = new Intent(CommonApplication.m11493l(), (Class<?>) BuddyActivity2.class);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE", 9);
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", 3);
                this.f1604f.startActivityForResult(intent, 100);
                break;
            case R.id.blocklist_menu_edit /* 2131166588 */:
                Intent intent2 = new Intent(CommonApplication.m11493l(), (Class<?>) BlockListActivity.class);
                intent2.putExtra(PrefFragmentPostONHide.BLOCK_BUDDY_LIST, this.f1606h);
                if (GlobalApplication.m6456e()) {
                    this.f1604f.startActivityForResult(intent2, 0);
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    public View m3142a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_blocked, viewGroup, false);
        this.f1606h = new ArrayList<>();
        f1600b = (ProgressDialog) new C3263j(this.f1611m).m11487a(R.string.dialog_connecting_server);
        if (GlobalApplication.m6456e()) {
            View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
            TextView textView = (TextView) viewFindViewById.findViewById(R.id.breadcrumb1);
            textView.setText(R.string.manage_buddies);
            textView.setClickable(true);
            textView.setOnClickListener(new ViewOnClickListenerC0488n(this));
            this.f1614p = (TextView) viewFindViewById.findViewById(R.id.breadcrumb2);
            this.f1614p.setText(R.string.settings_blocked);
            this.f1614p.setTextColor(this.f1611m.getResources().getColor(R.color.buddy_list_item_status_changed));
            ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        }
        this.f1609k = viewInflate.findViewById(R.id.no_item_layout);
        ((ImageView) this.f1609k.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_buddies);
        ((TextView) this.f1609k.findViewById(R.id.text1)).setText(this.f1611m.getResources().getString(R.string.chat_title_no_buddies));
        ((TextView) this.f1609k.findViewById(R.id.text2)).setText(this.f1611m.getResources().getString(R.string.setting_block_list_text));
        C0489o c0489o = new C0489o(this);
        this.f1608j = new C0472a(this.f1611m, R.layout.list_item_common_5, this.f1606h);
        this.f1608j.m3128a(c0489o);
        this.f1607i = new C1328f(this.f1603e);
        this.f1607i.m5704a();
        f1600b.show();
        this.f1605g = (ListView) viewInflate.findViewById(R.id.list);
        this.f1605g.setAdapter((ListAdapter) this.f1608j);
        this.f1605g.setOnItemSelectedListener(new C0490p(this));
        this.f1605g.setOnKeyListener(new ViewOnKeyListenerC0491q(this));
        return viewInflate;
    }

    /* renamed from: b */
    public void m3150b() {
        if (!GlobalApplication.m6456e() && this.f1607i != null && f1600b != null) {
            this.f1607i.m5704a();
            f1600b.show();
        }
    }

    /* renamed from: c */
    public void m3151c() {
        if (f1600b != null) {
            f1600b.dismiss();
        }
    }

    /* renamed from: a */
    public void m3144a(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                if (this.f1607i != null && f1600b != null) {
                    this.f1607i.m5704a();
                    f1600b.show();
                    break;
                }
                break;
            case 100:
                if (i2 == -1) {
                    C3250y.m11456e("Remove multiple block buddy", getClass().getSimpleName());
                    this.f1607i.m5708a((String[]) intent.getStringArrayExtra("blindlist").clone());
                    f1600b.show();
                    break;
                }
                break;
        }
    }

    /* renamed from: d */
    public void m3152d() {
        if (this.f1611m != null && this.f1606h != null) {
            if (!GlobalApplication.m6456e()) {
                this.f1611m.setTitle(this.f1611m.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1606h.size()) + ")");
            } else {
                this.f1614p.setText(this.f1611m.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1606h.size()) + ")");
            }
            if (this.f1606h.size() == 0) {
                if (this.f1612n != null) {
                    if (!GlobalApplication.m6456e()) {
                        this.f1612n.setVisible(false);
                    } else {
                        this.f1612n.setEnabled(false);
                        C3228cp.m11343a(this.f1612n);
                    }
                }
                this.f1609k.setVisibility(0);
                return;
            }
            this.f1609k.setVisibility(8);
            if (this.f1612n != null) {
                if (!GlobalApplication.m6456e()) {
                    this.f1612n.setVisible(true);
                } else {
                    this.f1612n.setEnabled(true);
                    C3228cp.m11343a(this.f1612n);
                }
            }
        }
    }

    /* renamed from: a */
    public void m3146a(Bundle bundle) {
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return m3149a(menuItem);
    }
}
