package com.sec.chaton.multimedia.image;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.GeneralHeaderView;
import java.io.IOException;

/* loaded from: classes.dex */
public class ViewOriginalImage extends Activity {

    /* renamed from: a */
    private String f2740a;

    /* renamed from: b */
    private Context f2741b;

    /* renamed from: c */
    private GeneralHeaderView f2742c;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_original_imageview);
        this.f2741b = this;
    }

    @Override // android.app.Activity
    protected void onResume() {
        Boolean boolValueOf;
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("URI")) {
            this.f2740a = extras.getString("URI");
        }
        C1341p.m4658b("imageUri: " + this.f2740a, getClass().getSimpleName());
        if (this.f2740a == null || C0684a.f2332c.equals(this.f2740a)) {
            new AlertDialogBuilderC1625m(this.f2741b).setMessage(getResources().getString(R.string.media_download_fail)).setPositiveButton(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0808a(this)).create().show();
            return;
        }
        this.f2742c = (GeneralHeaderView) findViewById(R.id.header_view);
        this.f2742c.setButtonClickListener(new ViewOnClickListenerC0809b(this));
        ImageView imageView = (ImageView) findViewById(R.id.original_image);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Display defaultDisplay = ((WindowManager) this.f2741b.getSystemService("window")).getDefaultDisplay();
            BitmapFactory.decodeFile(this.f2740a, options);
            options.inSampleSize = 1;
            int i = options.outWidth >> 1;
            for (int i2 = options.outHeight >> 1; i > defaultDisplay.getWidth() && i2 > defaultDisplay.getHeight(); i2 >>= 1) {
                options.inSampleSize <<= 1;
                i >>= 1;
            }
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.f2740a, options);
            if (bitmapDecodeFile != null) {
                try {
                    String attribute = new ExifInterface(this.f2740a).getAttribute("Orientation");
                    Matrix matrix = new Matrix();
                    Boolean.valueOf(false);
                    if ("6".equals(attribute)) {
                        boolValueOf = Boolean.valueOf(matrix.postRotate(90.0f));
                    } else if ("3".equals(attribute)) {
                        boolValueOf = Boolean.valueOf(matrix.postRotate(180.0f));
                    } else if ("8".equals(attribute)) {
                        boolValueOf = Boolean.valueOf(matrix.postRotate(270.0f));
                    } else {
                        boolValueOf = false;
                    }
                    if (boolValueOf.booleanValue()) {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                        if (bitmapDecodeFile != null) {
                            bitmapDecodeFile.recycle();
                            bitmapDecodeFile = bitmapCreateBitmap;
                        } else {
                            bitmapDecodeFile = bitmapCreateBitmap;
                        }
                    }
                    imageView.setImageBitmap(bitmapDecodeFile);
                } catch (IOException e) {
                    C1341p.m4653a(e, getApplicationContext().getClass().getName());
                }
            }
        } catch (Exception e2) {
            C1341p.m4653a(e2, getApplicationContext().getClass().getName());
        }
    }

    /* renamed from: a */
    public void m3301a() {
        if (!C1327bw.m4595a()) {
            C1619g.m5888a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent();
        String strM4581a = C1324bt.m4581a(this.f2740a, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//ChatON", this.f2740a.substring(this.f2740a.lastIndexOf("/") + 1));
        if (strM4581a != null) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            intent.putExtra("SAVE", true);
            setResult(-1, intent);
            C1341p.m4658b("SAVE RESULT OK : " + strM4581a, getClass().getSimpleName());
        } else {
            C1341p.m4651a("SAVE RESULT Fail : " + this.f2740a, getClass().getSimpleName());
            intent.putExtra("SAVE", false);
            setResult(-1, intent);
        }
        finish();
    }
}
