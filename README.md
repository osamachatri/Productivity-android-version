# ProductivityX

![ProductivityX](https://your-project-banner-url.com)

🚀 **ProductivityX** is a modern **productivity app** built using **Kotlin** and **Jetpack Compose**. It features **Notes, To-Do Lists, Events, Pomodoro Timer, and an AI Chatbot** to help users stay organized and focused. Designed with a clean **MVVM architecture**, it integrates **Room, Retrofit, Hilt, Firebase, and Ktor** for a seamless experience.

## 📌 Features
- 📝 **Notes** – Create, edit, and manage notes with rich text.
- ✅ **To-Do Lists** – Organize tasks efficiently with categories and reminders.
- 📅 **Events** – Keep track of important dates and events.
- ⏳ **Pomodoro Timer** – Stay productive with a time-management technique.
- 🤖 **AI Chatbot** – Get assistance with a built-in AI-powered chatbot.
- 🌙 **Dark Mode Support** – Seamless light/dark theme switching.
- 📶 **Offline Mode** – Access notes and tasks even without internet.
- 🔔 **Notifications & Reminders** – Stay on top of your tasks and events.

## 🏗️ Tech Stack
- **Kotlin** – Primary language for Android development.
- **Jetpack Compose** – Modern UI toolkit for building native UIs.
- **Room Database** – Local storage for notes, tasks, and events.
- **Retrofit** – REST API client for network communication.
- **Hilt (Dagger)** – Dependency injection for clean architecture.
- **Firebase Authentication** – User sign-in and authentication.
- **Firebase Realtime Database** – Cloud-based real-time data syncing.
- **WorkManager** – Background tasks and scheduling.
- **Ktor Backend** – Server-side API to manage user data.

## 📂 Project Structure
```
📦 myapp
 ┣ 📂 app
 ┃ ┣ 📂 src/main
 ┃ ┃ ┣ 📂 java/com/example/myapp
 ┃ ┃ ┃ ┣ 📂 core                   
 ┃ ┃ ┃ ┃ ┣ 📂 di                 # ✅ Dependency Injection (Hilt modules)
 ┃ ┃ ┃ ┃ ┃ ┣ 📜 AppModule.kt    # Provides app-wide dependencies (DB, API, DataStore)
 ┃ ┃ ┃ ┃ ┃ ┣ 📜 DatabaseModule.kt # Provides Room Database & DAOs
 ┃ ┃ ┃ ┃ ┃ ┣ 📜 NetworkModule.kt  # Provides Retrofit & API services
 ┃ ┃ ┃ ┃ ┃ ┗ 📜 DispatcherModule.kt # Provides Dispatchers for Coroutines
 ┃ ┃ ┃ ┃ ┣ 📂 datastore          # ✅ DataStore for app preferences
 ┃ ┃ ┃ ┃ ┃ ┣ 📜 SettingsManager.kt # Handles theme, notification preferences
 ┃ ┃ ┃ ┃ ┃ ┗ 📜 UserPreferences.kt # DataStore model
 ┃ ┃ ┃ ┃ ┣ 📂 database           # ✅ Room Database setup
 ┃ ┃ ┃ ┃ ┃ ┣ 📜 AppDatabase.kt   # Main Room database
 ┃ ┃ ┃ ┃ ┃ ┣ 📜 NoteDao.kt       # DAO for Notes
 ┃ ┃ ┃ ┃ ┃ ┣ 📜 TodoDao.kt       # DAO for To-Do lists
 ┃ ┃ ┃ ┃ ┃ ┗ 📜 EventDao.kt      # DAO for Events
 ┃ ┃ ┃ ┃ ┣ 📂 network            # ✅ Retrofit API Service
 ┃ ┃ ┃ ┃ ┃ ┣ 📜 ApiService.kt    # Retrofit API calls
 ┃ ┃ ┃ ┃ ┃ ┗ 📜 ApiConstants.kt  # API Endpoints
 ┃ ┃ ┃ ┃ ┣ 📂 utils              # ✅ Helper classes (Validators, DateUtils, etc.)
 ┃ ┃ ┃ ┣ 📂 main                 # ✅ Main Application Setup
 ┃ ┃ ┃ ┃ ┣ 📜 MyApp.kt          # Application class (Hilt & AppConfig)
 ┃ ┃ ┃ ┃ ┣ 📜 MainActivity.kt   # Main UI entry point
 ┃ ┃ ┃ ┃ ┗ 📜 AppModule.kt      # App-level Hilt dependencies
 ┃ ┃ ┃ ┣ 📂 navigation           # ✅ Handles Navigation Graph
 ┃ ┃ ┃ ┃ ┣ 📜 Screen.kt         # Sealed class for navigation routes
 ┃ ┃ ┃ ┃ ┗ 📜 NavGraph.kt       # Navigation setup
 ┃ ┃ ┃ ┣ 📂 auth                 # ✅ Authentication Module (Sign In/Up)
 ┃ ┃ ┃ ┃ ┣ 📂 data               # Repositories & models
 ┃ ┃ ┃ ┃ ┣ 📂 domain             # Use Cases
 ┃ ┃ ┃ ┃ ┗ 📂 presentation       # UI Screens & ViewModels
 ┃ ┃ ┃ ┣ 📂 features             # ✅ Feature Modules
 ┃ ┃ ┃ ┃ ┣ 📂 notes              # Notes feature
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 data             # Repositories, Data Models
 ┃ ┃ ┃ ┃ ┃ ┣ 📂 domain           # Use Cases
 ┃ ┃ ┃ ┃ ┃ ┗ 📂 presentation     # UI & ViewModels
 ┃ ┃ ┃ ┃ ┣ 📂 todo               # To-Do Lists feature
 ┃ ┃ ┃ ┃ ┣ 📂 events             # Events feature
 ┃ ┃ ┃ ┃ ┣ 📂 pomodoro           # Pomodoro feature
 ┃ ┃ ┃ ┃ ┗ 📂 chatbot            # AI Chatbot feature
 ┃ ┃ ┃ ┣ 📂 ui                   # ✅ Common UI components
 ┃ ┃ ┃ ┃ ┣ 📜 AppTheme.kt       # Jetpack Compose Theme
 ┃ ┃ ┃ ┃ ┣ 📜 CommonButton.kt   # Reusable buttons
 ┃ ┃ ┃ ┃ ┣ 📜 CommonDialog.kt   # Reusable dialogs
 ┃ ┃ ┃ ┃ ┗ 📜 LoadingIndicator.kt # Custom loading spinner
 ┃ ┃ ┣ 📂 res                    # ✅ Resources (drawables, themes, strings)
 ┃ ┃ ┗ AndroidManifest.xml
 ┃ ┣ 📂 src/test                 # ✅ Unit tests
 ┃ ┣ 📂 src/androidTest          # ✅ Instrumentation tests

```

## 🔧 Installation
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/your-username/ProductivityX.git
   cd ProductivityX
   ```
2. **Open in Android Studio** and Sync Gradle.
3. **Run the App** on an emulator or physical device.

## 🚀 API & Backend Setup
- The backend is built using **Ktor** and **MySQL**.
- To run the server locally:
  ```sh
  ./gradlew run
  ```
- API Base URL is configured in `NetworkModule.kt`.

## 🧪 Testing
Run unit tests with:
```sh
./gradlew test
```
Run UI tests with:
```sh
./gradlew connectedAndroidTest
```

## 🤝 Contributing
1. **Fork the repo** and create a new branch.
2. Make changes and **commit with meaningful messages**.
3. Open a **Pull Request** for review.

## 📜 License
MIT License - see the [LICENSE](LICENSE) file for details.

---

💡 **Developed with ❤️ by [Your Name]**

