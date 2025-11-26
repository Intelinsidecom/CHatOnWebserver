package com.samsung.android.sdk.pen.document;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.util.SpenError;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class SpenObjectTextBox extends SpenObjectBase {
    public static final int ALIGN_BOTH = 3;
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 1;
    public static final int AUTO_FIT_BOTH = 3;
    public static final int AUTO_FIT_HORIZONTAL = 1;
    public static final int AUTO_FIT_NONE = 0;
    public static final int AUTO_FIT_VERTICAL = 2;
    public static final int BORDER_TYPE_DOT = 3;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SHADOW = 2;
    public static final int BORDER_TYPE_SQUARE = 1;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int ELLIPSIS_DOTS = 1;
    public static final int ELLIPSIS_NONE = 0;
    public static final int ELLIPSIS_TRIANGLE = 2;
    public static final int GRAVITY_BOTTOM = 2;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_TOP = 0;
    public static final int HYPER_TEXT_ADDRESS = 5;
    public static final int HYPER_TEXT_DATE = 4;
    public static final int HYPER_TEXT_EMAIL = 1;
    public static final int HYPER_TEXT_TEL = 2;
    public static final int HYPER_TEXT_UNKNOWN = 0;
    public static final int HYPER_TEXT_URL = 3;
    public static final int IMEACTION_PREVIOUS = 7;
    public static final int IME_ACTION_DONE = 4;
    public static final int IME_ACTION_GO = 2;
    public static final int IME_ACTION_NEXT = 6;
    public static final int IME_ACTION_NONE = 1;
    public static final int IME_ACTION_SEARCH = 3;
    public static final int IME_ACTION_SEND = 5;
    public static final int IME_ACTION_UNSPECIFIED = 0;
    public static final int INPUT_TYPE_DATETIME = 4;
    public static final int INPUT_TYPE_NONE = 0;
    public static final int INPUT_TYPE_NUMBER = 2;
    public static final int INPUT_TYPE_PHONE = 3;
    public static final int INPUT_TYPE_TEXT = 1;
    public static final int LINE_SPACING_PERCENT = 1;
    public static final int LINE_SPACING_PIXEL = 0;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_MASK = 7;
    public static final int STYLE_NONE = 0;
    public static final int STYLE_UNDERLINE = 4;

    public static class AlignParagraphInfo extends TextParagraphInfo {
        public int align = 0;
    }

    public static class BackgroundColorSpanInfo extends TextSpanInfo {
        public int backgroundColor = -16777216;
    }

    public static class BoldStyleSpanInfo extends TextSpanInfo {
        public boolean isBold = true;
    }

    public static class FontNameSpanInfo extends TextSpanInfo {
        public String fontName;
    }

    public static class FontSizeSpanInfo extends TextSpanInfo {
        public float fontSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    public static class ForegroundColorSpanInfo extends TextSpanInfo {
        public int foregroundColor = -1;
    }

    public static class HyperTextStyleSpanInfo extends TextSpanInfo {
        public int hyperTextType = 0;
    }

    public static class ItalicStyleSpanInfo extends TextSpanInfo {
        public boolean isItalic = true;
    }

    public static class LineSpacingParagraphInfo extends TextParagraphInfo {
        public int type = 0;
        public float lineSpacing = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    public static class TextDirectionSpanInfo extends TextSpanInfo {
        public int textDirection = 0;
    }

    public static class TextParagraphInfo {
        public int startPos = 0;
        public int endPos = 0;
    }

    public static class TextSpanInfo {
        public static final int SPAN_EXCLUSIVE_EXCLUSIVE = 2;
        public static final int SPAN_EXCLUSIVE_INCLUSIVE = 3;
        public static final int SPAN_INCLUSIVE_EXCLUSIVE = 0;
        public static final int SPAN_INCLUSIVE_INCLUSIVE = 1;
        public int startPos = 0;
        public int endPos = 0;
        public int intervalType = 0;
    }

    public static class UnderlineStyleSpanInfo extends TextSpanInfo {
        public boolean isUnderline = true;
        public int reserved1 = -1;
        public int reserved2 = -1;
    }

    private native boolean ObjectTextBox_appendParagraph(TextParagraphInfo textParagraphInfo);

    private native boolean ObjectTextBox_appendSpan(TextSpanInfo textSpanInfo);

    private native void ObjectTextBox_clearChangedFlag();

    private native boolean ObjectTextBox_copy(SpenObjectBase spenObjectBase);

    private native boolean ObjectTextBox_enableReadOnly(boolean z);

    private native ArrayList<TextParagraphInfo> ObjectTextBox_findParagraphs(int i, int i2);

    private native ArrayList<TextSpanInfo> ObjectTextBox_findSpans(int i, int i2);

    private native int ObjectTextBox_getAutoFitOption();

    private native int ObjectTextBox_getBackgroundColor();

    private native int ObjectTextBox_getBorderType();

    private native float ObjectTextBox_getBottomMargin();

    private native int ObjectTextBox_getBulletType();

    private native int ObjectTextBox_getCursorPos();

    private native RectF ObjectTextBox_getDrawnRect();

    private native int ObjectTextBox_getEllipsisType();

    private native String ObjectTextBox_getFont();

    private native float ObjectTextBox_getFontSize();

    private native int ObjectTextBox_getGravity();

    private native String ObjectTextBox_getHintText();

    private native int ObjectTextBox_getHintTextColor();

    private native float ObjectTextBox_getHintTextFontSize();

    private native int ObjectTextBox_getIMEActionType();

    private native float ObjectTextBox_getLeftMargin();

    private native int ObjectTextBox_getLineBorderColor();

    private native float ObjectTextBox_getLineBorderWidth();

    private native ArrayList<TextParagraphInfo> ObjectTextBox_getParagraph();

    private native float ObjectTextBox_getRightMargin();

    private native ArrayList<TextSpanInfo> ObjectTextBox_getSpan();

    private native String ObjectTextBox_getText();

    private native int ObjectTextBox_getTextAlignment();

    private native int ObjectTextBox_getTextColor();

    private native int ObjectTextBox_getTextDirection();

    private native int ObjectTextBox_getTextIndentLevel();

    private native int ObjectTextBox_getTextInputType();

    private native float ObjectTextBox_getTextLineSpacing();

    private native int ObjectTextBox_getTextLineSpacingType();

    private native int ObjectTextBox_getTextStyle();

    private native float ObjectTextBox_getTopMargin();

    private native float ObjectTextBox_getVerticalPan();

    private native boolean ObjectTextBox_init1();

    private native boolean ObjectTextBox_init2(String str);

    private native boolean ObjectTextBox_init3(String str, ArrayList<TextSpanInfo> arrayList);

    private native boolean ObjectTextBox_init4(String str, ArrayList<TextSpanInfo> arrayList, ArrayList<TextParagraphInfo> arrayList2);

    private native boolean ObjectTextBox_init5(String str, ArrayList<TextSpanInfo> arrayList, ArrayList<TextParagraphInfo> arrayList2, boolean z);

    private native boolean ObjectTextBox_insertChar(char c, int i);

    private native boolean ObjectTextBox_insertCharAtCursor(char c);

    private native boolean ObjectTextBox_insertText(String str, int i);

    private native boolean ObjectTextBox_insertTextAtCursor(String str);

    private native boolean ObjectTextBox_isChanged();

    private native boolean ObjectTextBox_isHintTextVisiable();

    private native boolean ObjectTextBox_isReadOnly();

    private native boolean ObjectTextBox_parseHyperText();

    private native boolean ObjectTextBox_removeAllText();

    private native boolean ObjectTextBox_removeParagraph(TextParagraphInfo textParagraphInfo);

    private native boolean ObjectTextBox_removeSpan(TextSpanInfo textSpanInfo);

    private native boolean ObjectTextBox_removeText(int i, int i2);

    private native boolean ObjectTextBox_replaceText(String str, int i, int i2);

    private native boolean ObjectTextBox_setAutoFitOption(int i);

    private native boolean ObjectTextBox_setBackgroundColor(int i);

    private native boolean ObjectTextBox_setBorderType(int i);

    private native boolean ObjectTextBox_setBulletType(int i);

    private native boolean ObjectTextBox_setCursorPos(int i);

    private native boolean ObjectTextBox_setEllipsisType(int i);

    private native boolean ObjectTextBox_setFont(String str);

    private native boolean ObjectTextBox_setFontSize(float f);

    private native boolean ObjectTextBox_setGravity(int i);

    private native boolean ObjectTextBox_setHintText(String str);

    private native boolean ObjectTextBox_setHintTextColor(int i);

    private native boolean ObjectTextBox_setHintTextFontSize(float f);

    private native boolean ObjectTextBox_setHintTextVisibility(boolean z);

    private native boolean ObjectTextBox_setIMEActionType(int i);

    private native boolean ObjectTextBox_setLineBorderColor(int i);

    private native boolean ObjectTextBox_setLineBorderWidth(float f);

    private native boolean ObjectTextBox_setMargin(float f, float f2, float f3, float f4);

    private native boolean ObjectTextBox_setParagraph(ArrayList<TextParagraphInfo> arrayList);

    private native boolean ObjectTextBox_setSpan(ArrayList<TextSpanInfo> arrayList);

    private native boolean ObjectTextBox_setText(String str);

    private native boolean ObjectTextBox_setTextAlignment(int i);

    private native boolean ObjectTextBox_setTextColor(int i);

    private native boolean ObjectTextBox_setTextDirection(int i);

    private native boolean ObjectTextBox_setTextIndentLevel(int i);

    private native boolean ObjectTextBox_setTextInputType(int i);

    private native boolean ObjectTextBox_setTextLineSpacingInfo(int i, float f);

    private native boolean ObjectTextBox_setTextStyle(int i);

    private native boolean ObjectTextBox_setVerticalPan(float f);

    protected SpenObjectTextBox(int type) {
        super(type);
    }

    public SpenObjectTextBox() {
        super(2);
    }

    public SpenObjectTextBox(boolean isTemplateObject) {
        super(2);
        boolean rnt = ObjectTextBox_init5(null, null, null, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectTextBox(String text) {
        super(2);
        boolean rnt = ObjectTextBox_init2(text);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectTextBox(String text, boolean isTemplateObject) {
        super(2);
        boolean rnt = ObjectTextBox_init5(text, null, null, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectTextBox(String text, ArrayList<TextSpanInfo> span) {
        super(2);
        if (span != null) {
            Iterator<TextSpanInfo> it = span.iterator();
            while (it.hasNext()) {
                TextSpanInfo temp = it.next();
                if (temp.startPos < 0 || temp.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        boolean rnt = ObjectTextBox_init3(text, span);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectTextBox(String text, ArrayList<TextSpanInfo> span, boolean isTemplateObject) {
        super(2);
        if (span != null) {
            Iterator<TextSpanInfo> it = span.iterator();
            while (it.hasNext()) {
                TextSpanInfo temp = it.next();
                if (temp.startPos < 0 || temp.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        boolean rnt = ObjectTextBox_init5(text, span, null, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectTextBox(String text, ArrayList<TextSpanInfo> span, ArrayList<TextParagraphInfo> paras) {
        super(2);
        if (span != null) {
            Iterator<TextSpanInfo> it = span.iterator();
            while (it.hasNext()) {
                TextSpanInfo temp = it.next();
                if (temp.startPos < 0 || temp.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        boolean rnt = ObjectTextBox_init4(text, span, paras);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectTextBox(String text, ArrayList<TextSpanInfo> span, ArrayList<TextParagraphInfo> paras, boolean isTemplateObject) {
        super(2);
        if (span != null) {
            Iterator<TextSpanInfo> it = span.iterator();
            while (it.hasNext()) {
                TextSpanInfo temp = it.next();
                if (temp.startPos < 0 || temp.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        boolean rnt = ObjectTextBox_init5(text, span, paras, isTemplateObject);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRect(RectF rect, boolean regionOnly) {
        super.setRect(rect, regionOnly);
    }

    public void setText(String text) {
        boolean rnt = ObjectTextBox_setText(text);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getText() {
        return ObjectTextBox_getText();
    }

    public void insertText(String text, int position) {
        boolean rnt = ObjectTextBox_insertText(text, position);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void insertTextAtCursor(String text) {
        boolean rnt = ObjectTextBox_insertTextAtCursor(text);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeText(int startPosition, int length) {
        boolean rnt = ObjectTextBox_removeText(startPosition, length);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeAllText() {
        boolean rnt = ObjectTextBox_removeAllText();
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void replaceText(String text, int startPosition, int length) {
        boolean rnt = ObjectTextBox_replaceText(text, startPosition, length);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setCursorPos(int position) {
        String text = getText();
        if (text != null && (position < 0 || position > text.length())) {
            throw new IllegalArgumentException("position is not valid");
        }
        boolean rnt = ObjectTextBox_setCursorPos(position);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getCursorPos() {
        return ObjectTextBox_getCursorPos();
    }

    public void setSpan(ArrayList<TextSpanInfo> span) {
        if (span != null) {
            Iterator<TextSpanInfo> it = span.iterator();
            while (it.hasNext()) {
                TextSpanInfo temp = it.next();
                if (temp.startPos < 0 || temp.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        boolean rnt = ObjectTextBox_setSpan(span);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public ArrayList<TextSpanInfo> getSpan() {
        return ObjectTextBox_getSpan();
    }

    public ArrayList<TextSpanInfo> findSpans(int startPos, int endPos) {
        return ObjectTextBox_findSpans(startPos, endPos);
    }

    public void removeSpan(TextSpanInfo span) {
        boolean rnt = ObjectTextBox_removeSpan(span);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void appendSpan(TextSpanInfo span) {
        boolean rnt = ObjectTextBox_appendSpan(span);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setParagraph(ArrayList<TextParagraphInfo> paragraph) {
        boolean rnt = ObjectTextBox_setParagraph(paragraph);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public ArrayList<TextParagraphInfo> getParagraph() {
        return ObjectTextBox_getParagraph();
    }

    public ArrayList<TextParagraphInfo> findParagraphs(int startPos, int endPos) {
        return ObjectTextBox_findParagraphs(startPos, endPos);
    }

    public void removeParagraph(TextParagraphInfo paragraph) {
        boolean rnt = ObjectTextBox_removeParagraph(paragraph);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void appendParagraph(TextParagraphInfo paragraph) {
        boolean rnt = ObjectTextBox_appendParagraph(paragraph);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setMargin(float left, float top, float right, float bottom) {
        boolean rnt = ObjectTextBox_setMargin(left, top, right, bottom);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getLeftMargin() {
        return ObjectTextBox_getLeftMargin();
    }

    public float getTopMargin() {
        return ObjectTextBox_getTopMargin();
    }

    public float getRightMargin() {
        return ObjectTextBox_getRightMargin();
    }

    public float getBottomMargin() {
        return ObjectTextBox_getBottomMargin();
    }

    public void setLineBorderColor(int color) {
        boolean rnt = ObjectTextBox_setLineBorderColor(color);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getLineBorderColor() {
        return ObjectTextBox_getLineBorderColor();
    }

    public void setLineBorderWidth(float width) {
        boolean rnt = ObjectTextBox_setLineBorderWidth(width);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getLineBorderWidth() {
        return ObjectTextBox_getLineBorderWidth();
    }

    public void setBorderType(int type) {
        boolean rnt = ObjectTextBox_setBorderType(type);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getBorderType() {
        return ObjectTextBox_getBorderType();
    }

    public void setReadOnlyEnabled(boolean enable) {
        boolean rnt = ObjectTextBox_enableReadOnly(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isReadOnlyEnabled() {
        return ObjectTextBox_isReadOnly();
    }

    public void setHintText(String hintText) {
        boolean rnt = ObjectTextBox_setHintText(hintText);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getHintText() {
        return ObjectTextBox_getHintText();
    }

    public void setHintTextEnabled(boolean enable) {
        boolean rnt = ObjectTextBox_setHintTextVisibility(enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isHintTextEnabled() {
        return ObjectTextBox_isHintTextVisiable();
    }

    public void setAutoFitOption(int textAutoFit) {
        boolean rnt = ObjectTextBox_setAutoFitOption(textAutoFit);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getAutoFitOption() {
        return ObjectTextBox_getAutoFitOption();
    }

    public void parseHyperText() {
        boolean rnt = ObjectTextBox_parseHyperText();
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setGravity(int textGravity) {
        boolean rnt = ObjectTextBox_setGravity(textGravity);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getGravity() {
        return ObjectTextBox_getGravity();
    }

    public void setTextColor(int color) {
        boolean rnt = ObjectTextBox_setTextColor(color);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getTextColor() {
        return ObjectTextBox_getTextColor();
    }

    public void setBackgroundColor(int color) {
        boolean rnt = ObjectTextBox_setBackgroundColor(color);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getBackgroundColor() {
        return ObjectTextBox_getBackgroundColor();
    }

    public void setFontSize(float size) {
        boolean rnt = ObjectTextBox_setFontSize(size);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getFontSize() {
        return ObjectTextBox_getFontSize();
    }

    public void setFont(String font) {
        boolean rnt = ObjectTextBox_setFont(font);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getFont() {
        return ObjectTextBox_getFont();
    }

    public void setTextDirection(int direction) {
        boolean rnt = ObjectTextBox_setTextDirection(direction);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getTextDirection() {
        return ObjectTextBox_getTextDirection();
    }

    public void setTextStyle(int style) {
        if ((style & 7) == 0 && style != 0) {
            throw new IllegalArgumentException("style is invalid");
        }
        boolean rnt = ObjectTextBox_setTextStyle(style);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getTextStyle() {
        return ObjectTextBox_getTextStyle();
    }

    public void setTextAlignment(int align) {
        boolean rnt = ObjectTextBox_setTextAlignment(align);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getTextAlignment() {
        return ObjectTextBox_getTextAlignment();
    }

    public void setTextLineSpacingInfo(int type, float lineSpacing) {
        boolean rnt = ObjectTextBox_setTextLineSpacingInfo(type, lineSpacing);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getTextLineSpacingType() {
        return ObjectTextBox_getTextLineSpacingType();
    }

    public float getTextLineSpacing() {
        return ObjectTextBox_getTextLineSpacing();
    }

    public void setHintTextColor(int color) {
        boolean rnt = ObjectTextBox_setHintTextColor(color);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getHintTextColor() {
        return ObjectTextBox_getHintTextColor();
    }

    public void setHintTextFontSize(int size) {
        boolean rnt = ObjectTextBox_setHintTextFontSize(size);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getHintTextFontSize() {
        return ObjectTextBox_getHintTextFontSize();
    }

    public void setIMEActionType(int type) {
        boolean rnt = ObjectTextBox_setIMEActionType(type);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getIMEActionType() {
        return ObjectTextBox_getIMEActionType();
    }

    public void setTextInputType(int type) {
        boolean rnt = ObjectTextBox_setTextInputType(type);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getTextInputType() {
        return ObjectTextBox_getTextInputType();
    }

    public void setVereticalPan(float position) {
        boolean rnt = ObjectTextBox_setVerticalPan(position);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public float getVerticalPan() {
        return ObjectTextBox_getVerticalPan();
    }

    public void setEllipsisType(int type) {
        boolean rnt = ObjectTextBox_setEllipsisType(type);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getEllipsisType() {
        return ObjectTextBox_getEllipsisType();
    }

    private static ArrayList<int[]> parseHyperlink(String str) {
        ArrayList<int[]> result = new ArrayList<>();
        LinkedHashMap<Integer, String> regexList = new LinkedHashMap<>();
        regexList.put(2, "(?:\\+[0-9]+[\\- \\.]*)?(?:[0-9]{2,5}[\\- \\.]?[0-9]{3,5}[\\- \\.]?[0-9]{3,5})");
        regexList.put(5, "\\b(?:(?:[\\w]?[\\d]{1,4}[\\-\\s](?:\\d[0-9a-zA-Z]{0,3})?)|(?:\\d[0-9a-zA-Z]{0,3}))\\b(?:\\s|\\,|(?:\\&nbsp;)){1,3}[\\w -꼀](?:[ -꼀\\'\\w\\s#@\\-\\,\\.]{4,12})(?:\\s|\\,|(?:\\&nbsp;)|(?:\\&middot;)){1,3}(?i:<[^>]+>(?:[\\s\\x0d\\x0a]|(?:\\&nbsp;)){0,2}){0,5}(?:(?:(?:[a-zA-Z -꼀\\'\\s]{2,20}(?:\\s|\\,|(?:\\&nbsp;)|(?:\\&middot;)){1,3}[a-zA-Z -꼀\\']{2,10})(?:\\s|\\,|(?:\\&nbsp;)){1,3}\\b(?:(?:[\\d]{4})|(?:[a-zA-Z][a-zA-Z0-9]{1,3}[\\-\\s][0-9][a-zA-Z][a-zA-Z])|(?:[a-zA-Z][0-9][a-zA-Z][\\-\\s][0-9][a-zA-Z][0-9])|(?:[\\d]{5}(?:[\\-\\s][\\d]{4})?))\\b)|(?:\\b(?:(?:[\\d]{4})|(?:[a-zA-Z][a-zA-Z0-9]{1,3}[\\-\\s][0-9][a-zA-Z][a-zA-Z])|(?:[a-zA-Z][0-9][a-zA-Z][\\-\\s][0-9][a-zA-Z][0-9])|(?:[\\d]{5}(?:[\\-\\s][\\d]{4})?))(?:\\s|\\,|(?:\\&nbsp;)){1,3}(?:[a-zA-Z -꼀\\'\\s]{2,20}(?:\\s|\\,|(?:\\&nbsp;)|(?:\\&middot;)){1,3}[a-zA-Z -꼀\\']{2,10})\\b)|(?:(?:(?:Ankara)|(?:Athens)|(?:Atlanta)|(?:Baghdad)|(?:Bandung)|(?:Bangalore)|(?:Bangkok)|(?:Barcelona)|(?:Beijing)|(?:Berlin)|(?:Bombay)|(?:Boston)|(?:Brasillia)|(?:Buenos\\sAires)|(?:Busan)|(?:Cairo)|(?:Calcutta)|(?:Casablandca)|(?:Chicago)|(?:Chongqing)|(?:Dallas)|(?:Delhi)|(?:Detroit)|(?:Dhaka)|(?:Guangzhou)|(?:Hanoi)|(?:Hong\\sKong)|(?:Houston)|(?:Istanbul)|(?:Karachi)|(?:Jakarta)|(?:Kobe)|(?:Lagos)|(?:Lahore)|(?:Lima)|(?:London)|(?:Los\\sAngeles)|(?:Madrid)|(?:Melbourne)|(?:Metro\\sManila)|(?:Mexico\\sCity)|(?:Miami)|(?:Milan)|(?:Montreal)|(?:Moscow)|(?:Mumbai)|(?:New\\sYork)|(?:Osaka)|(?:Paris)|(?:Philadelphia)|(?:Phoenix)|(?:Pusan)|(?:Rio\\sde\\sJaneiro)|(?:Santiago)|(?:Sao\\sPaulo)|(?:Seoul)|(?:Shanghai)|(?:Shenyang)|(?:Singapore)|(?:Sydney)|(?:Tehran)|(?:Tianjin)|(?:Tokyo)|(?:Toronto)|(?:Washington(?:[\\,\\s]{1,2}[Dd][\\.]?[Cc][\\.]?))|(?:Wuhan)|(?:Xi[\\']?an))))(?:[\\s\\,][\\s]?(?:[Uu]nited\\s)?[ -꼀\\'\\w\\.]{2,20}\\b)?");
        regexList.put(1, "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}(?:\\@|(?:\\&\\#[0]*64\\;))[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(?:\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
        regexList.put(4, "(([0-9]{4}/[0-9]{1,2}/[0-9]{1,2})|([0-9]{1,2}/[0-9]{1,2}/[0-9]{2,4}))(\\s[0-9]{1,2}(:[0-9]{1,2})?(\\s(AM|Am|am|PM|Pm|pm))?)?");
        regexList.put(3, "((https?|ftp)://)?([a-z0-9+!*(),;?&=$_.-]+(:[a-z0-9+!*(),;?&=$_.-]+)?@)?([A-Za-z0-9-.]*)\\.([a-z]{2,3})(:[0-9]{2,5})?(/([A-Za-z0-9+$_-].?[A-Za-z0-9;:@&%=+/$_.-?]*)+)*/?(#[A-Za-z_.-][A-Za-z0-9+$_.-]*)?(\\W|$)");
        for (Integer key : regexList.keySet()) {
            Pattern p = Pattern.compile(regexList.get(key));
            Matcher m = p.matcher(str);
            while (m.find()) {
                int[] hyperlink = {m.start(), m.end(), key.intValue()};
                if (key.intValue() == 3 && hyperlink[1] < str.length() - 1) {
                    hyperlink[1] = hyperlink[1] - 1;
                }
                boolean contain = false;
                Iterator<int[]> it = result.iterator();
                while (it.hasNext()) {
                    int[] v = it.next();
                    if ((hyperlink[0] >= v[0] && hyperlink[0] <= v[1]) || (hyperlink[1] >= v[0] && hyperlink[1] <= v[1])) {
                        contain = true;
                        break;
                    }
                }
                if (!contain) {
                    result.add(hyperlink);
                }
            }
        }
        return result;
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void clearChangedFlag() {
        ObjectTextBox_clearChangedFlag();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public boolean isChanged() {
        return ObjectTextBox_isChanged();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public RectF getDrawnRect() {
        return ObjectTextBox_getDrawnRect();
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(SpenObjectBase source) {
        boolean rnt = ObjectTextBox_copy(source);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    private void throwUncheckedException(int errno) {
        if (errno == 19) {
            throw new SpenAlreadyClosedException("SpenObjectTextBox(" + this + ") is already closed");
        }
        SpenError.ThrowUncheckedException(errno);
    }
}
