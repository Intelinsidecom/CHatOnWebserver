package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SyncInfo;
import android.content.SyncStatusObserver;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class PrefFragmentContactSync extends BasePreferenceFragment implements View.OnClickListener {
    private View autoContactsDescription;
    private boolean isAutoSync;
    private boolean isSync;
    private RelativeLayout layoutAutoContacts;
    private RelativeLayout layoutManualSync;
    private RelativeLayout layoutSimContacts;
    private Object mStatusChangeListenerHandle;
    private TextView manualSyncDesc;
    private ImageView manualSyncView;
    private View simContactsDescription;
    private CheckBox syncAutoChkBox;
    private CheckBox syncChkBox;
    private boolean mIsActive = false;
    private C3160ab sharedPref = null;
    private boolean isContactSynced = false;
    private final Handler mHandler = new Handler();
    private Runnable mRunnableSyncStateUpdated = new Runnable() { // from class: com.sec.chaton.settings2.PrefFragmentContactSync.4
        @Override // java.lang.Runnable
        public void run() {
            PrefFragmentContactSync.this.onSyncStateUpdated();
        }
    };
    private SyncStatusObserver mSyncStatusObserver = new SyncStatusObserver() { // from class: com.sec.chaton.settings2.PrefFragmentContactSync.5
        @Override // android.content.SyncStatusObserver
        public void onStatusChanged(int i) {
            PrefFragmentContactSync.this.mHandler.post(PrefFragmentContactSync.this.mRunnableSyncStateUpdated);
        }
    };

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        this.sharedPref = C3159aa.m10962a();
        if (this.sharedPref.m10977a("contact_sim_sync", (Boolean) false).booleanValue()) {
            this.isSync = true;
            this.sharedPref.m10983b("contact_sim_sync", (Boolean) true);
        } else {
            this.isSync = false;
            this.sharedPref.m10983b("contact_sim_sync", (Boolean) false);
        }
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_contact_sync, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) viewGroup.getParent();
        if (Build.VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(null);
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        linearLayout.setBackgroundColor(0);
        linearLayout.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 17) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(0);
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
            }
        }
        View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.breadcrumb1);
        textView.setText(R.string.buddy_contact_sync);
        textView.setTextColor(getActivity().getResources().getColor(R.color.buddy_list_item_status_changed));
        ((TextView) viewFindViewById.findViewById(R.id.breadcrumb2)).setVisibility(8);
        ((ImageView) viewFindViewById.findViewById(R.id.separator1)).setVisibility(8);
        ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        if (C1493a.m6463a("support_contact_auto_sync")) {
            this.layoutAutoContacts = (RelativeLayout) viewInflate.findViewById(R.id.layout_setting_auto_contacts);
            this.layoutAutoContacts.setVisibility(0);
            viewInflate.findViewById(R.id.setting_auto_divider).setVisibility(0);
            this.syncAutoChkBox = (CheckBox) viewInflate.findViewById(R.id.setting_auto_contacts);
            this.syncAutoChkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentContactSync.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    PrefFragmentContactSync.this.isAutoSync = z;
                    PrefFragmentContactSync.this.sharedPref.m10983b("auto_contact_sync", Boolean.valueOf(z));
                }
            });
            this.layoutAutoContacts.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentContactSync.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PrefFragmentContactSync.this.isAutoSync = !PrefFragmentContactSync.this.isAutoSync;
                    PrefFragmentContactSync.this.syncAutoChkBox.setChecked(PrefFragmentContactSync.this.isAutoSync);
                }
            });
            this.autoContactsDescription = viewInflate.findViewById(R.id.setting_auto_contacts_description);
            TextView textView2 = (TextView) this.autoContactsDescription.findViewById(R.id.text1);
            TextView textView3 = (TextView) this.autoContactsDescription.findViewById(R.id.text2);
            textView2.setText(R.string.contact_auto_sync);
            textView3.setText("");
        }
        this.layoutSimContacts = (RelativeLayout) viewInflate.findViewById(R.id.layout_setting_sim_contacts);
        this.syncChkBox = (CheckBox) viewInflate.findViewById(R.id.setting_sim_contacts);
        this.syncChkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sec.chaton.settings2.PrefFragmentContactSync.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PrefFragmentContactSync.this.isSync = z;
                PrefFragmentContactSync.this.sharedPref.m10983b("contact_sim_sync", Boolean.valueOf(z));
            }
        });
        this.layoutSimContacts.setOnClickListener(this);
        this.simContactsDescription = viewInflate.findViewById(R.id.setting_sim_contacts_description);
        TextView textView4 = (TextView) this.simContactsDescription.findViewById(R.id.text1);
        TextView textView5 = (TextView) this.simContactsDescription.findViewById(R.id.text2);
        textView4.setText(R.string.sync_sim_contact);
        textView5.setText(R.string.sync_sim_contact);
        this.layoutManualSync = (RelativeLayout) viewInflate.findViewById(R.id.layout_setting_manual_sync);
        this.layoutManualSync.setOnClickListener(this);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.setting_manual_title);
        this.manualSyncDesc = (TextView) viewInflate.findViewById(R.id.setting_manual_desc);
        if (C1493a.m6463a("support_contact_auto_sync")) {
            textView6.setText(R.string.contact_manual_sync);
            this.manualSyncDesc.setText(setSummaryLatestSyncTime());
        } else {
            textView6.setText(R.string.buddy_contact_sync);
            this.manualSyncDesc.setText(setLatestContactSyncTime());
        }
        this.manualSyncView = (ImageView) viewInflate.findViewById(R.id.setting_manual_sync);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.isContactSynced = !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""));
        this.syncChkBox.setChecked(this.isSync);
        if (this.syncAutoChkBox != null) {
            this.syncAutoChkBox.setChecked(this.isAutoSync);
        }
        startSyncObserver();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        stopSyncObserver();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_setting_sim_contacts /* 2131166222 */:
            case R.id.setting_sim_contacts /* 2131166223 */:
                this.isSync = this.isSync ? false : true;
                this.syncChkBox.setChecked(this.isSync);
                break;
            case R.id.layout_setting_manual_sync /* 2131166225 */:
                int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
                if (-3 == iM6733a || -2 == iM6733a) {
                    C3641ai.m13210a(getActivity(), R.string.trunk_network_not_available, 0).show();
                    break;
                } else if (this.isContactSynced) {
                    C0423i.m3039a(true);
                    break;
                } else {
                    Intent intent = new Intent(getActivity(), (Class<?>) ActivityRegist.class);
                    intent.putExtra("ACTIVITY_PURPOSE_CALL_CONTACT_SYNC", "ACTIVITY_PURPOSE_CALL_CONTACT_SYNC");
                    startActivity(intent);
                    break;
                }
                break;
        }
    }

    public void startSyncObserver() {
        stopSyncObserver();
        this.mStatusChangeListenerHandle = ContentResolver.addStatusChangeListener(7, this.mSyncStatusObserver);
        onSyncStateUpdated();
    }

    public void stopSyncObserver() {
        if (this.mStatusChangeListenerHandle != null) {
            this.mHandler.removeCallbacks(this.mRunnableSyncStateUpdated);
            ContentResolver.removeStatusChangeListener(this.mStatusChangeListenerHandle);
            this.mStatusChangeListenerHandle = null;
        }
    }

    private boolean isSyncing() {
        SyncInfo currentSync = ContentResolver.getCurrentSync();
        return (currentSync == null || currentSync.account == null || !"com.sec.chaton".equals(currentSync.account.type)) ? false : true;
    }

    @TargetApi(11)
    private boolean isSyncingOverHoneyComb() {
        List<SyncInfo> currentSyncs = ContentResolver.getCurrentSyncs();
        if (currentSyncs == null || currentSyncs.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < currentSyncs.size(); i++) {
            if (currentSyncs.get(i).account != null && "com.sec.chaton".equals(currentSyncs.get(i).account.type)) {
                z = true;
            }
            C3250y.m11450b("isSyncing return value = " + z, "SyncStatePreference");
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSyncStateUpdated() {
        boolean zIsSyncing;
        if (Build.VERSION.SDK_INT >= 11) {
            zIsSyncing = isSyncingOverHoneyComb();
        } else {
            zIsSyncing = isSyncing();
        }
        C3250y.m11450b("onSyncStateUpdated " + zIsSyncing, "SyncStatePreference");
        setActive(zIsSyncing);
    }

    private void setActive(boolean z) {
        if (this.mIsActive != z) {
            this.mIsActive = z;
            if (z) {
                final AnimationDrawable animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.icon_sync_on);
                this.manualSyncView.setImageDrawable(animationDrawable);
                this.manualSyncView.post(new Runnable() { // from class: com.sec.chaton.settings2.PrefFragmentContactSync.6
                    @Override // java.lang.Runnable
                    public void run() {
                        animationDrawable.start();
                    }
                });
            } else {
                this.manualSyncView.setImageResource(R.drawable.ic_sync_01);
                if (C1493a.m6463a("support_contact_auto_sync")) {
                    this.manualSyncDesc.setText(setSummaryLatestSyncTime());
                } else {
                    this.manualSyncDesc.setText(setLatestContactSyncTime());
                }
            }
        }
    }

    private String setSummaryLatestSyncTime() {
        StringBuilder sb = new StringBuilder();
        long jLongValue = Long.valueOf(C3159aa.m10962a().m10979a("Setting Sync TimeInMillis", "0")).longValue();
        if (jLongValue == 0) {
            sb.append(getResources().getString(R.string.settings_sync_contacts_not_synced_yet));
        } else {
            sb.append(getResources().getString(R.string.setting_contact_latest_sync) + ": ").append(DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(jLongValue))).append(" ").append(DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(jLongValue)));
        }
        return sb.toString();
    }

    private String setLatestContactSyncTime() {
        long jLongValue = Long.valueOf(C3159aa.m10962a().m10979a("Setting Sync TimeInMillis", "0")).longValue();
        if (TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
            return getResources().getString(R.string.setting_sync_now_text);
        }
        if (jLongValue == 0) {
            return getResources().getString(R.string.setting_sync_now_text) + "\n" + getResources().getString(R.string.settings_sync_contacts_not_synced_yet);
        }
        return getResources().getString(R.string.setting_sync_now_text) + "\n" + getResources().getString(R.string.setting_contact_latest_sync) + ": " + DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(jLongValue)) + " " + DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(jLongValue));
    }
}
