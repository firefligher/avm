package android.content;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import lombok.extern.java.Log;
import org.xmlpull.v1.XmlPullParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Log
public class Intent implements Parcelable, Cloneable {
    @Log
    public static final class FilterComparison {
        public Intent getIntent() {
            log.warning("Unimplemented method: android.content.Intent$FilterComparison.getIntent()");
            return null;
        }
    }

    @Log
    public static final class ShortcutIconResource implements Parcelable {
        public static final Creator<ShortcutIconResource> CREATOR = new Creator<ShortcutIconResource>() {
            @Override
            public ShortcutIconResource createFromParcel(Parcel source) {
                log.warning("Unimplemented method: android.content.Intent$ShortcutIconResource.CREATOR" +
                        ".createFromParcel(android.os.Parcel)");

                return null;
            }

            @Override
            public ShortcutIconResource[] newArray(int size) {
                return new ShortcutIconResource[size];
            }
        };

        public static ShortcutIconResource fromContext(Context context, int resourceId) {
            log.warning("Unimplemented method: android.content.Intent$ShortcutIconResource.fromContext(" +
                    "android.content.Context, int)");

            return null;
        }

        public String packageName;
        public String resourceName;

        @Override
        public int describeContents() {
            log.warning("Unimplemented method: android.content.Intent$ShortcutIconResource.describeContents()");
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            log.warning("Unimplemented method: android.content.Intent$ShortcutIconResource.writeToParcel(" +
                    "android.os.Parcel, int)");
        }
    }

    public static final String ACTION_AIRPLANE_MODE_CHANGED             = "android.intent.action.AIRPLANE_MODE";
    public static final String ACTION_ALL_APPS                          = "android.intent.action.ALL_APPS";
    public static final String ACTION_ANSWER                            = "android.intent.action.ANSWER";
    public static final String ACTION_APPLICATION_PREFERENCES           =
            "android.intent.action.APPLICATION_PREFERENCES";

    public static final String ACTION_APPLICATION_RESTRICTIONS_CHANGED  =
            "android.intent.action.APPLICATION_RESTRICTIONS_CHANGED";

    public static final String ACTION_APP_ERROR                         = "android.intent.action.APP_ERROR";
    public static final String ACTION_ASSIST                            = "android.intent.action.ASSIST";
    public static final String ACTION_ATTACH_DATA                       = "android.intent.action.ATTACH_DATA";
    public static final String ACTION_BATTERY_CHANGED                   = "android.intent.action.BATTERY_CHANGED";
    public static final String ACTION_BATTERY_LOW                       = "android.intent.action.BATTERY_LOW";
    public static final String ACTION_BATTERY_OKAY                      = "android.intent.action.BATTERY_OKAY";
    public static final String ACTION_BOOT_COMPLETED                    = "android.intent.action.BOOT_COMPLETED";
    public static final String ACTION_BUG_REPORT                        = "android.intent.action.BUG_REPORT";
    public static final String ACTION_CALL                              = "android.intent.action.CALL";
    public static final String ACTION_CALL_BUTTON                       = "android.intent.action.CALL_BUTTON";
    public static final String ACTION_CAMERA_BUTTON                     = "android.intent.action.CAMERA_BUTTON";
    public static final String ACTION_CARRIER_SETUP                     = "android.intent.action.CARRIER_SETUP";
    public static final String ACTION_CHOOSER                           = "android.intent.action.CHOOSER";
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS              = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    public static final String ACTION_CONFIGURATION_CHANGED             = "android.intent.action.CONFIGURATION_CHANGED";
    public static final String ACTION_CREATE_DOCUMENT                   = "android.intent.action.CREATE_DOCUMENT";
    public static final String ACTION_CREATE_SHORTCUT                   = "android.intent.action.CREATE_SHORTCUT";
    public static final String ACTION_DATE_CHANGED                      = "android.intent.action.DATE_CHANGED";
    public static final String ACTION_DEFAULT                           = "android.intent.action.VIEW";
    public static final String ACTION_DEFINE                            = "android.intent.action.DEFINE";
    public static final String ACTION_DELETE                            = "android.intent.action.DELETE";
    public static final String ACTION_DEVICE_STORAGE_LOW                = "android.intent.action.DEVICE_STORAGE_LOW";
    public static final String ACTION_DEVICE_STORAGE_OK                 = "android.intent.action.DEVICE_STORAGE_OK";
    public static final String ACTION_DIAL                              = "android.intent.action.DIAL";
    public static final String ACTION_DOCK_EVENT                        = "android.intent.action.DOCK_EVENT";
    public static final String ACTION_DREAMING_STARTED                  = "android.intent.action.DREAMING_STARTED";
    public static final String ACTION_DREAMING_STOPPED                  = "android.intent.action.DREAMING_STOPPED";
    public static final String ACTION_EDIT                              = "android.intent.action.EDIT";
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE   =
            "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";

    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
            "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";

    public static final String ACTION_FACTORY_TEST                      = "android.intent.action.FACTORY_TEST";
    public static final String ACTION_GET_CONTENT                       = "android.intent.action.GET_CONTENT";
    public static final String ACTION_GET_RESTRICTION_ENTRIES           =
            "android.intent.action.GET_RESTRICTION_ENTRIES";

