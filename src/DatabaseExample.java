
import java.sql.*;
import java.util.Scanner;

public class DatabaseExample {
    public static void main(String[] args) {
        try {

            Connection conn = getConnection();

            Statement stmt = conn.createStatement();
            int story_id = getStory_id();
            int target_id = 2;
            getBody(stmt, story_id);

            while (target_id != 22) {
                ResultSet rset2 = getResultSet(stmt, story_id, "select target_id, description from links where story_id = ");

                while (rset2.next()) {
                    Next(rset2);
                }

                Scanner in = new Scanner(System.in);
                target_id = in.nextInt();
                story_id = target_id;

                ResultSet rset3 = getResultSet(stmt, target_id, "select body from story where id = ");

                while (rset3.next()) {
                    String body = rset3.getString("body");
                    System.out.println(body);
                }

            }

            // Close conn and stmt
            conn.close();
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void Next(ResultSet rset2) throws SQLException {
        int target_ids = rset2.getInt("target_id");
        String description = rset2.getString("description");
        System.out.println(target_ids + ": " + description);
    }

    public static ResultSet getResultSet(Statement stmt, int story_id, String s) throws SQLException {
        String strSelect2 = s + story_id;
        System.out.println("The SQL statement is: " + strSelect2 + "\n");
        return stmt.executeQuery(strSelect2);
    }

    public static String getBody(Statement stmt, int story_id) throws SQLException {
        ResultSet rset = getResultSet(stmt, story_id, "select body from story where id = ");

        System.out.println("Story body:");
        while (rset.next()) {
            String body = rset.getString("body");
            System.out.println(body);
            return body;
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                        "jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                                "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        DatabaseLoginData.user, DatabaseLoginData.password);
    }

    private static int getStory_id() {
        return 1;
    }
}
