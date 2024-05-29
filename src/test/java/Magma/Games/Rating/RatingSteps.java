package Magma.Games.Rating;

import Magma.Games.db.MainRepo;
import Magma.Games.services.RatingService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class RatingSteps {



    private String gameName;
    private String message;
    private Stars stars;
    private String comment;
    private Boolean isEditing;
    private Boolean isDeleting;

    public RatingSteps(Stars stars) {this.stars = stars;}

    @Given("потребителят отваря детайлите на играта {string}")
    public void openGameDetails(String gameName) {
        this.gameName = gameName;
    }

    @When("въвежда коментар {string}")
    public void addComment(String comment) {
        this.comment = comment;
    }

    @When("Натиска бутона оцени")
    public void submitRating() {
        final RatingService rateService = new RatingService();
        message = rateService.rateGame(gameName, stars.getRating(), comment);
    }
    @Then("потребителят вижда съобщението {string}")
    public void checkMessage(String expectedMessage) {
         {
            assertEquals(expectedMessage, message);
        }
    }


    @Then("потребителят вижда съобщението за липса на ревю {string}")
    public void checkNotReviewedMessage(String expectedMessage) {
        final RatingService ratingService = new RatingService();
        message = ratingService.generateNotReviewedMessage(gameName);
        assertEquals(expectedMessage, message);
    }

    @Given("потребителят е вече написал ревю за играта {string}")
            public void userHasAlreadyWrittenReview(String gameName) {
        this.gameName = gameName;
    }

    @When("потребителят избира да редактира ревюто си")
    public void userChoosesToEditReview() {
        isEditing = true;
    }

    @And("променя оценката на {int} звезди")
    public void userChangesRating(int newRating) {
        if (isEditing) {
            stars.setRating(newRating);
        }
    }
    @And("променя коментара на {string}")
    public void userChangesComment(String newComment) {
        if (isEditing) {
            comment = newComment;

        }
    }

    @When("потребителят избира да премахне ревюто си")
    public void userChoosesToDeleteReview() {
        isDeleting = true;
    }
    @And("потвърждава премахването")
    public void userConfirmsDeletion() {
        if (isDeleting) {
            final RatingService ratingService = new RatingService();
            message = ratingService.deleteReview(gameName);
        }
    }
    @When("потребителят преглежда ревютата на играта {string}")
    public void userSeesReview(String gameName) {
        this.gameName = gameName;
    }

    @When("потребителят вижда своето ревю за играта {string}")
    public void userSeesHisReview(String gameName) {
        this.gameName = gameName;
    }

    @When("потребителят не е написал ревю за играта {string}")
    public void userHasNotGivenReview(String gameName) {
        final RatingService ratingService = new RatingService();
        if (!MainRepo.getRatings().stream().anyMatch(rating -> rating.getGame().getGameName().equals(gameName))) {
            message = ratingService.generateNotReviewedMessage(gameName);
        } else {
            message = null;
        }
    }



    @When("потребителят опита да редактира или премахне ревюто си")
    public void userAttemptsToEditOrDeleteReview() {

        if (gameName != null && !gameName.isEmpty()) {

            System.out.println("Are you sure you want to edit or delete your review for " + gameName + "?");

            isEditing = true;
            isDeleting = true;
        } else {

            System.out.println("You haven't written a review yet.");
        }
    }


}
