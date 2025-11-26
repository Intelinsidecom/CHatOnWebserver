package com.sec.chaton.trunk.tablet;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.trunk.InterfaceC1520af;
import com.sec.chaton.trunk.InterfaceC1553bb;
import com.sec.chaton.trunk.TrunkCommentView;
import com.sec.chaton.trunk.TrunkItemView;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.util.C1766bv;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSPlayerActivity;

/* loaded from: classes.dex */
public class TrunkItemTabletActivity extends BaseMultiPaneActivity implements InterfaceC1520af, InterfaceC1553bb {

    /* renamed from: a */
    private static final String f5750a = TrunkItemTabletActivity.class.getSimpleName();

    /* renamed from: b */
    private String f5751b;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.trunk_content_fragment_container);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Bundle extras = getIntent().getExtras();
        Bundle bundle2 = new Bundle();
        this.f5751b = extras.getString("trunkItemId");
        bundle2.putString("sessionId", extras.getString("sessionId"));
        bundle2.putString("inboxNO", extras.getString("inboxNO"));
        bundle2.putString("itemId", extras.getString("trunkItemId"));
        bundle2.putString("downloadUrl", extras.getString("downloadUrl"));
        bundle2.putSerializable("contentType", extras.getString("contentType"));
        TrunkItemView trunkItemView = new TrunkItemView();
        trunkItemView.setArguments(bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("sessionId", extras.getString("sessionId"));
        bundle3.putString("contentId", extras.getString("trunkItemId"));
        TrunkCommentView trunkCommentView = new TrunkCommentView();
        trunkCommentView.setArguments(bundle3);
        fragmentTransactionBeginTransaction.replace(R.id.trunkItemLayout, trunkItemView);
        fragmentTransactionBeginTransaction.replace(R.id.trunkCommentLayout, trunkCommentView);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("TrunkTabletActivity.onActivityResult(). requestCode: %s, resultCode: %s.", Integer.valueOf(i), Integer.valueOf(i2)), f5750a);
        }
        if (i == 1 && i2 == -1) {
            if (intent.getBooleanExtra("SAVE", false)) {
                Toast.makeText(this, R.string.toast_save_media, 0).show();
            } else {
                Toast.makeText(this, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: a */
    public void mo5222a(String str, String str2) {
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: a */
    public void mo5221a(EnumC1599h enumC1599h, String str) {
        Intent intentM6001b = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            Toast.makeText(this, getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (enumC1599h == EnumC1599h.IMAGE) {
            intentM6001b = C1766bv.m5994a(this, getString(R.string.trunk_opt_header_share), str, (String) null, (String) null);
        } else if (enumC1599h == EnumC1599h.VIDEO) {
            intentM6001b = C1766bv.m6001b(this, getString(R.string.trunk_opt_header_share), str, (String) null, (String) null);
        }
        if (intentM6001b != null) {
            startActivityForResult(intentM6001b, 3);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: b */
    public void mo5223b(EnumC1599h enumC1599h, String str) {
        Intent intent = new Intent();
        if (enumC1599h == EnumC1599h.IMAGE) {
            if (C1598g.m5509c(str)) {
                intent.setClass(this, AMSPlayerActivity.class);
                intent.putExtra("AMS_FILE_PATH", str);
                intent.putExtra("VIEWER_MODE", 1002);
            } else {
                intent.setClass(this, ViewOriginalImage.class);
                intent.putExtra("uri", str);
                intent.putExtra(C0452a.f1727f, true);
                intent.putExtra(C0452a.f1729h, true);
                intent.putExtra(C0452a.f1730i, this.f5751b);
            }
        } else if (enumC1599h == EnumC1599h.VIDEO) {
            intent.setClass(this, VideoPreviewActivity.class);
            intent.putExtra("URI", str);
            intent.putExtra("playDirectly", true);
        }
        startActivityForResult(intent, 1);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: b_ */
    public void mo5224b_() {
        finish();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: c */
    public void mo5217c() {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.trunkItemLayout);
        if (fragmentFindFragmentById instanceof TrunkItemView) {
            ((TrunkItemView) fragmentFindFragmentById).m5319d();
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: d */
    public void mo5218d() {
    }

    @Override // com.sec.chaton.trunk.InterfaceC1520af
    /* renamed from: e */
    public void mo5219e() {
        mo5224b_();
    }
}
