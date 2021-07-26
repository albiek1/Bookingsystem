package business.entities;

public class User
{

    public User(String name, String email, String password, Integer phone, String role, int point)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.point = point;
    }

    public User(int id, String name, String email, Integer phone, int point){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.point = point;
    }

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private int point;
    private String name;
    private String email;
    private String password; // Should be hashed and secured
    private Integer phone;
    private String role;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getPhone(){
        return phone;
    }

    public void setPhone(Integer phone){
        this.phone = phone;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getPoint(){
        return point;
    }

    public void setPoint(int point){
        this.point = point;
    }
}
