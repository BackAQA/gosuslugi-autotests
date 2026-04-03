package TelegramBotQAAutomationJava;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.List;

/// Что делает этот класс: Он слушает сообщения от Telegram и реагирует на команды.
// @Slf4j — это аннотация Lombok. Она создаёт поле log для логирования.
// Логирование — это когда программа пишет "я сделала то-то" в консоль.
@Slf4j
public class VacancyBot extends TelegramLongPollingBot {

    private final TelegramBotConfig config;
    private final VacancyFinder vacancyFinder;

    public VacancyBot(TelegramBotConfig config) {
        super(config.getBotToken());
        this.config = config;
        this.vacancyFinder = new VacancyFinder();
        log.info("Бот {} создан!", config.getBotName());
    }

    @Override
    public String getBotUsername() {
        return config.getBotUsername();
    }

    // Этот метод вызывается КАЖДЫЙ раз, когда пользователь пишет боту.
    // Update — это объект, который содержит всё сообщение (текст, кто написал, когда).
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            switch (text) {
                case "/start" -> sendMessage(chatId, "🤖 Бот готов! Команды: /find, /resume");
                case "/find" -> findAndSendVacancies(chatId);
                case "/resume" -> sendResume(chatId);
                default -> sendMessage(chatId, "❓ Неизвестно. Используй /start");
            }
        }
    }

    private void sendMessage(String chatId, String text) {
        SendMessage msg = new SendMessage();        // 1. Создаём ПУСТОЙ объект
        msg.setChatId(chatId);                      // 2. Заполняем chatId
        msg.setText(text);                          // 3. Заполняем text
        try {
            execute(msg);                           // 4. Отправляем УЖЕ заполненный msg
        } catch (TelegramApiException e) { log.error("Ошибка", e); }
    }

    private void findAndSendVacancies(String chatId) {
        sendMessage(chatId, "🔍 Ищу...");
        List<String> vacancies = vacancyFinder.findVacancies();
        sendMessage(chatId, vacancies.isEmpty() ? "😞 Ничего не найдено" : "✅ Найдено: " + vacancies.size());
    }

    private void sendResume(String chatId) {
        File file = new File("C:\\Users\\admir\\OneDrive\\Desktop\\Бетуганов Адмир.pdf");
        if (!file.exists()) {
            sendMessage(chatId, "❌ Файл resume.pdf не найден");
            return;
        }
        SendDocument doc = new SendDocument();
        doc.setChatId(chatId);
        doc.setDocument(new InputFile(file));
        try { execute(doc); } catch (TelegramApiException e) { log.error("Ошибка", e); }
    }
}