    public static final String ACTION_GTALK_SERVICE_CONNECTED           = "android.intent.action.GTALK_CONNECTED";
    public static final String ACTION_GTALK_SERVICE_DISCONNECTED        = "android.intent.action.GTALK_DISCONNECTED";
    public static final String ACTION_HEADSET_PLUG                      = "android.intent.action.HEADSET_PLUG";
    public static final String ACTION_INPUT_METHOD_CHANGED              = "android.intent.action.INPUT_METHOD_CHANGED";
    public static final String ACTION_INSERT                            = "android.intent.action.INSERT";
    public static final String ACTION_INSERT_OR_EDIT                    = "android.intent.action.INSERT_OR_EDIT";
    public static final String ACTION_INSTALL_FAILURE                   = "android.intent.action.INSTALL_FAILURE";
    public static final String ACTION_INSTALL_PACKAGE                   = "android.intent.action.INSTALL_PACKAGE";
    public static final String ACTION_LOCALE_CHANGED                    = "android.intent.action.LOCALE_CHANGED";
    public static final String ACTION_LOCKED_BOOT_COMPLETED             = "android.intent.action.LOCKED_BOOT_COMPLETED";
    public static final String ACTION_MAIN                              = "android.intent.action.MAIN";
    public static final String ACTION_MANAGED_PROFILE_ADDED             = "android.intent.action.MANAGED_PROFILE_ADDED";
    public static final String ACTION_MANAGED_PROFILE_AVAILABLE         =
            "android.intent.action.MANAGED_PROFILE_AVAILABLE";

    public static final String ACTION_MANAGED_PROFILE_REMOVED           =
            "android.intent.action.MANAGED_PROFILE_REMOVED";

    public static final String ACTION_MANAGED_PROFILE_UNAVAILABLE       =
            "android.intent.action.MANAGED_PROFILE_UNAVAILABLE";

    public static final String ACTION_MANAGED_PROFILE_UNLOCKED          =
            "android.intent.action.MANAGED_PROFILE_UNLOCKED";

    public static final String ACTION_MANAGE_NETWORK_USAGE              = "android.intent.action.MANAGE_NETWORK_USAGE";
    public static final String ACTION_MANAGE_PACKAGE_STORAGE            =
            "android.intent.action.MANAGE_PACKAGE_STORAGE";

    public static final String ACTION_MEDIA_BAD_REMOVAL                 = "android.intent.action.MEDIA_BAD_REMOVAL";
    public static final String ACTION_MEDIA_BUTTON                      = "android.intent.action.MEDIA_BUTTON";
    public static final String ACTION_MEDIA_CHECKING                    = "android.intent.action.MEDIA_CHECKING";
    public static final String ACTION_MEDIA_EJECT                       = "android.intent.action.MEDIA_EJECT";
    public static final String ACTION_MEDIA_MOUNTED                     = "android.intent.action.MEDIA_MOUNTED";
    public static final String ACTION_MEDIA_NOFS                        = "android.intent.action.MEDIA_NOFS";
    public static final String ACTION_MEDIA_REMOVED                     = "android.intent.action.MEDIA_REMOVED";
    public static final String ACTION_MEDIA_SCANNER_FINISHED            =
            "android.intent.action.MEDIA_SCANNER_FINISHED";

    public static final String ACTION_MEDIA_SCANNER_SCAN_FILE           =
            "android.intent.action.MEDIA_SCANNER_SCAN_FILE";

    public static final String ACTION_MEDIA_SCANNER_SCAN_VOLUME         =
            "android.intent.action.MEDIA_SCANNER_SCAN_VOLUME";

    public static final String ACTION_MEDIA_SCANNER_STARTED             = "android.intent.action.MEDIA_SCANNER_STARTED";
    public static final String ACTION_MEDIA_SHARED                      = "android.intent.action.MEDIA_SHARED";
    public static final String ACTION_MEDIA_UNMOUNTABLE                 = "android.intent.action.MEDIA_UNMOUNTABLE";
    public static final String ACTION_MEDIA_UNMOUNTED                   = "android.intent.action.MEDIA_UNMOUNTED";
    public static final String ACTION_MY_PACKAGE_REPLACED               = "android.intent.action.MY_PACKAGE_REPLACED";
    public static final String ACTION_MY_PACKAGE_SUSPENDED              = "android.intent.action.MY_PACKAGE_SUSPENDED";
    public static final String ACTION_MY_PACKAGE_UNSUSPENDED            =
            "android.intent.action.MY_PACKAGE_UNSUSPENDED";

    public static final String ACTION_NEW_OUTGOING_CALL                 = "android.intent.action.NEW_OUTGOING_CALL";
    public static final String ACTION_OPEN_DOCUMENT                     = "android.intent.action.OPEN_DOCUMENT";
    public static final String ACTION_OPEN_DOCUMENT_TREE                = "android.intent.action.OPEN_DOCUMENT_TREE";
    public static final String ACTION_PACKAGES_SUSPENDED                = "android.intent.action.PACKAGES_SUSPENDED";
    public static final String ACTION_PACKAGES_UNSUSPENDED              = "android.intent.action.PACKAGES_UNSUSPENDED";
    public static final String ACTION_PACKAGE_ADDED                     = "android.intent.action.PACKAGE_ADDED";
    public static final String ACTION_PACKAGE_CHANGED                   = "android.intent.action.PACKAGE_CHANGED";
    public static final String ACTION_PACKAGE_DATA_CLEARED              = "android.intent.action.PACKAGE_DATA_CLEARED";
    public static final String ACTION_PACKAGE_FIRST_LAUNCH              = "android.intent.action.PACKAGE_FIRST_LAUNCH";
    public static final String ACTION_PACKAGE_FULLY_REMOVED             = "android.intent.action.PACKAGE_FULLY_REMOVED";
    public static final String ACTION_PACKAGE_INSTALL                   = "android.intent.action.PACKAGE_INSTALL";
    public static final String ACTION_PACKAGE_NEEDS_VERIFICATION        =
            "android.intent.action.PACKAGE_NEEDS_VERIFICATION";

