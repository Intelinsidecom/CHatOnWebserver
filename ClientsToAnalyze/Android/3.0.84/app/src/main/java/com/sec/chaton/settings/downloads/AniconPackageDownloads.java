package com.sec.chaton.settings.downloads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.InterfaceC0460e;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1332j;
import com.sec.chaton.p025d.p026a.C1198bz;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;

/* loaded from: classes.dex */
public class AniconPackageDownloads extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, InterfaceC0460e, InterfaceC2540ag {

    /* renamed from: a */
    private static final String f9479a = AniconPackageDownloads.class.getSimpleName();

    /* renamed from: b */
    private Activity f9480b;

    /* renamed from: c */
    private ListView f9481c;

    /* renamed from: d */
    private ProgressDialog f9482d;

    /* renamed from: e */
    private C1332j f9483e;

    /* renamed from: f */
    private C1198bz f9484f;

    /* renamed from: g */
    private ViewOnClickListenerC2537ad f9485g;

    /* renamed from: h */
    private C3326c f9486h;

    /* renamed from: i */
    private Menu f9487i;

    /* renamed from: j */
    private Handler f9488j = new HandlerC2545al(this);

    /* renamed from: k */
    private Handler f9489k = new HandlerC2546am(this);

    /* renamed from: a */
    void m9335a(boolean z) {
        if (this.f9487i != null) {
            this.f9487i.findItem(R.id.anicon_filter).setEnabled(z);
            C3228cp.m11343a(this.f9487i.findItem(R.id.anicon_filter));
        }
    }

    /* renamed from: b */
    void m9336b(boolean z) {
        if (this.f9487i != null) {
            this.f9487i.findItem(R.id.anicon_downloadAll).setEnabled(z);
            C3228cp.m11343a(this.f9487i.findItem(R.id.anicon_downloadAll));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9480b = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9483e = new C1332j(this.f9480b, this.f9489k);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_packagelist_view, viewGroup, false);
        this.f9486h = new C3326c();
        this.f9481c = (ListView) viewInflate.findViewById(R.id.anicon_package_list);
        this.f9485g = new ViewOnClickListenerC2537ad(this.f9480b, null, false, this.f9486h);
        this.f9485g.m9479a(this);
        C2525p.m9458a().m9461a(this.f9485g);
        this.f9481c.setAdapter((ListAdapter) this.f9485g);
        C2556aw c2556aw = new C2556aw();
        c2556aw.m9499a(this.f9488j);
        this.f9485g.m9480a(c2556aw);
        setHasOptionsMenu(true);
        this.f9481c.setOnItemClickListener(new C2547an(this));
        m9328d();
        this.f9484f = this.f9483e.m5767a(EnumC1172b.UI, "0", "zip", 240);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C2525p.m9458a().m9465b(this.f9485g);
        getLoaderManager().destroyLoader(0);
        if (this.f9484f != null) {
            this.f9484f.m5493c();
        }
        if (this.f9486h != null) {
            this.f9486h.m11731a();
        }
        if (this.f9485g != null) {
            if (this.f9485g.m9481a()) {
                this.f9485g.m9482b();
            }
            this.f9485g.m9483c();
            this.f9485g.m9479a((InterfaceC2540ag) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9480b = null;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) throws Throwable {
        String strM11849a;
        if (C3250y.f11734b) {
            C3250y.m11450b("anicon_list, AniconPackageListView.onCreateLoader()", f9479a);
        }
        switch (EnumC2554au.m9485a(C3159aa.m10962a().m10978a("setting_anicon_sortby", Integer.valueOf(EnumC2554au.SORT_BY_TIME.m9486a())).intValue())) {
            case SORT_BY_TITLE:
                strM11849a = C3364o.m11849a("special", " DESC,", "name");
                break;
            case SORT_BY_CHARACTER:
                strM11849a = C3364o.m11849a("special", " DESC,", "data1", ",", "data2", ",", "data3");
                break;
            case SORT_BY_POPULARITY:
                strM11849a = C3364o.m11849a("special", " DESC,", "down_rank");
                break;
            default:
                strM11849a = C3364o.m11849a("special", " DESC,", "new", " DESC,", "item_id", " DESC");
                break;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("anicon_list, order by : " + strM11849a.toString(), f9479a);
        }
        return new CursorLoader(this.f9480b, C1398ap.m6249a(EnumC1399aq.Anicon), null, null, null, strM11849a);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (C3250y.f11734b) {
            C3250y.m11450b("anicon_list, AniconPackageListView.onLoadFinished()", f9479a);
        }
        this.f9485g.swapCursor(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        if (C3250y.f11734b) {
            C3250y.m11450b("anicon_list, AniconPackageListView.onLoaderReset()", f9479a);
        }
        this.f9485g.swapCursor(null);
    }

    /* renamed from: a */
    public void m9333a(String str) {
        Intent intent = new Intent(this.f9480b, (Class<?>) ActivityAniconPackageDetail.class);
        intent.putExtra("ANICON_PACKAGE_ID", str);
        startActivity(intent);
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2540ag
    /* renamed from: a */
    public void mo9334a(String str, String str2) {
        C2555av.m9492d(this.f9480b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2548ao(this, str)).mo11512b();
    }

    /* renamed from: b */
    private void m9324b() {
        AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.setting_download_anicon_sort_by).mo11496a(R.array.setting_download_anicon_opt_array, EnumC2554au.m9485a(C3159aa.m10962a().m10978a("setting_anicon_sortby", Integer.valueOf(EnumC2554au.SORT_BY_TIME.m9486a())).intValue()).m9486a(), new DialogInterfaceOnClickListenerC2549ap(this)).mo11512b();
    }

    /* renamed from: c */
    private void m9325c() {
        if (this.f9480b != null) {
            C2555av.m9494f(this.f9480b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2550aq(this)).mo11512b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f9487i = menu;
        if (GlobalApplication.m6456e()) {
            menuInflater.inflate(R.menu.download_anicon_menu_tablet, menu);
            menu.getItem(0).setEnabled(false);
        } else {
            menuInflater.inflate(R.menu.download_anicon_menu, menu);
        }
        m9335a(false);
        m9336b(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                if (this.f9485g != null && this.f9485g.m9481a()) {
                    m9331f();
                    break;
                } else {
                    this.f9480b.finish();
                    break;
                }
                break;
            case R.id.anicon_filter /* 2131166607 */:
                m9324b();
                break;
            case R.id.anicon_downloadAll /* 2131166608 */:
                m9325c();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.base.InterfaceC0460e
    /* renamed from: a */
    public boolean mo3095a(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f9485g == null || !this.f9485g.m9481a()) {
            return false;
        }
        m9331f();
        return true;
    }

    /* renamed from: d */
    private void m9328d() {
        if (this.f9482d == null) {
            this.f9482d = C2555av.m9489a(this.f9480b);
            this.f9482d.setOnCancelListener(new DialogInterfaceOnCancelListenerC2551ar(this));
            if (!this.f9482d.isShowing()) {
                this.f9482d.show();
            }
            this.f9482d.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m9330e() {
        if (this.f9482d != null && this.f9482d.isShowing()) {
            this.f9482d.dismiss();
        }
    }

    /* renamed from: f */
    private void m9331f() {
        AbstractC3271a abstractC3271aM9493e = C2555av.m9493e(this.f9480b);
        abstractC3271aM9493e.mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2552as(this));
        abstractC3271aM9493e.mo11512b();
    }
}
