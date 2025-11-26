package com.sec.voiceservice.translatelib;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class htmlText {
    private htmlSpecialChar mhtmlSpecialChar = null;
    private static List<String> TEXT_STR_LIST = null;
    private static List<String> TEXT_LOC_LIST = null;
    private static String HTMLTAG = "";
    private static String TEXT = "";
    private static String TAG = "";
    private static String PrevTAG = "";

    public String HTMLTextParsing(String html, boolean option) {
        TEXT_STR_LIST = new ArrayList();
        TEXT_LOC_LIST = new ArrayList();
        HTMLTAG = "";
        TAG = "";
        TEXT = "";
        PrevTAG = "";
        boolean Indicator_Start = false;
        boolean isTag = false;
        boolean bCheckTagStart = false;
        boolean bCheckTagMore = false;
        int ExceptTagNum = 0;
        HTMLTAG = html;
        int html_len = html.length();
        int i = 0;
        while (i < html_len) {
            char html_char = html.charAt(i);
            if (!isTag) {
                if (html_char == '<') {
                    if (TEXT != "") {
                        String temp = TEXT.replaceAll("\n", "");
                        if (temp.replaceAll("\t", "").replaceAll(" ", "") == "") {
                            TEXT = "";
                        } else {
                            TEXT_STR_LIST.add(TEXT);
                            TEXT_LOC_LIST.add(Integer.toString(i));
                            TEXT = "";
                        }
                    }
                    Indicator_Start = true;
                    bCheckTagStart = true;
                } else if (html_char == '>') {
                    Indicator_Start = false;
                } else if (bCheckTagMore) {
                    TAG = String.valueOf(TAG) + html_char;
                    ExceptTagNum++;
                    if (TAG.equals("!--") || TAG.equals("style") || TAG.equals("STYLE") || TAG.equals("script") || TAG.equals("SCRIPT")) {
                        PrevTAG = TAG;
                        isTag = true;
                        TAG = "";
                        ExceptTagNum = 0;
                        bCheckTagMore = false;
                    }
                    if (ExceptTagNum == 7 || TAG.equals("span") || TAG.equals("SPAN") || TAG.equals("strike") || TAG.equals("STRIKE") || TAG.equals("strong") || TAG.equals("STRONG")) {
                        TAG = "";
                        ExceptTagNum = 0;
                        bCheckTagMore = false;
                    }
                } else if (Indicator_Start) {
                    if (bCheckTagStart) {
                        if (html_char == 's' || html_char == 'S' || html_char == '!') {
                            bCheckTagMore = true;
                            TAG = String.valueOf(TAG) + html_char;
                            ExceptTagNum++;
                        }
                        bCheckTagStart = false;
                    }
                } else {
                    TEXT = String.valueOf(TEXT) + html_char;
                }
            } else if ((html_char == '<' || html_char == '-') && !bCheckTagStart) {
                bCheckTagStart = true;
            } else if (bCheckTagMore) {
                TAG = String.valueOf(TAG) + html_char;
                ExceptTagNum++;
                if (PrevTAG.equals("!--") && TAG.equals("->")) {
                    isTag = false;
                    Indicator_Start = false;
                    PrevTAG = "";
                    TAG = "";
                    ExceptTagNum = 0;
                    bCheckTagMore = false;
                }
                if ((PrevTAG.equals("style") && TAG.equals("/style>")) || (PrevTAG.equals("STYLE") && TAG.equals("/STYLE>"))) {
                    isTag = false;
                    Indicator_Start = false;
                    PrevTAG = "";
                    TAG = "";
                    ExceptTagNum = 0;
                    bCheckTagMore = false;
                }
                if ((PrevTAG.equals("script") && TAG.equals("/script>")) || (PrevTAG.equals("SCRIPT") && TAG.equals("/SCRIPT>"))) {
                    isTag = false;
                    Indicator_Start = false;
                    PrevTAG = "";
                    TAG = "";
                    ExceptTagNum = 0;
                    bCheckTagMore = false;
                }
                if (ExceptTagNum == 9) {
                    TAG = "";
                    ExceptTagNum = 0;
                    bCheckTagMore = false;
                }
            } else if (bCheckTagStart) {
                if (((PrevTAG.equals("style") || PrevTAG.equals("STYLE") || PrevTAG.equals("script") || PrevTAG.equals("SCRIPT")) && html_char == '/') || (PrevTAG.equals("!--") && html_char == '-')) {
                    bCheckTagMore = true;
                    TAG = String.valueOf(TAG) + html_char;
                    ExceptTagNum++;
                }
                bCheckTagStart = false;
            }
            i++;
        }
        TEXT_STR_LIST.add(TEXT);
        TEXT_LOC_LIST.add(Integer.toString(i));
        TEXT = "";
        String html_trans = "";
        for (int j = 0; j < TEXT_STR_LIST.size(); j++) {
            String tmp = ReplaceHTMLSC(TEXT_STR_LIST.get(j));
            if (option) {
                html_trans = String.valueOf(html_trans) + tmp.replace("\n", " --\n") + " --\n++ --\n";
            } else {
                html_trans = String.valueOf(html_trans) + (String.valueOf(tmp) + "\n");
            }
        }
        return html_trans;
    }

    public String ReplaceHTMLSCtoCode(String html_text) {
        this.mhtmlSpecialChar = new htmlSpecialChar();
        String HTML_TEXT = "";
        for (int i = 0; i < html_text.length(); i++) {
            char html_text_char = html_text.charAt(i);
            if (html_text_char == '<' || html_text_char == '>') {
                HTML_TEXT = String.valueOf(HTML_TEXT) + this.mhtmlSpecialChar.HashMap_NumCharToRealValue(String.valueOf(html_text_char));
            } else {
                HTML_TEXT = String.valueOf(HTML_TEXT) + html_text_char;
            }
        }
        return HTML_TEXT;
    }

    private String ReplaceHTMLSC(String html_text) {
        this.mhtmlSpecialChar = new htmlSpecialChar();
        String HTML_TEXT = "";
        String HTML_SC = "";
        boolean Indicator_Start = false;
        for (int i = 0; i < html_text.length(); i++) {
            char html_text_char = html_text.charAt(i);
            if (html_text_char == '&' && !Indicator_Start) {
                Indicator_Start = true;
            }
            if (Indicator_Start) {
                if (!HTML_SC.isEmpty() && html_text_char == '&') {
                    HTML_TEXT = String.valueOf(HTML_TEXT) + HTML_SC;
                    HTML_SC = "&";
                } else if (html_text_char == ';') {
                    String HTML_SC2 = String.valueOf(HTML_SC) + html_text_char;
                    Indicator_Start = false;
                    if (HTML_SC2.charAt(0) == '&' && HTML_SC2.charAt(1) == '#') {
                        HTML_TEXT = String.valueOf(HTML_TEXT) + HTML_SC2;
                    } else {
                        HTML_TEXT = String.valueOf(HTML_TEXT) + this.mhtmlSpecialChar.HashMap_RealValueToNumChar(HTML_SC2);
                    }
                    HTML_SC = "";
                } else {
                    HTML_SC = String.valueOf(HTML_SC) + html_text_char;
                }
            } else if (!Indicator_Start) {
                HTML_TEXT = String.valueOf(HTML_TEXT) + html_text_char;
            }
        }
        return HTML_TEXT;
    }

    public String ChangeOtoT(String html_trans) throws NumberFormatException {
        int offset = 0;
        String[] html_trans_array = html_trans.split("\\+\\-\\-\\+");
        StringBuffer SB_HTMLTAG = new StringBuffer(HTMLTAG);
        Log.i("HTMLTranslate", "ChangeOToT:html_trans_array_length:" + html_trans_array.length);
        for (int i = 0; i < html_trans_array.length; i++) {
            String str = html_trans_array[i];
            int loc = Integer.parseInt(TEXT_LOC_LIST.get(i));
            int oldlen = TEXT_STR_LIST.get(i).length();
            int newlen = str.length();
            SB_HTMLTAG.delete((loc - oldlen) - offset, loc - offset);
            SB_HTMLTAG.insert((loc - oldlen) - offset, str);
            offset = (offset + oldlen) - newlen;
        }
        return SB_HTMLTAG.toString();
    }
}
