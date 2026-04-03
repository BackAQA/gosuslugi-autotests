package TelegramBotQAAutomationJava;

import java.util.ArrayList;
import java.util.List;

public class VacancyFinder {

    private static final String API_URL = "https://api.hh.ru/vacancies";
    private static final String TEXT = "Java developer";  // Поисковый запрос
    private static final String AREA = "1";               // 1 = Москва

    public List<String> findVacancies() {
        // 1. Формируем URL для запроса
        // 2. Отправляем HTTP запрос к API hh.ru
        // 3. Парсим JSON ответ
        // 4. Извлекаем нужные данные (название, ссылка, зарплата)
        // 5. Возвращаем список вакансий
        return new ArrayList<>();
    }
}
