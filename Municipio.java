import java.util.ArrayList;
class Municipio {
    private String nombre;
     private Departamento departamento;
    private ArrayList<Victima> victimas;
    private ArrayList <Sismo> sismos;

    public Municipio(String nombre,Departamento departamento) {
        this.nombre = nombre;
        this.victimas = new ArrayList<>();
        this.sismos = new ArrayList <>();
        this.departamento = departamento;
        departamento.agregarMunicipio(this);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Victima> getVictimasM() {
        return victimas;
    }

    public void agregarVictima(Victima victima) {
        victimas.add(victima);
    }
    
    public ArrayList <Sismo> getSismos(){
        return sismos;
    }
    
     public void agregarSismo(Sismo sismo) {
        sismos.add(sismo);
    }
    
      public Departamento getDepartamento() {
        return departamento;
    }
}