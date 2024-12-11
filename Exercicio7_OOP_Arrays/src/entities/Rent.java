package entities;

public class Rent {
    private String renterName;
    private String email;
    private int room;

    public Rent(String renterName, String email, int room) {
        this.renterName = renterName;
        this.email = email;
        this.room = room;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String toString() {
        return getRoom()
                + ": "
                + getRenterName()
                + ", "
                + getEmail();
    }


}
