package TelegramBotQAAutomationJava;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        // 1. Создаём конфиг с данными бота
        TelegramBotConfig config = new TelegramBotConfig(
                "JavaQAVacancyBot",
                "JavaQAVacancyBot",
                "8471690445:AAEZT96mnnXCTWcsnzdtP7ra5huw-6YdZTU"
        );

        // 2. Создаём бота, передаём ему конфиг
        VacancyBot bot = new VacancyBot(config);

        // 3. Регистрируем бота в Telegram API
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
            System.out.println("✅ Бот запущен!");
        } catch (TelegramApiException e) {
            System.err.println("❌ Ошибка запуска: " + e.getMessage());
        }
    }
}

/*
1. Main.main() запускается
2. Создаётся TelegramBotConfig с токеном
3. Создаётся VacancyBot, который вызывает super(токен)
4. TelegramBotsApi регистрирует бота
5. Библиотека начинает слушать сообщения
6. Приходит сообщение → TelegramLongPollingBot вызывает onUpdateReceived()
7. Твой код в onUpdateReceived() обрабатывает сообщение
8. Ты вызываешь execute(message) → библиотека отправляет ответ
*/



/*
* // 1. Класс-конфиг (просто данные)
class Config {
    String token = "123:abc";
    String name = "MyBot";
}

// 2. Класс-бот (логика)
class MyBot extends TelegramLongPollingBot {
    private Config config;

    public MyBot(Config config) {
        super(config.token);  // ← передаём токен в библиотеку
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.name;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // твоя логика
    }
}

// 3. Запуск
class Main {
    public static void main(String[] args) {
        Config config = new Config();
        MyBot bot = new MyBot(config);
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(bot);
    }
}
* */