    public static final String ACTION_PACKAGE_REMOVED                   = "android.intent.action.PACKAGE_REMOVED";
    public static final String ACTION_PACKAGE_REPLACED                  = "android.intent.action.PACKAGE_REPLACED";
    public static final String ACTION_PACKAGE_RESTARTED                 = "android.intent.action.PACKAGE_RESTARTED";
    public static final String ACTION_PACKAGE_VERIFIED                  = "android.intent.action.PACKAGE_VERIFIED";
    public static final String ACTION_PASTE                             = "android.intent.action.PASTE";
    public static final String ACTION_PICK                              = "android.intent.action.PICK";
    public static final String ACTION_PICK_ACTIVITY                     = "android.intent.action.PICK_ACTIVITY";
    public static final String ACTION_POWER_CONNECTED                   =
            "android.intent.action.ACTION_POWER_CONNECTED";

    public static final String ACTION_POWER_DISCONNECTED                =
            "android.intent.action.ACTION_POWER_DISCONNECTED";

    public static final String ACTION_POWER_USAGE_SUMMARY               = "android.intent.action.POWER_USAGE_SUMMARY";
    public static final String ACTION_PROCESS_TEXT                      = "android.intent.action.PROCESS_TEXT";
    public static final String ACTION_PROVIDER_CHANGED                  = "android.intent.action.PROVIDER_CHANGED";
    public static final String ACTION_QUICK_CLOCK                       = "android.intent.action.QUICK_CLOCK";
    public static final String ACTION_QUICK_VIEW                        = "android.intent.action.QUICK_VIEW";
    public static final String ACTION_REBOOT                            = "android.intent.action.REBOOT";
    public static final String ACTION_RUN                               = "android.intent.action.RUN";
    public static final String ACTION_SCREEN_OFF                        = "android.intent.action.SCREEN_OFF";
    public static final String ACTION_SCREEN_ON                         = "android.intent.action.SCREEN_ON";
    public static final String ACTION_SEARCH                            = "android.intent.action.SEARCH";
    public static final String ACTION_SEARCH_LONG_PRESS                 = "android.intent.action.SEARCH_LONG_PRESS";
    public static final String ACTION_SEND                              = "android.intent.action.SEND";
    public static final String ACTION_SENDTO                            = "android.intent.action.SENDTO";
    public static final String ACTION_SEND_MULTIPLE                     = "android.intent.action.SEND_MULTIPLE";
    public static final String ACTION_SET_WALLPAPER                     = "android.intent.action.SET_WALLPAPER";
    public static final String ACTION_SHOW_APP_INFO                     = "android.intent.action.SHOW_APP_INFO";
    public static final String ACTION_SHUTDOWN                          = "android.intent.action.ACTION_SHUTDOWN";
    public static final String ACTION_SYNC                              = "android.intent.action.SYNC";
    public static final String ACTION_SYSTEM_TUTORIAL                   = "android.intent.action.SYSTEM_TUTORIAL";
    public static final String ACTION_TIMEZONE_CHANGED                  = "android.intent.action.TIMEZONE_CHANGED";
    public static final String ACTION_TIME_CHANGED                      = "android.intent.action.TIME_SET";
    public static final String ACTION_TIME_TICK                         = "android.intent.action.TIME_TICK";
    public static final String ACTION_TRANSLATE                         = "android.intent.action.TRANSLATE";
    public static final String ACTION_UID_REMOVED                       = "android.intent.action.UID_REMOVED";
    public static final String ACTION_UMS_CONNECTED                     = "android.intent.action.UMS_CONNECTED";
    public static final String ACTION_UMS_DISCONNECTED                  = "android.intent.action.UMS_DISCONNECTED";
    public static final String ACTION_UNINSTALL_PACKAGE                 = "android.intent.action.UNINSTALL_PACKAGE";
    public static final String ACTION_USER_BACKGROUND                   = "android.intent.action.USER_BACKGROUND";
    public static final String ACTION_USER_FOREGROUND                   = "android.intent.action.USER_FOREGROUND";
    public static final String ACTION_USER_INITIALIZE                   = "android.intent.action.USER_INITIALIZE";
    public static final String ACTION_USER_PRESENT                      = "android.intent.action.USER_PRESENT";
    public static final String ACTION_USER_UNLOCKED                     = "android.intent.action.USER_UNLOCKED";
    public static final String ACTION_VIEW                              = "android.intent.action.VIEW";
    public static final String ACTION_VOICE_COMMAND                     = "android.intent.action.VOICE_COMMAND";
    public static final String ACTION_WALLPAPER_CHANGED                 = "android.intent.action.WALLPAPER_CHANGED";
    public static final String ACTION_WEB_SEARCH                        = "android.intent.action.WEB_SEARCH";

    public static final String CATEGORY_ALTERNATIVE                     = "android.intent.category.ALTERNATIVE";
    public static final String CATEGORY_APP_BROWSER                     = "android.intent.category.APP_BROWSER";
    public static final String CATEGORY_APP_CALCULATOR                  = "android.intent.category.APP_CALCULATOR";
    public static final String CATEGORY_APP_CALENDAR                    = "android.intent.category.APP_CALENDAR";
    public static final String CATEGORY_APP_CONTACTS                    = "android.intent.category.APP_CONTACTS";
    public static final String CATEGORY_APP_EMAIL                       = "android.intent.category.APP_EMAIL";
    public static final String CATEGORY_APP_GALLERY                     = "android.intent.category.APP_GALLERY";
    public static final String CATEGORY_APP_MAPS                        = "android.intent.category.APP_MAPS";
    public static final String CATEGORY_APP_MARKET                      = "android.intent.category.APP_MARKET";
    public static final String CATEGORY_APP_MESSAGING                   = "android.intent.category.APP_MESSAGING";
    public static final String CATEGORY_APP_MUSIC                       = "android.intent.category.APP_MUSIC";
    public static final String CATEGORY_BROWSABLE                       = "android.intent.category.BROWSABLE";
    public static final String CATEGORY_CAR_DOCK                        = "android.intent.category.CAR_DOCK";
    public static final String CATEGORY_CAR_MODE                        = "android.intent.category.CAR_MODE";
    public static final String CATEGORY_DEFAULT                         = "android.intent.category.DEFAULT";
    public static final String CATEGORY_DESK_DOCK                       = "android.intent.category.DESK_DOCK";
    public static final String CATEGORY_DEVELOPMENT_PREFERENCE          =
            "android.intent.category.DEVELOPMENT_PREFERENCE";

