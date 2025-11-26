package com.sec.chaton.multimedia.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.StorageStateInfoUtil;

/* renamed from: com.sec.chaton.multimedia.video.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0335i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VideoPreviewActivity f2424a;

    ViewOnClickListenerC0335i(VideoPreviewActivity videoPreviewActivity) {
        this.f2424a = videoPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!StorageStateInfoUtil.m3677a()) {
            Toast.makeText(this.f2424a.getBaseContext(), C0062R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent();
        String strM3479a = ChatONFileUtil.m3479a(this.f2424a.f2387a, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//ChatON", this.f2424a.f2387a.substring(this.f2424a.f2387a.lastIndexOf("/") + 1));
        if (strM3479a != null) {
            this.f2424a.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            intent.putExtra("SAVE", true);
            this.f2424a.setResult(-1, intent);
            ChatONLogWriter.m3506b("SAVE RESULT OK : " + strM3479a, getClass().getSimpleName());
        } else {
            ChatONLogWriter.m3499a("SAVE RESULT Fail : " + this.f2424a.f2387a, getClass().getSimpleName());
            intent.putExtra("SAVE", false);
            this.f2424a.setResult(-1, intent);
        }
        this.f2424a.finish();
    }
}
