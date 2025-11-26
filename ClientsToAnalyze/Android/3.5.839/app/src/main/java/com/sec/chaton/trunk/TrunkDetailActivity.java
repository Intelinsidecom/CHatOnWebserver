package com.sec.chaton.trunk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.AbstractC0024aj;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.multimedia.p079b.AsyncTaskC2751a;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4869cg;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.io.File;

/* loaded from: classes.dex */
public class TrunkDetailActivity extends BaseMultiPaneActivity implements InterfaceC4585aj, InterfaceC4628bt {

    /* renamed from: p */
    private static final String f16458p = TrunkDetailActivity.class.getSimpleName();

    /* renamed from: n */
    protected String f16459n;

    /* renamed from: o */
    InterfaceC2211y f16460o = new C4587al(this);

    /* renamed from: q */
    private TrunkItemView f16461q;

    /* renamed from: r */
    private InterfaceC4588am f16462r;

    /* renamed from: s */
    private C2210x f16463s;

    /* renamed from: t */
    private String f16464t;

    /* renamed from: u */
    private String f16465u;

    /* renamed from: v */
    private LinearLayout f16466v;

    /* renamed from: w */
    private TextView f16467w;

    /* renamed from: a */
    public static void m17292a(Context context, String str, String str2, String str3, String str4, int i, boolean z, String str5, boolean z2) {
        Intent intent = new Intent();
        intent.putExtra("sessionId", str);
        intent.putExtra("inboxNo", str2);
        intent.putExtra("ownerUid", str3);
        intent.putExtra("fileName", str4);
        intent.putExtra("totalcomment", i);
        intent.putExtra("isvalid", z);
        intent.putExtra("mediaUri", str5);
        intent.putExtra("isVideo", z2);
        intent.setClass(context, TrunkDetailActivity.class);
        context.startActivity(intent);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_trunk_detail);
        this.f16466v = (LinearLayout) findViewById(R.id.floating_menu_layout);
        this.f16467w = (TextView) findViewById(R.id.text_counter);
        this.f16466v.setVisibility(8);
        Bundle bundleA = m6158a(getIntent());
        this.f16461q = new TrunkItemView();
        this.f16462r = this.f16461q;
        if (bundleA.getBoolean("link_mod", false)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("It is deeplink mode.", f16458p);
            }
            this.f16464t = bundleA.getString("sessionId");
            this.f16465u = bundleA.getString("itemId");
            if (this.f16464t != null && this.f16465u != null) {
                this.f16463s = new C2210x(getContentResolver(), this.f16460o);
                this.f16463s.startQuery(0, null, C2299s.f8209a, null, "inbox_session_id =?", new String[]{this.f16464t}, null);
                return;
            }
            return;
        }
        this.f16461q.setArguments(bundleA);
        m17293a(bundleA);
    }

    /* renamed from: a */
    public void m17299a(int i) {
        if (i > 0) {
            this.f16466v.setVisibility(0);
            this.f16467w.setText(i + "/140");
        } else {
            this.f16466v.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17293a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("sessionId", bundle.getString("sessionId"));
        bundle2.putString("itemId", bundle.getString("itemId"));
        bundle2.putBoolean("isvalid", bundle.getBoolean("isvalid"));
        TrunkCommentView trunkCommentView = new TrunkCommentView();
        trunkCommentView.setArguments(bundle2);
        AbstractC0024aj abstractC0024ajMo183a = m50e().mo183a();
        abstractC0024ajMo183a.mo100b(R.id.trunk_item_layout, this.f16461q);
        abstractC0024ajMo183a.mo100b(R.id.trunk_comment_layout, trunkCommentView);
        abstractC0024ajMo183a.mo99b();
    }

    @Override // com.sec.chaton.trunk.InterfaceC4628bt
    /* renamed from: a */
    public void mo17301a(EnumC4642g enumC4642g, String str, String str2) {
        Intent intentM18494a = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            C5179v.m19811a(this, getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (enumC4642g == EnumC4642g.IMAGE || enumC4642g == EnumC4642g.AMS) {
            intentM18494a = C4869cg.m18494a((Context) this, getString(R.string.trunk_opt_header_share), str, str2, (String) null, false);
        } else if (enumC4642g == EnumC4642g.VIDEO) {
            intentM18494a = C4869cg.m18492a(this, getString(R.string.trunk_opt_header_share), str, str2, (String) null);
        }
        if (intentM18494a != null) {
            startActivityForResult(intentM18494a, 2);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4628bt
    /* renamed from: a */
    public void mo17300a(EnumC4642g enumC4642g, String str) {
        new Intent();
        if (C4641f.m17617b(str)) {
            if (C4822an.m18206P() || C4822an.m18207Q()) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            } else {
                if (C2948h.m12190a().m12192a(this, EnumC2949i.Animessage)) {
                    startActivityForResult(C2921a.m12139a(this, str), 1);
                    return;
                }
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
                abstractC4932aM18733a.mo18734a(R.string.media_animessage).mo18746b(R.string.ams_install_message).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4586ak(this)).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
                abstractC4932aM18733a.mo18752b();
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4628bt
    /* renamed from: b */
    public void mo17303b(String str) {
        Intent intent = new Intent();
        if (C4873ck.m18500a()) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(Uri.fromFile(new File(str)).toString()), "video/*");
            intent.putExtra("android.intent.extra.finishOnCompletion", false);
        }
        try {
            startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f16458p);
            }
        }
    }

    /* renamed from: f */
    public void m17306f() {
        this.f16461q.m17424d();
    }

    @Override // com.sec.chaton.trunk.InterfaceC4585aj
    /* renamed from: c_ */
    public void mo17305c_(boolean z) {
        if (z) {
            this.f16461q.m17428g();
        } else {
            this.f16461q.m17429h();
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4585aj
    /* renamed from: a */
    public void mo17298a() {
        mo17302a(true, false);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        BaseActivity.m6159a(this);
    }

    /* renamed from: c */
    public void m17304c(String str) {
        if (!C4847bl.m18333a()) {
            if (!C4873ck.m18500a()) {
                C5179v.m19810a(this, R.string.sdcard_not_found, 0).show();
            } else if (!C4873ck.m18504e()) {
                AbstractC4932a.m18733a(this).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
            } else {
                AsyncTaskC2751a.m11541a(str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", null, false).execute(new String[0]);
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                this.f16461q.m17426e();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.trunk.InterfaceC4628bt
    /* renamed from: a */
    public void mo17302a(boolean z, boolean z2) {
        if (z) {
            setResult(1, null);
        } else {
            Intent intent = new Intent();
            intent.putExtra("noUnread", z2);
            setResult(1, intent);
        }
        finish();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f16462r != null) {
            this.f16462r.mo17421c();
        }
    }
}
