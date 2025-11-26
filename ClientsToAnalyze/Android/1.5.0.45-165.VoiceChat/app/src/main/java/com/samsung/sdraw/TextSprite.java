package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class TextSprite extends AbstractSprite {

    /* renamed from: d */
    public PointF f1359d = new PointF();

    /* renamed from: e */
    public RectF f1360e;

    /* renamed from: f */
    private Data f1361f;

    /* renamed from: g */
    private TextPaint f1362g;

    public static class Data {
        public DynamicLayout layout;
        public Editable text;
    }

    public TextSprite(Context context) {
    }

    @Override // com.samsung.sdraw.InterfaceC1008au
    /* renamed from: a */
    public RectF mo1136a() {
        this.f831b = new RectF(this.f1360e);
        this.f831b.offset(this.f1359d.x, this.f1359d.y);
        return this.f831b;
    }

    /* renamed from: b */
    public int m1195b() {
        Editable editable = this.f1361f.text;
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable.getSpans(0, editable.nextSpanTransition(0, editable.length(), ForegroundColorSpan.class), ForegroundColorSpan.class);
        return foregroundColorSpanArr.length <= 0 ? Setting.f1239k : foregroundColorSpanArr[0].getForegroundColor();
    }

    /* renamed from: c */
    public Layout m1196c() {
        return this.f1361f.layout;
    }

    /* renamed from: d */
    public int m1197d() {
        Editable editable = this.f1361f.text;
        return ((AbsoluteSizeSpan[]) editable.getSpans(0, editable.nextSpanTransition(0, editable.length(), AbsoluteSizeSpan.class), AbsoluteSizeSpan.class))[0].getSize() / 4;
    }

    /* renamed from: e */
    public int m1198e() {
        Editable editable = this.f1361f.text;
        StyleSpan[] styleSpanArr = (StyleSpan[]) editable.getSpans(0, editable.nextSpanTransition(0, editable.length(), StyleSpan.class), StyleSpan.class);
        int i = 0;
        for (int i2 = 0; i2 < styleSpanArr.length; i2++) {
            if (styleSpanArr[i2].getStyle() == 1) {
                i++;
            }
            if (styleSpanArr[i2].getStyle() == 2) {
                i += 2;
            }
        }
        if (((UnderlineSpan[]) editable.getSpans(0, editable.nextSpanTransition(0, editable.length(), UnderlineSpan.class), UnderlineSpan.class)).length > 0) {
            return i + 4;
        }
        return i;
    }

    /* renamed from: f */
    public Layout.Alignment m1199f() {
        return this.f1361f.layout.getAlignment();
    }

    /* renamed from: g */
    public String m1200g() {
        Editable editable = this.f1361f.text;
        C1040bz[] c1040bzArr = (C1040bz[]) editable.getSpans(0, editable.nextSpanTransition(0, editable.length(), C1040bz.class), C1040bz.class);
        return c1040bzArr.length < 1 ? Setting.f1240l : c1040bzArr[c1040bzArr.length - 1].getFamily();
    }

    /* renamed from: h */
    public Editable m1201h() {
        return this.f1361f.text;
    }

    /* renamed from: k */
    private void m1191k() {
        this.f1362g = new TextPaint();
        this.f1362g.setAntiAlias(true);
        this.f1362g.measureText(SimpleUserInfo.TYPE_HOST);
    }

    /* renamed from: b */
    private void m1189b(Editable editable, int i, int i2, Layout.Alignment alignment) {
        int desiredWidth = i == -1 ? (int) DynamicLayout.getDesiredWidth(editable, this.f1362g) : i;
        if (desiredWidth < 0) {
            desiredWidth = (int) DynamicLayout.getDesiredWidth(editable, this.f1362g);
        }
        this.f1361f = new Data();
        this.f1361f.text = editable;
        this.f1361f.layout = new DynamicLayout(editable, this.f1362g, desiredWidth, alignment, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
        this.f1360e = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, desiredWidth, i2);
        setLayerID(4);
        mo1136a();
    }

    /* renamed from: b */
    private void m1190b(Editable editable, int i, int i2, Layout.Alignment alignment, int i3) {
        int desiredWidth = i == -1 ? (int) DynamicLayout.getDesiredWidth(editable, this.f1362g) : i;
        if (desiredWidth < 0) {
            desiredWidth = (int) DynamicLayout.getDesiredWidth(editable, this.f1362g);
        }
        this.f1361f = new Data();
        this.f1361f.text = editable;
        this.f1361f.layout = new DynamicLayout(editable, this.f1362g, desiredWidth, alignment, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
        if (i3 != -1) {
            setLayerID(i3);
        }
        this.f1360e = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, desiredWidth, i2);
        mo1136a();
    }

    /* renamed from: a */
    public void m1192a(Editable editable, int i, int i2, Layout.Alignment alignment) {
        m1191k();
        m1189b(editable, i, i2, alignment);
    }

    /* renamed from: a */
    public void m1193a(Editable editable, int i, int i2, Layout.Alignment alignment, int i3) {
        m1191k();
        m1190b(editable, i, i2, alignment, i3);
    }

    /* renamed from: a */
    public void m1194a(Editable editable, PointF pointF, int i, int i2, Layout.Alignment alignment) {
        int desiredWidth = i == -1 ? (int) DynamicLayout.getDesiredWidth(editable, this.f1362g) : i;
        this.f1359d = pointF;
        m1190b(editable, desiredWidth, i2, alignment, -1);
    }

    @Override // com.samsung.sdraw.InterfaceC1008au
    /* renamed from: a */
    public void mo1139a(Canvas canvas, RectF rectF) {
        if (isHitted(rectF) && this.f830a) {
            canvas.save();
            canvas.translate(this.f1359d.x, this.f1359d.y);
            this.f1361f.layout.draw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: i */
    public RectF m1202i() {
        return mo1136a();
    }

    /* renamed from: j */
    public TextInfo m1203j() {
        TextInfo textInfo = new TextInfo(m1195b(), m1197d(), m1201h().toString(), m1202i(), m1198e(), m1199f(), m1200g(), getLayerID());
        textInfo.setID(this.objectID);
        textInfo.setMultiUserID(this.multiUserID);
        textInfo.setMultiObjectID(this.multiObjectID);
        return textInfo;
    }

    @Override // com.samsung.sdraw.AbstractSprite
    public void dispose() {
        this.f1361f.layout = null;
        this.f1361f.text.clear();
        this.f1361f.text = null;
    }

    @Override // com.samsung.sdraw.AbstractSprite
    public StringBuilder toXML() {
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[15];
        objArr[0] = Integer.valueOf((int) this.f831b.left);
        objArr[1] = Integer.valueOf((int) this.f831b.top);
        objArr[2] = Integer.valueOf((int) this.f831b.right);
        objArr[3] = Integer.valueOf((int) this.f831b.bottom);
        objArr[4] = Integer.valueOf(m1197d());
        objArr[5] = Integer.valueOf(m1195b());
        objArr[6] = Integer.valueOf(this.f830a ? 1 : 0);
        objArr[7] = m1188a(m1201h().toString());
        objArr[8] = Integer.valueOf(this.objectID);
        objArr[9] = Integer.valueOf(m1198e());
        objArr[10] = m1200g();
        objArr[11] = m1188a(m1199f().toString());
        objArr[12] = Integer.valueOf(getLayerID());
        objArr[13] = Integer.valueOf(this.multiUserID);
        objArr[14] = Integer.valueOf(this.multiObjectID);
        sb.append(String.format("<text rect=\"%d,%d,%d,%d\" size=\"%d\" color=\"#%08x\" visible=\"%d\" text=\"%s\" id=\"%d\" style=\"%d\" font=\"%s\" alignment=\"%s\" layerID=\"%d\" userID=\"%d\" textID=\"%d\"/>", objArr));
        return sb;
    }

    @Override // com.samsung.sdraw.AbstractSprite, com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(PointF point) {
        return false;
    }

    /* renamed from: a */
    private static String m1188a(String str) {
        if (str != null) {
            return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        }
        return str;
    }
}
