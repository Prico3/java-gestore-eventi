package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        //Milestone 1 e 2
        Scanner s = new Scanner(System.in);

        // Si chiede all’utente di inserire un nuovo evento con tutti i parametri.
        System.out.println("Inserisci il tuo Evento!\nInserisci il nome dell'evento: ");
        String titolo = s.nextLine();

        System.out.println("Inserisci la data dell'evento(dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(s.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        System.out.println("Inserisci il numero totale dei posti disponibili per l'evento: ");
        int numeroPostiTotale = Integer.parseInt(s.nextLine());

        Evento evento = null;
        try {
            evento = new Evento(titolo, data, numeroPostiTotale);
            System.out.println(evento.toString());
        } catch (Exception e) {
            System.out.println("Non è possibile inserire l'evento! " + e.getMessage());
            return;
        }
		
		
		/*
		 * 	Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni
			vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo
			eventuali eccezioni.
		 */

        System.out.println("Vuoi fare delle prenotazioni all'evento?\n* si\n* no");
        String sceltaUtente = s.nextLine();

        if (sceltaUtente.equals("si")) {
            System.out.println("Quanti posti vuoi prenotare?");
            int numeroPrenotazione = Integer.parseInt(s.nextLine());
            if (numeroPrenotazione > numeroPostiTotale) {
                System.out.println("Numero non valido per la prenotazione dei posti");
                return;
            }

            for (int i = 0; i < numeroPrenotazione; i++) {
                try {
                    evento.prenota();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            System.out.println("Numero posti prenotati: " + numeroPrenotazione +
                    "\nPosti ancora disponibili: " + (evento.getCapienza()));

        } else {
            System.out.println("Nessuna prenotazione richiesta! Arrivederci!");
        }
		
		/*
			4. Chiedere all’utente se e quanti posti vuole disdire
			5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo
			eventuali eccezioni
		 */
        if (sceltaUtente.equals("si")) {
            System.out.println("Vuoi disdire delle prenotazioni effettuate?\n* si\n* no");
            String sceltaDisdettaUtente = s.nextLine();

            if (sceltaDisdettaUtente.equals("si")) {
                System.out.println("Quanti posti vuoi disdire?");
                int numeroDisdette = Integer.parseInt(s.nextLine());
                if (numeroDisdette == 0) {
                    System.out.println("Numero non valido per la disdetta dei posti");
                    return;
                }

                for (int i = 0; i < numeroDisdette; i++) {
                    try {
                        evento.disdici();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                System.out.println("Numero posti disdetti: " + numeroDisdette +
                        "\nPosti disponibili: " + (evento.getCapienza()));

            } else {
                System.out.println("Nessuna disdetta richiesta! Arrivederci!");
            }
        }

        //MILESTONE 3
        Concerto concerto1 = null;
        try {
            concerto1 = new Concerto("Campovolo", LocalDate.parse("2023-10-12"), 20, LocalTime.parse("09:00"), BigDecimal.valueOf(10.5780));
            System.out.println(concerto1.toString());
        } catch (Exception e) {
            System.out.println("Non è possibile inserire l'evento! " + e.getMessage());
            return;
        }
    }
}