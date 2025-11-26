package com.coolots.chaton.common.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.LogReportAsk;
import com.coolots.p2pmsg.model.StoreNoteAsk;
import com.coolots.sso.util.ChatONVAPII;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.LogReportAdaptor;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class LogSenderActivity extends Activity implements DisposeInterface {
    private CheckBox[] mArrayCheckBox = new CheckBox[5];
    private EditText mEditText;
    private Handler mHandler;
    private String mLevel;
    private String mTag;

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(C0000R.layout.log_sender);
        initialize();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        if (this.mEditText != null) {
            this.mEditText.removeCallbacks(null);
            this.mEditText = null;
        }
        this.mHandler = null;
        this.mArrayCheckBox = null;
        System.gc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckBoxState(CheckBox target, boolean state) {
        if (this.mArrayCheckBox.length != 0) {
            for (CheckBox item : this.mArrayCheckBox) {
                if (item.getId() == target.getId()) {
                    switch (item.getId()) {
                        case C0000R.id.checkBox1 /* 2131493080 */:
                            this.mLevel = "V";
                            break;
                        case C0000R.id.checkBox2 /* 2131493081 */:
                            this.mLevel = StoreNoteAsk.TYPE_REMOVE_MEMBER;
                            break;
                        case C0000R.id.checkBox3 /* 2131493082 */:
                            this.mLevel = "I";
                            break;
                        case C0000R.id.checkBox4 /* 2131493083 */:
                            this.mLevel = "W";
                            break;
                        case C0000R.id.checkBox5 /* 2131493084 */:
                            this.mLevel = "E";
                            break;
                    }
                } else {
                    item.setChecked(state);
                }
            }
        }
    }

    private void initialize() {
        this.mEditText = (EditText) findViewById(C0000R.id.editText1);
        this.mArrayCheckBox[0] = (CheckBox) findViewById(C0000R.id.checkBox1);
        this.mArrayCheckBox[1] = (CheckBox) findViewById(C0000R.id.checkBox2);
        this.mArrayCheckBox[2] = (CheckBox) findViewById(C0000R.id.checkBox3);
        this.mArrayCheckBox[3] = (CheckBox) findViewById(C0000R.id.checkBox4);
        this.mArrayCheckBox[4] = (CheckBox) findViewById(C0000R.id.checkBox5);
        if (this.mArrayCheckBox.length != 0) {
            for (final CheckBox item : this.mArrayCheckBox) {
                item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.coolots.chaton.common.view.LogSenderActivity.1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (!isChecked) {
                            LogSenderActivity.this.mLevel = "*";
                        } else {
                            LogSenderActivity.this.setCheckBoxState(item, !isChecked);
                        }
                    }
                });
            }
        }
        Button button = (Button) findViewById(C0000R.id.button1);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.view.LogSenderActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogSenderActivity.this.startErrorLogToServer(ModelInfoUtil.getAppVersion(MainApplication.mContext), MainApplication.mPhoneManager.getConfigManager().writeErrorLog(LogSenderActivity.this.executeLogcat().toString()));
                Toast.makeText(LogSenderActivity.this, LogSenderActivity.this.getResources().getString(C0000R.string.start_sending_log), 1).show();
            }
        });
        this.mHandler = new Handler() { // from class: com.coolots.chaton.common.view.LogSenderActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                if (msg.what == MessageInfo.LogReportRep.getDispatchCode() && msg.arg1 == 22220) {
                    Log.m2958e("COOLOTS EventCode.EVENT_LOG_REPORT_SUCCESS");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StringBuilder executeLogcat() throws IOException {
        if (this.mEditText.getText().toString() == null && "".equals(this.mEditText.getText().toString())) {
            this.mTag = "*";
        }
        StringBuilder result = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec("logcat -d -v time " + this.mTag + ChatONVAPII.USERID_DELEMETER + this.mLevel);
            InputStream inputStream = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(isr);
            while (true) {
                String line = bufferReader.readLine();
                if (line == null) {
                    break;
                }
                result.append(String.valueOf('\n') + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startErrorLogToServer(String appVersion, String logData) {
        LogReportAsk logReportAsk = new LogReportAsk();
        logReportAsk.setAppVersion(appVersion);
        logReportAsk.setLogData(logData);
        LogReportAdaptor logReportAdaptor = new LogReportAdaptor(logReportAsk, this.mHandler);
        logReportAdaptor.start();
    }
}
