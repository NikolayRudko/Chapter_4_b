import Classes.ElectricalDevice;
import Classes.MyException.MyException;
import Classes.Rooms;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author NikolayRudko
 * @version 1.0
 * @since 2019-09-21
 */

/*Домашние электроприборы.
 Определить иерархию электроприборов.
 Включить некоторые в розетку.
 Подсчитать потребляемую мощность.
 Провести сортировку приборов в квартире на основе мощности.
 Найти  прибор в квартире, соответствующий заданному диапазону параметров.*/

public class Main {
    public static void main(String[] args) {
        //List of all device in home
        ElectricalDevice[] homeDevices = {
                new ElectricalDevice(0.005, "Light bulb 1", Rooms.HALLWAY_1),
                new ElectricalDevice(0.0075, "Light bulb 2", Rooms.HALLWAY_1),
                new ElectricalDevice(0.0075, "Light bulb 3", Rooms.HALLWAY_1),
                new ElectricalDevice(0.0075, "Light bulb 4", Rooms.GUESTROOM),
                new ElectricalDevice(0.005, "Light bulb 5", Rooms.GUESTROOM),
                new ElectricalDevice(0.0075, "Light bulb 6", Rooms.GUESTROOM),
                new ElectricalDevice(0.005, "Light bulb 7", Rooms.GUESTROOM),
                new ElectricalDevice(0.43, "Vacuum cleaner 1", Rooms.GUESTROOM),
                new ElectricalDevice(0.02, "TV_1", Rooms.GUESTROOM),
                new ElectricalDevice(0.03, "X-Box", Rooms.GUESTROOM),
                new ElectricalDevice(0.0075, "Light bulb 8", Rooms.HALLWAY_2),
                new ElectricalDevice(0.0075, "Light bulb 9", Rooms.HALLWAY_2),
                new ElectricalDevice(0.0075, "Light bulb 10", Rooms.BEDROOM_1),
                new ElectricalDevice(0.0075, "Light bulb 11", Rooms.BEDROOM_1),
                new ElectricalDevice(0.02, "TV_2", Rooms.BEDROOM_1),
                new ElectricalDevice(0.0075, "Light bulb 12", Rooms.BEDROOM_2),
                new ElectricalDevice(0.0075, "Light bulb 13", Rooms.BEDROOM_2),
                new ElectricalDevice(0.04, "Audio system", Rooms.BEDROOM_2),
                new ElectricalDevice(0.0075, "Light bulb 14", Rooms.HALLWAY_3),
                new ElectricalDevice(0.0075, "Light bulb 15", Rooms.HALLWAY_3),
                new ElectricalDevice(0.0075, "Light bulb 16", Rooms.BATHROOM),
                new ElectricalDevice(0.0075, "Light bulb 17", Rooms.BATHROOM),
                new ElectricalDevice(0.0075, "Light bulb 18", Rooms.BATHROOM),
                new ElectricalDevice(1.7, "Washer", Rooms.BATHROOM),
                new ElectricalDevice(0.0075, "Light bulb 18", Rooms.TOILET),
                new ElectricalDevice(0.0075, "Light bulb 19", Rooms.KITCHEN),
                new ElectricalDevice(0.0075, "Light bulb 20", Rooms.KITCHEN),
                new ElectricalDevice(0.0075, "Light bulb 21", Rooms.KITCHEN),
                new ElectricalDevice(0.0075, "Light bulb 22", Rooms.KITCHEN),
                new ElectricalDevice(0.2, "Fridge", Rooms.KITCHEN),
                new ElectricalDevice(0.5, "Microwave", Rooms.KITCHEN),
                new ElectricalDevice(1.5, "Electric kettle", Rooms.KITCHEN),
        };

        String[] menu = {
                "0 - Show all device.",
                "1 - Show rooms.",
                "2 - Show device of rooms.",
                "3 - Calculate the total power.",
                "4 - Switch on all electrical devices.",
                "5 - Sort by power.",
                "6 - Find by name.",
                "7 - Switch on device by ID",
                "8 - Switch off device by ID"
        };

        Scanner sc = new Scanner(System.in);
        String answer;

        do {
            //Show menu
            for (String item : menu) System.out.println(item);

            System.out.println("Enter menu item :");

            switch (inputMenuItem(menu.length)) {
                case 0:
                    printAllDevice(homeDevices);
                    break;
                case 1:
                    printAllRooms();
                    break;
                case 2:
                    showRoomDevice(homeDevices);
                    break;
                case 3:
                    System.out.println("Total power: " + calculateTotalPower(homeDevices));
                    break;
                case 4:
                    turnOnAllDevices(homeDevices);
                    break;
                case 5:
                    printAllDevice(powerSort(homeDevices));
                    printAllDevice(homeDevices);
                    break;
                case 6:
                    findByName(homeDevices);
                    break;
                case 7:

                    turnOnDeviceByID(homeDevices);
                    break;
                case 8:
                    System.out.println("Enter ID:");
                    turnOffDeviceByID(homeDevices);
                    break;
                default:
                    break;
            }
            System.out.println("Do you want continue work with program? Y/N");
            answer = sc.next();
        } while (answer.equals("Y") || answer.equals("y"));
    }

    /**
     * This method displays a list of all the devices on the screen.
     *
     * @param devices An array of transferable devices.
     */
    private static void printAllDevice(ElectricalDevice[] devices) {
        for (ElectricalDevice d : devices) {
            System.out.println(d);
        }
    }

