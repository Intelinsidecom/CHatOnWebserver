package com.sec.chaton.smsplugin.multimedia.emoticon;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.C2793e;
import com.sec.chaton.multimedia.emoticon.C2795g;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.util.C4822an;

/* loaded from: classes.dex */
public class SmsEmoticonContainer extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: a */
    private int f14052a;

    /* renamed from: b */
    private String f14053b;

    /* renamed from: c */
    private Activity f14054c;

    /* renamed from: d */
    private GridView f14055d;

    /* renamed from: e */
    private View f14056e;

    /* renamed from: f */
    private TextView f14057f;

    /* renamed from: g */
    private ImageButton f14058g;

    /* renamed from: h */
    private View f14059h;

    /* renamed from: i */
    private ListAdapter f14060i;

    /* renamed from: j */
    private ListAdapter f14061j;

    /* renamed from: k */
    private InterfaceC3912a f14062k;

    /* renamed from: a */
    public static final SmsEmoticonContainer m15097a(int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("layoutResId", i);
        SmsEmoticonContainer smsEmoticonContainer = new SmsEmoticonContainer();
        smsEmoticonContainer.setArguments(bundle);
        return smsEmoticonContainer;
    }

    /* renamed from: a */
    public void m15099a(InterfaceC3912a interfaceC3912a) {
        this.f14062k = interfaceC3912a;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f14054c = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f14054c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14052a = getArguments().getInt("layoutResId");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f14053b = null;
        String string = bundle != null ? bundle.getString("currentTabId") : null;
        String str = TextUtils.isEmpty(string) ? "normal" : string;
        View viewInflate = layoutInflater.inflate(this.f14052a, viewGroup, false);
        this.f14055d = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f14055d.setOnItemClickListener(this);
        this.f14056e = viewInflate.findViewById(R.id.emoticonEmptyView);
        this.f14057f = (TextView) viewInflate.findViewById(R.id.emoticonEmptyTextView);
        this.f14057f.setText(R.string.emoticon_recently_used_empty_title);
        this.f14058g = (ImageButton) viewInflate.findViewById(R.id.emoticonRecentTabIndicator);
        if (!C4822an.m18218a()) {
            this.f14058g.setEnabled(false);
            this.f14058g.setBackgroundResource(R.drawable.chat_anicon_btn_disable);
            this.f14058g.setImageResource(R.drawable.chat_anicon_btn_recent_disable);
        } else {
            this.f14058g.setEnabled(true);
            this.f14058g.setImageResource(R.drawable.chat_anicon_btn_recent);
        }
        this.f14058g.setOnClickListener(this);
        this.f14059h = viewInflate.findViewById(R.id.emoticonNormalTabIndicator);
        this.f14059h.setOnClickListener(this);
        m15100a(str);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f14060i = null;
        this.f14061j = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentTabId", this.f14053b);
    }

    /* renamed from: a */
    private ListAdapter m15096a() {
        String[] strArr = new String[1];
        return new C2793e(this.f14054c, C2797i.m11707c());
    }

    /* renamed from: b */
    private ListAdapter m15098b() {
        return new C2795g(this.f14054c, C2797i.m11705a());
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str) && this.f14062k != null) {
            this.f14062k.mo15104a(this, str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f14059h)) {
            m15100a("normal");
        } else if (view.equals(this.f14058g)) {
            m15100a("recent");
        }
    }

    /* renamed from: a */
    public void m15100a(String str) {
        if (TextUtils.isEmpty(this.f14053b) || !this.f14053b.equals(str)) {
            if ("recent".equals(str)) {
                this.f14053b = "recent";
                this.f14058g.setSelected(true);
                this.f14059h.setSelected(false);
                if (this.f14060i == null) {
                    this.f14060i = m15098b();
                }
                if (this.f14060i.isEmpty()) {
                    this.f14056e.setVisibility(0);
                    this.f14055d.setVisibility(8);
                } else {
                    this.f14056e.setVisibility(8);
                    this.f14055d.setVisibility(0);
                }
                this.f14055d.setAdapter(this.f14060i);
                return;
            }
            if ("normal".equals(str)) {
                this.f14053b = "normal";
                this.f14058g.setSelected(false);
                this.f14059h.setSelected(true);
                if (this.f14061j == null) {
                    this.f14061j = m15096a();
                }
                this.f14056e.setVisibility(8);
                this.f14055d.setVisibility(0);
                this.f14055d.setAdapter(this.f14061j);
            }
        }
    }
}
