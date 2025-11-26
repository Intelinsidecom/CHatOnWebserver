package com.sec.chaton.multimedia.emoticon.ams;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.ActivityAmsItemDownloads;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.settings.downloads.InterfaceC2644s;
import com.sec.chaton.settings.downloads.InterfaceC2645t;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import com.sec.vip.amschaton.C3584q;
import com.sec.vip.amschaton.p071a.C3398f;
import twitter4j.Query;

/* loaded from: classes.dex */
public class AmsContainer extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, InterfaceC2644s, InterfaceC2645t {

    /* renamed from: a */
    private static final String f6722a = AmsContainer.class.getSimpleName();

    /* renamed from: b */
    private static Handler f6723b = new Handler();

    /* renamed from: c */
    private String f6724c;

    /* renamed from: d */
    private Activity f6725d;

    /* renamed from: e */
    private GridView f6726e;

    /* renamed from: f */
    private View f6727f;

    /* renamed from: g */
    private View f6728g;

    /* renamed from: h */
    private TextView f6729h;

    /* renamed from: i */
    private Button f6730i;

    /* renamed from: j */
    private TextView f6731j;

    /* renamed from: k */
    private View f6732k;

    /* renamed from: l */
    private View f6733l;

    /* renamed from: m */
    private View f6734m;

    /* renamed from: n */
    private C1809f f6735n;

    /* renamed from: o */
    private C1810g f6736o;

    /* renamed from: p */
    private C3398f f6737p;

    /* renamed from: q */
    private C3326c f6738q;

    /* renamed from: r */
    private InterfaceC1806c f6739r;

    /* renamed from: a */
    public static final AmsContainer m7444a() {
        return new AmsContainer();
    }

    /* renamed from: a */
    public void m7446a(InterfaceC1806c interfaceC1806c) {
        this.f6739r = interfaceC1806c;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6725d = activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f6738q = new C3326c();
        this.f6724c = null;
        String string = bundle != null ? bundle.getString("currentTabId") : null;
        String str = TextUtils.isEmpty(string) ? "myWorks" : string;
        View viewInflate = layoutInflater.inflate(R.layout.layout_ams_container, viewGroup, false);
        this.f6726e = (GridView) viewInflate.findViewById(R.id.amsGridView);
        this.f6726e.setVisibility(0);
        this.f6726e.setOnItemClickListener(this);
        this.f6737p = new C3398f(this.f6725d);
        this.f6737p.m12126b();
        if (!C3584q.m12778a().m12806b()) {
            if (C3250y.f11736d) {
                C3250y.m11455d("AMSFileManager isn't loaded, loading now.", f6722a);
            }
            C3584q.m12778a().m12795a(this.f6725d);
        }
        this.f6735n = new C1809f(this.f6725d, null, 2, this.f6738q);
        this.f6736o = new C1810g(this.f6725d, this.f6738q);
        this.f6727f = viewInflate.findViewById(R.id.amsEmptyView);
        this.f6728g = viewInflate.findViewById(R.id.amsDownloadView);
        this.f6729h = (TextView) viewInflate.findViewById(R.id.amsDownloadDescription);
        this.f6730i = (Button) viewInflate.findViewById(R.id.amsDownloadButton);
        this.f6730i.setOnClickListener(this);
        this.f6732k = viewInflate.findViewById(R.id.amsDownloadTabIndicator);
        this.f6732k.setOnClickListener(this);
        this.f6731j = (TextView) viewInflate.findViewById(R.id.amsNewTemplateTextView);
        this.f6733l = viewInflate.findViewById(R.id.amsRecentTabIndicator);
        this.f6733l.setOnClickListener(this);
        this.f6734m = viewInflate.findViewById(R.id.amsMyWorksTabIndicator);
        this.f6734m.setOnClickListener(this);
        m7447a(str);
        C2642q.m9635a((InterfaceC2644s) this);
        C2642q.m9636a((InterfaceC2645t) this);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        int iM9632a = C2642q.m9632a(EnumC1327e.Template);
        if (iM9632a == 0) {
            this.f6731j.setVisibility(8);
        } else {
            this.f6731j.setVisibility(0);
            C3228cp.m11345a(this.f6731j, iM9632a);
        }
        this.f6736o.notifyDataSetChanged();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C2642q.m9639b((InterfaceC2644s) this);
        C2642q.m9640b((InterfaceC2645t) this);
        if (this.f6735n != null) {
            this.f6735n.changeCursor(null);
        }
        if (this.f6737p != null) {
            this.f6737p.mo12098a();
        }
        if (this.f6738q != null) {
            this.f6738q.m11731a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6725d = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentTabId", this.f6724c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f6732k)) {
            m7447a("download");
            return;
        }
        if (view.equals(this.f6733l)) {
            m7447a(Query.RECENT);
            return;
        }
        if (view.equals(this.f6734m)) {
            m7447a("myWorks");
        } else if (view.equals(this.f6730i)) {
            Intent intent = new Intent(this.f6725d, (Class<?>) ActivityAmsItemDownloads.class);
            intent.putExtra("amsType", EnumC1327e.Template);
            startActivity(intent);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f6724c.equals(Query.RECENT)) {
            Cursor cursor = (Cursor) this.f6735n.getItem(i);
            String string = cursor.getString(cursor.getColumnIndex("ams_path"));
            int i2 = cursor.getInt(cursor.getColumnIndex("ams_type"));
            EnumC1807d enumC1807d = null;
            if (i2 == 2000) {
                enumC1807d = EnumC1807d.Basic;
            } else if (i2 == 2002) {
                enumC1807d = EnumC1807d.Download;
            } else if (i2 == 2001) {
                enumC1807d = EnumC1807d.User;
            }
            this.f6739r.mo7442a(this, enumC1807d, string);
            return;
        }
        if (this.f6724c.equals("myWorks")) {
            String str = (String) this.f6736o.getItem(i);
            if (j == 0) {
                this.f6739r.mo7441a(this);
            } else {
                this.f6739r.mo7442a(this, EnumC1807d.m7449a(j), str);
            }
        }
    }

