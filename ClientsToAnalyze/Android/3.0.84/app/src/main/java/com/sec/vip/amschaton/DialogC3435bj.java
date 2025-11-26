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

/* compiled from: TextInputDialog.java */
/* renamed from: com.sec.vip.amschaton.bj */
/* loaded from: classes.dex */
public class DialogC3435bj extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    TextWatcher f12566a;

    /* renamed from: b */
    private TextView f12567b;

    /* renamed from: c */
    private EditText f12568c;

    /* renamed from: d */
    private String f12569d;

    /* renamed from: e */
    private int f12570e;

    /* renamed from: f */
    private Button f12571f;

    /* renamed from: g */
    private Toast f12572g;

    /* renamed from: h */
    private InterfaceC3434bi f12573h;

    public DialogC3435bj(Context context, int i, int i2) {
        super(context, i);
        this.f12567b = null;
        this.f12568c = null;
        this.f12569d = null;
        this.f12570e = 0;
        this.f12571f = null;
        this.f12572g = null;
        this.f12573h = null;
        this.f12566a = new C3436bk(this);
        setContentView(R.layout.ams_text_input_popup);
        int width = (int) (getWindow().getWindowManager().getDefaultDisplay().getWidth() * 0.9d);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_text_input);
        this.f12568c = new EditText(context);
        this.f12568c.setLayoutParams(new ViewGroup.LayoutParams(width, -2));
        this.f12568c.setTextSize(18.0f);
        this.f12568c.setSingleLine();
        this.f12568c.setInputType(16384);
        linearLayout.addView(this.f12568c);
        if (i2 > 0) {
            this.f12570e = i2;
            this.f12568c.addTextChangedListener(this.f12566a);
            this.f12567b = new TextView(context);
            this.f12567b.setLayoutParams(new ViewGroup.LayoutParams(width, -2));
            this.f12567b.setGravity(5);
            this.f12567b.setText(String.format("(%d/%d)", Integer.valueOf(this.f12568c.getText().length()), Integer.valueOf(this.f12570e)));
            linearLayout.addView(this.f12567b);
        }
        this.f12571f = (Button) findViewById(R.id.btnOK);
        Button button = (Button) findViewById(R.id.btnCancel);
        this.f12571f.setOnClickListener(this);
        button.setOnClickListener(this);
        m12295c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12295c() {
        boolean z;
        String string = this.f12568c.getText().toString();
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
        this.f12571f.setEnabled(length > 0 && !z);
    }

    /* renamed from: a */
    public void m12301a(String str) {
        this.f12568c.setText(str);
        this.f12568c.setSelection(this.f12568c.getText().length());
    }

    /* renamed from: b */
    public void m12303b(String str) {
        this.f12569d = str;
    }

    /* renamed from: a */
    public void m12300a(InterfaceC3434bi interfaceC3434bi) {
        this.f12573h = interfaceC3434bi;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOK /* 2131165297 */:
                if (this.f12568c.getText().toString().length() > 0 && this.f12573h != null) {
                    this.f12573h.mo12235b();
                }
                dismiss();
                break;
            case R.id.btnCancel /* 2131165298 */:
                dismiss();
                break;
        }
    }

    /* renamed from: a */
    public String m12298a() {
        return this.f12568c.getText().toString();
    }

    /* renamed from: b */
    public EditText m12302b() {
        return this.f12568c;
    }

    /* renamed from: c */
    static int m12293c(String str) {
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
    String m12299a(String str, int i) {
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
