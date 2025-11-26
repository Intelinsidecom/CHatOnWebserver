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
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class TextInputDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    TextWatcher f4175a;

    /* renamed from: b */
    private TextView f4176b;

    /* renamed from: c */
    private EditText f4177c;

    /* renamed from: d */
    private String f4178d;

    /* renamed from: e */
    private int f4179e;

    /* renamed from: f */
    private Button f4180f;

    /* renamed from: g */
    private OnApplyListener f4181g;

    public TextInputDialog(Context context, int i, int i2) {
        super(context, i);
        this.f4176b = null;
        this.f4177c = null;
        this.f4178d = null;
        this.f4179e = 0;
        this.f4180f = null;
        this.f4181g = null;
        this.f4175a = new C0720w(this);
        setContentView(C0062R.layout.ams_text_input_popup);
        setTitle("Input Text");
        int width = (int) (getWindow().getWindowManager().getDefaultDisplay().getWidth() * 0.9d);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0062R.id.layout_text_input);
        this.f4177c = new EditText(context);
        this.f4177c.setLayoutParams(new ViewGroup.LayoutParams(width, -2));
        this.f4177c.setTextSize(18.0f);
        linearLayout.addView(this.f4177c);
        if (i2 > 0) {
            this.f4179e = i2;
            this.f4177c.addTextChangedListener(this.f4175a);
            this.f4176b = new TextView(context);
            this.f4176b.setLayoutParams(new ViewGroup.LayoutParams(width, -2));
            this.f4176b.setGravity(5);
            this.f4176b.setText(String.format("(%d/%d)", Integer.valueOf(this.f4177c.getText().length()), Integer.valueOf(this.f4179e)));
            linearLayout.addView(this.f4176b);
        }
        this.f4180f = (Button) findViewById(C0062R.id.btnOK);
        Button button = (Button) findViewById(C0062R.id.btnCancel);
        this.f4180f.setOnClickListener(this);
        button.setOnClickListener(this);
        m4177c();
    }

    /* renamed from: c */
    static int m4175c(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = str.charAt(i2) < 128 ? i + 1 : i + 2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4177c() {
        this.f4180f.setEnabled(this.f4177c.getText().toString().length() > 0);
    }

    /* renamed from: a */
    public String m4179a() {
        return this.f4177c.getText().toString();
    }

    /* renamed from: a */
    public void m4180a(OnApplyListener onApplyListener) {
        this.f4181g = onApplyListener;
    }

    /* renamed from: a */
    public void m4181a(String str) {
        this.f4177c.setText(str);
    }

    /* renamed from: b */
    public EditText m4182b() {
        return this.f4177c;
    }

    /* renamed from: b */
    public void m4183b(String str) {
        this.f4178d = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btnOK /* 2131427488 */:
                if (this.f4177c.getText().toString().length() > 0 && this.f4181g != null) {
                    this.f4181g.mo4161b();
                }
                dismiss();
                break;
            case C0062R.id.btnCancel /* 2131427489 */:
                dismiss();
                break;
        }
    }
}
