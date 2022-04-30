import java.io.Serializable;

public class Profile implements Serializable {
    private String name;
    private String dateOfBirth;
    private Address billingAddress;
    private Address mailAddress;

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getMailAddress() {
        return mailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setMailAddress(Address mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", billingAddress=" + billingAddress +
                ", mailAddress=" + mailAddress +
                '}';
    }
}
