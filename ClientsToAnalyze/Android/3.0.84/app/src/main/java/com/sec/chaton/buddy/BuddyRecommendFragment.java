package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p018b.ContextMenuC0453a;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1336n;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.settings.tellfriends.C2735al;
import com.sec.chaton.settings.tellfriends.C2737an;
import com.sec.chaton.settings.tellfriends.C2739ap;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyRecommendFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    /* renamed from: A */
    private ViewGroup f2169A;

    /* renamed from: B */
    private TextView f2170B;

    /* renamed from: C */
    private LinearLayout f2171C;

    /* renamed from: D */
    private ViewGroup f2172D;

    /* renamed from: E */
    private TextView f2173E;

    /* renamed from: F */
    private LinearLayout f2174F;

    /* renamed from: G */
    private ImageView f2175G;

    /* renamed from: H */
    private TextView f2176H;

    /* renamed from: I */
    private TextView f2177I;

    /* renamed from: J */
    private Activity f2178J;

    /* renamed from: K */
    private LinearLayout f2179K;

    /* renamed from: L */
    private LinearLayout f2180L;

    /* renamed from: c */
    private C0728gl f2190c;

    /* renamed from: d */
    private ListView f2191d;

    /* renamed from: e */
    private View f2192e;

    /* renamed from: f */
    private ProgressDialog f2193f;

    /* renamed from: h */
    private C1330h f2195h;

    /* renamed from: i */
    private C1336n f2196i;

    /* renamed from: j */
    private String f2197j;

    /* renamed from: k */
    private int f2198k;

    /* renamed from: l */
    private String f2199l;

    /* renamed from: n */
    private long f2201n;

    /* renamed from: q */
    private C1377u f2204q;

    /* renamed from: s */
    private LinearLayout f2206s;

    /* renamed from: t */
    private View f2207t;

    /* renamed from: u */
    private View f2208u;

    /* renamed from: v */
    private View f2209v;

    /* renamed from: w */
    private C2737an f2210w;

    /* renamed from: x */
    private C2739ap f2211x;

    /* renamed from: y */
    private C2735al f2212y;

    /* renamed from: z */
    private LinearLayout f2213z;

    /* renamed from: g */
    private InterfaceC3274d f2194g = null;

    /* renamed from: m */
    private int f2200m = 0;

    /* renamed from: o */
    private boolean f2202o = true;

    /* renamed from: p */
    private ArrayList<String> f2203p = new ArrayList<>();

    /* renamed from: r */
    private boolean f2205r = false;

    /* renamed from: a */
    ContentObserver f2188a = new C0724gh(this, new Handler());

    /* renamed from: b */
    InterfaceC1378v f2189b = new C0725gi(this);

    /* renamed from: M */
    private View.OnClickListener f2181M = new ViewOnClickListenerC0726gj(this);

    /* renamed from: N */
    private View.OnClickListener f2182N = new ViewOnClickListenerC0707fr(this);

    /* renamed from: O */
    private View.OnClickListener f2183O = new ViewOnClickListenerC0708fs(this);

    /* renamed from: P */
    private View.OnClickListener f2184P = new ViewOnClickListenerC0709ft(this);

    /* renamed from: Q */
    private View.OnClickListener f2185Q = new ViewOnClickListenerC0710fu(this);

    /* renamed from: R */
    private Handler f2186R = new HandlerC0711fv(this);

    /* renamed from: S */
    private Handler f2187S = new HandlerC0715fz(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3773a(android.database.Cursor r8, java.lang.Object r9) {
        /*
            r7 = this;
            r1 = 0
            android.app.Activity r0 = r7.f2178J
            java.lang.String r2 = "layout_inflater"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            if (r8 == 0) goto L70
            r8.moveToFirst()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
        L10:
            r3 = r1
            r1 = 2130903213(0x7f0300ad, float:1.7413238E38)
            android.widget.LinearLayout r2 = r7.f2171C     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r4 = 0
            android.view.View r4 = r0.inflate(r1, r2, r4)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r1 = 2131165506(0x7f070142, float:1.7945231E38)
            android.view.View r1 = r4.findViewById(r1)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r2 = 2131165979(0x7f07031b, float:1.794619E38)
            android.view.View r2 = r4.findViewById(r2)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            java.lang.String r5 = "buddy_name"
            int r5 = r8.getColumnIndex(r5)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            java.lang.String r5 = r8.getString(r5)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            java.lang.String r6 = "buddy_no"
            int r6 = r8.getColumnIndex(r6)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            java.lang.String r6 = r8.getString(r6)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r2.setText(r5)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r2 = 2131165198(0x7f07000e, float:1.7944606E38)
            r4.setTag(r2, r6)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r2 = 2131165199(0x7f07000f, float:1.7944608E38)
            r4.setTag(r2, r5)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            android.view.View$OnClickListener r2 = r7.f2183O     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r4.setOnClickListener(r2)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            android.support.v4.app.FragmentActivity r2 = r7.getActivity()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            com.sec.chaton.util.bt r2 = com.sec.chaton.util.C3205bt.m11182a(r2)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r2.m11210a(r1, r6)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            android.widget.LinearLayout r1 = r7.f2171C     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            r1.addView(r4)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            int r1 = r3 + 1
            boolean r2 = r8.moveToNext()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L7d
            if (r2 == 0) goto L70
            r2 = 5
            if (r1 < r2) goto L10
        L70:
            if (r8 == 0) goto L75
        L72:
            r8.close()
        L75:
            return
        L76:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7d
            if (r8 == 0) goto L75
            goto L72
        L7d:
            r0 = move-exception
            if (r8 == 0) goto L83
            r8.close()
        L83:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyRecommendFragment.m3773a(android.database.Cursor, java.lang.Object):void");
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f2178J = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f2178J = null;
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_buddy_recommend, viewGroup, false);
        this.f2179K = (LinearLayout) layoutInflater.inflate(R.layout.layout_buddy_recommend_header, (ViewGroup) null);
        this.f2206s = (LinearLayout) this.f2179K.findViewById(R.id.sns_account_layout);
        if (this.f2206s.findViewById(R.id.btn_twitter) instanceof Button) {
            this.f2207t = (Button) this.f2206s.findViewById(R.id.btn_twitter);
            this.f2208u = (Button) this.f2206s.findViewById(R.id.btn_cinaweibo);
            this.f2209v = (Button) this.f2206s.findViewById(R.id.btn_renren);
        } else {
            this.f2207t = (ImageView) this.f2206s.findViewById(R.id.btn_twitter);
            this.f2208u = (ImageView) this.f2206s.findViewById(R.id.btn_cinaweibo);
            this.f2209v = (ImageView) this.f2206s.findViewById(R.id.btn_renren);
        }
        this.f2210w = new C2737an(this.f2178J);
        this.f2211x = new C2739ap(this.f2178J);
        this.f2212y = new C2735al(this.f2178J);
        ((ViewGroup) this.f2179K.findViewById(R.id.suggestion_sns_friends_layout)).setVisibility(8);
        this.f2191d = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f2180L = (LinearLayout) layoutInflater.inflate(R.layout.layout_buddy_recommend_footer, (ViewGroup) null);
        this.f2172D = (ViewGroup) this.f2180L.findViewById(R.id.may_know_header_layout);
        this.f2173E = (TextView) this.f2172D.findViewById(R.id.text1);
        this.f2173E.setText(getResources().getString(R.string.add_buddy_suggestion_people_may_know) + " (0)");
        this.f2174F = (LinearLayout) this.f2180L.findViewById(R.id.no_recommendations_layout);
        this.f2175G = (ImageView) this.f2174F.findViewById(R.id.image1);
        this.f2175G.setImageResource(R.drawable.no_contents_buddies);
        this.f2176H = (TextView) this.f2174F.findViewById(R.id.text1);
        this.f2176H.setText(getResources().getString(R.string.buddy_suggestions_wait));
        this.f2177I = (TextView) this.f2174F.findViewById(R.id.text2);
        this.f2177I.setText(getResources().getString(R.string.buddy_suggestions_informations));
        this.f2171C = (LinearLayout) this.f2179K.findViewById(R.id.chatonlive_h_layout);
        this.f2213z = (LinearLayout) this.f2179K.findViewById(R.id.chatonlive_layout);
        this.f2191d.addHeaderView(this.f2179K);
        this.f2169A = (ViewGroup) this.f2179K.findViewById(R.id.chatonlive_header_layout);
        this.f2170B = (TextView) this.f2169A.findViewById(R.id.text1);
        this.f2170B.setText(getResources().getString(R.string.add_buddy_livepartner_recommendation));
        this.f2170B.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
        this.f2204q = new C1377u(this.f2178J.getContentResolver(), this.f2189b);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (C3159aa.m10962a().m10977a("recomned_receive", (Boolean) true).booleanValue() || C3159aa.m10962a().m10977a("recomned_special", (Boolean) true).booleanValue()) {
            this.f2190c = new C0728gl(this, this.f2178J, R.layout.list_item_common_11, null, PrefFragmentChats.TYPE);
            this.f2191d.setItemsCanFocus(true);
            this.f2191d.setAdapter((ListAdapter) this.f2190c);
            this.f2191d.setOnItemClickListener(new C0706fq(this));
            registerForContextMenu(this.f2191d);
            getLoaderManager().initLoader(0, null, this);
            this.f2190c.notifyDataSetChanged();
            this.f2195h = new C1330h(this.f2186R);
            this.f2196i = new C1336n(this.f2187S);
            this.f2193f = new ProgressDialogC3265l(this.f2178J, false);
            this.f2193f.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
            return;
        }
        this.f2177I.setText(R.string.add_buddy_suggestion_not_use);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f2205r = false;
        this.f2200m = m3767a();
        this.f2178J.getContentResolver().registerContentObserver(C1388af.f5186a, true, this.f2188a);
        if (this.f2200m == 0) {
            C3159aa.m10965a("recommend_timestamp", (Long) 0L);
        }
        this.f2204q.startQuery(2, null, C1388af.f5186a, null, "type='100' AND rank > 0", null, "rank COLLATE LOCALIZED ASC");
        this.f2204q.startQuery(1, null, C1388af.f5186a, null, "type='200'", null, null);
        C0816a.m4368d();
        if (!C0816a.m4369e()) {
            if (this.f2206s.findViewById(R.id.btn_twitter) instanceof Button) {
                this.f2207t.setVisibility(8);
            } else {
                ((LinearLayout) this.f2206s.findViewById(R.id.layout_twitter)).setVisibility(8);
            }
        } else if (this.f2206s.findViewById(R.id.btn_twitter) instanceof Button) {
            this.f2207t.setVisibility(8);
        } else {
            ((LinearLayout) this.f2206s.findViewById(R.id.layout_twitter)).setVisibility(8);
        }
        this.f2207t.setOnClickListener(new ViewOnClickListenerC0717ga(this));
        this.f2208u.setVisibility(0);
        this.f2208u.setOnClickListener(new ViewOnClickListenerC0719gc(this));
        this.f2209v.setVisibility(0);
        this.f2209v.setOnClickListener(new ViewOnClickListenerC0721ge(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3779a(boolean z) {
        if (this.f2194g == null) {
            this.f2194g = AbstractC3271a.m11494a(this.f2178J).mo11500a(getResources().getString(R.string.ams_attention_title)).mo11509b(getResources().getString(R.string.dev_network_error)).mo11511b(false).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0723gg(this, z)).mo11505a();
        }
        this.f2194g.show();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f2205r = true;
        this.f2178J.getContentResolver().unregisterContentObserver(this.f2188a);
        if (this.f2202o && this.f2201n > 0) {
            C3159aa.m10965a("recommend_timestamp", Long.valueOf(this.f2201n));
        }
        this.f2202o = true;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (getResources() != null && this.f2192e != null) {
            this.f2192e.setPadding(0, getResources().getDimensionPixelSize(R.dimen.buddy_no_suggestion_padding_top), 0, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m3771a(android.content.ContentResolver r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.String r7 = ""
            android.net.Uri r1 = com.sec.chaton.p027e.C1388af.f5186a     // Catch: java.lang.Throwable -> L39
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r0.<init>()     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "buddy_no='"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "'"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L39
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L43
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L43
            r0 = 2
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L41
        L33:
            if (r1 == 0) goto L38
            r1.close()
        L38:
            return r0
        L39:
            r0 = move-exception
            r1 = r6
        L3b:
            if (r1 == 0) goto L40
            r1.close()
        L40:
            throw r0
        L41:
            r0 = move-exception
            goto L3b
        L43:
            r0 = r7
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyRecommendFragment.m3771a(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m3767a() throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1388af.f5186a, null, "type='200'", null, null);
        } catch (Throwable th) {
            th = th;
            cursorQuery = null;
        }
        try {
            int count = cursorQuery.getCount();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return count;
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this.f2178J, C1388af.f5186a, null, null, null, PrefFragmentChats.TYPE);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        Cursor cursor;
        super.onDestroy();
        if (this.f2190c != null && (cursor = this.f2190c.getCursor()) != null && !cursor.isClosed()) {
            cursor.close();
            if (C3250y.f11734b) {
                C3250y.m11450b("The Cursor of Adapter was closed", getClass().getSimpleName());
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        SQLiteDatabase readableDatabase = C1404av.m6253a(this.f2178J).getReadableDatabase();
        boolean zBooleanValue = C3159aa.m10962a().m10977a("recomned_receive", (Boolean) true).booleanValue();
        C3250y.m11458g("isBuddy =  " + zBooleanValue + " isSpecial = false", getClass().getSimpleName());
        if (zBooleanValue) {
        }
        if (zBooleanValue) {
            C3250y.m11458g("isBuddy =  " + zBooleanValue + " isSpecial = false sql = SELECT * FROM recommendee WHERE type='200' ORDER BY timestamp DESC LIMIT 10; ", getClass().getSimpleName());
            Cursor cursorSwapCursor = this.f2190c.swapCursor(readableDatabase.rawQuery("SELECT * FROM recommendee WHERE type='200' ORDER BY timestamp DESC LIMIT 10; ", null));
            if (cursorSwapCursor != null) {
                cursorSwapCursor.close();
            }
        } else {
            Cursor cursorSwapCursor2 = this.f2190c.swapCursor(null);
            if (cursorSwapCursor2 != null) {
                cursorSwapCursor2.close();
            }
        }
        this.f2190c.notifyDataSetChanged();
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        Cursor cursorSwapCursor = this.f2190c.swapCursor(null);
        if (cursorSwapCursor != null) {
            cursorSwapCursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3778a(String str, int i) throws UnsupportedEncodingException {
        if (str == null) {
            str = this.f2197j;
        }
        this.f2193f.show();
        this.f2195h.m5731b(str, true);
        this.f2190c.notifyDataSetChanged();
        this.f2197j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3777a(String str) {
        if (str == null) {
            str = this.f2197j;
        }
        this.f2193f.show();
        this.f2203p.add(str);
        this.f2196i.m5791a("true", this.f2203p);
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        ContextMenuC0453a contextMenuC0453a = new ContextMenuC0453a(this.f2178J, contextMenu);
        C0729gm c0729gm = new C0729gm(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).targetView);
        this.f2197j = c0729gm.f2980c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f2198k = Integer.parseInt(c0729gm.f2980c.getTag(R.id.TAG_FOR_TYPE).toString());
        this.f2199l = c0729gm.f2979b.getText().toString();
        contextMenuC0453a.setHeaderTitle(this.f2199l);
        contextMenuC0453a.add(0, 100, 1, getResources().getString(R.string.buddy_profile_button_addbuddy));
        contextMenuC0453a.add(0, 101, 2, getResources().getString(R.string.buddy_suggestion_ignore));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2178J, R.string.popup_no_network_connection, 0).show();
        } else {
            switch (menuItem.getItemId()) {
                case 100:
                    m3778a(this.f2197j, this.f2198k);
                    break;
                case 101:
                    AbstractC3271a.m11494a(this.f2178J).mo11500a(getResources().getString(R.string.buddy_suggestion_ignore)).mo11509b(getResources().getString(R.string.suggestion_ignore_popup_message, this.f2199l)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0727gk(this)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                    break;
            }
        }
        return true;
    }
}
