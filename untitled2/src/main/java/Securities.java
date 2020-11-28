import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Securities {
    int id;
    int code;
    String nameofComp;
    String[] currency;
    String dateTime;

    public Securities() {
    }

    public Securities(int id, String nameofComp, String[] currency, String dateTime, int code) {
        this.id = id;
        this.nameofComp = nameofComp;
        this.currency = currency;
        this.dateTime = dateTime;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameofComp() {
        return nameofComp;
    }

    public void setNameofComp(String nameofComp) {
        this.nameofComp = nameofComp;
    }

    public String[] getCurrency() {
        return currency;
    }

    public void setCurrency(String[] currency) {
        this.currency = currency;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDate getDateTime() { return LocalDate.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd")); }
}
