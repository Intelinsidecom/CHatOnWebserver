package com.sec.chaton.settings;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.C0096i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0419d;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.g */
/* loaded from: classes.dex */
public class C3644g extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f13204a;

    /* renamed from: b */
    private LayoutInflater f13205b;

    /* renamed from: c */
    private ImageView f13206c;

    /* renamed from: d */
    private TextView f13207d;

    /* renamed from: g */
    private boolean f13210g;

    /* renamed from: h */
    private boolean f13211h;

    /* renamed from: e */
    private int f13208e = 1;

    /* renamed from: f */
    private boolean f13209f = false;

    /* renamed from: i */
    private InterfaceC0419d f13212i = new C3660h(this);

    public C3644g(AboutServiceFragment aboutServiceFragment) {
        this.f13204a = aboutServiceFragment;
        this.f13210g = false;
        this.f13211h = false;
        this.f13205b = LayoutInflater.from(aboutServiceFragment.f12452m);
        if (C4859bx.m18386a(aboutServiceFragment.f12452m)) {
            this.f13210g = true;
            this.f13208e++;
        }
        if (C4859bx.m18397c("com.sec.spp.push")) {
            this.f13211h = true;
            this.f13208e++;
        }
        if (!this.f13210g && this.f13211h) {
            AboutServiceFragment.f12440e = 1;
            AboutServiceFragment.f12439d = -1;
        }
        m13924a();
    }

    /* renamed from: a */
    private void m13924a() {
        if (this.f13210g) {
            this.f13204a.f12442a[AboutServiceFragment.f12439d] = C4859bx.m18390b(C4859bx.m18402e());
            this.f13204a.f12455q = new C0416a();
            if (C4859bx.m18386a(this.f13204a.f12452m) && this.f13204a.f12455q.m1495d(this.f13204a.f12452m)) {
                this.f13204a.f12455q.m1492a(this.f13204a.f12452m, this.f13212i);
                this.f13204a.f12455q.m1505n(this.f13204a.f12452m);
            } else if (C4904y.f17872b) {
                C4904y.m18639b("chatonv update is NOT available", AboutServiceFragment.f12441o);
            }
        }
        if (this.f13211h) {
            this.f13204a.f12442a[AboutServiceFragment.f12440e] = C4859bx.m18390b("com.sec.spp.push");
            try {
                Cursor cursorQuery = this.f13204a.f12452m.getContentResolver().query(Uri.parse("content://com.sec.spp.provider/version_info"), null, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.moveToFirst()) {
                        this.f13204a.f12442a[AboutServiceFragment.f12440e] = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_CURRENT_VERSION));
                        this.f13204a.f12443b[AboutServiceFragment.f12440e] = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_LATEST_VERSION));
                        this.f13209f = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_NEED_UPDATE)));
                        if (C4904y.f17872b) {
                            C4904y.m18639b("[SPP update status] currentVer : " + this.f13204a.f12442a[AboutServiceFragment.f12440e] + " latestVer : " + this.f13204a.f12443b[AboutServiceFragment.f12440e] + " needUpdate : " + this.f13209f, AboutServiceFragment.f12441o);
                        }
                        notifyDataSetChanged();
                        C4809aa.m18105a("spp_update_is", Boolean.valueOf(this.f13209f));
                        if (this.f13209f) {
                            C0096i.m358a(this.f13204a.f12452m).m363a(new Intent("more_tab_badge_update"));
                        }
                        C4809aa.m18108a("spp_latest_ver", this.f13204a.f12443b[AboutServiceFragment.f12440e]);
                    }
                    cursorQuery.close();
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("cursor is null", AboutServiceFragment.f12441o);
                }
            } catch (Exception e) {
                C4904y.m18634a(e.toString(), AboutServiceFragment.f12441o);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13208e;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f13205b.inflate(R.layout.layout_item_about_service, viewGroup, false);
        }
        this.f13206c = (ImageView) view.findViewById(R.id.icon_image);
        this.f13207d = (TextView) view.findViewById(R.id.service_title);
        this.f13204a.f12457s[i] = (TextView) view.findViewById(R.id.service_current_ver);
        this.f13204a.f12458t[i] = (TextView) view.findViewById(R.id.service_latest_ver);
        this.f13204a.f12459u[i] = (Button) view.findViewById(R.id.button_update);
        switch (i) {
            case 0:
                this.f13206c.setImageResource(R.drawable.setting_chaton_logo);
                this.f13207d.setText(R.string.app_name);
                this.f13204a.f12453n = 0;
                this.f13206c.setClickable(true);
                this.f13206c.setSoundEffectsEnabled(false);
                this.f13206c.setOnClickListener(new ViewOnClickListenerC3661i(this));
                this.f13204a.f12457s[0].setText(this.f13204a.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + this.f13204a.f12442a[0]);
                this.f13204a.f12458t[0].setText(this.f13204a.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (this.f13204a.f12443b[0].length() > 0 ? this.f13204a.f12443b[0] : this.f13204a.f12442a[0]));
                this.f13204a.f12458t[0].setVisibility(0);
                m13925a(0);
                return view;
            case 1:
                if (this.f13210g) {
                    m13926b();
                } else if (this.f13211h) {
                    m13927c();
                }
                return view;
            case 2:
                if (this.f13211h) {
                    m13927c();
                }
                return view;
            default:
                return view;
        }
    }

    /* renamed from: b */
    private void m13926b() {
        String strM18121a;
        this.f13206c.setImageResource(R.drawable.setting_chaton_logo);
        this.f13207d.setText(R.string.chaton_voice_video_chat);
        this.f13204a.f12457s[AboutServiceFragment.f12439d].setText(this.f13204a.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + this.f13204a.f12442a[AboutServiceFragment.f12439d]);
        TextView textView = this.f13204a.f12458t[AboutServiceFragment.f12439d];
        StringBuilder sbAppend = new StringBuilder().append(this.f13204a.getActivity().getResources().getString(R.string.setting_about_latest_ver)).append(" ");
        if (this.f13204a.f12443b[AboutServiceFragment.f12439d] != null) {
            strM18121a = this.f13204a.f12443b[AboutServiceFragment.f12439d];
        } else {
            strM18121a = C4809aa.m18104a().m18121a("chatonv_update_version", (String) null) != null ? C4809aa.m18104a().m18121a("chatonv_update_version", (String) null) : this.f13204a.f12442a[AboutServiceFragment.f12439d];
        }
        textView.setText(sbAppend.append(strM18121a).toString());
        m13925a(AboutServiceFragment.f12439d);
    }

    /* renamed from: c */
    private void m13927c() {
        this.f13206c.setImageResource(R.drawable.setting_pushservice_logo);
        this.f13207d.setText(R.string.registration_samsung_push_service);
        try {
            this.f13204a.f12457s[AboutServiceFragment.f12440e].setText(this.f13204a.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + this.f13204a.f12442a[AboutServiceFragment.f12440e]);
            this.f13204a.f12458t[AboutServiceFragment.f12440e].setText(this.f13204a.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (C4809aa.m18104a().m18121a("spp_latest_ver", (String) null) != null ? C4809aa.m18104a().m18121a("spp_latest_ver", (String) null) : this.f13204a.f12442a[AboutServiceFragment.f12440e]));
            m13925a(AboutServiceFragment.f12440e);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m13925a(int i) {
        if (i == 0) {
            this.f13204a.m13302a(i);
            if (this.f13204a.f12444c == null || this.f13204a.f12444c.length() <= 0) {
                this.f13204a.f12459u[i].setEnabled(false);
                return;
            } else {
                this.f13204a.f12459u[i].setEnabled(true);
                return;
            }
        }
        if (i == AboutServiceFragment.f12439d) {
            this.f13204a.m13302a(i);
            if (this.f13204a.f12456r || C4809aa.m18104a().m18120a("chatonVUpdateStatus", (Integer) 0).intValue() != 0) {
                this.f13204a.f12459u[i].setEnabled(true);
                return;
            } else {
                this.f13204a.f12459u[i].setEnabled(false);
                return;
            }
        }
        if (i == AboutServiceFragment.f12440e) {
            this.f13204a.m13302a(i);
            if (this.f13209f || C4809aa.m18104a().m18119a("spp_update_is", (Boolean) false).booleanValue()) {
                this.f13204a.f12459u[i].setEnabled(true);
            } else {
                this.f13204a.f12459u[i].setEnabled(false);
            }
        }
    }
}
