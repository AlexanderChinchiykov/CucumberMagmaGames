Feature: Оценяване на игра

  Background:
    Given потребителят отваря детайлите на играта "Adventure Quest"

  Scenario: Успешно добавяне на ревю на игра
    When избира 5 звезда
    And въвежда коментар "Невероятна игра!"
    And Натиска бутона оцени
    Then потребителят вижда съобщението "Успешно оценихте Adventure Quest с 5 звезди"

  Scenario: Успешно добавяне на ревю без коментар
    When избира 4 звезда
    And Натиска бутона оцени
    Then потребителят вижда съобщението "Успешно оценихте Adventure Quest с 4 звезди"

  Scenario: Опит за добавяне на ревю без оценка
    When въвежда коментар "Добра игра!"
    And Натиска бутона оцени
    Then потребителят вижда съобщението "Въведете оценка"

  Scenario: Добавяне на ревю с коментар по-дълъг от 50 символа
    When избира 3 звезда
    And въвежда коментар "Невероятна!"
    And Натиска бутона оцени
    Then потребителят вижда съобщението "Коментара трябва да е с дължина над 15 символа"

  Scenario: Добавяне на ревю с забранени символи в коментара
    When избира 3 звезда
    And въвежда коментар "Невероятна игра!;$>"
    And Натиска бутона оцени
    Then потребителят вижда съобщението "За коментари може да ползвате букви, цифри и '.,!-'"

  Scenario: Редактиране на съществуващо ревю на игра
    Given потребителят е вече написал ревю за играта "Adventure Quest"
    When потребителят избира да редактира ревюто си
    And променя оценката на 4 звезди
    And променя коментара на "Добра игра, но има нужда от подобрения"
    And Натиска бутона оцени
    Then потребителят вижда съобщението "Успешно оценихте Adventure Quest с 4 звезди"

  Scenario: Премахване на съществуващо ревю на игра неуспешнo
    Given потребителят не е написал ревю за играта "Adventure Quest"
    When потребителят избира да премахне ревюто си
    And потвърждава премахването
    Then потребителят вижда съобщението "Няма намерено ревю за Adventure Quest."

  Scenario: Преглеждане на ревюта на игра
    Given потребителят е вече написал ревю за играта "Adventure Quest"
    When потребителят преглежда ревютата на играта "Adventure Quest"
    Then потребителят вижда своето ревю за играта "Adventure Quest"


#  Scenario: Преглеждане на среден рейтинг за игра
#    Given има ревюта с оценки от 5 звезди за играта "Adventure Quest"
#    When потребителят преглежда средния рейтинг за играта
#    Then потребителят вижда средния рейтинг за играта "Adventure Quest" като 4 звезди

  Scenario: Потребителят получава съобщение, че все още не е написал ревю
    Given потребителят не е написал ревю за играта "Adventure Quest"
    When потребителят опита да редактира или премахне ревюто си
    Then потребителят вижда съобщението за липса на ревю "Вие все още не сте написали ревю за играта Adventure Quest"