    public static final String CATEGORY_EMBED                           = "android.intent.category.EMBED";
    public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST  =
            "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";

    public static final String CATEGORY_HE_DESK_DOCK                    = "android.intent.category.HE_DESK_DOCK";
    public static final String CATEGORY_HOME                            = "android.intent.category.HOME";
    public static final String CATEGORY_INFO                            = "android.intent.category.INFO";
    public static final String CATEGORY_LAUNCHER                        = "android.intent.category.LAUNCHER";
    public static final String CATEGORY_LEANBACK_LAUNCHER               = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String CATEGORY_LE_DESK_DOCK                    = "android.intent.category.LE_DESK_DOCK";
    public static final String CATEGORY_MONKEY                          = "android.intent.category.MONKEY";
    public static final String CATEGORY_OPENABLE                        = "android.intent.category.OPENABLE";
    public static final String CATEGORY_PREFERENCE                      = "android.intent.category.PREFERENCE";
    public static final String CATEGORY_SAMPLE_CODE                     = "android.intent.category.SAMPLE_CODE";
    public static final String CATEGORY_SECONDARY_HOME                  = "android.intent.category.SECONDARY_HOME";
    public static final String CATEGORY_SELECTED_ALTERNATIVE            =
            "android.intent.category.SELECTED_ALTERNATIVE";

    public static final String CATEGORY_TAB                             = "android.intent.category.TAB";
    public static final String CATEGORY_TEST                            = "android.intent.category.TEST";
    public static final String CATEGORY_TYPED_OPENABLE                  = "android.intent.category.TYPED_OPENABLE";
    public static final String CATEGORY_UNIT_TEST                       = "android.intent.category.UNIT_TEST";
    public static final String CATEGORY_VOICE                           = "android.intent.category.VOICE";
    public static final String CATEGORY_VR_HOME                         = "android.intent.category.VR_HOME";

    public static final String EXTRA_ALARM_COUNT                        = "android.intent.extra.ALARM_COUNT";
    public static final String EXTRA_ALLOW_MULTIPLE                     = "android.intent.extra.ALLOW_MULTIPLE";
    public static final String EXTRA_ALLOW_REPLACE                      = "android.intent.extra.ALLOW_REPLACE";
    public static final String EXTRA_ALTERNATE_INTENTS                  = "android.intent.extra.ALTERNATE_INTENTS";
    public static final String EXTRA_ASSIST_CONTEXT                     = "android.intent.extra.ASSIST_CONTEXT";
    public static final String EXTRA_ASSIST_INPUT_DEVICE_ID             = "android.intent.extra.ASSIST_INPUT_DEVICE_ID";
    public static final String EXTRA_ASSIST_INPUT_HINT_KEYBOARD         =
            "android.intent.extra.ASSIST_INPUT_HINT_KEYBOARD";

    public static final String EXTRA_ASSIST_PACKAGE                     = "android.intent.extra.ASSIST_PACKAGE";
    public static final String EXTRA_ASSIST_UID                         = "android.intent.extra.ASSIST_UID";
    public static final String EXTRA_AUTO_LAUNCH_SINGLE_CHOICE          =
            "android.intent.extra.AUTO_LAUNCH_SINGLE_CHOICE";

    public static final String EXTRA_BCC                                = "android.intent.extra.BCC";
    public static final String EXTRA_BUG_REPORT                         = "android.intent.extra.BUG_REPORT";
    public static final String EXTRA_CC                                 = "android.intent.extra.CC";
    public static final String EXTRA_CHANGED_COMPONENT_NAME             = "android.intent.extra.changed_component_name";
    public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST        =
            "android.intent.extra.changed_component_name_list";

    public static final String EXTRA_CHANGED_PACKAGE_LIST               = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST                   = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_CHOOSER_REFINEMENT_INTENT_SENDER   =
            "android.intent.extra.CHOOSER_REFINEMENT_INTENT_SENDER";

    public static final String EXTRA_CHOOSER_TARGETS                    = "android.intent.extra.CHOOSER_TARGETS";
    public static final String EXTRA_CHOSEN_COMPONENT                   = "android.intent.extra.CHOSEN_COMPONENT";
    public static final String EXTRA_CHOSEN_COMPONENT_INTENT_SENDER     =
            "android.intent.extra.CHOSEN_COMPONENT_INTENT_SENDER";

