package com.yotharit.artistra.common.constant;

import java.text.DecimalFormat;

public class Constant {
    public static final DecimalFormat CURRENCY_INTEGER = new DecimalFormat("#,###");
    public static final DecimalFormat CURRENCY_REAL = new DecimalFormat("#,###.##");

    public static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-zA-Z0-9._-]+";

    public static final int ANIM_DEFAULT = -1;
    public static final int ANIM_FADE = 0;
    public static final int ANIM_SLIDE_UP = 1;
    public static final int ANIM_SLIDE_DOWN = 2;
    public static final int ANIM_SLIDE_LEFT = 3;
    public static final int ANIM_SLIDE_RIGHT = 4;
}
