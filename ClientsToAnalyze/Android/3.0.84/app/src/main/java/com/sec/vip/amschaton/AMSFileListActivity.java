package com.sec.vip.amschaton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSFileListActivity extends AMSActivity {

    /* renamed from: l */
    private int f12347l = 1000;

    /* renamed from: m */
    private boolean f12348m = false;

    /* renamed from: n */
    private boolean f12349n = false;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C3250y.m11453c("[onCreate]", getClass().getSimpleName());
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.ams_file_list_layout);
        if (!m11976d() || !m11977e()) {
            C3250y.m11442a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            m11973a(R.string.ams_sdcard_unmounted_msg);
            finish();
            return;
        }
        if (bundle != null) {
            C3250y.m11453c("[onCreate] savedInstanceState is not null!", getClass().getSimpleName());
            return;
        }
        m12058f();
        if (!f12277j) {
            m12060g();
        }
        this.f12347l = 1000;
        Intent intent = new Intent();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
            this.f12347l = extras.getInt("AMS_START_STATE", -1);
            switch (this.f12347l) {
                case 1001:
                    intent.setClass(this, BaseAMSActivity.class);
                    break;
                case 1002:
                case 1003:
                default:
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    intent.setClass(this, getClass());
                    break;
                case 1004:
                    intent.setClass(this, BaseAMSActivity.class);
                    intent.putExtra("AMS_ACTION", 3);
                    break;
                case 1005:
                    String string = extras.getString("AMS_FILE_PATH");
                    if (string != null) {
                        intent.putExtra("AMS_FILE_PATH", string);
                    }
                    intent.putExtra("AMS_ACTION", 4);
                    intent.putExtra("VIEWER_MODE", 1003);
                    intent.setClass(this, BaseAMSActivity.class);
                    break;
            }
        } else {
            this.f12347l = 1001;
            intent.setClass(this, BaseAMSActivity.class);
        }
        if (intent.getClass() != null) {
            startActivity(intent);
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C3250y.m11453c("[onDestroy]", getClass().getSimpleName());
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        C3250y.m11453c("[onNewIntent] mCurrentState = " + this.f12347l, getClass().getSimpleName());
        super.onNewIntent(intent);
        m12049a(intent.getExtras());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C3250y.m11453c("[onRestoreInstanceState]", getClass().getSimpleName());
        if (bundle != null) {
            this.f12347l = bundle.getInt("SI_CURRENT_STATE", 1000);
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C3250y.m11453c("[onSaveInstanceState]", getClass().getSimpleName());
        bundle.putInt("SI_CURRENT_STATE", this.f12347l);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    private void m12049a(Bundle bundle) {
        if (bundle != null) {
            switch (bundle.getInt("ACTION", 2000)) {
                case 2000:
                    m12054b(bundle);
                    break;
                case 2001:
                    m12056d(bundle);
                    break;
                case 2002:
                    m12057e(bundle);
                    break;
                case 2003:
                    m12055c(bundle);
                    break;
                case 2004:
                    m12059f(bundle);
                    break;
                case 2005:
                    m12061g(bundle);
                    break;
                case 2006:
                    m12063h(bundle);
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m12054b(Bundle bundle) {
        int i = 1000;
        switch (this.f12347l) {
            case 1000:
                if (f12277j) {
                    finish();
                    break;
                } else {
                    m12053b(1000);
                    break;
                }
            case 1001:
                if (f12277j) {
                    m12048a(1000, null, false, false, false);
                    break;
                } else {
                    finish();
                    break;
                }
            case 1002:
                int i2 = bundle.getInt("AMS_FILE_TYPE", 2001);
                if (i2 == 2000) {
                    i = 1001;
                } else if (i2 == 2002) {
                    i = 1002;
                }
                m12053b(i);
                break;
            case 1003:
                String string = bundle.getString("AMS_FILE_PATH");
                if (string == null) {
                    string = f12274g;
                }
                m12048a(1000, string, this.f12348m, this.f12349n, false);
                break;
            case 1004:
                finish();
                break;
            case 1005:
                break;
            case 1006:
                String string2 = bundle.getString("AMS_FILE_PATH");
                if (string2 == null) {
                    string2 = f12274g;
                }
                m12048a(1004, string2, this.f12348m, this.f12349n, false);
                break;
            default:
                C3250y.m11442a("[doActionBack] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: c */
    private void m12055c(Bundle bundle) {
        switch (this.f12347l) {
            case 1001:
                if (bundle.getBoolean("AMS_SAVE_FILE", true)) {
                    m12062h();
                }
                String string = bundle.getString("AMS_FILE_PATH");
                this.f12349n = bundle.getBoolean("AMS_EDIT_FLAG", false);
                m12048a(1000, string, false, this.f12349n, true);
                break;
            case 1002:
                String string2 = bundle.getString("AMS_FILE_PATH");
                this.f12349n = bundle.getBoolean("AMS_EDIT_FLAG", false);
                m12048a(1000, string2, false, this.f12349n, true);
                break;
            default:
                C3250y.m11442a("[doActionCompose] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: d */
    private void m12056d(Bundle bundle) {
        switch (this.f12347l) {
            case 1000:
                this.f12348m = bundle.getBoolean("AMS_SAVE_FLAG", false);
                m12053b(bundle.getInt("AMS_TAB_ID", 1000));
                break;
            default:
                C3250y.m11442a("[doActionList] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: e */
    private void m12057e(Bundle bundle) {
        switch (this.f12347l) {
            case 1001:
                m12050a(bundle.getString("AMS_FILE_PATH"), bundle.getInt("AMS_FILE_TYPE", 2001), bundle.getBoolean("AMS_DIRECT_PLAY", true));
                break;
            default:
                C3250y.m11442a("[doActionPlay] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: f */
    private void m12059f(Bundle bundle) {
        switch (this.f12347l) {
            case 1000:
                this.f12348m = bundle.getBoolean("AMS_SAVE_FLAG", false);
                String string = bundle.getString("AMS_FILE_PATH");
                if (string == null) {
                    string = f12274g;
                }
                m12047a(1003, string);
                break;
            case 1004:
                this.f12348m = bundle.getBoolean("AMS_SAVE_FLAG", false);
                String string2 = bundle.getString("AMS_FILE_PATH");
                if (string2 == null) {
                    string2 = f12274g;
                }
                m12047a(1006, string2);
                break;
            default:
                C3250y.m11442a("[doActionPreview] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: g */
    private void m12061g(Bundle bundle) {
        switch (this.f12347l) {
            case 1000:
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
                m12064i(bundle);
                break;
            default:
                C3250y.m11442a("[doActionSend] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: h */
    private void m12063h(Bundle bundle) {
        finish();
    }

    /* renamed from: a */
    private void m12048a(int i, String str, boolean z, boolean z2, boolean z3) {
        this.f12347l = i;
        Intent intent = new Intent();
        intent.setClass(this, BaseAMSActivity.class);
        intent.putExtra("AMS_ACTION", 3);
        if (str != null) {
            intent.putExtra("AMS_FILE_PATH", str);
        }
        intent.putExtra("AMS_SAVE_FLAG", z);
        intent.putExtra("AMS_EDIT_FLAG", z2);
        if (f12277j) {
            intent.putExtra("AMS_PEN_STATE_DEFAULT", false);
        } else {
            intent.putExtra("AMS_PEN_STATE_DEFAULT", z3);
        }
        startActivity(intent);
    }

    /* renamed from: b */
    private void m12053b(int i) {
        this.f12347l = 1001;
        Intent intent = new Intent();
        intent.setClass(this, BaseAMSActivity.class);
        intent.putExtra("AMS_ACTION", 0);
        intent.putExtra("AMS_TAB_ID", i);
        startActivity(intent);
    }

    /* renamed from: a */
    private void m12050a(String str, int i, boolean z) {
        this.f12347l = 1002;
        Intent intent = new Intent();
        intent.putExtra("AMS_ACTION", 1);
        intent.setClass(this, BaseAMSActivity.class);
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
    private void m12047a(int i, String str) {
        this.f12347l = i;
        Intent intent = new Intent();
        intent.putExtra("AMS_ACTION", 2);
        intent.setClass(this, BaseAMSActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.putExtra("VIEWER_MODE", 1001);
        if (str != null) {
            intent.putExtra("AMS_FILE_PATH", str);
            intent.putExtra("AMS_SAVE_FLAG", this.f12348m);
        }
        startActivity(intent);
    }

    /* renamed from: f */
    private void m12058f() {
        if (!m11976d() || !m11977e()) {
            C3250y.m11442a("[deleteTempFolder] External Storage Is Not Available or Writable!", getClass().getSimpleName());
            return;
        }
        String[] list = new File(f12273f).list();
        if (list != null) {
            C3250y.m11453c("[deleteTempFolder] fileList.length : " + list.length, getClass().getSimpleName());
            for (String str : list) {
                if (str != null) {
                    C3250y.m11453c(f12273f + str + " : " + new File(f12273f + str).delete(), getClass().getSimpleName());
                }
            }
        }
    }

    /* renamed from: g */
    private void m12060g() {
        if (!m11976d() || !m11977e()) {
            C3250y.m11442a("[deleteOldSentFile] External Storage Is Not Available or Writable!", getClass().getSimpleName());
            return;
        }
        String[] list = new File(f12271d).list();
        if (list != null) {
            C3250y.m11453c("[deleteOldSentFile] fileList.length : " + list.length, getClass().getSimpleName());
            long jCurrentTimeMillis = System.currentTimeMillis();
            C3250y.m11453c("[deleteOldSentFile] currentTime : " + jCurrentTimeMillis, getClass().getSimpleName());
            for (String str : list) {
                if (str != null) {
                    File file = new File(f12271d + str);
                    long jLastModified = file.lastModified();
                    if (jLastModified <= 0) {
                        C3250y.m11453c(file.getAbsolutePath() + " : " + file.delete(), getClass().getSimpleName());
                    } else {
                        C3250y.m11453c("[deleteOldSentFile] lastModifiedTime : " + jLastModified, getClass().getSimpleName());
                        if (jCurrentTimeMillis - jLastModified > 604800000) {
                            C3250y.m11453c(file.getAbsolutePath() + " : " + file.delete(), getClass().getSimpleName());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    private void m12064i(Bundle bundle) {
        m12051a(bundle.getString("AMS_FILE_PATH"), bundle.getString("IMG_FILE_PATH"), bundle.getInt("AMS_FILE_TYPE", 2001), bundle.getInt("AMS_SEND_METHOD", 1));
    }

    /* renamed from: a */
    private void m12051a(String str, String str2, int i, int i2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            if ((i2 & 1) != 0) {
                if (f12277j) {
                    str3 = f12276i + m12046a("A", System.currentTimeMillis(), ".jpg");
                } else {
                    str3 = f12271d + m12046a("A", System.currentTimeMillis(), ".jpg");
                }
                if (!m12052a(str, str3)) {
                    m11973a(R.string.ams_error_ams_file_save);
                    finish();
                    return;
                }
            } else {
                str3 = !TextUtils.isEmpty(str2) ? str2 : str;
            }
            C3250y.m11453c("[sendAMS] AMS_FILE_PATH : " + str3, getClass().getSimpleName());
            Intent intent = new Intent();
            intent.putExtra("AMS_FILE_PATH", str3);
            intent.putExtra("AMS_FILE_PATH_TO_MANAGE", str);
            intent.putExtra("AMS_WITH_TEXT", (i2 & 2) != 0);
            intent.putExtra("AMS_FILE_TYPE", i);
            setResult(-1, intent);
            finish();
        }
    }

    /* renamed from: a */
    private String m12046a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m12052a(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.AMSFileListActivity.m12052a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: h */
    private void m12062h() {
        if (!m12052a(f12274g, f12270c + m12046a("A", System.currentTimeMillis(), "") + ".jpg")) {
            m11973a(R.string.ams_error_ams_file_save);
            finish();
        }
    }
}
