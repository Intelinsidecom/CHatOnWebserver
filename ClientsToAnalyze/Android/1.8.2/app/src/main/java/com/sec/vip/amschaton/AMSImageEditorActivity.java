package com.sec.vip.amschaton;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.util.C1786r;
import com.sec.vip.cropimage.honeycomb.CropImage;
import java.io.File;

/* loaded from: classes.dex */
public class AMSImageEditorActivity extends AMSActivity {

    /* renamed from: l */
    private int f6683l = 1000;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f6683l = extras.getInt("IMAGE_SELECTOR", 1000);
        } else {
            C1786r.m6054a("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m6357b(this.f6683l);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String string;
        if (i2 != -1) {
            finish();
        }
        switch (i) {
            case 3000:
                m6358b(intent.getData());
                break;
            case 3001:
                new C2066p(this).start();
                break;
            case 3002:
                Bundle extras = intent.getExtras();
                if (extras != null && (string = extras.getString("AMS_CHAT_SKIN_PATH")) != null) {
                    m6358b(Uri.fromFile(new File(string)));
                    break;
                }
                break;
            case 3003:
                m6353a(intent.getData());
                break;
            case 3004:
                new C2067q(this).start();
                break;
            case 3005:
                m6354a(intent.getExtras(), 2000);
                break;
            case 3006:
                m6354a(intent.getExtras(), 2001);
                break;
            default:
                finish();
                break;
        }
    }

    /* renamed from: b */
    private void m6357b(int i) {
        if (i == 1000) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            if (!m6356a(this, intent)) {
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
            }
            startActivityForResult(intent, 3000);
            return;
        }
        if (i == 1001) {
            File file = new File(f6615h);
            Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            intent2.putExtra("output", Uri.fromFile(file));
            startActivityForResult(intent2, 3001);
            return;
        }
        if (i == 1003) {
            Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
            intent3.setType("image/*");
            startActivityForResult(intent3, 3003);
        } else {
            if (i == 1004) {
                File file2 = new File(f6615h);
                Intent intent4 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent4.putExtra("output", Uri.fromFile(file2));
                startActivityForResult(intent4, 3004);
                return;
            }
            C1786r.m6054a("[startImageSelector] Wrong image selector!", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static boolean m6356a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* renamed from: a */
    private void m6354a(Bundle bundle, int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6353a(Uri uri) {
        Intent intent;
        if (f6617j) {
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
        startActivityForResult(intent, 3006);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6358b(Uri uri) {
        Intent intent;
        if (f6617j) {
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
        startActivityForResult(intent, 3005);
    }
}
