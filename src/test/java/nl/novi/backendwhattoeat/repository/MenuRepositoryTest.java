package nl.novi.backendwhattoeat.repository;

import nl.novi.backendwhattoeat.models.Menu;
import nl.novi.backendwhattoeat.repositories.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class MenuRepositoryTest {

//    @Autowired
//    TestEntityManager entityManager;
//
//    @Autowired
//    MenuRepository menuRepository;
//
//    @Test
//    public void findAllMenusTest(){
//        Menu menu = new Menu();
//        menu.setTitle("good testing");
//        menu.setGlutenAllergy(true);
//        Menu menu1 = new Menu();
//        menu1.setTitle("bad testing");
//        menu1.setGlutenAllergy(true);
//        Menu menu2 = menu;
//        entityManager.persist(menu);
//        entityManager.persist(menu1);
//        entityManager.flush();
//
//        Optional<Menu> actual = menuRepository.findMenuByTitleEqualsIgnoreCase("good testing");
//
//        assertEquals("good testing", actual.get().getTitle());
//    }

}
