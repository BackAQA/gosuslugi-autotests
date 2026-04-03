package TelegramBotQAAutomationJava;

/// Что это за класс: Обычный Java класс (POJO). Не из библиотеки. Просто хранит данные.
public class TelegramBotConfig {

    private final String botName;
    private final String botUsername;
    private final String botToken;

    // Конструктор
    public TelegramBotConfig(String botName, String botUsername, String botToken) {
        this.botName = botName;
        this.botUsername = botUsername;
        this.botToken = botToken;
    }

    // Геттеры (только получать данные, ничего не делать)
    public String getBotName() { return botName; }
    public String getBotUsername() { return botUsername; }
    public String getBotToken() { return botToken; }


}
