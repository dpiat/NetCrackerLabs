import com.nc.project.JAXB.Jaxb;
import com.nc.project.model.client.Client;
import org.junit.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJaxb {
    @Test
    public void testToXml() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date birthday = null;
        try {
            birthday = dateFormat.parse("20.07.2000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Client client = new Client(1, "Piataikin Dmitrii Igorevich", birthday, "Male", 20132134);
        File file = new File("src/main/resources/client.xml");
        Jaxb.toXml(client, file.getPath());
    }

    @Test
    public void testFromXml() {
        Client client = new Client();
        client = (Client) Jaxb.fromXml("src/main/resources/client.xml", Client.class);
        System.out.println(client.toString());
    }
}
