package com.coolots.chaton.setting.view.layout;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ChatONDialog;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ListPreferenceMultiSelect extends ListPreference {
    private static final String CLASSNAME = "[ListPreferenceMultiSelect]";
    public static final String SEPARATOR = "OV=I=XseparatorX=I=VO";
    private String mCheckAllKey;
    private boolean[] mClickedDialogEntryIndices;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ListPreferenceMultiSelect(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCheckAllKey = "checkAll";
        logI("ListPreferenceMultiSelect()");
        this.mClickedDialogEntryIndices = new boolean[getEntries().length];
    }

    public ListPreferenceMultiSelect(Context context) {
        this(context, null);
        logI("ListPreferenceMultiSelect()");
    }

    @Override // android.preference.ListPreference
    public void setEntries(CharSequence[] entries) {
        super.setEntries(entries);
        logI("setEntries()");
        this.mClickedDialogEntryIndices = new boolean[entries.length];
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder a) {
        logI("onPrepareDialogBuilder()");
        CharSequence[] entries = getEntries();
        CharSequence[] entryValues = getEntryValues();
        if (entries == null || entryValues == null || entries.length != entryValues.length) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array which are both the same length");
        }
        restoreCheckedEntries();
        ListView listView = new ListView(getContext());
        CheckBoxListAdapter adpater = new CheckBoxListAdapter(getContext(), C0000R.layout.user_preference_screen_checkbox_one_line, entries);
        adpater.setData(this.mClickedDialogEntryIndices);
        listView.setAdapter((ListAdapter) adpater);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coolots.chaton.setting.view.layout.ListPreferenceMultiSelect.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View view, int postion, long id) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {
                    checkBox.setChecked(false);
                } else {
                    checkBox.setChecked(true);
                }
                checkBox.sendAccessibilityEvent(1);
                ListPreferenceMultiSelect.this.mClickedDialogEntryIndices[postion] = checkBox.isChecked();
            }
        });
        ChatONDialog dialog = new ChatONDialog.Builder(getContext()).setTitle(getTitle()).setPositiveButton(C0000R.string.ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.layout.ListPreferenceMultiSelect.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int which) {
                ListPreferenceMultiSelect.this.onDialogClosed(true);
                dialog2.dismiss();
            }
        }).setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.layout.ListPreferenceMultiSelect.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int which) {
                dialog2.dismiss();
            }
        }).setView(listView).create();
        dialog.setCancelable(true);
        dialog.show();
    }

    @Override // android.preference.DialogPreference
    protected void showDialog(Bundle state) {
        onPrepareDialogBuilder(null);
    }

    public static List<Boolean> parsePreferenceValue(String preference, List<Boolean> defaultValue) {
        List<Boolean> data = new ArrayList<>(defaultValue);
        String[] buf = parseStoredValue(preference);
        if (buf != null) {
            getStoredValue(buf, data);
        }
        return data;
    }

    private static String[] parseStoredValue(CharSequence val) {
        if ("".equals(val)) {
            return null;
        }
        return ((String) val).split(SEPARATOR);
    }

    private static List<Boolean> getStoredValue(String[] buf, List<Boolean> list) {
        for (int i = 0; i < list.size(); i++) {
            int len = 0;
            while (true) {
                if (len >= buf.length) {
                    break;
                }
                if (i != Integer.parseInt(buf[len])) {
                    len++;
                } else {
                    list.set(i, true);
                    break;
                }
            }
            if (len == buf.length) {
                list.set(i, false);
            }
        }
        return list;
    }

    private void restoreCheckedEntries() {
        logI("restoreCheckedEntries()");
        CharSequence[] entryValues = getEntryValues();
        String[] vals = parseStoredValue(getValue());
        int size = this.mClickedDialogEntryIndices.length;
        for (int i = 0; i < size; i++) {
            this.mClickedDialogEntryIndices[i] = false;
        }
        if (vals != null) {
            List<String> valuesList = Arrays.asList(vals);
            for (int i2 = 0; i2 < entryValues.length; i2++) {
                CharSequence entry = entryValues[i2];
                if (valuesList.contains(entry)) {
                    this.mClickedDialogEntryIndices[i2] = true;
                }
            }
        }
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    protected void onDialogClosed(boolean positiveResult) {
        logI("onDialogClosed() positiveResult: " + positiveResult);
        ArrayList<String> values = new ArrayList<>();
        CharSequence[] entryValues = getEntryValues();
        if (positiveResult && entryValues != null) {
            for (int i = 0; i < entryValues.length; i++) {
                if (this.mClickedDialogEntryIndices[i]) {
                    String val = (String) entryValues[i];
                    if (this.mCheckAllKey == null || !val.equals(this.mCheckAllKey)) {
                        values.add(val);
                    }
                }
            }
            if (callChangeListener(values)) {
                setValue(join(values, SEPARATOR));
                return;
            }
            return;
        }
        restoreCheckedEntries();
    }

    protected static String join(Iterable<? extends Object> pColl, String separator) {
        if (pColl != null) {
            Iterator<? extends Object> oIter = pColl.iterator();
            if (oIter.hasNext()) {
                StringBuilder oBuilder = new StringBuilder(String.valueOf(oIter.next()));
                while (oIter.hasNext()) {
                    oBuilder.append(separator).append(oIter.next());
                }
                return oBuilder.toString();
            }
        }
        return "";
    }

    public static boolean contains(String straw, String haystack, String separator) {
        String _separator = separator;
        if (_separator == null) {
            _separator = SEPARATOR;
        }
        String[] vals = haystack.split(_separator);
        for (String str : vals) {
            if (str.equals(straw)) {
                return true;
            }
        }
        return false;
    }
}
