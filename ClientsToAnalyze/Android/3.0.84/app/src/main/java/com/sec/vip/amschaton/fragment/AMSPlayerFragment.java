package com.sec.vip.amschaton.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.C2555av;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.vip.amschaton.RunnableC3442bq;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class AMSPlayerFragment extends AMSViewerFragment {

    /* renamed from: S */
    private Activity f12745S;

    @Override // com.sec.vip.amschaton.fragment.AMSViewerFragment, com.sec.vip.amschaton.fragment.AMSFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        BaseActivity.m3081a(this, true);
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12745S = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12745S = null;
    }

    @Override // com.sec.vip.amschaton.fragment.AMSViewerFragment
    /* renamed from: a */
    protected View mo12582a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.layout_ams_player, viewGroup, false);
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
        this.f12774G = (LinearLayout) view.findViewById(R.id.layout_status);
        if (!this.f12781N) {
            m12698a(false);
        }
        this.f12810z = (SeekBar) view.findViewById(R.id.progressbar);
        this.f12810z.setOnTouchListener(new ViewOnTouchListenerC3503bx(this));
        this.f12810z.setMax(RunnableC3442bq.f12592a);
        this.f12810z.setProgress(0);
        m12702c(true);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f12807w && !this.f12803s) {
            menuInflater.inflate(R.menu.ams_list_menu, menu);
            menu.findItem(R.id.ams_download).setVisible(false);
            if (this.f12795b != null) {
                if ((this.f12795b.m12336g() & 1) == 1) {
                    menu.findItem(R.id.ams_delete).setEnabled(false);
                } else {
                    menu.findItem(R.id.ams_delete).setEnabled(true);
                }
                C3228cp.m11343a(menu.findItem(R.id.ams_delete));
            }
        } else {
            menuInflater.inflate(R.menu.image_pager_menu, menu);
            menu.findItem(R.id.menu_share).setVisible(false);
            if (this.f12795b != null) {
                if ((this.f12795b.m12336g() & 1) == 1) {
                    menu.findItem(R.id.menu_save).setEnabled(false);
                } else {
                    menu.findItem(R.id.menu_save).setEnabled(true);
                }
                C3228cp.m11343a(menu.findItem(R.id.menu_save));
            }
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        switch (menuItem.getItemId()) {
            case R.id.ams_delete /* 2131166575 */:
                if (this.f12808x != null) {
                    C2555av.m9492d(this.f12745S).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3504by(this)).mo11512b();
                    break;
                }
                break;
            case R.id.menu_save /* 2131166578 */:
                String strF = m12704f();
                if (this.f12807w && strF != null && strF.length() > 0 && this.f12808x != null) {
                    try {
                        C2642q.m9634a(getActivity(), EnumC1327e.Template, this.f12808x, new File(strF));
                    } catch (IOException e) {
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e, getClass().getName());
                        }
                    }
                }
                mo12415c();
                break;
        }
        return false;
    }
}
