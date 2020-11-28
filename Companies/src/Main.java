import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.apache.commons.validator.GenericValidator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("t.json"));
        List<Company> companyList = getObjectList(reader, Company.class);

//        1
        showShortInfo(companyList);
//
//        2
        showExpireSecur(companyList);
//
//        3
        showCompaniesOfDate(companyList);
//
//        4
        showSecuretiesOfCurrency(companyList);

    }

    public static void showShortInfo(List<Company> companyList) {
        int i = 1;
        if (companyList.isEmpty()) {
            System.out.println("Список организаций пуст.");
        } else {
            for (Company company : companyList) {
                System.out.println(i++ +
                        ". " + company.getShort_name() +
                        " - " + company.getDateOfFoundation().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + ".");
            }
        }
    }

    public static void showExpireSecur(List<Company> companyList) {
        int i = 0;
        int j = 1;
        for (Company company : companyList) {
            for (Securities sec : company.getSecurities()) {
                if (sec.getDateTime().isBefore(LocalDate.now())) {
                    System.out.println(j++ +
                            ".\tКод - " + sec.getId() +
                            ".\n\tДата истечения -" + sec.getDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                            ".\n\tВладелец - " + sec.getNameofComp() + ".");
                    i++;
                }
            }
        }
        System.out.println("Общее число просроченных бумаг - " + i + ".");
    }

    public static void showCompaniesOfDate(List<Company> companyList) {
        Scanner scan = new Scanner(System.in);
        String str;
        boolean check = true;
        LocalDate date;
        GenericValidator genericValidator = new GenericValidator();
        System.out.println("Введите шаблон формата даты: ");
        while (true){
            str = scan.nextLine();
            if (genericValidator.isDate(str, "dd.MM.yyyy", true)) {
                date = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                break;
            } else if (genericValidator.isDate(str, "dd.MM,yy", true)) {
                date = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd.MM,yy"));
                break;
            } else if (genericValidator.isDate(str, "dd/MM/yy", true)) {
                date = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yy"));
                break;
            } else if (genericValidator.isDate(str, "dd/MM/yyyy", true)) {
                date = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } else {
                System.out.println("Введите один из следующих форматов : «ДД.ММ.ГГГГ», «ДД.ММ,ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ».");
            }
        }
        int i = 1;
        System.out.println("Основаны после " + date + " :");
        for (Company company : companyList) {
            if (company.getDateOfFoundation().isAfter(date)) {
                System.out.println(i++ + ". " + company.getShort_name() + " - " + company.getDateOfFoundation() + ".");
            }
        }
    }

    public static void showSecuretiesOfCurrency(List<Company> companyList){
        String str;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сокращенное имя валюты (RUB, USD, EUR): ");
        while (true){
            str = scan.nextLine();
            if (str.equalsIgnoreCase("RUB") ||
                    str.equalsIgnoreCase("USD") ||
                    str.equalsIgnoreCase("EUR")) {
                break;
            }
            else {
                System.out.println("Введите один из следующих форматов: RUB, USD, EUR.");
            }
        }
        int j = 1;
        for (Company company : companyList) {
            for (Securities sec : company.getSecurities()) {
                for(String currency : sec.currency){
                    if (currency.equalsIgnoreCase(str)) {
                        System.out.println(j++ +
                                ".\tID  - " + sec.getId() +
                                ".\n\tКод - " + sec.getCode() + ".");
                    }
                }
            }
        }
    }

    public static <T> List<T> getObjectList(JsonReader jsonString, Class<T> cls) {
        List<T> list = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
