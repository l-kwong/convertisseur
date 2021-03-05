// Nom : Lauren Kwong
// Date : Le 1 mars 2021
// Description : Ceci s'agit d'un convertisseur d'unité capable de convertir des unités impériales et les unités métriques de masse, 
// de volume, de longeur, de temp et de vitesse.

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SampleController implements Initializable{

    @FXML
    private ComboBox<String> cboVo1;

    @FXML
    private ComboBox<String> cboVo2;

    @FXML
    private ComboBox<String> cboMa1;

    @FXML
    private ComboBox<String> cboMa2;

    @FXML
    private ComboBox<String> cboVi1;

    @FXML
    private ComboBox<String> cboVi2;

    @FXML
    private TextField txtVo2;

    @FXML
    private TextField txtVo1;

    @FXML
    private TextField txtMa2;

    @FXML
    private TextField txtVi1;

    @FXML
    private TextField txtMa1;

    @FXML
    private TextField txtTe2;

    @FXML
    private TextField txtTe1;

    @FXML
    private ComboBox<String> cboLo1;

    @FXML
    private TextField txtVi2;

    @FXML
    private ComboBox<String> cboLo2;

    @FXML
    private ComboBox<String> cboTe1;

    @FXML
    private ComboBox<String> cboTe2;

    @FXML
    private TextField txtLo2;

    @FXML
    private TextField txtLo1;
    
    //masse
    private ObservableList<String> listeMa=(ObservableList<String>)FXCollections.observableArrayList("Kilograms", "Grams", "Miligrams", "Onces", "Livres");
    
    double []tabMass= {0.001,1.0,1000,0.035274,0.00220462};
    
    //volume
    private ObservableList<String> listeVo=(ObservableList<String>)FXCollections.observableArrayList("Litres", "Millilitres", "Gallons", "Pintes");
    
    double []tabVolu= {1.0,1000,0.219969,1.75975};
    
    //longeur
    private ObservableList<String> listeLo=(ObservableList<String>)FXCollections.observableArrayList("Kilomètres", "Mètres", "Centimètres", "Millimètres", "Pieds", "Verge", "Pouces", "Mille");
    
    double []tabLong= {0.001,1.0,100,1000,3.28084,1.09361,39.3701,0.000621371};
    
    //temp
    private ObservableList<String> listeTe=(ObservableList<String>)FXCollections.observableArrayList("Secondes", "Minutes", "Heures", "Millisecondes", "Jours");
    
    double []tabTemp= {60,1.0,0.0166667,60000,0.000694444};

    //vitesse
    private ObservableList<String> listeVi=(ObservableList<String>)FXCollections.observableArrayList("Kilomètres par heure", "Mètres par seconde", "Verge par heure", "Pieds par seconde");
    
    double []tabVite= {3.6,1.0,2.23694,3.28084};
   
    @Override
	public void initialize(URL location, ResourceBundle resources) 
    {
    	//masse
		cboMa1.setItems(listeMa);
		cboMa2.setItems(listeMa);
		cboMa1.getSelectionModel().selectFirst();
		cboMa2.getSelectionModel().selectFirst();
		//volume			
		cboVo1.setItems(listeVo);
		cboVo2.setItems(listeVo);
		cboVo1.getSelectionModel().selectFirst();
		cboVo2.getSelectionModel().selectFirst();
		//longeurs
		cboLo1.setItems(listeLo);
		cboLo2.setItems(listeLo);
		cboLo1.getSelectionModel().selectFirst();
		cboLo2.getSelectionModel().selectFirst();
		//température			
		cboTe1.setItems(listeTe);
		cboTe2.setItems(listeTe);
		cboTe1.getSelectionModel().selectFirst();
		cboTe2.getSelectionModel().selectFirst();
		//vitesse			
		cboVi1.setItems(listeVi);
		cboVi2.setItems(listeVi);
		cboVi1.getSelectionModel().selectFirst();
		cboVi2.getSelectionModel().selectFirst();
	}
    
    //pour calculer masse
    @FXML
    void calculerMa1()
    {
    	convertir(txtMa1,txtMa2,cboMa1,cboMa2,tabMass);
    }
    
    @FXML
    void calculerMa2()
    {
    	convertir(txtMa2,txtMa1,cboMa2,cboMa1,tabMass);
    }
    
    //pour calculer volume
    @FXML
    void calculerVo1()
    {
    	convertir(txtVo1,txtVo2,cboVo1,cboVo2,tabVolu);
    }
    
    @FXML
    void calculerVo2()
    {
    	convertir(txtVo2,txtVo1,cboVo2,cboVo1,tabVolu);
    }
    
    //pour calculer longeur
    @FXML
    void calculerLo1()
    {
    	convertir1(txtLo1,txtLo2,cboLo1,cboLo2,tabLong);
    }
    
    @FXML
    void calculerLo2()
    {
    	convertir1(txtLo2,txtLo1,cboLo2,cboLo1,tabLong);
    }
    
    //pour calculer température
    @FXML
    void calculerTe1()
    {
    	convertir(txtTe1,txtTe2,cboTe1,cboTe2,tabTemp);
    }
    
    @FXML
    void calculerTe2()
    {
    	convertir(txtTe2,txtTe1,cboTe2,cboTe1,tabTemp);
    }
    
    //pour calculer vitesse
    @FXML
    void calculerVi1()
    {
    	convertir(txtVi1,txtVi2,cboVi1,cboVi2,tabVite);
    }
    
    @FXML
    void calculerVi2()
    {
    	convertir(txtVi2,txtVi1,cboVi2,cboVi1,tabVite);
    }
    
    //caluler avec les nombres significatifs illimités
    public void convertir(TextField txtA, TextField txtB, ComboBox boxA, ComboBox boxB, double [] tab)
	{
		verifNum(txtA);
		
		int item1=boxA.getSelectionModel().getSelectedIndex();
		int item2=boxB.getSelectionModel().getSelectedIndex();
		try {
			double taux=tab[item2]/tab[item1];
			double res=taux*(Double.parseDouble(txtA.getText()));
			txtB.setText(Double.toString(res));
		} catch (NumberFormatException e) 
		{
			txtA.setText("0");
		}
	}
    
    //calculer avec une limitation de 4 nombres significants
    public void convertir1(TextField txtA, TextField txtB, ComboBox boxA, ComboBox boxB, double [] tab)
	{
		verifNum(txtA);
		
		int item1=boxA.getSelectionModel().getSelectedIndex();
		int item2=boxB.getSelectionModel().getSelectedIndex();
		try {
			double taux=tab[item2]/tab[item1];
			double res=taux*(Double.parseDouble(txtA.getText()));
			txtB.setText(String.format("%.4f", res));
		} catch (NumberFormatException e) 
		{
			txtA.setText("0");
		}
	}
    
    //Gestion numérique - accepter des caractères numériques seulement 
  	public void verifNum(TextField a)
  	{
  		if(a.getText().equals("")) a.setText("0");
  		a.textProperty().addListener((observable,oldValue,newValue)->
  		{
  			if(!newValue.matches("^[0-9](\\\\.[0-9]+)?$"))
  			{
  				a.setText(newValue.replaceAll("[^\\d*\\.]", ""));
  			}
  		});
  	}
  	
  	//pour quiter l'application
  	@FXML
  	private void quiter()
  	    {
  	    	System.exit(0);
  	    }
}
