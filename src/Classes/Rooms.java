package Classes;

public enum Rooms {
    HALLWAY_1("Hallway 1"),
    HALLWAY_2("Hallway 2"),
    HALLWAY_3("Hallway 3"),
    BEDROOM_1("Bedroom 1"),
    BEDROOM_2("Bedroom 2"),
    GUESTROOM("Guestroom"),
    KITCHEN("Kitchen"),
    BATHROOM("Bathroom"),
    TOILET("Toilet");

    private String str;

    Rooms(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
