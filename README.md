# Farnaz Towhidi . Jarvis Consulting

As a Junior Software Engineer at Jarvis Consulting Group, with experience gained from working in different companies, I bring practical skills and a strong academic background obtained through completion of the General Assembly software immersive bootcamp and my PhD research. My academic journey includes earning a master's and PhD in computer science from UTM University, where my research focused on demonstrating the vulnerability of graphical password authentication to dictionary attacks. Specifically, my research investigated the aggregation of regions within an image that exhibit low-level properties and their impact on security.  However, recognizing the importance of practical and technical skills in the software engineering industry, I decided to complement my academic expertise with hands-on experience. This led me to enroll in the General Assembly software immersive bootcamp, where I gained proficiency in a range of programming languages and frameworks, including Java, JavaScript/TypeScript, React, Angular, Next.js, MongoDB, and Django. Additionally, I honed my skills in utilizing essential tools such as Git, Docker, and agile methodologies during the bootcamp.

## Skills

**Proficient:** JavaScript, Java, React, Angular, Bash, Node.js, MongoDB, SQL

**Competent:** REST APIs, Docker, Git, HTML/CSS, Agile/Scrum

**Familiar:** OAuth, TestRail, Selenium, Jira, .Net

## Jarvis Projects

Project source code: [https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-FarnazTowhidi](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-FarnazTowhidi)


**Twitter CRUD App** [[GitHub](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-FarnazTowhidi/tree/master/core_java/twitter)] : I have developed an MVC application that allows users to create and delete tweets on Twitter using the Twitter REST API v2. The application follows a layered architecture with four components; model, controller, service, and data access. The Controller layer handles client input and calls the service layer to handle the business logic. The service layer interacts with the Data Access Object for communication with the Twitter REST API. This enables actions such as posting, showing, and deleting tweets. To ensure the quality of the code, integration and unit testing are performed using the Mockito and JUnit4 libraries. To authenticate with the Twitter API, the application utilizes the OAuth 1.0a protocol, which includes the necessary credentials in the HTTP Authorization header. For easy distribution and deployment, the project is packaged into a Docker image and published on Docker Hub. In addition, the spring boot framework is used to manage dependencies.

