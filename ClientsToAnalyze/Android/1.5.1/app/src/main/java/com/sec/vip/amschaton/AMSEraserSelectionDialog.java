package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.sec.chaton.C0062R;

/* loaded from: classes.dex */
public class AMSEraserSelectionDialog extends AMSToolSelectionDialog {

    /* renamed from: f */
    private int f3915f;

    /* renamed from: g */
    private SeekBar f3916g;

    /* renamed from: h */
    private ImageView f3917h;

    public AMSEraserSelectionDialog(Context context, int i) {
        super(context, i);
        this.f3915f = 0;
        this.f3916g = null;
        this.f3917h = null;
        setContentView(C0062R.layout.ams_eraser_selection_layout);
        this.f3916g = (SeekBar) findViewById(C0062R.id.seekbar_eraser_size);
        this.f3916g.setOnSeekBarChangeListener(new C0664bk(this));
        this.f3917h = (ImageView) findViewById(C0062R.id.image_eraser_preview);
        m3870b(this.f3915f);
        ((Button) findViewById(C0062R.id.btn_ok)).setOnClickListener(this);
        ((Button) findViewById(C0062R.id.btn_cancel)).setOnClickListener(this);
        m3869b();
    }

    /* renamed from: b */
    private void m3869b() {
        int i = this.f3915f;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (this.f4083c * 88.0f), (int) (this.f4083c * 88.0f), Bitmap.Config.ARGB_8888);
        AMSObjectDrawings aMSObjectDrawings = new AMSObjectDrawings(1, -1, 2);
        aMSObjectDrawings.mo3954a(this.f4083c * 2.0f);
        aMSObjectDrawings.m3957a(bitmapCreateBitmap);
        aMSObjectDrawings.mo3963a((float) ((bitmapCreateBitmap.getWidth() * 0.5d) - ((i + 1) * this.f4083c)), (float) ((bitmapCreateBitmap.getHeight() * 0.5d) - ((i + 1) * this.f4083c)), (float) ((bitmapCreateBitmap.getWidth() * 0.5d) + ((i + 1) * this.f4083c)), (float) (((i + 1) * this.f4083c) + (bitmapCreateBitmap.getHeight() * 0.5d)), 255);
        this.f3917h.setImageBitmap(bitmapCreateBitmap);
    }

    /* renamed from: b */
    private void m3870b(int i) {
        int i2 = i * 2;
        SeekBar seekBar = this.f3916g;
        if (i2 >= 72) {
            i2 = 72;
        }
        seekBar.setProgress(i2);
    }

    /* renamed from: a */
    public int m3871a() {
        return this.f3915f + 1;
    }

    /* renamed from: a */
    public void m3872a(int i) {
        int i2 = i < 1 ? 1 : i;
        if (i2 >= 72) {
            i2 = 72;
        }
        this.f3915f = i2 - 1;
        m3870b(this.f3915f);
        m3869b();
    }
}
