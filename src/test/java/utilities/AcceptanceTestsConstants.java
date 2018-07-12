package utilities;

import java.util.Arrays;
import java.util.List;

public class AcceptanceTestsConstants {

  public static final String ENVIRONMENT = "environment";

  public static final String ACTIVE = "active";
  public static final String ALL_OCCURRENCES = "all occurrences";
  public static final String ALL_PERSONAL = "All Personal";
  public static final String ALWAYS_AVAILABLE = "always available";
  public static final String APPEARED = "appeared";
  public static final String BASICS = "Basics";
  public static final String BLANK = "Blank";
  public static final String CANCEL = "Cancel";
  public static final String CALENDAR_EVENT_RESERVED_MESSAGE = "Calendar event temporarily "
      + "reserved";
  public static final String CALENDAR_MAIN_PAGE_TITLE = "CM/ECF Calendar";
  public static final String CASE_EVENT_ACCORDION_CALENDAREVENTS = "Calendar Events";
  public static final String CASE_EVENT_ACCORDION_DOCKETING = "Users who may select this calendar"
      + " event when docketing";
  public static final String CASE_EVENT_ACCORDION_FILINGS = "Filings associated with calendar "
      + "event";
  public static final String CASE_EVENT_ACCORDION_JUDGE = "Judge";
  public static final String CASE_EVENT_FILINGS_RADIO_RESERVRE_FOR_FUTURE = "Reserve for a future"
      + " filing";
  public static final String CASE_EVENT_FILINGS_RADIO_ASSOCIATE_WITH_PREVIOUS = "Associate with a"
      + " previous filing";
  public static final String CATEGORY = "Category";
  public static final String CATEGORY_NAME = "Category Name";
  public static final String CHAMBERS = "Chambers";
  public static final String CHECK = "check";
  public static final String CHECKED = "checked";
  public static final String CHROME_WEB_SERVICE_BROWSER_TITLE = "data:,";
  public static final String COURT = "Court";
  public static final String COLOR_BARS = "Color Bars";
  public static final String CREATE = "Create";
  public static final String CURRENT_GEN_LOGIN = "District Development-login";
  public static final String DEADLINE = "Deadline";
  public static final String DEFAULT = "Default";
  public static final String DATE = "Date";
  public static final String TIME = "Time";
  public static final String DEFAULT_DATE_TIME = "Default Date/Time";
  public static final String DELETE = "Delete";
  public static final String DISABLED = "disabled";
  public static final String DISAPPEARED = "disappeared";
  public static final String DOCKETING_TAB = "Docketing";
  public static final String DOCKET_SHORT = "Docket";
  public static final String EDIT = "Edit";
  public static final String ENABLED = "enabled";
  public static final String DEADLINES_AND_HEARINGS = "Deadlines & Hearings";
  public static final String FIREFOX_WEB_SERVICE_BROWSER_TITLE = "";
  public static final String FIRST = "first";
  public static final String FUTURE = "future";
  public static final String GROUP = "Group";
  public static final String HEARING = "Hearing";
  public static final String HOLIDAYS = "Holidays";
  public static final String INACTIVE = "Inactive";
  public static final String INDIVIDUAL = "individual";
  public static final String INTERPRETER = "Interpreter";
  public static final String JUDGE = "Judge";
  public static final String Last = "last";
  public static final String MY_PERSONAL = "My Personal";
  public static final String NEW = "new";
  public static final String NO_RECORDS_FOUND = "No records found.";
  public static final String NO_RECORDS_FOUND_NO_PERIOD = "No records found";
  public static final String NONE = "None";
  public static final String NOT = "not";
  public static final String NO = "no";
  public static final String OVERLAY_CLASS = "ui-widget-overlay";
  public static final String PREVIOUS = "previous";
  public static final String RANDOM = "Random";
  public static final String RESOURCE_NAME = "Resource Name";
  public static final String RESOURCES = "Resources";
  public static final String ROLE = "Role";
  public static final String SAVE = "save";
  public static final String SCHEDULING_PERMISSIONS = "Scheduling Permissions";
  public static final String SELECTED = "selected";
  public static final String SHOULD = "should";
  public static final String SHOULD_NOT = "should not";
  public static final String TENTATIVE = "Tentative";
  public static final String THIS_AND_FUTURE_OCCURRENCES = "this and future occurrences";
  public static final String THIS_OCCURRENCE_ONLY = "this occurrence only";
  public static final String TYPE = "Type";
  public static final String UNSELECTED = "unselected";
  public static final String USER = "User";
  public static final String VIEW = "View";
  public static final String NO_BLANK_SPACE = "&nbsp;";
  public static final String SELECT_A_CATEGORY = "Select a Category";
  public static final String UPDATE = "Update";
  public static final String YES = "yes";

