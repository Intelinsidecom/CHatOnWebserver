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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.base.InterfaceC0460e;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1326d;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p025d.p026a.C1271j;
import com.sec.chaton.p025d.p026a.C1273l;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p035io.entry.inner.AmsItem;
import com.sec.chaton.settings.downloads.p056a.C2510a;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.AlertDialogC3256c;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;
import com.sec.common.util.p070a.C3332a;
import com.sec.vip.amschaton.AMSPlayerActivity;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class AmsItemDownloads extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener, InterfaceC0460e, InterfaceC2614d {

    /* renamed from: a */
    private static final String f9429a = AmsItemDownloads.class.getSimpleName();

    /* renamed from: b */
    private Activity f9430b;

    /* renamed from: c */
    private EnumC1327e f9431c;

    /* renamed from: d */
    private GridView f9432d;

    /* renamed from: e */
    private ProgressDialog f9433e;

    /* renamed from: f */
    private AlertDialogC3256c f9434f;

    /* renamed from: g */
    private InterfaceC3274d f9435g;

    /* renamed from: h */
    private ViewOnClickListenerC2509a f9436h;

    /* renamed from: i */
    private C1326d f9437i;

    /* renamed from: j */
    private C1273l f9438j;

    /* renamed from: k */
    private C1271j f9439k;

    /* renamed from: l */
    private C3326c f9440l;

    /* renamed from: m */
    private String f9441m;

    /* renamed from: n */
    private String f9442n;

    /* renamed from: o */
    private String f9443o;

    /* renamed from: p */
    private Menu f9444p;

    /* renamed from: q */
    private Handler f9445q = new HandlerC2632g(this);

    /* renamed from: r */
    private Handler f9446r = new HandlerC2634i(this);

    /* renamed from: a */
    void m9307a(boolean z) {
        if (this.f9444p != null) {
            this.f9444p.findItem(R.id.downloads_downloadAll).setEnabled(z);
            C3228cp.m11343a(this.f9444p.findItem(R.id.downloads_downloadAll));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9430b = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mDownloadingAmsItemId", this.f9441m);
        bundle.putString("mDownloadingAmsImageUrl", this.f9442n);
        bundle.putString("mDownloadingAmsItemFilePath", this.f9443o);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f9441m = bundle.getString("mDownloadingAmsItemId", null);
            this.f9442n = bundle.getString("mDownloadingAmsImageUrl", null);
            this.f9443o = bundle.getString("mDownloadingAmsItemFilePath", null);
        }
        this.f9440l = new C3326c();
        this.f9437i = new C1326d(this.f9430b, this.f9446r);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9431c = (EnumC1327e) getArguments().get("amsType");
        if (this.f9431c == null) {
            getActivity().finish();
            return null;
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_ams_item_list, viewGroup, false);
        this.f9432d = (GridView) viewInflate.findViewById(R.id.ams_item_downloads_list);
        this.f9436h = new ViewOnClickListenerC2509a(this.f9430b, null, false, this.f9431c, this.f9440l);
        this.f9436h.m9424a(this);
        C2556aw c2556aw = new C2556aw();
        c2556aw.m9499a(this.f9445q);
        this.f9436h.m9423a(c2556aw);
        C2525p.m9458a().m9461a(this.f9436h);
        this.f9432d.setAdapter((ListAdapter) this.f9436h);
        setHasOptionsMenu(true);
        this.f9432d.setOnItemClickListener(this);
        if (this.f9431c == EnumC1327e.Stamp && !GlobalApplication.m6456e()) {
            this.f9432d.setColumnWidth(this.f9430b.getResources().getDimensionPixelOffset(R.dimen.ams_item_stamp_gridview_item_width));
        }
        m9288d();
        switch (C2633h.f9876a[this.f9431c.ordinal()]) {
            case 1:
                getActivity().setTitle(R.string.ams_background);
                this.f9438j = this.f9437i.m5698a(EnumC1172b.UI, 224L, 224L);
                break;
            case 2:
                getActivity().setTitle(R.string.ams_title_stamp);
                this.f9438j = this.f9437i.m5699b(EnumC1172b.UI, 166L, 166L);
                break;
            case 3:
                getActivity().setTitle(R.string.settings_ams_template);
                this.f9438j = this.f9437i.m5700c(EnumC1172b.UI, 224L, 224L);
                break;
        }
        return viewInflate;
    }

    /* renamed from: b */
    private void m9283b() {
        if (this.f9430b != null) {
            C2555av.m9494f(this.f9430b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2635j(this)).mo11512b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.download_all_only_menu, menu);
        if (GlobalApplication.m6456e()) {
            menu.getItem(0).setEnabled(false);
        }
        this.f9444p = menu;
        m9307a(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                if (this.f9436h != null && this.f9436h.m9426a()) {
                    m9284c();
                    break;
                } else {
                    this.f9430b.finish();
                    break;
                }
                break;
            case R.id.downloads_downloadAll /* 2131166606 */:
                m9283b();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C2525p.m9458a().m9465b(this.f9436h);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f9440l != null) {
            this.f9440l.m11731a();
        }
        if (this.f9438j != null) {
            this.f9438j.m5493c();
        }
        if (this.f9436h != null) {
            if (this.f9436h.m9426a()) {
                this.f9436h.m9427b();
            }
            this.f9436h.m9429c();
            this.f9436h.m9424a((InterfaceC2614d) null);
        }
        getLoaderManager().destroyLoader(0);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9430b = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 0 && intent.getBooleanExtra("AMS_SAVE", false)) {
            try {
                C2642q.m9634a(this.f9430b, this.f9431c, this.f9441m, new File(this.f9443o));
            } catch (IOException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9429a);
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f9436h != null) {
            Cursor cursor = (Cursor) this.f9436h.getItem(i);
            String string = cursor.getString(cursor.getColumnIndex("item_id"));
            int i2 = cursor.getInt(cursor.getColumnIndex("install"));
            C2510a c2510a = (C2510a) C2525p.m9458a().m9459a(this.f9431c.m5703b(), string);
            if (i2 != 0) {
                if (this.f9431c == EnumC1327e.Template) {
                    File fileM9638b = C2642q.m9638b(this.f9430b, EnumC1327e.Template, string);
                    Intent intent = new Intent(this.f9430b, (Class<?>) AMSPlayerActivity.class);
                    intent.putExtra("AMS_FILE_PATH", fileM9638b.getAbsolutePath());
                    intent.putExtra("VIEWER_MODE", 1002);
                    intent.putExtra("AMS_DOWNLOAD_PREVIEW", false);
                    intent.putExtra("AMS_FROM_DOWNLOADS", true);
                    intent.putExtra("AMS_ITEM_ID", string);
                    AmsItem amsItemM9421a = this.f9436h.m9421a(string);
                    if (amsItemM9421a != null) {
                        intent.putExtra("AMS_FILE_SIZE", amsItemM9421a.filesize);
                        intent.putExtra("AMS_EXPIRATION_DATE", amsItemM9421a.expirationdate);
                        intent.putExtra("AMS_IS_FAILED_ITEM", false);
                    }
                    startActivity(intent);
                    return;
                }
                if (this.f9431c == EnumC1327e.Background) {
                    File fileM9638b2 = C2642q.m9638b(this.f9430b, EnumC1327e.Background, string);
                    Intent intent2 = new Intent(this.f9430b, (Class<?>) ActivityAmsItemBackgroundDetail.class);
                    intent2.putExtra("filePath", fileM9638b2.getAbsolutePath());
                    intent2.putExtra("amsItemId", string);
                    startActivity(intent2);
                    return;
                }
                return;
            }
            if (c2510a != null) {
                switch (c2510a.m9455d()) {
                }
            }
            if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("download_ams, Clicked item type: ", this.f9431c, ", item id: ", string), f9429a);
            }
            switch (C2633h.f9876a[this.f9431c.ordinal()]) {
                case 1:
                case 3:
                    m9280a(string);
                    break;
                case 2:
                    this.f9436h.m9425a(string, false);
                    break;
            }
        }
    }

    @Override // com.sec.chaton.base.InterfaceC0460e
    /* renamed from: a */
    public boolean mo3095a(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f9436h == null || !this.f9436h.m9426a()) {
            return false;
        }
        m9284c();
        return true;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this.f9430b, C1398ap.m6249a(this.f9431c.m5703b()), null, null, null, C3364o.m11849a("special", " DESC,", "new", " DESC,", "item_id", " DESC"));
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f9436h.swapCursor(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        this.f9436h.swapCursor(null);
    }

    /* renamed from: c */
    private void m9284c() {
        C2555av.m9493e(this.f9430b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2636k(this)).mo11512b();
    }

    /* renamed from: d */
    private void m9288d() {
        if (this.f9433e == null) {
            this.f9433e = C2555av.m9489a(this.f9430b);
            this.f9433e.setOnCancelListener(new DialogInterfaceOnCancelListenerC2637l(this));
            if (!this.f9433e.isShowing()) {
                this.f9433e.show();
            }
            this.f9433e.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m9290e() {
        if (this.f9433e != null && this.f9433e.isShowing()) {
            this.f9433e.dismiss();
        }
    }

    /* renamed from: f */
    private void m9291f() {
        if (this.f9434f == null) {
            this.f9434f = C2555av.m9490b(this.f9430b);
            this.f9434f.setButton(getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2638m(this));
            this.f9434f.setOnCancelListener(new DialogInterfaceOnCancelListenerC2639n(this));
        }
        if (!this.f9434f.isShowing()) {
            this.f9434f.show();
            this.f9434f.m11483a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m9293g() {
        if (this.f9434f != null && this.f9434f.isShowing()) {
            this.f9434f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m9296h() {
        m9298i();
        if (this.f9435g == null) {
            AbstractC3271a abstractC3271aM9491c = C2555av.m9491c(this.f9430b);
            abstractC3271aM9491c.mo11510b(getString(R.string.setting_selfsms_retry), new DialogInterfaceOnClickListenerC2640o(this));
            this.f9435g = abstractC3271aM9491c.mo11505a();
        }
        if (!this.f9435g.isShowing()) {
            this.f9435g.show();
        }
    }

    /* renamed from: i */
    private void m9298i() {
        if (this.f9435g != null && this.f9435g.isShowing()) {
            this.f9435g.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9280a(String str) {
        m9291f();
        this.f9441m = str;
        this.f9439k = this.f9437i.m5697a(EnumC1172b.UI, this.f9431c, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m9300j() {
        if (this.f9439k == null || this.f9439k.m5494d()) {
            C3332a.m11750a().m11756a(this.f9446r, this.f9442n);
        } else {
            this.f9439k.m5493c();
            this.f9439k = null;
        }
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2614d
    /* renamed from: a */
    public void mo9306a(EnumC1327e enumC1327e, String str) {
        C2555av.m9492d(this.f9430b).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2641p(this, enumC1327e, str)).mo11512b();
    }
}
