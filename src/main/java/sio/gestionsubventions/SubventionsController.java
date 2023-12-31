package sio.gestionsubventions;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sio.gestionsubventions.Model.Structure;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class SubventionsController implements Initializable {
    HashMap<String, HashMap<String, TreeMap<Integer, ArrayList<Structure>>>> mesSubventions;
    @FXML
    private AnchorPane apAffecter;
    @FXML
    private ListView lvVilles;
    @FXML
    private AnchorPane apStatistiques;
    @FXML
    private ListView lvSecteurs;
    @FXML
    private ComboBox cboAnnees;
    @FXML
    private TextField txtNomStructure;
    @FXML
    private TextField txtMontant;
    @FXML
    private Button btnAffecterSubvention;
    @FXML
    private Button btnMenuAffecter;
    @FXML
    private Button btnMenuStatistiques;
    @FXML
    private ListView lvVillesStats;
    @FXML
    private TreeView tvMontantsParSecteurs;
    @FXML
    private TreeView tvMontantsParAnnees;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apAffecter.toFront();
        mesSubventions = new HashMap<>();

        lvVilles.getItems().addAll("Bordeaux", "Nantes", "Paris");
        lvSecteurs.getItems().addAll("Culture", "Education", "Santé", "Sport");
        cboAnnees.getItems().addAll(2020, 2021, 2022, 2023, 2024, 2025);
        cboAnnees.getSelectionModel().selectFirst();

        // Jeu d'essais au cas où :)
//        Structure structure1 = new Structure("Structure 1",1000);
//        Structure structure2 = new Structure("Structure 2",2000);
//        Structure structure3 = new Structure("Structure 3",3000);
//        Structure structure4 = new Structure("Structure 4",4000);
//        Structure structure5 = new Structure("Structure 5",5000);
//        Structure structure6 = new Structure("Structure 6",6000);
//        Structure structure7 = new Structure("Structure 7",7000);
//        Structure structure8 = new Structure("Structure 8",8000);
//        Structure structure9 = new Structure("Structure 9",9000);
//
//        ArrayList<Structure> lesStructuresDeBordeaux = new ArrayList<>();
//        lesStructuresDeBordeaux.add(structure1);
//        lesStructuresDeBordeaux.add(structure2);
//        lesStructuresDeBordeaux.add(structure3);
//
//        ArrayList<Structure> lesStructuresDeNantes = new ArrayList<>();
//        lesStructuresDeNantes.add(structure4);
//        lesStructuresDeNantes.add(structure5);
//        lesStructuresDeNantes.add(structure6);
//
//        ArrayList<Structure> lesStructuresDeParis = new ArrayList<>();
//        lesStructuresDeParis.add(structure7);
//        lesStructuresDeParis.add(structure8);
//        lesStructuresDeParis.add(structure9);
//
//        TreeMap<Integer,ArrayList<Structure>> lesAnneesDeBordeaux = new TreeMap<>();
//        lesAnneesDeBordeaux.put(2020, lesStructuresDeBordeaux);
//        lesAnneesDeBordeaux.put(2021, lesStructuresDeBordeaux);
//        lesAnneesDeBordeaux.put(2022, lesStructuresDeBordeaux);
//
//        TreeMap<Integer,ArrayList<Structure>> lesAnneesDeNantes = new TreeMap<>();
//        lesAnneesDeNantes.put(2020, lesStructuresDeNantes);
//        lesAnneesDeNantes.put(2021, lesStructuresDeNantes);
//        lesAnneesDeNantes.put(2022, lesStructuresDeNantes);
//        lesAnneesDeNantes.put(2023, lesStructuresDeNantes);
//
//        TreeMap<Integer,ArrayList<Structure>> lesAnneesDeParis = new TreeMap<>();
//        lesAnneesDeParis.put(2022, lesStructuresDeParis);
//        lesAnneesDeParis.put(2023, lesStructuresDeParis);
//        lesAnneesDeParis.put(2024, lesStructuresDeParis);
//
//        HashMap<String,TreeMap<Integer,ArrayList<Structure>>> lesSecteursDeBordeaux = new HashMap<>();
//        lesSecteursDeBordeaux.put("Santé", lesAnneesDeBordeaux);
//        lesSecteursDeBordeaux.put("Sport", lesAnneesDeBordeaux);
//
//        HashMap<String,TreeMap<Integer,ArrayList<Structure>>> lesSecteursDeNantes = new HashMap<>();
//        lesSecteursDeNantes.put("Education", lesAnneesDeNantes);
//        lesSecteursDeNantes.put("Culture", lesAnneesDeNantes);
//
//        HashMap<String,TreeMap<Integer,ArrayList<Structure>>> lesSecteursDeParis = new HashMap<>();
//        lesSecteursDeParis.put("Culture", lesAnneesDeParis);
//
//        mesSubventions.put("Bordeaux",lesSecteursDeBordeaux);
//        mesSubventions.put("Nantes",lesSecteursDeNantes);
//        mesSubventions.put("Paris",lesSecteursDeParis);

    }

    @FXML
    public void btnMenuClicked(Event event) {
        if (event.getSource() == btnMenuAffecter) {
            apAffecter.toFront();
        } else if (event.getSource() == btnMenuStatistiques) {
            apStatistiques.toFront();
        }
    }

    @FXML
    public void btnAffecterSubventionClicked(Event event) {
        if (lvVilles.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choix de la ville");
            alert.setHeaderText("");
            alert.setContentText("Sélectionner une ville");
            alert.showAndWait();
        } else if (lvSecteurs.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choix du secteur");
            alert.setHeaderText("");
            alert.setContentText("Sélectionner un secteur");
            alert.showAndWait();
        } else if (txtNomStructure.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("choix de la structure");
            alert.setHeaderText("");
            alert.setContentText("Saisir une structure");
            alert.showAndWait();
        } else if (txtMontant.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("choix du montant");
            alert.setHeaderText("");
            alert.setContentText("Saisir un montant");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Affectation reussi");
            alert.setHeaderText("");
            alert.setContentText("Subvention enregistré");
            alert.showAndWait();


            String strVilles = lvVilles.getSelectionModel().getSelectedItem().toString();
            String strSecteurs = lvSecteurs.getSelectionModel().getSelectedItem().toString();
            String strNomStructure = txtNomStructure.getText().toString();
            int intMontant = Integer.parseInt(txtMontant.getText());
            int intAnnee = Integer.parseInt(cboAnnees.getSelectionModel().getSelectedItem().toString());

            if (!mesSubventions.containsKey(strVilles)) {
                mesSubventions.put(strVilles, new HashMap<>());
            }
            if (!mesSubventions.get(strVilles).containsKey(strSecteurs)) {
                mesSubventions.get(strVilles).put(strSecteurs, new TreeMap<>());
            }
            if (!mesSubventions.get(strVilles).get(strSecteurs).containsKey(intAnnee)) {
                mesSubventions.get(strVilles).get(strSecteurs).put(intAnnee, new ArrayList<>());
            }
            mesSubventions.get(strVilles).get(strSecteurs).get(intAnnee).add(new Structure(strNomStructure, intMontant ));
            RemplirTreeViewDesTaches();
        }

    }

    public void RemplirTreeViewDesTaches() {
        TreeItem<String> rootItem = new TreeItem<>("Villes et Secteurs");

        for (String ville : mesSubventions.keySet()) {
            TreeItem<String> villeItem = new TreeItem<>(ville);

            for (String secteur : mesSubventions.get(ville).keySet()) {
                TreeItem<String> secteurItem = new TreeItem<>(secteur);

                for (Integer annee : mesSubventions.get(ville).get(secteur).keySet()) {
                    TreeItem<String> anneeItem = new TreeItem<>(annee.toString());

                    for (Structure structure : mesSubventions.get(ville).get(secteur).get(annee)) {
                        TreeItem<String> structureItem = new TreeItem<>(structure.getNomStructure()); // Assurez-vous que votre classe Structure a une méthode getNom()

                        anneeItem.getChildren().add(structureItem);
                    }

                    secteurItem.getChildren().add(anneeItem);
                }

                villeItem.getChildren().add(secteurItem);
            }

            rootItem.getChildren().add(villeItem);
        }

        tvMontantsParSecteurs.setRoot(rootItem);
    }





    @FXML
    public void lvVillesStatsClicked(Event event) {
    }
}