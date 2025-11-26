package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.localbackup.ActivityBackupList;
import com.sec.chaton.localbackup.BackupListView;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;

@TargetApi(11)
/* loaded from: classes.dex */
public class PrefFragmentBackupList extends BasePreferenceFragment {
    private static final String TAG = ActivityBackupList.class.getSimpleName();
    private Activity mActivity;
    private BackupListView mBackupListView;
    private BroadcastReceiver mExternalStorageReceiver;
    private OnBackKeyListener mListener;

    public interface OnBackKeyListener {
        boolean switchViewMode();
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = getActivity();
        if (bundle != null) {
        }
    }

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBackupListView = new BackupListView();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        startWatchingExternalStorage();
        super.onResume();
    }

    private void startWatchingExternalStorage() {
        this.mExternalStorageReceiver = new BroadcastReceiver() { // from class: com.sec.chaton.settings2.PrefFragmentBackupList.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                C3250y.m11450b("onReceive : " + intent.getAction(), PrefFragmentBackupList.TAG);
                PrefFragmentBackupList.this.handleExternalStorageState();
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.mActivity.registerReceiver(this.mExternalStorageReceiver, intentFilter);
        handleExternalStorageState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExternalStorageState() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.mActivity, R.string.sdcard_not_found, 0).show();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        stopWatchingExternalStorage();
    }

    private void stopWatchingExternalStorage() {
        this.mActivity.unregisterReceiver(this.mExternalStorageReceiver);
    }
}
