package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.sec.chaton.buddy.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC0087ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f624a;

    ViewOnClickListenerC0087ak(ViewProfileImage viewProfileImage) {
        this.f624a = viewProfileImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        switch (view.getId()) {
            case C0062R.id.profile_cancel /* 2131427906 */:
                this.f624a.finish();
                break;
            case C0062R.id.profile_save /* 2131428112 */:
                if (!StorageStateInfoUtil.m3677a()) {
                    Toast.makeText(this.f624a.getBaseContext(), C0062R.string.sdcard_not_found, 0).show();
                    break;
                } else {
                    try {
                        ChatOnGraphics.m3538a(((BitmapDrawable) this.f624a.f605d.getDrawable()).getBitmap(), new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "//Camera//", "ChatON"), "pic_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".jpg", Bitmap.CompressFormat.JPEG, 100);
                        Toast.makeText(this.f624a.f603b, this.f624a.getResources().getString(C0062R.string.buddy_profile_saveprofile_toast_success), 0).show();
                        this.f624a.m646b();
                    } catch (NullPointerException e) {
                        Toast.makeText(this.f624a.f603b, this.f624a.getResources().getString(C0062R.string.buddy_profile_saveprofile_toast_failed_notready), 0).show();
                    } catch (Exception e2) {
                        Toast.makeText(this.f624a.f603b, this.f624a.getResources().getString(C0062R.string.buddy_profile_saveprofile_toast_failed), 0).show();
                    }
                    this.f624a.finish();
                    break;
                }
        }
    }
}
