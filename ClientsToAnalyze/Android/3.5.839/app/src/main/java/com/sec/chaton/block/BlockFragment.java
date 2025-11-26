package com.sec.chaton.block;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BlockFragment extends Fragment {

    /* renamed from: a */
    static boolean f3405a = false;

    /* renamed from: b */
    static ProgressDialog f3406b;

    /* renamed from: d */
    View f3408d;

    /* renamed from: g */
    private ListView f3411g;

    /* renamed from: h */
    private ArrayList<C1093u> f3412h;

    /* renamed from: i */
    private C2126g f3413i;

    /* renamed from: j */
    private C1073a f3414j;

    /* renamed from: k */
    private ViewStub f3415k;

    /* renamed from: l */
    private View f3416l;

    /* renamed from: m */
    private ImageView f3417m;

    /* renamed from: n */
    private TextView f3418n;

    /* renamed from: o */
    private TextView f3419o;

    /* renamed from: q */
    private Activity f3421q;

    /* renamed from: c */
    Dialog f3407c = null;

    /* renamed from: p */
    private boolean f3420p = true;

    /* renamed from: r */
    private MenuItem f3422r = null;

    /* renamed from: s */
    private MenuItem f3423s = null;

    /* renamed from: e */
    String[] f3409e = null;

    /* renamed from: t */
    private ArrayList<String> f3424t = null;

    /* renamed from: f */
    public Handler f3410f = new HandlerC1081i(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3421q = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3421q = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) throws Throwable {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.block_list_menu, menu);
        this.f3422r = menu.findItem(R.id.blocklist_menu_add);
        this.f3423s = menu.findItem(R.id.blocklist_menu_edit);
        if (this.f3422r != null) {
            int iM9825c = C2190d.m9825c(this.f3421q.getContentResolver());
            if ((C2190d.m9798a(this.f3421q.getContentResolver()) - iM9825c) - C2190d.m9817b(this.f3421q.getContentResolver()) <= 0) {
                this.f3422r.setEnabled(false);
            } else {
                this.f3422r.setEnabled(true);
            }
            C4880cr.m18523a(this.f3422r);
        }
        if (this.f3412h != null && this.f3412h.size() == 0) {
            this.f3423s.setEnabled(false);
            C4880cr.m18523a(this.f3423s);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        switch (menuItem.getItemId()) {
            case R.id.blocklist_menu_add /* 2131166668 */:
                if (-3 == iM10677a || -2 == iM10677a) {
                    C5179v.m19810a(this.f3421q, R.string.popup_no_network_connection, 0).show();
                } else {
                    Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                    intent.putExtra("BUDDY_SORT_STYLE", 11);
                    intent.putExtra("ACTIVITY_PURPOSE", 25);
                    intent.putExtra("ACTIVITY_PURPOSE_ARG2", 3);
                    startActivityForResult(intent, 100);
                }
                return true;
            case R.id.blocklist_menu_edit /* 2131166669 */:
                if (-3 == iM10677a || -2 == iM10677a) {
                    C5179v.m19810a(this.f3421q, R.string.popup_no_network_connection, 0).show();
                } else if (!C4847bl.m18333a()) {
                    Intent intent2 = new Intent(CommonApplication.m18732r(), (Class<?>) BlockListActivity.class);
                    intent2.putExtra("block_buddy_list", this.f3412h);
                    startActivityForResult(intent2, 0);
                }
                return true;
            default:
                return true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (this.f3413i != null && f3406b != null) {
                    this.f3413i.m9477a();
                    f3406b.show();
                    break;
                }
                break;
            case 100:
                if (i2 == -1) {
                    C4904y.m18646e("Remove multiple block buddy", getClass().getSimpleName());
                    this.f3409e = (String[]) intent.getStringArrayExtra("blindlist").clone();
                    m6196a(this.f3409e);
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public void m6196a(String[] strArr) {
        this.f3413i.m9481a(strArr);
        if (f3406b != null && !f3406b.isShowing() && !getActivity().isFinishing()) {
            f3406b.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_blocked, viewGroup, false);
        this.f3412h = new ArrayList<>();
        BaseActivity.m6160a((Fragment) this, true);
        this.f3421q.setTitle(this.f3421q.getResources().getString(R.string.settings_blocked_contacts) + " (" + Integer.toString(this.f3412h.size()) + ")");
        f3406b = (ProgressDialog) new C4923p(this.f3421q).m18724a(R.string.dialog_connecting_server);
        this.f3415k = (ViewStub) viewInflate.findViewById(R.id.no_item_layout);
        C1078f c1078f = new C1078f(this);
        this.f3414j = new C1073a(this.f3421q, R.layout.list_item_common_5, this.f3412h);
        this.f3414j.m6221a(c1078f);
        this.f3413i = C2126g.m9476a(this.f3410f);
        this.f3413i.m9477a();
        f3406b.show();
        this.f3411g = (ListView) viewInflate.findViewById(R.id.list);
        this.f3411g.setAdapter((ListAdapter) this.f3414j);
        this.f3411g.setOnItemSelectedListener(new C1079g(this));
        this.f3411g.setOnKeyListener(new ViewOnKeyListenerC1080h(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (f3406b != null) {
            f3406b.dismiss();
        }
        super.onDestroy();
    }

    /* renamed from: a */
    public void m6195a() {
        if (this.f3421q != null && this.f3412h != null) {
            this.f3421q.setTitle(getResources().getString(R.string.settings_blocked_contacts) + " (" + Integer.toString(this.f3412h.size()) + ")");
            if (this.f3412h.size() == 0) {
                if (this.f3423s != null) {
                    this.f3423s.setEnabled(false);
                    C4880cr.m18523a(this.f3423s);
                    return;
                }
                return;
            }
            if (this.f3423s != null) {
                this.f3423s.setEnabled(true);
                C4880cr.m18523a(this.f3423s);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f3424t != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f3424t.size()) {
                    C2496n.m10790e(this.f3421q, this.f3424t.get(i2));
                    i = i2 + 1;
                } else {
                    this.f3424t.clear();
                    this.f3424t = null;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6188b() {
        if (this.f3416l == null) {
            this.f3416l = this.f3415k.inflate();
            this.f3417m = (ImageView) this.f3416l.findViewById(R.id.image1);
            this.f3417m.setImageResource(R.drawable.no_contents_buddies);
            this.f3418n = (TextView) this.f3416l.findViewById(R.id.text1);
            this.f3418n.setText(this.f3421q.getResources().getString(R.string.blocked_buddies_no_contacts));
            this.f3419o = (TextView) this.f3416l.findViewById(R.id.text2);
            this.f3419o.setText(this.f3421q.getResources().getString(R.string.setting_block_contacts_text));
            this.f3411g.setEmptyView(this.f3415k);
        }
    }
}
