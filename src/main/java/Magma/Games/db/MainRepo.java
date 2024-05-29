package Magma.Games.db;
import Magma.Games.models.Game;
import Magma.Games.models.Purchase;
import Magma.Games.models.Rating;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainRepo {

    public static List<Game> games = new ArrayList<>();
    public static List<Purchase> purchases = new ArrayList<>();
    public static List<Rating> ratings = new ArrayList<>();

    static {
        Game game1 = new Game(1L, "Adventure Quest", "Action", 59.99, true,null,"Blizzard","2024/04/01");
        Game game2 = new Game(2L, "Battle Royale", "Action", 59.99,true, new HashSet<>(),"Ubisoft","2002/05/05");
        Game game3 = new Game(3L, "Adventure Quest", "Action", 59.99, true,null,"Blizzard","2001/04/01");
        games.add(game1);
        games.add(game2);
        games.add(game3);
    }

    public static List<Game> getGames() {
        return games;
    }

    public static List<Purchase> getPurchases() {
        return purchases;
    }

    public static List<Rating> getRatings() {
        return ratings;
    }

}
