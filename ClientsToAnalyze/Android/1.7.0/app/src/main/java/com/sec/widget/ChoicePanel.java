package com.sec.widget;

import android.content.Context;
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
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChoicePanel extends HorizontalScrollView {

    /* renamed from: a */
    private View.OnClickListener f5651a;

    public ChoicePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.f5651a = onClickListener;
    }

    /* renamed from: a */
    public void m5837a(String str, String str2) {
        if (str != null && str2 != null) {
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            if (linearLayout.findViewWithTag(str) == null) {
                Button button = (Button) LayoutInflater.from(getContext()).inflate(R.layout.choice_panel_button, (ViewGroup) linearLayout, false);
                button.setText(str2);
                button.setTag(str);
                button.setOnClickListener(this.f5651a);
                linearLayout.addView(button);
                if (getVisibility() == 8) {
                    setVisibility(0);
                }
                post(new RunnableC1617e(this));
            }
        }
    }

    /* renamed from: a */
    public void m5836a(String str) {
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        View viewFindViewWithTag = linearLayout.findViewWithTag(str);
        if (viewFindViewWithTag != null) {
            linearLayout.removeView(viewFindViewWithTag);
            if (linearLayout.getChildCount() == 0 && getVisibility() == 0) {
                setVisibility(8);
            }
        }
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C1634v();
        ArrayList idList;
        ArrayList textList;

        /* synthetic */ SavedState(Parcel parcel, RunnableC1617e runnableC1617e) {
            this(parcel);
        }

        SavedState(Parcelable parcelable, ArrayList arrayList, ArrayList arrayList2) {
            super(parcelable);
            this.idList = arrayList;
            this.textList = arrayList2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            if (parcel != null) {
                this.idList = new ArrayList();
                this.textList = new ArrayList();
                parcel.readStringList(this.idList);
                parcel.readStringList(this.textList);
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeStringList(this.idList);
            parcel.writeStringList(this.textList);
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
                arrayList2.add((String) button.getText());
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
                    m5837a((String) savedState.idList.get(i2), (String) savedState.textList.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
