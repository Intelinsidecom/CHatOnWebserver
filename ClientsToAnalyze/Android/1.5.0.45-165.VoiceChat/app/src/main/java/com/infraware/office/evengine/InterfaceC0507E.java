package com.infraware.office.evengine;

/* renamed from: com.infraware.office.evengine.E */
/* loaded from: classes.dex */
public interface InterfaceC0507E {
    public static final int EVFALSE = 0;
    public static final int EVTRUE = 1;

    /* renamed from: com.infraware.office.evengine.E$EV_BOOKMARK_TYPE */
    public interface EV_BOOKMARK_TYPE {
        public static final int eEV_BOOKMARK_DEFAULT = 1;
    }

    /* renamed from: com.infraware.office.evengine.E$EV_DOCEXTENSION_TYPE */
    public interface EV_DOCEXTENSION_TYPE {
        public static final int eEV_DOC_EXT_DOC = 2;
        public static final int eEV_DOC_EXT_DOCX = 18;
        public static final int eEV_DOC_EXT_MAX = 255;
        public static final int eEV_DOC_EXT_PDF = 6;
        public static final int eEV_DOC_EXT_PPT = 1;
        public static final int eEV_DOC_EXT_PPTX = 19;
    }

    /* renamed from: com.infraware.office.evengine.E$EV_EDITMODETYPE */
    public interface EV_EDITMODETYPE {
        public static final int eEV_EDITOR_VIEWMODE = 0;
    }

    /* renamed from: com.infraware.office.evengine.E$EV_ERROR_CODE */
    public interface EV_ERROR_CODE {
        public static final int EV_CORRUPT_FILE_ERROR = -4;
        public static final int EV_DOCUMENT_TRUNCATED = 32;
        public static final int EV_DOC_EDIT_PROTECT = -7;
        public static final int EV_FILE_CREATE_ERROR = -16;
        public static final int EV_FILE_EMPTY = -20;
        public static final int EV_FILE_NOT_MODEFIED = -19;
        public static final int EV_FILE_STORAGE_ERROR = -18;
        public static final int EV_FILE_WRITE_ERROR = -17;
        public static final int EV_FONT_INITIAL_ERROR = -8;
        public static final int EV_INTERNAL_ERROR = 0;
        public static final int EV_LONG_TIME_ERROR = -6;
        public static final int EV_MEMORY_ERROR = -1;
        public static final int EV_MEMORY_INITIAL_ERROR = -9;
        public static final int EV_MISS_OBJECT = -21;
        public static final int EV_PAGE_TRUNCATED = 16;
        public static final int EV_PASSWORD_DIFF = -22;
        public static final int EV_PASSWORD_DOC_ERROR = -5;
        public static final int EV_PROCESS_SUCCESS = 1;
        public static final int EV_REPAIRED_PAGE = 48;
        public static final int EV_UNSUPPORTED_TYPE_ERROR = -3;
        public static final int EV_UNSUPPORTED_VERSION_ERROR = -2;
    }

