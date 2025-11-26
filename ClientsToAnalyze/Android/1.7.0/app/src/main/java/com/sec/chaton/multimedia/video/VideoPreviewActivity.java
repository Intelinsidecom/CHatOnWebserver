package com.sec.chaton.multimedia.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class VideoPreviewActivity extends Activity {

    /* renamed from: a */
    View.OnClickListener f2928a = new ViewOnClickListenerC0844a(this);

    /* renamed from: b */
    private String f2929b;

    /* renamed from: c */
    private Context f2930c;

    /* renamed from: d */
    private GeneralHeaderView f2931d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_video_view);
        this.f2930c = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("URI")) {
                this.f2929b = extras.getString("URI");
            }
            if (this.f2929b != null && extras.getBoolean("playDirectly", false) && C1327bw.m4595a()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(this.f2929b), "video/*");
                intent.putExtra("android.intent.extra.finishOnCompletion", false);
                startActivityForResult(intent, 0);
            }
        }
        this.f2931d = (GeneralHeaderView) findViewById(R.id.video_header);
        this.f2931d.setButtonClickListener(this.f2928a);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4658b("videoUri: " + this.f2929b, getClass().getSimpleName());
        ImageView imageView = (ImageView) findViewById(R.id.video_image);
        if (this.f2929b == null || C0684a.f2332c.equals(this.f2929b)) {
            new AlertDialogBuilderC1625m(this.f2930c).setMessage(getResources().getString(R.string.media_download_fail)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0845b(this)).create().show();
            return;
        }
        if (this.f2929b.contains("file://")) {
            this.f2929b = this.f2929b.substring(7);
        }
        imageView.setImageBitmap(ThumbnailUtils.createVideoThumbnail(this.f2929b, 1));
        ((ImageButton) findViewById(R.id.video_play_button)).setOnClickListener(this.f2928a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3413a() {
        if (!C1327bw.m4595a()) {
            C1619g.m5888a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent();
        String strM4581a = C1324bt.m4581a(this.f2929b, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//ChatON", this.f2929b.substring(this.f2929b.lastIndexOf("/") + 1));
        if (strM4581a != null) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            intent.putExtra("SAVE", true);
            setResult(-1, intent);
            C1341p.m4658b("SAVE RESULT OK : " + strM4581a, getClass().getSimpleName());
        } else {
            C1341p.m4651a("SAVE RESULT Fail : " + this.f2929b, getClass().getSimpleName());
            intent.putExtra("SAVE", false);
            setResult(-1, intent);
        }
        finish();
    }
}
