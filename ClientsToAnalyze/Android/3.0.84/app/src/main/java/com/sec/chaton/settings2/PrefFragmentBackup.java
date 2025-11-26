package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.localbackup.ActivitySecretKey;
import com.sec.chaton.localbackup.C1658q;
import com.sec.chaton.localbackup.EnumC1660s;
import com.sec.chaton.localbackup.EnumC1661t;
import com.sec.chaton.localbackup.noti.C1653a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3225cm;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(11)
/* loaded from: classes.dex */
public class PrefFragmentBackup extends BasePreferenceFragment {
    private static final int REQ_PASSWORD = 0;
    private static final String TAG = PrefFragmentBackup.class.getSimpleName();
    private boolean isAlive;
    private boolean isAutoBackup;
    private PreferenceActivity mActivity;
    private Context mContext;
    private FileEncryptionTask mFileEncryptionTask;
    private Dialog mProgressDialog;
    private Dialog mSDcardDialog;
    private CheckBoxPreference prefAutoBackup;
    private Preference prefBackupNow;
    private Preference prefsettingBackup;
    private C3160ab sharedPref = null;

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        this.mActivity = (PreferenceActivity) getActivity();
        C3225cm.m11337a(this.mActivity);
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.setting_localbackup);
        this.sharedPref = C3159aa.m10962a();
        this.sharedPref.m10983b("Lock Check", (Boolean) false);
        this.mContext = this.mActivity;
        this.isAlive = true;
        try {
            initializeForPreference();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        if (this.mFileEncryptionTask != null) {
            this.mFileEncryptionTask.cancel(true);
            C3641ai.m13210a(this.mContext, R.string.backup_failed, 1).show();
        }
        this.isAlive = false;
        super.onDestroy();
    }

    private void setTitleTextWitColor(String str, Preference preference, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 0);
        preference.setTitle(spannableString);
    }

    private void initializeForPreference() {
        this.prefAutoBackup = (CheckBoxPreference) findPreference("pref_auto_backup");
        this.prefAutoBackup.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentBackup.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = obj + "";
                if (obj == null || !str.equals("true")) {
                    PrefFragmentBackup.this.sharedPref.m10983b("auto_backup_on", (Boolean) false);
                    C1653a.m6925a(PrefFragmentBackup.this.mContext);
                    PrefFragmentBackup.this.isAutoBackup = false;
                } else {
                    if (!C3223ck.m11327a()) {
                        PrefFragmentBackup.this.showSDcarDialog();
                        return false;
                    }
                    PrefFragmentBackup.this.sharedPref.m10983b("auto_backup_on", (Boolean) true);
                    PrefFragmentBackup.this.isAutoBackup = true;
                    PrefFragmentBackup.this.asyncFileEncryptionTask();
                    C1653a.m6926a(PrefFragmentBackup.this.mContext, true);
                }
                return true;
            }
        });
        this.prefBackupNow = findPreference("pref_backup_now");
        this.prefBackupNow.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentBackup.2
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                if (!C3223ck.m11327a()) {
                    PrefFragmentBackup.this.showSDcarDialog();
                } else {
                    PrefFragmentBackup.this.asyncFileEncryptionTask();
                }
                return false;
            }
        });
        this.prefsettingBackup = findPreference("pref_setting_backup");
        this.prefsettingBackup.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentBackup.3
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(PrefFragmentBackup.this.mContext, (Class<?>) ActivitySecretKey.class);
                intent.putExtra("password_mode", true);
                PrefFragmentBackup.this.startActivityForResult(intent, 0);
                return false;
            }
        });
        findPreference("pref_view_backedup").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentBackup.4
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                PrefFragmentBackup.this.mActivity.startPreferencePanel(PrefBackupListView.class.getName(), new Bundle(), 0, PrefFragmentBackup.this.mActivity.getString(R.string.settings_type), null, 0);
                return false;
            }
        });
        if (this.sharedPref.m10977a("auto_backup_on", (Boolean) false).booleanValue()) {
            this.prefAutoBackup.setEnabled(true);
            this.prefAutoBackup.setChecked(true);
            this.prefBackupNow.setEnabled(true);
            if (C3159aa.m10962a().m10978a("Theme", (Integer) 0).intValue() == 1) {
                setTitleTextWitColor(getString(R.string.auto_backup), this.prefAutoBackup, getResources().getColor(R.color.buddy_list_sub_title_text));
                setTitleTextWitColor(getString(R.string.backup_now), this.prefBackupNow, getResources().getColor(R.color.buddy_list_sub_title_text));
            } else {
                setTitleTextWitColor(getString(R.string.auto_backup), this.prefAutoBackup, getResources().getColor(R.color.color2));
                setTitleTextWitColor(getString(R.string.backup_now), this.prefBackupNow, getResources().getColor(R.color.color2));
            }
        }
        if (!this.sharedPref.m10977a("setting_backup_enable", (Boolean) false).booleanValue()) {
            settingCheck(false, true);
        } else {
            this.prefsettingBackup.setSummary(this.mContext.getResources().getString(R.string.setup_change_description));
        }
        this.prefAutoBackup.setSummary(String.format(this.mContext.getString(R.string.auto_backup_description_am), 1));
        setLastmodified();
    }

    public void setLastmodified() {
        if (this.isAlive && this.prefBackupNow != null) {
            this.prefBackupNow.setSummary(this.mContext.getResources().getString(R.string.last_backup) + " : " + C3159aa.m10962a().m10979a("backup_last_modified", ""));
        }
    }

    public void settingCheck(boolean z, boolean z2) {
        if (z) {
            Intent intent = new Intent(this.mContext, (Class<?>) ActivitySecretKey.class);
            intent.putExtra("password_mode", true);
            startActivityForResult(intent, 0);
            return;
        }
        this.sharedPref.m10983b("setting_backup_enable", (Boolean) false);
        this.prefAutoBackup.setEnabled(false);
        this.prefAutoBackup.setChecked(false);
        setTitleTextWitColor(getString(R.string.auto_backup), this.prefAutoBackup, getResources().getColor(R.color.setting_explain_text));
        this.sharedPref.m10983b("auto_backup_on", (Boolean) false);
        this.prefBackupNow.setEnabled(false);
        setTitleTextWitColor(getString(R.string.backup_now), this.prefBackupNow, getResources().getColor(R.color.setting_explain_text));
        if (!z2) {
            C1653a.m6925a(this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSDcarDialog() {
        if (this.mSDcardDialog == null) {
            this.mSDcardDialog = AbstractC3271a.m11494a(this.mContext).mo11495a(R.string.backup).mo11506b(R.string.unable_backup_sdcard).mo11515d(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentBackup.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).mo11505a().mo11517a();
            this.mSDcardDialog.setCancelable(false);
        }
        if (this.mSDcardDialog != null) {
            this.mSDcardDialog.show();
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    this.sharedPref.m10983b("setting_backup_enable", (Boolean) true);
                    this.prefAutoBackup.setEnabled(true);
                    this.prefBackupNow.setEnabled(true);
                    if (C3159aa.m10962a().m10978a("Theme", (Integer) 0).intValue() == 1) {
                        setTitleTextWitColor(getString(R.string.auto_backup), this.prefAutoBackup, getResources().getColor(R.color.buddy_list_sub_title_text));
                        setTitleTextWitColor(getString(R.string.backup_now), this.prefBackupNow, getResources().getColor(R.color.buddy_list_sub_title_text));
                    } else {
                        setTitleTextWitColor(getString(R.string.auto_backup), this.prefAutoBackup, getResources().getColor(R.color.color2));
                        setTitleTextWitColor(getString(R.string.backup_now), this.prefBackupNow, getResources().getColor(R.color.color2));
                    }
                    this.prefsettingBackup.setSummary(this.mContext.getResources().getString(R.string.setup_change_description));
                    C3641ai.m13210a(this.mContext, R.string.password_set_notice, 1).show();
                    break;
                } else if (i2 == 0) {
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new C3263j(this.mContext).m11487a(R.string.setting_webview_please_wait);
            this.mProgressDialog.setCancelable(false);
        }
        if (this.mProgressDialog != null) {
            this.mProgressDialog.show();
        }
    }

    class FileEncryptionTask extends AsyncTask<Void, Void, Boolean> {
        C1658q encryptionBackupFile;

        private FileEncryptionTask() {
            this.encryptionBackupFile = new C1658q();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            PrefFragmentBackup.this.showProgressDialog();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voidArr) {
            try {
                this.encryptionBackupFile.m6942a(EnumC1661t.FILE_ENCRYPT, this.encryptionBackupFile.m6938a(EnumC1660s.DECRYPT, (String) null), this.encryptionBackupFile.m6940a("local-backup.db.crypt"));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                C3250y.m11443a(e, PrefFragmentBackup.TAG);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((FileEncryptionTask) bool);
            if (PrefFragmentBackup.this.isAlive) {
                if (PrefFragmentBackup.this.mProgressDialog != null) {
                    PrefFragmentBackup.this.mProgressDialog.dismiss();
                }
                if (!bool.booleanValue()) {
                    C3641ai.m13210a(PrefFragmentBackup.this.mContext, R.string.backup_failed, 1).show();
                } else {
                    C3250y.m11450b("[File encryption] complete " + this, getClass().getSimpleName());
                    PrefFragmentBackup.this.setLastmodified();
                    if (PrefFragmentBackup.this.isAutoBackup) {
                        C3641ai.m13210a(PrefFragmentBackup.this.mContext, R.string.auto_backup_enabled, 1).show();
                        PrefFragmentBackup.this.isAutoBackup = false;
                    } else {
                        C3641ai.m13210a(PrefFragmentBackup.this.mContext, R.string.backup_completed, 1).show();
                    }
                }
                PrefFragmentBackup.this.mFileEncryptionTask = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncFileEncryptionTask() {
        this.mFileEncryptionTask = new FileEncryptionTask();
        C3250y.m11450b("[File encryption] start " + this, getClass().getSimpleName());
        if (Build.VERSION.SDK_INT < 11) {
            this.mFileEncryptionTask.execute(new Void[0]);
        } else {
            this.mFileEncryptionTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }
}
