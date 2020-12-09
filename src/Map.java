import java.util.ArrayList;

/**
 *  This is a comment
 */
public class Map
{
    private Room outside;
    private Room theater, pub, lab, office;
    private Room startRoom;
    private Room tennisCourt;

    public Map()
    {
        createRooms();
        startRoom = outside;  // start game outside
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        outside = new Room(1, "outside the main entrance of the university");
        outside.setDescription("You have walked up a hill, still in the forest.  The road slopes back\n" +
                " down the other side of the hill.  There is a building in the distance.");

        pub = new Room(2, "in the campus pub");
        lab = new Room(3, "in a computing lab");
        office = new Room(4, "in the computing admin office");
        theater = new Room(5,"in a lecture theater");

        tennisCourt = new Room(6,"in a grass tennis court");
        tennisCourt.setItem(Items.BALL);

        connectOutside();
        connectLab();
        connectOffice();
        connectPub();
        connectTheatre();
        connectTennisCourt();
    }

    private void connectTennisCourt()
    {
        outside.setExit("north", tennisCourt);
        tennisCourt.setExit("soth", outside);
    }

    /**
     *
     * @return
     */
    private void connectOutside()
    {
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
    }

    private void connectPub()
    {
        pub.setExit("east", outside);
    }

    private void connectLab()
    {
        lab.setExit("north", outside);
        lab.setExit("east", office);
    }


    private void connectOffice()
    {
        office.setExit("west", lab);
    }

    private void connectTheatre()
    {
        theater.setExit("west", outside);
    }

    public Room getStart()
    {
        return startRoom;
    }
}
