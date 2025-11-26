package com.sec.chaton.multimedia.emoticon.anicon;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.p030a.C0910a;
import com.sec.chaton.multimedia.emoticon.p030a.p031a.C0914d;
import com.sec.chaton.multimedia.emoticon.p032b.C0952g;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.C1816b;
import com.sec.common.p056b.p059c.AbstractRunnableC1820a;
import com.sec.common.p056b.p059c.C1821b;
import com.sec.common.p056b.p059c.InterfaceC1824e;
import com.sec.common.p056b.p060d.C1828c;
import com.sec.common.p056b.p061e.C1830a;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;

/* loaded from: classes.dex */
public class AniconPackageDetailActivity extends Fragment implements View.OnClickListener, InterfaceC1824e {

    /* renamed from: a */
    private static final String f3389a = AniconPackageDetailActivity.class.getSimpleName();

    /* renamed from: b */
    private String f3390b;

    /* renamed from: c */
    private String f3391c;

    /* renamed from: d */
    private String f3392d;

    /* renamed from: e */
    private String f3393e;

    /* renamed from: f */
    private String f3394f;

    /* renamed from: g */
    private int f3395g;

    /* renamed from: h */
    private String f3396h;

    /* renamed from: i */
    private int f3397i;

    /* renamed from: j */
    private int f3398j;

    /* renamed from: k */
    private ImageView f3399k;

    /* renamed from: l */
    private TextView f3400l;

    /* renamed from: m */
    private TextView f3401m;

    /* renamed from: n */
    private ImageView f3402n;

    /* renamed from: o */
    private ImageView f3403o;

    /* renamed from: p */
    private Button f3404p;

    /* renamed from: q */
    private TextView f3405q;

    /* renamed from: r */
    private TextView f3406r;

    /* renamed from: s */
    private ProgressDialog f3407s;

    /* renamed from: t */
    private AlertDialog f3408t;

    /* renamed from: u */
    private C0910a f3409u;

    /* renamed from: v */
    private C1821b f3410v;

    /* renamed from: w */
    private C0914d f3411w;

    /* renamed from: x */
    private File f3412x;

    /* renamed from: y */
    private Handler f3413y = new HandlerC0924g(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3409u = new C0910a(getActivity(), this.f3413y);
        this.f3410v = new C1821b();
        this.f3410v.m6195a(this);
        this.f3390b = getArguments().getString("ANICON_PACKAGE_ID");
    }

