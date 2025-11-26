package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ImageDownloader;

/* renamed from: com.sec.chaton.buddy.ai */
/* loaded from: classes.dex */
class RunnableC0085ai implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageDownloader.ImageDownResult f620a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f621b;

    /* renamed from: c */
    final /* synthetic */ C0086aj f622c;

    RunnableC0085ai(C0086aj c0086aj, ImageDownloader.ImageDownResult imageDownResult, Bitmap bitmap) {
        this.f622c = c0086aj;
        this.f620a = imageDownResult;
        this.f621b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f620a == ImageDownloader.ImageDownResult.SUCCESS) {
            if (this.f621b != null) {
                this.f622c.f623a.f605d.setImageBitmap(this.f621b);
                this.f622c.f623a.f606e.setEnabled(true);
            } else {
                Toast.makeText(this.f622c.f623a.f603b, C0062R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            }
        } else if (this.f620a == ImageDownloader.ImageDownResult.ERROR) {
            Toast.makeText(this.f622c.f623a.f603b, C0062R.string.dev_network_error, 0).show();
        }
        if (this.f622c.f623a.f608g != null) {
            this.f622c.f623a.f608g.dismiss();
        }
        this.f622c.f623a.f607f.setEnabled(true);
    }
}
