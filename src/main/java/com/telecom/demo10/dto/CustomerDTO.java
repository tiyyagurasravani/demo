package com.telecom.demo10.dto;

        import java.util.List;
        import javax.validation.constraints.Email;
public class CustomerDTO {
    long phoneNo;
    String name;
    @Email(message = "Email id is not in format, please check")
    String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    int age;
    char gender;
    List<FriendFamilyDTO> friendAndFamily;
    String password;
    String address;
    PlanDTO currentPlan;
    public PlanDTO getCurrentPlan() {
        return currentPlan;
    }
    public void setCurrentPlan(PlanDTO currentPlan) {
        this.currentPlan = currentPlan;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<FriendFamilyDTO> getFriendAndFamily() {
        return friendAndFamily;
    }
    public void setFriendAndFamily(List<FriendFamilyDTO> friendAndFamily) {
        this.friendAndFamily = friendAndFamily;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "CustomerDTO [phoneNo=" + phoneNo + ", name=" + name + ", age=" + age + ", gender=" + gender
                + ", friendAndFamily=" + friendAndFamily + ", password=" + password + ", address=" + address + "]";
    }
}
