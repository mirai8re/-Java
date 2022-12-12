package Lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Run {
    private Companies companies;
    private PrintStream requestsWriter;

    public Run() throws FileNotFoundException {
        companies = new Companies();
        requestsWriter = new PrintStream("requests.txt");
    }

    public void fillCompanies(String filePath) throws FileNotFoundException, InputException {
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine();
        while (sc.hasNext()) {
            String buffer = sc.nextLine();
            companies.add(readCompany(buffer.split(";")));
        }
        sc.close();
    }

    private Company readCompany(String[] fields) throws InputException {
        return new Company(fields[0].trim(), Check.checkShortTitle(fields[1].trim()),
                Check.checkDate(fields[2].trim(), false), fields[3].trim(), Check.checkDate(fields[4].trim(), true),
                Check.checkCountEmployees(fields[5].trim()), fields[6].trim(), Check.checkPhone(fields[7].trim()),
                Check.checkEmail(fields[8].trim()), Check.checkBranch(fields[9].trim()),
                Check.checkActivity(fields[10].trim()), Check.checkLink(fields[11].trim()));
    }

    public String outputXML() throws FileNotFoundException {
        String filePath = "output.xml";
        PrintStream psXML = new PrintStream(new File(filePath));
        psXML.print(companies.toXMLString());
        psXML.flush();
        psXML.close();
        return filePath;
    }

    public String outputJSON() throws FileNotFoundException {
        String filePath = "output.json";
        PrintStream psJSON = new PrintStream(new File(filePath));
        psJSON.print(companies.toJSONString());
        psJSON.flush();
        psJSON.close();
        return filePath;
    }

    public void printSearchResultOfShortTitle(String string) {
        List<Company> tmpList = new ArrayList<>();
        Companies tmpCompanies = new Companies();
        requestsWriter.print("Result of searching by short title: \"" + string + "\"\n");
        tmpList = companies.findShortTitle(string, requestsWriter);
        for (Company item : tmpList) {
            tmpCompanies.add(item);
        }
        if (tmpCompanies.size() != 0) {
            requestsWriter.print(tmpCompanies.toString() + "\n");
        }
    }

    public void printSearchResultOfBranch(String string) {
        List<Company> tmpList = new ArrayList<>();
        Companies tmpCompanies = new Companies();
        requestsWriter.print("Result of searching by branch: \"" + string + "\"\n");
        tmpList = companies.findBranch(string, requestsWriter);
        for (Company item : tmpList) {
            tmpCompanies.add(item);
        }
        if (tmpCompanies.size() != 0) {
            requestsWriter.print(tmpCompanies.toString() + "\n");
        }
    }

    public void printSearchResultOfActivity(String string) {
        List<Company> tmpList = new ArrayList<>();
        Companies tmpCompanies = new Companies();
        requestsWriter.print("Result of searching by activity: \"" + string + "\"\n");
        tmpList = companies.findActivity(string, requestsWriter);
        for (Company item : tmpList) {
            tmpCompanies.add(item);
        }
        if (tmpCompanies.size() != 0) {
            requestsWriter.print(tmpCompanies.toString() + "\n");
        }
    }

    public void printSearchResultOfDateOfFoundation(LocalDate fromDate, LocalDate toDate) {
        List<Company> tmpList = new ArrayList<>();
        Companies tmpCompanies = new Companies();
        requestsWriter.print("Result of date (from " + fromDate + " to " + toDate + ")\n");
        tmpList = companies.findDateOfFoundation(fromDate, toDate, requestsWriter);
        for (Company item : tmpList) {
            tmpCompanies.add(item);
        }
        if (tmpCompanies.size() != 0) {
            requestsWriter.print(tmpCompanies.toString() + "\n");
        }
    }

    public void printSearchResultOfCountOfEmployees(int fromCount, int toCount) throws InputException {
        List<Company> tmpList = new ArrayList<>();
        Companies tmpCompanies = new Companies();
        requestsWriter.print("\nResult of count of employees (from " + fromCount + " to " + toCount + ")\n");
        tmpList = companies.findCountOfEmployees(fromCount, toCount, requestsWriter);
        for (Company item : tmpList) {
            tmpCompanies.add(item);
        }
        if (tmpCompanies.size() != 0) {
            requestsWriter.print(tmpCompanies.toString() + "\n");
        }
    }
}
