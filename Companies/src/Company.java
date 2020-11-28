import java.security.Security;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Company {
    String full_name;
    String short_name;

    String dateOfFoundation;
    long ogrn;
    long inn;
    String[] phones;
    Address address;
    List<Securities> securities;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }

    public long getOgrn() {
        return ogrn;
    }

    public void setOgrn(int ogrn) {
        this.ogrn = ogrn;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public LocalDate getDateOfFoundation() { return LocalDate.parse(dateOfFoundation, DateTimeFormatter.ofPattern("yyyy-MM-dd")); }
}
