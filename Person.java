/**
 * Interface is subset of Abstract class
 * @version 3.0
 * @since February 24, 2021
 *
 */

public abstract class Person {
    //Generic attributes to a person
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private long identificationNumber;
    private String address;
    private String phoneNumber;
    //check for @ and .extension (fancy)
    private String email;

    /**
     * default constructor
     */
    public Person() {

    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     * @param identificationNumber
     * @param address
     * @param phoneNumber
     * @param email
     *
     * constructor for data read from csv file
     */
    public Person(String firstName, String lastName, String dateOfBirth, long identificationNumber,
                  String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.identificationNumber = identificationNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    /**
     *
     * @return person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * {@link Person#getFirstName()}
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return person's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * {@link Person#getLastName()}
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return person's first and last name space seperated
     */
    public String getFullName() { return this.firstName + " " + this.lastName;}

    /**
     *
     * @return person's date of birth as string
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * {@link Person#getDateOfBirth()}
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @return person's identification number
     */
    public long getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * {@link Person#getIdentificationNumber()}
     */
    public void setIdentificationNumber(long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    /**
     *
     * @return person's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * {@link Person#getAddress()}
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return person's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * {@link Person#getPhoneNumber()}
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return person's email address
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * {@link Person#getEmail()}
     */
    public void setEmail(String email) {
        this.email = email;
    }


    public String fullName() {
        String s = this.firstName +" " +this.lastName;
        return s;
    }
}
