package com.sec.chaton.trunk;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.multimedia.image.ViewOriginalImage;
import com.sec.chaton.multimedia.video.VideoPreviewActivity;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.trunk.p045d.C1165c;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1335j;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C1619g;
import java.io.File;

@Deprecated
/* loaded from: classes.dex */
public class ContentActivity extends BaseSinglePaneActivity implements InterfaceC1126ax {

    /* renamed from: a */
    private static final String f3749a = ContentActivity.class.getSimpleName();

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new TrunkItemView();
    }

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: a */
    public void mo3963a(String str, String str2) {
        CommentActivity.m3958a(this, 2, str, str2, null);
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
            startActivityForResult(intentM4620b, 3);
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

    @Override // com.sec.chaton.trunk.InterfaceC1126ax
    /* renamed from: b_ */
    public void mo3965b_() {
        TrunkActivity.m3970a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C1341p.f4578b) {
            C1341p.m4658b(String.format("ContentActivity.onActivityResult(). requestCode: %s, resultCode: %s.", Integer.valueOf(i), Integer.valueOf(i2)), f3749a);
        }
        if (i == 1) {
            if (i2 == -1) {
                if (intent.getBooleanExtra("SAVE", false)) {
                    C1619g.m5888a(this, R.string.toast_save_media, 0).show();
                    return;
                } else {
                    C1619g.m5888a(this, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
                    return;
                }
            }
            return;
        }
        if (i == 2 && i2 == -1) {
            try {
                ((TrunkItemView) m2047e()).m4050b();
            } catch (ClassCastException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, f3749a);
                }
            } catch (NullPointerException e2) {
                if (C1341p.f4581e) {
                    C1341p.m4651a("getPane() returns null.", f3749a);
                }
            }
        }
    }
}
