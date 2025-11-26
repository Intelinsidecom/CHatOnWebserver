package com.sec.chaton.settings;

import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.settings.p096a.C3481y;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.widget.C5179v;
import java.io.IOException;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.ew */
/* loaded from: classes.dex */
class C3613ew implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f13146a;

    C3613ew(FragmentSkinChange3 fragmentSkinChange3) {
        this.f13146a = fragmentSkinChange3;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws IOException {
        Drawable drawableM13838g;
        C3481y c3481yM13837f;
        C3623ff c3623ff = (C3623ff) view.getTag();
        if (c3623ff != null) {
            if ((this.f13146a.f12772u != FragmentSkinChange3.f12733a || !this.f13146a.f12764m.equals(c3623ff.f13162a)) && ((this.f13146a.f12772u != FragmentSkinChange3.f12734b || !this.f13146a.f12765n.equals(c3623ff.f13162a)) && (this.f13146a.f12772u != FragmentSkinChange3.f12735c || !this.f13146a.f12762k.equals(c3623ff.f13163b)))) {
                if (this.f13146a.f12772u != FragmentSkinChange3.f12735c) {
                    if (this.f13146a.f12772u != FragmentSkinChange3.f12734b) {
                        if (this.f13146a.f12772u == FragmentSkinChange3.f12733a && (drawableM13838g = C3474r.m13838g(this.f13146a.getActivity(), c3623ff.f13162a)) != null) {
                            this.f13146a.f12767p.setBackgroundDrawable(drawableM13838g.getConstantState().newDrawable());
                            if (this.f13146a.f12774w == null) {
                                this.f13146a.m13637b(c3623ff.f13162a, c3623ff.f13165d, c3623ff.f13164c);
                                return;
                            } else {
                                this.f13146a.m13634a(c3623ff.f13162a, c3623ff.f13165d, c3623ff.f13164c);
                                return;
                            }
                        }
                        return;
                    }
                    Drawable drawableM13840i = C3474r.m13840i(this.f13146a.getActivity(), c3623ff.f13162a);
                    if (drawableM13840i != null) {
                        this.f13146a.f12768q.setBackgroundDrawable(drawableM13840i.getConstantState().newDrawable());
                        if (this.f13146a.f12774w == null) {
                            this.f13146a.m13637b(c3623ff.f13162a, c3623ff.f13165d, c3623ff.f13164c);
                            return;
                        } else {
                            this.f13146a.m13634a(c3623ff.f13162a, c3623ff.f13165d, c3623ff.f13164c);
                            return;
                        }
                    }
                    return;
                }
                if (c3623ff.f13163b.equals("skin_add")) {
                    if (!C4847bl.m18333a()) {
                        if (!C4873ck.m18500a() || this.f13146a.f12740E == null) {
                            if (this.f13146a.f12747L == null) {
                                this.f13146a.f12747L = C5179v.m19811a(this.f13146a.getActivity(), this.f13146a.getString(R.string.sdcard_not_found), 1);
                            }
                            this.f13146a.f12747L.show();
                            return;
                        }
                        this.f13146a.m13609a(this.f13146a.f12740E);
                        return;
                    }
                    return;
                }
                if (c3623ff.f13163b.equals("skin_myskin.png_")) {
                    this.f13146a.m13625k();
                    if (this.f13146a.f12774w == null) {
                        this.f13146a.m13637b(c3623ff.f13163b, c3623ff.f13165d, c3623ff.f13164c);
                        return;
                    } else {
                        this.f13146a.m13634a(c3623ff.f13163b, c3623ff.f13165d, c3623ff.f13164c);
                        return;
                    }
                }
                if (EnumC2258bd.Skin.m10123a().equals(c3623ff.f13165d)) {
                    c3481yM13837f = C3474r.m13836f(this.f13146a.getActivity(), c3623ff.f13163b);
                } else {
                    c3481yM13837f = C3474r.m13837f(this.f13146a.getActivity(), c3623ff.f13163b, true);
                }
                if (c3481yM13837f != null) {
                    if (c3623ff.f13164c.equals("pa")) {
                        this.f13146a.f12754S = new BitmapDrawable(c3481yM13837f.f12970b);
                        this.f13146a.f12754S.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                        this.f13146a.f12766o.setImageBitmap(null);
                        this.f13146a.f12766o.setBackgroundDrawable(this.f13146a.f12754S);
                    } else {
                        this.f13146a.f12766o.setImageBitmap(c3481yM13837f.f12970b);
                    }
                    if (this.f13146a.f12774w == null) {
                        this.f13146a.m13637b(c3623ff.f13163b, c3623ff.f13165d, c3623ff.f13164c);
                        return;
                    } else {
                        this.f13146a.m13634a(c3623ff.f13163b, c3623ff.f13165d, c3623ff.f13164c);
                        return;
                    }
                }
                return;
            }
            if (this.f13146a.f12748M != null) {
                this.f13146a.f12748M.cancel();
            }
            this.f13146a.f12748M = C5179v.m19810a(this.f13146a.getActivity(), R.string.ams_msg_already_saved, 0);
            this.f13146a.f12748M.show();
        }
    }
}
