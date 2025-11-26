package com.sec.vip.amschaton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.util.C1341p;
import com.sec.vip.cropimage.honeycomb.CropImage;
import java.io.File;

/* loaded from: classes.dex */
public class AMSImageEditorActivity extends AMSActivity {

    /* renamed from: a */
    private int f4696a = 1000;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4696a = extras.getInt("IMAGE_SELECTOR", 1000);
        } else {
            C1341p.m4651a("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m4833b(this.f4696a);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            finish();
        }
        switch (i) {
            case 3000:
                m4834b(intent.getData());
                break;
            case 3001:
                new C1555t(this).start();
                break;
            case 3002:
                m4830a(intent.getData());
                break;
            case 3003:
                m4831a(intent.getExtras(), 2000);
                break;
            case 3004:
                m4831a(intent.getExtras(), 2001);
                break;
            default:
                finish();
                break;
        }
    }

    /* renamed from: b */
    private void m4833b(int i) {
        if (i == 1000) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            startActivityForResult(intent, 3000);
        } else {
            if (i == 1001) {
                File file = new File(f4628j);
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("output", Uri.fromFile(file));
                startActivityForResult(intent2, 3001);
                return;
            }
            if (i == 1002) {
                Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
                intent3.setType("image/*");
                startActivityForResult(intent3, 3002);
                return;
            }
            C1341p.m4651a("[startImageSelector] Wrong image selector!", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m4831a(Bundle bundle, int i) {
        if (bundle == null) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("IMAGE_FOR_WHAT", i);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: a */
    private void m4830a(Uri uri) {
        Intent intent;
        if (f4630l) {
            intent = new Intent(this, (Class<?>) CropImage.class);
        } else {
            intent = new Intent(this, (Class<?>) com.sec.vip.cropimage.ics.CropImage.class);
        }
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("outputX", 120);
        intent.putExtra("outputY", 120);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("template", true);
        intent.putExtra("effect", false);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3004);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4834b(Uri uri) {
        Intent intent;
        if (f4630l) {
            intent = new Intent(this, (Class<?>) CropImage.class);
        } else {
            intent = new Intent(this, (Class<?>) com.sec.vip.cropimage.ics.CropImage.class);
        }
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("outputX", 240);
        intent.putExtra("outputY", 240);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("template", false);
        intent.putExtra("effect", true);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3003);
    }
}
