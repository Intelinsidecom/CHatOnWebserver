package com.sec.chaton.settings2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.p035io.entry.inner.BuddyMappingInfo;
import com.sec.chaton.p035io.entry.inner.MappingInfoEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.registration.ActivitySyncSignInPopup;
import com.sec.chaton.settings.ActivityMultiDeviceView;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import java.util.ArrayList;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class PrefFragmentConnectedDevice extends BasePreferenceFragment {
    private LinearLayout deviceList;
    private Activity mActivity;
    private Context mContext;
    private ArrayList<MappingInfoEntry> mMappingInfo;
    private C1345w mProfileControl;
    private C1307at mSAControl;
    private TextView myAccountInfo;
    private String TAG = ActivityMultiDeviceView.class.getSimpleName();
    private final int MAPPING_RESULT = 0;
    private MultiDeviceAdapter deviceAdapter = null;
    private ProgressDialog progressBar = null;
    private String webURL = "";
    Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.sec.chaton.settings2.PrefFragmentConnectedDevice.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0267d c0267d = (C0267d) message.obj;
            switch (message.what) {
                case HttpResponseCode.TOO_LONG /* 413 */:
                    if (PrefFragmentConnectedDevice.this.progressBar != null && PrefFragmentConnectedDevice.this.progressBar.isShowing()) {
                        PrefFragmentConnectedDevice.this.progressBar.dismiss();
                    }
                    if (c0267d != null && c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        BuddyMappingInfo buddyMappingInfo = (BuddyMappingInfo) c0267d.m1354e();
                        if (buddyMappingInfo == null || !buddyMappingInfo.mapping.booleanValue()) {
                            Toast.makeText(PrefFragmentConnectedDevice.this.mContext, R.string.toast_network_unable, 0).show();
                            break;
                        } else {
                            PrefFragmentConnectedDevice.this.mMappingInfo = buddyMappingInfo.MappingInfo;
                            PrefFragmentConnectedDevice.this.webURL = buddyMappingInfo.url;
                            C3250y.m11450b("webURL : " + PrefFragmentConnectedDevice.this.webURL + " mMappingInfo : " + PrefFragmentConnectedDevice.this.mMappingInfo, getClass().getSimpleName());
                            LayoutInflater layoutInflaterFrom = LayoutInflater.from(PrefFragmentConnectedDevice.this.deviceList.getContext());
                            PrefFragmentConnectedDevice.this.deviceList.removeAllViews();
                            for (int i = 0; i < PrefFragmentConnectedDevice.this.deviceAdapter.getCount(); i++) {
                                PrefFragmentConnectedDevice.this.deviceList.addView(PrefFragmentConnectedDevice.this.deviceAdapter.getView(i, null, PrefFragmentConnectedDevice.this.deviceList));
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                                LinearLayout linearLayout = new LinearLayout(PrefFragmentConnectedDevice.this.deviceList.getContext());
                                linearLayout.setLayoutParams(layoutParams);
                                linearLayout.addView(layoutInflaterFrom.inflate(R.layout.layout_common_divider5, (ViewGroup) null));
                                PrefFragmentConnectedDevice.this.deviceList.addView(linearLayout);
                            }
                            break;
                        }
                    }
                    break;
                case 2007:
                    if (c0267d == null || !c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        if (PrefFragmentConnectedDevice.this.progressBar != null && PrefFragmentConnectedDevice.this.progressBar.isShowing()) {
                            PrefFragmentConnectedDevice.this.progressBar.dismiss();
                        }
                        Toast.makeText(PrefFragmentConnectedDevice.this.mContext, R.string.toast_network_unable, 0).show();
                        break;
                    } else {
                        PrefFragmentConnectedDevice.this.mProfileControl.m5942f("");
                        Toast.makeText(PrefFragmentConnectedDevice.this.mContext, R.string.toast_account_deleted2, 0).show();
                        break;
                    }
                    break;
            }
        }
    };

    @Override // com.sec.chaton.settings2.BasePreferenceFragment, android.preference.PreferenceFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_multidevice, viewGroup, false);
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
        textView.setText(R.string.account_connected_device);
        textView.setTextColor(getActivity().getResources().getColor(R.color.buddy_list_item_status_changed));
        ((TextView) viewFindViewById.findViewById(R.id.breadcrumb2)).setVisibility(8);
        ((ImageView) viewFindViewById.findViewById(R.id.separator1)).setVisibility(8);
        ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        ((TextView) viewInflate.findViewById(R.id.text1)).setText(getResources().getString(R.string.setting_samsung_account));
        this.myAccountInfo = (TextView) viewInflate.findViewById(R.id.text2);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.layout_header);
        ((TextView) linearLayout2.findViewById(R.id.text1)).setText(getResources().getString(R.string.account_connected_device));
        linearLayout2.setClickable(false);
        this.deviceList = (LinearLayout) viewInflate.findViewById(R.id.device_list);
        this.mContext = this.mActivity;
        this.deviceAdapter = new MultiDeviceAdapter();
        this.mProfileControl = new C1345w(this.mHandler);
        this.mSAControl = new C1307at(this.mHandler);
        if (C3171am.m11080r()) {
            this.myAccountInfo.setText(C3171am.m11079q());
            if (bundle == null) {
                this.progressBar = ProgressDialogC3265l.m11489a(this.mContext, null, getResources().getString(R.string.dialog_provision_ing));
            }
            this.mProfileControl.m5942f("");
        } else {
            Intent intent = new Intent(this.mContext, (Class<?>) ActivitySyncSignInPopup.class);
            intent.setFlags(67108864);
            intent.putExtra("isSyncContacts", true);
            startActivityForResult(intent, 0);
        }
        setHasOptionsMenu(true);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mActivity = null;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
                if (i2 != -1) {
                    C3250y.m11450b("mapping was FAILED", getClass().getSimpleName());
                    break;
                } else {
                    this.myAccountInfo.setText(C3171am.m11079q());
                    this.progressBar = ProgressDialogC3265l.m11489a(this.mContext, null, getResources().getString(R.string.dialog_provision_ing));
                    this.mProfileControl.m5942f("");
                    break;
                }
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        C3250y.m11453c("[LIFE] onStart, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11453c("[LIFE] onResume, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        C3250y.m11453c("[LIFE] onPause, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onStop() {
        super.onStop();
        C3250y.m11453c("[LIFE] onStop, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C3250y.m11453c("[LIFE] onDestroy, isTaskRoot: " + this.mActivity.isTaskRoot() + ", Task ID: " + this.mActivity.getTaskId() + ", Memory Address:" + this, this.TAG);
    }

    public class MultiDeviceAdapter extends BaseAdapter {
        private boolean currentDevice;
        private Button[] mButton;
        private TextView mCode;
        private LayoutInflater mInflater;
        private TextView mText;
        private String number;

        public MultiDeviceAdapter() {
            this.mInflater = LayoutInflater.from(PrefFragmentConnectedDevice.this.mContext);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return PrefFragmentConnectedDevice.this.mMappingInfo.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return PrefFragmentConnectedDevice.this.mMappingInfo.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            this.currentDevice = false;
            if (view == null) {
                view = this.mInflater.inflate(R.layout.list_item_common_4, viewGroup, false);
            }
            view.setPadding(0, view.getPaddingTop(), 0, view.getPaddingBottom());
            this.mButton = new Button[getCount()];
            this.mText = (TextView) view.findViewById(R.id.text1);
            this.mCode = (TextView) view.findViewById(R.id.text2);
            this.mButton[i] = (Button) view.findViewById(R.id.button1);
            this.mButton[i].setVisibility(0);
            this.mButton[i].setText(R.string.connected_device_deregister);
            if (PrefFragmentConnectedDevice.this.mMappingInfo != null && PrefFragmentConnectedDevice.this.mMappingInfo.size() > 0) {
                if (((MappingInfoEntry) PrefFragmentConnectedDevice.this.mMappingInfo.get(i)).isAsker != null) {
                    this.currentDevice = ((MappingInfoEntry) PrefFragmentConnectedDevice.this.mMappingInfo.get(i)).isAsker.booleanValue();
                }
                String str = ((MappingInfoEntry) PrefFragmentConnectedDevice.this.mMappingInfo.get(i)).model;
                this.mText.setText(str);
                this.number = ((MappingInfoEntry) PrefFragmentConnectedDevice.this.mMappingInfo.get(i)).phoneNumber;
                if (str != null && str.contains("web")) {
                    this.mCode.setText(PrefFragmentConnectedDevice.this.webURL);
                    this.mButton[i].setVisibility(8);
                } else if (!TextUtils.isEmpty(this.number)) {
                    if (!this.currentDevice) {
                        this.mCode.setText(((MappingInfoEntry) PrefFragmentConnectedDevice.this.mMappingInfo.get(i)).phoneNumber);
                    } else {
                        this.mCode.setSingleLine(false);
                        this.mCode.setText(((MappingInfoEntry) PrefFragmentConnectedDevice.this.mMappingInfo.get(i)).phoneNumber + "\n" + PrefFragmentConnectedDevice.this.getResources().getString(R.string.regist_setting_current_device));
                    }
                } else if (this.currentDevice) {
                    this.mCode.setText(PrefFragmentConnectedDevice.this.getResources().getString(R.string.regist_setting_current_device));
                }
                if (TextUtils.isEmpty(this.mCode.getText())) {
                    this.mCode.setVisibility(8);
                    this.mText.setGravity(16);
                }
                final String str2 = ((MappingInfoEntry) PrefFragmentConnectedDevice.this.mMappingInfo.get(i)).chatonid;
                this.mButton[i].setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentConnectedDevice.MultiDeviceAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AbstractC3271a.m11494a(PrefFragmentConnectedDevice.this.mContext).mo11495a(R.string.deregister_device).mo11506b(R.string.multideivce_delete_account2).mo11507b(R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentConnectedDevice.MultiDeviceAdapter.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.cancel();
                            }
                        }).mo11515d(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefFragmentConnectedDevice.MultiDeviceAdapter.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                                PrefFragmentConnectedDevice.this.progressBar = ProgressDialogC3265l.m11489a(PrefFragmentConnectedDevice.this.mContext, null, PrefFragmentConnectedDevice.this.getResources().getString(R.string.dialog_provision_ing));
                                PrefFragmentConnectedDevice.this.mSAControl.m5618b(str2);
                            }
                        }).mo11505a().show();
                    }
                });
            }
            return view;
        }
    }
}
