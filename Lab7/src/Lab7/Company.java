package Lab7;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Formatter;

class Company {
    private String name;
    private String shortTitle;
    private LocalDate dateUpdate;
    private String address;
    private LocalDate dateFoundation;
    private int countEmployees;
    private String auditor;
    private String phone;
    private String email;
    private String branch;
    private String activity;
    private String link;

    public Company(String name, String shortTitle, LocalDate dateUpdate, String address, LocalDate dateFoundation, int countEmployees, String auditor, String phone, String email, String branch, String activity, String link) {
        this.name = name;
        this.shortTitle = shortTitle;
        this.dateUpdate = dateUpdate;
        this.address = address;
        this.dateFoundation = dateFoundation;
        this.countEmployees = countEmployees;
        this.auditor = auditor;
        this.phone = phone;
        this.email = email;
        this.branch = branch;
        this.activity = activity;
        this.link = link;
    }

    public Company() {
        this("", "", LocalDate.of(0, 1, 1), "", LocalDate.of(0, 1, 1), 0, "", "", "", "", "", "");
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public LocalDate getDateFoundation() {
        return dateFoundation;
    }

    public int getCountEmployees() {
        return countEmployees;
    }

    public String getBranch() {
        return branch;
    }

    public String getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("%20.20s | %10s | %10s | %15.15s | %10s | %6s | %10s | %21s | %25.25s | %10.10s | %10.10s |" +
                        " %15.15s", name, shortTitle, dateUpdate, address, dateFoundation, countEmployees, auditor,
                phone, email, branch, activity, link);
        return formatter.toString();
    }

    public String toXMLString() {
        String head = getClassName(Company.class.getName());
        Field[] fields = Company.class.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("\t<").append(head).append(">\n");
        try {
            for (Field item : fields) {
                String name = item.getName();
                sb.append("\t\t<").append(name).append(">").append(item.get(this)).append("</").append(name).append(">\n");
            }
        } catch (IllegalAccessException e) {
            System.out.println("Illegal Access Exception.");
        }
        sb.append("\t</").append(head).append(">");
        return sb.toString();
    }

    public String toJSONString() {
        Field[] fields = Company.class.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t{\n");
        try {
            for (Field item : fields) {
                String name = item.getName();
                sb.append("\t\t\t\"").append(name).append("\"").append(": ");
                if (!(item.get(this) instanceof Integer)) {
                    sb.append("\"").append(item.get(this)).append("\",\n");
                } else {
                    sb.append(item.get(this)).append(",\n");
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println("Illegal Access Exception.");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("\t\t},");
        return sb.toString();
    }

    private String getClassName(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = name.length() - 1; name.charAt(i) != '.'; i--) {
            sb.append(name.charAt(i));
        }
        return sb.reverse().toString();
    }
}
