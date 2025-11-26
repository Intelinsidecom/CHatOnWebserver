package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.C0703r;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p017e.p019b.C0686m;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.p017e.p019b.InterfaceC0687n;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class MyPageRelationshipRankFragment extends Fragment implements TabHost.OnTabChangeListener, InterfaceC0667k {

    /* renamed from: d */
    private static C0666j f5924d;

    /* renamed from: g */
    private static int f5925g;

    /* renamed from: t */
    private static ProgressDialog f5926t;

    /* renamed from: u */
    private static Handler f5927u = new HandlerC1641ar();

    /* renamed from: a */
    String f5928a;

    /* renamed from: e */
    private ProgressDialog f5931e;

    /* renamed from: f */
    private ProgressDialog f5932f;

    /* renamed from: h */
    private ListView f5933h;

    /* renamed from: i */
    private LinearLayout f5934i;

    /* renamed from: j */
    private LinearLayout f5935j;

    /* renamed from: k */
    private ArrayList f5936k;

    /* renamed from: l */
    private TabHost f5937l;

    /* renamed from: m */
    private TabWidget f5938m;

    /* renamed from: n */
    private String f5939n;

    /* renamed from: o */
    private ArrayAdapter f5940o;

    /* renamed from: p */
    private TextView f5941p;

    /* renamed from: r */
    private String f5943r;

    /* renamed from: s */
    private View f5944s;

    /* renamed from: v */
    private View f5945v;

    /* renamed from: w */
    private AlertDialog f5946w;

    /* renamed from: q */
    private int f5942q = 1;

    /* renamed from: b */
    InterfaceC0677d f5929b = new C1639ap(this);

    /* renamed from: c */
    InterfaceC0687n f5930c = new C1640aq(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6061b("onCreate", getClass().getSimpleName());
        f5926t = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_userprofile_updating);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("current_position", this.f5937l.getCurrentTabTag());
    }

    /* renamed from: a */
    private void m5661a(View view, LayoutInflater layoutInflater) {
        this.f5937l = (TabHost) view.findViewById(R.id.TabHost01);
        this.f5937l.setup();
        this.f5938m = (TabWidget) view.findViewById(android.R.id.tabs);
        this.f5937l.addTab(this.f5937l.newTabSpec("week1").setIndicator(m5678a(1, layoutInflater)).setContent(R.id.tabcontent));
        this.f5937l.addTab(this.f5937l.newTabSpec("week2").setIndicator(m5678a(2, layoutInflater)).setContent(R.id.tabcontent));
        this.f5937l.addTab(this.f5937l.newTabSpec("week3").setIndicator(m5678a(3, layoutInflater)).setContent(R.id.tabcontent));
        this.f5937l.addTab(this.f5937l.newTabSpec("week4").setIndicator(m5678a(4, layoutInflater)).setContent(R.id.tabcontent));
        this.f5937l.setOnTabChangedListener(this);
        this.f5937l.setCurrentTab(1);
    }

    /* renamed from: a */
    RelativeLayout m5678a(int i, LayoutInflater layoutInflater) {
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.mypage_interaction_tab_indicator, (ViewGroup) this.f5938m, false);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
        textView.setText(getString(R.string.interaction_rank_week, Integer.valueOf(i)));
        textView.setTextColor(getResources().getColorStateList(R.drawable.tab_title_font_color));
        return relativeLayout;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1786r.m6061b("onCreateView", getClass().getSimpleName());
        this.f5944s = layoutInflater.inflate(R.layout.layout_relationshiprank2_wgui, viewGroup, false);
        this.f5933h = (ListView) this.f5944s.findViewById(R.id.relationship_list);
        this.f5934i = (LinearLayout) this.f5944s.findViewById(R.id.no_item_layout);
        this.f5935j = (LinearLayout) this.f5944s.findViewById(R.id.week_title);
        this.f5945v = this.f5944s.findViewById(R.id.listview_top3dumpview);
        this.f5941p = (TextView) this.f5944s.findViewById(R.id.week_layout_title);
        this.f5941p.setText(getString(R.string.interaction_rank_week, 1));
        this.f5934i.setVisibility(0);
        this.f5936k = new ArrayList();
        f5924d = new C0666j(getActivity().getContentResolver(), this);
        this.f5928a = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        m5673f();
        this.f5940o = new C1644au(getActivity(), 0, this.f5936k);
        this.f5933h.setAdapter((ListAdapter) this.f5940o);
        this.f5933h.setOnItemClickListener(new C1635al(this));
        this.f5933h.setOnItemLongClickListener(new C1636am(this));
        m5661a(this.f5944s, layoutInflater);
        this.f5937l.setCurrentTab(0);
        return this.f5944s;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f5946w != null && this.f5946w.isShowing()) {
            if (configuration.orientation == 2) {
                C1786r.m6061b("ORIENTATION_LANDSCAPE", getClass().getSimpleName());
                this.f5946w.dismiss();
                m5660a(m5677i(), getString(R.string.setting_interaction_rank) + ":" + m5676h());
            } else if (configuration.orientation == 1) {
                C1786r.m6061b("ORIENTATION_PORTRAIT", getClass().getSimpleName());
                this.f5946w.dismiss();
                m5660a(m5677i(), getString(R.string.setting_interaction_rank) + ":" + m5676h());
            }
        }
    }

    /* renamed from: a */
    protected void m5679a() {
        C1786r.m6061b("relationUpdateTime=" + C1789u.m6075a().getString("relationUpdateTime", ""), getClass().getSimpleName());
        this.f5943r = new SimpleDateFormat("MMM dd, yyyy HH:mm").format(Long.valueOf(System.currentTimeMillis()));
        this.f5931e = ProgressDialogC1806j.m6141a(getActivity(), null, getResources().getString(R.string.interaction_updating), true);
        C0668l.m3077a(new C0668l(), -1, new C0686m(this.f5929b, this.f5943r, null));
    }

    /* renamed from: f */
    private void m5673f() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(5, -1);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(5, -7);
        DateFormat dateInstance = DateFormat.getDateInstance();
        dateInstance.format(new Date(calendar.getTimeInMillis()));
        dateInstance.format(new Date(calendar2.getTimeInMillis()));
        dateInstance.format(new Date(calendar3.getTimeInMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5658a(int i) {
        f5924d.startQuery(-1, null, C0703r.m3166a(), null, "relation_date = ?  AND buddy_relation_hide = 'N'  AND relation_rank != 0 ", new String[]{Integer.toString(i)}, "relation_rank ASC LIMIT 30");
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1786r.m6061b("onStart", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.containsKey("current_position")) {
            this.f5939n = bundle.getString("current_position");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6061b("onResume", getClass().getSimpleName());
        if (!TextUtils.isEmpty(this.f5939n)) {
            this.f5937l.setCurrentTabByTag(this.f5939n);
            this.f5939n = null;
        }
        BaseActivity.m1827a(this, true);
        C0686m.m3110a(this.f5930c);
        C1786r.m6066e("Is Updating : " + C0686m.m3114b(), getClass().getSimpleName());
        if (C0686m.m3114b()) {
            this.f5932f = ProgressDialogC1806j.m6141a(getActivity(), null, getResources().getString(R.string.interaction_updating), true);
        } else {
            m5658a(this.f5942q);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1786r.m6061b("onPause", getClass().getSimpleName());
        if (this.f5931e != null) {
            C1786r.m6061b("mProgressDialog_refresh onPause", getClass().getSimpleName());
            this.f5931e.dismiss();
        }
        if (f5926t != null) {
            f5926t.dismiss();
        }
        C0686m.m3113b(this.f5930c);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C1786r.m6061b("item =" + menuItem.getItemId(), getClass().getSimpleName());
        switch (menuItem.getItemId()) {
            case 1:
                m5679a();
                break;
        }
        return true;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        try {
            if (getActivity() != null) {
                if (cursor == null || cursor.getCount() <= 0) {
                    this.f5933h.setVisibility(8);
                    this.f5945v.setVisibility(8);
                    this.f5934i.setVisibility(0);
                } else {
                    this.f5933h.setVisibility(0);
                    this.f5945v.setVisibility(0);
                    this.f5934i.setVisibility(8);
                    this.f5935j.setVisibility(0);
                    m5659a(cursor);
                }
                if (this.f5940o != null && this.f5940o.getCount() != 0) {
                    m5675g();
                    this.f5940o.notifyDataSetChanged();
                    if (cursor == null) {
                    }
                } else if (cursor == null) {
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (i == 0) {
            if (i2 == 1) {
                m5658a(this.f5942q);
            } else {
                C2153y.m7536a(getActivity(), getResources().getString(R.string.buddy_profile_saveprofile_toast_failed), 1).show();
            }
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }

    /* renamed from: a */
    private void m5659a(Cursor cursor) {
        if (cursor != null) {
            this.f5936k.clear();
            while (cursor.moveToNext()) {
                C0257c c0257c = new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
                c0257c.m2334f(cursor.getPosition() + 1);
                if (cursor.getPosition() == 0) {
                    f5925g = c0257c.m2341m();
                }
                if (cursor.getPosition() < 4) {
                    c0257c.m2330d(5);
                }
                this.f5936k.add(c0257c);
            }
        }
    }

    /* renamed from: g */
    private void m5675g() {
        if (getActivity() != null && this.f5940o.getCount() != 0) {
            LinearLayout linearLayout = (LinearLayout) this.f5944s.findViewById(R.id.top3DumpView);
            linearLayout.removeAllViews();
            LayoutInflater.from(getActivity()).inflate(R.layout.list_relationship_rank_header_for_share, (ViewGroup) linearLayout, true);
            for (int i = 0; i < 3 && i < this.f5940o.getCount(); i++) {
                linearLayout.addView(this.f5940o.getView(i, null, linearLayout), -1, -2);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.f5944s.findViewById(R.id.top3DumpViewLand);
            linearLayout2.removeAllViews();
            LayoutInflater.from(getActivity()).inflate(R.layout.list_relationship_rank_header_for_share, (ViewGroup) linearLayout2, true);
            for (int i2 = 0; i2 < 3 && i2 < this.f5940o.getCount(); i2++) {
                linearLayout2.addView(this.f5940o.getView(i2, null, linearLayout2), -1, -2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public String m5676h() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = (Calendar) calendar.clone();
        Calendar calendar3 = (Calendar) calendar.clone();
        DateFormat dateInstance = DateFormat.getDateInstance();
        dateInstance.format(new Date(calendar.getTimeInMillis()));
        calendar2.add(5, -1);
        String str = dateInstance.format(new Date(calendar2.getTimeInMillis()));
        new SimpleDateFormat("yyyy-MM-dd").format(new Date(calendar2.getTimeInMillis()));
        calendar3.add(5, -7);
        return dateInstance.format(new Date(calendar3.getTimeInMillis())) + " - " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5660a(Bitmap bitmap, String str) {
        ScrollView scrollView = new ScrollView(getActivity());
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageBitmap(bitmap);
        scrollView.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
        this.f5946w = new AlertDialogBuilderC2120a(getActivity()).setTitle(getActivity().getResources().getString(R.string.share)).setPositiveButton(R.string.cancel, new DialogInterfaceOnClickListenerC1643at(this)).setNegativeButton(R.string.share, new DialogInterfaceOnClickListenerC1642as(this, bitmap, str)).create();
        this.f5946w.setView(scrollView, 0, 0, 0, 0);
        this.f5946w.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public Bitmap m5677i() {
        LinearLayout linearLayout;
        if (getResources().getConfiguration().orientation == 2) {
            linearLayout = (LinearLayout) this.f5944s.findViewById(R.id.top3DumpViewLand);
        } else {
            linearLayout = (LinearLayout) this.f5944s.findViewById(R.id.top3DumpView);
        }
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(linearLayout.getLayoutParams().width, 0), View.MeasureSpec.makeMeasureSpec(linearLayout.getLayoutParams().height, 0));
        linearLayout.layout(0, 0, linearLayout.getMeasuredWidth(), linearLayout.getMeasuredHeight());
        linearLayout.buildDrawingCache();
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(linearLayout.getDrawingCache(), linearLayout.getWidth(), linearLayout.getHeight(), true);
        linearLayout.draw(new Canvas(bitmapCreateScaledBitmap));
        return bitmapCreateScaledBitmap;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if (str.equals("week1")) {
            m5658a(1);
            this.f5941p.setText(getString(R.string.interaction_rank_week, 1));
            this.f5942q = 1;
            return;
        }
        if (str.equals("week2")) {
            m5658a(2);
            this.f5941p.setText(getString(R.string.interaction_rank_week, 2));
            this.f5942q = 2;
        } else if (str.equals("week3")) {
            m5658a(3);
            this.f5941p.setText(getString(R.string.interaction_rank_week, 3));
            this.f5942q = 3;
        } else if (str.equals("week4")) {
            m5658a(4);
            this.f5941p.setText(getString(R.string.interaction_rank_week, 4));
            this.f5942q = 4;
        } else {
            m5658a(1);
            this.f5941p.setText(getString(R.string.interaction_rank_week, 1));
            this.f5942q = 1;
        }
    }
}