  public static final List<String> CASE_EVENT_ACCORDION_LIST = Arrays.asList
      (CASE_EVENT_ACCORDION_JUDGE, CASE_EVENT_ACCORDION_CALENDAREVENTS,
          CASE_EVENT_ACCORDION_FILINGS, CASE_EVENT_ACCORDION_DOCKETING);

  // repeat options
  public static final String HOURLY = "Hourly";
  public static final String DAILY = "Daily";
  public static final String WEEKLY = "Weekly";
  public static final String MONTHLY = "Monthly";
  public static final String YEARLY = "Yearly";
  public static final String MONTHLY_BY_DAY = "Monthly by day";
  public static final String MONTHLY_BY_DATE = "Monthly by date";
  public static final String REPEAT_DAY = "Repeat Day";
  public static final String REPEAT_FREQUENCY = "Repeat Frequency";
  public static final String REPEAT_ORDER = "Ordinal Occurrence of Day in Month";
  public static final String REPEAT_TYPE = "Repeat Type";
  public static final String WEEKDAY = "Day of the Week";
  public static final String STOP_AFTER_DATE = "Stop after Date";
  public static final String TIMES_PER_MONTH = "Time per month";
  public static final String NUMBER_OF_OCCURENCES = "Number of Occurrences";

  // Tab names
  public static final String ATTACHMENTS = "Attachments";
  public static final String DESCRIPTION = "Description";
  public static final String PERMISSIONS = "Permissions";
  public static final String REPEAT = "Repeat";

  // Date time fields
  public static final String DURATION = "Duration";
  public static final String START_TIME = "Start time";
  public static final String END_TIME = "End time";
  public static final String START_DATE = "Start date";
  public static final String END_DATE = "End date";
  public static final String HOURS = "Hours";
  public static final String MINUTES = "Minutes";

  public static final String LOCATION = "Location";
  public static final String DISTRICT = "District";
  public static final String BANKRUPTCY = "Bankruptcy";

  public static enum EndRepeatRadioButtonOptions {
    REPEAT_FOR(1), STOP_AFTER(2);
    private final Integer index;

    private EndRepeatRadioButtonOptions(final Integer radioButtonIndex) {
      index = radioButtonIndex;
    }

    public Integer getIndex() {
      return index;
    }
  }

  public static enum DailySummaryViewColumns {
    START, PLUS, END, DESCRIPTION, TYPE
  }

  public static final String UNAVAILABLE = "unavailable";

  public static final String AVAILABLE = "available";

  public static final String DISTRICT_DOCKET_REPORT_PAGE = "District Development-Docket Report";

  public static final String NEXT = "Next";

  public static final String WORK_HOURS = "Work Hours";
  public static final String All_HOURS = "All Hours";

  public static final String SCHEDULE_VIA_DOCKETING_EVENT_DIALOG = "Scheduling through docketing "
      + "dialog";

  public static final String HELP_PAGE_TITLE = "NextGen Calendar";

  public static final String NO_JUDGE_ASSOCIATED = "No Judge Associated";

  public static final String TODAY = "Today";

  public static final String DATE_AND_TIME_REQUIRED = "Date and Time required";

  public static final String RESOURCE_CATEGORIES = "Resource Categories";

  public static final String CUSTOM_CALENDARS = "Custom Calendars";

}
