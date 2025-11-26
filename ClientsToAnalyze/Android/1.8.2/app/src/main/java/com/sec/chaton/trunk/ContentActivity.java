package com.sec.chaton.trunk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.util.C1766bv;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSPlayerActivity;
import java.io.File;

/* loaded from: classes.dex */
public class ContentActivity extends BaseSinglePaneActivity implements InterfaceC1553bb {

    /* renamed from: a */
    private static final String f5431a = ContentActivity.class.getSimpleName();

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        return new TrunkItemView();
    }

    /* renamed from: a */
    public static void m5220a(Context context, String str, String str2, String str3, String str4, EnumC1599h enumC1599h) {
        Intent intent = new Intent();
        intent.putExtra("sessionId", str);
        intent.putExtra("inboxNO", str2);
        intent.putExtra("itemId", str3);
        intent.putExtra("downloadUrl", str4);
        intent.putExtra("contentType", enumC1599h);
        intent.setClass(context, ContentActivity.class);
        context.startActivity(intent);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: a */
    public void mo5222a(String str, String str2) {
        CommentActivity.m5216a(this, 2, str, str2, null);
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
                intent.putExtra("URI", str);
                intent.putExtra(C0452a.f1727f, true);
            }
        } else if (enumC1599h == EnumC1599h.VIDEO) {
            intent.setClass(this, VideoPreviewActivity.class);
            intent.putExtra("URI", Uri.fromFile(new File(str)).toString());
            intent.putExtra("playDirectly", true);
        }
        startActivityForResult(intent, 1);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1553bb
    /* renamed from: b_ */
    public void mo5224b_() {
        TrunkActivity.m5231a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C1786r.f6452b) {
            C1786r.m6061b(String.format("ContentActivity.onActivityResult(). requestCode: %s, resultCode: %s.", Integer.valueOf(i), Integer.valueOf(i2)), f5431a);
        }
        if (i == 1) {
            if (i2 == -1) {
                if (intent.getBooleanExtra("SAVE", false)) {
                    Toast.makeText(this, R.string.toast_save_media, 0).show();
                    return;
                } else {
                    Toast.makeText(this, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                    return;
                }
            }
            return;
        }
        if (i == 2 && i2 == -1) {
            try {
                ((TrunkItemView) m1834b()).m5319d();
            } catch (ClassCastException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, f5431a);
                }
            } catch (NullPointerException e2) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("getPane() returns null.", f5431a);
                }
            }
        }
    }
}
