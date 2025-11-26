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
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.base.InterfaceC0460e;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0823h;
import com.sec.chaton.p025d.p026a.C1195bw;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.settings.ActivityBgBubbleChange;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;

/* loaded from: classes.dex */
public class SkinListView extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener, InterfaceC0460e, InterfaceC2585by {

    /* renamed from: a */
    static final String f9557a = SkinListView.class.getSimpleName();

    /* renamed from: b */
    private Activity f9558b;

    /* renamed from: c */
    private ProgressDialog f9559c;

    /* renamed from: d */
    private GridView f9560d;

    /* renamed from: e */
    private C3326c f9561e;

    /* renamed from: f */
    private C0823h f9562f;

    /* renamed from: g */
    private C1195bw f9563g;

    /* renamed from: h */
    private ViewOnClickListenerC2583bw f9564h;

    /* renamed from: i */
    private Menu f9565i;

    /* renamed from: j */
    private InterfaceC2606cs f9566j;

    /* renamed from: k */
    private Handler f9567k = new HandlerC2601cn(this);

    /* renamed from: l */
    private Handler f9568l = new HandlerC2602co(this);

    /* renamed from: a */
    void m9387a(boolean z) {
        if (this.f9565i != null) {
            this.f9565i.findItem(R.id.downloads_downloadAll).setEnabled(z);
            C3228cp.m11343a(this.f9565i.findItem(R.id.downloads_downloadAll));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f9560d != null) {
            this.f9560d.invalidateViews();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9558b = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9558b = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9562f = new C0823h(this.f9558b, this.f9568l);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f9561e = new C3326c();
        View viewInflate = layoutInflater.inflate(R.layout.layout_theme_package_list, viewGroup, false);
        this.f9560d = (GridView) viewInflate.findViewById(R.id.theme_package_list);
        this.f9564h = new ViewOnClickListenerC2583bw(this.f9558b, null, false, this.f9561e);
        this.f9564h.m9559a(this);
        this.f9566j = (InterfaceC2606cs) this.f9558b;
        C2525p.m9458a().m9461a(this.f9564h);
        C2556aw c2556aw = new C2556aw();
        c2556aw.m9499a(this.f9567k);
        this.f9564h.m9558a(c2556aw);
        this.f9560d.setAdapter((ListAdapter) this.f9564h);
        if (!GlobalApplication.m6456e()) {
            this.f9560d.setOnItemClickListener(this);
        }
        m9379c();
        this.f9563g = this.f9562f.m4378a(EnumC1172b.UI, C2591cd.m9572b(), C2591cd.m9572b(), C2591cd.m9576c(), C2591cd.m9578d());
        setHasOptionsMenu(true);
        return viewInflate;
    }

    /* renamed from: b */
    private void m9378b() {
        if (this.f9558b != null) {
            C2555av.m9494f(this.f9558b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2603cp(this)).mo11512b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f9565i = menu;
        if (GlobalApplication.m6456e()) {
            menuInflater.inflate(R.menu.download_skin_menu_tablet, menu);
            menu.getItem(0).setEnabled(false);
        } else {
            menuInflater.inflate(R.menu.download_all_only_menu, menu);
        }
        m9387a(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                if (this.f9564h != null && this.f9564h.m9560a()) {
                    m9383e();
                    break;
                } else {
                    this.f9558b.finish();
                    break;
                }
                break;
            case R.id.downloads_downloadAll /* 2131166606 */:
                m9378b();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C2525p.m9458a().m9465b(this.f9564h);
        if (this.f9563g != null) {
            this.f9563g.m5493c();
        }
        if (this.f9561e != null) {
            this.f9561e.m11731a();
        }
        if (this.f9564h != null) {
            if (this.f9564h.m9560a()) {
                this.f9564h.m9561b();
            }
            this.f9564h.m9562c();
        }
        getLoaderManager().destroyLoader(0);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) throws Throwable {
        return new CursorLoader(this.f9558b, C1398ap.m6249a(EnumC1399aq.Skin), null, C3364o.m11849a("item_id", " >= ?"), new String[]{"0"}, C3364o.m11849a("special", " DESC,", "new", " DESC,", "item_id", " DESC"));
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f9564h.swapCursor(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        this.f9564h.swapCursor(null);
    }

    /* renamed from: c */
    private void m9379c() {
        if (this.f9559c == null) {
            this.f9559c = C2555av.m9489a(this.f9558b);
            this.f9559c.setOnCancelListener(new DialogInterfaceOnCancelListenerC2604cq(this));
            if (!this.f9559c.isShowing()) {
                this.f9559c.show();
            }
            this.f9559c.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m9382d() {
        if (this.f9559c != null && this.f9559c.isShowing()) {
            this.f9559c.dismiss();
        }
    }

    @Override // com.sec.chaton.base.InterfaceC0460e
    /* renamed from: a */
    public boolean mo3095a(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f9564h == null || !this.f9564h.m9560a()) {
            return false;
        }
        m9383e();
        return true;
    }

    /* renamed from: e */
    private void m9383e() {
        C2555av.m9493e(this.f9558b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2605cr(this)).mo11512b();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f9564h != null) {
            String strM9557a = this.f9564h.m9557a(view);
            if (!TextUtils.isEmpty(strM9557a)) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(C3364o.m11849a("download_skin, Clicked item id: ", strM9557a), f9557a);
                }
                mo9386a(strM9557a);
            }
        }
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2585by
    /* renamed from: a */
    public void mo9386a(String str) {
        Intent intent = new Intent(this.f9558b, (Class<?>) ActivitySkinDetail.class);
        intent.putExtra("ITEM_ID", str);
        startActivityForResult(intent, 1000);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1000:
                if (this.f9564h != null && i2 == 2000) {
                    this.f9564h.notifyDataSetChanged();
                    Intent intent2 = new Intent(this.f9558b, (Class<?>) ActivityBgBubbleChange.class);
                    intent2.putExtra("called_from_downloads", true);
                    startActivity(intent2);
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2585by
    /* renamed from: a */
    public void mo9384a() {
        this.f9566j.mo9073c();
    }
}
