package com.sec.vip.amschaton;

import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.honeycomb.AMSComposerActivity;
import com.sec.vip.amschaton.honeycomb.AMSMyWorksActivity;
import com.sec.vip.amschaton.honeycomb.AMSSamplesActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSFileListActivity extends AMSActivity {

    /* renamed from: a */
    private int f4693a = 1000;

    /* renamed from: b */
    private boolean f4694b = false;

    /* renamed from: c */
    private boolean f4695c = false;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1341p.m4660c("[onCreate]", getClass().getSimpleName());
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.ams_file_list_layout);
        if (!m4743f() || !m4744g()) {
            C1341p.m4651a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            m4738a(R.string.ams_sdcard_unmounted_msg);
            finish();
        } else {
            if (bundle != null) {
                C1341p.m4660c("[onCreate] savedInstanceState is not null!", getClass().getSimpleName());
                return;
            }
            m4814a();
            this.f4693a = 1000;
            Intent intent = new Intent();
            if (f4630l) {
                intent.setClass(this, AMSComposerActivity.class);
            } else {
                intent.setClass(this, com.sec.vip.amschaton.ics.AMSComposerActivity.class);
            }
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getSimpleName());
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        C1341p.m4660c("[onNewIntent] mCurrentState = " + this.f4693a, getClass().getSimpleName());
        super.onNewIntent(intent);
        m4815a(intent.getExtras());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C1341p.m4660c("[onRestoreInstanceState]", getClass().getSimpleName());
        if (bundle != null) {
            this.f4693a = bundle.getInt("SI_CURRENT_STATE", 1000);
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1341p.m4660c("[onSaveInstanceState]", getClass().getSimpleName());
        bundle.putInt("SI_CURRENT_STATE", this.f4693a);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    private void m4815a(Bundle bundle) {
        if (bundle != null) {
            switch (bundle.getInt("ACTION", 2000)) {
                case 2000:
                    m4822b(bundle);
                    break;
                case 2001:
                    m4824d(bundle);
                    break;
                case 2002:
                    m4825e(bundle);
                    break;
                case 2003:
                    m4823c(bundle);
                    break;
                case 2004:
                    m4826f(bundle);
                    break;
                case 2005:
                    m4827g(bundle);
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m4822b(Bundle bundle) {
        switch (this.f4693a) {
            case 1000:
                finish();
                break;
            case 1001:
                m4819a((String) null, false, false);
                break;
            case 1002:
                int i = 1000;
                if (bundle.getInt("AMS_FILE_TYPE", 2001) == 2000) {
                    i = 1001;
                }
                m4821b(i);
                break;
            case 1003:
                String string = bundle.getString("AMS_FILE_PATH");
                if (string == null) {
                    string = f4627i;
                }
                m4819a(string, this.f4694b, this.f4695c);
                break;
            default:
                C1341p.m4651a("[doActionBack] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: c */
    private void m4823c(Bundle bundle) {
        switch (this.f4693a) {
            case 1001:
                if (bundle.getBoolean("AMS_SAVE_FILE", true)) {
                    m4828h();
                }
                String string = bundle.getString("AMS_FILE_PATH");
                this.f4695c = bundle.getBoolean("AMS_EDIT_FLAG", false);
                m4819a(string, false, this.f4695c);
                break;
            case 1002:
                String string2 = bundle.getString("AMS_FILE_PATH");
                this.f4695c = bundle.getBoolean("AMS_EDIT_FLAG", false);
                m4819a(string2, false, this.f4695c);
                break;
            default:
                C1341p.m4651a("[doActionCompose] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: d */
    private void m4824d(Bundle bundle) {
        switch (this.f4693a) {
            case 1000:
                this.f4694b = bundle.getBoolean("AMS_SAVE_FLAG", false);
                m4821b(bundle.getInt("AMS_TAB_ID", 1000));
                break;
            default:
                C1341p.m4651a("[doActionList] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: e */
    private void m4825e(Bundle bundle) {
        switch (this.f4693a) {
            case 1001:
                m4817a(bundle.getString("AMS_FILE_PATH"), bundle.getInt("AMS_FILE_TYPE", 2001), bundle.getBoolean("AMS_DIRECT_PLAY", true));
                break;
            default:
                C1341p.m4651a("[doActionPlay] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: f */
    private void m4826f(Bundle bundle) {
        switch (this.f4693a) {
            case 1000:
                this.f4694b = bundle.getBoolean("AMS_SAVE_FLAG", false);
                String string = bundle.getString("AMS_FILE_PATH");
                if (string == null) {
                    string = f4627i;
                }
                m4816a(string);
                break;
            default:
                C1341p.m4651a("[doActionPlay] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: g */
    private void m4827g(Bundle bundle) {
        switch (this.f4693a) {
            case 1000:
            case 1001:
            case 1002:
            case 1003:
                m4829h(bundle);
                break;
            default:
                C1341p.m4651a("[doActionPlay] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: a */
    private void m4819a(String str, boolean z, boolean z2) {
        this.f4693a = 1000;
        Intent intent = new Intent();
        if (f4630l) {
            intent.setClass(this, AMSComposerActivity.class);
        } else {
            intent.setClass(this, com.sec.vip.amschaton.ics.AMSComposerActivity.class);
        }
        if (str != null) {
            intent.putExtra("AMS_FILE_PATH", str);
        }
        intent.putExtra("AMS_SAVE_FLAG", z);
        intent.putExtra("AMS_EDIT_FLAG", z2);
        intent.putExtra("AMS_PEN_STATE_DEFAULT", false);
        startActivity(intent);
    }

    /* renamed from: b */
    private void m4821b(int i) {
        this.f4693a = 1001;
        Intent intent = new Intent();
        if (f4630l) {
            if (i == 1000) {
                intent.setClass(this, AMSMyWorksActivity.class);
            } else {
                intent.setClass(this, AMSSamplesActivity.class);
            }
            intent.putExtra("AMS_SAVE_FLAG", this.f4694b);
        } else {
            if (i == 1000) {
                intent.setClass(this, com.sec.vip.amschaton.ics.AMSMyWorksActivity.class);
            } else {
                intent.setClass(this, com.sec.vip.amschaton.ics.AMSSamplesActivity.class);
            }
            intent.putExtra("AMS_SAVE_FLAG", this.f4694b);
        }
        intent.putExtra("AMS_TAB_ID", i);
        startActivity(intent);
    }

    /* renamed from: a */
    private void m4817a(String str, int i, boolean z) {
        this.f4693a = 1002;
        Intent intent = new Intent();
        if (f4630l) {
            intent.setClass(this, com.sec.vip.amschaton.honeycomb.AMSPlayerActivity.class);
        } else {
            intent.setClass(this, com.sec.vip.amschaton.ics.AMSPlayerActivity.class);
        }
        intent.putExtra("VIEWER_MODE", 1000);
        intent.putExtra("AMS_DIRECT_PLAY", z);
        if (str != null) {
            intent.putExtra("AMS_FILE_PATH", str);
        }
        if (i > -1) {
            intent.putExtra("AMS_FILE_TYPE", i);
        }
        startActivity(intent);
    }

    /* renamed from: a */
    private void m4816a(String str) {
        this.f4693a = 1003;
        Intent intent = new Intent();
        if (f4630l) {
            intent.setClass(this, com.sec.vip.amschaton.honeycomb.AMSPlayerActivity.class);
        } else {
            intent.setClass(this, com.sec.vip.amschaton.ics.AMSPlayerActivity.class);
        }
        intent.putExtra("VIEWER_MODE", 1001);
        if (str != null) {
            intent.putExtra("AMS_FILE_PATH", str);
        }
        startActivity(intent);
    }

    /* renamed from: a */
    private void m4814a() {
        if (!m4743f() || !m4744g()) {
            C1341p.m4651a("[deleteTempFolder] External Storage Is Not Available or Writable!", getClass().getSimpleName());
            return;
        }
        String[] list = new File(f4626h).list();
        if (list != null) {
            C1341p.m4660c("[deleteTempFolder] fileList.length : " + list.length, getClass().getSimpleName());
            for (String str : list) {
                if (str != null) {
                    C1341p.m4660c(f4626h + str + " : " + new File(f4626h + str).delete(), getClass().getSimpleName());
                }
            }
        }
    }

    /* renamed from: h */
    private void m4829h(Bundle bundle) {
        m4818a(bundle.getString("AMS_FILE_PATH"), bundle.getBoolean("AMS_FILE_TYPE", true));
    }

    /* renamed from: a */
    private void m4818a(String str, boolean z) {
        if (str != null) {
            if (z) {
                String str2 = f4629k + m4813a("A", System.currentTimeMillis(), ".jpg");
                if (!m4820a(str, str2)) {
                    m4738a(R.string.ams_error_ams_file_save);
                    finish();
                    return;
                }
                str = str2;
            }
            C1341p.m4660c("[sendAMS] AMS_FILE_PATH : " + str, getClass().getSimpleName());
            Intent intent = new Intent();
            intent.putExtra("AMS_FILE_PATH", str);
            setResult(-1, intent);
            finish();
        }
    }

    /* renamed from: a */
    private String m4813a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m4820a(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.AMSFileListActivity.m4820a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: h */
    private void m4828h() {
        if (!m4820a(f4627i, f4624f + m4813a("A", System.currentTimeMillis(), "") + ".jpg")) {
            m4738a(R.string.ams_error_ams_file_save);
            finish();
        }
    }
}
