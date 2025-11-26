package com.coolots.chaton.setting.view.datausage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.EditTextNotHover;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.data.ChatONSettingDataInterface;
import com.coolots.chaton.setting.view.datausage.DataUsageInfoManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class SettingDataUsageActivity extends Activity implements DisposeInterface, TextView.OnEditorActionListener {
    private static final String CLASSNAME = "[SettingDataUsageActivity]";
    private static final int DATAUSAGE_CYCLE_RANGE = 3;
    private static final int DIALOG_DATA_USAGE_CYCLE = 1000;
    private static final int MOBILE_LAYOUT = 0;
    static final boolean UPGRADETEST = false;
    private static final int WIFI_LAYOUT = 1;
    private static EditTextNotHover mCycleContentText;
    private ArrayList<String> cycleList;
    private Spinner duCycleSpinner;
    private ChatOnService mChatonservice;
    private int mCurCycleDay;
    private Button mDownCycleBtn;
    Thread mDownCycleThread;
    private Button mMobileBtn;
    private int mSelectedSpinnerPosition;
    private TextView mTotalDataUsage;
    private Button mUpCycleBtn;
    Thread mUpCycleThread;
    private Button mWifiBtn;
    private CheckBox mWifiOnlyCheckBox;
    private TextView mWifiOnlyText;
    private View mWifiOnlylayout;
    private SettingDataUsageFragment mFragment = null;
    private final ChatONSettingDataInterface chatonSetting = ChatONSettingData.getInstance();
    private ArrayAdapter<String> spinnerAdapter = null;
    private Dialog mSetDataUsageCycleDialog = null;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.1
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            SettingDataUsageActivity.this.procSelectedCycleViewItem(SettingDataUsageActivity.this.duCycleSpinner.getSelectedItemPosition());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    };
    Handler mHandler = new Handler();
    Object mCycleMutex = new Object();

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upCycleDay() {
        int cycleDay = this.mCurCycleDay + 1;
        if (cycleDay > 31) {
            cycleDay = 1;
        }
        setCycleDay(cycleDay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downCycleDay() {
        int cycleDay = this.mCurCycleDay - 1;
        if (cycleDay < 1) {
            cycleDay = 31;
        }
        setCycleDay(cycleDay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCycleDay(int Day) {
        this.mCurCycleDay = Day;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUsedWifiTab() {
        if (!this.mWifiOnlyCheckBox.isChecked() && !this.chatonSetting.isUseWifiOnly()) {
            return false;
        }
        return true;
    }

    private String getDayStr(int day) {
        if (getResources().getConfiguration().locale.equals(Locale.KOREAN) || getResources().getConfiguration().locale.equals(Locale.KOREA)) {
            String display = Integer.toString(day);
            return display;
        }
        if (getResources().getConfiguration().locale.equals(Locale.CHINESE) || getResources().getConfiguration().locale.equals(Locale.CHINA) || getResources().getConfiguration().locale.equals(Locale.TAIWAN) || getResources().getConfiguration().locale.equals(Locale.JAPAN) || getResources().getConfiguration().locale.equals(Locale.JAPANESE) || getResources().getConfiguration().locale.equals(Locale.TRADITIONAL_CHINESE)) {
            String display2 = String.valueOf(day) + "日";
            return display2;
        }
        String display3 = Integer.toString(day);
        return display3;
    }

    private String getMonStr(int mon) {
        String display;
        if (getResources().getConfiguration().locale.equals(Locale.KOREAN) || getResources().getConfiguration().locale.equals(Locale.KOREA)) {
            display = String.valueOf(mon + 1) + "/";
        } else {
            Calendar cal = Calendar.getInstance();
            cal.clear();
            cal.add(2, mon);
            display = cal.getDisplayName(2, 1, getResources().getConfiguration().locale);
        }
        if (getResources().getConfiguration().locale.toString().equals("vi_VN") || getResources().getConfiguration().locale.equals(new Locale("vi"))) {
            logI("locale vietnam~! getMonStr : " + display + " mon :" + mon);
            return display.replace(" ", "");
        }
        return display;
    }

    private String makeCycleStr(String startMon, String startDay, String endMon, String endDay) {
        Locale locale = getResources().getConfiguration().locale;
        return (locale.equals(Locale.KOREAN) || locale.equals(Locale.KOREA) || locale.equals(Locale.CHINESE) || locale.equals(Locale.CHINA) || getResources().getConfiguration().locale.equals(Locale.JAPAN) || locale.equals(Locale.TAIWAN) || locale.equals(Locale.TRADITIONAL_CHINESE)) ? String.valueOf(startMon) + startDay + "-" + endMon + endDay : String.valueOf(startDay) + startMon + "-" + endDay + endMon;
    }

    private void makeCycleList() {
        if (this.cycleList == null) {
            this.cycleList = new ArrayList<>();
        }
        this.cycleList.clear();
        for (int monthIdx = 0; monthIdx < 3; monthIdx++) {
            int diffMoth = -monthIdx;
            DataUsageInfoManager.CycleTimeData cycleTimeData = DataUsageInfoManager.getCycleTimeData(diffMoth);
            if (cycleTimeData != null) {
                String cycleStr = getCycleStr(cycleTimeData);
                this.cycleList.add(cycleStr);
            } else {
                return;
            }
        }
        this.cycleList.add(getString(C0000R.string.datausage_change_cycle));
    }

    private String getCycleStr(DataUsageInfoManager.CycleTimeData cycleTimeData) {
        String startMonth = getMonStr(cycleTimeData.startMon);
        String startDay = getDayStr(cycleTimeData.startDay);
        String endMonth = getMonStr(cycleTimeData.endMon);
        String endDay = getDayStr(cycleTimeData.endDay);
        return makeCycleStr(startMonth, startDay, endMonth, endDay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDataUsageCycleView() {
        setCycleDay(this.chatonSetting.getCycleDayPref());
        makeCycleList();
        if (this.spinnerAdapter != null) {
            this.spinnerAdapter = null;
        }
        this.spinnerAdapter = new ArrayAdapter<>(this, C0000R.layout.setting_data_usage_spinner_item, this.cycleList);
        this.spinnerAdapter.setDropDownViewResource(C0000R.layout.setting_data_usage_spinner_dropdown_item);
        this.duCycleSpinner.setAdapter((SpinnerAdapter) this.spinnerAdapter);
        this.duCycleSpinner.setOnItemSelectedListener(this.mOnItemSelectedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void procSelectedCycleViewItem(int pos) {
        if (pos == this.duCycleSpinner.getAdapter().getCount() - 1) {
            showDialog(1000);
            return;
        }
        DataUsageInfoManager.CycleTimeData cycleTimeData = DataUsageInfoManager.getCycleTimeData(-pos);
        getFragment().setFrgmentPeoriod(cycleTimeData);
        getFragment().updateAllData(null);
        this.mSelectedSpinnerPosition = pos;
    }

    private void initFragment() {
        if (this.mFragment != null) {
            this.mFragment = null;
        }
    }

    private void initActionBar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(C0000R.layout.user_preference_action_bar_title_normal);
            actionBar.setDisplayOptions(16);
            TextView txtTitle = (TextView) findViewById(C0000R.id.user_preference_tab_title_name);
            txtTitle.setText(getString(C0000R.string.preference_data_network_usage));
            View btnBack = findViewById(C0000R.id.action_back);
            btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    SettingDataUsageActivity.this.finish();
                }
            });
            if (this.mChatonservice.getBackgroundThema() == 1) {
                actionBar.getCustomView().setBackgroundResource(C0000R.color.tw_light_color001);
                txtTitle.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
            }
        }
    }

    public void initActivity() {
        this.mWifiOnlyText = (TextView) findViewById(C0000R.id.top_text);
        this.mWifiOnlylayout = findViewById(C0000R.id.wifi_only_layout);
        this.mWifiOnlylayout.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                SettingDataUsageActivity.this.chatonSetting.setUseWifiOnly(!SettingDataUsageActivity.this.chatonSetting.isUseWifiOnly());
                SettingDataUsageActivity.this.updateCheckWifiData();
                if (SettingDataUsageActivity.this.isUsedWifiTab()) {
                    SettingDataUsageActivity.this.setVisibilityLayout(1);
                } else {
                    SettingDataUsageActivity.this.setVisibilityLayout(0);
                }
                SettingDataUsageActivity.this.getFragment().setIsWifi(SettingDataUsageActivity.this.isUsedWifiTab());
                SettingDataUsageActivity.this.getFragment().updateAllData(null);
            }
        });
        this.mWifiOnlyCheckBox = (CheckBox) findViewById(C0000R.id.wifi_only_checkbox);
        this.mMobileBtn = (Button) findViewById(C0000R.id.mobile_state_btn);
        this.mMobileBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingDataUsageActivity.this.setVisibilityLayout(0);
                SettingDataUsageActivity.this.getFragment().setIsWifi(false);
                SettingDataUsageActivity.this.getFragment().updateAllData(null);
            }
        });
        this.mWifiBtn = (Button) findViewById(C0000R.id.wifi_state_btn);
        this.mWifiBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingDataUsageActivity.this.setVisibilityLayout(1);
                SettingDataUsageActivity.this.getFragment().setIsWifi(true);
                SettingDataUsageActivity.this.getFragment().updateAllData(null);
            }
        });
        this.mTotalDataUsage = (TextView) findViewById(C0000R.id.total_data_usage);
        if (isUsedWifiTab()) {
            setVisibilityLayout(1);
        } else {
            setVisibilityLayout(0);
        }
        this.duCycleSpinner = (Spinner) findViewById(C0000R.id.data_usage_cycle_spinner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibilityLayout(int layout) {
        long kbyteNum = MainApplication.mPhoneManager.getDataUsageManager().getTotalDU() / 1024;
        String totalDataUsageValue = String.valueOf(getString(C0000R.string.preference_6_2_summary, new Object[]{Long.toString(kbyteNum)})) + " Kbytes";
        this.mTotalDataUsage.setText(totalDataUsageValue);
        switch (layout) {
            case 0:
                this.mMobileBtn.setSelected(true);
                this.mMobileBtn.setEnabled(false);
                this.mWifiBtn.setSelected(false);
                this.mWifiBtn.setEnabled(true);
                break;
            case 1:
                this.mMobileBtn.setSelected(false);
                this.mMobileBtn.setEnabled(true);
                this.mWifiBtn.setSelected(true);
                this.mWifiBtn.setEnabled(false);
                break;
            default:
                this.mMobileBtn.setSelected(true);
                this.mMobileBtn.setEnabled(false);
                this.mWifiBtn.setSelected(false);
                this.mWifiBtn.setEnabled(true);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckWifiData() {
        if (this.chatonSetting.isUseWifiOnly()) {
            this.mWifiOnlyCheckBox.setChecked(true);
        } else {
            this.mWifiOnlyCheckBox.setChecked(false);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (this.mChatonservice.getBackgroundThema() == 1) {
            setContentView(C0000R.layout.data_usage_black);
        } else {
            setContentView(C0000R.layout.data_usage);
        }
        super.onCreate(savedInstanceState);
        initActionBar();
        initActivity();
        initDataUsageCycleView();
        initFragment();
        getFragment().setIsWifi(isUsedWifiTab());
        getFragmentManager().beginTransaction().replace(C0000R.id.data_usage_fragment, getFragment()).commit();
    }

    @Override // android.app.Activity
    protected void onResume() {
        setTitle("");
        updateCheckWifiData();
        checkEntitlementWifiOnlyMode();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SettingDataUsageFragment getFragment() {
        if (this.mFragment == null) {
            this.mFragment = new SettingDataUsageFragment();
        }
        return this.mFragment;
    }

    void setCycleContetTextAndCursorMoveToLast() {
        mCycleContentText.setText(Integer.toString(this.mCurCycleDay));
        mCycleContentText.setSelection(mCycleContentText.getText().length(), mCycleContentText.getText().length());
    }

    public class CycleInputFilter implements InputFilter {
        protected int mMaxByte;

        public CycleInputFilter(int maxbyte) {
            this.mMaxByte = maxbyte;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) throws NumberFormatException {
            String expected = String.valueOf(String.valueOf(String.valueOf(new String()) + ((Object) dest.subSequence(0, dstart))) + ((Object) source.subSequence(start, end))) + ((Object) dest.subSequence(dend, dest.length()));
            if (expected.equals("0") || expected.equals("00")) {
                SettingDataUsageActivity.mCycleContentText.setText("");
                return null;
            }
            if (expected.length() > this.mMaxByte) {
                return "";
            }
            if (expected.equals("")) {
                return null;
            }
            if (expected.length() > 0) {
                expected = expected.replace(" ", "");
            }
            try {
                int day = Integer.parseInt(expected);
                if (day < 1) {
                    SettingDataUsageActivity.this.setCycleDay(Integer.parseInt(expected));
                    return null;
                }
                if (day <= 31) {
                    SettingDataUsageActivity.this.setCycleDay(Integer.parseInt(expected));
                    return null;
                }
                return "";
            } catch (NumberFormatException e) {
                return "";
            }
        }
    }

    class UpCycleThread implements Runnable {
        UpCycleThread() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(200L);
                    SettingDataUsageActivity.this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.UpCycleThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (SettingDataUsageActivity.this.mCycleMutex) {
                                SettingDataUsageActivity.this.upCycleDay();
                                SettingDataUsageActivity.this.setCycleContetTextAndCursorMoveToLast();
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    class DownCycleThread implements Runnable {
        DownCycleThread() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(200L);
                    SettingDataUsageActivity.this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.DownCycleThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (SettingDataUsageActivity.this.mCycleMutex) {
                                SettingDataUsageActivity.this.downCycleDay();
                                SettingDataUsageActivity.this.setCycleContetTextAndCursorMoveToLast();
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopUpCycleThread() {
        if (this.mUpCycleThread != null && !this.mUpCycleThread.isInterrupted()) {
            this.mUpCycleThread.interrupt();
            this.mUpCycleThread = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopDownCycleThread() {
        if (this.mDownCycleThread != null && !this.mDownCycleThread.isInterrupted()) {
            this.mDownCycleThread.interrupt();
            this.mDownCycleThread = null;
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int id) {
        if (this.mSetDataUsageCycleDialog != null && this.mSetDataUsageCycleDialog.isShowing()) {
            this.mSetDataUsageCycleDialog.dismiss();
        }
        if (id != 1000) {
            return super.onCreateDialog(id);
        }
        LayoutInflater factory = LayoutInflater.from(this);
        ChatONDialog.Builder dialog = new ChatONDialog.Builder(this);
        dialog.setTitle(C0000R.string.datausage_cycle_dialog_title);
        View popupBody = factory.inflate(C0000R.layout.data_usage_cycle_dialog, (ViewGroup) null);
        dialog.setView(popupBody);
        mCycleContentText = (EditTextNotHover) popupBody.findViewById(C0000R.id.datausage_cycle_what_day);
        mCycleContentText.setText(Integer.toString(this.mCurCycleDay));
        mCycleContentText.setBackgroundColor(0);
        mCycleContentText.setOnEditorActionListener(this);
        mCycleContentText.setSelection(mCycleContentText.getText().length(), mCycleContentText.getText().length());
        mCycleContentText.setFilters(new InputFilter[]{new CycleInputFilter(2)});
        this.mUpCycleBtn = (Button) popupBody.findViewById(C0000R.id.datausage_cycle_up_action_btn);
        this.mUpCycleBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingDataUsageActivity.this.upCycleDay();
                SettingDataUsageActivity.this.setCycleContetTextAndCursorMoveToLast();
            }
        });
        this.mUpCycleBtn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SettingDataUsageActivity.this.mUpCycleThread = new Thread(SettingDataUsageActivity.this.new UpCycleThread());
                SettingDataUsageActivity.this.mUpCycleThread.start();
                return false;
            }
        });
        this.mUpCycleBtn.setOnTouchListener(new View.OnTouchListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 1:
                        SettingDataUsageActivity.this.stopUpCycleThread();
                        break;
                }
                return false;
            }
        });
        this.mDownCycleBtn = (Button) popupBody.findViewById(C0000R.id.datausage_cycle_down_action_btn);
        this.mDownCycleBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingDataUsageActivity.this.downCycleDay();
                SettingDataUsageActivity.this.setCycleContetTextAndCursorMoveToLast();
            }
        });
        this.mDownCycleBtn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.10
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SettingDataUsageActivity.this.mDownCycleThread = new Thread(SettingDataUsageActivity.this.new DownCycleThread());
                SettingDataUsageActivity.this.mDownCycleThread.start();
                return false;
            }
        });
        this.mDownCycleBtn.setOnTouchListener(new View.OnTouchListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 1:
                        SettingDataUsageActivity.this.stopDownCycleThread();
                        break;
                }
                return false;
            }
        });
        dialog.setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int whichButton) {
                SettingDataUsageActivity.this.duCycleSpinner.setSelection(SettingDataUsageActivity.this.mSelectedSpinnerPosition);
                SettingDataUsageActivity.this.stopUpCycleThread();
                SettingDataUsageActivity.this.stopDownCycleThread();
                dialog2.dismiss();
            }
        });
        dialog.setPositiveButton(C0000R.string.datausage_cycle_set, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int which) {
                SettingDataUsageActivity.this.mSelectedSpinnerPosition = 0;
                SettingDataUsageActivity.this.stopUpCycleThread();
                SettingDataUsageActivity.this.stopDownCycleThread();
                SettingDataUsageActivity.this.chatonSetting.setCycleDayPref(SettingDataUsageActivity.this.mCurCycleDay);
                SettingDataUsageActivity.this.removeDialog(1000);
                SettingDataUsageActivity.this.initDataUsageCycleView();
                SettingDataUsageActivity.this.getFragment().updateAllData(null);
                SettingDataUsageActivity.this.mSetDataUsageCycleDialog = null;
            }
        });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.setting.view.datausage.SettingDataUsageActivity.14
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog2) {
                SettingDataUsageActivity.this.duCycleSpinner.setSelection(SettingDataUsageActivity.this.mSelectedSpinnerPosition);
                SettingDataUsageActivity.this.stopUpCycleThread();
                SettingDataUsageActivity.this.stopDownCycleThread();
                dialog2.dismiss();
            }
        });
        this.mSetDataUsageCycleDialog = dialog.create();
        this.mSetDataUsageCycleDialog.show();
        return null;
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int id, Dialog dialog) {
        if (id == 1000 && mCycleContentText != null) {
            mCycleContentText.isFocusable();
            this.mSetDataUsageCycleDialog.getWindow().setSoftInputMode(5);
        }
        super.onPrepareDialog(id, dialog);
    }

    private void checkEntitlementWifiOnlyMode() {
        boolean entitlementWifiOnlyMode = MainApplication.mPhoneManager.getPhoneStateMachine().isEntitlementWifiOnlyMode();
        if (this.mChatonservice == null) {
            this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        }
        if (entitlementWifiOnlyMode) {
            this.mWifiOnlylayout.setEnabled(false);
            if (this.mChatonservice.getBackgroundThema() == 1) {
                this.mWifiOnlyText.setTextColor(getResources().getColor(C0000R.color.chaton_color_dark_theme_5));
                return;
            } else {
                this.mWifiOnlyText.setTextColor(getResources().getColor(C0000R.color.chaton_color_003_light));
                return;
            }
        }
        this.mWifiOnlylayout.setEnabled(true);
        if (this.mChatonservice.getBackgroundThema() == 1) {
            this.mWifiOnlyText.setTextColor(getResources().getColor(C0000R.color.chaton_color_dark_theme_1));
        } else {
            this.mWifiOnlyText.setTextColor(getResources().getColor(C0000R.color.chaton_color_002_light));
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        if (this.mFragment != null) {
            this.mFragment = null;
        }
        if (this.mMobileBtn != null) {
            this.mMobileBtn = null;
        }
        if (this.mWifiBtn != null) {
            this.mWifiBtn = null;
        }
        if (this.mUpCycleBtn != null) {
            this.mUpCycleBtn = null;
        }
        if (this.mDownCycleBtn != null) {
            this.mDownCycleBtn = null;
        }
        if (mCycleContentText != null) {
            mCycleContentText = null;
        }
        if (this.duCycleSpinner != null) {
            this.duCycleSpinner = null;
        }
        if (this.spinnerAdapter != null) {
            this.spinnerAdapter = null;
        }
        if (this.cycleList != null) {
            this.cycleList = null;
        }
        if (this.mSetDataUsageCycleDialog != null) {
            if (this.mSetDataUsageCycleDialog.isShowing()) {
                this.mSetDataUsageCycleDialog.dismiss();
            }
            this.mSetDataUsageCycleDialog = null;
        }
        System.gc();
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
        if (actionId == 6 || event == null) {
            return false;
        }
        event.getKeyCode();
        return false;
    }
}
