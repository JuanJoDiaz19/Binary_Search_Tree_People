public class Person {

    private String name;
    private int id;
    private String city;
    private String birthDate;

    public Person(String name, int id, String city, String birthDate) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "***************************\n" + name + "\n" + birthDate + "\n" + id + "\n" + city + "\n***************************\n";
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
