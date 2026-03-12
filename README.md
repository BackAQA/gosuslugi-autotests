# Автотесты для портала Госуслуги 🏛️

[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.34-green)](https://www.selenium.dev/)
[![JUnit](https://img.shields.io/badge/JUnit-5.13-blue)](https://junit.org/)
[![Allure](https://img.shields.io/badge/Allure-2.29-red)](https://qameta.io/)
[![Maven](https://img.shields.io/badge/Maven-3.9-yellow)](https://maven.apache.org/)

## 📋 О проекте

Автоматизированные тесты для проверки авторизации на портале **Госуслуги**.  
Проект демонстрирует использование современных инструментов и подходов в автоматизации тестирования.

## 🛠 Стек технологий

| Технология | Назначение |
|------------|------------|
| **Java 17** | Язык программирования |
| **Selenium WebDriver** | Управление браузером |
| **JUnit 5** | Тестовый фреймворк |
| **Maven** | Сборка проекта |
| **Allure** | Формирование отчётов |
| **Page Object Model** | Паттерн проектирования |
| **Git/GitHub** | Контроль версий |

## ✅ Что проверяют тесты

### Позитивные сценарии
- [x] Открытие главной страницы
- [x] Получение списка категорий
- [x] Работа с модальным окном помощи
- [x] Проверка ссылок в модальном окне

### Негативные сценарии
- [x] Неверный логин + верный пароль (8+ вариантов)
- [x] Верный логин + неверный пароль (20+ вариантов)
- [x] Различные комбинации логин/пароль
- [x] **Появление капчи после 3х неудачных попыток** 🔐

## 🚀 Как запустить

### 1. Клонировать репозиторий
```bash
# Клонировать репозиторий
git clone https://github.com/admirhanafi07-star/gosuslugi-autotests.git

# Перейти в папку проекта
cd gosuslugi-autotests

# Запустить тесты
mvn clean test

# Посмотреть Allure отчёт
mvn allure:serve
