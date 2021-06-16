package com.gioco_4.games;

import com.gioco_4.GameDescription;
import com.gioco_4.parser.ParserOutput;
import com.gioco_4.type.Command;
import com.gioco_4.type.CommandType;
import com.gioco_4.type.Room;
import java.io.PrintStream;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FireHouseGame extends GameDescription {

    public Room r;

    @Override
    public void init() throws Exception {
        //Commands
        Command nord = new Command(CommandType.NORD, "nord");
        nord.setAlias(new String[]{"n", "N", "Nord", "NORD"});
        getCommands().add(nord);
        Command iventory = new Command(CommandType.INVENTORY, "inventario");
        iventory.setAlias(new String[]{"inv", "i", "I"});
        getCommands().add(iventory);
        Command sud = new Command(CommandType.SOUTH, "sud");
        sud.setAlias(new String[]{"s", "S", "Sud", "SUD"});
        getCommands().add(sud);
        Command est = new Command(CommandType.EAST, "est");
        est.setAlias(new String[]{"e", "E", "Est", "EST"});
        getCommands().add(est);
        Command ovest = new Command(CommandType.WEST, "ovest");
        ovest.setAlias(new String[]{"o", "O", "Ovest", "OVEST"});
        getCommands().add(ovest);
        Command end = new Command(CommandType.END, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit", "università"});
        getCommands().add(end);
        Command look = new Command(CommandType.LOOK_AT, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        getCommands().add(look);
        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
        pickup.setAlias(new String[]{"prendi"});
        getCommands().add(pickup);
        Command open = new Command(CommandType.OPEN, "apri");
        open.setAlias(new String[]{});
        getCommands().add(open);
        Command dove = new Command(CommandType.WHERE, "dove");
        dove.setAlias(new String[]{"Dove", "DOVE", "dove sono"});
        getCommands().add(dove);
        Command push = new Command(CommandType.PUSH, "premi");
        push.setAlias(new String[]{"spingi", "attiva"});
        getCommands().add(push);

        Caricamento_room c = new Caricamento_room();
        c.caricamento_room();
        setCurrentRoom(c.geStanza());
        setRooms(c.getList());
    }

    @Override
    public void nextMove(ParserOutput p, PrintStream out) {
        if (p.getCommand() == null) {
            out.println("Non ho capito cosa devo fare! Scrivi meglio.");
        } else {
            //move
            boolean noroom = false;
            boolean move = false;
            if (null != p.getCommand().getType()) {
                switch (p.getCommand().getType()) {
                    case NORD:
                        if (getCurrentRoom().getNorth() != null) {
                            ListIterator<Room> l = getRooms().listIterator();
                            while (l.hasNext()) {
                                Room r = l.next();
                                if (getCurrentRoom().getNorth() == r.getName()) {
                                    setCurrentRoom(r);
                                    break;
                                }
                            }
                            move = true;
                        } else {
                            noroom = true;
                        }
                        break;
                    case SOUTH:
                        if (getCurrentRoom().getSouth() != null) {
                            ListIterator<Room> l = getRooms().listIterator();
                            while (l.hasNext()) {
                                Room r = l.next();
                                if (getCurrentRoom().getSouth() == r.getName()) {
                                    setCurrentRoom(r);
                                    break;
                                }
                            }
                            move = true;
                        } else {
                            noroom = true;
                        }
                        break;
                    case EAST:
                        if (getCurrentRoom().getEast() != null) {
                            ListIterator<Room> l = getRooms().listIterator();
                            while (l.hasNext()) {
                                Room r = l.next();
                                if (getCurrentRoom().getEast() == r.getName()) {
                                    setCurrentRoom(r);
                                    break;
                                }
                            }
                            move = true;
                        } else {
                            noroom = true;
                        }
                        break;
                    case WEST:
                        if (getCurrentRoom().getWest() != null) {
                            ListIterator<Room> l = getRooms().listIterator();
                            while (l.hasNext()) {
                                Room r = l.next();
                                if (getCurrentRoom().getWest() == r.getName()) {
                                    setCurrentRoom(r);
                                    break;
                                }
                            }
                            move = true;
                        } else {
                            noroom = true;
                        }
                        break;

                    case LOOK_AT:
                        if (getCurrentRoom().getLook() != null) {
                            out.println(getCurrentRoom().getLook());
                        } else {
                            out.println("Non c'è niente di interessante qui.");
                        }
                        break;
                    case WHERE:
                        out.println(getCurrentRoom().getName());
                        break;
                    default:
                        break;
                }
            }
            if (noroom) {
                out.println("Da quella parte non si può andare c'è un muro!");
            } else if (move) {
                out.println(getCurrentRoom().getName());
                out.println(getCurrentRoom().getDescription());
            }
        }
    }
}
