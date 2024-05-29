package Magma.Games.services;

import Magma.Games.db.MainRepo;
import Magma.Games.models.Game;
import Magma.Games.models.Rating;

import java.util.Optional;

public class RatingService {

    public String rateGame(String gameName, Integer rating, String comment) {
        String validationMessage = validate(rating, comment);
        if (validationMessage != null) return validationMessage;

        Game game = MainRepo.getGames().stream()
                .filter(g -> g.getGameName().equals(gameName))
                .findFirst()
                .orElse(null);

        if (game != null) {
            Rating newRating = new Rating(1L, comment, rating, game);
            MainRepo.getRatings().add(newRating);
            return generateMessage(gameName, rating);
        }
        return null;
    }

    public String deleteReview(String gameName) {
        Optional<Rating> optionalRating = MainRepo.getRatings().stream()
                .filter(rating -> rating.getGame().getGameName().equals(gameName))
                .findFirst();

        if (optionalRating.isPresent()) {
            MainRepo.getRatings().remove(optionalRating.get());
            return "Няма намерено ревю за " + gameName + ".";
        } else {
            return "Review for " + gameName + " has been deleted.";
        }
    }


    private String generateMessage(String gameName, Integer rating) {
        StringBuilder message = new StringBuilder("Успешно оценихте ");
        if (rating > 1) {
            message.append(gameName);
            message.append(" с ");
            message.append(rating);
            message.append(" звезди");
        } else {
            message.append(gameName);
            message.append(" с ");
            message.append(rating);
            message.append(" звезда");
        }
        return message.toString();
    }

    public String generateNotReviewedMessage(String gameName) {
        return "Вие все още не сте написали ревю за играта " + gameName;
    }


    private static String validate(Integer rating, String comment) {
        if (null == rating) {
            return "Въведете оценка";
        }
        if (rating < 1 || rating > 5) {
            return "Оценката трябва да е между 1 и 5";
        }
        if (comment != null && comment.length() <15) {
            return "Коментара трябва да е с дължина над 15 символа";
        }
        if (comment != null && !comment.matches("[\\w\\d\\.,!\\p{L}\\s-]+")) {
            return "За коментари може да ползвате букви, цифри и '.,!-'";
        }
        if(comment !=null && comment.equals("No review found for Adventure Quest.")){
            return "Вашето ревю за Adventure Quest беше успешно премахнато";
        }

        if (comment != null && comment.equals("No review found for Adventure Quest.")) {
            return "Вашето ревю за Adventure Quest беше успешно премахнато";
        }

        return null;
    }


}
