# 🛒 selenium-api-shopperstack

An automation framework combining **Selenium WebDriver** and **Rest Assured** to perform UI and API testing on [shopperstack.com](https://www.shopperstack.com). Designed with modularity, reusability, and scalability in mind, this project uses the **Page Object Model (POM)** and follows best practices for hybrid test automation.

---

## 📌 Key Features

- ✅ Hybrid Test Automation (UI + API)
- 🧪 TestNG for test structure and assertions
- 🌐 Rest Assured for API validation and automation
- 🔧 Selenium WebDriver with Page Object Model
- 🔁 Parallel execution using TestNG suites
- 📦 Maven for build and dependency management
- 🔐 Token-based authentication and header injection
- 🧵 Thread-safe WebDriver using ThreadLocal
- 📊 Supports integration with reporting tools like Allure or ExtentReports

---



## ⚙️ Technologies Used

- Java 11+
- Selenium WebDriver
- Rest Assured
- TestNG
- Maven
- JSON Schema Validator
- ThreadLocal
- Git & GitHub
- (Optional) Allure or Extent Reports

---
## 💻 Parallel Execution Support
Thread-safe WebDriver is used to support parallel UI execution using:

## 🚀 How to Run Tests

```bash
git clone https://github.com/Ganeshaprasad/selenium-api-shopperstack.git
cd selenium-api-shopperstack

###  Run with Maven
mvn clean test

### Run specific TestNG suite
mvn test -DsuiteXmlFile=testng.xml
```
---
###  🚀Note: This framework automates ShoppersStack — a demo eCommerce site — for learning purposes only.
