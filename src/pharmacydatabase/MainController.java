package pharmacydatabase;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import dao.ArtikalDAO;
import dao.CijenaDAO;
import dao.FakturaDAO;
import dao.KozmetikaDAO;
import dao.LijekDAO;
import dao.MedicinskiAparatDAO;
import dao.MjestoDAO;
import dao.ProizvodjacComboDAO;
import dao.ProizvodjacDAO;
import dao.RacunDAO;
import dao.ReceptDAO;
import dao.TipArtiklaDAO;
import dao.ZaposleniDAO;
import dto.Artikal;
import dto.Cijena;
import dto.Faktura;
import dto.FakturaStavka;
import dto.Lijek;
import dto.Kozmetika;
import dto.MedicinskiAparat;
import dto.Mjesto;
import dto.Proizvodjac;
import dto.ProizvodjacCombo;
import dto.RacunStavka;
import dto.Recept;
import dto.TipArtikla;
import dto.Zaposleni;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Aleksandra
 */
public class MainController implements Initializable {

    private ObservableList<RacunStavka> listaStavkaRacun;
    private ObservableList<Artikal> listaArtikala;
    private ObservableList<Faktura> listaFaktura;
    private ObservableList<FakturaStavka> listaStavkaFaktura;
    private ObservableList<Lijek> listaLijekova;
    private ObservableList<Kozmetika> listaKozmetika;
    private ObservableList<MedicinskiAparat> listaMedicinskiAparati;
    private ObservableList<Recept> listaRecepti;
    private ObservableList<Proizvodjac> listaProizvodjac;
    private ObservableList<Cijena> listaCijena;
    private ObservableList<Artikal> listaSkladiste;
    private static Proizvodjac selektProizvodjac;
    @FXML
    private StackPane stackpane;
    @FXML
    private JFXButton btnProizvodi;
    @FXML
    private JFXButton btnKasa;
    @FXML
    private JFXButton btnRecepti;
    @FXML
    private JFXButton btnSifarnici;
    @FXML
    private JFXButton btnFakture;
    @FXML
    private JFXButton btnSkladiste;
    @FXML
    private Pane pnFakture;
    @FXML
    private Pane pnKasa;
    @FXML
    private Pane pnProizvodi;
    @FXML
    private Pane pnRecepti;
    @FXML
    private Pane pnSifarnici;
    @FXML
    private Pane pnSkladiste;
    @FXML
    private TableView<Lijek> tabelaLijekovi;
    @FXML
    private TableView<Kozmetika> tabelaKozmetika;
    @FXML
    private TableView<MedicinskiAparat> tabelaMedicinskiAparati;
    @FXML
    private TableView<Recept> tabelaRecepti;
    @FXML
    private TableView<Proizvodjac> tabelaProizvodjac;
    @FXML
    private TableView<Faktura> tabelaFakture;
    @FXML
    private TableView tabelaKasa;
    @FXML
    private TableView tabelaStavkaFaktura;
    @FXML
    private TableView<Artikal> tabelaSkladiste;
    @FXML
    private ComboBox<Zaposleni> zaposleniComboBox;
    @FXML
    private ComboBox<TipArtikla> tipArtiklaComboBox;
    @FXML
    private ComboBox<Artikal> sifraArtiklaComboBox;
    @FXML
    private TextField kolicinaArtikla;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<RacunStavka> sr = new ArrayList<>();
        listaStavkaRacun = FXCollections.observableArrayList(sr);
        ArrayList<FakturaStavka> fs = new ArrayList<>();
        listaStavkaFaktura = FXCollections.observableArrayList(fs);

        allComboBox();
        allList();
        allTable();

