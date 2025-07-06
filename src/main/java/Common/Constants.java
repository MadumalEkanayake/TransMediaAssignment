package Common;

public class Constants {

    public static final String APP_URL = System.getProperty("app.url", "http://localhost:3000/");

    public static final String BASE_URI = System.getProperty("base.uri", "http://localhost:3000/api");
    public static final String BOARD_NAME = System.getProperty("Board.name", "New Board");

    public static String LISTNAME1 = System.getProperty("List.name1", "L1");
    public static String LISTNAME2 = System.getProperty("List.name2", "L2");

    public static String TEXTPATH = System.getProperty("text.path", "src/main/resources/listId.txt");




}
