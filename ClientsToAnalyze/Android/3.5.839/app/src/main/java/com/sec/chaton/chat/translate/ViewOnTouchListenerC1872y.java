package com.sec.chaton.chat.translate;

import android.view.MotionEvent;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.y */
/* loaded from: classes.dex */
class ViewOnTouchListenerC1872y implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7090a;

    ViewOnTouchListenerC1872y(TranslatorFragment translatorFragment) {
        this.f7090a = translatorFragment;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == R.id.chat_translator_msg_buddy) {
            this.f7090a.m9003a(this.f7090a.f6975h, true);
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
