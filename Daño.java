
class Daño {
    private String detalle;
    private Municipio municipio;

    public Daño(String detalle,Municipio municipio) {
        this.detalle = detalle;
        this.municipio = municipio;
    }

    // Getters
    public String getDetalle() {
        return detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    public Municipio getMunicipio(){
        return municipio;
    }

    
    
    
}
