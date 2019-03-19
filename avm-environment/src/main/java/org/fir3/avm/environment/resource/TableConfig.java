package org.fir3.avm.environment.resource;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Data
public class TableConfig {
    @Data
    public static class Imsi {
        private final int mcc;
        private final int mnc;
    }

    @Data
    public static class Locale {
        private final String language;
        private final String country;
    }

    public enum OrientationType implements IdProvider {
        Any(0x0000),
        Port(0x0001),
        Land(0x0002),
        Square(0x0003);

        @Getter
        private final int id;

        OrientationType(int id) {
            this.id = id;
        }
    }

    public enum TouchscreenType implements IdProvider {
        Any(0x0000),
        NoTouch(0x0001),
        Stylus(0x0002),
        Finger(0x0003);

        @Getter
        private final int id;

        TouchscreenType(int id) {
            this.id = id;
        }
    }

    public enum DensityType implements IdProvider {
        Default(0),
        Low(120),
        Medium(160),
        Tv(213),
        High(240),
        XHigh(320),
        XxHigh(480),
        XxxHigh(640),
        None(0xFFFF);

        @Getter
        private final int id;

        DensityType(int id) {
            this.id = id;
        }
    }

    @Data
    public static class ScreenType {
        private final OrientationType orientation;
        private final TouchscreenType touchscreen;
        private final DensityType density;
    }

    public enum KeyboardType implements IdProvider {
        Any(0x0000),
        NoKeys(0x0001),
        QWERTY(0x0002),
        _12Key(0x0003);

        @Getter
        private final int id;

        KeyboardType(int id) {
            this.id = id;
        }
    }

    public enum NavigationType implements IdProvider {
        Any(0x0000),
        NoNav(0x0001),
        DPad(0x0002),
        Trackball(0x0003),
        Wheel(0x0004);

        @Getter
        private final int id;

        NavigationType(int id) {
            this.id = id;
        }
    }

    public enum InputType implements IdProvider {
        KeysHidden_Any(0x0000),
        KeysHidden_No(0x0001),
        KeysHidden_Yes(0x0002),
        KeysHidden_Soft(0x0003),

        NavHidden_Any(0x0000),
        NavHidden_No(0x0004),
        NavHidden_Yes(0x0008);

        @Getter
        private final int id;

        InputType(int id) {
            this.id = id;
        }
    }

    @Data
    public static class Input {
        private final KeyboardType keyboard;
        private final NavigationType navigation;
        private final Set<InputType> input;
        private final short inputPad0;
    }

    @Data
    public static class ScreenSize {
        public static final int SCREENWIDTH_ANY = 0;
        public static final int SCREENHEIGHT_ANY = 0;

        private final int screenWidth;
        private final int screenHeight;
    }

    @Data
    public static class Version {
        private final int sdkVersion;
        private final int minorVersion;
    }

    public enum ScreenLayoutType implements IdProvider {
        ScreenSize_Any(0x00),
        ScreenSize_Small(0x01),
        ScreenSize_Normal(0x02),
        ScreenSize_Large(0x03),
        ScreenSize_XLarge(0x04),

        ScreenLong_Any(0x00),
        ScreenLong_No(0x10),
        ScreenLong_Yes(0x20),

        LayoutDir_Any(0x00),
        LayoutDir_Ltr(0x40),
        LayoutDir_Rtl(0x80);

        @Getter
        private final int id;

        ScreenLayoutType(int id) {
            this.id = id;
        }
    }

    public enum UiModeType implements IdProvider {
        Type_Any(0x00),
        Type_Normal(0x01),
        Type_Desk(0x02),
        Type_Car(0x03),
        Type_Television(0x04),
        Type_Appliance(0x05),

        Night_Any(0x00),
        Night_No(0x10),
        Night_Yes(0x20);

        @Getter
        private final int id;

        UiModeType(int id) {
            this.id = id;
        }
    }

    @Data
    public static class ScreenConfig {
        private final Set<ScreenLayoutType> screenLayout;
        private final Set<UiModeType> uiMode;
        private final int smallestScreenWidthDp;
    }

    @Data
    public static class ScreenSizeDp {
        private final int screenWidthDp;
        private final int screenHeightDp;
    }

    private final long size;
    private final Imsi imsi;
    private final Locale locale;
    private final ScreenType screenType;
    private final Input input;
    private final ScreenSize screenSize;
    private final Version version;
    private final ScreenConfig screenConfig;
    private final ScreenSizeDp screenSizeDp;
}
