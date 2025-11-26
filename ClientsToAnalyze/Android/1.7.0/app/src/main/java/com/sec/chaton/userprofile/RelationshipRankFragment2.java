package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.p013a.C0197aj;
import com.sec.chaton.p025d.C0658k;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.p025d.p027b.C0640c;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.p025d.p027b.InterfaceC0642e;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class RelationshipRankFragment2 extends Fragment implements InterfaceC0626f, InterfaceC1238bh {

    /* renamed from: g */
    private static C0630j f4189g;

    /* renamed from: C */
    private View f4192C;

    /* renamed from: D */
    private AlertDialog f4193D;

    /* renamed from: a */
    String f4194a;

    /* renamed from: b */
    Context f4195b;

    /* renamed from: c */
    GeneralHeaderView f4196c;

    /* renamed from: h */
    private ProgressDialog f4200h;

    /* renamed from: i */
    private ProgressDialog f4201i;

    /* renamed from: j */
    private int f4202j;

    /* renamed from: k */
    private ListView f4203k;

    /* renamed from: l */
    private LinearLayout f4204l;

    /* renamed from: m */
    private LinearLayout f4205m;

    /* renamed from: n */
    private ArrayList f4206n;

    /* renamed from: o */
    private C1276z f4207o;

    /* renamed from: p */
    private Button f4208p;

    /* renamed from: q */
    private Button f4209q;

    /* renamed from: r */
    private Button f4210r;

    /* renamed from: s */
    private Button f4211s;

    /* renamed from: t */
    private TextView f4212t;

    /* renamed from: v */
    private String f4214v;

    /* renamed from: w */
    private View f4215w;

    /* renamed from: x */
    private ProgressDialog f4216x;

    /* renamed from: y */
    private String f4217y;

    /* renamed from: z */
    private C0197aj f4218z;

    /* renamed from: u */
    private int f4213u = 1;

    /* renamed from: d */
    View.OnClickListener f4197d = new ViewOnClickListenerC1241bk(this);

    /* renamed from: e */
    InterfaceC0641d f4198e = new C1246bp(this);

    /* renamed from: f */
    InterfaceC0642e f4199f = new C1245bo(this);

    /* renamed from: A */
    private final Handler f4190A = new HandlerC1248br(this);

    /* renamed from: B */
    private ContentObserver f4191B = new C1242bl(this, new Handler());

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4658b("onCreate", getClass().getSimpleName());
        this.f4216x = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.dialog_userprofile_updating);
        this.f4195b = getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1341p.m4658b("onCreateView", getClass().getSimpleName());
        this.f4215w = layoutInflater.inflate(R.layout.layout_relationshiprank2, viewGroup, false);
        this.f4203k = (ListView) this.f4215w.findViewById(R.id.relationship_list);
        this.f4204l = (LinearLayout) this.f4215w.findViewById(R.id.no_item_layout);
        this.f4205m = (LinearLayout) this.f4215w.findViewById(R.id.week_title);
        this.f4218z = new C0197aj(this.f4190A);
        getActivity().getContentResolver().registerContentObserver(C0658k.f2285a, true, this.f4191B);
        getActivity().getContentResolver().registerContentObserver(C0667t.f2310a, true, this.f4191B);
        this.f4196c = (GeneralHeaderView) this.f4215w.findViewById(R.id.relation_headerview);
        this.f4196c.setButtonClickListener(new ViewOnClickListenerC1240bj(this));
        this.f4192C = this.f4215w.findViewById(R.id.listview_top3dumpview);
        this.f4208p = (Button) this.f4215w.findViewById(R.id.week1);
        this.f4209q = (Button) this.f4215w.findViewById(R.id.week2);
        this.f4210r = (Button) this.f4215w.findViewById(R.id.week3);
        this.f4211s = (Button) this.f4215w.findViewById(R.id.week4);
        this.f4212t = (TextView) this.f4215w.findViewById(R.id.week_layout_title);
        this.f4208p.setSelected(true);
        this.f4212t.setText(getString(R.string.interaction_rank_week, 1));
        this.f4208p.setShadowLayer(0.1f, 0.1f, -0.1f, R.color.interaction_week_click_shadow);
        this.f4209q.setShadowLayer(0.1f, 0.1f, -0.1f, R.color.interaction_week_shadow);
        this.f4210r.setShadowLayer(0.1f, 0.1f, -0.1f, R.color.interaction_week_shadow);
        this.f4211s.setShadowLayer(0.1f, 0.1f, -0.1f, R.color.interaction_week_shadow);
        this.f4208p.setContentDescription(getString(R.string.interaction_rank_week, 1));
        this.f4209q.setContentDescription(getString(R.string.interaction_rank_week, 2));
        this.f4210r.setContentDescription(getString(R.string.interaction_rank_week, 3));
        this.f4211s.setContentDescription(getString(R.string.interaction_rank_week, 4));
        this.f4208p.setOnClickListener(this.f4197d);
        this.f4208p.setText(getString(R.string.interaction_rank_week, 1));
        this.f4209q.setOnClickListener(this.f4197d);
        this.f4209q.setText(getString(R.string.interaction_rank_week, 2));
        this.f4210r.setOnClickListener(this.f4197d);
        this.f4210r.setText(getString(R.string.interaction_rank_week, 3));
        this.f4211s.setOnClickListener(this.f4197d);
        this.f4211s.setText(getString(R.string.interaction_rank_week, 4));
        this.f4206n = new ArrayList();
        f4189g = new C0630j(getActivity().getContentResolver(), this);
        this.f4194a = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        m4358c();
        this.f4207o = new C1276z(getActivity(), 0, this.f4206n);
        this.f4207o.m4431a(this);
        this.f4203k.setAdapter((ListAdapter) this.f4207o);
        return this.f4215w;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().getContentResolver().unregisterContentObserver(this.f4191B);
        if (this.f4207o != null) {
            this.f4207o.m4431a(null);
        }
        if (this.f4216x != null) {
            this.f4216x.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f4193D != null && this.f4193D.isShowing()) {
            if (configuration.orientation == 2) {
                C1341p.m4658b("ORIENTATION_LANDSCAPE", getClass().getSimpleName());
                this.f4193D.dismiss();
                m4351a(m4363f(), getString(R.string.setting_interaction_rank) + ":" + m4362e());
            } else if (configuration.orientation == 1) {
                C1341p.m4658b("ORIENTATION_PORTRAIT", getClass().getSimpleName());
                this.f4193D.dismiss();
                m4351a(m4363f(), getString(R.string.setting_interaction_rank) + ":" + m4362e());
            }
        }
    }

    /* renamed from: a */
    protected void m4373a() {
        C1341p.m4658b("relationUpdateTime=" + C1323bs.m4575a().getString("relationUpdateTime", ""), getClass().getSimpleName());
        this.f4214v = new SimpleDateFormat("MMM dd, yyyy HH:mm").format(Long.valueOf(System.currentTimeMillis()));
        this.f4200h = ProgressDialogC1354a.m4724a(getActivity(), null, getResources().getString(R.string.interaction_updating), true);
        C0627g.m2858a(new C0627g(), -1, new C0640c(this.f4198e, this.f4214v, null));
    }

    /* renamed from: c */
    private void m4358c() {
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
    public void m4349a(int i) {
        f4189g.startQuery(-1, null, C0658k.m2990a(), null, "relation_date = ?  AND relation_rank != 0 ", new String[]{Integer.toString(i)}, "relation_rank ASC LIMIT 30");
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1341p.m4658b("onStart", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1341p.m4658b("onResume", getClass().getSimpleName());
        BaseActivity.m2041a(this, true);
        C0640c.m2962a(this.f4199f);
        C1341p.m4662e("Is Updating : " + C0640c.m2966b(), getClass().getSimpleName());
        if (C0640c.m2966b()) {
            this.f4201i = ProgressDialogC1354a.m4724a(getActivity(), null, getResources().getString(R.string.interaction_updating), true);
        } else {
            m4349a(this.f4213u);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1341p.m4658b("onPause", getClass().getSimpleName());
        if (this.f4200h != null) {
            C1341p.m4658b("mProgressDialog_refresh onPause", getClass().getSimpleName());
            this.f4200h.dismiss();
        }
        C0640c.m2965b(this.f4199f);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C1341p.m4658b("item =" + menuItem.getItemId(), getClass().getSimpleName());
        switch (menuItem.getItemId()) {
            case 1:
                m4373a();
                break;
        }
        return true;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        try {
            if (getActivity() != null) {
                if (cursor == null || cursor.getCount() <= 0) {
                    this.f4203k.setVisibility(8);
                    this.f4196c.setButtonEnabled(false);
                    this.f4192C.setVisibility(8);
                    this.f4204l.setVisibility(0);
                } else {
                    this.f4203k.setVisibility(0);
                    this.f4196c.setButtonEnabled(true);
                    this.f4192C.setVisibility(0);
                    this.f4204l.setVisibility(8);
                    this.f4205m.setVisibility(0);
                    m4350a(cursor);
                }
                if (this.f4207o != null && this.f4207o.getCount() != 0) {
                    this.f4207o.notifyDataSetChanged();
                    m4360d();
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

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
        if (i == 0) {
            if (i2 == 1) {
                m4349a(this.f4213u);
            } else {
                C1619g.m5889a(getActivity(), getResources().getString(R.string.buddy_profile_saveprofile_toast_failed), 1).show();
            }
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
    }

    /* renamed from: a */
    private void m4350a(Cursor cursor) {
        if (cursor != null) {
            this.f4206n.clear();
            while (cursor.moveToNext()) {
                C0363a c0363a = new C0363a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
                c0363a.m2317c(cursor.getPosition() + 1);
                if (cursor.getPosition() == 0) {
                    this.f4202j = c0363a.m2327m();
                }
                if (cursor.getPosition() < 4) {
                    c0363a.m2309a(5);
                }
                this.f4206n.add(c0363a);
            }
        }
    }

    @Override // com.sec.chaton.userprofile.InterfaceC1238bh
    /* renamed from: a */
    public void mo4374a(String str, String str2) {
        this.f4217y = str2;
        AlertDialogBuilderC1625m alertDialogBuilderC1625m = new AlertDialogBuilderC1625m(this.f4195b);
        alertDialogBuilderC1625m.setTitle(str);
        alertDialogBuilderC1625m.setMessage(String.format(this.f4195b.getResources().getString(R.string.settings_hide_interaction_with), str));
        alertDialogBuilderC1625m.setPositiveButton(R.string.done, new DialogInterfaceOnClickListenerC1247bq(this, str2));
        alertDialogBuilderC1625m.setNeutralButton(R.string.cancel, new DialogInterfaceOnClickListenerC1243bm(this));
        alertDialogBuilderC1625m.show();
    }

    /* renamed from: d */
    private void m4360d() {
        if (getActivity() != null && this.f4207o.getCount() != 0) {
            LinearLayout linearLayout = (LinearLayout) this.f4215w.findViewById(R.id.top3DumpView);
            linearLayout.removeAllViews();
            LayoutInflater.from(getActivity()).inflate(R.layout.list_relationship_rank_header_for_share, (ViewGroup) linearLayout, true);
            for (int i = 0; i < 3 && i < this.f4207o.getCount(); i++) {
                linearLayout.addView(this.f4207o.getView(i, null, linearLayout), -1, -2);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.f4215w.findViewById(R.id.top3DumpViewLand);
            linearLayout2.removeAllViews();
            LayoutInflater.from(getActivity()).inflate(R.layout.list_relationship_rank_header_for_share, (ViewGroup) linearLayout2, true);
            for (int i2 = 0; i2 < 3 && i2 < this.f4207o.getCount(); i2++) {
                linearLayout2.addView(this.f4207o.getView(i2, null, linearLayout2), -1, -2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public String m4362e() {
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
    public void m4351a(Bitmap bitmap, String str) {
        ScrollView scrollView = new ScrollView(getActivity());
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageBitmap(bitmap);
        scrollView.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
        this.f4193D = new AlertDialogBuilderC1625m(getActivity()).setTitle(getActivity().getResources().getString(R.string.share)).setPositiveButton(R.string.share, new DialogInterfaceOnClickListenerC1224au(this, bitmap, str)).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC1244bn(this)).create();
        this.f4193D.setView(scrollView, 0, 0, 0, 0);
        this.f4193D.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public Bitmap m4363f() {
        LinearLayout linearLayout;
        if (getResources().getConfiguration().orientation == 2) {
            linearLayout = (LinearLayout) this.f4215w.findViewById(R.id.top3DumpViewLand);
        } else {
            linearLayout = (LinearLayout) this.f4215w.findViewById(R.id.top3DumpView);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Bitmap.Config.ARGB_8888);
        linearLayout.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }
}