**Cluster Monitor** [[GitHub](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-FarnazTowhidi/tree/masterhttps://github.com/Jarvis-Consulting-Group/jarvis_data_eng-FarnazTowhidi/tree/develop/linux_sql)]: This project is used by the Jarvis Linux Cluster Administrator (LCA) team to manage server nodes in a closed network. A series of bash scripts collects the hardware specs of each server like host name, CPU architecture, CPU model, and L2 cache as well as real time resource usage of each server like CPU idle, kernel statistics and available disk space. The PostgreSQL Docker container configured and maintained to store and manage the collected data. To ensure accurate and up-to-date information, resource usage is fetched at regular intervals using Crontab.

**Grep App** [[GitHub](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-FarnazTowhidi/tree/master/core_java/grep)]: This project simulatered the egrep text processing tool, enabling recursive searches of a given directory using regular expressions. The BufferedReader class is used to read the file, and regular expressions are applied to compare words against the provided regex pattern. The identified words are saved to an output file using the FileWriter class. Additionally, the project was re-implemented using Lambda and Stream APIs to write code in a more readable functional programming style, as well as processing large files. Maven is utilized for dependency management, specifically for incorporating slf4j and log4j for logging purposes.

**JDBC Apps** [[GitHub](https://github.com/Jarvis-Consulting-Group/jarvis_data_eng-FarnazTowhidi/tree/master/core_java/jdbc)]: Developed proficiency in data access patterns and JDBC by performing data manipulation tasks on the hplussport PostgreSQL database. Utilized Dbeaver and Intellij Idea for database management, Docker for containerization, PostgreSQL and PSQL CLI tool for database creation and manipulation, JDBC for data access, and Maven for build automation.


## Highlighted Projects
**A new method of dictionary attack on cued graphical password**: As an ethical researcher, in my PHD, I proposed a model to identifying the weaknesses of a cue-based graphical passwords to dictionary attack.   This model analyze an image and identifies areas within the image that have the potential to capture the user's attention. Since any high difference in colour, intensity and orientation can highlight the object from its surrounding, the algorithm calculated the values of these three features for all pixels in the image. The output consists of points that exhibit noticeable dissimilarities from their surroundings, indicating their likelihood to attract the user's focus.  These areas created a new dictionary of graphical password, that were used to attack actual passwords of users. The model used Matlab for color detection, HTML for user interface and SQL Server for databases of passwords.

**Chatterbox** [[GitHub](https://github.com/FarnazTowhidi/mern-project)]: I have developed "Chatterbox," an instant messaging application with a Client-Server architecture that enables real-time communication between users. In this single-page application, the client-side scripting is implemented using React and Material-UI (MUI), providing a seamless and intuitive user interface. To handle data storage and manipulation, CRUD requests are sent to the server through API calls using Express.js and MongoDB. The application leverages Socket.io to achieve the functionality of instant messaging, enabling users to engage in real-time conversations. Additionally, the aws-sdk package is utilized to facilitate the smooth uploading of images to Amazon Web Service (AWS) S3 buckets. This allows users to easily share and display images within the application. Lastly, the project is deployed to Heroku, ensuring that Chatterbox is accessible and available to users on a reliable hosting platform.

**Track Fit** [[GitHub](https://github.com/aerlikh17/track-fit-app)]: Track Fit is a Python-based Django Web Framework designed for individuals to track their fitness journey. With Django's built-in authentication, users can securely authenticate and manage their daily exercises in a PostgreSQL database. The framework also provides yearly reports grouped by month for insightful analysis. Deployment is seamless through Heroku, ensuring easy accessibility and availability for users.

**Card Game War** [[GitHub](https://github.com/FarnazTowhidi/warCardGame)]: I simulated the card game war with Vanilla JavaScript, HTML and CSS. The JavaScript used to implement the game logic to handle shuffling the deck, dealing cards to players, comparing card values, determining the round winner, and managing the game state. More over JavaScript used to interact with the DOM to update the game's visual elements when playing rounds, displaying cards, and declaring a winner.


## Professional Experiences

**Software Engineer, Jarvis (2023-present)**: I have joined Jarvis as a Junior Software Engineer to develop, consult, and assist customers with their software solutions. I work in an Agile/Scrum development environment where I participate in daily scrum meetings with the Scrum Master to discuss our progress and possible blockers. The sprint meeting is held every two weeks to select from various projectusing Java, RDBMS, Linux, Docker, SpringBoot, React, and Angular.

**Full Stack Developer, Iranian Iron & Steel Institute of Education, Remote (2021-2022) [[site]](http://www.iisie.net/)**: Implemented a website for managing and scheduling workshops on Metallurgical and Materials engineering. Allowed organizations and individuals to create and sign-up for events, as well as share learning resources. The website created by asp, HTML and bootstrap, ensuring a user-friendly experience for all users.

**Quality Assurance, IBM, Fredericton (2020-2020)**: I joined IBM as a Tech-reentry in the Security Intelligence team, where I had the opportunity to learn about QRadar. Through this experience, I gained knowledge on how QRadar efficiently analyzes the log data and network flows to identify malicious activities. As part of my role as a QA, I was responsible for both automation and manual testing, utilizing tools such as Selenium WebDriver. While testing QRadar, I validating its functionalities and detecting any potential issues. Additionally, I worked extensively with Jenkins jobs during the QRadar patch release, ensuring smooth and efficient deployment.

**Full Stack Developer, Canadian Institute of Cybersecurity, Fredericton (2019-2019) [[site]](https://pstnet.ca/)**: I designed and implemented the PST website, a forum that designed for researchers worldwide to share their latest work in privacy, security, and trust. It is organized annually by the University of New Brunswick and the Canadian Institute for Cybersecurity. The website features a responsive design created using ASP, Bootstrap, HTML, and CSS. It provides various sections including a 'Call for Papers' to invite submissions, a 'Paper Registration' section for authors, and an archive of previous conferences.

**Full Stack Developer, Biossentials, Kuala Lumpur (2009-2014) [[site]](https://www.biossentials.com/)**: I redesigned the Biossentials website to prioritize SEO improvement. I focused on creating engaging content, optimizing relevant keywords, improving site structure, integrating social media, and enhancing user experience. The website was developed using ASP, HTML, and CSS, ensuring a professional and seamless online presence.


## Education
**General Assembly (2022-2022)**, Software Engineering Immersive, Faculty of Computing, GPA: 3.9/4.0

**Universiti Teknologi Malaysia (2010-2015)**, PHD of Computer Science, Faculty of Computing

**Universiti Teknologi Malaysia (2008-2010)**, Master of Computer Science (Information Security), Faculty of Computing, GPA: 3.65/4.0


## Miscellaneous
- Authored [[Book]](https://www.amazon.ca/Graphical-Password-Alternative-Textual-ebook/dp/B01343DVSM/ref=sr_1_2?crid=1XD4DTN9AE0I9&keywords=farnaz+towhidi&qid=1689566121&sprefix=farnaz+towhidi%2Caps%2C78&sr=8-2): Graphical User Authentication (GUA): Graphical Password Algorithms and Analysis
- Authored [[Book]](https://www.amazon.ca/Graphical-User-Authentication-GUA-Algorithms/dp/3843380724/ref=sr_1_1?crid=1XD4DTN9AE0I9&keywords=farnaz+towhidi&qid=1689566293&sprefix=farnaz+towhidi%2Caps%2C78&sr=8-1): Graphical Password An Alternative to Textual Password
- Computer Hacking Forensics Investigator (CHFI), EC-Council
- Certified Ethical Hacker (CEH), EC-Council
- Cloud Core, IBM
- Design and User Experience (D&UX), IBM