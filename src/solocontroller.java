import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class solocontroller {
    private soloview Theview;
    private solomodel Themodel;

public solocontroller(soloview theview, solomodel themodel) {
    this.Theview = theview;
    this.Themodel = themodel;
    this.Theview.addsoloListener(new sololistener());
}

}
