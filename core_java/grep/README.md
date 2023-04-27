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
- 
# Compile Java and classpath
```
cd core_java/grep
mvn clean
java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp .*Romeo.*Juliet.* ./data ./out/grep.txt
```
# Dockerize your grep
- Create Access token in Docker hub
- `docker login -u farnaztowhidi`
- Password: The Access Token
- Create dockerfile:
```
cat > Dockerfile << EOF
FROM openjdk:8-alpine
COPY target/grep*.jar /usr/local/app/grep/lib/grep.jar
ENTRYPOINT ["java","-jar","/usr/local/app/grep/lib/grep.jar"]
EOF
```
- Package your java app
```
#mvn clean package
#build a new docker image locally
docker build -t ${docker_user}/grep .
#verify your image
docker image ls | grep "grep"
#run docker container (you must undertand all options)
docker run --rm \
-v `pwd`/data:/data -v `pwd`/log:/log \
${docker_user}/grep .*Romeo.*Juliet.* /data /log/grep.out

#push your image to Docker Hubg
docker push ${docker_user}/grep

#Go to hub.docker.com and verify your image
```

# App Usage
```

docker run --rm \
-v `pwd`/data:/data -v `pwd`/out:/out jrvs/grep \
${regex_pattern} ${src_dir} /out/${outfile}
#verify
cat out/$outfile
```

# Test
The Java grep app was thoroughly tested through manual testing using IntelliJ's debug mode. The testing process involved using a sample text file, such as shakespeare.txt, as input data and running the grep app manually. The results were then compared to a sample output file to ensure accuracy and proper functioning of the app.

