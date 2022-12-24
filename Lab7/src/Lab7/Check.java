package Lab7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Check {

    public static String checkShortTitle(String shortTitle) throws InputException {
        if (shortTitle.trim().length() == 0) {
            throw new InputException("Field of short title is empty! Please, open \"input.csv\" and enter correct info.");
        }
        return shortTitle;
    }

    public static LocalDate checkDate(String strDate, boolean isThrowException) throws InputException {
        if (strDate.trim().length() != 0) {
            LocalDate date;
            if (strDate.contains(".")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                try {
                    date = LocalDate.parse(strDate, formatter);
                } catch (DateTimeParseException e) {
                    throw new InputException("Wrong date format! Please, open \"input.csv\" and enter correct info " +
                            "(use \"dd.mm.yyyy\" or \"mm/dd/yyyy\").");
                }
                return date;
            }
            if (strDate.contains("/")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                try {
                    date = LocalDate.parse(strDate, formatter);
                } catch (DateTimeParseException e) {
                    throw new InputException("Wrong date format! Please, open \"input.csv\" and enter correct info " +
                            "(use \"dd.mm.yyyy\" or \"mm/dd/yyyy\").");
                }
                return date;
            }
        } else {
            if (isThrowException) {
                throw new InputException("Field of date of foundation is empty! Please, open \"input.csv\" and enter " +
                        "correct info.");
            }
        }
        return LocalDate.of(0, 1, 1);
    }

    public static int checkCountEmployees(String countEmployees) throws InputException {
        if (countEmployees.trim().length() == 0) {
            throw new InputException("Field of count of employees is empty! Please, open \"input.csv\" and enter " +
                    "correct info.");
        }
        try {
            int count = Integer.parseInt(countEmployees);
            if (count < 0) {
                throw new InputException("Field of count of employees is empty! Please, open \"input.csv\" and enter " +
                        "correct info.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new InputException("Wrong count of employees! Please, open \"input.csv\" and enter correct info.");
        }
    }

    public static String checkPhone(String phone) throws InputException {
        if (phone.length() != 0) {
            Pattern pattern = Pattern.compile("^\\+[ ]?([1-9](\\d){0,2})([ ])?([(]?)([1-9](\\d){1,3})([)]?)([ ]?)(([1-9](\\d){2}[ -]?(\\d){2}[ -]?(\\d){2})|([1-9](\\d){1}[ -]?(\\d){2}[ -]?(\\d){3})|([1-9](\\d){2}([ -]?)(\\d){4})|([1-9](\\d){3}[ -]?(\\d){3}))$");
            Matcher matcher = pattern.matcher(phone);
            if (!matcher.matches()) {
                throw new InputException("Wrong phone number! Please, open \"input.csv\" and enter correct info.");
            }
        }
        return phone;
    }

    public static String checkEmail(String email) throws InputException {
        if (email.length() != 0) {
            Pattern pattern = Pattern.compile("^[-\\w.]+@(\\w+\\.)+[A-z]{2,4}$");
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                throw new InputException("Wrong e-mail address! Please, open \"input.csv\" and enter correct info.");
            }
        }
        return email;
    }

    public static String checkBranch(String branch) throws InputException {
        if (branch.trim().length() == 0) {
            throw new InputException("Field of branch is empty! Please, open \"input.csv\" and enter correct info.");
        }
        return branch;
    }

    public static String checkActivity(String activity) throws InputException {
        if (activity.trim().length() == 0) {
            throw new InputException("Field of activity is empty! Please, open \"input.csv\" and enter correct info.");
        }
        return activity;
    }

    public static String checkLink(String link) throws InputException {
        if (link.length() != 0) {
            Pattern pattern = Pattern.compile("^(http(s?)://)?([^./]+[.]?)*\\S+[.]?([\\w]{2,6})(/?)\\S*(/?)$");
            Matcher matcher = pattern.matcher(link);
            if (!matcher.matches()) {
                throw new InputException("Wrong URL address! Please, open \"input.csv\" and enter correct info.");
            }
        }
        return link;
    }
}
