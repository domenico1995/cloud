
package com.gioco_4;

import com.gioco_4.games.FireHouseGame;
import com.gioco_4.parser.Parser;
import com.gioco_4.parser.ParserOutput;
import com.gioco_4.type.CommandType;
import static java.lang.System.out;
import java.util.Scanner;

public class Engine {

    private final GameDescription game;

    private final Parser parser;

    public Engine(GameDescription game) {
        this.game = game;
        try {
            this.game.init();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        parser = new Parser();
    }

    public void run() {
        out.println(game.getCurrentRoom().getName());
        System.out.println(game.getCurrentRoom().getDescription());
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            ParserOutput p = parser.parse(command, game.getCommands());
            if (p.getCommand() != null && p.getCommand().getType() == CommandType.END) {
                System.out.println("Addio!");
                break;
            } else {
                game.nextMove(p, System.out);
            }
        }
    }

   
    public static void main(String[] args) {
        Engine engine = new Engine(new FireHouseGame());
        engine.run();
    }

}
