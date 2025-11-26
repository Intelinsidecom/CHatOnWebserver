package com.sec.chaton.settings;

import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1739av;
import com.sec.chaton.util.C1767bw;
import com.sec.widget.C2153y;
import java.io.IOException;

/* compiled from: FragmentSkinChange2.java */
/* renamed from: com.sec.chaton.settings.ck */
/* loaded from: classes.dex */
class ViewOnClickListenerC1286ck implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange2 f4832a;

    ViewOnClickListenerC1286ck(FragmentSkinChange2 fragmentSkinChange2) {
        this.f4832a = fragmentSkinChange2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        String string = view.getTag().toString();
        if (string.equals("skin_add")) {
            if (!C1739av.m5927a()) {
                if (!C1767bw.m6002a() || this.f4832a.f4646B == null) {
                    if (this.f4832a.f4653K == null) {
                        this.f4832a.f4653K = C2153y.m7536a(this.f4832a.getActivity(), this.f4832a.getString(R.string.toast_sdcard_amount), 1);
                    }
                    this.f4832a.f4653K.show();
                } else {
                    this.f4832a.m4636a(this.f4832a.f4646B);
                }
            } else {
                return;
            }
        } else {
            if (string.equals("skin_myskin.png_")) {
                this.f4832a.f4672j = string;
                this.f4832a.f4673k = ((C1289cn) this.f4832a.f4659Q.get(this.f4832a.f4672j)).f4836b;
                this.f4832a.f4676n.setImageResource(android.R.color.transparent);
                this.f4832a.m4653n();
            } else {
                C1289cn c1289cn = (C1289cn) this.f4832a.f4659Q.get(string);
                if (c1289cn.f4837c != null && c1289cn.f4838d != null) {
                    this.f4832a.f4672j = string;
                    this.f4832a.f4673k = c1289cn.f4836b;
                    this.f4832a.f4676n.setImageResource(android.R.color.transparent);
                    if (!c1289cn.f4836b.equals("pa")) {
                        this.f4832a.f4676n.setImageBitmap(c1289cn.f4838d);
                    } else {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(c1289cn.f4838d);
                        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        this.f4832a.f4676n.setBackgroundDrawable(bitmapDrawable);
                    }
                } else {
                    return;
                }
            }
            if (this.f4832a.f4682t != null) {
                this.f4832a.f4682t.setSelection(view.getTag().toString());
            }
        }
        if (this.f4832a.f4679q.equals(this.f4832a.f4672j)) {
            if (this.f4832a.f4657O != null) {
                this.f4832a.f4657O.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                this.f4832a.f4657O.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
            }
        } else if (this.f4832a.f4657O != null) {
            this.f4832a.f4657O.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            this.f4832a.f4657O.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        }
        if (this.f4832a.f4658P) {
            this.f4832a.f4657O.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            this.f4832a.f4657O.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        }
    }
}
