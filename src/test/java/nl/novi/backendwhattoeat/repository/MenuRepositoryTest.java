package nl.novi.backendwhattoeat.repository;


import nl.novi.backendwhattoeat.models.Menu;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ContextConfiguration
public class MenuRepositoryTest {

//    @Autowired
//    private TestEntityManager testEntityManager;
//
//    @Autowired
//    private MenuRepository menuRepository;
//
//    @Test
//    void testFindMenuById(){
//
//            Menu menu = new Menu ();
//            testEntityManager.persist(menu);
//            testEntityManager.flush();
//
//            Menu found = menuRepository.findById(Long.valueOf(1));
//
//            String expected = "sajoer boontjes";
//            String actual = found.getTitle();
//
//            assertEquals (expected, actual);
//    }
}
