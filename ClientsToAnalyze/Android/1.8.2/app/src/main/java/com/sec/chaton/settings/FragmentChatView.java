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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentChatView extends Fragment implements AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener {

    /* renamed from: a */
    private RadioGroup f4597a;

    /* renamed from: b */
    private String f4598b;

    /* renamed from: c */
    private TextView f4599c;

    /* renamed from: d */
    private TextView f4600d;

    /* renamed from: e */
    private TextView f4601e;

    /* renamed from: f */
    private TextView f4602f;

    /* renamed from: g */
    private View f4603g;

    /* renamed from: h */
    private View f4604h;

    /* renamed from: i */
    private BitmapDrawable f4605i = null;

    /* renamed from: j */
    private ListView f4606j;

    /* renamed from: k */
    private String f4607k;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4605i = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.pad_chat_bg_01));
        this.f4605i.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null && bundle.containsKey("Default Font Size")) {
            this.f4598b = bundle.getString("Default Font Size");
        }
        if (this.f4598b == null) {
            this.f4607k = C1789u.m6075a().getString("Default Font Size", "size100");
        } else {
            this.f4607k = this.f4598b;
        }
        this.f4598b = this.f4607k;
        BaseActivity.m1829b(this, true);
        this.f4603g = layoutInflater.inflate(R.layout.layout_setting_chatview, viewGroup, false);
        this.f4604h = this.f4603g.findViewById(R.id.skin_preview);
        this.f4599c = (TextView) this.f4603g.findViewById(R.id.read_font_size);
        this.f4600d = (TextView) this.f4603g.findViewById(R.id.read_time);
        this.f4601e = (TextView) this.f4603g.findViewById(R.id.sent_font_size);
        this.f4602f = (TextView) this.f4603g.findViewById(R.id.sent_time);
        if (this.f4603g.findViewById(R.id.menu) != null) {
            this.f4597a = (RadioGroup) this.f4603g.findViewById(R.id.menu);
        }
        if (this.f4603g.findViewById(android.R.id.list) != null) {
            this.f4606j = (ListView) this.f4603g.findViewById(android.R.id.list);
            ArrayList arrayList = new ArrayList();
            arrayList.add(getString(R.string.chat_font_extra_small));
            arrayList.add(getString(R.string.chat_font_small));
            arrayList.add(getString(R.string.chat_font_medium));
            arrayList.add(getString(R.string.chat_font_large));
            arrayList.add(getString(R.string.chat_font_extra_large));
            this.f4606j.setAdapter((ListAdapter) new ArrayAdapter(getActivity(), R.layout.simple_list_item_single_choice, arrayList));
            this.f4606j.setChoiceMode(1);
        }
        if (this.f4597a != null) {
            this.f4597a.setOnCheckedChangeListener(this);
        }
        if (this.f4606j != null) {
            this.f4606j.setOnItemClickListener(this);
        }
        if (this.f4607k.equals("size50")) {
            if (this.f4597a != null) {
                this.f4597a.check(R.id.size50);
            }
            if (this.f4606j != null) {
                this.f4606j.setItemChecked(0, true);
            }
        } else if (this.f4607k.equals("size70")) {
            if (this.f4597a != null) {
                this.f4597a.check(R.id.size70);
            }
            if (this.f4606j != null) {
                this.f4606j.setItemChecked(1, true);
            }
        } else if (this.f4607k.equals("size100")) {
            if (this.f4597a != null) {
                this.f4597a.check(R.id.size100);
            }
            if (this.f4606j != null) {
                this.f4606j.setItemChecked(2, true);
            }
        } else if (this.f4607k.equals("size150")) {
            if (this.f4597a != null) {
                this.f4597a.check(R.id.size150);
            }
            if (this.f4606j != null) {
                this.f4606j.setItemChecked(3, true);
            }
        } else if (this.f4607k.equals("size200")) {
            if (this.f4597a != null) {
                this.f4597a.check(R.id.size200);
            }
            if (this.f4606j != null) {
                this.f4606j.setItemChecked(4, true);
            }
        } else {
            if (this.f4597a != null) {
                this.f4597a.check(R.id.size100);
            }
            if (this.f4606j != null) {
                this.f4606j.setItemChecked(2, true);
            }
        }
        if (this.f4603g.findViewById(R.id.save_viewsize) != null) {
            ((Button) this.f4603g.findViewById(R.id.save_viewsize)).setOnClickListener(new ViewOnClickListenerC1264bp(this));
        }
        if (this.f4603g.findViewById(R.id.btnCancel) != null) {
            ((Button) this.f4603g.findViewById(R.id.btnCancel)).setOnClickListener(new ViewOnClickListenerC1265bq(this));
        }
        m4590a(this.f4598b, this.f4599c);
        m4590a(this.f4598b, this.f4601e);
        m4591b(this.f4598b, this.f4600d);
        m4591b(this.f4598b, this.f4602f);
        return this.f4603g;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f4604h.setBackgroundDrawable(this.f4605i);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f4598b != null) {
            bundle.putString("Default Font Size", this.f4598b);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (GlobalApplication.m3265f()) {
            C1789u.m6075a().edit().putString("Default Font Size", this.f4598b).commit();
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.getId() == R.id.menu) {
            switch (i) {
                case R.id.size100 /* 2131493792 */:
                    this.f4598b = "size100";
                    break;
                case R.id.size50 /* 2131493794 */:
                    this.f4598b = "size50";
                    break;
                case R.id.size70 /* 2131493796 */:
                    this.f4598b = "size70";
                    break;
                case R.id.size150 /* 2131493797 */:
                    this.f4598b = "size150";
                    break;
                case R.id.size200 /* 2131493798 */:
                    this.f4598b = "size200";
                    break;
            }
            m4590a(this.f4598b, this.f4599c);
            m4590a(this.f4598b, this.f4601e);
            m4591b(this.f4598b, this.f4600d);
            m4591b(this.f4598b, this.f4602f);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                this.f4598b = "size50";
                break;
            case 1:
                this.f4598b = "size70";
                break;
            case 2:
                this.f4598b = "size100";
                break;
            case 3:
                this.f4598b = "size150";
                break;
            case 4:
                this.f4598b = "size200";
                break;
        }
        m4590a(this.f4598b, this.f4599c);
        m4590a(this.f4598b, this.f4601e);
        m4591b(this.f4598b, this.f4600d);
        m4591b(this.f4598b, this.f4602f);
    }

    /* renamed from: a */
    private void m4590a(String str, TextView textView) {
        if (str.equals("size50")) {
            if (GlobalApplication.m3265f()) {
                textView.setTextSize(11.0f);
                return;
            } else {
                textView.setTextSize(8.0f);
                return;
            }
        }
        if (str.equals("size70")) {
            if (GlobalApplication.m3265f()) {
                textView.setTextSize(15.4f);
                return;
            } else {
                textView.setTextSize(11.2f);
                return;
            }
        }
        if (str.equals("size100")) {
            if (GlobalApplication.m3265f()) {
                textView.setTextSize(22.0f);
                return;
            } else {
                textView.setTextSize(16.0f);
                return;
            }
        }
        if (str.equals("size150")) {
            if (GlobalApplication.m3265f()) {
                textView.setTextSize(33.0f);
                return;
            } else {
                textView.setTextSize(24.0f);
                return;
            }
        }
        if (str.equals("size200")) {
            if (GlobalApplication.m3265f()) {
                textView.setTextSize(44.0f);
            } else {
                textView.setTextSize(32.0f);
            }
        }
    }

    /* renamed from: b */
    private void m4591b(String str, TextView textView) {
        textView.setTextSize(8.6f);
    }
}
