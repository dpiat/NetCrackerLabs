import com.nc.project.JAXB.Jaxb;
import com.nc.project.exception.InjectException;
import com.nc.project.model.client.Client;
import com.nc.project.model.container.Repository;
import com.nc.project.model.contract.Contract;
import com.nc.project.util.CSVReader;
import com.nc.project.util.injector.Injector;
import org.junit.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestJaxb {
    @Test
    public void testToXmlForClient() {
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
    public void testFromXmlForCLient() {
        Client client = new Client();
        client = (Client) Jaxb.fromXml("src/main/resources/client.xml", Client.class);
        System.out.println(client.toString());
    }

    @Test
    public void testToXmlContractRepository() {
        Injector injector = null;
        try {
            injector = new Injector();
        } catch (InjectException e) {
            e.printStackTrace();
        }
        String csvFilePath = "src\\main\\resources\\contracts.csv";
        Repository<Contract> contractRepository = new Repository<>();
        CSVReader csvReader = new CSVReader();
        try {
            injector.inject(csvReader);
        } catch (InjectException e) {
            e.printStackTrace();
        }
        csvReader.readCSV(csvFilePath, contractRepository);
        try {
            injector.inject(contractRepository);
        } catch (InjectException e) {
            e.printStackTrace();
        }

        Jaxb.toXml(contractRepository, "src/main/resources/contractRepository.xml");
    }

    @Test
    public void testFromXmlContractRepository() {
        Injector injector = null;
        try {
            injector = new Injector();
        } catch (InjectException e) {
            e.printStackTrace();
        }
        Repository<Contract> contractRepository = new Repository<>();
        try {
            injector.inject(contractRepository);
        } catch (InjectException e) {
            e.printStackTrace();
        }
        contractRepository = (Repository<Contract>) Jaxb.fromXml("src/main/resources/contractRepository.xml", contractRepository.getClass());
        System.out.println(contractRepository.toString());
    }
}