    /* renamed from: a */
    public void m7447a(String str) {
        if (TextUtils.isEmpty(this.f6724c) || !this.f6724c.equals(str)) {
            if ("download".equals(str)) {
                this.f6724c = "download";
                this.f6732k.setSelected(true);
                this.f6733l.setSelected(false);
                this.f6734m.setSelected(false);
                this.f6726e.setVisibility(8);
                this.f6727f.setVisibility(8);
                this.f6728g.setVisibility(0);
                if (C3584q.m12778a().m12809c() == 0) {
                    this.f6729h.setText(R.string.ams_item_no_download_title);
                } else {
                    this.f6729h.setText(R.string.ams_item_more_download_title);
                }
                this.f6726e.setAdapter((ListAdapter) null);
                return;
            }
            if (Query.RECENT.equals(str)) {
                this.f6724c = Query.RECENT;
                this.f6732k.setSelected(false);
                this.f6733l.setSelected(true);
                this.f6734m.setSelected(false);
                this.f6726e.setVisibility(0);
                this.f6727f.setVisibility(8);
                this.f6728g.setVisibility(8);
                this.f6735n.changeCursor(this.f6737p.m12128c());
                this.f6726e.setAdapter((ListAdapter) this.f6735n);
                if (this.f6735n.isEmpty()) {
                    this.f6726e.setVisibility(8);
                    this.f6727f.setVisibility(0);
                    return;
                }
                return;
            }
            if ("myWorks".equals(str)) {
                this.f6724c = "myWorks";
                this.f6732k.setSelected(false);
                this.f6733l.setSelected(false);
                this.f6734m.setSelected(true);
                this.f6726e.setVisibility(0);
                this.f6727f.setVisibility(8);
                this.f6728g.setVisibility(8);
                this.f6726e.setAdapter((ListAdapter) this.f6736o);
            }
        }
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2645t
    /* renamed from: a */
    public void mo7445a(EnumC1327e enumC1327e, String str) {
        f6723b.post(new RunnableC1804a(this, enumC1327e));
    }

    @Override // com.sec.chaton.settings.downloads.InterfaceC2644s
    /* renamed from: b */
    public void mo7448b(EnumC1327e enumC1327e, String str) {
        f6723b.post(new RunnableC1805b(this, enumC1327e));
    }
}