    public static final String EXTRA_COMPONENT_NAME                     = "android.intent.extra.COMPONENT_NAME";
    public static final String EXTRA_CONTENT_ANNOTATIONS                = "android.intent.extra.CONTENT_ANNOTATIONS";
    public static final String EXTRA_CONTENT_QUERY                      = "android.intent.extra.CONTENT_QUERY";
    public static final String EXTRA_DATA_REMOVED                       = "android.intent.extra.DATA_REMOVED";
    public static final String EXTRA_DOCK_STATE                         = "android.intent.extra.DOCK_STATE";
    public static final String EXTRA_DONT_KILL_APP                      = "android.intent.extra.DONT_KILL_APP";
    public static final String EXTRA_DURATION_MILLIS                    = "android.intent.extra.DURATION_MILLIS";
    public static final String EXTRA_EMAIL                              = "android.intent.extra.EMAIL";
    public static final String EXTRA_EXCLUDE_COMPONENTS                 = "android.intent.extra.EXCLUDE_COMPONENTS";
    public static final String EXTRA_FROM_STORAGE                       = "android.intent.extra.FROM_STORAGE";
    public static final String EXTRA_HTML_TEXT                          = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_INDEX                              = "android.intent.extra.INDEX";
    public static final String EXTRA_INITIAL_INTENTS                    = "android.intent.extra.INITIAL_INTENTS";
    public static final String EXTRA_INSTALLER_PACKAGE_NAME             = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    public static final String EXTRA_INTENT                             = "android.intent.extra.INTENT";
    public static final String EXTRA_KEY_EVENT                          = "android.intent.extra.KEY_EVENT";
    public static final String EXTRA_LOCAL_ONLY                         = "android.intent.extra.LOCAL_ONLY";
    public static final String EXTRA_MIME_TYPES                         = "android.intent.extra.MIME_TYPES";
    public static final String EXTRA_NOT_UNKNOWN_SOURCE                 = "android.intent.extra.NOT_UNKNOWN_SOURCE";
    public static final String EXTRA_ORIGINATING_URI                    = "android.intent.extra.ORIGINATING_URI";
    public static final String EXTRA_PACKAGE_NAME                       = "android.intent.extra.PACKAGE_NAME";
    public static final String EXTRA_PHONE_NUMBER                       = "android.intent.extra.PHONE_NUMBER";
    public static final String EXTRA_PROCESS_TEXT                       = "android.intent.extra.PROCESS_TEXT";
    public static final String EXTRA_PROCESS_TEXT_READONLY              = "android.intent.extra.PROCESS_TEXT_READONLY";
    public static final String EXTRA_QUICK_VIEW_FEATURES                = "android.intent.extra.QUICK_VIEW_FEATURES";
    public static final String EXTRA_QUIET_MODE                         = "android.intent.extra.QUIET_MODE";
    public static final String EXTRA_REFERRER                           = "android.intent.extra.REFERRER";
    public static final String EXTRA_REFERRER_NAME                      = "android.intent.extra.REFERRER_NAME";
    public static final String EXTRA_REMOTE_INTENT_TOKEN                = "android.intent.extra.remote_intent_token";
    public static final String EXTRA_REPLACEMENT_EXTRAS                 = "android.intent.extra.REPLACEMENT_EXTRAS";
    public static final String EXTRA_REPLACING                          = "android.intent.extra.REPLACING";
    public static final String EXTRA_RESTRICTIONS_BUNDLE                = "android.intent.extra.restrictions_bundle";
    public static final String EXTRA_RESTRICTIONS_INTENT                = "android.intent.extra.restrictions_intent";
    public static final String EXTRA_RESTRICTIONS_LIST                  = "android.intent.extra.restrictions_list";
    public static final String EXTRA_RESULT_RECEIVER                    = "android.intent.extra.RESULT_RECEIVER";
    public static final String EXTRA_RETURN_RESULT                      = "android.intent.extra.RETURN_RESULT";
    public static final String EXTRA_SHORTCUT_ICON                      = "android.intent.extra.shortcut.ICON";
    public static final String EXTRA_SHORTCUT_ICON_RESOURCE             = "android.intent.extra.shortcut.ICON_RESOURCE";
    public static final String EXTRA_SHORTCUT_ID                        = "android.intent.extra.shortcut.ID";
    public static final String EXTRA_SHORTCUT_INTENT                    = "android.intent.extra.shortcut.INTENT";
    public static final String EXTRA_SHORTCUT_NAME                      = "android.intent.extra.shortcut.NAME";
    public static final String EXTRA_SHUTDOWN_USERSPACE_ONLY            =
            "android.intent.extra.SHUTDOWN_USERSPACE_ONLY";

    public static final String EXTRA_SPLIT_NAME                         = "android.intent.extra.SPLIT_NAME";
    public static final String EXTRA_STREAM                             = "android.intent.extra.STREAM";
    public static final String EXTRA_SUBJECT                            = "android.intent.extra.SUBJECT";
    public static final String EXTRA_SUSPENDED_PACKAGE_EXTRAS           =
            "android.intent.extra.SUSPENDED_PACKAGE_EXTRAS";

    public static final String EXTRA_TEMPLATE                           = "android.intent.extra.TEMPLATE";
    public static final String EXTRA_TEXT                               = "android.intent.extra.TEXT";
    public static final String EXTRA_TITLE                              = "android.intent.extra.TITLE";
    public static final String EXTRA_UID                                = "android.intent.extra.UID";
    public static final String EXTRA_USER                               = "android.intent.extra.USER";

    public static final int EXTRA_DOCK_STATE_UNDOCKED   = 0x00000000;
    public static final int EXTRA_DOCK_STATE_DESK       = 0x00000001;
    public static final int EXTRA_DOCK_STATE_CAR        = 0x00000002;
    public static final int EXTRA_DOCK_STATE_LE_DESK    = 0x00000003;
    public static final int EXTRA_DOCK_STATE_HE_DESK    = 0x00000004;

    public static final int FILL_IN_ACTION          = 0x00000001;
    public static final int FILL_IN_DATA            = 0x00000002;
    public static final int FILL_IN_CATEGORIES      = 0x00000004;
    public static final int FILL_IN_COMPONENT       = 0x00000008;
    public static final int FILL_IN_PACKAGE         = 0x00000010;
    public static final int FILL_IN_SOURCE_BOUNDS   = 0x00000020;
    public static final int FILL_IN_SELECTOR        = 0x00000040;
    public static final int FILL_IN_CLIP_DATA       = 0x00000080;

