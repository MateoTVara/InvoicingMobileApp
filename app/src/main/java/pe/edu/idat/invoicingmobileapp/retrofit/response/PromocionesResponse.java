package pe.edu.idat.invoicingmobileapp.retrofit.response;

public class PromocionesResponse {

    private int idpromo;
    private String despromo;
    private String fchaini;
    private String fchafin;
    private String imagen;

    public int getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(int idpromo) {
        this.idpromo = idpromo;
    }

    public String getDespromo() {
        return despromo;
    }

    public void setDespromo(String despromo) {
        this.despromo = despromo;
    }

    public String getFchaini() {
        return fchaini;
    }

    public void setFchaini(String fchaini) {
        this.fchaini = fchaini;
    }

    public String getFchafin() {
        return fchafin;
    }

    public void setFchafin(String fchafin) {
        this.fchafin = fchafin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
