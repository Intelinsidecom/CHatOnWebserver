package com.coolots.chaton.common.view.layout;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import com.coolots.chaton.C0000R;

/* loaded from: classes.dex */
public class OptionMenuLayout {
    private static boolean optionMenu = false;

    public static void setLayout(final Activity activity, Menu menu) {
        if (activity.getLayoutInflater().getFactory() == null) {
            activity.getLayoutInflater().setFactory(new LayoutInflater.Factory() { // from class: com.coolots.chaton.common.view.layout.OptionMenuLayout.1
                @Override // android.view.LayoutInflater.Factory
                public View onCreateView(String name, Context context, AttributeSet attrs) throws InflateException, ClassNotFoundException {
                    if (name.equalsIgnoreCase("com.android.internal.view.menu.ListMenuItemView")) {
                        OptionMenuLayout.optionMenu = true;
                        try {
                            LayoutInflater li = LayoutInflater.from(context);
                            final View view = li.createView(name, null, attrs);
                            Handler handler = new Handler();
                            final Activity activity2 = activity;
                            handler.post(new Runnable() { // from class: com.coolots.chaton.common.view.layout.OptionMenuLayout.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    view.setBackgroundDrawable(activity2.getResources().getDrawable(C0000R.drawable.option_menu_bg_selector));
                                }
                            });
                            return view;
                        } catch (InflateException e) {
                        } catch (ClassNotFoundException e2) {
                        }
                    }
                    if (OptionMenuLayout.optionMenu && name.equalsIgnoreCase("TextView")) {
                        OptionMenuLayout.optionMenu = false;
                        try {
                            LayoutInflater li2 = LayoutInflater.from(context);
                            return li2.createView(name, null, attrs);
                        } catch (InflateException e3) {
                        } catch (ClassNotFoundException e4) {
                        }
                    }
                    return null;
                }
            });
        }
    }

    public static void setLayout(final Activity activity) {
        if (activity.getLayoutInflater().getFactory() == null) {
            activity.getLayoutInflater().setFactory(new LayoutInflater.Factory() { // from class: com.coolots.chaton.common.view.layout.OptionMenuLayout.2
                @Override // android.view.LayoutInflater.Factory
                public View onCreateView(String name, Context context, AttributeSet attrs) throws InflateException, ClassNotFoundException {
                    if (name.equalsIgnoreCase("com.android.internal.view.menu.ListMenuItemView")) {
                        OptionMenuLayout.optionMenu = true;
                        try {
                            LayoutInflater li = LayoutInflater.from(context);
                            final View view = li.createView(name, null, attrs);
                            Handler handler = new Handler();
                            final Activity activity2 = activity;
                            handler.post(new Runnable() { // from class: com.coolots.chaton.common.view.layout.OptionMenuLayout.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    view.setBackgroundDrawable(activity2.getResources().getDrawable(C0000R.drawable.option_menu_bg_selector));
                                }
                            });
                            return view;
                        } catch (InflateException e) {
                        } catch (ClassNotFoundException e2) {
                        }
                    }
                    if (OptionMenuLayout.optionMenu && name.equalsIgnoreCase("TextView")) {
                        OptionMenuLayout.optionMenu = false;
                        try {
                            LayoutInflater li2 = LayoutInflater.from(context);
                            final View view2 = li2.createView(name, null, attrs);
                            Handler handler2 = new Handler();
                            final Activity activity3 = activity;
                            handler2.post(new Runnable() { // from class: com.coolots.chaton.common.view.layout.OptionMenuLayout.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((TextView) view2).setTextColor(activity3.getResources().getColor(C0000R.color.tw_color001));
                                }
                            });
                            return view2;
                        } catch (InflateException e3) {
                        } catch (ClassNotFoundException e4) {
                        }
                    }
                    return null;
                }
            });
        }
    }
}
