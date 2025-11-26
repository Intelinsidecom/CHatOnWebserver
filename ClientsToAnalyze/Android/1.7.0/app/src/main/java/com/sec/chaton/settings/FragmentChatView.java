package com.sec.chaton.settings;

import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C1323bs;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentChatView extends Fragment implements AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener {

    /* renamed from: a */
    private RadioGroup f3482a;

    /* renamed from: b */
    private String f3483b;

    /* renamed from: c */
    private TextView f3484c;

    /* renamed from: d */
    private TextView f3485d;

    /* renamed from: e */
    private TextView f3486e;

    /* renamed from: f */
    private TextView f3487f;

    /* renamed from: g */
    private View f3488g;

    /* renamed from: h */
    private View f3489h;

    /* renamed from: i */
    private BitmapDrawable f3490i = null;

    /* renamed from: j */
    private ListView f3491j;

    /* renamed from: k */
    private String f3492k;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3490i = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.pad_chat_bg_01));
        this.f3490i.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null && bundle.containsKey("Default Font Size")) {
            this.f3483b = bundle.getString("Default Font Size");
        }
        if (this.f3483b == null) {
            this.f3492k = C1323bs.m4575a().getString("Default Font Size", "size100");
        } else {
            this.f3492k = this.f3483b;
        }
        this.f3483b = this.f3492k;
        BaseActivity.m2043b(this, true);
        this.f3488g = layoutInflater.inflate(R.layout.layout_setting_chatview, viewGroup, false);
        this.f3489h = this.f3488g.findViewById(R.id.skin_preview);
        this.f3484c = (TextView) this.f3488g.findViewById(R.id.read_font_size);
        this.f3485d = (TextView) this.f3488g.findViewById(R.id.read_time);
        this.f3486e = (TextView) this.f3488g.findViewById(R.id.sent_font_size);
        this.f3487f = (TextView) this.f3488g.findViewById(R.id.sent_time);
        if (this.f3488g.findViewById(R.id.menu) != null) {
            this.f3482a = (RadioGroup) this.f3488g.findViewById(R.id.menu);
        }
        if (this.f3488g.findViewById(android.R.id.list) != null) {
            this.f3491j = (ListView) this.f3488g.findViewById(android.R.id.list);
            ArrayList arrayList = new ArrayList();
            arrayList.add(getString(R.string.chat_font_extra_small));
            arrayList.add(getString(R.string.chat_font_small));
            arrayList.add(getString(R.string.chat_font_medium));
            arrayList.add(getString(R.string.chat_font_large));
            arrayList.add(getString(R.string.chat_font_extra_large));
            this.f3491j.setAdapter((ListAdapter) new ArrayAdapter(getActivity(), R.layout.simple_list_item_single_choice, arrayList));
            this.f3491j.setChoiceMode(1);
        }
        if (this.f3482a != null) {
            this.f3482a.setOnCheckedChangeListener(this);
        }
        if (this.f3491j != null) {
            this.f3491j.setOnItemClickListener(this);
        }
        if (this.f3492k.equals("size50")) {
            if (this.f3482a != null) {
                this.f3482a.check(R.id.size50);
            }
            if (this.f3491j != null) {
                this.f3491j.setItemChecked(0, true);
            }
        } else if (this.f3492k.equals("size70")) {
            if (this.f3482a != null) {
                this.f3482a.check(R.id.size70);
            }
            if (this.f3491j != null) {
                this.f3491j.setItemChecked(1, true);
            }
        } else if (this.f3492k.equals("size100")) {
            if (this.f3482a != null) {
                this.f3482a.check(R.id.size100);
            }
            if (this.f3491j != null) {
                this.f3491j.setItemChecked(2, true);
            }
        } else if (this.f3492k.equals("size150")) {
            if (this.f3482a != null) {
                this.f3482a.check(R.id.size150);
            }
            if (this.f3491j != null) {
                this.f3491j.setItemChecked(3, true);
            }
        } else if (this.f3492k.equals("size200")) {
            if (this.f3482a != null) {
                this.f3482a.check(R.id.size200);
            }
            if (this.f3491j != null) {
                this.f3491j.setItemChecked(4, true);
            }
        } else {
            if (this.f3482a != null) {
                this.f3482a.check(R.id.size100);
            }
            if (this.f3491j != null) {
                this.f3491j.setItemChecked(2, true);
            }
        }
        if (this.f3488g.findViewById(R.id.save_viewsize) != null) {
            ((Button) this.f3488g.findViewById(R.id.save_viewsize)).setOnClickListener(new ViewOnClickListenerC1084p(this));
        }
        if (this.f3488g.findViewById(R.id.btnCancel) != null) {
            ((Button) this.f3488g.findViewById(R.id.btnCancel)).setOnClickListener(new ViewOnClickListenerC1085q(this));
        }
        m3826a(this.f3483b, this.f3484c);
        m3826a(this.f3483b, this.f3486e);
        m3827b(this.f3483b, this.f3485d);
        m3827b(this.f3483b, this.f3487f);
        return this.f3488g;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f3489h.setBackgroundDrawable(this.f3490i);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f3483b != null) {
            bundle.putString("Default Font Size", this.f3483b);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.getId() == R.id.menu) {
            switch (i) {
                case R.id.size100 /* 2131428027 */:
                    this.f3483b = "size100";
                    break;
                case R.id.size50 /* 2131428029 */:
                    this.f3483b = "size50";
                    break;
                case R.id.size70 /* 2131428031 */:
                    this.f3483b = "size70";
                    break;
                case R.id.size150 /* 2131428032 */:
                    this.f3483b = "size150";
                    break;
                case R.id.size200 /* 2131428033 */:
                    this.f3483b = "size200";
                    break;
            }
            m3826a(this.f3483b, this.f3484c);
            m3826a(this.f3483b, this.f3486e);
            m3827b(this.f3483b, this.f3485d);
            m3827b(this.f3483b, this.f3487f);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                this.f3483b = "size50";
                break;
            case 1:
                this.f3483b = "size70";
                break;
            case 2:
                this.f3483b = "size100";
                break;
            case 3:
                this.f3483b = "size150";
                break;
            case 4:
                this.f3483b = "size200";
                break;
        }
        m3826a(this.f3483b, this.f3484c);
        m3826a(this.f3483b, this.f3486e);
        m3827b(this.f3483b, this.f3485d);
        m3827b(this.f3483b, this.f3487f);
    }

    /* renamed from: a */
    private void m3826a(String str, TextView textView) {
        if (str.equals("size50")) {
            textView.setTextSize(8.0f);
            return;
        }
        if (str.equals("size70")) {
            textView.setTextSize(11.2f);
            return;
        }
        if (str.equals("size100")) {
            textView.setTextSize(16.0f);
        } else if (str.equals("size150")) {
            textView.setTextSize(24.0f);
        } else if (str.equals("size200")) {
            textView.setTextSize(32.0f);
        }
    }

    /* renamed from: b */
    private void m3827b(String str, TextView textView) {
        textView.setTextSize(8.6f);
    }
}
