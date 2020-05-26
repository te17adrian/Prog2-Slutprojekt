import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class solocontroller {
    private soloview Theview;
    private solomodel Themodel;

public solocontroller(soloview theview, solomodel themodel) {
    this.Theview = theview;
    this.Themodel = themodel;
    this.Theview.addSoloListener(new Sololistener());
    try {
        Connection conn = DatabaseExample.getConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    DatabaseExample.getBody(stmt, story_id);
    DatabaseExample.ResultSet rset2 = getResultSet(stmt, story_id, "select target_id, description from links where story_id = ");
    DatabaseExample.Next(rset2);
}

public class Sololistener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        int story_id, target_id = 1;

    }
}

}
