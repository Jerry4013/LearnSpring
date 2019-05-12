package imooc.flashsale.service.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/03
 **/
public class UserModel {
    private Integer id;
    @NotBlank(message = "User name cannot be empty.")
    private String name;

    @NotNull(message = "gender cannot be empty.")
    private Byte gender;

    @NotNull(message = "age cannot be empty.")
    @Min(value = 0, message = "Age must be larger than 0.")
    @Max(value = 150, message = "Age must be less than 150.")
    private Integer age;

    @NotBlank(message = "Telephone number cannot be empty.")
    private String telephone;
    private String registerMode;
    private String thirdPartyId;

    @NotBlank(message = "Password cannot be empty.")
    private String encryptPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }
}
