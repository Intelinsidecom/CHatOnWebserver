package com.sec.chaton.settings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class ActivityChatView extends Activity implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a */
    private RadioGroup f2980a;

    /* renamed from: b */
    private String f2981b;

    /* renamed from: c */
    private TextView f2982c;

    /* renamed from: d */
    private TextView f2983d;

    /* renamed from: e */
    private TextView f2984e;

    /* renamed from: f */
    private TextView f2985f;

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.getId() == C0062R.id.menu) {
            switch (i) {
                case C0062R.id.size100 /* 2131427949 */:
                    this.f2982c.setTextSize(16.0f);
                    this.f2983d.setTextSize(11.0f);
                    this.f2984e.setTextSize(16.0f);
                    this.f2985f.setTextSize(11.0f);
                    this.f2981b = "size100";
                    break;
                case C0062R.id.size50 /* 2131427951 */:
                    this.f2982c.setTextSize(8.0f);
                    this.f2983d.setTextSize(11.0f);
                    this.f2984e.setTextSize(8.0f);
                    this.f2985f.setTextSize(11.0f);
                    this.f2981b = "size50";
                    break;
                case C0062R.id.size70 /* 2131427952 */:
                    this.f2982c.setTextSize(11.0f);
                    this.f2983d.setTextSize(11.0f);
                    this.f2984e.setTextSize(11.0f);
                    this.f2985f.setTextSize(11.0f);
                    this.f2981b = "size70";
                    break;
                case C0062R.id.size150 /* 2131427953 */:
                    this.f2982c.setTextSize(24.0f);
                    this.f2983d.setTextSize(11.0f);
                    this.f2984e.setTextSize(24.0f);
                    this.f2985f.setTextSize(11.0f);
                    this.f2981b = "size150";
                    break;
                case C0062R.id.size200 /* 2131427954 */:
                    this.f2982c.setTextSize(32.0f);
                    this.f2983d.setTextSize(11.0f);
                    this.f2984e.setTextSize(32.0f);
                    this.f2985f.setTextSize(11.0f);
                    this.f2981b = "size200";
                    break;
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = ChatONPref.m3519a().getString("Default Font Size", "size100");
        ChatONLogWriter.m3508c("FONT_SIZE = " + string, getClass().getSimpleName());
        this.f2981b = string;
        setContentView(C0062R.layout.layout_setting_chatview);
        this.f2980a = (RadioGroup) findViewById(C0062R.id.menu);
        this.f2982c = (TextView) findViewById(C0062R.id.read_font_size);
        this.f2983d = (TextView) findViewById(C0062R.id.read_time);
        this.f2984e = (TextView) findViewById(C0062R.id.sent_font_size);
        this.f2985f = (TextView) findViewById(C0062R.id.sent_time);
        if (string.equals("size50")) {
            this.f2980a.check(C0062R.id.size50);
            this.f2982c.setTextSize(8.0f);
            this.f2983d.setTextSize(11.0f);
            this.f2984e.setTextSize(8.0f);
            this.f2985f.setTextSize(11.0f);
        } else if (string.equals("size70")) {
            this.f2980a.check(C0062R.id.size70);
            this.f2982c.setTextSize(11.0f);
            this.f2983d.setTextSize(11.0f);
            this.f2984e.setTextSize(11.0f);
            this.f2985f.setTextSize(11.0f);
        } else if (string.equals("size100")) {
            this.f2980a.check(C0062R.id.size100);
            this.f2982c.setTextSize(16.0f);
            this.f2983d.setTextSize(11.0f);
            this.f2984e.setTextSize(16.0f);
            this.f2985f.setTextSize(11.0f);
        } else if (string.equals("size150")) {
            this.f2980a.check(C0062R.id.size150);
            this.f2982c.setTextSize(24.0f);
            this.f2983d.setTextSize(11.0f);
            this.f2984e.setTextSize(24.0f);
            this.f2985f.setTextSize(11.0f);
        } else if (string.equals("size200")) {
            this.f2980a.check(C0062R.id.size200);
            this.f2982c.setTextSize(32.0f);
            this.f2983d.setTextSize(11.0f);
            this.f2984e.setTextSize(32.0f);
            this.f2985f.setTextSize(11.0f);
        } else {
            this.f2980a.check(C0062R.id.size100);
            this.f2982c.setTextSize(16.0f);
            this.f2983d.setTextSize(11.0f);
            this.f2984e.setTextSize(16.0f);
            this.f2985f.setTextSize(11.0f);
        }
        this.f2980a.setOnCheckedChangeListener(this);
        ((Button) findViewById(C0062R.id.save_viewsize)).setOnClickListener(new ViewOnClickListenerC0483be(this));
        ((Button) findViewById(C0062R.id.btnCancel)).setOnClickListener(new ViewOnClickListenerC0484bf(this));
    }
}
