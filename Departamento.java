import java.util.ArrayList;
class Departamento {
    private String nombre;
    private ArrayList<Municipio> municipios;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.municipios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Municipio> getMunicipios() {
        return municipios;
    }

    public void agregarMunicipio(Municipio municipio) {
        municipios.add(municipio);
    }
}