    /* renamed from: a */
    public void m3700a() throws Resources.NotFoundException {
        String dateTime = null;
        Cursor cursorQuery = getActivity().getContentResolver().query(C0952g.f3515a, null, "package_id=?", new String[]{this.f3390b}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            this.f3391c = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
            this.f3392d = cursorQuery.getString(cursorQuery.getColumnIndex("preview_url"));
            this.f3393e = cursorQuery.getString(cursorQuery.getColumnIndex("thumbnail_url"));
            this.f3394f = cursorQuery.getString(cursorQuery.getColumnIndex("anicon_count")) + " (" + (cursorQuery.getInt(cursorQuery.getColumnIndex("volume")) / 1000) + "KB)";
            this.f3395g = cursorQuery.getInt(cursorQuery.getColumnIndex("install"));
            this.f3397i = cursorQuery.getInt(cursorQuery.getColumnIndex("new"));
            this.f3398j = cursorQuery.getInt(cursorQuery.getColumnIndex("special"));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("expiration_time"));
            if (this.f3395g != 0 && j != 0) {
                dateTime = DateUtils.formatDateTime(getActivity(), j, 8212);
            }
            if (dateTime != null) {
                this.f3394f = C1828c.m6207a(this.f3394f, " / ", dateTime);
            }
            cursorQuery.close();
        }
        this.f3400l.setText(this.f3391c);
        this.f3401m.setText(this.f3394f);
        if (this.f3395g == 0) {
            this.f3402n.setVisibility(0);
            this.f3405q.setVisibility(8);
        } else {
            this.f3402n.setVisibility(8);
            this.f3405q.setVisibility(0);
        }
        if (this.f3395g == 0) {
            this.f3402n.setVisibility(0);
            this.f3404p.setVisibility(8);
        } else {
            this.f3402n.setVisibility(8);
            this.f3404p.setVisibility(0);
        }
        if (this.f3398j != 0) {
            this.f3406r.setVisibility(0);
            this.f3406r.setText(R.string.download_special_ribbon_text);
            this.f3406r.setBackgroundResource(R.drawable.thumbnail_special_bg);
        } else if (this.f3397i != 0) {
            this.f3406r.setVisibility(0);
            this.f3406r.setText(R.string.download_new_ribbon_text);
            this.f3406r.setBackgroundResource(R.drawable.thumbnail_new_bg);
        } else {
            this.f3406r.setVisibility(8);
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_width);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_height);
        int iM6159b = C1816b.m6159b();
        int iM6160c = C1816b.m6160c();
        this.f3410v.m6190a(this.f3399k, new CallableC0917ab(this.f3393e, dimensionPixelOffset, dimensionPixelOffset2));
        CallableC0917ab callableC0917ab = new CallableC0917ab(this.f3392d, iM6159b, iM6160c);
        callableC0917ab.m3777a(R.drawable.detail_emoticon_error);
        this.f3410v.m6190a(this.f3403o, callableC0917ab);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        C1786r.m6063c("onActivityCreated()", f3389a);
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        View viewInflate = layoutInflater.inflate(R.layout.layout_package_detail_view, viewGroup, false);
        this.f3399k = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_thumbnail);
        this.f3400l = (TextView) viewInflate.findViewById(R.id.anicon_package_item_name);
        this.f3401m = (TextView) viewInflate.findViewById(R.id.anicon_package_item_volume);
        this.f3402n = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_download);
        this.f3405q = (TextView) viewInflate.findViewById(R.id.anicon_download_information);
        this.f3402n.setOnClickListener(this);
        this.f3404p = (Button) viewInflate.findViewById(R.id.anicon_package_item_uninstall);
        this.f3404p.setOnClickListener(this);
        this.f3406r = (TextView) viewInflate.findViewById(R.id.anicon_package_item_ribbon);
        this.f3403o = (ImageView) viewInflate.findViewById(R.id.anicon_preview_image);
        m3700a();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f3412x != null && this.f3412x.exists()) {
            this.f3412x.delete();
        }
        if (this.f3410v != null) {
            this.f3410v.m6195a((InterfaceC1824e) null);
            this.f3410v.m6191a();
        }
        if (this.f3411w != null) {
            this.f3411w.m2710c();
            m3695f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (view == this.f3402n) {
            m3684a(this.f3390b);
        } else if (view == this.f3404p) {
            new AlertDialogBuilderC2120a(getActivity()).setTitle(R.string.anicon_package_uninstall).setMessage(String.format(getString(R.string.anicon_package_uninstall_description), this.f3391c)).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0925h(this)).setNegativeButton(R.string.dialog_cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3689c() throws Resources.NotFoundException {
        m3690d();
        if (this.f3408t == null) {
            Resources resources = getResources();
            String string = resources.getString(R.string.toast_error);
            String string2 = resources.getString(R.string.setting_selfsms_retry);
            String string3 = resources.getString(R.string.dialog_cancel);
            String string4 = resources.getString(R.string.anicon_file_download_fail);
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(getActivity());
            alertDialogBuilderC2120a.setTitle(string);
            alertDialogBuilderC2120a.setMessage(string4);
            alertDialogBuilderC2120a.setPositiveButton(string3, (DialogInterface.OnClickListener) null);
            alertDialogBuilderC2120a.setNegativeButton(string2, new DialogInterfaceOnClickListenerC0926i(this));
            this.f3408t = alertDialogBuilderC2120a.create();
        }
        if (!this.f3408t.isShowing()) {
            this.f3408t.show();
        }
    }

    /* renamed from: d */
    private void m3690d() {
        if (this.f3408t != null && this.f3408t.isShowing()) {
            this.f3408t.dismiss();
        }
    }

    /* renamed from: e */
    private void m3692e() throws Resources.NotFoundException {
        if (this.f3407s == null) {
            this.f3407s = new ProgressDialog(new ContextThemeWrapper(getActivity(), R.style.CustomProgressDialogtheme));
            this.f3407s.setProgressStyle(1);
            this.f3407s.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_custom));
            this.f3407s.setTitle(getResources().getString(R.string.media_file_download));
            this.f3407s.setButton(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0927j(this));
            this.f3407s.setOnCancelListener(new DialogInterfaceOnCancelListenerC0928k(this));
        }
        if (!this.f3407s.isShowing()) {
            this.f3407s.show();
            this.f3407s.setProgress(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3695f() {
        if (this.f3407s != null && this.f3407s.isShowing()) {
            this.f3407s.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3684a(String str) throws Resources.NotFoundException {
        m3692e();
        this.f3411w = this.f3409u.m3670b(str, "png", 240);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3697g() {
        if (this.f3411w == null || this.f3411w.m2711d()) {
            C1830a.m6211a().m6216a(this.f3413y, this.f3396h);
        } else {
            this.f3411w.m2710c();
        }
    }

    @Override // com.sec.common.p056b.p059c.InterfaceC1824e
    /* renamed from: a */
    public void mo3701a(View view, AbstractRunnableC1820a abstractRunnableC1820a) {
        if (view == this.f3403o) {
            this.f3403o.setBackgroundResource(R.drawable.picturebox2);
        }
    }

    @Override // com.sec.common.p056b.p059c.InterfaceC1824e
    /* renamed from: b */
    public void mo3702b(View view, AbstractRunnableC1820a abstractRunnableC1820a) {
    }
}
