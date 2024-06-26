Feature: Purchase Game


  Scenario: Купете успешно игра
    Given потребителят е на страницата с подробности за играта за "Adventure Quest"
    When потребителят кликва върху бутона „Купи“.
    And Въвежда валидни данни за плащане
    And Потвърждава поръчката
    Then Системата обработва данните
    And Изкарва потвърждение за поръчката

  Scenario: Купуване на игра с невалидни данни за плащане
    Given потребителят е на страницата с подробности за играта за "Adventure Quest"
    When потребителят кликва върху бутона „Купи“.
    And Въвежда невалидни данни за плащане
    And Потвърждава поръчката
    Then Системата отказва плащането
    And Излиза съобщение за грешка при плащането

  Scenario: Купуване на игра с недостатъчно средства
    Given потребителят е на страницата с подробности за играта за "Adventure Quest"
    When потребителят кликва върху бутона „Купи“.
    And въвежда данни за плащане с недостатъчни средства
    And Потвърждава поръчката
    Then Системата отказва плащането
    And Излиза съобщение за недостатъчно средства

  Scenario: Вижте историята на покупките
    Given потребителят е закупил игри
    When потребителят навигира до страницата с история на покупките
    Then системата показва списък със закупени игри

  Scenario: Опит за закупуване на игра, която не е налична
    Given потребителят е на страница с подробности за играта, която не е налична
    When потребителят кликва върху бутона „Купи игра“.
    Then Излиза съобщение че играта не е налична

  Scenario: Купуване на игра с валиден код за отстъпка
    Given потребителят е на страницата с подробности за играта за "Adventure Quest"
    When потребителят кликва върху бутона „Купи“.
    And Въвежда валидни данни за плащане
    And Въвежда валиден код за отстъпка "DISCOUNT10"
    And Потвърждава поръчката
    Then Системата обработва данните
    And Системата прилага отстъпката
    And Изкарва потвърждение за поръчката с прилагането на отстъпка
