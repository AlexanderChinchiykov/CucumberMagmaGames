package Magma.Games.services;
import Magma.Games.db.MainRepo;
import Magma.Games.models.Game;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryService {

    public void addGameToLibrary(String gameName) {
        Game newGame = new Game();
        newGame.setGameName(gameName);
        newGame.setId(MainRepo.getGames().size() + 1L);
        MainRepo.getGames().add(newGame);
    }

    public void removeGameFromLibrary(String gameName) {
        MainRepo.getGames().removeIf(game -> game.getGameName().equals(gameName));
    }

    public boolean isGameInLibrary(String gameName) {
        return MainRepo.getGames().stream().anyMatch(game -> game.getGameName().equals(gameName));
    }

    public List<Game> getAllGames() {
        return MainRepo.getGames();
    }

    public Game getGameByName(String gameName) {
        return MainRepo.getGames().stream()
                .filter(game -> game.getGameName().equals(gameName))
                .findFirst()
                .orElse(null);
    }
    public List<String> searchForGame(String gameName) {
        return MainRepo.getGames().stream()
                .map(Game::getGameName)
                .filter(name -> name.toLowerCase().contains(gameName.toLowerCase()))
                .collect(Collectors.toList());
    }

}