    public static final int FLAG_GRANT_READ_URI_PERMISSION          = 0x00000001;
    public static final int FLAG_GRANT_WRITE_URI_PERMISSION         = 0x00000002;
    public static final int FLAG_FROM_BACKGROUND                    = 0x00000004;
    public static final int FLAG_DEBUG_LOG_RESOLUTION               = 0x00000008;
    public static final int FLAG_EXCLUDE_STOPPED_PACKAGES           = 0x00000010;
    public static final int FLAG_GRANT_PERSISTABLE_URI_PERMISSION   = 0x00000040;
    public static final int FLAG_GRANT_PREFIX_URI_PERMISSION        = 0x00000080;
    public static final int FLAG_DIRECT_BOOT_AUTO                   = 0x00000100;
    public static final int FLAG_ACTIVITY_MATCH_EXTERNAL            = 0x00000800;
    public static final int FLAG_ACTIVITY_LAUNCH_ADJACENT           = 0x00001000;
    public static final int FLAG_ACTIVITY_RETAIN_IN_RECENTS         = 0x00002000;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME              = 0x00004000;
    public static final int FLAG_ACTIVITY_CLEAR_TASK                = 0x00008000;
    public static final int FLAG_ACTIVITY_NO_ANIMATION              = 0x00010000;
    public static final int FLAG_ACTIVITY_REORDER_TO_FRONT          = 0x00020000;
    public static final int FLAG_ACTIVITY_NO_USER_ACTION            = 0x00040000;
    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET     = 0x00080000;
    public static final int FLAG_ACTIVITY_NEW_DOCUMENT              = 0x00080000;
    public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY     = 0x00100000;
    public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED      = 0x00200000;
    public static final int FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS   = 0x00200000;
    public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT          = 0x00400000;
    public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS      = 0x00800000;
    public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP           = 0x01000000;
    public static final int FLAG_ACTIVITY_FORWARD_RESULT            = 0x02000000;
    public static final int FLAG_ACTIVITY_CLEAR_TOP                 = 0x04000000;
    public static final int FLAG_ACTIVITY_MULTIPLE_TASK             = 0x08000000;
    public static final int FLAG_RECEIVER_NO_ABORT                  = 0x08000000;
    public static final int FLAG_ACTIVITY_NEW_TASK                  = 0x10000000;
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES           = 0x10000000;
    public static final int FLAG_RECEIVER_FOREGROUND                = 0x10000000;
    public static final int FLAG_ACTIVITY_SINGLE_TOP                = 0x20000000;
    public static final int FLAG_RECEIVER_REPLACE_PENDING           = 0x20000000;
    public static final int FLAG_ACTIVITY_NO_HISTORY                = 0x40000000;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY           = 0x40000000;

    public static final String METADATA_DOCK_HOME = "android.dock_home";

    public static final int URI_INTENT_SCHEME       = 0x00000001;
    public static final int URI_ANDROID_APP_SCHEME  = 0x00000002;
    public static final int URI_ALLOW_UNSAFE        = 0x00000004;


    public static final Creator<Intent> CREATOR = new Creator<Intent>() {
        @Override
        public Intent createFromParcel(Parcel source) {
            log.warning("Unimplemented method: android.content.Intent.CREATOR.createFromParcel(android.os.Parcel)");
            return null;
        }

        @Override
        public Intent[] newArray(int size) {
            return new Intent[size];
        }
    };

    public static Intent createChooser(Intent target, CharSequence title, IntentSender sender) {
        log.warning("Unimplemented method: android.content.Intent.createChooser");
        return null;
    }

    public static Intent createChooser(Intent target, CharSequence title) {
        log.warning("Unimplemented method: android.content.Intent.createChooser");
        return null;
    }

    public static Intent getIntent(String uri) {
        log.warning("Unimplemented method: android.content.Intent.getIntent");
        return null;
    }

    public static Intent getIntentOld(String uri) {
        log.warning("Unimplemented method: android.content.Intent.getIntentOld");
        return null;
    }

    public static Intent makeMainActivity(ComponentName mainActivity) {
        log.warning("Unimplemented method: android.content.Intent.makeMainActivity");
        return null;
    }

    public static Intent makeMainSelectorActivity(String selectorAction, String selectorCategory) {
        log.warning("Unimplemented method: android.content.Intent.makeMainSelectorActivity");
        return null;
    }

