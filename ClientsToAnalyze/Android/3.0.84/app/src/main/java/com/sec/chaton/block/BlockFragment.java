package com.sec.chaton.block;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
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
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.settings2.PrefFragmentPostONHide;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BlockFragment extends Fragment {

    /* renamed from: a */
    static boolean f1540a = false;

    /* renamed from: b */
    static ProgressDialog f1541b;

    /* renamed from: d */
    View f1543d;

    /* renamed from: h */
    private ListView f1547h;

    /* renamed from: i */
    private ArrayList<C0475ac> f1548i;

    /* renamed from: j */
    private C1328f f1549j;

    /* renamed from: k */
    private C0472a f1550k;

    /* renamed from: l */
    private View f1551l;

    /* renamed from: n */
    private Activity f1553n;

    /* renamed from: c */
    Dialog f1542c = null;

    /* renamed from: m */
    private boolean f1552m = true;

    /* renamed from: o */
    private MenuItem f1554o = null;

    /* renamed from: p */
    private MenuItem f1555p = null;

    /* renamed from: e */
    String[] f1544e = null;

    /* renamed from: q */
    private ArrayList<String> f1556q = null;

    /* renamed from: f */
    public Handler f1545f = new HandlerC0484j(this);

    /* renamed from: g */
    ContentObserver f1546g = new C0486l(this, new Handler());

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1553n = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1553n = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getContentResolver().registerContentObserver(C1441i.f5369a, true, this.f1546g);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.block_list_menu, menu);
        this.f1554o = menu.findItem(R.id.blocklist_menu_add);
        this.f1555p = menu.findItem(R.id.blocklist_menu_edit);
        if (this.f1554o != null) {
            if (C1360d.m6034b(this.f1553n.getContentResolver()) - C1360d.m6041c(this.f1553n.getContentResolver()) <= 0) {
                this.f1554o.setEnabled(false);
            } else {
                this.f1554o.setEnabled(true);
            }
            C3228cp.m11343a(this.f1554o);
        }
        if (this.f1548i != null && this.f1548i.size() == 0) {
            this.f1555p.setEnabled(false);
            C3228cp.m11343a(this.f1555p);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        switch (menuItem.getItemId()) {
            case R.id.blocklist_menu_add /* 2131166587 */:
                Intent intent = new Intent(getActivity(), (Class<?>) BuddyActivity2.class);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE", 9);
                intent.putExtra("ACTIVITY_PURPOSE_ARG2", 3);
                startActivityForResult(intent, 100);
                break;
            case R.id.blocklist_menu_edit /* 2131166588 */:
                Intent intent2 = new Intent(CommonApplication.m11493l(), (Class<?>) BlockListActivity.class);
                intent2.putExtra(PrefFragmentPostONHide.BLOCK_BUDDY_LIST, this.f1548i);
                startActivityForResult(intent2, 0);
                break;
        }
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (this.f1549j != null && f1541b != null) {
                    this.f1549j.m5704a();
                    f1541b.show();
                    break;
                }
                break;
            case 100:
                if (i2 == -1) {
                    C3250y.m11456e("Remove multiple block buddy", getClass().getSimpleName());
                    this.f1544e = (String[]) intent.getStringArrayExtra("blindlist").clone();
                    m3108a(this.f1544e);
                    break;
                }
                break;
        }
    }

    /* renamed from: a */
    public void m3108a(String[] strArr) {
        this.f1549j.m5708a(strArr);
        f1541b.show();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_blocked, viewGroup, false);
        this.f1548i = new ArrayList<>();
        BaseActivity.m3081a(this, true);
        this.f1553n.setTitle(this.f1553n.getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1548i.size()) + ")");
        f1541b = (ProgressDialog) new C3263j(this.f1553n).m11487a(R.string.dialog_connecting_server);
        this.f1551l = viewInflate.findViewById(R.id.no_item_layout);
        ((ImageView) this.f1551l.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_buddies);
        ((TextView) this.f1551l.findViewById(R.id.text1)).setText(getResources().getString(R.string.chat_title_no_buddies));
        ((TextView) this.f1551l.findViewById(R.id.text2)).setText(getResources().getString(R.string.setting_block_list_text));
        C0481g c0481g = new C0481g(this);
        this.f1550k = new C0472a(this.f1553n, R.layout.list_item_common_11, this.f1548i);
        this.f1550k.m3128a(c0481g);
        this.f1549j = new C1328f(this.f1545f);
        this.f1549j.m5704a();
        f1541b.show();
        this.f1547h = (ListView) viewInflate.findViewById(R.id.list);
        this.f1547h.setAdapter((ListAdapter) this.f1550k);
        this.f1547h.setOnItemSelectedListener(new C0482h(this));
        this.f1547h.setOnKeyListener(new ViewOnKeyListenerC0483i(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (f1541b != null) {
            f1541b.dismiss();
        }
        getActivity().getApplicationContext().getContentResolver().unregisterContentObserver(this.f1546g);
        super.onDestroy();
    }

    /* renamed from: a */
    public void m3107a() {
        if (this.f1553n != null && this.f1548i != null) {
            this.f1553n.setTitle(getResources().getString(R.string.setting_blocked_list) + " (" + Integer.toString(this.f1548i.size()) + ")");
            if (this.f1548i.size() == 0) {
                if (this.f1555p != null) {
                    this.f1555p.setEnabled(false);
                    C3228cp.m11343a(this.f1555p);
                }
                this.f1551l.setVisibility(0);
                return;
            }
            this.f1551l.setVisibility(8);
            if (this.f1555p != null) {
                this.f1555p.setEnabled(true);
                C3228cp.m11343a(this.f1555p);
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
        if (this.f1556q != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f1556q.size()) {
                    C3205bt.m11182a(this.f1553n).m11227b(this.f1556q.get(i2));
                    i = i2 + 1;
                } else {
                    this.f1556q.clear();
                    this.f1556q = null;
                    return;
                }
            }
        }
    }
}
