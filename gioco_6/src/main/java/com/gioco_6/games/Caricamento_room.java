/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gioco_6.games;

import com.gioco_6.type.Room;
import java.util.ArrayList;
import java.util.List;

public class Caricamento_room {
    
    private List<Room> l;
    
    private Room stanza_inizio;
    
    public void caricamento_room(){
    
        List<Room> list = new ArrayList<>();
        
        Room corridoio = new Room(0, "Corridoio", "Il corridoio è libera, la via è vicina");
        corridoio.setLook("trovi un corridoio a destra e a sinistra");
        Room corridoio_sinistra = new Room(1, "Corridoio sinistra", "è libero. trova l'uscita");
        corridoio_sinistra.setLook("trovi un corridoio a nord e a sud");
        Room corridoio_destra = new Room(2, "Corridoio destra", "sei vicino all'uscita");
        corridoio_destra.setLook("trovi un corridoio a nord e a sud");
        
        Room corridoio_sinistra_nord = new Room(3, "Corridoio sinistra nord", "riesci a respirare");
        corridoio_sinistra_nord.setLook("ci sono stanze a ovest, nord e est");
        Room corridoio_sinistra_sud = new Room(4, "Corridoio sinistra sud", "via libera, trova l'uscita");
        corridoio_sinistra_sud.setLook("ci sono stanze a ovest, sud e est");
        
        Room stanza11 = new Room(7, "Stanza 11", "è vuota");
        Room stanza12 = new Room(8, "Stanza 12", "è vuota");
        Room stanza13 = new Room(9, "Stanza 13", "è vuota");
        Room stanza41 = new Room(15, "Stanza 41", "è vuota");
        Room stanza42 = new Room(16, "Stanza 42", "è vuota. Trova l'uscita.");
        Room stanza43 = new Room(17, "Stanza 43", "è vuota");
        
        Room uscita = new Room(18, "Uscita", "Sei uscito. Ma è tutto un sogno, stavi facendo l'esame di MAP e stavi dormendo.");
        
        corridoio.setWest("Corridoio sinistra");
        corridoio.setEast("Corridoio destra");
        
        corridoio_sinistra.setEast("Corridoio");
        corridoio_sinistra.setNorth("Corridoio sinistra nord");
        corridoio_sinistra.setSouth("Corridoio sinistra sud");
        
        corridoio_destra.setWest("Corridoio");       
        corridoio_destra.setEast("Uscita");
        
        corridoio_sinistra_sud.setWest("Stanza 11");
        corridoio_sinistra_sud.setSouth("Stanza 12");
        corridoio_sinistra_sud.setEast("Stanza 13");
        corridoio_sinistra_sud.setNorth("Corridoio sinistra");
        
        corridoio_sinistra_nord.setWest("Stanza 41");
        corridoio_sinistra_nord.setNorth("Stanza 42");
        corridoio_sinistra_nord.setEast("Stanza 43");
        corridoio_sinistra_nord.setSouth("Corridoio sinistra");
        
        stanza11.setEast("Corridoio sinistra sud");
        stanza12.setNorth("Corridoio sinistra sud");
        stanza13.setWest("Corridoio sinistra sud");
        stanza41.setEast("Corridoio sinistra nord");
        stanza42.setSouth("Corridoio sinistra nord");
        stanza43.setWest("Corridoio sinistra nord");
                
        list.add(corridoio);
        list.add(corridoio_sinistra);
        list.add(corridoio_destra);
        list.add(corridoio_sinistra_nord);
        list.add(corridoio_sinistra_sud);
        list.add(stanza11);
        list.add(stanza12);
        list.add(stanza13);
        list.add(stanza41);
        list.add(stanza42);
        list.add(stanza43);
        list.add(uscita);
        
        setList(list);
        setStanza(stanza42);
    }
    
    public void setList(List<Room> list){
        this.l = list;
    }
    
    public List<Room> getList(){return l;}
    
    public void setStanza(Room r){
        this.stanza_inizio = r;
    }
    
    public Room geStanza(){return stanza_inizio;}
}
