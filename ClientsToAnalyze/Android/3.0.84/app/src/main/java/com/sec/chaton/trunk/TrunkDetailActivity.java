package com.sec.chaton.trunk;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3220ch;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C3641ai;
import java.io.File;

/* loaded from: classes.dex */
public class TrunkDetailActivity extends BaseMultiPaneActivity implements InterfaceC2968ai, InterfaceC3009bq {

    /* renamed from: a */
    protected String f10518a;

    /* renamed from: b */
    private TrunkItemView f10519b;

    /* renamed from: c */
    private InterfaceC2969aj f10520c;

    /* renamed from: a */
    public static void m10199a(Context context, String str, String str2, String str3, String str4, int i, boolean z, String str5, boolean z2) {
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
        Bundle bundleB = m3082b(getIntent());
        this.f10519b = new TrunkItemView();
        this.f10519b.setArguments(bundleB);
        this.f10520c = this.f10519b;
        Bundle bundle2 = new Bundle();
        bundle2.putString("sessionId", bundleB.getString("sessionId"));
        bundle2.putString("itemId", bundleB.getString("itemId"));
        bundle2.putBoolean("isvalid", bundleB.getBoolean("isvalid"));
        TrunkCommentView trunkCommentView = new TrunkCommentView();
        trunkCommentView.setArguments(bundle2);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.trunk_item_layout, this.f10519b);
        fragmentTransactionBeginTransaction.replace(R.id.trunk_comment_layout, trunkCommentView);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.sec.chaton.trunk.InterfaceC3009bq
    /* renamed from: a */
    public void mo10203a(EnumC3026g enumC3026g, String str, String str2) {
        Intent intentM11322a = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            C3641ai.m13211a(this, getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (enumC3026g == EnumC3026g.IMAGE || enumC3026g == EnumC3026g.AMS) {
            intentM11322a = C3220ch.m11322a((Context) this, getString(R.string.trunk_opt_header_share), str, str2, (String) null, false);
        } else if (enumC3026g == EnumC3026g.VIDEO) {
            intentM11322a = C3220ch.m11326b(this, getString(R.string.trunk_opt_header_share), str, str2, null);
        }
        if (intentM11322a != null) {
            startActivityForResult(intentM11322a, 2);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3009bq
    /* renamed from: a */
    public void mo10202a(EnumC3026g enumC3026g, String str) {
        Intent intent = new Intent();
        if (C3025f.m10540b(str)) {
            intent.setClass(this, AMSPlayerActivity.class);
            intent.putExtra("AMS_FILE_PATH", str);
            intent.putExtra("VIEWER_MODE", 1002);
            startActivityForResult(intent, 1);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC3009bq
    /* renamed from: b */
    public void mo10206b(String str) {
        Intent intent = new Intent();
        if (C3223ck.m11327a()) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(Uri.fromFile(new File(str)).toString()), "video/*");
            intent.putExtra("android.intent.extra.finishOnCompletion", false);
        }
        startActivityForResult(intent, 1);
    }

    /* renamed from: c */
    public void m10207c() {
        this.f10519b.m10329d();
    }

    @Override // com.sec.chaton.trunk.InterfaceC2968ai
    /* renamed from: a */
    public void mo10201a() {
        this.f10519b.m10332g();
    }

    @Override // com.sec.chaton.trunk.InterfaceC2968ai
    /* renamed from: b */
    public void mo10205b() {
        mo10204a(true, false);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        m10200d();
        BaseActivity.m3080a(this);
    }

    /* renamed from: d */
    private void m10200d() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: c */
    public void m10208c(String str) throws Throwable {
        if (!C3197bl.m11159a()) {
            if (!C3223ck.m11327a()) {
                C3641ai.m13210a(this, R.string.sdcard_not_found, 0).show();
                return;
            }
            String strM11415a = C3243r.m11415a(str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//ChatON", str.substring(str.lastIndexOf("/") + 1));
            if (strM11415a != null) {
                sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
                C3250y.m11450b("SAVE RESULT OK : " + strM11415a, getClass().getSimpleName());
                C3641ai.m13210a(this, R.string.toast_save_media, 0).show();
            } else {
                C3250y.m11442a("SAVE RESULT Fail : " + str, getClass().getSimpleName());
                C3641ai.m13210a(this, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                this.f10519b.m10330e();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.trunk.InterfaceC3009bq
    /* renamed from: a */
    public void mo10204a(boolean z, boolean z2) {
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
        if (this.f10520c != null) {
            this.f10520c.mo10326c();
        }
    }
}