        setCellValuesProizvodjac();
        setCellValuesMedicinskiAparati();
        setCellValuesKozmetika();
        setCellValuesLijek();
    }

    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////TABELE///////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////       
    private void tabelaLijekovi() {

        TableColumn Barkod = new TableColumn("Barkod");
        Barkod.setPrefWidth(55);
        Barkod.setCellValueFactory(
                new PropertyValueFactory<>("Barkod"));

        TableColumn NazivArtikla = new TableColumn("Naziv");
        NazivArtikla.setPrefWidth(100);
        NazivArtikla.setCellValueFactory(
                new PropertyValueFactory<>("NazivArtikla"));

        TableColumn Zaliha = new TableColumn("Na stanju");
        Zaliha.setPrefWidth(70);
        Zaliha.setCellValueFactory(
                new PropertyValueFactory<>("Zaliha"));

        TableColumn Proizvodjac = new TableColumn("Proizvođač");
        Proizvodjac.setPrefWidth(120);
        Proizvodjac.setCellValueFactory(
                new PropertyValueFactory<>("Proizvodjac"));

        TableColumn NazivTipa = new TableColumn("Režim izdavanja");
        NazivTipa.setPrefWidth(120);
        NazivTipa.setCellValueFactory(
                new PropertyValueFactory<>("NazivTipa"));

        TableColumn NabavnaCijena = new TableColumn("Nabavna cijena");
        NabavnaCijena.setPrefWidth(80);
        NabavnaCijena.setCellValueFactory(
                new PropertyValueFactory<>("NabavnaCijena"));

        TableColumn ProdajnaCijena = new TableColumn("Prodajna cijena");
        ProdajnaCijena.setPrefWidth(80);
        ProdajnaCijena.setCellValueFactory(
                new PropertyValueFactory<>("ProdajnaCijena"));

        TableColumn GenerickiNaziv = new TableColumn("Generički naziv");
        GenerickiNaziv.setPrefWidth(130);
        GenerickiNaziv.setCellValueFactory(
                new PropertyValueFactory<>("GenerickiNaziv"));

        TableColumn Doza = new TableColumn("Doza");
        Doza.setPrefWidth(120);
        Doza.setCellValueFactory(
                new PropertyValueFactory<>("Doza"));

        TableColumn Oblik = new TableColumn("Oblik");
        Oblik.setPrefWidth(100);
        Oblik.setCellValueFactory(
                new PropertyValueFactory<>("Oblik"));

        TableColumn NazivListe = new TableColumn("Naziv liste");
        NazivListe.setPrefWidth(120);
        NazivListe.setCellValueFactory(
                new PropertyValueFactory<>("NazivListe"));

        tabelaLijekovi.setItems(listaLijekova);
        tabelaLijekovi.getColumns().addAll(Barkod, NazivArtikla, Zaliha, Proizvodjac, NazivTipa, NabavnaCijena, ProdajnaCijena, GenerickiNaziv, Doza, Oblik, NazivListe);
    }

    private void tabelaKozmetika() {

        TableColumn Barkod = new TableColumn("Barkod");
        Barkod.setPrefWidth(60);
        Barkod.setCellValueFactory(
                new PropertyValueFactory<>("Barkod"));

        TableColumn NazivArtikla = new TableColumn("Naziv");
        NazivArtikla.setPrefWidth(160);
        NazivArtikla.setCellValueFactory(
                new PropertyValueFactory<>("NazivArtikla"));

        TableColumn Zaliha = new TableColumn("Na stanju");
        Zaliha.setPrefWidth(70);
        Zaliha.setCellValueFactory(
                new PropertyValueFactory<>("Zaliha"));

        TableColumn Proizvodjac = new TableColumn("Proizvođač");
        Proizvodjac.setPrefWidth(190);
        Proizvodjac.setCellValueFactory(
                new PropertyValueFactory<>("Proizvodjac"));

        TableColumn NabavnaCijena = new TableColumn("Nabavna cijena");
        NabavnaCijena.setPrefWidth(105);
        NabavnaCijena.setCellValueFactory(
                new PropertyValueFactory<>("NabavnaCijena"));

        TableColumn ProdajnaCijena = new TableColumn("Prodajna cijena");
        ProdajnaCijena.setPrefWidth(105);
        ProdajnaCijena.setCellValueFactory(
                new PropertyValueFactory<>("ProdajnaCijena"));

        TableColumn JedinicaMjere = new TableColumn("Jedinica mjere");
        JedinicaMjere.setPrefWidth(100);
        JedinicaMjere.setCellValueFactory(
                new PropertyValueFactory<>("JedinicaMjere"));

        TableColumn NazivTipa = new TableColumn("Režim izdavanja");
        NazivTipa.setPrefWidth(140);
        NazivTipa.setCellValueFactory(
                new PropertyValueFactory<>("NazivTipa"));

        tabelaKozmetika.setItems(listaKozmetika);
        tabelaKozmetika.getColumns().addAll(Barkod, NazivArtikla, Zaliha, Proizvodjac, NabavnaCijena, ProdajnaCijena, JedinicaMjere, NazivTipa);
    }

    private void tabelaMedicinskiAparati() {

        TableColumn Barkod = new TableColumn("Barkod");
        Barkod.setPrefWidth(60);
        Barkod.setCellValueFactory(
                new PropertyValueFactory<>("Barkod"));

        TableColumn NazivArtikla = new TableColumn("Naziv");
        NazivArtikla.setPrefWidth(210);
        NazivArtikla.setCellValueFactory(
                new PropertyValueFactory<>("NazivArtikla"));

        TableColumn Zaliha = new TableColumn("Na stanju");
        Zaliha.setPrefWidth(70);
        Zaliha.setCellValueFactory(
                new PropertyValueFactory<>("Zaliha"));

        TableColumn Proizvodjac = new TableColumn("Proizvođač");
        Proizvodjac.setPrefWidth(200);
        Proizvodjac.setCellValueFactory(
                new PropertyValueFactory<>("Proizvodjac"));

        TableColumn NabavnaCijena = new TableColumn("Nabavna cijena");
        NabavnaCijena.setPrefWidth(115);
        NabavnaCijena.setCellValueFactory(
                new PropertyValueFactory<>("NabavnaCijena"));

        TableColumn ProdajnaCijena = new TableColumn("Prodajna cijena");
        ProdajnaCijena.setPrefWidth(115);
        ProdajnaCijena.setCellValueFactory(
                new PropertyValueFactory<>("ProdajnaCijena"));

        TableColumn NazivTipa = new TableColumn("Režim izdavanja");
        NazivTipa.setPrefWidth(140);
        NazivTipa.setCellValueFactory(
                new PropertyValueFactory<>("NazivTipa"));

        tabelaMedicinskiAparati.setItems(listaMedicinskiAparati);
        tabelaMedicinskiAparati.getColumns().addAll(Barkod, NazivArtikla, Zaliha, Proizvodjac, NabavnaCijena, ProdajnaCijena, NazivTipa);
    }

    private void tabelaProizvodjaci() {
        TableColumn Naziv = new TableColumn("Naziv");
        Naziv.setPrefWidth(115);
        Naziv.setCellValueFactory(
                new PropertyValueFactory<>("Naziv"));

        TableColumn Adresa = new TableColumn("Adresa");
        Adresa.setPrefWidth(250);
        Adresa.setCellValueFactory(
                new PropertyValueFactory<>("Adresa"));

        TableColumn BrojPoste = new TableColumn("Broj pošte");
        BrojPoste.setPrefWidth(100);
        BrojPoste.setCellValueFactory(
                new PropertyValueFactory<>("BrojPoste"));

        TableColumn Mjesto = new TableColumn("Mjesto");
        Mjesto.setPrefWidth(250);
        Mjesto.setCellValueFactory(
                new PropertyValueFactory<>("Mjesto"));

        TableColumn Telefon = new TableColumn("Telefon");
        Telefon.setPrefWidth(160);
        Telefon.setCellValueFactory(
                new PropertyValueFactory<>("Telefon"));

        tabelaProizvodjac.setItems(listaProizvodjac);
        tabelaProizvodjac.getColumns().addAll(Naziv, Adresa, BrojPoste, Mjesto, Telefon);
    }

    private void tabelaRecepti() {

        TableColumn DatumIzdavanja = new TableColumn("Datum izdavanja");
        DatumIzdavanja.setPrefWidth(120);
        DatumIzdavanja.setCellValueFactory(
                new PropertyValueFactory<>("DatumIzdavanja"));

        TableColumn BrojKnjizice = new TableColumn("Broj knjižice");
        BrojKnjizice.setPrefWidth(120);
        BrojKnjizice.setCellValueFactory(
                new PropertyValueFactory<>("BrojKnjizice"));

        TableColumn JMBG = new TableColumn("Jmbg pacijenta");
        JMBG.setPrefWidth(120);
        JMBG.setCellValueFactory(
                new PropertyValueFactory<>("JMBG"));

        TableColumn SifraDoktora = new TableColumn("Šifra doktora");
        SifraDoktora.setPrefWidth(120);
        SifraDoktora.setCellValueFactory(
                new PropertyValueFactory<>("SifraDoktora"));

        TableColumn Barkod = new TableColumn("Barkod lijeka");
        Barkod.setPrefWidth(90);
        Barkod.setCellValueFactory(
                new PropertyValueFactory<>("Barkod"));

        TableColumn NazivArtikla = new TableColumn("Naziv lijeka");
        NazivArtikla.setPrefWidth(150);
        NazivArtikla.setCellValueFactory(
                new PropertyValueFactory<>("NazivArtikla"));

        TableColumn Kolicina = new TableColumn("Količina");
        Kolicina.setPrefWidth(60);
        Kolicina.setCellValueFactory(
                new PropertyValueFactory<>("Kolicina"));

        TableColumn ProdajnaCijena = new TableColumn("Cijena");
        ProdajnaCijena.setPrefWidth(70);
        ProdajnaCijena.setCellValueFactory(
                new PropertyValueFactory<>("ProdajnaCijena"));

        tabelaRecepti.setItems(listaRecepti);
        tabelaRecepti.getColumns().addAll(DatumIzdavanja, BrojKnjizice, JMBG, SifraDoktora, Barkod, NazivArtikla, Kolicina, ProdajnaCijena);
    }

    private void tabelaKasa() {
        TableColumn Barkod = new TableColumn("Barkod");
        Barkod.setPrefWidth(200);
        Barkod.setCellValueFactory(
                new PropertyValueFactory<>("Barkod"));

        TableColumn NazivArtikla = new TableColumn("Naziv artikla");
        NazivArtikla.setPrefWidth(210);
        NazivArtikla.setCellValueFactory(
                new PropertyValueFactory<>("NazivArtikla"));

        TableColumn Cijena = new TableColumn("Cijena");
        Cijena.setPrefWidth(210);
        Cijena.setCellValueFactory(
                new PropertyValueFactory<>("Cijena"));

        TableColumn Kolicina = new TableColumn("Količina");
        Kolicina.setPrefWidth(210);
        Kolicina.setCellValueFactory(
                new PropertyValueFactory<>("Kolicina"));

        tabelaKasa.setItems(listaStavkaRacun);
        tabelaKasa.getColumns().addAll(Barkod, NazivArtikla, Cijena, Kolicina);
    }

    private void tabelaStavkaFaktura() {

        TableColumn Barkod = new TableColumn("Barkod");
        Barkod.setPrefWidth(150);
        Barkod.setCellValueFactory(
                new PropertyValueFactory<>("Barkod"));

        TableColumn NazivArtikla = new TableColumn("Naziv artikla");
        NazivArtikla.setPrefWidth(300);
        NazivArtikla.setCellValueFactory(
                new PropertyValueFactory<>("NazivArtikla"));

        TableColumn Kolicina = new TableColumn("Količina");
        Kolicina.setPrefWidth(200);
        Kolicina.setCellValueFactory(
                new PropertyValueFactory<>("Kolicina"));

        TableColumn CijenaStavke = new TableColumn("Cijena");
        CijenaStavke.setPrefWidth(215);
        CijenaStavke.setCellValueFactory(
                new PropertyValueFactory<>("CijenaStavke"));

        tabelaStavkaFaktura.setItems(listaStavkaFaktura);
        tabelaStavkaFaktura.getColumns().addAll(Barkod, NazivArtikla, Kolicina, CijenaStavke);
    }

    private void tabelaFaktura() {

        TableColumn BrojFakture = new TableColumn("Broj fakture");
        BrojFakture.setPrefWidth(150);
        BrojFakture.setCellValueFactory(
                new PropertyValueFactory<>("BrojFakture"));

        TableColumn DatumIzdavanja = new TableColumn("Datum");
        DatumIzdavanja.setPrefWidth(300);
        DatumIzdavanja.setCellValueFactory(
                new PropertyValueFactory<>("DatumIzdavanja"));

        TableColumn IznosRacuna = new TableColumn("Iznos");
        IznosRacuna.setPrefWidth(200);
        IznosRacuna.setCellValueFactory(
                new PropertyValueFactory<>("IznosRacuna"));

        TableColumn Proizvodjac = new TableColumn("Proizvođač");
        Proizvodjac.setPrefWidth(215);
        Proizvodjac.setCellValueFactory(
                new PropertyValueFactory<>("Proizvodjac"));

        tabelaFakture.setItems(listaFaktura);
        tabelaFakture.getColumns().addAll(BrojFakture, DatumIzdavanja, IznosRacuna, Proizvodjac);
    }

    private void tabelaArtikli() {

        TableColumn Barkod = new TableColumn("Barkod");
        Barkod.setPrefWidth(140);
        Barkod.setCellValueFactory(
                new PropertyValueFactory<>("Barkod"));

        TableColumn NazivArtikla = new TableColumn("Naziv");
        NazivArtikla.setPrefWidth(250);
        NazivArtikla.setCellValueFactory(
                new PropertyValueFactory<>("NazivArtikla"));

        TableColumn Zaliha = new TableColumn("Na stanju");
        Zaliha.setPrefWidth(200);
        Zaliha.setCellValueFactory(
                new PropertyValueFactory<>("Zaliha"));

        TableColumn Proizvodjac = new TableColumn("Proizvođač");
        Proizvodjac.setPrefWidth(200);
        Proizvodjac.setCellValueFactory(
                new PropertyValueFactory<>("Proizvodjac"));

        tabelaSkladiste.setItems(listaSkladiste);
        tabelaSkladiste.getColumns().addAll(Barkod, NazivArtikla, Zaliha, Proizvodjac);
    }

    ///////////////////////////////////////////////////////////////////////////
    /////////////////////////////////LIJEKOVI//////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField sifraLijeka;
    @FXML
    private TextField nazivLijeka;
    @FXML
    private TextField generickiNaziv;
    @FXML
    private TextField nabavnaCijenaLijeka;
    @FXML
    private TextField prodajnaCijenaLijeka;
    @FXML
    private TextField dozaLijeka;
    @FXML
    private TextField oblikLijeka;
    @FXML
    private JFXComboBox<ProizvodjacCombo> proizvodjacComboBoxLijeka;
    @FXML
    private JFXComboBox<String> nazivListeComboBox;
    @FXML
    private JFXComboBox<TipArtikla> rezimIzdavanjaComboBoxLijeka;

    @FXML
    private void dodajLijekAction(MouseEvent event) throws IOException {

        try {
            if (!sifraLijeka.getText().equals("") && !nazivLijeka.getText().equals("")
                    && !generickiNaziv.getText().equals("") && !nabavnaCijenaLijeka.getText().equals("")
                    && !prodajnaCijenaLijeka.getText().equals("") && !dozaLijeka.getText().equals("")
                    && !oblikLijeka.getText().equals("") && !proizvodjacComboBoxLijeka.getValue().toString().equals("Izaberi")
                    && !nazivListeComboBox.getValue().equals("Izaberi") && !rezimIzdavanjaComboBoxLijeka.getValue().toString().equals("Izaberi")) {

                int barkod = Integer.parseInt(sifraLijeka.getText());
                String ime = nazivLijeka.getText();
                int proizvodjac = proizvodjacComboBoxLijeka.getValue().getIdProizvodjac();
                double nabavnaCijena = Double.parseDouble(nabavnaCijenaLijeka.getText());
                double prodajnaCijena = Double.parseDouble(prodajnaCijenaLijeka.getText());
                String nazivListe = nazivListeComboBox.getValue();
                int rezimIzdavanja = rezimIzdavanjaComboBoxLijeka.getValue().getIdTipArtikla();
                String genericki = generickiNaziv.getText();
                String doza = dozaLijeka.getText();
                String oblik = oblikLijeka.getText();

                boolean postoji = false;
                for (int i = 0; i < listaArtikala.size(); ++i) {
                    int sifra = listaArtikala.get(i).getBarkod();
                    if (sifra == barkod) {
                        postoji = true;
                        break;
                    }
                }
                if (postoji) {
                    Image image = new Image("img/delete.png");
                    Notifications notifications = Notifications.create()
                            .text("Artikal sa unesenim barkodom već postoji u bazi!")
                            .hideAfter(Duration.seconds(5))
                            .graphic(new ImageView(image))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.darkStyle();
                    notifications.show();
                } else {
                    LijekDAO.upisiLijek(barkod, ime, rezimIzdavanja, nabavnaCijena, prodajnaCijena, proizvodjac, genericki, doza, oblik, nazivListe);

                    osvjeziLijek();

                    Image image = new Image("img/mooo.png");
                    Notifications notifications = Notifications.create()
                            .text("Uspješan upis novog artikla.")
                            .hideAfter(Duration.seconds(5))
                            .graphic(new ImageView(image))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.darkStyle();
                    notifications.show();
                }
            } else {
                Image image = new Image("img/delete.png");
                Notifications notifications = Notifications.create()
                        .text("Unesite sva polja!")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
            }
        } catch (NumberFormatException e) {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Neispravan unos!")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    @FXML
    private void izmjeniLijekAction(MouseEvent event) throws IOException {

        if (!sifraLijeka.getText().equals("") && !nazivLijeka.getText().equals("")
                && !generickiNaziv.getText().equals("") && !dozaLijeka.getText().equals("")
                && !oblikLijeka.getText().equals("") && !nazivListeComboBox.getValue().equals("Izaberi")) {
            int barkod = Integer.parseInt(sifraLijeka.getText());
            String ime = nazivLijeka.getText();
            int proizvodjac = proizvodjacComboBoxLijeka.getValue().getIdProizvodjac();
            String nazivListe = nazivListeComboBox.getValue();
            String genericki = generickiNaziv.getText();
            String doza = dozaLijeka.getText();
            String oblik = oblikLijeka.getText();

            LijekDAO.izmijeniLijek(barkod, ime, proizvodjac, genericki, doza, oblik, nazivListe);

            osvjeziLijek();

        } else {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Selektuj red koji želite izmijeniti.")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    private void setCellValuesLijek() {
        tabelaLijekovi.setOnMouseClicked(e -> {
            Lijek k = tabelaLijekovi.getItems().get(tabelaLijekovi.getSelectionModel().getSelectedIndex());
            sifraLijeka.setText(k.getBarkod() + "");
            nazivLijeka.setText(k.getNazivArtikla());
            nazivListeComboBox.setValue(k.getNazivListe());
            nabavnaCijenaLijeka.setText(k.getNabavnaCijena() + "");
            prodajnaCijenaLijeka.setText(k.getProdajnaCijena() + "");
            generickiNaziv.setText(k.getGenerickiNaziv());
            dozaLijeka.setText(k.getDoza());
            oblikLijeka.setText(k.getOblik());
        });
    }

    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////KOZMETIKA//////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////    
    @FXML
    private TextField sifraKozmetike;
    @FXML
    private TextField nazivKozmetike;
    @FXML
    private JFXComboBox<ProizvodjacCombo> proizvodjacComboBoxKozmetike;
    @FXML
    private TextField nabavnaCijenaKozmetike;
    @FXML
    private TextField prodajnaCijenaKozmetike;
    @FXML
    private TextField jedinicuMjere;
    @FXML
    private JFXComboBox<TipArtikla> rezimIzdavanjaComboBoxKozmetike;

    @FXML
    private void dodajKozmetikaAction(MouseEvent event) throws IOException {

        try {
            if (!sifraKozmetike.getText().equals("") && !nazivKozmetike.getText().equals("")
                    && !rezimIzdavanjaComboBoxKozmetike.getValue().toString().equals("Izaberi") && !jedinicuMjere.getText().equals("")
                    && !proizvodjacComboBoxKozmetike.getValue().toString().equals("Izaberi") && !nabavnaCijenaKozmetike.getText().equals("")
                    && !prodajnaCijenaKozmetike.getText().equals("")) {

                int barkod = Integer.parseInt(sifraKozmetike.getText());
                String ime = nazivKozmetike.getText();
                double nabavnaCijena = Double.parseDouble(nabavnaCijenaKozmetike.getText());
                double prodajnaCijena = Double.parseDouble(prodajnaCijenaKozmetike.getText());
                int proizvodjac = proizvodjacComboBoxKozmetike.getValue().getIdProizvodjac();
                String jedinicaMjere = jedinicuMjere.getText();
                int rezimIzdavanja = rezimIzdavanjaComboBoxKozmetike.getValue().getIdTipArtikla();

                boolean postoji = false;
                for (int i = 0; i < listaArtikala.size(); ++i) {
                    int sifra = listaArtikala.get(i).getBarkod();
                    if (sifra == barkod) {
                        postoji = true;
                        break;
                    }
                }
                if (postoji) {
                    Image image = new Image("img/delete.png");
                    Notifications notifications = Notifications.create()
                            .text("Artikal sa unesenim barkodom već postoji u bazi!")
                            .hideAfter(Duration.seconds(5))
                            .graphic(new ImageView(image))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.darkStyle();
                    notifications.show();
                } else {

                    KozmetikaDAO.upisiKozmetika(barkod, ime, nabavnaCijena, prodajnaCijena, proizvodjac, jedinicaMjere, rezimIzdavanja);

                    osvjeziKozmetika();

                    Image image = new Image("img/mooo.png");
                    Notifications notifications = Notifications.create()
                            .text("Uspješan upis novog artikla.")
                            .hideAfter(Duration.seconds(5))
                            .graphic(new ImageView(image))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.darkStyle();
                    notifications.show();
                }
            } else {
                Image image = new Image("img/delete.png");
                Notifications notifications = Notifications.create()
                        .text("Unesite sva polja!")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
            }
        } catch (NumberFormatException e) {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Neispravan unos!")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    @FXML
    private void izmijeniKozmetikaAction(MouseEvent event) throws IOException {

        if (!sifraKozmetike.getText().equals("") && !nazivKozmetike.getText().equals("")
                && !jedinicuMjere.getText().equals("")) {

            int barkod = Integer.parseInt(sifraKozmetike.getText());
            String naziv = nazivKozmetike.getText();
            int proizvodjac = proizvodjacComboBoxKozmetike.getValue().getIdProizvodjac();
            String jedinicaMjere = jedinicuMjere.getText();

            KozmetikaDAO.izmijeniKozmetiku(barkod, naziv, proizvodjac, jedinicaMjere);

            osvjeziKozmetika();

        } else {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Selektuj red koji želite izmijeniti.")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    private void setCellValuesKozmetika() {
        tabelaKozmetika.setOnMouseClicked(e -> {
            Kozmetika k = tabelaKozmetika.getItems().get(tabelaKozmetika.getSelectionModel().getSelectedIndex());
            sifraKozmetike.setText(k.getBarkod() + "");
            nazivKozmetike.setText(k.getNazivArtikla());
            nabavnaCijenaKozmetike.setText(k.getNabavnaCijena() + "");
            prodajnaCijenaKozmetike.setText(k.getProdajnaCijena() + "");
            jedinicuMjere.setText(k.getJedinicaMjere());
        });
    }

    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////KASA/////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////   
    @FXML
    private void dodajStavkuAction(ActionEvent event) {

        try {
            if (zaposleniComboBox.getValue().toString().equals("Izaberi") || tipArtiklaComboBox.getValue().toString().equals("Izaberi")
                    || kolicinaArtikla.getText().equals("")) {

                Image image = new Image("img/delete.png");
                Notifications notifications = Notifications.create()
                        .text("Unesite sva polja!")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
            } else {
                boolean sadrzi = false;
                boolean postoji = false;
                int i = 0;

                int barkod = sifraArtiklaComboBox.getValue().getBarkod();
                String nazivArtikla = sifraArtiklaComboBox.getValue().getNazivArtikla();
                int kolicina = Integer.parseInt(kolicinaArtikla.getText());
                int tipArtikla = tipArtiklaComboBox.getValue().getIdTipArtikla();
                int idZaposlenog = zaposleniComboBox.getValue().getIdZaposlenog();
                double cijena = 0.00;

                for (i = 0; i < listaArtikala.size(); ++i) {
                    if (listaArtikala.get(i).getBarkod() == barkod && listaArtikala.get(i).getZaliha() < kolicina) {
                        postoji = true;
                        break;
                    }
                }
                if (postoji) {
                    Image image = new Image("img/delete.png");
                    Notifications notifications = Notifications.create()
                            .text("Nema dovoljno na stanju, provjerite zalihe!")
                            .hideAfter(Duration.seconds(5))
                            .graphic(new ImageView(image))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.darkStyle();
                    notifications.show();

                } else {
                    for (i = 0; i < listaStavkaRacun.size(); ++i) {
                        if (listaStavkaRacun.get(i).getBarkod() == barkod && listaStavkaRacun.get(i).getIdTipArtikla() == tipArtikla) {
                            sadrzi = true;
                            break;
                        }
                    }
                    if (sadrzi) {
                        int kol = 0;
                        RacunStavka stavka = listaStavkaRacun.get(i);
                        listaStavkaRacun.remove(i);
                        kol = Integer.parseInt(kolicinaArtikla.getText());
                        stavka.setKolicina(kol);
                        listaStavkaRacun.add(i, stavka);
                        tabelaKasa.setItems(listaStavkaRacun);
                        kolicinaArtikla.setText("");
                    } else {
                        int tip = 0;

                        for (i = 0; i < listaCijena.size(); ++i) {
                            if (listaCijena.get(i).getBarkod() == barkod && listaCijena.get(i).getTipArtikla().getIdTipArtikla() == tipArtikla) {
                                cijena = listaCijena.get(i).getProdajnaCijena();
                                tip = listaCijena.get(i).getTipArtikla().getIdTipArtikla();
                                break;
                            }
                        }
                        if (tip != tipArtikla) {
                            Image image = new Image("img/delete.png");
                            Notifications notifications = Notifications.create()
                                    .text("Provjeriti tip artikla!")
                                    .hideAfter(Duration.seconds(5))
                                    .graphic(new ImageView(image))
                                    .position(Pos.BOTTOM_RIGHT);
                            notifications.darkStyle();
                            notifications.show();

                        } else {
                            if (tipArtiklaComboBox.getValue().toString().equals("Izdaje se na recept")
                                    && listaCijena.get(i).getTipArtikla().getIdTipArtikla() == 1) {
                                listaStavkaRacun.add(new RacunStavka(barkod, nazivArtikla, kolicina, cijena, idZaposlenog, tipArtikla));
                                kolicinaArtikla.setText("");
                                sifraArtiklaComboBox.getSelectionModel().select(0);
                                tipArtiklaComboBox.getSelectionModel().select(0);

                            } else if (tipArtiklaComboBox.getValue().toString().equals("Izdaje se bez recepta")
                                    && listaCijena.get(i).getTipArtikla().getIdTipArtikla() == 2) {
                                listaStavkaRacun.add(new RacunStavka(barkod, nazivArtikla, kolicina, cijena, idZaposlenog, tipArtikla));
                                kolicinaArtikla.setText("");
                                sifraArtiklaComboBox.getSelectionModel().select(0);
                                tipArtiklaComboBox.getSelectionModel().select(0);
                            } else {
                                listaStavkaRacun.add(new RacunStavka(barkod, nazivArtikla, kolicina, cijena, idZaposlenog, tipArtikla));
                                kolicinaArtikla.setText("");
                                tipArtiklaComboBox.getSelectionModel().select(0);
                                sifraArtiklaComboBox.getSelectionModel().select(0);
                            }
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Neispravan unos!")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    @FXML
    private void noviRacunAction(ActionEvent event) {

        if (!listaStavkaRacun.isEmpty()) {
            RacunDAO.prodaj(listaStavkaRacun);
            tabelaKasa.setItems(listaStavkaRacun);
            ObservableList<Recept> recepti = ReceptDAO.getRecept();
            listaRecepti.setAll(recepti);
            tabelaRecepti.setItems(listaRecepti);
            ObservableList<Artikal> skladiste = ArtikalDAO.getSkladiste();
            listaSkladiste.setAll(skladiste);
            tabelaSkladiste.setItems(listaSkladiste);
            ObservableList<Artikal> artikal = ArtikalDAO.getArtikal();
            listaArtikala.setAll(artikal);
            ObservableList<Kozmetika> kozmetika = KozmetikaDAO.getKozmetika();
            listaKozmetika.setAll(kozmetika);
            ObservableList<Lijek> lijekovi = LijekDAO.getLijekovi();
            listaLijekova.setAll(lijekovi);
            ObservableList<MedicinskiAparat> medicinskiaparati = MedicinskiAparatDAO.getMedicinskiAparati();
            listaMedicinskiAparati.setAll(medicinskiaparati);
            listaStavkaRacun.clear();

            Image image = new Image("img/mooo.png");
            Notifications notifications = Notifications.create()
                    .text("Uspješno kreiran račun.")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        } else {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Unesite stavku.")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    @FXML
    private void ukloniStavkuAction(ActionEvent event) {

        ObservableList<RacunStavka> allracunstavka, racunstavka;
        allracunstavka = tabelaKasa.getItems();
        racunstavka = tabelaKasa.getSelectionModel().getSelectedItems();
        racunstavka.forEach(allracunstavka::remove);
    }

    @FXML
    private void unesiRecept(ActionEvent event) throws IOException {
        Parent part = FXMLLoader.load(getClass().getResource("/gui/Recept.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////MEDICINSKI APARATI///////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField sifraAparata;
    @FXML
    private TextField nazivAparata;
    @FXML
    private TextField nabavnaCijenaAparata;
    @FXML
    private TextField prodajnaCijenaAparata;
    @FXML
    private JFXComboBox<ProizvodjacCombo> proizvodjacComboBoxAparata;
    @FXML
    private JFXComboBox<TipArtikla> rezimIzdavanjaComboBoxAparata;

    @FXML
    private void dodajMedicinskiAparatiAction(MouseEvent event) throws IOException {

        try {
            if (!sifraAparata.getText().equals("") && !nazivAparata.getText().equals("")
                    && !rezimIzdavanjaComboBoxAparata.getValue().toString().equals("Izaberi")
                    && !proizvodjacComboBoxAparata.getValue().toString().equals("Izaberi")
                    && !nabavnaCijenaAparata.getText().equals("") && !prodajnaCijenaAparata.getText().equals("")) {
                int barkod = Integer.parseInt(sifraAparata.getText());
                String ime = nazivAparata.getText();
                int proizvodjac = proizvodjacComboBoxAparata.getValue().getIdProizvodjac();
                double nabavnaCijena = Double.parseDouble(nabavnaCijenaAparata.getText());
                double prodajnaCijena = Double.parseDouble(prodajnaCijenaAparata.getText());
                int rezimIzdavanja = rezimIzdavanjaComboBoxAparata.getValue().getIdTipArtikla();

                boolean postoji = false;
                for (int i = 0; i < listaArtikala.size(); ++i) {
                    int sifra = listaArtikala.get(i).getBarkod();
                    if (sifra == barkod) {
                        postoji = true;
                        break;
                    }
                }
                if (postoji) {
                    Image image = new Image("img/delete.png");
                    Notifications notifications = Notifications.create()
                            .text("Artikal sa unesenim barkodom već postoji u bazi!")
                            .hideAfter(Duration.seconds(5))
                            .graphic(new ImageView(image))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.darkStyle();
                    notifications.show();
                } else {

                    MedicinskiAparatDAO.upisiMedicinskiAparati(barkod, ime, nabavnaCijena, prodajnaCijena, proizvodjac, rezimIzdavanja);

                    Image image = new Image("img/mooo.png");
                    Notifications notifications = Notifications.create()
                            .text("Uspješan upis novog artikla.")
                            .hideAfter(Duration.seconds(5))
                            .graphic(new ImageView(image))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.darkStyle();
                    notifications.show();

                    osvjeziMedicinskiAparat();
                }
            } else {
                Image image = new Image("img/delete.png");
                Notifications notifications = Notifications.create()
                        .text("Unesite sva polja!")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
            }
        } catch (NumberFormatException e) {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Neispravan unos")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    @FXML
    private void izmijeniMedicinskiAparatAction(MouseEvent event) throws IOException {

        if (!sifraAparata.getText().equals("") && !nazivAparata.getText().equals("")) {
            int barkod = Integer.parseInt(sifraAparata.getText());
            String naziv = nazivAparata.getText();
            int proizvodjac = proizvodjacComboBoxAparata.getValue().getIdProizvodjac();

            MedicinskiAparatDAO.izmijeniMedicinskiAparat(barkod, naziv, proizvodjac);

            osvjeziMedicinskiAparat();

        } else {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Selektuj red koji želite izmijeniti.")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    private void setCellValuesMedicinskiAparati() {
        tabelaMedicinskiAparati.setOnMouseClicked(e -> {

            MedicinskiAparat m = tabelaMedicinskiAparati.getItems().get(tabelaMedicinskiAparati.getSelectionModel().getSelectedIndex());
            sifraAparata.setText(m.getBarkod() + "");
            nazivAparata.setText(m.getNazivArtikla());
            nabavnaCijenaAparata.setText(m.getNabavnaCijena() + "");
            prodajnaCijenaAparata.setText(m.getProdajnaCijena() + "");
        });
    }
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////PROIZVODJACI////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField nazivProizvodjaca;
    @FXML
    private TextField adresaProizvodjaca;
    @FXML
    private JFXComboBox<Mjesto> mjestoProizvodjacaComboBox;
    @FXML
    private TextField telefonProizvodjaca;

    @FXML
    private void dodajProizvodjacaAction(MouseEvent event) throws IOException {

        if (nazivProizvodjaca.getText().equals("") || adresaProizvodjaca.getText().equals("")
                || mjestoProizvodjacaComboBox.getValue().toString().equals("Izaberi") || telefonProizvodjaca.getText().equals("")) {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Unesite sva polja!")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        } else {
            String naziv = nazivProizvodjaca.getText();
            String adresa = adresaProizvodjaca.getText();
            String telefon = telefonProizvodjaca.getText();
            int mjesto = mjestoProizvodjacaComboBox.getValue().getBrojPoste();

            boolean postoji = false;
            for (int i = 0; i < listaProizvodjac.size(); ++i) {
                String nazivProizvodjaca = listaProizvodjac.get(i).getNaziv();
                if (nazivProizvodjaca.equals(naziv)) {
                    postoji = true;
                    break;
                }
            }
            if (postoji) {
                Image image = new Image("img/delete.png");
                Notifications notifications = Notifications.create()
                        .text("Proizvođač sa unesenim nazivom već postoji u bazi!")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
            } else {
                ProizvodjacDAO.upisiProizvodjaca(naziv, adresa, mjesto, telefon);

                Image image = new Image("img/mooo.png");
                Notifications notifications = Notifications.create()
                        .text("Uspješan upis novog proizvođača.")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();

                osvjeziProizvodjaca();
            }
        }
    }

    @FXML
    private void izmijeniProizvodjacaAction(MouseEvent event) throws IOException {

        if (mjestoProizvodjacaComboBox.getValue().toString().equals("Izaberi") || nazivProizvodjaca.getText().equals("")
                || adresaProizvodjaca.getText().equals("") || telefonProizvodjaca.getText().equals("")) {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Uneste sva polja!")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        } else {
            String naziv = nazivProizvodjaca.getText();
            String adresa = adresaProizvodjaca.getText();
            int mjesto = mjestoProizvodjacaComboBox.getValue().getBrojPoste();
            String telefon = telefonProizvodjaca.getText();

            ProizvodjacDAO.izmijeniProizvodjaca(naziv, adresa, mjesto, telefon);

            osvjeziProizvodjaca();
        }
    }

    @FXML
    private void obrisiProizvodjacaAction(MouseEvent event) {

        selektProizvodjac = tabelaProizvodjac.getSelectionModel().getSelectedItem();

        if (!nazivProizvodjaca.getText().equals("")) {
            ProizvodjacDAO proizvodjac = new ProizvodjacDAO();
            boolean isCorrect = proizvodjac.obrisiProizvodjaca(selektProizvodjac);
            if (isCorrect) {
                Image image = new Image("img/mooo.png");
                Notifications notifications = Notifications.create()
                        .text("Uspješno ste obrisali proizvođača.")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
                listaProizvodjac.remove(selektProizvodjac);

                osvjeziProizvodjaca();
            } else {
                Image image = new Image("img/delete.png");
                Notifications notifications = Notifications.create()
                        .text("Nije moguće obrisati proizvođača.")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
            }
        } else {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Selektujte red koji želite obrisati.")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    private void setCellValuesProizvodjac() {
        tabelaProizvodjac.setOnMouseClicked(e -> {

            Proizvodjac p = tabelaProizvodjac.getItems().get(tabelaProizvodjac.getSelectionModel().getSelectedIndex());
            nazivProizvodjaca.setText(p.getNaziv());
            adresaProizvodjaca.setText(p.getAdresa());
            telefonProizvodjaca.setText(p.getTelefon());
        });
    }
    ///////////////////////////////////////////////////////////////////////////
    ////////////////////////////////FAKTURA////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////   
    @FXML
    private JFXComboBox<Artikal> barkodStavkaFaktura;
    @FXML
    private TextField kolicinaStavkaFaktura;
    @FXML
    private JFXComboBox<ProizvodjacCombo> proizvodjacComboBoxFaktura;
    @FXML
    private TextField brojFakture;
    @FXML
    private JFXComboBox<Zaposleni> zaposleniComboBoxFaktura;

    @FXML
    private void kreirajFakturuAction(ActionEvent event) {
        if (!listaStavkaFaktura.isEmpty()) {
            FakturaDAO.faktura(listaStavkaFaktura);

            listaFaktura = FakturaDAO.getFaktura();
            tabelaFakture.setItems(listaFaktura);
            ObservableList<Artikal> skladiste = ArtikalDAO.getSkladiste();
            listaSkladiste.setAll(skladiste);
            tabelaSkladiste.setItems(listaSkladiste);
            ObservableList<Kozmetika> kozmetike = KozmetikaDAO.getKozmetika();
            listaKozmetika.setAll(kozmetike);
            ObservableList<Lijek> lijekovi = LijekDAO.getLijekovi();
            listaLijekova.setAll(lijekovi);
            ObservableList<MedicinskiAparat> medicinskiaparat = MedicinskiAparatDAO.getMedicinskiAparati();
            listaMedicinskiAparati.setAll(medicinskiaparat);
            listaStavkaFaktura.clear();
            brojFakture.setText("");
            kolicinaStavkaFaktura.setText("");
            barkodStavkaFaktura.setDisable(false);
            proizvodjacComboBoxFaktura.getSelectionModel().select(0);
            zaposleniComboBoxFaktura.getSelectionModel().select(0);

        } else {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Unesite stavku.")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    @FXML
    private void dodajStavkaFakturaAction(ActionEvent event) {

        try {
            if (zaposleniComboBoxFaktura.getValue().toString().equals("Izaberi")
                    || proizvodjacComboBoxFaktura.getValue().toString().equals("Izaberi")
                    || barkodStavkaFaktura.getValue().toString().equals("Izaberi") || brojFakture.getText().equals("") || kolicinaStavkaFaktura.getText().equals("")) {

                Image image = new Image("img/delete.png");
                Notifications notifications = Notifications.create()
                        .text("Unesite sva polja!")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
            } else {
                int faktura = Integer.parseInt(brojFakture.getText());
                String imeProizvodjac = proizvodjacComboBoxFaktura.getValue().getNaziv();
                int idProizvodjac = proizvodjacComboBoxFaktura.getValue().getIdProizvodjac();
                int barkod = barkodStavkaFaktura.getValue().getBarkod();
                String nazivArtikla = barkodStavkaFaktura.getValue().getNazivArtikla();
                int kolicina = Integer.parseInt(kolicinaStavkaFaktura.getText());
                int idZaposlenog = zaposleniComboBoxFaktura.getValue().getIdZaposlenog();

                boolean ima = false;
                for (int i = 0; i < listaFaktura.size(); ++i) {
                    int brojFakture = listaFaktura.get(i).getBrojFakture();
                    if (brojFakture == faktura) {
                        ima = true;
                        break;
                    }
                }
                if (ima) {
                    Image image = new Image("img/delete.png");
                    Notifications notifications = Notifications.create()
                            .text("Broj fakture postoji u bazi!")
                            .hideAfter(Duration.seconds(5))
                            .graphic(new ImageView(image))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.darkStyle();
                    notifications.show();
                } else {
                    int i = 0;
                    boolean sadrzi = false;
                    boolean postoji = false;

                    for (i = 0; i < listaArtikala.size(); ++i) {
                        if (listaArtikala.get(i).getBarkod() == barkod && listaArtikala.get(i).getProizvodjac().getNaziv().equals(imeProizvodjac)) {
                            barkod = listaArtikala.get(i).getBarkod();
                            sadrzi = true;
                            break;
                        }
                    }

                    if (sadrzi) {
                        double cijena = 0.00;
                        for (i = 0; i < listaCijena.size(); ++i) {
                            if (listaCijena.get(i).getBarkod() == barkod) {
                                cijena = listaCijena.get(i).getNabavnaCijena();
                                break;
                            }
                        }
                        //da li postoji vec artikal u StavkaFaktura
                        for (i = 0; i < listaStavkaFaktura.size(); ++i) {
                            if (listaStavkaFaktura.get(i).getBarkod() == barkod) {
                                postoji = true;
                                break;
                            }
                        }
                        if (postoji) {
                            FakturaStavka fakturastavka = listaStavkaFaktura.get(i);
                            listaStavkaFaktura.remove(i);
                            int kol = 0;
                            kol = Integer.parseInt(kolicinaStavkaFaktura.getText());
                            fakturastavka.setKolicina(kol);
                            listaStavkaFaktura.add(i, fakturastavka);
                            tabelaStavkaFaktura.setItems(listaStavkaFaktura);
                            kolicinaStavkaFaktura.setText("");
                            barkodStavkaFaktura.setDisable(false);
                        } else {

                            listaStavkaFaktura.add(new FakturaStavka(faktura, barkod, nazivArtikla, kolicina, cijena, idProizvodjac, idZaposlenog));

                            tabelaStavkaFaktura.setItems(listaStavkaFaktura);
                            kolicinaStavkaFaktura.setText("");
                            barkodStavkaFaktura.setDisable(false);
                        }
                    } else {
                        Image image = new Image("img/delete.png");
                        Notifications notifications = Notifications.create()
                                .text("Proizvođač ne proizvodi dati lijek!")
                                .hideAfter(Duration.seconds(5))
                                .graphic(new ImageView(image))
                                .position(Pos.CENTER_RIGHT);
                        notifications.darkStyle();
                        notifications.show();
                    }
                }
            }
        } catch (NumberFormatException e) {
            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .text("Neispravan unos")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
        }
    }

    @FXML
    private void ukloniStavkaFakturaAction(ActionEvent event) {
        ObservableList<FakturaStavka> allfakturastavka, fakturastavka;
        allfakturastavka = tabelaStavkaFaktura.getItems();
        fakturastavka = tabelaStavkaFaktura.getSelectionModel().getSelectedItems();
        fakturastavka.forEach(allfakturastavka::remove);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnProizvodi) {
            pnProizvodi.toFront();
        } else if (event.getSource() == btnKasa) {
            pnKasa.toFront();
        } else if (event.getSource() == btnFakture) {
            pnFakture.toFront();
        } else if (event.getSource() == btnRecepti) {
            pnRecepti.toFront();
        } else if (event.getSource() == btnSifarnici) {
            pnSifarnici.toFront();
        } else if (event.getSource() == btnSkladiste) {
            pnSkladiste.toFront();
        }
    }

    @FXML
    private void logout(MouseEvent event) {
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("ZATVORI"));
        dialogLayout.setBody(new Text("Da li želiš da izađeš?"));

        JFXButton ok = new JFXButton("Da");
        JFXButton Cancel = new JFXButton("Odustani");

        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);

        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        Cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        dialogLayout.setActions(ok, Cancel);
        dialog.show();
    }

    @FXML
    private void mouse_ext_proizvodi(MouseEvent event) {
        btnProizvodi.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    private void mouse_ent_proizvodi(MouseEvent event) {
        btnProizvodi.setStyle("-fx-background-color: #dbdbdb;");
    }

    @FXML
    private void mouse_ext_kasa(MouseEvent event) {
        btnKasa.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    private void mouse_ent_kasa(MouseEvent event) {
        btnKasa.setStyle("-fx-background-color: #dbdbdb;");
    }

    @FXML
    private void mouse_ext_izvjestaji(MouseEvent event) {
        btnRecepti.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    private void mouse_ent_izvjestaji(MouseEvent event) {
        btnRecepti.setStyle("-fx-background-color: #dbdbdb;");
    }

    @FXML
    private void mouse_ext_sifarnici(MouseEvent event) {
        btnSifarnici.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    private void mouse_ent_sifarnici(MouseEvent event) {
        btnSifarnici.setStyle("-fx-background-color: #dbdbdb;");
    }

    @FXML
    private void mouse_ext_fakture(MouseEvent event) {
        btnFakture.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    private void mouse_ent_fakture(MouseEvent event) {
        btnFakture.setStyle("-fx-background-color: #dbdbdb;");
    }

    @FXML
    private void mouse_ext_skladiste(MouseEvent event) {
        btnSkladiste.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    private void mouse_ent_skladiste(MouseEvent event) {
        btnSkladiste.setStyle("-fx-background-color: #dbdbdb;");
    }

    void osvjeziProizvodjaca() {
        ObservableList<Proizvodjac> proizvodjac = ProizvodjacDAO.getProizvodjac();
        listaProizvodjac.setAll(proizvodjac);
        ObservableList<ProizvodjacCombo> proizvodjaciFaktura = ProizvodjacComboDAO.getProizvodjacCombo();
        proizvodjacComboBoxFaktura.setItems(proizvodjaciFaktura);
        proizvodjacComboBoxFaktura.getSelectionModel().select(0);
        ObservableList<ProizvodjacCombo> proizvodjaciLijekova = ProizvodjacComboDAO.getProizvodjacCombo();
        proizvodjacComboBoxLijeka.setItems(proizvodjaciLijekova);
        proizvodjacComboBoxLijeka.getSelectionModel().select(0);
        ObservableList<ProizvodjacCombo> proizvodjaciKozmetike = ProizvodjacComboDAO.getProizvodjacCombo();
        proizvodjacComboBoxKozmetike.setItems(proizvodjaciKozmetike);
        proizvodjacComboBoxKozmetike.getSelectionModel().select(0);
        ObservableList<ProizvodjacCombo> proizvodjaciAparata = ProizvodjacComboDAO.getProizvodjacCombo();
        proizvodjacComboBoxAparata.setItems(proizvodjaciAparata);
        proizvodjacComboBoxAparata.getSelectionModel().select(0);

        nazivProizvodjaca.setText("");
        adresaProizvodjaca.setText("");
        mjestoProizvodjacaComboBox.getSelectionModel().select(0);
        telefonProizvodjaca.setText("");
        proizvodjacComboBoxFaktura.setItems(proizvodjaciFaktura);
        proizvodjacComboBoxFaktura.getSelectionModel().select(0);
        tabelaProizvodjac.setItems(listaProizvodjac);
    }

    void osvjeziKozmetika() {

        ObservableList<Kozmetika> kozmetika = KozmetikaDAO.getKozmetika();
        listaKozmetika.setAll(kozmetika);
        tabelaKozmetika.setItems(listaKozmetika);
        ObservableList<Artikal> artikli = ArtikalDAO.getArtikal();
        barkodStavkaFaktura.setItems(artikli);
        barkodStavkaFaktura.getSelectionModel().select(0);
        sifraArtiklaComboBox.setItems(artikli);
        sifraArtiklaComboBox.getSelectionModel().select(0);
        listaArtikala.setAll(artikli);
        ObservableList<Artikal> skladiste = ArtikalDAO.getSkladiste();
        listaSkladiste.setAll(skladiste);
        listaKozmetika.setAll(kozmetika);

        sifraKozmetike.setText("");
        nazivKozmetike.setText("");
        proizvodjacComboBoxKozmetike.getSelectionModel().select(0);
        rezimIzdavanjaComboBoxKozmetike.getSelectionModel().select(0);
        nabavnaCijenaKozmetike.setText("");
        prodajnaCijenaKozmetike.setText("");
        jedinicuMjere.setText("");
    }

    void allComboBox() {

        ObservableList<TipArtikla> list = TipArtiklaDAO.getTipArtikla();
        rezimIzdavanjaComboBoxAparata.setItems(list);
        rezimIzdavanjaComboBoxAparata.getSelectionModel().select(0);

        ObservableList<TipArtikla> list6 = TipArtiklaDAO.getTipArtikla();
        rezimIzdavanjaComboBoxLijeka.setItems(list6);
        rezimIzdavanjaComboBoxLijeka.getSelectionModel().select(0);

        ObservableList<TipArtikla> list7 = TipArtiklaDAO.getTipArtikla();
        rezimIzdavanjaComboBoxKozmetike.setItems(list7);
        rezimIzdavanjaComboBoxKozmetike.getSelectionModel().select(0);

        ObservableList<TipArtikla> list8 = TipArtiklaDAO.getTipArtikla();
        tipArtiklaComboBox.setItems(list8);
        tipArtiklaComboBox.getSelectionModel().select(0);

        ObservableList<Zaposleni> zaposleni = ZaposleniDAO.getZaposleni();
        zaposleniComboBox.setItems(zaposleni);
        zaposleniComboBox.getSelectionModel().select(0);

        ObservableList<Mjesto> mjesto = MjestoDAO.getMjesto();
        mjestoProizvodjacaComboBox.setItems(mjesto);
        mjestoProizvodjacaComboBox.getSelectionModel().select(0);

        ObservableList<ProizvodjacCombo> proizvodjaciLijekova = ProizvodjacComboDAO.getProizvodjacCombo();
        proizvodjacComboBoxLijeka.setItems(proizvodjaciLijekova);
        proizvodjacComboBoxLijeka.getSelectionModel().select(0);

        ObservableList<ProizvodjacCombo> proizvodjaciKozmetike = ProizvodjacComboDAO.getProizvodjacCombo();
        proizvodjacComboBoxKozmetike.setItems(proizvodjaciKozmetike);
        proizvodjacComboBoxKozmetike.getSelectionModel().select(0);

        ObservableList<ProizvodjacCombo> proizvodjaciMedAparata = ProizvodjacComboDAO.getProizvodjacCombo();
        proizvodjacComboBoxAparata.setItems(proizvodjaciMedAparata);
        proizvodjacComboBoxAparata.getSelectionModel().select(0);

        ObservableList<ProizvodjacCombo> fakture = ProizvodjacComboDAO.getProizvodjacCombo();
        proizvodjacComboBoxFaktura.setItems(fakture);
        proizvodjacComboBoxFaktura.getSelectionModel().select(0);

        ObservableList<Zaposleni> zaposleniFakture = ZaposleniDAO.getZaposleni();
        zaposleniComboBoxFaktura.setItems(zaposleniFakture);
        zaposleniComboBoxFaktura.getSelectionModel().select(0);

        nazivListeComboBox.getItems().addAll("Izaberi", "A", "B", "A1");
        nazivListeComboBox.getSelectionModel().selectFirst();
    }

    void allList() {
        listaLijekova = LijekDAO.getLijekovi();
        listaKozmetika = KozmetikaDAO.getKozmetika();
        listaMedicinskiAparati = MedicinskiAparatDAO.getMedicinskiAparati();
        listaRecepti = ReceptDAO.getRecept();
        listaArtikala = ArtikalDAO.getArtikal();
        listaProizvodjac = ProizvodjacDAO.getProizvodjac();
        listaCijena = CijenaDAO.getCijena();
        listaFaktura = FakturaDAO.getFaktura();
        listaSkladiste = ArtikalDAO.getSkladiste();
        sifraArtiklaComboBox.setItems(listaArtikala);
        sifraArtiklaComboBox.getSelectionModel().select(0);
        barkodStavkaFaktura.setItems(listaArtikala);
        barkodStavkaFaktura.getSelectionModel().select(0);
    }

    void allTable() {
        tabelaLijekovi();
        tabelaKozmetika();
        tabelaMedicinskiAparati();
        tabelaProizvodjaci();
        tabelaRecepti();
        tabelaKasa();
        tabelaStavkaFaktura();
        tabelaFaktura();
        tabelaArtikli();
    }

    void osvjeziMedicinskiAparat() {

        ObservableList<MedicinskiAparat> medicinskiaparati = MedicinskiAparatDAO.getMedicinskiAparati();
        listaMedicinskiAparati.setAll(medicinskiaparati);
        tabelaMedicinskiAparati.setItems(listaMedicinskiAparati);
        ObservableList<Artikal> list = ArtikalDAO.getArtikal();
        barkodStavkaFaktura.setItems(list);
        barkodStavkaFaktura.getSelectionModel().select(0);
        sifraArtiklaComboBox.setItems(list);
        sifraArtiklaComboBox.getSelectionModel().select(0);
        listaArtikala.setAll(list);
        ObservableList<Artikal> skladiste = ArtikalDAO.getSkladiste();
        listaSkladiste.setAll(skladiste);

        sifraAparata.setText("");
        nazivAparata.setText("");
        rezimIzdavanjaComboBoxAparata.getSelectionModel().select(0);
        proizvodjacComboBoxAparata.getSelectionModel().select(0);
        nabavnaCijenaAparata.setText("");
        prodajnaCijenaAparata.setText("");
    }

    void osvjeziLijek() {

        ObservableList<Lijek> lijek = LijekDAO.getLijekovi();
        listaLijekova.setAll(lijek);
        tabelaLijekovi.setItems(listaLijekova);
        ObservableList<Artikal> artikli = ArtikalDAO.getArtikal();
        barkodStavkaFaktura.setItems(artikli);
        barkodStavkaFaktura.getSelectionModel().select(0);
        sifraArtiklaComboBox.setItems(artikli);
        sifraArtiklaComboBox.getSelectionModel().select(0);
        listaArtikala.setAll(artikli);
        ObservableList<Artikal> skladiste = ArtikalDAO.getSkladiste();
        listaSkladiste.setAll(skladiste);

        sifraLijeka.setText("");
        nazivLijeka.setText("");
        proizvodjacComboBoxLijeka.getSelectionModel().select(0);
        nabavnaCijenaLijeka.setText("");
        prodajnaCijenaLijeka.setText("");
        nazivListeComboBox.getSelectionModel().select(0);
        rezimIzdavanjaComboBoxLijeka.getSelectionModel().select(0);
        generickiNaziv.setText("");
        dozaLijeka.setText("");
        oblikLijeka.setText("");
    }

}
