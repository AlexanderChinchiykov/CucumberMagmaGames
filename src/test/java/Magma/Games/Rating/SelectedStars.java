package Magma.Games.Rating;

import io.cucumber.java.en.When;

public class SelectedStars {

    private final Stars stars;
    private String gameName;
    public SelectedStars(Stars stars){
        this.stars=stars;
    }


    @When("избира {int} звезда")
    public void selectStar(Integer rating) {
        stars.setRating(rating);
    }

    @When("има ревюта с оценки от {int} звезди за играта {string}")
    public void SelectedStars1(Integer rating, String gameName) {
        stars.setRating(rating);
        this.gameName=gameName;
    }
}
