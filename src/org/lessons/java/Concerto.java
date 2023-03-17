package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento{
    // attributi
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int numeroPostiTotale, LocalTime ora, BigDecimal prezzo) throws Exception {
        super(titolo, data, numeroPostiTotale);

        setOra(ora);
        setPrezzo(prezzo);

    }

    //getter e setter
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    //Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€)
    public String dataOraFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        return super.getData().format(formattedDate) + " Ore: " +  ora.format(formatter);
    }

    public String prezzoFormattato() {
        DecimalFormat prezzoF = new DecimalFormat("##.##");
        return prezzoF.format(getPrezzo()) + "€";
    }

    //Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: data e ora formattata - titolo - prezzo formattato
    @Override
    public String toString() {
        return "Concerto [Data: " + dataOraFormattata() + " - Titolo evento: " + super.getTitolo()
                + " - Prezzo: " + prezzoFormattato() + "]";
    }


}