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
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.InterfaceC0460e;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1317bc;
import com.sec.chaton.p025d.p026a.C1208ci;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.util.C3364o;

/* loaded from: classes.dex */
public class SoundDownloads extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener, InterfaceC0460e, InterfaceC2628dn {

    /* renamed from: a */
    private static final String f9592a = SoundDownloads.class.getSimpleName();

    /* renamed from: b */
    private Activity f9593b;

    /* renamed from: c */
    private ListView f9594c;

    /* renamed from: d */
    private ProgressDialog f9595d;

    /* renamed from: e */
    private C1317bc f9596e;

    /* renamed from: f */
    private C1208ci f9597f;

    /* renamed from: g */
    private ViewOnClickListenerC2625dk f9598g;

    /* renamed from: h */
    private Menu f9599h;

    /* renamed from: i */
    private Handler f9600i = new HandlerC2612cy(this);

    /* renamed from: j */
    private Handler f9601j = new HandlerC2613cz(this);

    /* renamed from: k */
    private AdapterView.OnItemLongClickListener f9602k = new C2615da(this);

    /* renamed from: a */
    void m9416a(boolean z) {
        if (this.f9599h != null) {
            this.f9599h.findItem(R.id.downloads_downloadAll).setEnabled(z);
            C3228cp.m11343a(this.f9599h.findItem(R.id.downloads_downloadAll));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9593b = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9596e = new C1317bc(this.f9593b, this.f9601j);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_soundlist_view, viewGroup, false);
        this.f9594c = (ListView) viewInflate.findViewById(R.id.list_view);
        this.f9594c.setOnItemLongClickListener(this.f9602k);
        if (GlobalApplication.m6456e()) {
            this.f9594c.setItemsCanFocus(true);
        }
        this.f9598g = new ViewOnClickListenerC2625dk(this.f9593b, null, false);
        this.f9598g.m9623a(this);
        C2556aw c2556aw = new C2556aw();
        c2556aw.m9499a(this.f9600i);
        this.f9598g.m9622a(c2556aw);
        C2525p.m9458a().m9461a(this.f9598g);
        this.f9594c.setAdapter((ListAdapter) this.f9598g);
        m9410e();
        this.f9597f = this.f9596e.m5671a(EnumC1172b.UI, "mp3");
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        m9407c();
    }

    /* renamed from: c */
    private void m9407c() {
        C2525p.m9458a().m9465b(this.f9598g);
        getLoaderManager().destroyLoader(0);
        if (this.f9597f != null) {
            this.f9597f.m5493c();
        }
        if (this.f9598g != null) {
            this.f9598g.m9629d();
            if (this.f9598g.m9624a()) {
                this.f9598g.m9626b();
            }
            this.f9598g.m9628c();
            this.f9598g.m9623a((InterfaceC2628dn) null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9593b = null;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) throws Throwable {
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, SoundDownloads.onCreateLoader()", f9592a);
        }
        String strM11849a = C3364o.m11849a("special", " DESC,", "item_id", " DESC");
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, order by : " + strM11849a.toString(), f9592a);
        }
        return new CursorLoader(this.f9593b, C1398ap.m6249a(EnumC1399aq.Sound), null, C3364o.m11849a("item_id", " >= ?"), new String[]{"0"}, strM11849a);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, onLoadFinished()", f9592a);
        }
        this.f9598g.swapCursor(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        if (C3250y.f11734b) {
            C3250y.m11450b("download_sound, onLoaderReset()", f9592a);
        }
        this.f9598g.swapCursor(null);
    }

    /* renamed from: a */
    public void m9415a(String str, String str2) {
        Intent intent = new Intent(this.f9593b, (Class<?>) ActivitySoundDetail.class);
        intent.putExtra("ITEM_ID", str);
        intent.putExtra("SAMPLE_URL", str2);
        startActivityForResult(intent, 1000);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1000:
                if (this.f9598g != null && i2 == 2000) {
                    this.f9598g.notifyDataSetChanged();
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: b */
    public void m9417b(String str, String str2) {
        if (this.f9593b != null) {
            C2555av.m9492d(this.f9593b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2616db(this, str)).mo11512b();
        }
    }

    /* renamed from: d */
    private void m9409d() {
        if (this.f9593b != null) {
            C2555av.m9494f(this.f9593b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2617dc(this)).mo11512b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f9599h = menu;
        if (GlobalApplication.m6456e()) {
            menuInflater.inflate(R.menu.download_sound_menu_tablet, menu);
            menu.getItem(0).setEnabled(false);
        } else {
            menuInflater.inflate(R.menu.download_all_only_menu, menu);
        }
        m9416a(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    /* renamed from: a */
    public void m9413a() {
        if (this.f9598g != null && this.f9598g.m9624a()) {
            m9412g();
        } else if (this.f9593b != null) {
            this.f9593b.finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.downloads_downloadAll /* 2131166606 */:
                m9409d();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.base.InterfaceC0460e
    /* renamed from: a */
    public boolean mo3095a(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f9598g == null || !this.f9598g.m9624a()) {
            return false;
        }
        m9412g();
        return true;
    }

    /* renamed from: e */
    private void m9410e() {
        if (this.f9595d == null) {
            this.f9595d = C2555av.m9489a(this.f9593b);
            this.f9595d.setOnCancelListener(new DialogInterfaceOnCancelListenerC2618dd(this));
            if (!this.f9595d.isShowing()) {
                this.f9595d.show();
            }
            this.f9595d.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m9411f() {
        if (this.f9595d != null && this.f9595d.isShowing()) {
            this.f9595d.dismiss();
        }
    }

    /* renamed from: g */
    private void m9412g() {
        AbstractC3271a abstractC3271aM9493e = C2555av.m9493e(this.f9593b);
        abstractC3271aM9493e.mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2619de(this));
        abstractC3271aM9493e.mo11512b();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f9598g != null) {
            String strM9620a = this.f9598g.m9620a(view);
            String strM9621a = this.f9598g.m9621a(strM9620a);
            if (!TextUtils.isEmpty(strM9620a) && !GlobalApplication.m6456e()) {
                m9415a(strM9620a, strM9621a);
            }
        }
    }
}
