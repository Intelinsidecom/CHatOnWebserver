package com.coolots.chaton.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class StressTestActivity extends Activity implements DisposeInterface {
    private Button mBtnConfPlaceCallTest;
    private Button mBtnFinishTest;
    private Button mBtnPlaceCallTest;
    private Button mBtnReceiveCallTest;
    private EditText mEdtCallDuration;
    private EditText mEdtConfMember1;
    private EditText mEdtConfMember2;
    private EditText mEdtConfMember3;
    private EditText mEdtDest;
    private EditText mEdtWaitDuration;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(C0000R.layout.stresstest);
        initView();
        super.onCreate(savedInstanceState);
    }

    private void initView() {
        this.mEdtDest = (EditText) findViewById(C0000R.id.edit_p2pdest);
        this.mEdtConfMember1 = (EditText) findViewById(C0000R.id.edit_confdest1);
        this.mEdtConfMember2 = (EditText) findViewById(C0000R.id.edit_confdest2);
        this.mEdtConfMember3 = (EditText) findViewById(C0000R.id.edit_confdest3);
        this.mEdtCallDuration = (EditText) findViewById(C0000R.id.edit_callduration);
        this.mEdtWaitDuration = (EditText) findViewById(C0000R.id.edit_waitduration);
        this.mBtnPlaceCallTest = (Button) findViewById(C0000R.id.btn_placecallmode);
        this.mBtnPlaceCallTest.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.test.StressTestActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StressTestActivity.this.startPlaceCallTest();
            }
        });
        this.mBtnReceiveCallTest = (Button) findViewById(C0000R.id.btn_receivecallmode);
        this.mBtnReceiveCallTest.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.test.StressTestActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StressTestActivity.this.startReceiveCallTest();
            }
        });
        this.mBtnConfPlaceCallTest = (Button) findViewById(C0000R.id.btn_confplacecallmode);
        this.mBtnConfPlaceCallTest.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.test.StressTestActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StressTestActivity.this.startConfPlaceCallTest();
            }
        });
        this.mBtnFinishTest = (Button) findViewById(C0000R.id.btn_finishtest);
        this.mBtnFinishTest.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.test.StressTestActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StressTestActivity.this.finishTestMode();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlaceCallTest() {
        String userID = this.mEdtDest.getText().toString();
        MainApplication.mPhoneManager.getPhoneStateMachine().setP2PTestInfo(String.valueOf(userID) + "@chaton", Integer.parseInt(this.mEdtCallDuration.getText().toString()), Integer.parseInt(this.mEdtWaitDuration.getText().toString()), false);
        MainApplication.mPhoneManager.getPhoneStateMachine().startStressTest();
        this.mBtnPlaceCallTest.setEnabled(false);
        this.mBtnReceiveCallTest.setEnabled(false);
        this.mBtnConfPlaceCallTest.setEnabled(false);
        this.mBtnFinishTest.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReceiveCallTest() {
        MainApplication.mPhoneManager.setTestMode(true);
        this.mBtnPlaceCallTest.setEnabled(false);
        this.mBtnReceiveCallTest.setEnabled(false);
        this.mBtnConfPlaceCallTest.setEnabled(false);
        this.mBtnFinishTest.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConfPlaceCallTest() {
        ArrayList<SimpleUserInfo> member = new ArrayList<>();
        member.add(new SimpleUserInfo(String.valueOf(this.mEdtConfMember1.getText().toString()) + "@chaton", String.valueOf(this.mEdtConfMember1.getText().toString()) + "@chaton"));
        member.add(new SimpleUserInfo(String.valueOf(this.mEdtConfMember2.getText().toString()) + "@chaton", String.valueOf(this.mEdtConfMember2.getText().toString()) + "@chaton"));
        member.add(new SimpleUserInfo(String.valueOf(this.mEdtConfMember3.getText().toString()) + "@chaton", String.valueOf(this.mEdtConfMember3.getText().toString()) + "@chaton"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishTestMode() {
        MainApplication.mPhoneManager.setTestMode(false);
        MainApplication.mPhoneManager.getPhoneStateMachine().stopPhoneStressTest();
        this.mBtnPlaceCallTest.setEnabled(true);
        this.mBtnReceiveCallTest.setEnabled(true);
        this.mBtnConfPlaceCallTest.setEnabled(true);
        this.mBtnFinishTest.setEnabled(false);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        System.gc();
    }
}
