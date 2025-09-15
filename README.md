# 📚 Kaspersky Dictionary

<div align="center">

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

*Переводчик для Android*

</div>

## 🚀 Описание

**Kaspersky Dictionary** — это тестовое задание в компанию Kaspersky. Android-приложение для перевода слов. Приложение предоставляет удобный способ поиска значений слов с возможностью сохранения избранных переводов и просмотра истории поиска.

## 🛠 Технологический стек

### Основные технологии
- **Kotlin** - современный язык программирования для Android
- **Jetpack Compose** - декларативный UI фреймворк
- **Material Design 3** - современная система дизайна

### Архитектура и паттерны
- **MVVM** - архитектурный паттерн Model-View-ViewModel
- **Clean Architecture** - разделение на слои Domain, Data, Presentation
- **Repository Pattern** - абстракция для работы с данными
- **Use Cases** - инкапсуляция бизнес-логики

### Библиотеки и компоненты

#### Dependency Injection
- **Dagger Hilt** - современный DI фреймворк для Android

#### Навигация
- **Navigation Compose** - навигация между экранами в Compose

#### Сетевые запросы
- **Retrofit 2** - HTTP клиент для REST API
- **OkHttp** - сетевая библиотека с логированием
- **Gson** - сериализация/десериализация JSON

#### База данных
- **Room** - локальная база данных SQLite
- **Room KTX** - Kotlin расширения для Room

#### Асинхронность
- **Kotlin Coroutines** - асинхронное программирование
- **Lifecycle ViewModel** - управление состоянием UI

## 📱 Экраны приложения

1. **🏠 Главный экран (Перевод)** - поиск и перевод слов
2. **⭐ Избранное** - сохраненные переводы
3. **📚 История** - история поиска слов

## 🏗 Архитектура проекта

```
app/
├── data/                          # Слой данных
│   ├── di/                        # Dependency Injection модули
│   ├── network/                   # Сетевые запросы
│   │   ├── api/                   # API интерфейсы
│   │   └── dto/                   # Data Transfer Objects
│   ├── room/                      # Локальная база данных
│   │   ├── dao/                   # Data Access Objects
│   │   ├── entity/                # Сущности БД
│   │   └── MainDB.kt              # Конфигурация БД
│   └── repositoryImpl/            # Реализации репозиториев
├── domain/                        # Бизнес-логика
│   ├── model/                     # Модели предметной области
│   ├── repository/                # Интерфейсы репозиториев
│   └── usecase/                   # Сценарии использования
└── presentation/                  # Слой представления
    ├── component/                 # Переиспользуемые компоненты
    ├── navigation/                # Навигация
    ├── screen/                    # Экраны приложения
    ├── utils/                     # Утилиты для UI
    └── viewModel/                 # ViewModels
```

## 🚀 Установка и запуск

### Требования
- **Android Studio** Arctic Fox или новее
- **JDK 11** или выше
- **Android SDK** уровня 28 или выше
- **Gradle 8.11.2**

## 📋 Системные требования

- **Минимальная версия Android**: API 28 (Android 9.0)
- **Целевая версия Android**: API 36
- **Поддерживаемые архитектуры**: ARM64, ARMv7, x86, x86_64
---

<div align="center">

</div>
