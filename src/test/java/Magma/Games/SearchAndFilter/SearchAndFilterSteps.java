package Magma.Games.SearchAndFilter;

import Magma.Games.models.Game;
import Magma.Games.services.SearchAndFilterService;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.stream.Collectors;


public class SearchAndFilterSteps {

    private String gameName;
    private String genre;
    private boolean searchButtonClicked = false;
    private boolean filterButtonClicked = false;
    private final SearchAndFilterHelper helperModel;
    private final SearchAndFilterService filterServices=new SearchAndFilterService();

    public SearchAndFilterSteps(SearchAndFilterHelper helperModel) {this.helperModel = helperModel;}



    @When("потребителя въвежда име на игра {string} в полето за търсене")
    public void SearchGame(String gameName) {
        this.gameName = gameName;

    }

    @When("натиска бутона за търсене")
    public void ClicksSearchButton() {
        searchButtonClicked = true;
//        List<Game> searchResult = filterServices.searchGamesByName(gameName);
//        List<String> gameNames = searchResult.stream()
//                .map(Game::getGameName)
//                .collect(Collectors.toList());
//        helperModel.setSearchResult(gameNames);
    }

    @Then("Визуализира се игра с име {string}")
    public void VisualizeGame(String gameName) {
        this.gameName = gameName;
//        Game selectedGame = filterServices.getGameDetails(gameName);
//        helperModel.setSelectedGame(selectedGame);
    }

    @When("потребителя избире жанр {string}")
    public void GenreSelect(String gameName) {
        this.gameName=gameName;
    }

    @When("натиска бутона за филтриране")
    public void FilterBttn() {
        filterButtonClicked=true;
    }

    @Then("Визуализира се списък с игри в жанр {string}")
    public void GenreSelection(String genre) {
        this.genre=genre;
    }

    @When("потребителя избира игра с име {string}")
    public void потребителя_избира_игра_с_име(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("натиска бутона за детайлна информация")
    public void натиска_бутона_за_детайлна_информация() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Визуализира се детайлна информация за играта {string}")
    public void визуализира_се_детайлна_информация_за_играта(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("потребителя избира разработчик {string}")
    public void потребителя_избира_разработчик(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("натиска бутона за филтриране за разработчик")
    public void натиска_бутона_за_филтриране_за_разработчик() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Визуализира се списък с игри на разработчик {string}")
    public void визуализира_се_списък_с_игри_на_разработчик(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("потребителя избере дата на издаване {string}")
    public void потребителя_избере_дата_на_издаване(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("натиска бутона за филтриране по дата на издаване")
    public void натиска_бутона_за_филтриране_по_дата_на_издаване() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Визуализира се списък с игри, издадени през {string}")
    public void визуализира_се_списък_с_игри_издадени_през(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
