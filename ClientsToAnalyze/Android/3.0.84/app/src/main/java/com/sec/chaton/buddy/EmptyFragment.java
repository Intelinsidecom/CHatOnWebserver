package com.sec.chaton.buddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class EmptyFragment extends Fragment {

    /* renamed from: a */
    public static String f2241a = "No_Buddy_Selection";

    /* renamed from: b */
    public static String f2242b = "No_Chat_Selection";

    /* renamed from: c */
    public static String f2243c = "Empty_Flag";

    /* renamed from: d */
    private Bundle f2244d;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2244d = getArguments();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.empty_fragment, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image1);
        if (this.f2244d != null) {
            String string = this.f2244d.getString(f2243c, "");
            if (string.equals(f2241a)) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.no_contents_buddies));
            } else if (string.equals(f2242b)) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.no_contents_chat));
            }
        }
        return viewInflate;
    }
}
