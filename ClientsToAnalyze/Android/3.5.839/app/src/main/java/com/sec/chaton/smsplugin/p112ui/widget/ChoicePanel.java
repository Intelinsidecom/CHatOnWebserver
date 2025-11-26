package com.sec.chaton.smsplugin.p112ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChoicePanel extends HorizontalScrollView {

    /* renamed from: a */
    private View.OnClickListener f15796a;

    /* renamed from: b */
    private final int f15797b;

    public ChoicePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15797b = 2;
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.f15796a = onClickListener;
    }

    /* renamed from: a */
    public int m16531a() {
        return ((LinearLayout) getChildAt(0)).getChildCount();
    }

    /* renamed from: a */
    public void m16533a(String str, CharSequence charSequence) {
        if (str != null && charSequence != null) {
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            if (linearLayout.findViewWithTag(str) == null) {
                Button button = (Button) LayoutInflater.from(getContext()).inflate(R.layout.choice_panel_button, (ViewGroup) linearLayout, false);
                button.setText(charSequence);
                button.setTag(str);
                button.setOnClickListener(this.f15796a);
                button.setSingleLine(true);
                linearLayout.addView(button);
                if (getVisibility() == 8) {
                    setVisibility(0);
                }
                post(new RunnableC4357a(this));
            }
        }
    }

    /* renamed from: a */
    public void m16532a(String str) {
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        View viewFindViewWithTag = linearLayout.findViewWithTag(str);
        if (viewFindViewWithTag != null) {
            linearLayout.removeView(viewFindViewWithTag);
            if (linearLayout.getChildCount() == 0 && getVisibility() == 0) {
                setVisibility(8);
            }
        }
    }

    /* renamed from: b */
    public void m16535b() {
        ((LinearLayout) getChildAt(0)).removeAllViews();
        setVisibility(8);
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C4358b();
        private final String KEY_ID_LIST;
        private final String KEY_TEXT_LIST;
        private ArrayList<String> idList;
        private ArrayList<CharSequence> textList;

        /* synthetic */ SavedState(Parcel parcel, RunnableC4357a runnableC4357a) {
            this(parcel);
        }

        SavedState(Parcelable parcelable, ArrayList<String> arrayList, ArrayList<CharSequence> arrayList2) {
            super(parcelable);
            this.KEY_ID_LIST = "com.sec.chaton.smsplugin.ui.widget.ChoicePanel.idList";
            this.KEY_TEXT_LIST = "com.sec.chaton.smsplugin.ui.widget.ChoicePanel.textList";
            this.idList = arrayList;
            this.textList = arrayList2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.KEY_ID_LIST = "com.sec.chaton.smsplugin.ui.widget.ChoicePanel.idList";
            this.KEY_TEXT_LIST = "com.sec.chaton.smsplugin.ui.widget.ChoicePanel.textList";
            if (parcel != null) {
                Bundle bundle = new Bundle();
                bundle.readFromParcel(parcel);
                this.idList = bundle.getStringArrayList("com.sec.chaton.smsplugin.ui.widget.ChoicePanel.idList");
                this.textList = bundle.getCharSequenceArrayList("com.sec.chaton.smsplugin.ui.widget.ChoicePanel.textList");
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("com.sec.chaton.smsplugin.ui.widget.ChoicePanel.idList", this.idList);
            bundle.putCharSequenceArrayList("com.sec.chaton.smsplugin.ui.widget.ChoicePanel.textList", this.textList);
            bundle.writeToParcel(parcel, i);
        }

        public String toString() {
            return "ChoicePanel.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " idList=" + this.idList + " textList=" + this.textList + "}";
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        int i = 0;
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        ArrayList arrayList = new ArrayList(linearLayout.getChildCount());
        ArrayList arrayList2 = new ArrayList(linearLayout.getChildCount());
        while (true) {
            int i2 = i;
            if (i2 < linearLayout.getChildCount()) {
                Button button = (Button) linearLayout.getChildAt(i2);
                arrayList.add((String) button.getTag());
                arrayList2.add(button.getText());
                i = i2 + 1;
            } else {
                return new SavedState(parcelableOnSaveInstanceState, arrayList, arrayList2);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.idList != null && savedState.textList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < savedState.idList.size()) {
                    m16533a((String) savedState.idList.get(i2), (CharSequence) savedState.textList.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public ArrayList<String> m16536c() {
        int i = 0;
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        ArrayList<String> arrayList = new ArrayList<>(linearLayout.getChildCount());
        while (true) {
            int i2 = i;
            if (i2 < linearLayout.getChildCount()) {
                arrayList.add((String) ((Button) linearLayout.getChildAt(i2)).getTag());
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    /* renamed from: a */
    private boolean m16530a(String str, boolean z) {
        if (z) {
            return C4149cd.m16425b(str);
        }
        return PhoneNumberUtils.isWellFormedSmsAddress(str) || Telephony.Mms.isEmailAddress(str);
    }

    /* renamed from: a */
    public boolean m16534a(boolean z) {
        Iterator<String> it = m16536c().iterator();
        while (it.hasNext()) {
            if (m16530a(it.next(), z)) {
                return true;
            }
        }
        return false;
    }
}
