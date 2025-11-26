package com.vlingo.sdk.recognition.dialog;

import android.util.Pair;
import com.sds.coolots.common.model.EventCode;
import com.vlingo.sdk.internal.http.HttpUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VLDialogEvent {
    ArrayList<VLDialogEventFieldGroup> fieldGroupList;
    ArrayList<Pair<String, String>> fieldList;
    String name;

    public static class Builder {
        private String name;
        private ArrayList<Pair<String, String>> fieldList = new ArrayList<>();
        private ArrayList<VLDialogEventFieldGroup> fieldGroupList = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder eventField(String fieldName, String fieldValue) {
            this.fieldList.add(new Pair<>(fieldName, fieldValue));
            return this;
        }

        public Builder eventFieldGroup(VLDialogEventFieldGroup fieldGroup) {
            this.fieldGroupList.add(fieldGroup);
            return this;
        }

        public VLDialogEvent build() {
            return new VLDialogEvent(this);
        }
    }

    VLDialogEvent(Builder builder) {
        this.name = builder.name;
        this.fieldList = new ArrayList<>(builder.fieldList);
        this.fieldGroupList = new ArrayList<>(builder.fieldGroupList);
    }

    public String getName() {
        return this.name;
    }

    public List<Pair<String, String>> getFields() {
        return new ArrayList(this.fieldList);
    }

    public List<VLDialogEventFieldGroup> getFieldGroups() {
        return new ArrayList(this.fieldGroupList);
    }

    public String getXML() {
        StringBuilder sb = new StringBuilder();
        generateXML(EventCode.EVENT_IDENTIFIER, sb);
        return sb.toString();
    }

    void generateXML(String tagName, StringBuilder sb) {
        sb.append("<").append(tagName).append(" ");
        sb.append(HttpUtil.genAtr("n", this.name));
        sb.append(">");
        Iterator<Pair<String, String>> it = this.fieldList.iterator();
        while (it.hasNext()) {
            Pair<String, String> field = it.next();
            sb.append("<Field ");
            sb.append(HttpUtil.genAtr("n", (String) field.first));
            sb.append(HttpUtil.genAtr("v", (String) field.second));
            sb.append("/>");
        }
        Iterator<VLDialogEventFieldGroup> it2 = this.fieldGroupList.iterator();
        while (it2.hasNext()) {
            VLDialogEventFieldGroup group = it2.next();
            group.generateXML("FieldGroup", sb);
        }
        sb.append("</").append(tagName).append(">");
    }
}