    /**
     * This method displays a list of rooms in the house.
     *
     * @see Rooms
     */
    private static void printAllRooms() {
        System.out.println("The list of rooms at home:");
        for (Rooms room : Rooms.values()) {
            System.out.println(room.ordinal() + " - " + room.getStr());
        }
    }

    /**
     * This method displays a list of all the devices in the selected room.
     *
     * @param devices An array of transferable devices.
     */
    private static void showRoomDevice(ElectricalDevice[] devices) {

        Scanner sc = new Scanner(System.in);
        int itemMenu;
        String answer;

        do {
            //Show list of rooms
            printAllRooms();
            System.out.println("Enter menu item room:");
            itemMenu = inputMenuItem(Rooms.values().length);

            for (Rooms room : Rooms.values()) {
                if (itemMenu == room.ordinal()) {
                    for (ElectricalDevice e : devices) {
                        if (room == e.getLocation()) {
                            System.out.println(e);
                        }
                    }
                }
            }
            //Enter the answer to continue the work
            System.out.println("If you want to view other rooms, enter Y/N?");
            answer = sc.nextLine();
        } while (answer.equals("Y") || answer.equals("y"));
    }

    /**
     * This method includes all electrical devices.
     *
     * @param devices An array of transferable devices.
     */
    private static void turnOnAllDevices(ElectricalDevice[] devices) {
        for (ElectricalDevice d : devices) {
            d.setTurnOn(true);
        }
    }

    /**
     * This method input integer value from the console.
     *
     * @param max Number of menu items.
     */
    private static int inputMenuItem(int max) {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = scanner.nextInt();
                if (num < 0 || num > max)
                    throw new MyException("Not exit item: " + num);
                return num;
            } catch (InputMismatchException | MyException e) {
                scanner.nextLine();
                System.out.println("Exception: " + e);
                System.out.println("Not exit item. Try again: ");
            }
        }
    }


    /**
     * This method input integer value from the console.
     */
    private static int inputPositiveNum() {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = scanner.nextInt();
                if (num < 0)
                    throw new MyException("Not exit item: " + num);
                return num;
            } catch (InputMismatchException | MyException e) {
                scanner.nextLine();
                System.out.println("Exception: " + e);
                System.out.println("Enter only a positive value. Try again: ");
            }
        }
    }

    /**
     * This method calculates the total capacity of the included devices.
     *
     * @param devices An array of transferable devices.
     */
    private static double calculateTotalPower(ElectricalDevice[] devices) {
        double power = 0;
        for (ElectricalDevice device : devices) {
            if (device.isTurnOn())
                power += device.getPower();
        }
        return power;
    }

    /**
     * This method sorts all devices by power.
     *
     * @param electricalDevice An array of transferable devices.
     */
    private static ElectricalDevice[] powerSort(ElectricalDevice[] electricalDevice) {

        ElectricalDevice[] tempArray = electricalDevice.clone();
        ElectricalDevice temp;

        int n = tempArray.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tempArray[j].getPower() > tempArray[j + 1].getPower()) {
                    temp = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = temp;
                }
            }
        }
        return tempArray;
    }

    /**
     * This method searches for devices by name.
     *
     * @param devices An array of transferable devices.
     */
    private static void findByName(ElectricalDevice[] devices) {

        Scanner sc = new Scanner(System.in);
        String answerFindName;
        do {
            System.out.println("Enter the name of the device to search: ");
            String request = sc.nextLine();
            for (ElectricalDevice device : devices) {
                if (device.getName().toLowerCase().contains(request.toLowerCase())) {
                    System.out.println(device);
                }
            }
            System.out.println("Do you want to find another device? Y/N");
            answerFindName = sc.nextLine();
        } while (answerFindName.equals("Y") || answerFindName.equals("y"));
    }

    /**
     * This method includes an electrical device by ID.
     *
     * @param devices An array of transferable devices.
     *
     */
    private static void turnOnDeviceByID(ElectricalDevice[] devices) {
        Scanner sc = new Scanner(System.in);
        String answer;
        int id;
        do {
            System.out.println("Enter ID:");
            id = inputPositiveNum();
            if (id > devices[devices.length - 1].getIdDevice()) {
                System.out.printf("%d does not exist in the array.", id);
            } else {
                for (ElectricalDevice device : devices) {
                    if (device.getIdDevice() == id) {
                        device.setTurnOn(true);
                    }
                }
            }
            System.out.println("Do you want to switch on another device? Y/N");
            answer = sc.nextLine();
        } while (answer.equals("Y") || answer.equals("y"));
    }

    /**
     * This method turns off the electrical device by ID.
     *
     * @param devices An array of transferable devices.
     */
    private static void turnOffDeviceByID(ElectricalDevice[] devices) {
        Scanner sc = new Scanner(System.in);
        String answer;
        int id;
        do {
            System.out.println("Enter ID:");
            id = inputPositiveNum();
            if (id > devices[devices.length - 1].getIdDevice()) {
                System.out.printf("%d does not exist in the array.", id);
            } else {
                for (ElectricalDevice device : devices) {
                    if (device.getIdDevice() == id) {
                        device.setTurnOn(false);
                    }
                }
            }
            System.out.println("Do you want to switch off another device? Y/N");
            answer = sc.nextLine();
        } while (answer.equals("Y") || answer.equals("y"));
    }
}
