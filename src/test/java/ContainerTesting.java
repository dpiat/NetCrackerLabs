import com.nc.project.Client;
import com.nc.project.Contract;
import com.nc.project.Repository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class ContainerTesting {
    @Test
    public void testAddElem() {
        Repository contractContainer = new Repository();
        Assert.assertEquals(0, contractContainer.size());
        Contract contract = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        Contract contract2 = new Contract(2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), 1111112323L));
        contractContainer.add(contract);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract, contractContainer.get(1).get());
        contractContainer.add(contract2);
        Assert.assertEquals(2, contractContainer.size());
        Assert.assertEquals(contract2, contractContainer.get(2).get());

    }

    @Test
    public void testGetElemById() {
        Repository contractContainer = new Repository();
        Contract contract = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        contractContainer.add(contract);
        Assert.assertEquals(contract, contractContainer.get(1).get());
    }

    @Test
    public void testRemoveElemById() {
        Repository contractContainer = new Repository();
        Contract contract1 = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        Contract contract2 = new Contract(2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), 1111112323L));
        contractContainer.add(contract1);
        contractContainer.add(contract2);
        Assert.assertEquals(2, contractContainer.size());
        contractContainer.remove(1);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract2, contractContainer.get(2).get());
    }

    @Test
    public void testRemoveElem() {
        Repository contractContainer = new Repository();
        Contract contract1 = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        Contract contract2 = new Contract(2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), 1111112323L));
        contractContainer.add(contract1);
        contractContainer.add(contract2);
        Assert.assertEquals(2, contractContainer.size());
        contractContainer.remove(contract1);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract2, contractContainer.get(2).get());
    }
}