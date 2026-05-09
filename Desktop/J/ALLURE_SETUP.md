# Allure Reporting Setup

This project is configured with Allure Reports for detailed test analytics and trends.

## Prerequisites

Ensure you have the following installed:
- Java 17 or higher
- Maven 3.6.3 or higher
- Allure Commandline Tool (optional, for local report viewing)

## Installation Instructions

### 1. Install Java 17
If not already installed, download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or use:
```bash
brew install openjdk@17
```

### 2. Install Maven
```bash
brew install maven
```
Or download from [Apache Maven](https://maven.apache.org/download.cgi)

### 3. Verify Installations
```bash
java -version
mvn --version
```

## Running Tests and Generating Allure Reports

### Option 1: Run Tests and Generate Report (Recommended)

```bash
cd /Users/mac/Desktop/J

# Run tests
mvn clean test

# Generate Allure report
mvn allure:report
```

### Option 2: View Report in Browser (Localhost)

After running tests and generating the report:

```bash
mvn allure:serve
```

This command:
- Generates the Allure report
- Starts a local HTTP server
- Opens the report in your default browser
- The server runs until you stop it (Ctrl+C)

## Where Allure Results Are Stored

- **Raw Results**: `target/allure-results/`
- **Generated Report**: `target/site/allure-maven-plugin/`
- **Report Index**: `target/site/allure-maven-plugin/index.html`

## Report Features

Your Allure report includes:

✅ **Test Results** - PASSED, FAILED, SKIPPED status
✅ **Test Severity** - CRITICAL, NORMAL, MINOR levels
✅ **Test Stories** - Organized by feature stories
✅ **Test Descriptions** - Detailed test purpose and steps
✅ **Owner Information** - QA Team assignments
✅ **Test Timeline** - Duration and execution times
✅ **Trends** - Historical test results over time
✅ **Attachments** - Screenshots and logs (when available)

## Test Cases Included

### 1. **testCase1** - Homepage Verification
- **Story**: Homepage Verification
- **Severity**: CRITICAL
- **Description**: Verify Amazon homepage loads successfully and contains correct title

### 2. **testCase2** - Product Search  
- **Story**: Product Search
- **Severity**: CRITICAL
- **Description**: Search for a product on Amazon and verify results page appears

### 3. **testCase3** - Search Box Functionality
- **Story**: Search Box Functionality
- **Severity**: NORMAL
- **Description**: Verify Amazon search box visibility and input field behavior

## CI/CD Integration

Tests automatically run on:
- **Pull Requests** to the `main` branch via GitHub Actions
- Reports are generated as artifacts in GitHub Actions

## Troubleshooting

### Maven Command Not Found
```bash
export PATH=$PATH:/usr/local/bin/mvn
# Or add to ~/.zshrc or ~/.bash_profile
```

### Java Version Mismatch
```bash
java -version  # Check version
# Update JAVA_HOME if needed
```

### Report Not Generating
```bash
mvn clean  # Clear cache
mvn test   # Rerun tests
mvn allure:report  # Generate report
```

## Additional Resources

- [Allure Framework Documentation](https://docs.qameta.io/allure/)
- [TestNG Documentation](https://testng.org/)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
