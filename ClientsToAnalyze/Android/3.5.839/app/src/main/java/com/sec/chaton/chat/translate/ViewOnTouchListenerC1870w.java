package com.sec.chaton.chat.translate;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.w */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1870w implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7088a;

    ViewOnTouchListenerC1870w(TranslatorFragment translatorFragment) {
        this.f7088a = translatorFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == R.id.chat_translator_msg_me) {
            this.f7088a.m9003a(this.f7088a.f6974g, true);
            view.getParent().requestDisallowInterceptTouchEvent(true);
            switch (motionEvent.getAction() & 255) {
                case 1:
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                default:
                    return false;
            }
        }
        return false;
    }
}
