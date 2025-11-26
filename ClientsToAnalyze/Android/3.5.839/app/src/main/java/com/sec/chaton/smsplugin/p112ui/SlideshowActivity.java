package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.MediaController;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p104d.C3812a;
import com.sec.chaton.smsplugin.p104d.p106b.RunnableC3832m;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p148a.InterfaceC5239d;
import org.p146b.p147a.p148a.InterfaceC5240e;
import org.p146b.p147a.p149b.InterfaceC5246f;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public class SlideshowActivity extends Activity implements InterfaceC5239d {

    /* renamed from: a */
    private MediaController f15147a;

    /* renamed from: b */
    private RunnableC3832m f15148b;

    /* renamed from: c */
    private Handler f15149c;

    /* renamed from: d */
    private InterfaceC5246f f15150d;

    /* renamed from: e */
    private SlideView f15151e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final boolean m16227b(InterfaceC5246f interfaceC5246f) {
        NodeList childNodes;
        Node nodeItem;
        NodeList childNodes2;
        int length;
        InterfaceC5247g interfaceC5247gMo14528k = interfaceC5246f.mo14528k();
        if (interfaceC5247gMo14528k == null || (childNodes = interfaceC5247gMo14528k.getChildNodes()) == null || childNodes.getLength() != 1 || (nodeItem = childNodes.item(0)) == null || !"layout".equals(nodeItem.getNodeName()) || (childNodes2 = nodeItem.getChildNodes()) == null || (length = childNodes2.getLength()) <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            Node nodeItem2 = childNodes2.item(i);
            if (nodeItem2 == null) {
                return false;
            }
            String nodeName = nodeItem2.getNodeName();
            if (!"root-layout".equals(nodeName)) {
                if (!"region".equals(nodeName)) {
                    return false;
                }
                NamedNodeMap attributes = nodeItem2.getAttributes();
                if (attributes != null) {
                    for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                        Node nodeItem3 = attributes.item(i2);
                        if (nodeItem3 == null) {
                            return false;
                        }
                        String nodeName2 = nodeItem3.getNodeName();
                        if (!"left".equals(nodeName2) && !"top".equals(nodeName2) && !"height".equals(nodeName2) && !"width".equals(nodeName2) && !"fit".equals(nodeName2)) {
                            if (!"id".equals(nodeName2) || !(nodeItem3 instanceof C3812a)) {
                                return false;
                            }
                            String value = ((C3812a) nodeItem3).getValue();
                            if (!"Text".equals(value) && !"Image".equals(value)) {
                                return false;
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15149c = new Handler();
        getWindow().setFormat(-3);
        setContentView(R.layout.slideshow);
        try {
            C3870p c3870pM14881a = C3870p.m14881a(this, getIntent().getData());
            this.f15151e = (SlideView) findViewById(R.id.slide_view);
            C4278gy.m16480a("SlideshowPresenter", this, this.f15151e, c3870pM14881a);
            this.f15149c.post(new RunnableC4316ii(this, c3870pM14881a));
        } catch (C5111c e) {
            C3890m.m14995a("SlideshowActivity", "Cannot present the slide show.", e);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16224a() {
        this.f15147a = new MediaController((Context) this, false);
        this.f15147a.setMediaPlayer(new C4320im(this, this.f15148b));
        this.f15147a.setAnchorView(findViewById(R.id.slide_view));
        this.f15147a.setPrevNextListeners(new ViewOnClickListenerC4317ij(this), new ViewOnClickListenerC4318ik(this));
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f15148b != null && this.f15147a != null) {
            this.f15147a.show();
            return false;
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f15150d != null) {
            ((InterfaceC5240e) this.f15150d).mo14502b("SimlDocumentEnd", this, false);
        }
        if (this.f15148b != null) {
            this.f15148b.m14577f();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.f15148b != null) {
            if (isFinishing()) {
                this.f15148b.m14579h();
            } else {
                this.f15148b.m14580i();
            }
            if (this.f15147a != null) {
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
            case 82:
                if (this.f15148b != null && (this.f15148b.m14574c() || this.f15148b.m14572a() || this.f15148b.m14573b())) {
                    this.f15148b.m14579h();
                    break;
                }
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 25:
            case 164:
                break;
            default:
                if (this.f15148b != null && this.f15147a != null) {
                    this.f15147a.show();
                    break;
                }
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5239d
    /* renamed from: a */
    public void mo14745a(InterfaceC5237b interfaceC5237b) {
        this.f15149c.post(new RunnableC4319il(this, interfaceC5237b));
    }
}
