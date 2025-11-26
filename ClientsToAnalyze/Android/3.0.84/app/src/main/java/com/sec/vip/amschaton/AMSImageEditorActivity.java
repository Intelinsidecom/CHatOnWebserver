package com.sec.vip.amschaton;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.vip.cropimage.CropImage;
import java.io.File;

/* loaded from: classes.dex */
public class AMSImageEditorActivity extends AMSActivity {

    /* renamed from: l */
    private int f12350l = 1000;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f12350l = extras.getInt("IMAGE_SELECTOR", 1000);
        } else {
            C3250y.m11442a("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        m12069b(this.f12350l);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String string;
        if (i2 != -1) {
            finish();
        }
        switch (i) {
            case 3000:
                m12070b(intent.getData());
                break;
            case 3001:
                new C3586s(this).start();
                break;
            case 3002:
                Bundle extras = intent.getExtras();
                if (extras != null && (string = extras.getString("AMS_CHAT_SKIN_PATH")) != null) {
                    m12070b(Uri.fromFile(new File(string)));
                    break;
                }
                break;
            case 3003:
                m12065a(intent.getData());
                break;
            case 3004:
                new C3587t(this).start();
                break;
            case 3005:
                m12066a(intent.getExtras(), 2000);
                break;
            case 3006:
                m12066a(intent.getExtras(), 2001);
                break;
            default:
                finish();
                break;
        }
    }

    /* renamed from: b */
    private void m12069b(int i) {
        if (i == 1000) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            if (!m12068a(this, intent)) {
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
            }
            startActivityForResult(intent, 3000);
            return;
        }
        if (i == 1001) {
            File file = new File(f12275h);
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
                File file2 = new File(f12275h);
                Intent intent4 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent4.putExtra("output", Uri.fromFile(file2));
                startActivityForResult(intent4, 3004);
                return;
            }
            C3250y.m11442a("[startImageSelector] Wrong image selector!", getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public static boolean m12068a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* renamed from: a */
    private void m12066a(Bundle bundle, int i) {
        if (bundle == null) {
            finish();
            return;
        }
        if (f12277j) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.putExtra("IMAGE_FOR_WHAT", i);
            setResult(-1, intent);
            finish();
            return;
        }
        if (i == 2001) {
            Intent intent2 = new Intent();
            intent2.putExtras(bundle);
            intent2.putExtra("IMAGE_FOR_WHAT", i);
            setResult(-1, intent2);
            finish();
            return;
        }
        if (i == 2000) {
            Intent intent3 = new Intent();
            intent3.putExtras(bundle);
            intent3.putExtra("AMS_FRAME", 1001);
            intent3.putExtra("BACKGROUND_INDEX", 0);
            setResult(-1, intent3);
            finish();
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12065a(Uri uri) {
        Intent intent = new Intent(this, (Class<?>) CropImage.class);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("titleText", getResources().getString(R.string.ams_title_stamp));
        intent.putExtra("outputX", 120);
        intent.putExtra("outputY", 120);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("template", true);
        intent.putExtra("effect", true);
        intent.putExtra("effectFilterList", new int[]{2000, 2027, 2021, 2031, 2017, 2007, 2016, 2002, 2024, 2030, 2009, 2004, 2010});
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3006);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12070b(Uri uri) {
        Intent intent = new Intent(this, (Class<?>) CropImage.class);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("titleText", getResources().getString(R.string.ams_background));
        intent.putExtra("outputX", 240);
        intent.putExtra("outputY", 240);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("template", false);
        intent.putExtra("effect", true);
        intent.putExtra("effectFilterList", new int[]{2000, 2027, 2021, 2031, 2017, 2007, 2016, 2002, 2024, 2030, 2009, 2004, 2010});
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3005);
    }
}
