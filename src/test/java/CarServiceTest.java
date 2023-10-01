import DAO.CarDAO;
import Service.CarService;
import org.junit.Before;
import org.mockito.Mockito;

public class CarServiceTest {
    CarService carService;
    CarDAO mockCarDAO;

    @Before
    public void setup(){
        mockCarDAO = Mockito.mock(CarDAO.class);
        carService = new CarService(mockCarDAO);
    }


}
