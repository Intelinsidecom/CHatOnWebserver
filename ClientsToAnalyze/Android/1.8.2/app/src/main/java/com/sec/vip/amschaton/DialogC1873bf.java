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
/* renamed from: com.sec.vip.amschaton.bf */
/* loaded from: classes.dex */
public class DialogC1873bf extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    TextWatcher f6843a;

    /* renamed from: b */
    private TextView f6844b;

    /* renamed from: c */
    private EditText f6845c;

    /* renamed from: d */
    private String f6846d;

    /* renamed from: e */
    private int f6847e;

    /* renamed from: f */
    private Button f6848f;

    /* renamed from: g */
    private Toast f6849g;

    /* renamed from: h */
    private InterfaceC1872be f6850h;

    public DialogC1873bf(Context context, int i, int i2) {
        super(context, i);
        this.f6844b = null;
        this.f6845c = null;
        this.f6846d = null;
        this.f6847e = 0;
        this.f6848f = null;
        this.f6849g = null;
        this.f6850h = null;
        this.f6843a = new C1874bg(this);
        setContentView(R.layout.ams_text_input_popup);
        int width = (int) (getWindow().getWindowManager().getDefaultDisplay().getWidth() * 0.9d);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_text_input);
        this.f6845c = new EditText(context);
        this.f6845c.setLayoutParams(new ViewGroup.LayoutParams(width, -2));
        this.f6845c.setTextSize(18.0f);
        this.f6845c.setSingleLine();
        this.f6845c.setInputType(WebSocketFrameDecoder.DEFAULT_MAX_FRAME_SIZE);
        linearLayout.addView(this.f6845c);
        if (i2 > 0) {
            this.f6847e = i2;
            this.f6845c.addTextChangedListener(this.f6843a);
            this.f6844b = new TextView(context);
            this.f6844b.setLayoutParams(new ViewGroup.LayoutParams(width, -2));
            this.f6844b.setGravity(5);
            this.f6844b.setText(String.format("(%d/%d)", Integer.valueOf(this.f6845c.getText().length()), Integer.valueOf(this.f6847e)));
            linearLayout.addView(this.f6844b);
        }
        this.f6848f = (Button) findViewById(R.id.btnOK);
        Button button = (Button) findViewById(R.id.btnCancel);
        this.f6848f.setOnClickListener(this);
        button.setOnClickListener(this);
        m6473c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6473c() {
        boolean z;
        String string = this.f6845c.getText().toString();
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
        this.f6848f.setEnabled(length > 0 && !z);
    }

    /* renamed from: a */
    public void m6479a(String str) {
        this.f6845c.setText(str);
        this.f6845c.setSelection(this.f6845c.getText().length());
    }

    /* renamed from: b */
    public void m6481b(String str) {
        this.f6846d = str;
    }

    /* renamed from: a */
    public void m6478a(InterfaceC1872be interfaceC1872be) {
        this.f6850h = interfaceC1872be;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOK /* 2131493036 */:
                if (this.f6845c.getText().toString().length() > 0 && this.f6850h != null) {
                    this.f6850h.mo6436d_();
                }
                dismiss();
                break;
            case R.id.btnCancel /* 2131493037 */:
                dismiss();
                break;
        }
    }

    /* renamed from: a */
    public String m6476a() {
        return this.f6845c.getText().toString();
    }

    /* renamed from: b */
    public EditText m6480b() {
        return this.f6845c;
    }

    /* renamed from: c */
    static int m6471c(String str) {
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
    String m6477a(String str, int i) {
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
