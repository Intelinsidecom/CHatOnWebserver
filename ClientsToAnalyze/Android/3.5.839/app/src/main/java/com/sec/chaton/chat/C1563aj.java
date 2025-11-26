package com.sec.chaton.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import com.sec.chaton.R;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aj */
/* loaded from: classes.dex */
class C1563aj implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f5981a;

    C1563aj(ChatFragment chatFragment) {
        this.f5981a = chatFragment;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence != null) {
            Log.d("ChatON", "Chat_onTextChange()");
            if (i2 != i3) {
                String string = charSequence.toString();
                int length = string.length();
                boolean zMatches = string.matches("(\\s)+");
                this.f5981a.f5740es.setVisibility(8);
                if (this.f5981a.f5641ce.isEnabled() && length == 10001) {
                    this.f5981a.f5529aV.setText(R.string.toast_text_max_Length);
                    this.f5981a.f5529aV.setDuration(0);
                    this.f5981a.f5529aV.show();
                    this.f5981a.f5564bF.setText(string.substring(0, 10000));
                    this.f5981a.f5564bF.setSelection(10000);
                } else if (!zMatches && length > 0) {
                    this.f5981a.f5641ce.setEnabled(true);
                    this.f5981a.f5642cf.setEnabled(true);
                    if (!this.f5981a.f5698dm || !this.f5981a.f5699dn) {
                        this.f5981a.f5641ce.setVisibility(0);
                        this.f5981a.f5642cf.setVisibility(8);
                    } else if (this.f5981a.f5700do) {
                        this.f5981a.f5642cf.setVisibility(8);
                        this.f5981a.f5641ce.setVisibility(0);
                    } else {
                        this.f5981a.f5642cf.setVisibility(0);
                        this.f5981a.f5641ce.setVisibility(8);
                    }
                    this.f5981a.f5662cz.setVisibility(8);
                } else if (zMatches || length == 0) {
                    this.f5981a.f5641ce.setEnabled(false);
                    this.f5981a.f5642cf.setEnabled(false);
                    if (this.f5981a.f5548aq) {
                        this.f5981a.f5641ce.setEnabled(true);
                        this.f5981a.f5641ce.setVisibility(0);
                        this.f5981a.f5662cz.setVisibility(8);
                        if (this.f5981a.f5698dm && this.f5981a.f5699dn && !this.f5981a.f5700do) {
                            this.f5981a.f5642cf.setVisibility(8);
                        }
                    } else {
                        if (!this.f5981a.f5698dm || !this.f5981a.f5699dn || this.f5981a.f5700do) {
                            this.f5981a.f5641ce.setEnabled(false);
                            this.f5981a.f5641ce.setVisibility(0);
                            this.f5981a.f5642cf.setVisibility(8);
                        } else {
                            this.f5981a.f5642cf.setEnabled(false);
                            this.f5981a.f5642cf.setVisibility(0);
                            this.f5981a.f5641ce.setVisibility(8);
                        }
                        if (this.f5981a.m8277v()) {
                            this.f5981a.f5641ce.setVisibility(8);
                            this.f5981a.f5642cf.setVisibility(8);
                            this.f5981a.f5662cz.setVisibility(0);
                        }
                    }
                }
                if (this.f5981a.f5612cB != null) {
                    if (i2 > 0 || i3 > 0) {
                        if (!this.f5981a.f5613cC) {
                            this.f5981a.f5612cB.m8814b();
                        } else {
                            this.f5981a.f5613cC = false;
                        }
                    }
                }
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
