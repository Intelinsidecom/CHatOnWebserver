package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.method.HideReturnsTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p109f.C3852b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class SlideView extends LinearLayout implements InterfaceC4091a {

    /* renamed from: q */
    private static final int f15129q = C4149cd.m16426c();

    /* renamed from: r */
    private static final int f15130r = C4149cd.m16426c() / 2;

    /* renamed from: a */
    MediaPlayer.OnPreparedListener f15131a;

    /* renamed from: b */
    private View f15132b;

    /* renamed from: c */
    private ImageView f15133c;

    /* renamed from: d */
    private VideoView f15134d;

    /* renamed from: e */
    private ScrollView f15135e;

    /* renamed from: f */
    private TextView f15136f;

    /* renamed from: g */
    private InterfaceC4118b f15137g;

    /* renamed from: h */
    private MediaPlayer f15138h;

    /* renamed from: i */
    private boolean f15139i;

    /* renamed from: j */
    private boolean f15140j;

    /* renamed from: k */
    private int f15141k;

    /* renamed from: l */
    private boolean f15142l;

    /* renamed from: m */
    private ScrollView f15143m;

    /* renamed from: n */
    private LinearLayout f15144n;

    /* renamed from: o */
    private boolean f15145o;

    /* renamed from: p */
    private MediaController f15146p;

    public SlideView(Context context) {
        super(context);
        this.f15131a = new C4310ic(this);
    }

    public SlideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15131a = new C4310ic(this);
    }

    /* renamed from: a */
    public LinearLayout.LayoutParams m16219a(int i, int i2) {
        float f = i / i2;
        if (i < i2) {
            if (i2 < f15130r) {
                i2 = f15130r;
                i = (int) (f * i2);
            } else if (i2 > f15129q) {
                i2 = f15129q;
                i = (int) (f * i2);
            } else if (i < f15130r) {
                if (((int) (f15130r / f)) < f15129q) {
                    i = f15130r;
                    i2 = (int) (i / f);
                } else {
                    i2 = f15129q;
                    i = (int) (f * i2);
                }
            }
        } else if (i < f15130r) {
            i = f15130r;
            i2 = (int) (i / f);
        } else if (i2 > f15129q) {
            i = f15129q;
            i2 = (int) (i / f);
        } else if (i2 < f15130r) {
            if (((int) (f15130r * f)) < f15129q) {
                i2 = f15130r;
                i = (int) (f * i2);
            } else {
                i = f15129q;
                i2 = (int) (i / f);
            }
        }
        return new LinearLayout.LayoutParams(i, i2);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImage(String str, Bitmap bitmap) {
        if (this.f15133c == null) {
            this.f15133c = new ImageView(this.mContext);
            this.f15133c.setPadding(5, 5, 5, 5);
            addView(this.f15133c, new LinearLayout.LayoutParams(-2, -2));
        }
        if (bitmap == null) {
            try {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_missing_thumbnail_picture);
            } catch (OutOfMemoryError e) {
                C3890m.m14995a("SlideView", "setImage: out of memory: ", e);
                return;
            }
        }
        this.f15133c.setVisibility(0);
        this.f15133c.setImageBitmap(bitmap);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4091a
    public void setImageRegion(int i, int i2, int i3, int i4) {
        if (this.f15133c != null) {
            this.f15133c.setLayoutParams(m16219a(this.f15133c.getDrawable().getIntrinsicWidth(), this.f15133c.getDrawable().getIntrinsicHeight()));
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageRegionFit(String str) {
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideo(String str, Uri uri) {
        if (this.f15134d == null) {
            this.f15134d = new VideoView(this.mContext);
            addView(this.f15134d, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f15134d.setVisibility(0);
        this.f15134d.setVideoURI(uri);
    }

    public void setMediaController(MediaController mediaController) {
        this.f15146p = mediaController;
    }

    /* renamed from: a */
    private void m16207a(String str) {
        if (this.f15132b == null) {
            this.f15132b = LayoutInflater.from(getContext()).inflate(R.layout.playing_audio_info, (ViewGroup) null);
            if (this.f15145o) {
                this.f15144n.addView(this.f15132b, new LinearLayout.LayoutParams(-1, 82));
            } else {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 82);
                layoutParams.gravity = 16;
                addView(this.f15132b, layoutParams);
            }
        }
        ((TextView) this.f15132b.findViewById(R.id.name)).setText(str);
        this.f15132b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m16217h() {
        if (this.f15132b != null) {
            this.f15132b.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m16218i() {
        if (this.f15132b != null) {
            this.f15132b.setVisibility(8);
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setAudio(Uri uri, String str, Map<String, ?> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (uri == null) {
            throw new IllegalArgumentException("Audio URI may not be null.");
        }
        if (this.f15138h != null) {
            this.f15138h.reset();
            this.f15138h.release();
            this.f15138h = null;
        }
        this.f15139i = false;
        this.f15140j = false;
        this.f15141k = 0;
        this.f15142l = false;
        try {
            this.f15138h = new MediaPlayer();
            this.f15138h.setOnPreparedListener(this.f15131a);
            this.f15138h.setDataSource(this.mContext, uri);
            this.f15138h.prepareAsync();
        } catch (IOException e) {
            C3890m.m14995a("SlideView", "Unexpected IOException.", e);
            this.f15138h.release();
            this.f15138h = null;
        }
        m16207a(str);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setText(String str, String str2) {
        if (!this.f15145o) {
            if (this.f15135e == null) {
                this.f15135e = new ScrollView(this.mContext);
                this.f15135e.setScrollBarStyle(50331648);
                addView(this.f15135e, new LinearLayout.LayoutParams(-2, -2));
            }
            if (this.f15136f == null) {
                this.f15136f = new TextView(this.mContext);
                this.f15136f.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                this.f15135e.addView(this.f15136f);
            }
            this.f15135e.requestFocus();
        }
        this.f15136f.setVisibility(0);
        this.f15136f.setText(str2);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4091a
    public void setTextRegion(int i, int i2, int i3, int i4) {
        if (this.f15135e != null && !this.f15145o) {
            this.f15135e.setLayoutParams(new LinearLayout.LayoutParams(i3, i4));
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4091a
    public void setVideoRegion(int i, int i2, int i3, int i4) {
        if (this.f15134d != null && !this.f15145o) {
            this.f15134d.setLayoutParams(new LinearLayout.LayoutParams(i3, i4));
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setImageVisibility(boolean z) {
        if (this.f15133c != null) {
            if (this.f15145o) {
                this.f15133c.setVisibility(z ? 0 : 8);
            } else {
                this.f15133c.setVisibility(z ? 0 : 4);
            }
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setTextVisibility(boolean z) {
        if (this.f15145o) {
            if (this.f15136f != null) {
                this.f15136f.setVisibility(z ? 0 : 8);
            }
        } else if (this.f15135e != null) {
            this.f15135e.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setVideoVisibility(boolean z) {
        if (this.f15134d != null) {
            if (this.f15145o) {
                this.f15134d.setVisibility(z ? 0 : 8);
            } else {
                this.f15134d.setVisibility(z ? 0 : 4);
            }
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: a */
    public void mo15728a() throws IllegalStateException {
        if (this.f15138h != null && this.f15139i) {
            this.f15138h.start();
            this.f15140j = false;
            m16217h();
            return;
        }
        this.f15140j = true;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: c */
    public void mo15732c() throws IllegalStateException {
        if (this.f15138h != null && this.f15139i) {
            this.f15138h.stop();
            this.f15138h.release();
            this.f15138h = null;
            m16218i();
            return;
        }
        this.f15142l = true;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: f */
    public void mo15735f() throws IllegalStateException {
        if (this.f15138h != null && this.f15139i && this.f15138h.isPlaying()) {
            this.f15138h.pause();
        }
        this.f15140j = false;
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: a */
    public void mo15729a(int i) throws IllegalStateException {
        if (this.f15138h != null && this.f15139i) {
            this.f15138h.seekTo(i);
        } else {
            this.f15141k = i;
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: b */
    public void mo15730b() {
        if (this.f15134d != null) {
            this.f15134d.start();
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: d */
    public void mo15733d() {
        if (this.f15134d != null) {
            this.f15134d.stopPlayback();
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: g */
    public void mo15736g() {
        if (this.f15134d != null) {
            this.f15134d.pause();
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    /* renamed from: b */
    public void mo15731b(int i) {
        if (this.f15134d != null && i > 0) {
            this.f15134d.seekTo(i);
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4343ji
    /* renamed from: e */
    public void mo15734e() throws IllegalStateException {
        if (this.f15135e != null) {
            this.f15135e.setVisibility(8);
        }
        if (this.f15133c != null) {
            this.f15133c.setVisibility(8);
        }
        if (this.f15138h != null) {
            mo15732c();
        }
        if (this.f15134d != null) {
            mo15733d();
            this.f15134d.setVisibility(8);
        }
        if (this.f15136f != null) {
            this.f15136f.setVisibility(8);
        }
        if (this.f15143m != null) {
            this.f15143m.scrollTo(0, 0);
            this.f15143m.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public void setVisibility(boolean z) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f15137g != null) {
            this.f15137g.mo16341a(i, i2 - 82);
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4091a
    public void setOnSizeChangedListener(InterfaceC4118b interfaceC4118b) {
        this.f15137g = interfaceC4118b;
    }

    /* renamed from: a */
    public void m16220a(int i, int i2, int i3, int i4) {
        this.f15145o = true;
        if (this.f15143m == null) {
            this.f15143m = new C4311id(this, this.mContext);
            this.f15143m.setScrollBarStyle(50331648);
            this.f15144n = new LinearLayout(this.mContext);
            this.f15144n.setOrientation(1);
            this.f15144n.setGravity(17);
            this.f15144n.setOnClickListener(new ViewOnClickListenerC4312ie(this));
            this.f15143m.addView(this.f15144n, new FrameLayout.LayoutParams(-1, -2));
            addView(this.f15143m);
        }
        TreeMap treeMap = new TreeMap(new C4313if(this));
        if (i >= 0 && i2 >= 0) {
            this.f15136f = new TextView(this.mContext);
            this.f15136f.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.f15136f.setTextSize(18.0f);
            this.f15136f.setPadding(5, 5, 5, 5);
            treeMap.put(new C4314ig(this, i, i2), this.f15136f);
        }
        if (i3 >= 0 && i4 >= 0) {
            this.f15133c = new ImageView(this.mContext);
            this.f15133c.setPadding(0, 5, 0, 5);
            treeMap.put(new C4314ig(this, i3, i4), this.f15133c);
            this.f15134d = new VideoView(this.mContext);
            treeMap.put(new C4314ig(this, i3 + 1, i4), this.f15134d);
        }
        for (View view : treeMap.values()) {
            if (view instanceof VideoView) {
                this.f15144n.addView(view, new LinearLayout.LayoutParams(-1, C3852b.m14736a().m14740b().mo14733b()));
            } else {
                this.f15144n.addView(view, new LinearLayout.LayoutParams(-1, -2));
            }
            view.setVisibility(8);
        }
    }

    @Override // com.sec.chaton.smsplugin.p112ui.InterfaceC4315ih
    public void setRawAttachment(String str) {
    }

    public void setRawAttachmentVisibility(boolean z) {
    }
}
