

public class Main
{
   public static void main(String[] args) {
    // Crear un departamento
    Departamento departamento1 = new Departamento("CORDOBA");
    Departamento departamento2 = new Departamento("VAUPES");
    // Crear varios municipios
    Municipio municipio1 = new Municipio("SAN JOSE DE URE", departamento1);
    Municipio municipio2 = new Municipio("TUCHIN", departamento1);
    Municipio municipio3 = new Municipio("MITU", departamento2);
    // Crear victimas 
    Victima victima1 = new Victima("andres", municipio1);
    Victima victima2 = new Victima("juan", municipio1);
    Victima victima3 = new Victima("tomas", municipio3);

    // Crear un sismo con las víctimas en los municipios afectados
    Sismo sismo1 = new Sismo(municipio1, 5.0, 10.0, new Fecha(1, 1, 2022), "12:00", "1 hora");
    Sismo sismo2 = new Sismo(municipio3, 6.0, 70.0, new Fecha(1, 1, 2022), "12:00", "1 hora");
    
    //agregar cada victima a su respectivo sismo
    sismo1.agregarVictima(victima1);
    sismo1.agregarVictima(victima2);
    
    //agregar cada municipio a su respectivo sismo 
    sismo1.agregarMunicipio(municipio1);
    sismo1.agregarMunicipio(municipio3);

    // Mostrar los municipios afectados por departamento
    sismo1.mostrarMunicipiosAfectadosPorDepartamento();
    
    //mostrarinfosismos
    sismo1.mostrarInfo();
    sismo1.calcularMagnitud();
    sismo1.registrarTipoSismo();
    
    sismo2.mostrarInfo();
    sismo2.calcularMagnitud();
    sismo2.registrarTipoSismo();
    
    

   

}
}
