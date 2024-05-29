package Magma.Games.services;

import Magma.Games.db.MainRepo;
import Magma.Games.models.Game;

import java.util.List;
import java.util.stream.Collectors;

public class SearchAndFilterService {

    public List<Game> searchGamesByName(String gameName) {
        return MainRepo.getGames().stream()
                .filter(game -> game.getGameName().toLowerCase().contains(gameName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Game> filterGamesByGenre(String genre) {
        return MainRepo.getGames().stream()
                .filter(game -> game.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public List<Game> filterGamesByDeveloper(String developer) {
        return MainRepo.getGames().stream()
                .filter(game -> game.getDeveloper().equalsIgnoreCase(developer))
                .collect(Collectors.toList());
    }

    public List<Game> filterGamesByReleaseDate(String releaseDate) {
        return MainRepo.getGames().stream()
                .filter(game -> game.getReleaseDate().equalsIgnoreCase(releaseDate))
                .collect(Collectors.toList());
    }

    public Game getGameDetails(String gameName) {
        return MainRepo.getGames().stream()
                .filter(game -> game.getGameName().equalsIgnoreCase(gameName))
                .findFirst()
                .orElse(null);
    }
}
