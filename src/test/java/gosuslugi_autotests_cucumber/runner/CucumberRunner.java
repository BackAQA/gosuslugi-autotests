package gosuslugi_autotests_cucumber.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite //Говорит JUnit, что это не простой тест, а набор тестов (test suite)
@IncludeEngines("cucumber") //Указывает, какой движок использовать для запуска тестов. Другие варианты: Можно было бы написать @IncludeEngines("junit-jupiter") для обычных тестов.
@SelectClasspathResource("features") // Указывает, где искать feature файлы (файлы со сценариями).
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm") // Настраивает плагины для Cucumber. pretty — делает вывод в консоль красивым (цветным и структурированным). io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm — плагин для Allure отчетов
public class CucumberRunner {

}


/*
1. Вы запускаете CucumberRunner.java
2. JUnit видит @Suite и @IncludeEngines("cucumber")
3. Cucumber ищет feature файлы в папке features (@SelectClasspathResource)
4. Cucumber читает каждый сценарий
5. Cucumber ищет реализации шагов в пакете stepdefs (cucumber.glue)
6. Выполняются шаги
7. Плагины формируют отчет:
pretty — красивый вывод в консоль
Allure — сохраняет данные в target/allure-results
*/