    public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        log.warning("Unimplemented method: android.content.Intent.makeRestartActivityTask");
        return null;
    }

    public static String normalizeMimeType(String type) {
        log.warning("Unimplemented method: android.content.Intent.normalizeMimeType");
        return null;
    }

    public static Intent parseIntent(Resources resources, XmlPullParser parser, AttributeSet attrs) {
        log.warning("Unimplemented method: android.content.Intent.parseIntent");
        return null;
    }

    public static Intent parseUri(String uri, int flags) {
        log.warning("Unimplemented method: android.content.Intent.parseUri");
        return null;
    }

    public Intent() {
        log.warning("Unimplemented method: android.content.Intent.Intent()");
    }

    public Intent(Intent o) {
        log.warning("Unimplemented method: android.content.Intent.Intent(android.content.Intent)");
    }

    public Intent(String action) {
        log.warning("Unimplemented method: android.content.Intent.Intent(java.lang.String)");
    }

    public Intent(String action, Uri uri) {
        log.warning("Unimplemented method: android.content.Intent.Intent(java.lang.String, android.net.Uri)");
    }

    public Intent(Context packageContext, Class<?> cls) {
        log.warning("Unimplemented method: android.content.Intent.Intent(android.content.Context, java.lang.Class)");
    }

    public Intent(String action, Uri uri, Context packageContext, Class<?> cls) {
        log.warning("Unimplemented method: android.content.Intent.Intent(java.lang.String, android.net.Uri, " +
                "android.content.Context, java.lang.Class)");
    }

    public Intent addCategory(String category) {
        log.warning("Unimplemented method: android.content.Intent.addCategory");
        return null;
    }

    public Intent addFlags(int flags) {
        log.warning("Unimplemented method: android.content.Intent.addFlags");
        return null;
    }

    public Intent cloneFilter() {
        log.warning("Unimplemented method: android.content.Intent.cloneFilter");
        return null;
    }

    @Override
    public int describeContents() {
        log.warning("Unimplemented method: android.content.Intent.describeContents()");
        return 0;
    }

    public int fillIn(Intent other, int flags) {
        log.warning("Unimplemented method: android.content.Intent.fillIn");
        return 0;
    }

    public boolean filterEquals(Intent other) {
        log.warning("Unimplemented method: android.content.Intent.filterEquals");
        return false;
    }

    public int filterHashCode() {
        log.warning("Unimplemented method: android.content.Intent.filterHashCode");
        return 0;
    }

    public String getAction() {
        log.warning("Unimplemented method: android.content.Intent.getAction");
        return null;
    }

    public boolean[] getBooleanArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getBooleanArrayExtra");
        return null;
    }

    public boolean getBooleanExtra(String name, boolean defaultValue) {
        log.warning("Unimplemented method: android.content.Intent.getBooleanExtra");
        return false;
    }

    public Bundle getBundleExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getBundleExtra");
        return null;
    }

    public byte[] getByteArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getByteArrayExtra");
        return null;
    }

    public byte getByteExtra(String name, byte defaultValue) {
        log.warning("Unimplemented method: android.content.Intent.getByteExtra");
        return 0;
    }

    public Set<String> getCategories() {
        log.warning("Unimplemented method: android.content.Intent.getCategories");
        return null;
    }

    public char[] getCharArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getCharArrayExtra");
        return null;
    }

    public char getCharExtra(String name, char defaultValue) {
        log.warning("Unimplemented method: android.content.Intent.getCharExtra");
        return 0;
    }

    public CharSequence[] getCharSequenceArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getCharSequenceArrayExtra");
        return null;
    }

    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getCharSequenceArrayListExtra");
        return null;
    }

    public CharSequence getCharSequenceExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getCharSequenceExtra");
        return null;
    }

    public ClipData getClipData() {
        log.warning("Unimplemented method: android.content.Intent.getClipData");
        return null;
    }

    public ComponentName getComponent() {
        log.warning("Unimplemented method: android.content.Intent.getComponent");
        return null;
    }

    public Uri getData() {
        log.warning("Unimplemented method: android.content.Intent.getData");
        return null;
    }

    public String getDataString() {
        log.warning("Unimplemented method: android.content.Intent.getDataString");
        return null;
    }

    public double[] getDoubleArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getDoubleArrayExtra");
        return null;
    }

    public double getDoubleExtra(String name, double defaultValue) {
        log.warning("Unimplemented method: android.content.Intent.getDoubleExtra");
        return 0;
    }

    public Bundle getExtra() {
        log.warning("Unimplemented method: android.content.Intent.getExtra");
        return null;
    }

    public int getFlags() {
        log.warning("Unimplemented method: android.content.Intent.getFlags");
        return 0;
    }

    public float[] getFloatArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getFloatArrayExtra");
        return null;
    }

    public float getFloatExtra(String name, float defaultValue) {
        log.warning("Unimplemented method: android.content.Intent.getFloatExtra");
        return 0;
    }

    public int[] getIntArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getIntArrayExtra");
        return null;
    }

    public int getIntExtra(String name, int defaultValue) {
        log.warning("Unimplemented method: android.content.Intent.getIntExtra");
        return 0;
    }

    public ArrayList<Integer> getIntegerArrayListExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getIntegerArrayListExtra");
        return null;
    }

    public long[] getLongArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getLongArrayExtra");
        return null;
    }

    public long getLongExtra(String name, long defaultValue) {
        log.warning("Unimplemented method: android.content.Intent.getLongExtra");
        return 0;
    }

    public String getPackage() {
        log.warning("Unimplemented method: android.content.Intent.getPackage");
        return null;
    }

    public Parcelable[] getParcelableArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getParcelableArrayExtra");
        return null;
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getParcelableArrayListExtra");
        return null;
    }

    public <T extends Parcelable> T getParcelableExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getParcelableExtra");
        return null;
    }

    public String getScheme() {
        log.warning("Unimplemented method: android.content.Intent.getScheme");
        return null;
    }

    public Intent getSelector() {
        log.warning("Unimplemented method: android.content.Intent.getSelector");
        return null;
    }

    public Serializable getSerializableExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getSerializableExtra");
        return null;
    }

    public short[] getShortArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getShortArrayExtra");
        return null;
    }

    public short getShortExtra(String name, short defaultValue) {
        log.warning("Unimplemented method: android.content.Intent.getShortExtra");
        return 0;
    }

    public Rect getSourceBounds() {
        log.warning("Unimplemented method: android.content.Intent.getSourceBounds");
        return null;
    }

    public String[] getStringArrayExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getStringArrayExtra");
        return null;
    }

    public ArrayList<String> getStringArrayListExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getStringArrayListExtra");
        return null;
    }

    public String getStringExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.getStringExtra");
        return null;
    }

    public String getType() {
        log.warning("Unimplemented method: android.content.Intent.getType");
        return null;
    }

    public boolean hasCategory(String category) {
        log.warning("Unimplemented method: android.content.Intent.hasCategory");
        return false;
    }

    public boolean hasExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.hasExtra");
        return false;
    }

    public boolean hasFileDescriptors() {
        log.warning("Unimplemented method: android.content.Intent.hasFileDescriptors");
        return false;
    }

    public Intent putCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        log.warning("Unimplemented method: android.content.Intent.putCharSequenceArrayListExtra");
        return null;
    }

    public Intent putExtra(String name, Parcelable value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, long[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, byte value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, double[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, CharSequence value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, boolean[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, int value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, char[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, byte[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, Parcelable[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, Bundle value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, CharSequence[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, float[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, double value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, int[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, String[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, short[] value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, boolean value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, String value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, long value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, char value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, Serializable value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, float value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtra(String name, short value) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtras(Intent src) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putExtras(Bundle extras) {
        log.warning("Unimplemented method: android.content.Intent.putExtras");
        return null;
    }

    public Intent putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        log.warning("Unimplemented method: android.content.Intent.putIntegerArrayListExtra");
        return null;
    }

    public Intent putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        log.warning("Unimplemented method: android.content.Intent.putParcelableArrayListExtra");
        return null;
    }

    public Intent putStringArrayListExtra(String name, ArrayList<String> value) {
        log.warning("Unimplemented method: android.content.Intent.putStringArrayListExtra");
        return null;
    }

    public void readFromParcel(Parcel in) {
        log.warning("Unimplemented method: android.content.Intent.readFromParcel");
    }

    public void removeCategory(String category) {
        log.warning("Unimplemented method: android.content.Intent.removeCategory");
    }

    public void removeExtra(String name) {
        log.warning("Unimplemented method: android.content.Intent.removeExtra");
    }

    public void removeFlags(int flags) {
        log.warning("Unimplemented method: android.content.Intent.removeFlags");
    }

    public Intent replaceExtras(Intent src) {
        log.warning("Unimplemented method: android.content.Intent.replaceExtras");
        return null;
    }

    public Intent replaceExtras(Bundle extras) {
        log.warning("Unimplemented method: android.content.Intent.replaceExtras");
        return null;
    }

    public ComponentName resolveActivity(PackageManager pm) {
        log.warning("Unimplemented method: android.content.Intent.resolveActivity");
        return null;
    }

    public ActivityInfo resolveActivityInfo(PackageManager pm, int flags) {
        log.warning("Unimplemented method: android.content.Intent.resolveActivityInfo");
        return null;
    }

    public String resolveType(Context context) {
        log.warning("Unimplemented method: android.content.Intent.resolveType");
        return null;
    }

    public String resolveType(ContentResolver resolver) {
        log.warning("Unimplemented method: android.content.Intent.resolveType");
        return null;
    }

    public String resolveTypeIfNeeded(ContentResolver resolver) {
        log.warning("Unimplemented method: android.content.Intent.resolveTypeIfNeeded");
        return null;
    }

    public Intent setAction(String action) {
        log.warning("Unimplemented method: android.content.Intent.setAction");
        return null;
    }

    public Intent setClass(Context packageContext, Class<?> cls) {
        log.warning("Unimplemented method: android.content.Intent.setClass");
        return null;
    }

    public Intent setClassName(String packageName, String className) {
        log.warning("Unimplemented method: android.content.Intent.setClassName");
        return null;
    }

    public Intent setClassName(Context packageContext, String className) {
        log.warning("Unimplemented method: android.content.Intent.setClassName");
        return null;
    }

    public void setClipData(ClipData clip) {
        log.warning("Unimplemented method: android.content.Intent.setClipData");
    }

    public Intent setComponent(ComponentName component) {
        log.warning("Unimplemented method: android.content.Intent.setComponent");
        return null;
    }

    public Intent setData(Uri data) {
        log.warning("Unimplemented method: android.content.Intent.setData");
        return null;
    }

    public Intent setDataAndNormalize(Uri data) {
        log.warning("Unimplemented method: android.content.Intent.setDataAndNormalize");
        return null;
    }

    public Intent setDataAndType(Uri data, String type) {
        log.warning("Unimplemented method: android.content.Intent.setDataAndType");
        return null;
    }

    public Intent setDataAndTypeAndNormalize(Uri data, String type) {
        log.warning("Unimplemented method: android.content.Intent.setDataAndTypeAndNormalize");
        return null;
    }

    public void setExtrasClassLoader(ClassLoader loader) {
        log.warning("Unimplemented method: android.content.Intent.setExtrasClassLoader");
    }

    public Intent setFlags(int flags) {
        log.warning("Unimplemented method: android.content.Intent.setFlags");
        return null;
    }

    public Intent setPackage(String packageName) {
        log.warning("Unimplemented method: android.content.Intent.setPackage");
        return null;
    }

    public void setSelector(Intent selector) {
        log.warning("Unimplemented method: android.content.Intent.setSelector");
    }

    public void setSourceBounds(Rect rect) {
        log.warning("Unimplemented method: android.content.Intent.setSourceBounds");
    }

    public Intent setType(String type) {
        log.warning("Unimplemented method: android.content.Intent.setType");
        return null;
    }

    public Intent setTypeAndNormalize(String type) {
        log.warning("Unimplemented method: android.content.Intent.setTypeAndNormalize");
        return null;
    }

    public String toURI() {
        log.warning("Unimplemented method: android.content.Intent.toURI");
        return null;
    }

    public String toUri(int flags) {
        log.warning("Unimplemented method: android.content.Intent.toUri");
        return null;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        log.warning("Unimplemented method: android.content.Intent.writeToParcel(android.os.Parcel, int)");
    }
}
