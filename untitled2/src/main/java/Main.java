import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("t.json"));
        List<Company> companyList = getObjectList(reader, Company.class);

//        1
//        showShortInfo(companyList);

        //2
//        showExpireSecur(companyList);

        //3
        showCompaniesOfDate(companyList);
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
        for (Company company : companyList)
        {
            for(Securities sec : company.getSecurities())
            {
                if (sec.getDateTime().isBefore(LocalDate.now())) {
                    System.out.println(j++ +
                            ".\tКод - " + sec.getId() +
                            ".\n\tДата истечения -" + sec.getDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                            ".\n\tВладелец - " + sec.getNameofComp() + ".");
                    i++;
                }
            }
        }
        System.out.println("Общее число таких бумаг - " + i + ".");
    }

    public static void showCompaniesOfDate(List<Company> companyList) {
        Scanner scan = new Scanner(System.in);
        Date date = null;
        List<DateValidator> dateFormats = DateValidator.getInstance();
        dateFormats.add(new DateValidator(DateTimeFormatter.ofPattern("dd.MM.yy"));
        dateFormats.add(new DateValidator(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        dateFormats.add(new DateValidator(DateTimeFormatter.ofPattern("dd/MM/yy"));
        dateFormats.add(new DateValidator(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String sdata = null;
        while (!(sdata = scan.nextLine()).equalsIgnoreCase("stop"))
        {
            for (SimpleDateFormat format : dateFormats) {
                try {
                    format.setLenient(false);
                    date = format.parse(sdata);
                } catch (ParseException e) {
                    System.out.println("Неверный формат даты. Попробуйте снова.\n(Ожидаемый формат: дд.мм.гг ; дд.мм.гггг ; дд/мм/гг ; дд/мм/ггг)");
                }
                if (date != null) {
                    break;
                }
            }
        }
    }

    public static <T> List<T> getObjectList(JsonReader jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
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
