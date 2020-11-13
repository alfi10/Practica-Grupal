import java.util.List;

public class Pelicula {

    public String titulo;
    public String sinopsis;
    private String genero;
    private String enlace;
    private int agno;
    private int duracion;
    private List reparto;


    public Pelicula(String titulo, String sinopsis, String genero, String enlace,int agno, int duracion, List reparto ) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.enlace = enlace;
        this.agno = agno;
        this.duracion = duracion;
        this.reparto = reparto; //copiar???
    }

    public Pelicula(String titulo, String sinopsis, String enlace,int agno, int duracion, List reparto ) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.enlace = enlace;
        this.agno = agno;
        this.duracion = duracion;
        this.reparto = reparto; //copiar???
    }

    public String getTitulo() {
        return titulo;
    }

/* public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDemarcation() {
        return demarcation;
    }

    public void setDemarcation(List<String> demarcation) {
        this.demarcation = demarcation;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    @Override
    public String toString() {
        return "Dorsal=" + dorsal + ", Name=" + name + ", Demarcation="
                + demarcation + ", Team=" + team;
    }*/
}
