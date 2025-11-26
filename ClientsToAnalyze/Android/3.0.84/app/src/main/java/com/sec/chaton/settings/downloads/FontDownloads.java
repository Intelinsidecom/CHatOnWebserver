package com.sec.chaton.settings.downloads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.motion.MotionRecognitionManager;
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
import android.widget.ExpandableListView;
import com.sec.chaton.R;
import com.sec.chaton.base.InterfaceC0460e;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1333k;
import com.sec.chaton.p025d.p026a.C1194bv;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.C1401as;
import com.sec.chaton.p027e.p028a.C1369m;
import com.sec.chaton.p035io.entry.inner.FontFilter;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FontDownloads extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, ExpandableListView.OnGroupClickListener, InterfaceC0460e, InterfaceC2578br {

    /* renamed from: b */
    private static final String f9522b = FontDownloads.class.getSimpleName();

    /* renamed from: a */
    ArrayList<FontFilter> f9523a;

    /* renamed from: c */
    private Activity f9524c;

    /* renamed from: d */
    private ExpandableListView f9525d;

    /* renamed from: e */
    private ProgressDialog f9526e;

    /* renamed from: f */
    private C1333k f9527f;

    /* renamed from: g */
    private C1194bv f9528g;

    /* renamed from: h */
    private ViewOnClickListenerC2573bm f9529h;

    /* renamed from: i */
    private C3326c f9530i;

    /* renamed from: j */
    private Menu f9531j;

    /* renamed from: k */
    private Handler f9532k = new HandlerC2563bc(this);

    /* renamed from: l */
    private Handler f9533l = new HandlerC2564bd(this);

    /* renamed from: a */
    void m9362a(boolean z) {
        if (this.f9531j != null) {
            this.f9531j.findItem(R.id.font_filter).setEnabled(z);
            C3228cp.m11343a(this.f9531j.findItem(R.id.font_filter));
        }
    }

    /* renamed from: b */
    void m9363b(boolean z) {
        if (this.f9531j != null) {
            this.f9531j.findItem(R.id.font_downloadAll).setEnabled(z);
            C3228cp.m11343a(this.f9531j.findItem(R.id.font_downloadAll));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9524c = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9527f = new C1333k(this.f9524c, this.f9533l);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_font_list_view, viewGroup, false);
        this.f9530i = new C3326c();
        this.f9525d = (ExpandableListView) viewInflate.findViewById(R.id.font_list);
        this.f9525d.setOnGroupClickListener(this);
        this.f9529h = new ViewOnClickListenerC2573bm(null, this.f9524c, this.f9530i);
        this.f9529h.m9535a(this);
        C2525p.m9458a().m9461a(this.f9529h);
        C2556aw c2556aw = new C2556aw();
        c2556aw.m9499a(this.f9532k);
        this.f9529h.m9534a(c2556aw);
        this.f9525d.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
        m9355e();
        this.f9525d.setItemsCanFocus(true);
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, onCreateView(), request message control : font list", f9522b);
        }
        this.f9528g = this.f9527f.m5772a(EnumC1172b.UI, 120, 120, 640, 640);
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, onDestroyView()", f9522b);
        }
        C2525p.m9458a().m9465b(this.f9529h);
        getLoaderManager().destroyLoader(0);
        if (this.f9528g != null) {
            this.f9528g.m5493c();
        }
        if (this.f9530i != null) {
            this.f9530i.m11731a();
        }
        if (this.f9529h != null) {
            if (this.f9529h.m9536a()) {
                this.f9529h.m9537b();
            }
            this.f9529h.m9538c();
            this.f9529h.m9535a((InterfaceC2578br) null);
        }
        if (this.f9527f != null) {
            this.f9527f.m5774a();
        }
        this.f9533l = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, onDetach()", f9522b);
        }
        this.f9524c = null;
    }

    /* renamed from: c */
    private void m9351c() {
        if (this.f9523a == null) {
            this.f9523a = C1369m.m6101a(this.f9524c);
        }
        if (this.f9523a != null) {
            int iIntValue = C3159aa.m10962a().m10978a("setting_used_font_filter_id", (Integer) (-1)).intValue();
            int size = this.f9523a.size();
            if (size > 0) {
                CharSequence[] charSequenceArr = new CharSequence[size + 1];
                charSequenceArr[0] = getString(R.string.setting_downloads_font_filter_all);
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    FontFilter fontFilter = this.f9523a.get(i);
                    charSequenceArr[i + 1] = fontFilter.title;
                    int i3 = fontFilter.f5644id.intValue() == iIntValue ? i + 1 : i2;
                    i++;
                    i2 = i3;
                }
                AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.font_download_list_title).mo11503a(charSequenceArr, i2, new DialogInterfaceOnClickListenerC2565be(this)).mo11512b();
                return;
            }
            m9363b(false);
            m9362a(false);
        }
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2578br
    /* renamed from: a */
    public void mo9360a(String str) {
        Intent intent = new Intent(this.f9524c, (Class<?>) ActivityFontDetail.class);
        intent.putExtra("ITEM_ID", str);
        startActivityForResult(intent, 1000);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1000:
                if (this.f9529h != null && i2 == 2000) {
                    this.f9529h.notifyDataSetChanged();
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2578br
    /* renamed from: a */
    public void mo9361a(String str, String str2) {
        C2555av.m9492d(this.f9524c).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2566bf(this, str)).mo11512b();
    }

    /* renamed from: d */
    private void m9354d() {
        if (this.f9524c != null) {
            C2555av.m9494f(this.f9524c).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2567bg(this)).mo11512b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.f9531j = menu;
        if (GlobalApplication.m6456e()) {
            menuInflater.inflate(R.menu.download_font_menu_tablet, menu);
            MenuItem item = menu.getItem(0);
            item.setEnabled(false);
            item.getActionView().setFocusable(false);
        } else {
            menuInflater.inflate(R.menu.download_font_menu, menu);
        }
        m9362a(false);
        m9363b(false);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    /* renamed from: a */
    public void m9358a() {
        if (this.f9529h != null && this.f9529h.m9536a()) {
            m9357g();
        } else {
            this.f9524c.finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.font_filter /* 2131166610 */:
                m9351c();
                break;
            case R.id.font_downloadAll /* 2131166611 */:
                m9354d();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.base.InterfaceC0460e
    /* renamed from: a */
    public boolean mo3095a(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f9529h == null || !this.f9529h.m9536a()) {
            return false;
        }
        m9357g();
        return true;
    }

    /* renamed from: e */
    private void m9355e() {
        if (this.f9526e == null) {
            this.f9526e = C2555av.m9489a(this.f9524c);
            this.f9526e.setOnCancelListener(new DialogInterfaceOnCancelListenerC2568bh(this));
            if (!this.f9526e.isShowing()) {
                this.f9526e.show();
            }
            this.f9526e.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m9356f() {
        if (this.f9526e != null && this.f9526e.isShowing()) {
            this.f9526e.dismiss();
        }
    }

    /* renamed from: g */
    private void m9357g() {
        AbstractC3271a abstractC3271aM9493e = C2555av.m9493e(this.f9524c);
        abstractC3271aM9493e.mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2569bi(this));
        abstractC3271aM9493e.mo11512b();
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return true;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] strArr;
        String str;
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, onCreateLoader(), id : " + i, f9522b);
        }
        if (i < -1 || i != -1) {
            return null;
        }
        int iIntValue = C3159aa.m10962a().m10978a("setting_used_font_filter_id", (Integer) (-1)).intValue();
        if (iIntValue > 0) {
            str = "filter_id=?";
            strArr = new String[]{String.valueOf(iIntValue)};
        } else {
            strArr = null;
            str = null;
        }
        return new CursorLoader(this.f9524c, C1401as.f5214a, null, str, strArr, "filter_title");
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        int id = loader.getId();
        if (id < -1) {
        }
        if (C3250y.f11734b) {
            if (cursor != null) {
                C3250y.m11450b("download_font, onLoadFinished(), id/count/cursor : " + id + "/" + cursor.getCount() + "/" + cursor, f9522b);
            } else {
                C3250y.m11450b("download_font, onLoadFinished(), id/count/cursor : " + id + "/... null", f9522b);
            }
        }
        if (id == -1) {
            this.f9525d.setAdapter(this.f9529h);
            try {
                this.f9529h.setGroupCursor(cursor);
                return;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return;
            }
        }
        if (id > -1) {
            try {
                this.f9529h.setChildrenCursor(id, cursor);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        int id = loader.getId();
        if (C3250y.f11734b) {
            C3250y.m11450b("download_font, onLoaderReset(), id : " + id, f9522b);
        }
        if (id < -1) {
        }
        if (id == -1) {
            try {
                this.f9529h.setGroupCursor(null);
                return;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return;
            }
        }
        if (id > -1) {
            try {
                this.f9529h.setChildrenCursor(id, null);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }
}
