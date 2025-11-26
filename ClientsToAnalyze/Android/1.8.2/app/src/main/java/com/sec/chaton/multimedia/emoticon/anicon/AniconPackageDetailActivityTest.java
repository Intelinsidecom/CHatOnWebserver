package com.sec.chaton.multimedia.emoticon.anicon;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.multimedia.emoticon.p030a.C0910a;
import com.sec.chaton.multimedia.emoticon.p030a.p031a.C0914d;
import com.sec.chaton.multimedia.emoticon.p032b.C0952g;
import com.sec.common.p056b.C1816b;
import com.sec.common.p056b.p059c.C1821b;
import com.sec.common.p056b.p061e.C1830a;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;

/* loaded from: classes.dex */
public class AniconPackageDetailActivityTest extends BaseActivity implements View.OnClickListener {

    /* renamed from: a */
    private static final String f3414a = AniconPackageDetailActivity.class.getSimpleName();

    /* renamed from: b */
    private String f3415b;

    /* renamed from: c */
    private String f3416c;

    /* renamed from: d */
    private String f3417d;

    /* renamed from: e */
    private String f3418e;

    /* renamed from: i */
    private String f3419i;

    /* renamed from: j */
    private int f3420j;

    /* renamed from: k */
    private String f3421k;

    /* renamed from: l */
    private ImageView f3422l;

    /* renamed from: m */
    private TextView f3423m;

    /* renamed from: n */
    private TextView f3424n;

    /* renamed from: o */
    private ImageView f3425o;

    /* renamed from: p */
    private ImageView f3426p;

    /* renamed from: q */
    private TextView f3427q;

    /* renamed from: r */
    private ProgressDialog f3428r;

    /* renamed from: s */
    private AlertDialog f3429s;

    /* renamed from: t */
    private C0910a f3430t;

    /* renamed from: u */
    private C1821b f3431u;

    /* renamed from: v */
    private C0914d f3432v;

    /* renamed from: w */
    private File f3433w;

    /* renamed from: x */
    private Handler f3434x = new HandlerC0930m(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3430t = new C0910a(this, this.f3434x);
        this.f3431u = new C1821b();
        this.f3415b = getIntent().getExtras().getString("ANICON_PACKAGE_ID");
        Cursor cursorQuery = getContentResolver().query(C0952g.f3515a, null, "package_id=?", new String[]{this.f3415b}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            this.f3416c = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
            this.f3417d = cursorQuery.getString(cursorQuery.getColumnIndex("preview_url"));
            this.f3418e = cursorQuery.getString(cursorQuery.getColumnIndex("thumbnail_url"));
            this.f3419i = getResources().getString(R.string.layout_chat_fragment_selectall) + " " + cursorQuery.getString(cursorQuery.getColumnIndex("anicon_count")) + " (" + cursorQuery.getString(cursorQuery.getColumnIndex("volume")) + "KB)";
            this.f3420j = cursorQuery.getInt(cursorQuery.getColumnIndex("install"));
            cursorQuery.close();
        }
        m3710b();
    }

    /* renamed from: b */
    private void m3710b() {
        setContentView(R.layout.layout_package_detail_view);
        this.f3422l = (ImageView) findViewById(R.id.anicon_package_item_thumbnail);
        this.f3423m = (TextView) findViewById(R.id.anicon_package_item_name);
        this.f3423m.setText(this.f3416c);
        this.f3424n = (TextView) findViewById(R.id.anicon_package_item_volume);
        this.f3424n.setText(this.f3419i);
        this.f3425o = (ImageView) findViewById(R.id.anicon_package_item_download);
        this.f3427q = (TextView) findViewById(R.id.anicon_download_information);
        if (this.f3420j == 0) {
            this.f3425o.setVisibility(0);
            this.f3427q.setVisibility(8);
        } else {
            this.f3425o.setVisibility(8);
            this.f3427q.setVisibility(0);
        }
        this.f3425o.setOnClickListener(this);
        this.f3426p = (ImageView) findViewById(R.id.anicon_preview_image);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f3433w != null && this.f3433w.exists()) {
            this.f3433w.delete();
        }
        if (this.f3431u != null) {
            this.f3431u.m6191a();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) throws Resources.NotFoundException {
        super.onWindowFocusChanged(z);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_width);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_height);
        int iM6159b = C1816b.m6159b();
        int iM6160c = C1816b.m6160c();
        this.f3431u.m6190a(this.f3422l, new CallableC0917ab(this.f3418e, dimensionPixelOffset, dimensionPixelOffset2));
        CallableC0917ab callableC0917ab = new CallableC0917ab(this.f3417d, iM6159b, iM6160c);
        callableC0917ab.m3777a(R.drawable.detail_emoticon_error);
        this.f3431u.m6190a(this.f3426p, callableC0917ab);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m3708a(this.f3415b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3713c() throws Resources.NotFoundException {
        m3714d();
        if (this.f3429s == null) {
            Resources resources = getResources();
            String string = resources.getString(R.string.toast_error);
            String string2 = resources.getString(R.string.setting_selfsms_retry);
            String string3 = resources.getString(R.string.dialog_cancel);
            String string4 = resources.getString(R.string.anicon_file_download_fail);
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this);
            alertDialogBuilderC2120a.setTitle(string);
            alertDialogBuilderC2120a.setMessage(string4);
            alertDialogBuilderC2120a.setPositiveButton(string3, (DialogInterface.OnClickListener) null);
            alertDialogBuilderC2120a.setNegativeButton(string2, new DialogInterfaceOnClickListenerC0931n(this));
            this.f3429s = alertDialogBuilderC2120a.create();
        }
        if (!this.f3429s.isShowing()) {
            this.f3429s.show();
        }
    }

    /* renamed from: d */
    private void m3714d() {
        if (this.f3429s != null && this.f3429s.isShowing()) {
            this.f3429s.dismiss();
        }
    }

    /* renamed from: e */
    private void m3716e() {
        if (this.f3428r == null) {
            this.f3428r = new ProgressDialog(this);
            this.f3428r.setProgressStyle(1);
            this.f3428r.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_custom));
            this.f3428r.setMessage(getResources().getString(R.string.media_file_download));
            this.f3428r.setButton(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0932o(this));
            this.f3428r.setOnCancelListener(new DialogInterfaceOnCancelListenerC0933p(this));
        }
        if (!this.f3428r.isShowing()) {
            this.f3428r.show();
            this.f3428r.setProgress(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3719f() {
        if (this.f3428r != null && this.f3428r.isShowing()) {
            this.f3428r.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3708a(String str) {
        m3716e();
        this.f3432v = this.f3430t.m3670b(str, "png", 240);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3721g() {
        if (this.f3432v == null || this.f3432v.m2711d()) {
            C1830a.m6211a().m6216a(this.f3434x, this.f3421k);
        } else {
            this.f3432v.m2710c();
        }
    }
}
