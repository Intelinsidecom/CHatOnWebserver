package com.sec.chaton.multimedia.image;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONFileUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.StorageStateInfoUtil;

/* renamed from: com.sec.chaton.multimedia.image.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC0305a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOriginalImage f2178a;

    ViewOnClickListenerC0305a(ViewOriginalImage viewOriginalImage) {
        this.f2178a = viewOriginalImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!StorageStateInfoUtil.m3677a()) {
            Toast.makeText(this.f2178a.getBaseContext(), C0062R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent();
        String strM3479a = ChatONFileUtil.m3479a(this.f2178a.f2175a, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//ChatON", this.f2178a.f2175a.substring(this.f2178a.f2175a.lastIndexOf("/") + 1));
        if (strM3479a != null) {
            this.f2178a.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            intent.putExtra("SAVE", true);
            this.f2178a.setResult(-1, intent);
            ChatONLogWriter.m3506b("SAVE RESULT OK : " + strM3479a, getClass().getSimpleName());
        } else {
            ChatONLogWriter.m3499a("SAVE RESULT Fail : " + this.f2178a.f2175a, getClass().getSimpleName());
            intent.putExtra("SAVE", false);
            this.f2178a.setResult(-1, intent);
        }
        this.f2178a.finish();
    }
}
