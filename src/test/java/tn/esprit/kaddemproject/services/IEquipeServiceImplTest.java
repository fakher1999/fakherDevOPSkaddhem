package tn.esprit.kaddemproject;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.kaddemproject.entities.Equipe;
import tn.esprit.kaddemproject.entities.Niveau;
import tn.esprit.kaddemproject.repositories.EquipeRepository;
import tn.esprit.kaddemproject.services.IEquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest

public class IEquipeServiceImplTest {
        @Mock
        private EquipeRepository equipeRepository;

        @InjectMocks
        private IEquipeServiceImpl equipeService;


        @Test
        public void testadd() {

            Equipe equipe = new Equipe();
            equipe.setNomEquipe("Test AddTeam");
            equipe.setNiveau(Niveau.JUNIOR);

            when(equipeRepository.save(Mockito.any(Equipe.class))).thenReturn(equipe);

            Equipe savedEquipe = equipeService.add(equipe);

            assertNotNull(savedEquipe);
            assertNull(savedEquipe.getIdEquipe());
            assertEquals("Test AddTeam", savedEquipe.getNomEquipe());
            assertEquals(Niveau.JUNIOR, savedEquipe.getNiveau());
        }

        @Test
        public void testupdate() {
            Equipe equipe = new Equipe();
            equipe.setNomEquipe("Test UpdateTeam");
            equipe.setNiveau(Niveau.JUNIOR);

            when(equipeRepository.save(Mockito.any(Equipe.class))).thenReturn(equipe);

            Equipe savedEquipe = equipeService.add(equipe);

            when(equipeRepository.save(Mockito.any(Equipe.class))).thenReturn(savedEquipe);

            savedEquipe.setNiveau(Niveau.SENIOR);

            Equipe updatedEquipe = equipeService.update(savedEquipe);

            assertNotNull(updatedEquipe);
        }




        @Test
        public void testretrieveAll() {

            Equipe equipe1 = new Equipe();
            equipe1.setNomEquipe("Team Test1");
            equipe1.setNiveau(Niveau.JUNIOR);

            Equipe equipe2 = new Equipe();
            equipe2.setNomEquipe("Team Test2");
            equipe2.setNiveau(Niveau.SENIOR);

            List<Equipe> equipeList = new ArrayList<>();
            equipeList.add(equipe1);
            equipeList.add(equipe2);

            // Mock the behavior of the repository
            when(equipeRepository.findAll()).thenReturn(equipeList);

            List<Equipe> equipes = equipeService.retrieveAll();

            assertNotNull(equipes);
            assertEquals(2, equipes.size());
        }

        @Test
        public void testretrieveById() {

            Equipe equipe = new Equipe();
            equipe.setNomEquipe("Team Test3");
            equipe.setNiveau(Niveau.SENIOR);

            when(equipeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(equipe));

            Equipe retrievedEquipe = equipeService.retrieveById(1);

            assertNotNull(retrievedEquipe);
            assertEquals("Team Test3", retrievedEquipe.getNomEquipe());
            assertEquals(Niveau.SENIOR, retrievedEquipe.getNiveau());
        }

}