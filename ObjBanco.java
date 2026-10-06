public class ObjBanco {

    private String Id;
    private String Nombre;
    private String TipoTramite;
    private int Edad;
    private String CondicionAtencion;
    private int Turno;

    
    public ObjBanco(String id, String nombre, String tipoTramite, int edad, String condicionAtencion, int turno) {
        Id = id;
        Nombre = nombre;
        TipoTramite = tipoTramite;
        Edad = edad;
        CondicionAtencion = condicionAtencion;
        Turno = turno;
    }


    public ObjBanco() {
    }


    public String getId() {
        return Id;
    }


    public void setId(String id) {
        Id = id;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public String getTipoTramite() {
        return TipoTramite;
    }


    public void setTipoTramite(String tipoTramite) {
        TipoTramite = tipoTramite;
    }


    public int getEdad() {
        return Edad;
    }


    public void setEdad(int edad) {
        Edad = edad;
    }


    public String getCondicionAtencion() {
        return CondicionAtencion;
    }


    public void setCondicionAtencion(String condicionAtencion) {
        CondicionAtencion = condicionAtencion;
    }


    public int getTurno() {
        return Turno;
    }


    public void setTurno(int turno) {
        Turno = turno;
    }

   


}
