package com.sec.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.plugin.C1948a;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChoicePanel extends HorizontalScrollView {

    /* renamed from: a */
    private View.OnClickListener f13347a;

    /* renamed from: b */
    private final int f13348b;

    /* renamed from: c */
    private final int f13349c;

    /* renamed from: d */
    private final int f13350d;

    public ChoicePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13348b = 1;
        this.f13349c = 2;
        this.f13350d = 3;
        setFocusable(false);
    }

    public void setButtonClickListener(View.OnClickListener onClickListener, int i, boolean z) {
        this.f13347a = onClickListener;
    }

    public void setIsPluginAvailable_chaton(boolean z) {
    }

    /* renamed from: a */
    public void m13055a(String str, CharSequence charSequence) {
        if (str != null && charSequence != null) {
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            if (linearLayout.findViewWithTag(str) == null) {
                Button button = (Button) LayoutInflater.from(getContext()).inflate(R.layout.choice_panel_button, (ViewGroup) linearLayout, false);
                button.setMaxWidth((int) ((CommonApplication.m11493l().getResources().getDisplayMetrics().density * 121.0f) + 0.5f));
                button.setEllipsize(TextUtils.TruncateAt.END);
                Drawable drawable = button.getCompoundDrawables()[2];
                if (C1948a.m7903a(GlobalApplication.m11493l()) && BuddyFragment.m3357b(str)) {
                    button.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.buddies_videocall), button.getCompoundDrawables()[1], drawable, button.getCompoundDrawables()[3]);
                }
                button.setText(charSequence);
                button.setTag(str);
                button.setOnClickListener(this.f13347a);
                button.setSingleLine(true);
                linearLayout.addView(button);
                if (getVisibility() == 8) {
                    setVisibility(0);
                }
                post(new RunnableC3632a(this));
            }
        }
    }

    /* renamed from: a */
    public void m13054a(String str) {
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
        public static final Parcelable.Creator<SavedState> CREATOR = new C3659b();
        private final String KEY_ID_LIST;
        private final String KEY_TEXT_LIST;
        private ArrayList<String> idList;
        private ArrayList<CharSequence> textList;

        /* synthetic */ SavedState(Parcel parcel, RunnableC3632a runnableC3632a) {
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
                    m13055a((String) savedState.idList.get(i2), (CharSequence) savedState.textList.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void m13053a() {
        int i = 0;
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        while (true) {
            int i2 = i;
            if (i2 < linearLayout.getChildCount()) {
                View viewFindViewWithTag = linearLayout.findViewWithTag(linearLayout.getChildAt(i2).getTag());
                if (viewFindViewWithTag instanceof Button) {
                    String string = ((Button) viewFindViewWithTag).getText().toString();
                    String strM6037b = C1360d.m6037b(GlobalApplication.m11493l().getContentResolver(), linearLayout.getChildAt(i2).getTag().toString());
                    if (string.compareTo(strM6037b) != 0) {
                        ((Button) viewFindViewWithTag).setText(strM6037b);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
