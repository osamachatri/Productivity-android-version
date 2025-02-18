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
📦 ProductivityX
 ┣ 📂 app
 ┃ ┣ 📂 src/main/java/com/example/productivityx
 ┃ ┃ ┣ 📂 core (Core functionalities: DI, Database, Network, Utils)
 ┃ ┃ ┣ 📂 main (Application setup: MyApp, MainActivity)
 ┃ ┃ ┣ 📂 auth (Authentication: Data, Domain, UI)
 ┃ ┃ ┣ 📂 features (Feature modules: Notes, To-Do, Events, Pomodoro, Chatbot)
 ┃ ┃ ┣ 📂 ui (Reusable UI components)
 ┃ ┃ ┣ 📂 navigation (Navigation setup)
 ┃ ┃ ┗ 📂 res (Resources: Drawables, Strings, Themes)
 ┃ ┣ 📂 src/test (Unit tests)
 ┃ ┣ 📂 src/androidTest (UI tests)
 ┃ ┗ AndroidManifest.xml
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

