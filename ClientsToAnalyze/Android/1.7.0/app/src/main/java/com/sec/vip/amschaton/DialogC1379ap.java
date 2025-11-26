package com.sec.vip.amschaton;

import android.app.Dialog;
import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import org.jboss.netty.handler.codec.http.websocket.WebSocketFrameDecoder;

/* compiled from: TextInputDialog.java */
/* renamed from: com.sec.vip.amschaton.ap */
/* loaded from: classes.dex */
public class DialogC1379ap extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    TextWatcher f4823a;

    /* renamed from: b */
    private TextView f4824b;

    /* renamed from: c */
    private EditText f4825c;

    /* renamed from: d */
    private String f4826d;

    /* renamed from: e */
    private int f4827e;

    /* renamed from: f */
    private Button f4828f;

    /* renamed from: g */
    private Toast f4829g;

    /* renamed from: h */
    private InterfaceC1397bg f4830h;

    public DialogC1379ap(Context context, int i, int i2) {
        super(context, i);
        this.f4824b = null;
        this.f4825c = null;
        this.f4826d = null;
        this.f4827e = 0;
        this.f4828f = null;
        this.f4829g = null;
        this.f4830h = null;
        this.f4823a = new C1556u(this);
        setContentView(R.layout.ams_text_input_popup);
        int width = (int) (getWindow().getWindowManager().getDefaultDisplay().getWidth() * 0.9d);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_text_input);
        this.f4825c = new EditText(context);
        this.f4825c.setLayoutParams(new ViewGroup.LayoutParams(width, -2));
        this.f4825c.setTextSize(18.0f);
        this.f4825c.setSingleLine();
        this.f4825c.setInputType(WebSocketFrameDecoder.DEFAULT_MAX_FRAME_SIZE);
        linearLayout.addView(this.f4825c);
        if (i2 > 0) {
            this.f4827e = i2;
            this.f4825c.addTextChangedListener(this.f4823a);
            this.f4824b = new TextView(context);
            this.f4824b.setLayoutParams(new ViewGroup.LayoutParams(width, -2));
            this.f4824b.setGravity(5);
            this.f4824b.setText(String.format("(%d/%d)", Integer.valueOf(this.f4825c.getText().length()), Integer.valueOf(this.f4827e)));
            linearLayout.addView(this.f4824b);
        }
        this.f4828f = (Button) findViewById(R.id.btnOK);
        Button button = (Button) findViewById(R.id.btnCancel);
        this.f4828f.setOnClickListener(this);
        button.setOnClickListener(this);
        m4935c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4935c() {
        boolean z;
        String string = this.f4825c.getText().toString();
        int length = string.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            } else {
                if (string.charAt(i) != ' ') {
                    z = false;
                    break;
                }
                i++;
            }
        }
        this.f4828f.setEnabled(length > 0 && !z);
    }

    /* renamed from: a */
    public void m4941a(String str) {
        this.f4825c.setText(str);
        this.f4825c.setSelection(this.f4825c.getText().length());
    }

    /* renamed from: b */
    public void m4943b(String str) {
        this.f4826d = str;
    }

    /* renamed from: a */
    public void m4940a(InterfaceC1397bg interfaceC1397bg) {
        this.f4830h = interfaceC1397bg;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOK /* 2131427468 */:
                if (this.f4825c.getText().toString().length() > 0 && this.f4830h != null) {
                    this.f4830h.mo4927b();
                }
                dismiss();
                break;
            case R.id.btnCancel /* 2131427469 */:
                dismiss();
                break;
        }
    }

    /* renamed from: a */
    public String m4938a() {
        return this.f4825c.getText().toString();
    }

    /* renamed from: b */
    public EditText m4942b() {
        return this.f4825c;
    }

    /* renamed from: c */
    static int m4933c(String str) {
        int i = 0;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) < 128) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    /* renamed from: a */
    String m4939a(String str, int i) {
        int i2 = 0;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                i2++;
                sb.append(cCharAt);
            } else {
                if (i2 + 2 > i) {
                    break;
                }
                i2 += 2;
                sb.append(cCharAt);
            }
            if (i2 >= i) {
                break;
            }
        }
        return sb.toString();
    }
}
