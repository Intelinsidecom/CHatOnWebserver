package com.sec.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2190d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChoicePanel extends HorizontalScrollView {

    /* renamed from: a */
    private View.OnClickListener f18729a;

    /* renamed from: b */
    private final int f18730b;

    /* renamed from: c */
    private final int f18731c;

    /* renamed from: d */
    private final int f18732d;

    public ChoicePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18730b = 1;
        this.f18731c = 2;
        this.f18732d = 3;
        setFocusable(false);
    }

    public void setButtonClickListener(View.OnClickListener onClickListener, int i, boolean z) {
        this.f18729a = onClickListener;
    }

    public void setIsPluginAvailable_chaton(boolean z) {
    }

    /* renamed from: a */
    public void m19615a(String str, CharSequence charSequence) {
        if (str != null && charSequence != null) {
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            if (linearLayout.findViewWithTag(str) == null) {
                Button button = (Button) LayoutInflater.from(getContext()).inflate(R.layout.choice_panel_button, (ViewGroup) linearLayout, false);
                button.setText(charSequence);
                button.setTag(str);
                button.setOnClickListener(this.f18729a);
                button.setSingleLine(true);
                linearLayout.addView(button);
                if (getVisibility() == 8) {
                    setVisibility(0);
                }
                post(new RunnableC5137a(this));
            }
        }
    }

    /* renamed from: a */
    public void m19614a(String str) {
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        View viewFindViewWithTag = linearLayout.findViewWithTag(str);
        if (viewFindViewWithTag != null) {
            viewFindViewWithTag.setContentDescription(((Button) viewFindViewWithTag).getText().toString() + " " + getResources().getString(R.string.trunk_toast_deleted));
            viewFindViewWithTag.sendAccessibilityEvent(8);
            linearLayout.removeView(viewFindViewWithTag);
            if (linearLayout.getChildCount() == 0 && getVisibility() == 0) {
                setVisibility(8);
            }
        }
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C5159b();
        private final String KEY_ID_LIST;
        private final String KEY_TEXT_LIST;
        private ArrayList<String> idList;
        private ArrayList<CharSequence> textList;

        /* synthetic */ SavedState(Parcel parcel, RunnableC5137a runnableC5137a) {
            this(parcel);
        }

        SavedState(Parcelable parcelable, ArrayList<String> arrayList, ArrayList<CharSequence> arrayList2) {
            super(parcelable);
            this.KEY_ID_LIST = "com.sec.chaton.widget.ChoicePanel.idList";
            this.KEY_TEXT_LIST = "com.sec.chaton.widget.ChoicePanel.textList";
            this.idList = arrayList;
            this.textList = arrayList2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.KEY_ID_LIST = "com.sec.chaton.widget.ChoicePanel.idList";
            this.KEY_TEXT_LIST = "com.sec.chaton.widget.ChoicePanel.textList";
            if (parcel != null) {
                Bundle bundle = new Bundle();
                bundle.readFromParcel(parcel);
                this.idList = bundle.getStringArrayList("com.sec.chaton.widget.ChoicePanel.idList");
                this.textList = bundle.getCharSequenceArrayList("com.sec.chaton.widget.ChoicePanel.textList");
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("com.sec.chaton.widget.ChoicePanel.idList", this.idList);
            bundle.putCharSequenceArrayList("com.sec.chaton.widget.ChoicePanel.textList", this.textList);
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
                    m19615a((String) savedState.idList.get(i2), (CharSequence) savedState.textList.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void m19613a() {
        int i = 0;
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        while (true) {
            int i2 = i;
            if (i2 < linearLayout.getChildCount()) {
                View viewFindViewWithTag = linearLayout.findViewWithTag(linearLayout.getChildAt(i2).getTag());
                if (viewFindViewWithTag instanceof Button) {
                    String string = ((Button) viewFindViewWithTag).getText().toString();
                    String strM9827c = C2190d.m9827c(GlobalApplication.m18732r().getContentResolver(), linearLayout.getChildAt(i2).getTag().toString());
                    if (string.compareTo(strM9827c) != 0) {
                        ((Button) viewFindViewWithTag).setText(strM9827c);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
