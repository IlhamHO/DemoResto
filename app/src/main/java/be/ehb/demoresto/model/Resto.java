package be.ehb.demoresto.model;

public class Resto {
    private String naam, adres;

    public Resto() {
    }

    public Resto(String naam, String adres) {
        this.naam = naam;
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Resto{" +
                "naam='" + naam + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
