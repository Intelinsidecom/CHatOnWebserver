package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1791w;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: ViewProfileImage.java */
/* renamed from: com.sec.chaton.buddy.fs */
/* loaded from: classes.dex */
class ViewOnClickListenerC0415fs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f1576a;

    ViewOnClickListenerC0415fs(ViewProfileImage viewProfileImage) {
        this.f1576a = viewProfileImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        switch (view.getId()) {
            case R.id.profile_cancel /* 2131493730 */:
                this.f1576a.finish();
                break;
            case R.id.profile_save /* 2131494109 */:
                if (!C1767bw.m6002a()) {
                    Toast.makeText(this.f1576a.getBaseContext(), R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    try {
                        C1791w.m6096a(((BitmapDrawable) this.f1576a.f1301e.getDrawable()).getBitmap(), new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "//Camera//", "ChatON"), "pic_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg", Bitmap.CompressFormat.JPEG, 100);
                        Toast.makeText(this.f1576a.f1299c, this.f1576a.getResources().getString(R.string.buddy_profile_saveprofile_toast_success), 0).show();
                        this.f1576a.m2299b();
                        break;
                    } catch (NullPointerException e) {
                        Toast.makeText(this.f1576a.f1299c, this.f1576a.getResources().getString(R.string.buddy_profile_saveprofile_toast_failed_notready), 0).show();
                        return;
                    } catch (Exception e2) {
                        Toast.makeText(this.f1576a.f1299c, this.f1576a.getResources().getString(R.string.buddy_profile_saveprofile_toast_failed), 0).show();
                        return;
                    }
                }
        }
    }
}
