package com.sec.chaton.trunk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.trunk.p045d.C1165c;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1335j;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C1619g;
import com.sec.widget.C1632t;
import java.io.File;

/* loaded from: classes.dex */
public class TrunkDetailActivity extends BaseMultiPaneActivity implements InterfaceC1107ae, InterfaceC1126ax {

    /* renamed from: a */
    private TrunkItemView f3766a;

    /* renamed from: a */
    public static void m3985a(Context context, String str, String str2, String str3, String str4, EnumC1168f enumC1168f) {
        Intent intent = new Intent();
        intent.putExtra("sessionId", str);
        intent.putExtra("inboxNO", str2);
        intent.putExtra("itemId", str3);
        intent.putExtra("downloadUrl", str4);
        intent.putExtra("contentType", enumC1168f);
        intent.setClass(context, TrunkDetailActivity.class);
        context.startActivity(intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_trunk_detail);
        Bundle bundleB = m2042b(getIntent());
        this.f3766a = new TrunkItemView();
        this.f3766a.setArguments(bundleB);
        Bundle bundle2 = new Bundle();
        bundle2.putString("sessionId", bundleB.getString("sessionId"));
        bundle2.putString("contentId", bundleB.getString("itemId"));
        TrunkCommentView trunkCommentView = new TrunkCommentView();
        trunkCommentView.setArguments(bundle2);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.trunk_item_layout, this.f3766a);
        fragmentTransactionBeginTransaction.replace(R.id.trunk_comment_layout, trunkCommentView);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: a */
    public void mo3963a(String str, String str2) {
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: a */
    public void mo3962a(EnumC1168f enumC1168f, String str) {
        Intent intentM4620b = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            C1619g.m5889a(this, getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (enumC1168f == EnumC1168f.IMAGE) {
            intentM4620b = C1335j.m4613a(this, getString(R.string.trunk_opt_header_share), str, (String) null, (String) null);
        } else if (enumC1168f == EnumC1168f.VIDEO) {
            intentM4620b = C1335j.m4620b(this, getString(R.string.trunk_opt_header_share), str, (String) null, (String) null);
        }
        if (intentM4620b != null) {
            startActivityForResult(intentM4620b, 2);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: b */
    public void mo3964b(EnumC1168f enumC1168f, String str) {
        Intent intent = new Intent();
        if (enumC1168f == EnumC1168f.IMAGE) {
            if (C1165c.m4207c(str)) {
                intent.setClass(this, AMSPlayerActivity.class);
                intent.putExtra("AMS_FILE_PATH", str);
                intent.putExtra("VIEWER_MODE", 1002);
            } else {
                intent.setClass(this, ViewOriginalImage.class);
                intent.putExtra("URI", str);
                intent.putExtra(C0684a.f2335f, true);
            }
        } else if (enumC1168f == EnumC1168f.VIDEO) {
            intent.setClass(this, VideoPreviewActivity.class);
            intent.putExtra("URI", Uri.fromFile(new File(str)).toString());
            intent.putExtra("playDirectly", true);
        }
        startActivityForResult(intent, 1);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("TrunkTabletActivity.onActivityResult(). requestCode: %s, resultCode: %s.", Integer.valueOf(i), Integer.valueOf(i2)), "TrunkDetailActivity");
        }
        if (i == 1 && i2 == -1) {
            if (intent.getBooleanExtra("SAVE", false)) {
                C1619g.m5888a(this, R.string.toast_save_media, 0).show();
            } else {
                C1619g.m5888a(this, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: b_ */
    public void mo3965b_() {
        finish();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: b */
    public void mo3959b() {
        this.f3766a.m4050b();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: c */
    public void mo3960c() {
    }

    @Override // com.sec.chaton.trunk.InterfaceC1107ae
    /* renamed from: d */
    public void mo3961d() {
        mo3965b_();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (!C1632t.m5917c() || this.f3766a == null) {
            return super.onMenuOpened(i, menu);
        }
        this.f3766a.m4053c();
        return false;
    }
}
