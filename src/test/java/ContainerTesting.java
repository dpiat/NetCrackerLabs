import com.nc.project.Client;
import com.nc.project.Contract;
import com.nc.project.Repository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class ContainerTesting {
    @Test
    public void testAddElemToEnd() {
        Repository contractContainer = new Repository();
        Assert.assertEquals(0, contractContainer.size());
        Contract contract = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        contractContainer.add(contract);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract, contractContainer.get(contractContainer.size() - 1));
    }

    @Test
    public void testAddElemOnIndex() {
        Repository contractContainer = new Repository();
        Assert.assertEquals(0, contractContainer.size());
        Contract contract = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        contractContainer.add(0, contract);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract, contractContainer.get(contractContainer.size() - 1));
    }

    @Test
    public void testGetElemByIndex() {
        Repository contractContainer = new Repository();
        Contract contract = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        contractContainer.add(0, contract);
        Assert.assertEquals(contract, contractContainer.get(0));
    }

    @Test
    public void testRemoveElemByIndex() {
        Repository contractContainer = new Repository();
        Contract contract1 = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        Contract contract2 = new Contract(2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), 1111112323L));
        contractContainer.add(contract1);
        contractContainer.add(contract2);
        Assert.assertEquals(2, contractContainer.size());
        contractContainer.remove(0);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract2, contractContainer.get(0));
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
        Assert.assertEquals(contract2, contractContainer.get(0));
    }

    @Test
    public void testSetElemOnIndex() {
        Repository contractContainer = new Repository();
        Contract contract1 = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        Contract contract2 = new Contract(2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), 1111112323L));
        Contract contract3 = new Contract(3, new Date(100L), new Date(101L), new Client(3, "Ivanov Ivan Ivanovich", new Date(2003, Calendar.JULY, 27), 111111211L));
        contractContainer.add(contract1);
        contractContainer.add(contract2);
        Assert.assertEquals(2, contractContainer.size());
        contractContainer.set(0, contract3);
        Assert.assertEquals(2, contractContainer.size());
        Assert.assertEquals(contract3, contractContainer.get(0));
    }

    @Test
    public void testContainsElem() {
        Repository contractContainer = new Repository();
        Contract contract1 = new Contract(1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), 111111111L));
        Contract contract2 = new Contract(2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), 1111112323L));
        contractContainer.add(contract1);
        Assert.assertTrue(contractContainer.contains(contract1));
        Assert.assertFalse(contractContainer.contains(contract2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        Repository emptyList = new Repository();
        Contract contract = emptyList.get(0);
    }
}