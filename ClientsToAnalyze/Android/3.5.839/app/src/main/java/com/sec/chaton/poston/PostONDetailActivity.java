package com.sec.chaton.poston;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.multimedia.image.PostONImagePagerActivity;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class PostONDetailActivity extends BaseSinglePaneActivity implements InterfaceC2979ax {

    /* renamed from: n */
    private InterfaceC3028w f10866n;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        PostONDetailFragment postONDetailFragment = new PostONDetailFragment();
        this.f10866n = postONDetailFragment;
        return postONDetailFragment;
    }

    @Override // com.sec.chaton.poston.InterfaceC2979ax
    /* renamed from: a */
    public void mo12198a(Uri uri) {
        if (PostONImagePagerActivity.class != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, "video/*");
            intent.putExtra("android.intent.extra.finishOnCompletion", false);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, getClass().getSimpleName());
                }
            }
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC2979ax
    /* renamed from: a */
    public void mo12199a(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) BuddyDialog.class);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
        intent.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f10866n == null && (m6162g() instanceof InterfaceC3028w)) {
            this.f10866n = (InterfaceC3028w) m6162g();
        }
        if (this.f10866n != null) {
            this.f10866n.mo12276a();
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC2979ax
    /* renamed from: a */
    public void mo12200a(String str, boolean z) {
        if (str != null) {
            Intent intent = new Intent();
            intent.putExtra(PostONDetailFragment.f10874g, str);
            intent.putExtra(PostONDetailFragment.f10875h, z);
            setResult(-1, intent);
        }
        finish();
    }
}
