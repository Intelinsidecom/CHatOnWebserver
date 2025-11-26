package com.sec.chaton.settings;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0048d;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.g */
/* loaded from: classes.dex */
public class C2703g extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f10001a;

    /* renamed from: b */
    private LayoutInflater f10002b;

    /* renamed from: c */
    private ImageView f10003c;

    /* renamed from: d */
    private TextView f10004d;

    /* renamed from: g */
    private boolean f10007g;

    /* renamed from: h */
    private boolean f10008h;

    /* renamed from: e */
    private int f10005e = 1;

    /* renamed from: f */
    private boolean f10006f = false;

    /* renamed from: i */
    private InterfaceC0048d f10009i = new C2704h(this);

    public C2703g(AboutServiceFragment aboutServiceFragment) {
        this.f10001a = aboutServiceFragment;
        this.f10007g = false;
        this.f10008h = false;
        this.f10002b = LayoutInflater.from(aboutServiceFragment.f8922m);
        if (C3214cb.m11256a(aboutServiceFragment.f8922m)) {
            this.f10007g = true;
            this.f10005e++;
        }
        if (C3214cb.m11265c("com.sec.spp.push")) {
            this.f10008h = true;
            this.f10005e++;
        }
        if (!this.f10007g && this.f10008h) {
            AboutServiceFragment.f8910e = 1;
            AboutServiceFragment.f8909d = -1;
        }
        m9696a();
    }

    /* renamed from: a */
    private void m9696a() {
        if (this.f10007g) {
            this.f10001a.f8912a[AboutServiceFragment.f8909d] = C3214cb.m11258b("com.coolots.chaton");
            this.f10001a.f8925q = new C0045a();
            if (C3214cb.m11256a(this.f10001a.f8922m) && this.f10001a.f8925q.m55d(this.f10001a.f8922m)) {
                this.f10001a.f8925q.m52a(this.f10001a.f8922m, this.f10009i);
                this.f10001a.f8925q.m65n(this.f10001a.f8922m);
            } else if (C3250y.f11734b) {
                C3250y.m11450b("chatonv update is NOT available", AboutServiceFragment.f8911o);
            }
        }
        if (this.f10008h) {
            this.f10001a.f8912a[AboutServiceFragment.f8910e] = C3214cb.m11258b("com.sec.spp.push");
            try {
                Cursor cursorQuery = this.f10001a.f8922m.getContentResolver().query(Uri.parse("content://com.sec.spp.provider/version_info"), null, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.moveToFirst()) {
                        this.f10001a.f8912a[AboutServiceFragment.f8910e] = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_CURRENT_VERSION));
                        this.f10001a.f8913b[AboutServiceFragment.f8910e] = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_LATEST_VERSION));
                        this.f10006f = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_NEED_UPDATE)));
                        if (C3250y.f11734b) {
                            C3250y.m11450b("[SPP update status] currentVer : " + this.f10001a.f8912a[AboutServiceFragment.f8910e] + " latestVer : " + this.f10001a.f8913b[AboutServiceFragment.f8910e] + " needUpdate : " + this.f10006f, AboutServiceFragment.f8911o);
                        }
                        notifyDataSetChanged();
                        C3159aa.m10963a("spp_update_is", Boolean.valueOf(this.f10006f));
                        if (this.f10006f) {
                            LocalBroadcastManager.getInstance(this.f10001a.f8922m).sendBroadcast(new Intent("more_tab_badge_update"));
                        }
                        C3159aa.m10966a("spp_latest_ver", this.f10001a.f8913b[AboutServiceFragment.f8910e]);
                    }
                    cursorQuery.close();
                    return;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("cursor is null", AboutServiceFragment.f8911o);
                }
            } catch (Exception e) {
                C3250y.m11442a(e.toString(), AboutServiceFragment.f8911o);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10005e;
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
            view = this.f10002b.inflate(R.layout.layout_item_about_service, viewGroup, false);
        }
        this.f10003c = (ImageView) view.findViewById(R.id.icon_image);
        this.f10004d = (TextView) view.findViewById(R.id.service_title);
        this.f10001a.f8927s[i] = (TextView) view.findViewById(R.id.service_current_ver);
        this.f10001a.f8928t[i] = (TextView) view.findViewById(R.id.service_latest_ver);
        this.f10001a.f8929u[i] = (Button) view.findViewById(R.id.button_update);
        switch (i) {
            case 0:
                this.f10003c.setImageResource(R.drawable.setting_chaton_logo);
                this.f10004d.setText(R.string.app_name);
                this.f10001a.f8923n = 0;
                this.f10003c.setClickable(true);
                this.f10003c.setSoundEffectsEnabled(false);
                this.f10003c.setOnClickListener(new ViewOnClickListenerC2705i(this));
                this.f10001a.f8927s[0].setText(this.f10001a.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + this.f10001a.f8912a[0]);
                this.f10001a.f8928t[0].setText(this.f10001a.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (this.f10001a.f8913b[0].length() > 0 ? this.f10001a.f8913b[0] : this.f10001a.f8912a[0]));
                this.f10001a.f8928t[0].setVisibility(0);
                m9697a(0);
                return view;
            case 1:
                if (this.f10007g) {
                    m9698b();
                } else if (this.f10008h) {
                    m9699c();
                }
                return view;
            case 2:
                if (this.f10008h) {
                    m9699c();
                }
                return view;
            default:
                return view;
        }
    }

    /* renamed from: b */
    private void m9698b() {
        String strM10979a;
        this.f10003c.setImageResource(R.drawable.setting_chaton_logo);
        this.f10004d.setText(R.string.chaton_voice_video_chat);
        this.f10001a.f8927s[AboutServiceFragment.f8909d].setText(this.f10001a.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + this.f10001a.f8912a[AboutServiceFragment.f8909d]);
        TextView textView = this.f10001a.f8928t[AboutServiceFragment.f8909d];
        StringBuilder sbAppend = new StringBuilder().append(this.f10001a.getActivity().getResources().getString(R.string.setting_about_latest_ver)).append(" ");
        if (this.f10001a.f8913b[AboutServiceFragment.f8909d] != null) {
            strM10979a = this.f10001a.f8913b[AboutServiceFragment.f8909d];
        } else {
            strM10979a = C3159aa.m10962a().m10979a("chatonv_update_version", (String) null) != null ? C3159aa.m10962a().m10979a("chatonv_update_version", (String) null) : this.f10001a.f8912a[AboutServiceFragment.f8909d];
        }
        textView.setText(sbAppend.append(strM10979a).toString());
        m9697a(AboutServiceFragment.f8909d);
    }

    /* renamed from: c */
    private void m9699c() {
        this.f10003c.setImageResource(R.drawable.setting_pushservice_logo);
        this.f10004d.setText(R.string.registration_samsung_push_service);
        this.f10001a.f8927s[AboutServiceFragment.f8910e].setText(this.f10001a.getActivity().getResources().getString(R.string.setting_about_current_ver) + " " + this.f10001a.f8912a[AboutServiceFragment.f8910e]);
        this.f10001a.f8928t[AboutServiceFragment.f8910e].setText(this.f10001a.getActivity().getResources().getString(R.string.setting_about_latest_ver) + " " + (C3159aa.m10962a().m10979a("spp_latest_ver", (String) null) != null ? C3159aa.m10962a().m10979a("spp_latest_ver", (String) null) : this.f10001a.f8912a[AboutServiceFragment.f8910e]));
        m9697a(AboutServiceFragment.f8910e);
    }

    /* renamed from: a */
    private void m9697a(int i) {
        if (i == 0) {
            this.f10001a.m8915a(i);
            if (this.f10001a.f8914c == null || this.f10001a.f8914c.length() <= 0) {
                this.f10001a.f8929u[i].setEnabled(false);
                return;
            } else {
                this.f10001a.f8929u[i].setEnabled(true);
                return;
            }
        }
        if (i == AboutServiceFragment.f8909d) {
            this.f10001a.m8915a(i);
            if (this.f10001a.f8926r || C3159aa.m10962a().m10978a("chatonVUpdateStatus", (Integer) 0).intValue() != 0) {
                this.f10001a.f8929u[i].setEnabled(true);
                return;
            } else {
                this.f10001a.f8929u[i].setEnabled(false);
                return;
            }
        }
        if (i == AboutServiceFragment.f8910e) {
            this.f10001a.m8915a(i);
            if (this.f10006f || C3159aa.m10962a().m10977a("spp_update_is", (Boolean) false).booleanValue()) {
                this.f10001a.f8929u[i].setEnabled(true);
            } else {
                this.f10001a.f8929u[i].setEnabled(false);
            }
        }
    }
}