    /* renamed from: com.infraware.office.evengine.E$EV_GUI_EVENT */
    public interface EV_GUI_EVENT {
        public static final int eEV_DRAW_UNDERLINE = 71;
        public static final int eEV_GET_OBJECT_DATA = 70;
        public static final int eEV_GUI_APPLYBOOKMARK_EVENT = 36;
        public static final int eEV_GUI_BORDEREX_EVENT = 309;
        public static final int eEV_GUI_BORDER_EVENT = 299;
        public static final int eEV_GUI_BOTTOM_ALIGN_EVENT = 271;
        public static final int eEV_GUI_BRBOOKCLIP_EVENT = 60;
        public static final int eEV_GUI_BRFITTO_BASIC_FRAME_EVENT = 541;
        public static final int eEV_GUI_BWP_BOOKMARKEDITOR_EVENT = 531;
        public static final int eEV_GUI_BWP_BULLET_INPUT_EVENT = 520;
        public static final int eEV_GUI_BWP_CARET_MARK_EVENT = 517;
        public static final int eEV_GUI_BWP_CELL_BORDER_EVENT = 536;
        public static final int eEV_GUI_BWP_CELL_DELETE_EVENT = 526;
        public static final int eEV_GUI_BWP_CELL_INSERT_EVENT = 525;
        public static final int eEV_GUI_BWP_CELL_MERGE_EVENT = 527;
        public static final int eEV_GUI_BWP_CELL_SEPARATE_EVENT = 528;
        public static final int eEV_GUI_BWP_CHANGE_CELLSIZE_EVENT = 519;
        public static final int eEV_GUI_BWP_COLUMN_EVENT = 540;
        public static final int eEV_GUI_BWP_COMP_BACKCOLOR_EVENT = 542;
        public static final int eEV_GUI_BWP_DETAIL_MARK_EVENT = 537;
        public static final int eEV_GUI_BWP_EDITPAGE_REDRAW_BITMAP_EVENT = 522;
        public static final int eEV_GUI_BWP_GET_PAGE_THUMBNAIL_EVENT = 545;
        public static final int eEV_GUI_BWP_HIDEIMAGE_EVENT = 524;
        public static final int eEV_GUI_BWP_HYPERLINKEDITOR_EVENT = 532;
        public static final int eEV_GUI_BWP_INDENT_DECREASE_EVENT = 530;
        public static final int eEV_GUI_BWP_INDENT_INCREASE_EVENT = 529;
        public static final int eEV_GUI_BWP_INPUTIMG_EVENT = 512;
        public static final int eEV_GUI_BWP_INSERT_STRING_EVENT = 538;
        public static final int eEV_GUI_BWP_INSTABLE_EVENT = 513;
        public static final int eEV_GUI_BWP_LINESPACE_EVENT = 539;
        public static final int eEV_GUI_BWP_MULTI_SELECT_CELL_EVENT = 516;
        public static final int eEV_GUI_BWP_NUMBERING_INPUT_EVENT = 521;
        public static final int eEV_GUI_BWP_ONE_SELECT_CELL_EVENT = 515;
        public static final int eEV_GUI_BWP_POPUPOFFSET_EVENT = 533;
        public static final int eEV_GUI_BWP_SEARCHATTR_EVENT = 535;
        public static final int eEV_GUI_BWP_SELECT_MARK_CANCEL_EVENT = 518;
        public static final int eEV_GUI_BWP_SETPARAATTEX_EVENT = 543;
        public static final int eEV_GUI_BWP_SETPARAATT_EVENT = 534;
        public static final int eEV_GUI_BWP_SET_CARET_EVENT = 514;
        public static final int eEV_GUI_BWP_SHOWIMAGE_EVENT = 523;
        public static final int eEV_GUI_CANCEL_EVENT = 49;
        public static final int eEV_GUI_CARET_DOWN_EVENT = 277;
        public static final int eEV_GUI_CARET_END_EVENT = 281;
        public static final int eEV_GUI_CARET_HOME_EVENT = 280;
        public static final int eEV_GUI_CARET_LEFT_EVENT = 278;
        public static final int eEV_GUI_CARET_PAGEDOWN_EVENT = 283;
        public static final int eEV_GUI_CARET_PAGEUP_EVENT = 282;
        public static final int eEV_GUI_CARET_RIGHT_EVENT = 279;
        public static final int eEV_GUI_CARET_UP_EVENT = 276;
        public static final int eEV_GUI_CENTER_ALIGN_EVENT = 266;
        public static final int eEV_GUI_CHANGESCREEN_EVENT = 44;
        public static final int eEV_GUI_CHANGETEXTONLY_EVENT = 29;
        public static final int eEV_GUI_CHANGE_PAGE_DISPLAY = 56;
        public static final int eEV_GUI_CLOSEDOC_EVENT = 4;
        public static final int eEV_GUI_DELETECHAR_EVENT = 275;
        public static final int eEV_GUI_EDIT_COPY_EVENT = 285;
        public static final int eEV_GUI_EDIT_CUT_EVENT = 286;
        public static final int eEV_GUI_EDIT_MODE_EVENT = 256;
        public static final int eEV_GUI_EDIT_PASTE_EVENT = 287;
        public static final int eEV_GUI_FINALIZE_EVENT = 1;
        public static final int eEV_GUI_FINDWORD_EVENT = 52;
        public static final int eEV_GUI_FIRSTPAGE_EVENT = 5;
        public static final int eEV_GUI_FITTOHEIGHT_EVENT = 17;
        public static final int eEV_GUI_FITTOORIGIN_EVENT = 18;
        public static final int eEV_GUI_FITTOREFLOW_EVENT = 20;
        public static final int eEV_GUI_FITTOWHOLEPAGE_EVENT = 19;
        public static final int eEV_GUI_FITTOWIDTH_EVENT = 16;
        public static final int eEV_GUI_FLICK_EVENT = 61;
        public static final int eEV_GUI_HID_ACTION_EVENT = 284;
        public static final int eEV_GUI_HYPERLINK_EVENT = 53;
        public static final int eEV_GUI_IMAGE_EFFECT_EVENT = 310;
        public static final int eEV_GUI_IME_INSERT_EVENT = 273;
        public static final int eEV_GUI_IME_REPLACE_EVENT = 274;
        public static final int eEV_GUI_INIT_EVENT = 0;
        public static final int eEV_GUI_INPUTCHAR_EVENT = 272;
        public static final int eEV_GUI_JUSTIFY_ALIGN_EVENT = 268;
        public static final int eEV_GUI_LASTPAGE_EVENT = 10;
        public static final int eEV_GUI_LEFT_ALIGN_EVENT = 265;
        public static final int eEV_GUI_LINE_INSERT_EVENT = 295;
        public static final int eEV_GUI_MAX_EVENT = 65535;
        public static final int eEV_GUI_MEDIA_LINK = 59;
        public static final int eEV_GUI_MEMO_EVENT = 38;
        public static final int eEV_GUI_MIDDLE_ALIGN_EVENT = 270;
        public static final int eEV_GUI_NEW_EVENT = 261;
        public static final int eEV_GUI_NEXTPAGEEX_EVENT = 9;
        public static final int eEV_GUI_NEXTPAGE_EVENT = 8;
        public static final int eEV_GUI_OBJECTTEXTEDIT_EVENT = 301;
        public static final int eEV_GUI_OBJECT_ATTEX_EVENT = 308;
        public static final int eEV_GUI_OBJECT_ATT_EVENT = 294;
        public static final int eEV_GUI_OBJECT_DELETE_EVENT = 302;
        public static final int eEV_GUI_OBJECT_GRADIENT_EVENT = 298;
        public static final int eEV_GUI_OBJECT_POSITION_EVENT = 297;
        public static final int eEV_GUI_OBJECT_RESIZE_EVENT = 303;
        public static final int eEV_GUI_OPENEX_EVENT = 3;
        public static final int eEV_GUI_OPEN_EVENT = 2;
        public static final int eEV_GUI_PAGETHUMBNAIL_EVENT = 54;
        public static final int eEV_GUI_PIVOTSCREEN_EVENT = 33;
        public static final int eEV_GUI_PLAYER_EVENT = 39;
        public static final int eEV_GUI_PPT_SLIDEDELETE_EVENT = 1025;
        public static final int eEV_GUI_PPT_SLIDEDUPLICATE_EVENT = 1030;
        public static final int eEV_GUI_PPT_SLIDEINSERTEX_EVENT = 1035;
        public static final int eEV_GUI_PPT_SLIDEINSERT_EVENT = 1024;
        public static final int eEV_GUI_PPT_SLIDEMASTERLAYOUT_EVENT = 1037;
        public static final int eEV_GUI_PPT_SLIDEMOVEEX_EVENT = 1029;
        public static final int eEV_GUI_PPT_SLIDEMOVENEXT_EVENT = 1027;
        public static final int eEV_GUI_PPT_SLIDEMOVEPREV_EVENT = 1028;
        public static final int eEV_GUI_PPT_SLIDENOTEINPUT_EVENT = 1031;
        public static final int eEV_GUI_PPT_SLIDENOTE_EVENT = 1033;
        public static final int eEV_GUI_PPT_SLIDEOBJ_START_EVENT = 1032;
        public static final int eEV_GUI_PPT_SLIDESHOW_EVENT = 1034;
        public static final int eEV_GUI_PPT_TEXTBOXINSERT_EVENT = 1026;
        public static final int eEV_GUI_PREVPAGEEX_EVENT = 7;
        public static final int eEV_GUI_PREVPAGE_EVENT = 6;
        public static final int eEV_GUI_PRINTLAYOUT_MODE_EVENT = 259;
        public static final int eEV_GUI_PRINT_EVENT = 40;
        public static final int eEV_GUI_REDO_EVENT = 264;
        public static final int eEV_GUI_REDRAW_BITMAP_EVENT = 50;
        public static final int eEV_GUI_REMOVEBOOKMARK_EVENT = 37;
        public static final int eEV_GUI_RIGHT_ALIGN_EVENT = 267;
        public static final int eEV_GUI_ROTATECCW_EVENT = 32;
        public static final int eEV_GUI_ROTATECW_EVENT = 31;
        public static final int eEV_GUI_ROTATE_EVENT = 30;
        public static final int eEV_GUI_SAVE_EVENT = 262;
        public static final int eEV_GUI_SCREENMODE_BASIC_EVENT = 293;
        public static final int eEV_GUI_SCREENMODE_CONTINUE_EVENT = 292;
        public static final int eEV_GUI_SCREENMODE_THUMBNAIL_EVENT = 304;
        public static final int eEV_GUI_SCREENSCAPTURE_EVENT = 41;
        public static final int eEV_GUI_SCROLLBYPAGEMAP_EVENT = 28;
        public static final int eEV_GUI_SCROLLDOWN_EVENT = 22;
        public static final int eEV_GUI_SCROLLEND_EVENT = 26;
        public static final int eEV_GUI_SCROLLHOME_EVENT = 25;
        public static final int eEV_GUI_SCROLLLEFT_EVENT = 23;
        public static final int eEV_GUI_SCROLLRIGHT_EVENT = 24;
        public static final int eEV_GUI_SCROLLUP_EVENT = 21;
        public static final int eEV_GUI_SCROLL_EVENT = 27;
        public static final int eEV_GUI_SEARCH_END_MODEEVENT = 51;
        public static final int eEV_GUI_SEARCH_EVENT = 45;
        public static final int eEV_GUI_SECOND_DISPLAY = 58;
        public static final int eEV_GUI_SELECT_ALL_EVENT = 288;
        public static final int eEV_GUI_SEND_INTERNAL_STRING = 57;
        public static final int eEV_GUI_SETBOOKMARK_EVENT = 35;
        public static final int eEV_GUI_SETCOLORSEX_EVENT = 544;
        public static final int eEV_GUI_SETCOLORS_EVENT = 300;
        public static final int eEV_GUI_SETFONTEX_EVENT = 306;
        public static final int eEV_GUI_SETFONT_EVENT = 289;
        public static final int eEV_GUI_SETPAGE_EVENT = 11;
        public static final int eEV_GUI_SETREGIONZOOM_EVENT = 15;
        public static final int eEV_GUI_SETTHUMBNAIL_EVENT = 42;
        public static final int eEV_GUI_SETZOOM_EVENT = 14;
        public static final int eEV_GUI_SHAPE_INSERTEX_EVENT = 305;
        public static final int eEV_GUI_SHAPE_INSERT_EVENT = 296;
        public static final int eEV_GUI_SHEET_ALIGNMENT_EVENT = 769;
        public static final int eEV_GUI_SHEET_CHART_EVENT = 790;
        public static final int eEV_GUI_SHEET_COLOR_EVENT = 768;
        public static final int eEV_GUI_SHEET_COLUMN_WIDTH_EVENT = 783;
        public static final int eEV_GUI_SHEET_DELETE_ALL_EVENT = 786;
        public static final int eEV_GUI_SHEET_DELETE_CONTENT_EVENT = 784;
        public static final int eEV_GUI_SHEET_DELETE_FORMAT_EVENT = 785;
        public static final int eEV_GUI_SHEET_EDIT_EVENT = 773;
        public static final int eEV_GUI_SHEET_FIXFRAME_EVENT = 774;
        public static final int eEV_GUI_SHEET_FOCUS_EVENT = 788;
        public static final int eEV_GUI_SHEET_FORMAT_EVENT = 770;
        public static final int eEV_GUI_SHEET_FUNCTION_EVENT = 771;
        public static final int eEV_GUI_SHEET_INPUTFIELD_EVENT = 789;
        public static final int eEV_GUI_SHEET_INSERT_CELL_EVENT = 777;
        public static final int eEV_GUI_SHEET_INSERT_COL_EVENT = 779;
        public static final int eEV_GUI_SHEET_INSERT_ROW_EVENT = 778;
        public static final int eEV_GUI_SHEET_MERGE_EVENT = 791;
        public static final int eEV_GUI_SHEET_PAGEBREAK_EVENT = 775;
        public static final int eEV_GUI_SHEET_PROTECTION_EVENT = 776;
        public static final int eEV_GUI_SHEET_RECALCULATE_EVENT = 772;
        public static final int eEV_GUI_SHEET_ROW_HEIGHT_EVENT = 782;
        public static final int eEV_GUI_SHEET_SHOW_COL_EVENT = 781;
        public static final int eEV_GUI_SHEET_SHOW_ROW_EVENT = 780;
        public static final int eEV_GUI_SHEET_SORT_EVENT = 787;
        public static final int eEV_GUI_TABLEPROPERTY_PREVIEW_EVENT = 291;
        public static final int eEV_GUI_TEXT_MODE_EVENT = 260;
        public static final int eEV_GUI_THREAD_RESUME = 48;
        public static final int eEV_GUI_THREAD_SUSPEND = 47;
        public static final int eEV_GUI_TIMER = 46;
        public static final int eEV_GUI_TOP_ALIGN_EVENT = 269;
        public static final int eEV_GUI_UNDOEX_EVENT = 307;
        public static final int eEV_GUI_UNDO_EVENT = 263;
        public static final int eEV_GUI_USEBOOKMARK_EVENT = 34;
        public static final int eEV_GUI_USEMAGNIFIER_EVENT = 43;
        public static final int eEV_GUI_VIEW_MODE_EVENT = 257;
        public static final int eEV_GUI_WEBLAYOUT_MODE_EVENT = 258;
        public static final int eEV_GUI_ZOOMIN_EVENT = 12;
        public static final int eEV_GUI_ZOOMOUT_EVENT = 13;
        public static final int eEV_PPT_SLIDEOBJ_STARTEX_EVENT = 1036;
        public static final int eEV_SETFONT_PREVIEW_EVENT = 290;
    }

    /* renamed from: com.infraware.office.evengine.E$EV_PRINT_PAGER_TYPE */
    public interface EV_PRINT_PAGER_TYPE {
        public static final int eEV_PRINT_A4_100 = 2;
        public static final int eEV_PRINT_A4_150 = 3;
        public static final int eEV_PRINT_A4_200 = 4;
        public static final int eEV_PRINT_A4_300 = 5;
        public static final int eEV_PRINT_A4_600 = 6;
        public static final int eEV_PRINT_A4_72 = 1;
        public static final int eEV_PRINT_CURRENT = 0;
    }

    /* renamed from: com.infraware.office.evengine.E$EV_SCROLL_MODE */
    public interface EV_SCROLL_MODE {
        public static final int eEV_DEFAULT_SCROLL = 0;
    }
}
