package tn.esprit.kaddemproject.services;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.kaddemproject.entities.*;
import tn.esprit.kaddemproject.repositories.ContratRepository;
import tn.esprit.kaddemproject.repositories.DepartementRepository;
import tn.esprit.kaddemproject.repositories.EquipeRepository;
import tn.esprit.kaddemproject.repositories.EtudiantRepository;
import java.util.List;


@SpringBootTest
@Slf4j
class IEtudiantServiceImplTest {

    @Autowired
    IEtudiantService etudiantService;
    @Autowired
    IDepartementServiceImpl departementService;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    // @Test
    // void retrieveAllEtudiant() {
    //     final List<Etudiant> allEtudiants = this.etudiantService.retrieveAll();
    //     // Vérifie que la liste n'est pas nulle
    //     Assertions.assertNotNull(allEtudiants);

    //     // Vérifie que la liste contient au moins un étudiant
    //     Assertions.assertTrue(allEtudiants.size() > 0);
    // }
    // @Test
    // void testupdate() {

    //     Etudiant existingEtudiant = etudiantService.retrieveById(5);


    //     existingEtudiant.setOptionE(Option.DS);
    //     Etudiant updatedEtudiant = etudiantService.update(existingEtudiant);


    //     Assertions.assertEquals(Option.DS, updatedEtudiant.getOptionE());
    // }
    // @Test
    // void testAssignEtudiantToDepartement() {

    //     Etudiant etudiant = etudiantRepository.findById(6).orElse(null);
    //     Departement departement = departementRepository.findById(1).orElse(null);

    //     etudiantService.assignEtudiantToDepartement(etudiant.getIdEtudiant(), departement.getIdDepart());

    //     Etudiant assignedEtudiant = etudiantService.retrieveById(6);

    //     Assertions.assertEquals(departement.getIdDepart(), assignedEtudiant.getDepartement().getIdDepart());
    // }
//    @Test
//     void testAddAndAssignEtudiantToEquipeAndContract() {

//         Etudiant etudiant = new Etudiant();
//         etudiant.setIdEtudiant(5);
//         etudiant.setNomE("Ouledhamed");
//         etudiant.setPrenomE("Mohamed");
//         etudiant.setOptionE(Option.GAMIX);
//         Contrat contrat = contratRepository.findById(1).orElse(null);
//         Equipe equipe = equipeRepository.findById(1).orElse(null);
//         log.info("contart"+contrat);
//         log.info("equipe"+equipe);

//         contratRepository.save(contrat);
//         equipeRepository.save(equipe);


//         Etudiant etudiantAssigne = etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant, contrat.getIdContrat(), equipe.getIdEquipe());
//         Assertions.assertTrue(isEtudiantAssignedToContractOrEquipe(etudiantAssigne.getIdEtudiant(), contrat.getIdContrat(), equipe.getIdEquipe()));
//     }
    // Méthode de vérification personnalisée pour tester l'affectation d'un étudiant
   private boolean isEtudiantAssignedToContractOrEquipe(Integer etudiantId, Integer contratId, Integer equipeId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        if (etudiant != null) {
            if (contratId != null) {
                // Vérifier l'affectation au contrat
                for (Contrat contrat : etudiant.getContrats()) {
                    if (contrat.getIdContrat().equals(contratId)) {
                        return true;
                    }
                }
            }
            if (equipeId != null) {
                // Vérifier l'affectation à l'équipe
                for (Equipe equipe : etudiant.getEquipes()) {
                    if (equipe.getIdEquipe().equals(equipeId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // @Test
    // void testadd() {
    //     Etudiant newEtudiant = new Etudiant();
    //     newEtudiant.setNomE("Ouledhamed");
    //     newEtudiant.setPrenomE("Mohamed");
    //     newEtudiant.setOptionE(Option.DS);
    //     Etudiant savedEtudiant = etudiantService.add(newEtudiant);

    //     // Vérifiez que l'étudiant a été correctement enregistré et possède un identifiant
    //     Assertions.assertNotNull(savedEtudiant.getNomE());
    // }
    // @Test
    // void testretrieveById(){
    //     Etudiant e = etudiantService.retrieveById(0);
    //     log.info("etudiant"+e);
    //     Assertions.assertNotNull(e);
    // }
    
    @Test
     void testdelete(){

        Etudiant etudiantToRemove = new Etudiant();

        etudiantService.delete(0);

        List<Etudiant> lista = etudiantService.retrieveAll();
        for(Etudiant e:lista){
            Assertions.assertNotEquals(e.getIdEtudiant(),etudiantToRemove.getIdEtudiant());
        }


    }
    @Test
     void testgetEtudiantsByDepartement(){
        List<Etudiant> e = etudiantService.getEtudiantsByDepartement(1);
        Assertions.assertNotNull(e);
    }

}








