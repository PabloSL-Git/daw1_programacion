package ejercicio1;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDateTime;

public class Matricula {

    @CsvBindByName(column = "Nombre")
    private String nombre;

    // A. La fecha y hora de presentacion se guarda como LocalDateTime
    @CsvDate("dd/MM/yyyy HH:mm:ss")
    @CsvBindByName(column = "Fecha de Registro")
    private LocalDateTime fechaRegistro;

    @CsvBindByName(column = "TICO")
    private int tico;

    @CsvBindByName(column = "CDPC")
    private int cdpc;

    @CsvBindByName(column = "AYSO")
    private int ayso;

    @CsvBindByName(column = "ANAP")
    private int anap;

    @CsvBindByName(column = "PCYAA")
    private int pcyaa;

    @CsvBindByName(column = "FR2")
    private int fr2;

    public Matricula() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getTico() {
        return tico;
    }

    public void setTico(int tico) {
        this.tico = tico;
    }

    public int getCdpc() {
        return cdpc;
    }

    public void setCdpc(int cdpc) {
        this.cdpc = cdpc;
    }

    public int getAyso() {
        return ayso;
    }

    public void setAyso(int ayso) {
        this.ayso = ayso;
    }

    public int getAnap() {
        return anap;
    }

    public void setAnap(int anap) {
        this.anap = anap;
    }

    public int getPcyaa() {
        return pcyaa;
    }

    public void setPcyaa(int pcyaa) {
        this.pcyaa = pcyaa;
    }

    public int getFr2() {
        return fr2;
    }

    public void setFr2(int fr2) {
        this.fr2 = fr2;
    }

    @Override
    public String toString() {
        return "Matricula{nombre=" + nombre + ", fechaRegistro=" + fechaRegistro
                + ", TICO=" + tico + ", CDPC=" + cdpc + ", AYSO=" + ayso
                + ", ANAP=" + anap + ", PCYAA=" + pcyaa + ", FR2=" + fr2 + "}";
    }
}
