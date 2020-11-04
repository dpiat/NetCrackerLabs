import com.nc.project.Client;
import com.nc.project.Contract;
import com.nc.project.InternetContract;
import com.nc.project.Repository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Predicate;

public class ContainerTesting {
    @Test
    public void testAddElem() {
        Repository<Contract> contractContainer = new Repository<>();
        Assert.assertEquals(0, contractContainer.size());
        Contract contract = new Contract(1, 1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L));
        Contract contract2 = new Contract(2, 2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L));
        contractContainer.add(contract);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract, contractContainer.get(1).get());
        contractContainer.add(contract2);
        Assert.assertEquals(2, contractContainer.size());
        Assert.assertEquals(contract2, contractContainer.get(2).get());

    }

    @Test
    public void testGetElemById() {
        Repository<Contract> contractContainer = new Repository<>();
        Contract contract = new Contract(1, 1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L));
        contractContainer.add(contract);
        Assert.assertEquals(contract, contractContainer.get(1).get());
    }

    @Test
    public void testRemoveElemById() {
        Repository<Contract> contractContainer = new Repository<>();
        Contract contract1 = new Contract(1, 1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L));
        Contract contract2 = new Contract(2, 2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L));contractContainer.add(contract1);
        contractContainer.add(contract2);
        Assert.assertEquals(2, contractContainer.size());
        contractContainer.remove(1);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract2, contractContainer.get(2).get());
    }

    @Test
    public void testRemoveElem() {
        Repository<Contract> contractContainer = new Repository();
        Contract contract1 = new Contract(1, 1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L));
        Contract contract2 = new Contract(2, 2, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L));
        contractContainer.add(contract1);
        contractContainer.add(contract2);
        Assert.assertEquals(2, contractContainer.size());
        contractContainer.remove(contract1);
        Assert.assertEquals(1, contractContainer.size());
        Assert.assertEquals(contract2, contractContainer.get(2).get());
    }

    @Test
    public void testSortByNumberContract() {
        Repository<Contract> contractContainer = new Repository<>();
        Assert.assertEquals(0, contractContainer.size());
        Contract contract1 = new Contract(1, 1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L));
        Contract contract2 = new Contract(3, 3, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L));
        Contract contract3 = new Contract(2, 2, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L));
        Contract contract4 = new Contract(4, 4, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L));
        contractContainer.add(contract1);
        contractContainer.add(contract2);
        contractContainer.add(contract3);
        contractContainer.add(contract4);
        Assert.assertEquals(4, contractContainer.size());

        Comparator<Contract> contractComparator = new Comparator<Contract>() {
            @Override
            public int compare(Contract o1, Contract o2) {
                return (int) (o1.getNumberContract()-o2.getNumberContract());
            }
        };
        contractContainer.sortBy(contractComparator);
        for (int i = 1; i <= 4; i++) {
            Assert.assertEquals(contractContainer.get(i).get().getNumberContract(), i);
        }
    }

    @Test
    public void testSearchByClientFIO() {
        Repository<Contract> contractContainer = new Repository<>();
        Assert.assertEquals(0, contractContainer.size());
        Contract contract1 = new Contract(1, 1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L));
        Contract contract2 = new Contract(3, 3, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L));
        Contract contract3 = new Contract(2, 2, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L));
        Contract contract4 = new Contract(4, 4, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L));
        contractContainer.add(contract1);
        contractContainer.add(contract2);
        contractContainer.add(contract3);
        contractContainer.add(contract4);
        Assert.assertEquals(4, contractContainer.size());

        Predicate<Contract> contractPredicate = new Predicate<Contract>() {
            @Override
            public boolean test(Contract contract) {
                return contract.getClient().getFIO().equals("Piatakin Dmitrii Igorevich");
            }
        };

        contractContainer = contractContainer.searchBy(contractPredicate);

        Assert.assertEquals(contractContainer.size(), 2);
    }

    @Test
    public void testSearchByMaxSpeedInInternetContract() {
        Repository<InternetContract> contractContainer = new Repository<>();
        Assert.assertEquals(0, contractContainer.size());
        InternetContract contract1 = new InternetContract(1, 1, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L), 200);
        InternetContract contract2 = new InternetContract(3, 3, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L), 220);
        InternetContract contract3 = new InternetContract(2, 2, new Date(100L), new Date(101L), new Client(1, "Piatakin Dmitrii Igorevich", new Date(2000, Calendar.JULY, 20), "Male",111111111L), 190);
        InternetContract contract4 = new InternetContract(4, 4, new Date(100L), new Date(101L), new Client(2, "Podruchnie Genadiy Vladimirovich", new Date(1998, Calendar.MARCH, 18), "Male", 1111112323L), 240);
        contractContainer.add(contract1);
        contractContainer.add(contract2);
        contractContainer.add(contract3);
        contractContainer.add(contract4);
        Assert.assertEquals(4, contractContainer.size());

        Predicate<InternetContract> contractPredicate = new Predicate<InternetContract>() {
            @Override
            public boolean test(InternetContract contract) {
                return contract.getMaxSpeed() > 200;
            }
        };

        contractContainer = contractContainer.searchBy(contractPredicate);

        Assert.assertEquals(contractContainer.size(), 2);
    }
}