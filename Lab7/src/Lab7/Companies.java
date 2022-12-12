package Lab7;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Companies {
    private List<Company> list;

    public Companies() {
        list = new ArrayList<>();
    }

    public void add(Company company) {
        list.add(company);
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Company item : list) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

    public String toXMLString() {
        String head = getClassName(Companies.class.getName());
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(head).append(">\n");
        for (Company item : list) {
            sb.append(item.toXMLString()).append("\n");
        }
        sb.append("</").append(head).append(">");
        return sb.toString();
    }

    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        String head = getClassName(Companies.class.getName());
        sb.append("{\n\t\"").append(head).append("\": [\n");
        for (Company item : list) {
            sb.append(item.toJSONString()).append("\n");
        }
        sb.append("\n\t]\n");
        sb.append("}\n");
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }

    private String getClassName(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = name.length() - 1; name.charAt(i) != '.'; i--) {
            sb.append(name.charAt(i));
        }
        return sb.reverse().toString();
    }

    public List<Company> findShortTitle(String str, PrintStream ps) {
        List<Company> shortTitle = new ArrayList<>();
        for (Company item : list) {
            if (str.equalsIgnoreCase(item.getShortTitle())) {
                shortTitle.add(item);
            }
        }
        if (shortTitle.size() == 0) {
            ps.println("Companies with short title aren't found!\n");
        }
        return shortTitle;
    }

    public List<Company> findBranch(String str, PrintStream ps) {
        List<Company> branch = new ArrayList<>();
        for (Company item : list) {
            if (str.equalsIgnoreCase(item.getBranch())) {
                branch.add(item);
            }
        }
        if (branch.size() == 0) {
            ps.println("Companies of this branch aren't found!\n");
        }
        return branch;
    }

    public List<Company> findActivity(String str, PrintStream ps) {
        List<Company> activity = new ArrayList<>();
        for (Company item : list) {
            if (str.equalsIgnoreCase(item.getActivity())) {
                activity.add(item);
            }
        }
        if (activity.size() == 0) {
            ps.println("Companies of this activity aren't found!\n");
        }
        return activity;
    }

    public List<Company> findDateOfFoundation(LocalDate fromDate, LocalDate toDate, PrintStream ps) {
        List<Company> dateOfFoundation = new ArrayList<>();
        for (Company item : list) {
            LocalDate date = item.getDateFoundation();
            if (date.isAfter(fromDate) && date.isBefore(toDate)) {
                dateOfFoundation.add(item);
            }
        }
        if (dateOfFoundation.size() == 0) {
            ps.println("Companies of this period of foundation aren't found!\n");
        }
        return dateOfFoundation;
    }

    public List<Company> findCountOfEmployees(int fromCount, int toCount, PrintStream ps) throws InputException {
        if (fromCount < 0 || toCount < 0) {
            throw new InputException("Wrong edges of employees count!\n");
        }
        List<Company> countOfEmployees = new ArrayList<Company>();
        for (Company item : list) {
            int count = item.getCountEmployees();
            if (count >= fromCount && count <= toCount) {
                countOfEmployees.add(item);
            }
        }
        if (countOfEmployees.size() == 0) {
            ps.println("Companies with this edges of employees count aren't found!");
        }
        return countOfEmployees;
    }

}
