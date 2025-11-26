package com.sec.chaton.multimedia.video;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.sec.chaton.C0062R;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.StorageStateInfoUtil;

/* loaded from: classes.dex */
public class VideoPreviewActivity extends Activity {

    /* renamed from: a */
    private String f2387a;

    /* renamed from: b */
    private Context f2388b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_video_view);
        this.f2388b = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("URI")) {
                this.f2387a = extras.getString("URI");
            }
            if (this.f2387a != null && extras.getBoolean("playDirectly", false) && StorageStateInfoUtil.m3677a()) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(this.f2387a), "video/*");
                intent.putExtra("android.intent.extra.finishOnCompletion", false);
                startActivity(intent);
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        ChatONLogWriter.m3506b("videoUri: " + this.f2387a, getClass().getSimpleName());
        ImageView imageView = (ImageView) findViewById(C0062R.id.video_image);
        if (this.f2387a == null || ChatONConst.f1339c.equals(this.f2387a)) {
            new AlertDialog.Builder(this.f2388b).setMessage(getResources().getString(C0062R.string.media_download_fail)).setPositiveButton(C0062R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0336j(this)).create().show();
            return;
        }
        if (this.f2387a.contains("file://")) {
            this.f2387a = this.f2387a.substring(7);
        }
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.f2387a, 1);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), C0062R.drawable.view_play_button);
        Drawable drawable = getResources().getDrawable(C0062R.drawable.view_play_button);
        Bitmap bitmapCreateScaledBitmap = (bitmapDecodeResource == null || bitmapCreateVideoThumbnail == null) ? null : Bitmap.createScaledBitmap(bitmapCreateVideoThumbnail, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), true);
        if (bitmapCreateScaledBitmap != null) {
            imageView.setImageDrawable(new LayerDrawable(new Drawable[]{new BitmapDrawable(getResources(), bitmapCreateScaledBitmap), drawable}));
        } else {
            imageView.setImageResource(C0062R.drawable.view_play_button);
        }
        ((Button) findViewById(C0062R.id.save_video)).setOnClickListener(new ViewOnClickListenerC0335i(this));
        ((Button) findViewById(C0062R.id.video_preview_cancel)).setOnClickListener(new ViewOnClickListenerC0334h(this));
        imageView.setOnClickListener(new ViewOnClickListenerC0337k(this));
    }
}
