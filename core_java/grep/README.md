# Introduction
A Java grep app that mimics Linux grep command which allows users to search matching strings from files.

# Prerequisites
### 1- Install IntelliJ Plugins
1. IDE Features Trainer
2. Key Promoter X
3. CheckStyle-IDEA

### 2- Auto code Format
1. Get Google Java Style configuration file for IntelliJ
```
#bash cmd
cd {your_dir}/jarvis_data_eng_{your_name}
#download intellij-java-google-style.xml
wget https://raw.githubusercontent.com/google/styleguide/gh-pages/intellij-java-google-style.xml .
```
2. Apply this configuration file to IDE
   Docker is installed
psql client is installed

### 3- Automatically add import statements

# Pseudocode process method
```
matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
writeToFile(matchedLines)
```
# Implementaiton
- JVM for Java program
- Github for SCM
- Distribute app using Docker images

# ER Diagram


#Design Patterns

# Test
- Manual testing
- IDE debugger
- JUnit (if required)