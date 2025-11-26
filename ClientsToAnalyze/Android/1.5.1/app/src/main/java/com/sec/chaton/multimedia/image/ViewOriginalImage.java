package com.sec.chaton.multimedia.image;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import com.sec.chaton.C0062R;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public class ViewOriginalImage extends Activity {

    /* renamed from: a */
    private String f2175a;

    /* renamed from: b */
    private Context f2176b;

    /* renamed from: c */
    private boolean f2177c;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_original_imageview);
        this.f2176b = this;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("URI")) {
            this.f2175a = extras.getString("URI");
        }
        if (extras != null && extras.containsKey(ChatONConst.f1341e)) {
            this.f2177c = extras.getBoolean(ChatONConst.f1341e);
        }
        ChatONLogWriter.m3506b("imageUri: " + this.f2175a, getClass().getSimpleName());
        if (this.f2175a == null || ChatONConst.f1339c.equals(this.f2175a)) {
            new AlertDialog.Builder(this.f2176b).setMessage(getResources().getString(C0062R.string.media_download_fail)).setPositiveButton(C0062R.string.dialog_confirm, new DialogInterfaceOnClickListenerC0307c(this)).create().show();
            return;
        }
        Button button = (Button) findViewById(C0062R.id.send_image);
        Button button2 = (Button) findViewById(C0062R.id.save_image);
        ((Button) findViewById(C0062R.id.image_preview_cancel)).setOnClickListener(new ViewOnClickListenerC0308d(this));
        ImageView imageView = (ImageView) findViewById(C0062R.id.original_image);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Display defaultDisplay = ((WindowManager) this.f2176b.getSystemService("window")).getDefaultDisplay();
            BitmapFactory.decodeFile(this.f2175a, options);
            options.inSampleSize = 1;
            int i = options.outWidth >> 1;
            for (int i2 = options.outHeight >> 1; i > defaultDisplay.getWidth() && i2 > defaultDisplay.getHeight(); i2 >>= 1) {
                options.inSampleSize <<= 1;
                i >>= 1;
            }
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.f2175a, options);
            if (bitmapDecodeFile != null) {
                try {
                    String attribute = new ExifInterface(this.f2175a).getAttribute("Orientation");
                    Matrix matrix = new Matrix();
                    Boolean.valueOf(false);
                    if ((attribute.equals("6") ? Boolean.valueOf(matrix.postRotate(90.0f)) : attribute.equals("3") ? Boolean.valueOf(matrix.postRotate(180.0f)) : attribute.equals("8") ? Boolean.valueOf(matrix.postRotate(270.0f)) : false).booleanValue()) {
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
                    ChatONLogWriter.m3501a(e, getApplicationContext().getClass().getName());
                    return;
                }
            }
            if (this.f2177c) {
                button2.setOnClickListener(new ViewOnClickListenerC0305a(this));
                return;
            }
            button2.setVisibility(8);
            button.setVisibility(0);
            button.setOnClickListener(new ViewOnClickListenerC0306b(this));
        } catch (Exception e2) {
            ChatONLogWriter.m3501a(e2, getApplicationContext().getClass().getName());
        }
    }
}
