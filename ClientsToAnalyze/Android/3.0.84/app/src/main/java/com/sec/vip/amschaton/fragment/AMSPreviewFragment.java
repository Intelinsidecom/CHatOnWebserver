package com.sec.vip.amschaton.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;
import com.sec.vip.amschaton.BaseAMSActivity;
import com.sec.vip.amschaton.C3584q;
import com.sec.vip.amschaton.RunnableC3442bq;

/* loaded from: classes.dex */
public class AMSPreviewFragment extends AMSViewerFragment implements View.OnClickListener {
    @Override // com.sec.vip.amschaton.fragment.AMSViewerFragment
    /* renamed from: a */
    protected View mo12582a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.layout_ams_preview, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        getActivity().setTitle(R.string.media_animessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        boolean zA;
        switch (view.getId()) {
            case R.id.btn_edit /* 2131165470 */:
                m12527a(this.f12797m, true, true, true, false);
                break;
            case R.id.btn_delete /* 2131165818 */:
                if (this.f12799o == 2002) {
                    zA = C3584q.m12778a().m12796a(getActivity(), this.f12797m);
                } else if (this.f12799o == 2000) {
                    zA = C3584q.m12778a().m12808b(getActivity(), this.f12797m);
                } else {
                    zA = m12699a(this.f12797m);
                }
                if (zA) {
                    m12524a(R.string.ams_msg_deleted);
                    this.f12797m = null;
                } else {
                    C3250y.m11442a("Selected item was not deleted!", getClass().getSimpleName());
                }
                mo12415c();
                break;
            case R.id.btn_send /* 2131165819 */:
                if (!C3197bl.m11159a()) {
                    m12705g();
                }
                m12695a();
                break;
        }
    }

    @Override // com.sec.vip.amschaton.fragment.AMSFragment
    /* renamed from: c */
    public void mo12415c() {
        if (getArguments().getInt("AMS_ACTION", -1) == 1) {
            FragmentActivity activity = getActivity();
            if (activity instanceof BaseAMSActivity) {
                Intent intent = new Intent(activity, (Class<?>) BaseAMSActivity.class);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.putExtra("AMS_ACTION", 5);
                ((BaseActivity) activity).mo3084a(intent);
                return;
            }
            return;
        }
        m12527a(this.f12797m, true, true, false, false);
    }

    @Override // com.sec.vip.amschaton.fragment.AMSViewerFragment
    /* renamed from: a */
    protected boolean mo12583a(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_ams);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f12794a, this.f12794a);
        C3250y.m11455d("## mViewerSize = " + this.f12794a, getClass().getName());
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f12796c);
        this.f12773F = (RelativeLayout) view.findViewById(R.id.layout_main_container);
        this.f12773F.setOnClickListener(this.f12784Q);
        this.f12768A = new ImageView(getActivity());
        this.f12768A.setImageResource(R.drawable.chat_btn_ams_play);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f12768A.setLayoutParams(layoutParams2);
        this.f12768A.setOnClickListener(this.f12784Q);
        this.f12769B = view.findViewById(R.id.btn_play_pause);
        this.f12769B.setOnClickListener(this.f12784Q);
        this.f12783P = new RelativeLayout(getActivity());
        this.f12783P.setLayoutParams(new ViewGroup.LayoutParams(this.f12794a, this.f12794a));
        this.f12783P.addView(this.f12768A);
        m12700b(false);
        relativeLayout.addView(this.f12783P);
        this.f12770C = view.findViewById(R.id.btn_delete);
        this.f12771D = view.findViewById(R.id.btn_edit);
        this.f12772E = view.findViewById(R.id.btn_send);
        this.f12770C.setOnClickListener(this);
        this.f12771D.setOnClickListener(this);
        this.f12772E.setOnClickListener(this);
        this.f12775H = (LinearLayout) view.findViewById(R.id.layout_buttons);
        this.f12774G = (LinearLayout) view.findViewById(R.id.layout_status);
        if (!this.f12781N) {
            m12698a(false);
        }
        this.f12810z = (SeekBar) view.findViewById(R.id.progressbar);
        this.f12810z.setOnTouchListener(new ViewOnTouchListenerC3505bz(this));
        this.f12810z.setMax(RunnableC3442bq.f12592a);
        this.f12810z.setProgress(0);
        m12702c(true);
        return true;
    }
}
