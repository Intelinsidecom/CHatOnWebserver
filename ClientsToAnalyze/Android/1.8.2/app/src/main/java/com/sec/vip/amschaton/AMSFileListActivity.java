package com.sec.vip.amschaton;

import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.honeycomb.AMSComposerActivity;
import com.sec.vip.amschaton.honeycomb.AMSMyWorksActivity;
import com.sec.vip.amschaton.honeycomb.AMSSamplesActivity;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSFileListActivity extends AMSActivity {

    /* renamed from: l */
    private int f6680l = 1000;

    /* renamed from: m */
    private boolean f6681m = false;

    /* renamed from: n */
    private boolean f6682n = false;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C1786r.m6063c("[onCreate]", getClass().getSimpleName());
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.ams_file_list_layout);
        if (!m6266e() || !m6267f()) {
            C1786r.m6054a("External Storage Is Not Available or Writable!", getClass().getSimpleName());
            m6262a(R.string.ams_sdcard_unmounted_msg);
            finish();
        } else {
            if (bundle != null) {
                C1786r.m6063c("[onCreate] savedInstanceState is not null!", getClass().getSimpleName());
                return;
            }
            m6347g();
            if (!f6617j) {
                m6349h();
            }
            this.f6680l = 1000;
            Intent intent = new Intent();
            if (f6617j) {
                intent.setClass(this, AMSComposerActivity.class);
            } else {
                intent.setClass(this, com.sec.vip.amschaton.ics.AMSComposerActivity.class);
            }
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getSimpleName());
        if (f6617j) {
            if (!AMSComposerActivity.f6911m) {
                AMSComposerActivity.f6910l = true;
            }
        } else if (!com.sec.vip.amschaton.ics.AMSComposerActivity.f7139m) {
            com.sec.vip.amschaton.ics.AMSComposerActivity.f7138l = true;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        C1786r.m6063c("[onNewIntent] mCurrentState = " + this.f6680l, getClass().getSimpleName());
        super.onNewIntent(intent);
        m6335a(intent.getExtras());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        C1786r.m6063c("[onRestoreInstanceState]", getClass().getSimpleName());
        if (bundle != null) {
            this.f6680l = bundle.getInt("SI_CURRENT_STATE", 1000);
        }
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1786r.m6063c("[onSaveInstanceState]", getClass().getSimpleName());
        bundle.putInt("SI_CURRENT_STATE", this.f6680l);
        super.onSaveInstanceState(bundle);
    }

    /* renamed from: a */
    private void m6335a(Bundle bundle) {
        if (bundle != null) {
            switch (bundle.getInt("ACTION", 2000)) {
                case 2000:
                    m6342b(bundle);
                    break;
                case 2001:
                    m6344d(bundle);
                    break;
                case 2002:
                    m6345e(bundle);
                    break;
                case 2003:
                    m6343c(bundle);
                    break;
                case 2004:
                    m6346f(bundle);
                    break;
                case 2005:
                    m6348g(bundle);
                    break;
                case 2006:
                    m6350h(bundle);
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m6342b(Bundle bundle) {
        switch (this.f6680l) {
            case 1000:
                finish();
                break;
            case 1001:
                m6339a((String) null, false, false);
                break;
            case 1002:
                int i = 1000;
                if (bundle.getInt("AMS_FILE_TYPE", 2001) == 2000) {
                    i = 1001;
                }
                m6341b(i);
                break;
            case 1003:
                String string = bundle.getString("AMS_FILE_PATH");
                if (string == null) {
                    string = f6614g;
                }
                m6339a(string, this.f6681m, this.f6682n);
                break;
            default:
                C1786r.m6054a("[doActionBack] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: c */
    private void m6343c(Bundle bundle) {
        switch (this.f6680l) {
            case 1001:
                if (bundle.getBoolean("AMS_SAVE_FILE", true)) {
                    m6351i();
                }
                String string = bundle.getString("AMS_FILE_PATH");
                this.f6682n = bundle.getBoolean("AMS_EDIT_FLAG", false);
                m6339a(string, false, this.f6682n);
                break;
            case 1002:
                String string2 = bundle.getString("AMS_FILE_PATH");
                this.f6682n = bundle.getBoolean("AMS_EDIT_FLAG", false);
                m6339a(string2, false, this.f6682n);
                break;
            default:
                C1786r.m6054a("[doActionCompose] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: d */
    private void m6344d(Bundle bundle) {
        switch (this.f6680l) {
            case 1000:
                this.f6681m = bundle.getBoolean("AMS_SAVE_FLAG", false);
                m6341b(bundle.getInt("AMS_TAB_ID", 1000));
                break;
            default:
                C1786r.m6054a("[doActionList] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: e */
    private void m6345e(Bundle bundle) {
        switch (this.f6680l) {
            case 1001:
                m6338a(bundle.getString("AMS_FILE_PATH"), bundle.getInt("AMS_FILE_TYPE", 2001), bundle.getBoolean("AMS_DIRECT_PLAY", true));
                break;
            default:
                C1786r.m6054a("[doActionPlay] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: f */
    private void m6346f(Bundle bundle) {
        switch (this.f6680l) {
            case 1000:
                this.f6681m = bundle.getBoolean("AMS_SAVE_FLAG", false);
                String string = bundle.getString("AMS_FILE_PATH");
                if (string == null) {
                    string = f6614g;
                }
                m6336a(string);
                break;
            default:
                C1786r.m6054a("[doActionPreview] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: g */
    private void m6348g(Bundle bundle) {
        switch (this.f6680l) {
            case 1000:
            case 1001:
            case 1002:
            case 1003:
                m6352i(bundle);
                break;
            default:
                C1786r.m6054a("[doActionSend] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: h */
    private void m6350h(Bundle bundle) {
        switch (this.f6680l) {
            case 1000:
            case 1001:
            case 1002:
            case 1003:
                finish();
                break;
            default:
                C1786r.m6054a("[doActionExit] invalid state", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: a */
    private void m6339a(String str, boolean z, boolean z2) {
        this.f6680l = 1000;
        Intent intent = new Intent();
        if (f6617j) {
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
    private void m6341b(int i) {
        this.f6680l = 1001;
        Intent intent = new Intent();
        if (f6617j) {
            if (i == 1000) {
                intent.setClass(this, AMSMyWorksActivity.class);
            } else {
                intent.setClass(this, AMSSamplesActivity.class);
            }
            intent.putExtra("AMS_SAVE_FLAG", this.f6681m);
        } else {
            if (i == 1000) {
                intent.setClass(this, com.sec.vip.amschaton.ics.AMSMyWorksActivity.class);
            } else {
                intent.setClass(this, com.sec.vip.amschaton.ics.AMSSamplesActivity.class);
            }
            intent.putExtra("AMS_SAVE_FLAG", this.f6681m);
        }
        intent.putExtra("AMS_TAB_ID", i);
        startActivity(intent);
    }

    /* renamed from: a */
    private void m6338a(String str, int i, boolean z) {
        this.f6680l = 1002;
        Intent intent = new Intent();
        if (f6617j) {
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
    private void m6336a(String str) {
        this.f6680l = 1003;
        Intent intent = new Intent();
        if (f6617j) {
            intent.setClass(this, com.sec.vip.amschaton.honeycomb.AMSPlayerActivity.class);
        } else {
            intent.setClass(this, com.sec.vip.amschaton.ics.AMSPlayerActivity.class);
        }
        intent.putExtra("VIEWER_MODE", 1001);
        if (str != null) {
            intent.putExtra("AMS_FILE_PATH", str);
            intent.putExtra("AMS_SAVE_FLAG", this.f6681m);
        }
        startActivity(intent);
    }

    /* renamed from: g */
    private void m6347g() {
        if (!m6266e() || !m6267f()) {
            C1786r.m6054a("[deleteTempFolder] External Storage Is Not Available or Writable!", getClass().getSimpleName());
            return;
        }
        String[] list = new File(f6613f).list();
        if (list != null) {
            C1786r.m6063c("[deleteTempFolder] fileList.length : " + list.length, getClass().getSimpleName());
            for (String str : list) {
                if (str != null) {
                    C1786r.m6063c(f6613f + str + " : " + new File(f6613f + str).delete(), getClass().getSimpleName());
                }
            }
        }
    }

    /* renamed from: h */
    private void m6349h() {
        if (!m6266e() || !m6267f()) {
            C1786r.m6054a("[deleteOldSentFile] External Storage Is Not Available or Writable!", getClass().getSimpleName());
            return;
        }
        String[] list = new File(f6611d).list();
        if (list != null) {
            C1786r.m6063c("[deleteOldSentFile] fileList.length : " + list.length, getClass().getSimpleName());
            long jCurrentTimeMillis = System.currentTimeMillis();
            C1786r.m6063c("[deleteOldSentFile] currentTime : " + jCurrentTimeMillis, getClass().getSimpleName());
            for (String str : list) {
                if (str != null) {
                    File file = new File(f6611d + str);
                    long jLastModified = file.lastModified();
                    if (jLastModified <= 0) {
                        C1786r.m6063c(file.getAbsolutePath() + " : " + file.delete(), getClass().getSimpleName());
                    } else {
                        C1786r.m6063c("[deleteOldSentFile] lastModifiedTime : " + jLastModified, getClass().getSimpleName());
                        if (jCurrentTimeMillis - jLastModified > 604800000) {
                            C1786r.m6063c(file.getAbsolutePath() + " : " + file.delete(), getClass().getSimpleName());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    private void m6352i(Bundle bundle) {
        m6337a(bundle.getString("AMS_FILE_PATH"), bundle.getInt("AMS_SEND_METHOD", 1));
    }

    /* renamed from: a */
    private void m6337a(String str, int i) {
        String str2;
        if (str != null) {
            if ((i & 1) != 0) {
                if (f6617j) {
                    str2 = f6616i + m6334a("A", System.currentTimeMillis(), ".jpg");
                } else {
                    str2 = f6611d + m6334a("A", System.currentTimeMillis(), ".jpg");
                }
                if (!m6340a(str, str2)) {
                    m6262a(R.string.ams_error_ams_file_save);
                    finish();
                    return;
                }
            } else {
                str2 = str;
            }
            C1786r.m6063c("[sendAMS] AMS_FILE_PATH : " + str2, getClass().getSimpleName());
            Intent intent = new Intent();
            intent.putExtra("AMS_FILE_PATH", str2);
            intent.putExtra("AMS_WITH_TEXT", (i & 2) != 0);
            setResult(-1, intent);
            finish();
        }
    }

    /* renamed from: a */
    private String m6334a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m6340a(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.AMSFileListActivity.m6340a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: i */
    private void m6351i() {
        if (!m6340a(f6614g, f6610c + m6334a("A", System.currentTimeMillis(), "") + ".jpg")) {
            m6262a(R.string.ams_error_ams_file_save);
            finish();
        }
    }
}
