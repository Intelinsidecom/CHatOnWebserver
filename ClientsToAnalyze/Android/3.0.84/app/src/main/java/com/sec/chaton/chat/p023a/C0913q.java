package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.os.Environment;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.doc.EnumC1794a;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import java.util.HashMap;

/* compiled from: DocumentBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.q */
/* loaded from: classes.dex */
public class C0913q extends AbstractC0894af {

    /* renamed from: F */
    public static HashMap<EnumC1794a, Integer> f3843F = new HashMap<>();

    static {
        f3843F.put(EnumC1794a.DOC, Integer.valueOf(R.drawable.co_attach_file_word));
        f3843F.put(EnumC1794a.GUL, Integer.valueOf(R.drawable.co_attach_file_gul));
        f3843F.put(EnumC1794a.HWP, Integer.valueOf(R.drawable.co_attach_file_hwp));
        f3843F.put(EnumC1794a.PDF, Integer.valueOf(R.drawable.co_attach_file_pdf));
        f3843F.put(EnumC1794a.PPT, Integer.valueOf(R.drawable.co_attach_file_ppt));
        f3843F.put(EnumC1794a.XLS, Integer.valueOf(R.drawable.co_attach_file_excel));
        f3843F.put(EnumC1794a.TXT, Integer.valueOf(R.drawable.co_attach_file_text));
        f3843F.put(EnumC1794a.SNB, Integer.valueOf(R.drawable.co_attach_p_s_note_normal));
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a */
    public String mo5092a(Context context) {
        return context.getString(R.string.menu_multimedia_files);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: c */
    protected String mo5103c() {
        return null;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    protected void mo5087a() {
        super.mo5087a();
        EnumC1794a enumC1794a = EnumC1794a.DOC;
        EnumC1794a enumC1794aM7386c = FileExplorerActivity.m7386c(this.f3810x);
        if (m5123n()) {
            this.f3794h.f4229R.setImageResource(m5113a(enumC1794aM7386c));
            this.f3794h.f4228Q.setVisibility(0);
            this.f3794h.f4229R.setOnClickListener(this);
            this.f3794h.f4230S.setText(this.f3810x);
            this.f3794h.f4230S.setVisibility(0);
            this.f3794h.f4229R.setVisibility(0);
            return;
        }
        this.f3794h.f4293w.setImageResource(m5113a(enumC1794aM7386c));
        this.f3794h.f4292v.setVisibility(0);
        this.f3794h.f4293w.setOnClickListener(this);
        this.f3794h.f4294x.setText(this.f3810x);
        this.f3794h.f4294x.setVisibility(0);
        this.f3794h.f4293w.setVisibility(0);
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) {
        super.mo5090a(z);
        if (m5123n()) {
            this.f3794h.f4228Q.setVisibility(8);
            this.f3794h.f4229R.setOnClickListener(null);
        } else {
            this.f3794h.f4292v.setVisibility(8);
            this.f3794h.f4293w.setOnClickListener(null);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f3791e.isClosed()) {
            if ((view == this.f3794h.f4229R || view == this.f3794h.f4293w) && this.f3791e.moveToPosition(this.f3792f)) {
                this.f3797k.mo5002e(m5123n(), this.f3791e, this.f3794h.f4238a);
            }
        }
    }

    /* renamed from: a */
    private int m5113a(EnumC1794a enumC1794a) {
        return f3843F.containsKey(enumC1794a) ? f3843F.get(enumC1794a).intValue() : f3843F.get(EnumC1794a.TXT).intValue();
    }

    @Override // com.sec.chaton.chat.p023a.AbstractC0894af, com.sec.chaton.chat.p023a.InterfaceC0911o
    /* renamed from: k */
    public boolean mo5102k() {
        return mo5096g();
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: l */
    public String mo5107l() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON/Documents/";
    }
}
