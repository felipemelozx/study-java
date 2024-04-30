package entities;

public class People {
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    private  String name;
    private  String email;
    private  int numberRoom;

    public People(String name, String email, int numberRoom){
    this.name = name;
    this.email = email;
    this.numberRoom =numberRoom;
    }


}
