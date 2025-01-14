
import java.util.ArrayList;
class Sismo {
    private Municipio epicentro;
    private double escala;
    private double profundidad;
    private Fecha fecha;
    private String hora;
    private String duracion;
    private ArrayList<Victima> victimasTotales;
    private ArrayList<Municipio> municipios;
    private ArrayList<Departamento> departamentos;

    public Sismo(Municipio epicentro, double magnitud, double profundidad, Fecha fecha, String hora,
                 String duracion) {
        this.epicentro = epicentro;
        this.escala = magnitud;
        this.profundidad = profundidad;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.victimasTotales = new ArrayList<>();
        this.municipios = new ArrayList<>();
        this.departamentos = new ArrayList <>();
        epicentro.agregarSismo(this);
    }

    // Getters y setters
    public ArrayList<Victima> getVictimasTotales() {
        return victimasTotales;
    }
    
    public void agregarVictima(Victima victima){
        victimasTotales.add(victima);
    }
    
    public ArrayList<Municipio> getMunicipios(){
        return municipios;
    }
    
    public void agregarMunicipio(Municipio municipio){
        municipios.add(municipio);
    }
    
    public Municipio getEpicentro() {
        return epicentro;
    }

    public void setEpicentro(Municipio epicentro) {
        this.epicentro = epicentro;
    }

    public double getEscala() {
        return escala;
    }

    public void setMagnitud(double magnitud) {
        this.escala = magnitud;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
 
    
    public void calcularMagnitud(){
        TipoSismo tipo;
        Daño daño = new Daño(null,null);
        if(this.escala >=1.0 && this.escala <=1.9){
            System.out.println("el sismo no tiene ni un tipo de magnitud ni un daño marcado");
        }else if( this.escala >= 2.0 && this.escala <= 2.9){
            tipo = TipoSismo.MICRO;
            daño.setDetalle("No son perceptibles");
            System.out.println("el tipo de magnitud es " +tipo + " y sus daños son " + daño.getDetalle());
       }else if(this.escala >= 3.0 && this.escala <= 3.9){
            tipo = TipoSismo.MENOR;
            daño.setDetalle("Perceptibles con poco movimiento y sin daño.");
            System.out.println("el tipo del magnitud es " +tipo + " y sus daños son " + daño.getDetalle());
        }else if(this.escala >= 4.0 && this.escala <= 4.9){
            tipo = TipoSismo.LIGERA;
            daño.setDetalle("Perceptibles con movimiento de objetos y rara vez produce daño.");
            System.out.println("El tipo del escala " +tipo + " y sus daños son " + daño.getDetalle());
        }else if(this.escala >= 5.0 && this.escala <= 5.9){
            tipo = TipoSismo.MODERADA;
            daño.setDetalle("Puede causar daños mayores en construcciones débiles o mal construidas. ");
            System.out.println("El tipo del escala " +tipo + " y sus daños son " + daño.getDetalle());
        }else if(this.escala >= 6.0 && this.escala <= 6.9){
            tipo = TipoSismo.FUERTE;
            daño.setDetalle("Pueden ser destructivos. ");
            System.out.println("El tipo del escala " +tipo + " y sus daños son " + daño.getDetalle());
        }else if(this.escala >= 7.0 && this.escala <= 7.9){
            tipo = TipoSismo.MAYOR;
            daño.setDetalle("Pueden ser destructivos en zonas extensas. ");
            System.out.println("El tipo del escala " +tipo + " y sus daños son " + daño.getDetalle());
        }else if(this.escala >= 8.0 && this.escala <= 9.9){
            tipo = TipoSismo.GRANDE;
            daño.setDetalle("Catastróficos,Puede provocar una extincion muy grande en el campo cercano.  ");
            System.out.println("El tipo del escala " +tipo + " y sus daños son " + daño.getDetalle());
        }else if(this.escala >= 10.0){
            tipo = TipoSismo.EPICA;
            daño.setDetalle("Nunca ha sido generado, no se pueden calcular los daños  ");
            System.out.println("El tipo del escala" +tipo + " y sus daños son " + daño.getDetalle());
        }else {
            tipo = TipoSismo.EPICA;
            daño.setDetalle("Nunca ha sido generado, no se pueden calcular los daños ");
            System.out.println("El tipo de la escala " +tipo + " y sus daños son " + daño.getDetalle());            
        }
    }
    
    public void registrarTipoSismo(){
        TipoProfundidad tipoP;
        if(this.profundidad < 0){
            System.out.println("Error de dato:");
        }else if(this.profundidad >= 0.1 && this.profundidad <= 69.9){
            tipoP = TipoProfundidad.SUPERFICIAL;
            System.out.println("El tipo de sismo:" + tipoP);
        }else if(this.profundidad >=70.0 && this.profundidad <= 300.0){
            tipoP= TipoProfundidad.INTERMEDIO;
            System.out.println("El tipo de sismo: " + tipoP);
        }else if (this.profundidad > 300.0){
            tipoP= TipoProfundidad.PROFUNDO;
            System.out.println("El tipo de sismo: " + tipoP);
        }
    }
    
     public void mostrarMunicipiosAfectadosPorDepartamento() {
         
        for (Victima victima : victimasTotales) {
        Municipio municipio = victima.getMunicipio();
        if (!municipios.contains(municipio)) {
            municipios.add(municipio);
        }
    }

    // Iterar sobre los municipios afectados para mostrarlos
    for (Municipio municipio : municipios) {
        System.out.println("Municipio: " + municipio.getNombre() + " (" + municipio.getDepartamento().getNombre() + ")");
        System.out.println("Víctimas afectadas:");
        ArrayList<Victima> victimasUnicas = new ArrayList<>();
        for (Victima victima : municipio.getVictimasM()) {
             if (!victimasUnicas.contains(victima)) {
                    victimasUnicas.add(victima);
                }
        } 
        for (Victima victima : victimasUnicas) {
                System.out.println("  - " + victima.getDetalle());
        }
        
    }

}
    public void mostrarInfo(){
       
        System.out.println("el epicentro del sismo fue: " + epicentro.getNombre() +
                         "\nla magnitud del sismo fue: " + this.escala + 
                         "\nla profundidad del sismo fue: " + this.profundidad +
                         "\nla fecha del sismo fue: " + this.fecha +
                         "\nla hora del sismo fue: " + this.hora +
                         "\nla duracion del sismo fue: "+ this.duracion);
                                
    }
    
    
}

    
    
