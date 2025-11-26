package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p018b.ContextMenuC0453a;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1336n;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class BuddyRecommendListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    /* renamed from: c */
    private C0748he f2217c;

    /* renamed from: d */
    private ListView f2218d;

    /* renamed from: e */
    private View f2219e;

    /* renamed from: f */
    private ProgressDialog f2220f;

    /* renamed from: g */
    private C1330h f2221g;

    /* renamed from: h */
    private C1336n f2222h;

    /* renamed from: i */
    private int f2223i;

    /* renamed from: j */
    private String f2224j;

    /* renamed from: k */
    private int f2225k;

    /* renamed from: l */
    private String f2226l;

    /* renamed from: m */
    private View f2227m;

    /* renamed from: n */
    private Button f2228n;

    /* renamed from: o */
    private Button f2229o;

    /* renamed from: t */
    private long f2234t;

    /* renamed from: u */
    private int f2235u;

    /* renamed from: v */
    private int f2236v;

    /* renamed from: p */
    private int f2230p = 0;

    /* renamed from: q */
    private ArrayList<String> f2231q = new ArrayList<>();

    /* renamed from: r */
    private ArrayList<String> f2232r = new ArrayList<>();

    /* renamed from: s */
    private boolean f2233s = false;

    /* renamed from: a */
    ContentObserver f2215a = new C0730gn(this, new Handler());

    /* renamed from: b */
    ContentObserver f2216b = new C0737gu(this, new Handler());

    /* renamed from: w */
    private View.OnClickListener f2237w = new ViewOnClickListenerC0744ha(this);

    /* renamed from: x */
    private View.OnClickListener f2238x = new ViewOnClickListenerC0745hb(this);

    /* renamed from: y */
    private View.OnClickListener f2239y = new ViewOnClickListenerC0746hc(this);

    /* renamed from: z */
    private Handler f2240z = new HandlerC0731go(this);

    /* renamed from: A */
    private Handler f2214A = new HandlerC0736gt(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments().getInt("RECOMMENDED_BUDDY_TYPE") == 100) {
            this.f2223i = 100;
            this.f2230p = m3821d();
        } else if (getArguments().getInt("RECOMMENDED_BUDDY_TYPE") == 200) {
            this.f2223i = HttpResponseCode.f13733OK;
            this.f2230p = m3818c();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f2233s = false;
        if (this.f2223i == 100) {
            this.f2230p = m3821d();
            getActivity().getContentResolver().registerContentObserver(C1388af.f5186a, true, this.f2216b);
        } else if (this.f2223i == 200) {
            this.f2230p = m3818c();
            getActivity().getContentResolver().registerContentObserver(C1388af.f5186a, true, this.f2215a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[PHI: r0
  0x0019: PHI (r0v7 int) = (r0v5 int), (r0v8 int) binds: [B:10:0x0021, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m3818c() throws java.lang.Throwable {
        /*
            r7 = this;
            r6 = 0
            android.content.Context r0 = com.sec.common.CommonApplication.m11493l()     // Catch: java.lang.Throwable -> L24
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L24
            android.net.Uri r1 = com.sec.chaton.p027e.C1388af.f5186a     // Catch: java.lang.Throwable -> L24
            r2 = 0
            java.lang.String r3 = "type='200'"
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L24
            if (r1 != 0) goto L1d
            r0 = 0
            if (r1 == 0) goto L1c
        L19:
            r1.close()
        L1c:
            return r0
        L1d:
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L1c
            goto L19
        L24:
            r0 = move-exception
            r1 = r6
        L26:
            if (r1 == 0) goto L2b
            r1.close()
        L2b:
            throw r0
        L2c:
            r0 = move-exception
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyRecommendListFragment.m3818c():int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[PHI: r0
  0x0019: PHI (r0v7 int) = (r0v5 int), (r0v8 int) binds: [B:10:0x0021, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m3821d() throws java.lang.Throwable {
        /*
            r7 = this;
            r6 = 0
            android.content.Context r0 = com.sec.common.CommonApplication.m11493l()     // Catch: java.lang.Throwable -> L24
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L24
            android.net.Uri r1 = com.sec.chaton.p027e.C1388af.f5186a     // Catch: java.lang.Throwable -> L24
            r2 = 0
            java.lang.String r3 = "type='100'"
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L24
            if (r1 != 0) goto L1d
            r0 = 0
            if (r1 == 0) goto L1c
        L19:
            r1.close()
        L1c:
            return r0
        L1d:
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L1c
            goto L19
        L24:
            r0 = move-exception
            r1 = r6
        L26:
            if (r1 == 0) goto L2b
            r1.close()
        L2b:
            throw r0
        L2c:
            r0 = move-exception
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.BuddyRecommendListFragment.m3821d():int");
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f2233s = true;
        if (this.f2223i == 100) {
            getActivity().getContentResolver().unregisterContentObserver(this.f2216b);
        } else if (this.f2223i == 200) {
            getActivity().getContentResolver().unregisterContentObserver(this.f2215a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        Cursor cursor;
        super.onDestroy();
        if (this.f2217c != null && (cursor = this.f2217c.getCursor()) != null && !cursor.isClosed()) {
            cursor.close();
            if (C3250y.f11734b) {
                C3250y.m11450b("The Cursor of Adapter was closed", getClass().getSimpleName());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_buddy_recommend_list, viewGroup, false);
        this.f2218d = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f2219e = viewInflate.findViewById(R.id.no_recommendations_layout);
        ((ImageView) this.f2219e.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_buddies);
        ((TextView) this.f2219e.findViewById(R.id.text1)).setText(getResources().getString(R.string.buddy_suggestions_wait));
        ((TextView) this.f2219e.findViewById(R.id.text2)).setText(getResources().getString(R.string.buddy_suggestions_informations));
        this.f2227m = viewInflate.findViewById(R.id.suggestion_ignore_add_all_button);
        this.f2228n = (Button) this.f2227m.findViewById(R.id.button2);
        this.f2228n.setText(getResources().getString(R.string.buddy_suggestion_ignore_all));
        this.f2229o = (Button) this.f2227m.findViewById(R.id.button3);
        this.f2229o.setText(getResources().getString(R.string.buddy_suggestion_add_all));
        this.f2230p = m3823e();
        this.f2235u = R.drawable.buddy_item_highlight_xml;
        this.f2236v = R.color.buddy_list_item_name_highlight;
        this.f2228n.setOnClickListener(new ViewOnClickListenerC0738gv(this));
        this.f2229o.setOnClickListener(new ViewOnClickListenerC0740gx(this));
        if (this.f2223i == 100) {
            this.f2227m.setVisibility(8);
        } else {
            this.f2227m.setVisibility(0);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f2217c = new C0748he(this, getActivity(), null, 2);
        this.f2218d.setAdapter((ListAdapter) this.f2217c);
        this.f2218d.setItemsCanFocus(true);
        this.f2218d.setOnItemClickListener(new C0742gz(this));
        registerForContextMenu(this.f2218d);
        getLoaderManager().initLoader(0, null, this);
        this.f2221g = new C1330h(this.f2240z);
        this.f2222h = new C1336n(this.f2214A);
        this.f2220f = new ProgressDialogC3265l(getActivity(), false);
        this.f2220f.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getActivity(), C1388af.f5186a, null, "type='200'", null, "timestamp DESC");
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        Cursor cursorSwapCursor = this.f2217c.swapCursor(cursor);
        if (cursorSwapCursor != null) {
            cursorSwapCursor.close();
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        Cursor cursorSwapCursor = this.f2217c.swapCursor(null);
        if (cursorSwapCursor != null) {
            cursorSwapCursor.close();
        }
    }

    /* renamed from: a */
    public void m3834a() throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1388af.f5186a, null, "type='200'", null, null);
        } catch (Throwable th) {
            th = th;
            cursorQuery = null;
        }
        try {
            this.f2231q.clear();
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
            cursorQuery.moveToPosition(-1);
            while (cursorQuery.moveToNext()) {
                this.f2231q.add(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no")));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (this.f2220f != null) {
                this.f2220f.show();
            } else {
                this.f2220f = new ProgressDialogC3265l(getActivity(), false);
                this.f2220f.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
            }
            if (this.f2231q.size() > 0) {
                this.f2222h.m5792a(this.f2231q);
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    public void m3836b() throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1388af.f5186a, null, "type='200'", null, null);
        } catch (Throwable th) {
            th = th;
            cursorQuery = null;
        }
        try {
            this.f2231q.clear();
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
            cursorQuery.moveToPosition(-1);
            while (cursorQuery.moveToNext()) {
                this.f2231q.add(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no")));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (this.f2220f != null) {
                this.f2220f.show();
            } else {
                this.f2220f = new ProgressDialogC3265l(getActivity(), false);
                this.f2220f.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
            }
            if (this.f2231q.size() > 0) {
                this.f2221g.m5734b(this.f2231q, true);
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: e */
    private int m3823e() {
        Cursor cursorQuery;
        if (this.f2223i == 100) {
            cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1388af.f5186a, null, "type='100'", null, null);
        } else {
            cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1388af.f5186a, null, "type='200'", null, null);
        }
        int count = cursorQuery.getCount();
        cursorQuery.close();
        return count;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3814a(String str, int i) throws UnsupportedEncodingException {
        if (str == null) {
            str = this.f2224j;
        }
        this.f2220f.show();
        this.f2221g.m5731b(str, true);
        this.f2217c.notifyDataSetChanged();
        this.f2224j = str;
        Cursor cursorM3810a = m3810a(getActivity().getContentResolver(), this.f2224j);
        if (cursorM3810a != null && cursorM3810a.moveToFirst()) {
            this.f2226l = cursorM3810a.getString(2);
        }
        if (cursorM3810a != null) {
            cursorM3810a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3813a(String str) {
        if (str == null) {
            str = this.f2224j;
        }
        this.f2220f.show();
        this.f2232r.add(str);
        this.f2222h.m5791a("true", this.f2232r);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (getResources() != null && this.f2219e != null) {
            this.f2219e.setPadding(0, getResources().getDimensionPixelSize(R.dimen.buddy_no_suggestion_padding_top), 0, 0);
        }
    }

    /* renamed from: a */
    public static Cursor m3810a(ContentResolver contentResolver, String str) {
        return contentResolver.query(C1388af.f5186a, null, "buddy_no='" + str + "'", null, null);
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        ContextMenuC0453a contextMenuC0453a = new ContextMenuC0453a(getActivity(), contextMenu);
        C0749hf c0749hf = new C0749hf(((AdapterView.AdapterContextMenuInfo) contextMenuInfo).targetView);
        this.f2224j = c0749hf.f3011c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
        this.f2225k = Integer.parseInt(c0749hf.f3011c.getTag(R.id.TAG_FOR_TYPE).toString());
        this.f2226l = c0749hf.f3010b.getText().toString();
        contextMenuC0453a.setHeaderTitle(this.f2226l);
        contextMenuC0453a.add(0, 100, 1, getResources().getString(R.string.edit_group_add_member));
        contextMenuC0453a.add(0, 101, 2, getResources().getString(R.string.buddy_suggestion_ignore));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(getActivity(), R.string.popup_no_network_connection, 0).show();
        } else {
            switch (menuItem.getItemId()) {
                case 100:
                    m3814a(this.f2224j, this.f2225k);
                    break;
                case 101:
                    AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.buddy_suggestion_ignore)).mo11509b(getResources().getString(R.string.suggestion_ignore_popup_message, this.f2226l)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0747hd(this)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                    break;
            }
        }
        return true;
    }
}
