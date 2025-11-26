package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0703r;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p017e.p019b.C0686m;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.p017e.p019b.InterfaceC0687n;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1797a;
import com.sec.chaton.widget.C1798b;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class RelationshipRankFragment2 extends Fragment implements InterfaceC0667k {

    /* renamed from: g */
    private static C0666j f5992g;

    /* renamed from: j */
    private static int f5993j;

    /* renamed from: a */
    String f5994a;

    /* renamed from: d */
    private LocalBroadcastManager f5997d;

    /* renamed from: e */
    private BroadcastReceiver f5998e;

    /* renamed from: f */
    private IntentFilter f5999f;

    /* renamed from: h */
    private ProgressDialog f6000h;

    /* renamed from: i */
    private ProgressDialog f6001i;

    /* renamed from: k */
    private ListView f6002k;

    /* renamed from: l */
    private LinearLayout f6003l;

    /* renamed from: m */
    private RelativeLayout f6004m;

    /* renamed from: n */
    private ArrayList f6005n;

    /* renamed from: o */
    private ArrayAdapter f6006o;

    /* renamed from: p */
    private TextView f6007p;

    /* renamed from: q */
    private String f6008q;

    /* renamed from: r */
    private View f6009r;

    /* renamed from: s */
    private ListView f6010s;

    /* renamed from: t */
    private C1798b f6011t;

    /* renamed from: u */
    private AdapterView.OnItemSelectedListener f6012u;

    /* renamed from: v */
    private AdapterView.OnItemLongClickListener f6013v;

    /* renamed from: x */
    private View f6015x;

    /* renamed from: y */
    private AlertDialog f6016y;

    /* renamed from: w */
    private int f6014w = 1;

    /* renamed from: b */
    InterfaceC0677d f5995b = new C1667bq(this);

    /* renamed from: c */
    InterfaceC0687n f5996c = new C1668br(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6061b("onCreate", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1786r.m6061b("onCreateView", getClass().getSimpleName());
        this.f6009r = layoutInflater.inflate(R.layout.layout_relationshiprank2, viewGroup, false);
        this.f6002k = (ListView) this.f6009r.findViewById(R.id.relationship_list);
        this.f6003l = (LinearLayout) this.f6009r.findViewById(R.id.no_item_layout);
        this.f6004m = (RelativeLayout) this.f6009r.findViewById(R.id.week_title);
        this.f6007p = (TextView) this.f6009r.findViewById(R.id.week_title_text);
        this.f6007p.setText(getString(R.string.interaction_rank_week, 1));
        this.f6015x = this.f6009r.findViewById(R.id.listview_top3dumpview);
        this.f6005n = new ArrayList();
        f5992g = new C0666j(getActivity().getContentResolver(), this);
        this.f5994a = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        m5709f();
        this.f6006o = new C1671bu(getActivity(), 0, this.f6005n);
        this.f6002k.setAdapter((ListAdapter) this.f6006o);
        BaseActivity.m1829b(this, true);
        this.f6012u = new C1661bk(this);
        this.f6013v = new C1662bl(this);
        this.f6010s = (ListView) getActivity().findViewById(R.id.more_option_list);
        this.f6010s.setTag(true);
        this.f6010s.setOnItemClickListener(new C1665bo(this));
        this.f5997d = LocalBroadcastManager.getInstance(GlobalApplication.m3260b());
        this.f5998e = new C1666bp(this);
        this.f5999f = new IntentFilter();
        this.f5999f.addAction("com.sec.chaton.ACTION_DISPALY_WEEK");
        this.f5997d.registerReceiver(this.f5998e, this.f5999f);
        return this.f6009r;
    }

    /* renamed from: f */
    private void m5709f() {
        Calendar.getInstance();
        Calendar.getInstance().add(5, -1);
        Calendar.getInstance().add(5, -7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5694a(int i) {
        f5992g.startQuery(-1, null, C0703r.m3166a(), null, "relation_date = ?  AND buddy_relation_hide = 'N'  AND relation_rank != 0 ", new String[]{Integer.toString(i)}, "relation_rank ASC LIMIT 30");
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1786r.m6061b("onStart", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6061b("onResume", getClass().getSimpleName());
        BaseActivity.m1827a(this, true);
        C0686m.m3110a(this.f5996c);
        C1786r.m6066e("Is Updating : " + C0686m.m3114b(), getClass().getSimpleName());
        if (C0686m.m3114b()) {
            this.f6001i = ProgressDialogC1806j.m6141a(getActivity(), null, getResources().getString(R.string.interaction_updating), true);
        } else {
            m5694a(this.f6014w);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1786r.m6061b("onPause", getClass().getSimpleName());
        if (this.f6000h != null) {
            C1786r.m6061b("mProgressDialog_refresh onPause", getClass().getSimpleName());
            this.f6000h.dismiss();
        }
        C0686m.m3113b(this.f5996c);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        m5696a(configuration);
    }

    /* renamed from: a */
    private void m5696a(Configuration configuration) throws Resources.NotFoundException {
        if (configuration.orientation == 2) {
            m5695a(R.dimen.land_Left_fragment_size, R.dimen.land_right_fragment_size);
        } else if (configuration.orientation == 1) {
            m5695a(R.dimen.port_left_fragment_size, R.dimen.port_right_fragment_size);
        }
    }

    /* renamed from: a */
    private void m5695a(int i, int i2) throws Resources.NotFoundException {
        int dimensionPixelOffset = getActivity().getResources().getDimensionPixelOffset(i);
        int dimensionPixelOffset2 = getActivity().getResources().getDimensionPixelOffset(i2);
        ((FrameLayout) getActivity().findViewById(R.id.fragment_controller)).setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset, -1));
        ((FrameLayout) getActivity().findViewById(R.id.fragment_container)).setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset2, -1));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.removeItem(121);
        menu.add(0, 121, 3, "").setIcon(R.drawable.top_menu_optionmenu).setShowAsAction(2);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C1786r.m6061b("item =" + menuItem.getItemId(), getClass().getSimpleName());
        switch (menuItem.getItemId()) {
            case 121:
                if (this.f6010s.getVisibility() == 0) {
                    this.f6010s.setVisibility(8);
                    break;
                } else {
                    this.f6010s.setVisibility(0);
                    this.f6010s.setAdapter((ListAdapter) m5715a());
                    this.f6010s.setOnItemSelectedListener(m5716b());
                    this.f6010s.setOnItemLongClickListener(m5717c());
                    break;
                }
            case android.R.id.home:
                getActivity().finish();
                break;
        }
        return true;
    }

    /* renamed from: a */
    public C1798b m5715a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1797a(getResources().getString(R.string.setting_interaction_ru), R.drawable.refresh));
        if (this.f6015x.getVisibility() == 0) {
            arrayList.add(new C1797a(getResources().getString(R.string.share), R.drawable.share));
        }
        this.f6011t = new C1798b(getActivity(), arrayList);
        return this.f6011t;
    }

    /* renamed from: b */
    public AdapterView.OnItemSelectedListener m5716b() {
        return this.f6012u;
    }

    /* renamed from: c */
    public AdapterView.OnItemLongClickListener m5717c() {
        return this.f6013v;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a A[Catch: all -> 0x0066, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x003c, B:10:0x004a), top: B:16:0x0002 }] */
    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onQueryComplete(int r6, java.lang.Object r7, android.database.Cursor r8) {
        /*
            r5 = this;
            if (r8 == 0) goto L4a
            int r0 = r8.getCount()     // Catch: java.lang.Throwable -> L66
            if (r0 <= 0) goto L4a
            android.widget.ListView r0 = r5.f6002k     // Catch: java.lang.Throwable -> L66
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L66
            android.view.View r0 = r5.f6015x     // Catch: java.lang.Throwable -> L66
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L66
            android.widget.LinearLayout r0 = r5.f6003l     // Catch: java.lang.Throwable -> L66
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L66
            android.widget.RelativeLayout r0 = r5.f6004m     // Catch: java.lang.Throwable -> L66
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L66
            android.widget.TextView r0 = r5.f6007p     // Catch: java.lang.Throwable -> L66
            r1 = 2131427971(0x7f0b0283, float:1.8477573E38)
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L66
            r3 = 0
            int r4 = r5.f6014w     // Catch: java.lang.Throwable -> L66
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L66
            r2[r3] = r4     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r5.getString(r1, r2)     // Catch: java.lang.Throwable -> L66
            r0.setText(r1)     // Catch: java.lang.Throwable -> L66
            r5.m5697a(r8)     // Catch: java.lang.Throwable -> L66
        L3c:
            android.widget.ArrayAdapter r0 = r5.f6006o     // Catch: java.lang.Throwable -> L66
            r0.notifyDataSetChanged()     // Catch: java.lang.Throwable -> L66
            r5.m5711g()     // Catch: java.lang.Throwable -> L66
            if (r8 == 0) goto L49
            r8.close()
        L49:
            return
        L4a:
            android.widget.ListView r0 = r5.f6002k     // Catch: java.lang.Throwable -> L66
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L66
            android.view.View r0 = r5.f6015x     // Catch: java.lang.Throwable -> L66
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L66
            android.widget.LinearLayout r0 = r5.f6003l     // Catch: java.lang.Throwable -> L66
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L66
            android.widget.RelativeLayout r0 = r5.f6004m     // Catch: java.lang.Throwable -> L66
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L66
            goto L3c
        L66:
            r0 = move-exception
            if (r8 == 0) goto L6c
            r8.close()
        L6c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.userprofile.RelationshipRankFragment2.onQueryComplete(int, java.lang.Object, android.database.Cursor):void");
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (i == 0) {
            if (i2 == 1) {
                m5694a(this.f6014w);
            } else {
                Toast.makeText(getActivity(), getResources().getString(R.string.buddy_profile_saveprofile_toast_failed), 1).show();
            }
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
    }

    /* renamed from: a */
    private void m5697a(Cursor cursor) {
        if (cursor != null) {
            this.f6005n.clear();
            while (cursor.moveToNext()) {
                C0257c c0257c = new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
                c0257c.m2334f(cursor.getPosition() + 1);
                if (cursor.getPosition() == 0) {
                    f5993j = c0257c.m2341m();
                }
                if (cursor.getPosition() < 4) {
                    c0257c.m2330d(5);
                }
                this.f6005n.add(c0257c);
            }
        }
    }

    /* renamed from: g */
    private void m5711g() {
        if (getActivity() != null && this.f6006o.getCount() != 0) {
            LinearLayout linearLayout = (LinearLayout) this.f6009r.findViewById(R.id.top3DumpView);
            linearLayout.removeAllViews();
            LayoutInflater.from(getActivity()).inflate(R.layout.list_relationship_rank_header_for_share, (ViewGroup) linearLayout, true);
            for (int i = 0; i < 3 && i < this.f6006o.getCount(); i++) {
                linearLayout.addView(this.f6006o.getView(i, null, linearLayout), -1, -2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public String m5713h() {
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
    public void m5698a(Bitmap bitmap, String str) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageBitmap(bitmap);
        this.f6016y = new AlertDialogBuilderC2120a(getActivity()).setTitle(getActivity().getResources().getString(R.string.share)).setView(imageView).setNegativeButton(R.string.share, new DialogInterfaceOnClickListenerC1670bt(this, bitmap, str)).setPositiveButton(R.string.cancel, new DialogInterfaceOnClickListenerC1669bs(this)).create();
        this.f6016y.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public Bitmap m5714i() {
        Bitmap bitmapCreateScaledBitmap;
        LinearLayout linearLayout = (LinearLayout) this.f6009r.findViewById(R.id.top3DumpView);
        Configuration configuration = getResources().getConfiguration();
        if (GlobalApplication.m3265f()) {
            if (configuration.orientation == 2) {
                linearLayout.buildDrawingCache();
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(linearLayout.getDrawingCache(), linearLayout.getWidth() - 130, linearLayout.getHeight() - 40, true);
            } else {
                linearLayout.buildDrawingCache();
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(linearLayout.getDrawingCache(), linearLayout.getWidth(), linearLayout.getHeight(), true);
            }
            C1786r.m6061b("v:width=" + linearLayout.getWidth() + " height=" + linearLayout.getHeight(), getClass().getSimpleName());
            return bitmapCreateScaledBitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Bitmap.Config.ARGB_8888);
        linearLayout.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }
}
