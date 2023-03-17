package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int capienza;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int capienza) {
        this.titolo = titolo;
        this.data = data;
        this.capienza = capienza;
        this.postiPrenotati = postiPrenotati;
    }

    //GETTER E SETTER

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws Exception {
        // Inserire il controllo che la data non sia già passata
        LocalDate now = LocalDate.now();
        if (data.isBefore(now)) {
            throw new Exception("La data inserita è errata!");
        }
        this.data = data;
    }

    public int getCapienza() {
        return capienza;
    }



    public int getPostiPrenotati() {
        return postiPrenotati;
    }

   //METODI
   public void prenota() throws Exception {
       if( (data.isBefore(LocalDate.now()) ) || (postiPrenotati== capienza) ) {
           throw new Exception("Non è più possibile prenotare per questo evento!");
       }
       capienza--;
       postiPrenotati++;
   }

    public void disdici() throws Exception {
        if( (data.isBefore(LocalDate.now()) ) || (postiPrenotati == 0) ) {
            throw new Exception("Non è più possibile disdire per questo evento!");
        }
        capienza++;
        postiPrenotati--;
    }

    DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALIAN);

    @Override
    public String toString() {
        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", data=" + data +
                ", capienza=" + capienza +
                ", postiPrenotati=" + postiPrenotati +
                ", formattedDate=" + formattedDate +
                '}';
    }
}
