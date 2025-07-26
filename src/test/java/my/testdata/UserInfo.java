package my.testdata;

import lombok.Getter;
import lombok.Setter;
import my.testdata.TestData;


@Setter
@Getter
public class UserInfo {
    // Setter/Getter

    private String password;
    private String firstName;
    private String lastname;
    private String companyName;
    private String address1;
    private String address2;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;
    private String email;
    private String userName;
    // Constructor
    public UserInfo(String password, String firstName, String lastName, String companyName, String address1, String address2,
                    String state, String city, String zipCode, String mobileNumber) {
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastName;
        this.companyName = companyName;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
        this.mobileNumber = mobileNumber;
    }

    public UserInfo(){
        this.password = TestData.password;
        this.firstName = TestData.firstName;
        this.lastname = TestData.lastName;
        this.companyName = TestData.companyName;
        this.address1 = TestData.address1;
        this.address2 = TestData.address2;
        this.state = TestData.state;
        this.city = TestData.city;
        this.zipCode = TestData.zipCode;
        this.mobileNumber = TestData.mobileNumber;
        this.email = TestData.email;
        this.userName = TestData.userName;
    }


}
