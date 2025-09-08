# Finance Calculators Automation

This project automates the testing of various **finance calculators** on [MoneyControl](https://www.moneycontrol.com/) using **Selenium WebDriver**, **Cucumber BDD**, **TestNG**, and **Extent Reports**. The framework supports **data-driven testing** with **Excel files** and uses **Git** for version control.

---

## Project Overview

**Automated Calculators:**

* Car Loan EMI Calculator
* Personal Loan Calculator
* Provident Fund (PF) Calculator
* Gratuity Fund Calculator

**Key Features:**

* Java + Selenium WebDriver
* BDD with Cucumber (`.feature` files)
* Data-driven testing via Excel
* Extent Reports for logging & screenshots
* Handles dynamic page elements (popups, ads)
* Centralized config via `config.properties`


## Installation & Setup

1. **Clone the repository:**

```bash
git clone https://github.com/NihalThomas/Money-Control-Automation.git
```

2. **Install dependencies (Maven):**

```bash
mvn clean install
```

3. **Run Tests:**

```bash
mvn test
```

or run via IDE using `testng.xml`.

---

## Usage

* Update URLs in `config.properties`.
* Modify or add test data in `testdata/` Excel files.
* Screenshots and reports are generated in `screenshots/` and `extent-reports/`.

---

## Reporting

* **Extent Reports:** HTML reports with screenshots.
* **Cucumber Reports:** Pretty formatted execution report.

---

## Future Scope

* Integrate **CI/CD pipelines** (GitHub Actions, Jenkins).
* Expand to **cross-browser and mobile testing**.
* Implement **AI-driven test validation**.
* Enhance **test reporting dashboards**.
* Enable collaborative development using **Git branching & PRs**.

---
