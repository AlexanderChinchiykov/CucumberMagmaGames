package Magma.Games.SearchAndFilter;

import Magma.Games.models.Game;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchAndFilterHelper {
    private Game selectedGame;
    private List<String> searchResult;
    private List<Game> gameList;

}
