package com.sec.chaton.hide;

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
import com.sec.chaton.block.C1093u;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.p055d.C2133n;
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
public class HideFragment extends Fragment {

    /* renamed from: a */
    static boolean f8396a = false;

    /* renamed from: b */
    static ProgressDialog f8397b;

    /* renamed from: d */
    View f8399d;

    /* renamed from: g */
    private ListView f8402g;

    /* renamed from: h */
    private ArrayList<C1093u> f8403h;

    /* renamed from: i */
    private C2133n f8404i;

    /* renamed from: j */
    private C2366a f8405j;

    /* renamed from: k */
    private ViewStub f8406k;

    /* renamed from: l */
    private View f8407l;

    /* renamed from: m */
    private ImageView f8408m;

    /* renamed from: n */
    private TextView f8409n;

    /* renamed from: o */
    private TextView f8410o;

    /* renamed from: p */
    private Activity f8411p;

    /* renamed from: c */
    Dialog f8398c = null;

    /* renamed from: q */
    private MenuItem f8412q = null;

    /* renamed from: r */
    private MenuItem f8413r = null;

    /* renamed from: e */
    String[] f8400e = null;

    /* renamed from: s */
    private ArrayList<String> f8414s = null;

    /* renamed from: f */
    public Handler f8401f = new HandlerC2375j(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8411p = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f8411p = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) throws Throwable {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.hide_list_menu, menu);
        this.f8412q = menu.findItem(R.id.hidelist_menu_add);
        this.f8413r = menu.findItem(R.id.hidelist_menu_edit);
        if (this.f8412q != null) {
            int iM9825c = C2190d.m9825c(this.f8411p.getContentResolver());
            if ((C2190d.m9798a(this.f8411p.getContentResolver()) - iM9825c) - C2190d.m9817b(this.f8411p.getContentResolver()) <= 0) {
                this.f8412q.setEnabled(false);
            } else {
                this.f8412q.setEnabled(true);
            }
            C4880cr.m18523a(this.f8412q);
        }
        if (this.f8403h != null && this.f8403h.size() == 0) {
            this.f8413r.setEnabled(false);
            C4880cr.m18523a(this.f8413r);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        if (!C4847bl.m18333a()) {
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            switch (menuItem.getItemId()) {
                case R.id.hidelist_menu_add /* 2131166706 */:
                    if (-3 == iM10677a || -2 == iM10677a) {
                        C5179v.m19810a(this.f8411p, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                        intent.putExtra("BUDDY_SORT_STYLE", 11);
                        intent.putExtra("ACTIVITY_PURPOSE", 24);
                        intent.putExtra("ACTIVITY_PURPOSE_ARG2", 2);
                        startActivityForResult(intent, 100);
                        break;
                    }
                case R.id.hidelist_menu_edit /* 2131166707 */:
                    if (-3 == iM10677a || -2 == iM10677a) {
                        C5179v.m19810a(this.f8411p, R.string.popup_no_network_connection, 0).show();
                        break;
                    } else {
                        Intent intent2 = new Intent(CommonApplication.m18732r(), (Class<?>) HideListActivity.class);
                        intent2.putExtra("hide_buddy_list", this.f8403h);
                        startActivityForResult(intent2, 0);
                        break;
                    }
            }
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (this.f8404i != null && f8397b != null) {
                    this.f8404i.m9558a();
                    f8397b.show();
                    break;
                }
                break;
            case 100:
                if (i2 == -1) {
                    C4904y.m18646e("Remove multiple hide buddy", getClass().getSimpleName());
                    this.f8400e = (String[]) intent.getStringArrayExtra("blindlist").clone();
                    m10335a(this.f8400e);
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public void m10335a(String[] strArr) {
        this.f8404i.m9561a(strArr);
        f8397b.show();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_hided, viewGroup, false);
        this.f8403h = new ArrayList<>();
        BaseActivity.m6160a((Fragment) this, true);
        this.f8411p.setTitle(this.f8411p.getResources().getString(R.string.settings_hided_contacts) + " (" + Integer.toString(this.f8403h.size()) + ")");
        f8397b = (ProgressDialog) new C4923p(this.f8411p).m18724a(R.string.dialog_connecting_server);
        this.f8406k = (ViewStub) viewInflate.findViewById(R.id.no_item_layout);
        C2372g c2372g = new C2372g(this);
        this.f8405j = new C2366a(this.f8411p, R.layout.list_item_common_5, this.f8403h);
        this.f8405j.m10354a(c2372g);
        this.f8404i = new C2133n(this.f8401f);
        this.f8404i.m9558a();
        f8397b.show();
        this.f8402g = (ListView) viewInflate.findViewById(R.id.list);
        this.f8402g.setAdapter((ListAdapter) this.f8405j);
        this.f8402g.setOnItemSelectedListener(new C2373h(this));
        this.f8402g.setOnKeyListener(new ViewOnKeyListenerC2374i(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (f8397b != null) {
            f8397b.dismiss();
        }
        super.onDestroy();
    }

    /* renamed from: a */
    public void m10334a() {
        if (this.f8411p != null && this.f8403h != null) {
            this.f8411p.setTitle(getResources().getString(R.string.settings_hided_contacts) + " (" + Integer.toString(this.f8403h.size()) + ")");
            if (this.f8403h.size() == 0) {
                if (this.f8413r != null) {
                    this.f8413r.setEnabled(false);
                    C4880cr.m18523a(this.f8413r);
                    return;
                }
                return;
            }
            if (this.f8413r != null) {
                this.f8413r.setEnabled(true);
                C4880cr.m18523a(this.f8413r);
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
        if (this.f8414s != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f8414s.size()) {
                    C2496n.m10790e(this.f8411p, this.f8414s.get(i2));
                    i = i2 + 1;
                } else {
                    this.f8414s.clear();
                    this.f8414s = null;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10327b() {
        if (this.f8407l == null) {
            this.f8407l = this.f8406k.inflate();
            this.f8408m = (ImageView) this.f8407l.findViewById(R.id.image1);
            this.f8408m.setImageResource(R.drawable.no_contents_buddies);
            this.f8409n = (TextView) this.f8407l.findViewById(R.id.text1);
            this.f8409n.setText(this.f8411p.getResources().getString(R.string.hidden_buddies_no_contacts));
            this.f8410o = (TextView) this.f8407l.findViewById(R.id.text2);
            this.f8410o.setText(this.f8411p.getResources().getString(R.string.setting_hidden_contacts_text));
            this.f8402g.setEmptyView(this.f8406k);
        }
    }
}
