# Twitter Java App (API v2)
This project implements a Java application that allows users to post, show, and delete tweets on Twitter using the Twitter REST API V2. The TwitterApp follows the MVC architecture, where the models encapsulate and manage Tweet objects that are displayed in JSON format. The controller layer interacts with client input (args), parses it, and calls the service layer to return results. The service layer handles the business logic and interacts with the DAO layer to communicate with the Twitter REST API. The data access layer (DAO) interacts with the Twitter REST API to perform post, show, and delete actions on tweets.

To implement this design, we use Twitter REST API v2 and combine it with HTTP requests to perform the actions. We also use the OAuth 1.0a protocol to create an additional HTTP Authorization header to authorize HTTP requests. To convert JSON strings from HTTP responses to Tweet objects and vice versa, we use the fasterXML Jackson package. Springboot framework is used to manage dependencies and set dependencies via the class constructor. For testing, we utilize integration and unit testing with the libraries Mockito and JUnit4. To manage all the above dependency packages, we use Maven.

Finally, we deploy the Twitter application within a Docker container and upload it to Dockerhub for easy use.

# Technologies
- Java 8 ()
- Postman / Twitter v2Api
- Docker
- OAth Authentication
 

## Start App
Retrieve the App from Docker image.
```
docker run --rm \
-e consumerKey=YOUR_VALUE \
-e consumerSecret=YOUR_VALUE \
-e accessToken=YOUR_VALUE \
-e tokenSecret=YOUR_VALUE \
jrvs/twitter_app post "The first tweet from Farnaz Towhidi"
```


```
TwitterApp post [options]
TwitterAApp post "Tweet text"

TwitterApp delete [options]
TwitterApp delete Tweet_id1,Tweet_id2"
```

## End Points
1. Create Tweet: /2/tweets
2. Delete Tweet: /2/tweets/:id
3. Show User: 
```
{
"text": "Hello World!"
}
```
# Twitter Json
```
{
	"created_at": "Fri Feb 14 19:00:55 +0000 2020",
	"id_str": "1228393702244134912",
	"text": "What did the developer write in their Valentine?s card?\n  \nwhile(true) {\n    I = Love(You);  \n}",
	"entities": {
		"hashtags": [],
		"symbols": [],
		"user_mentions": [],
		"urls": []
	},
	"user": {
		"entities": {
			"url": {}
		}
	},
	"place": {}
}
```
3-Get Tweet:
End Point: GET /2/users/me


# MVC Architectural Pattern
This project implements with the bottom-up approach, DAO -> Service -> Controller -> AppMain.

![Twitter_Architecture.jpg](assets%2FTwitter_Architecture.jpg)

### 1- Model
Models are implemented with POJOs which is a class with private member variables and public getter and setters. This class encapsulates Tweet data (Tweet Objects) which often display in JSON format.
### 2- Controller
The controller layer interacts and parsers user input (CLI args in this APP). It also calls the service layer and returns results.
### 3- Service
The service layer handles business logic and calls DAO layer in order to interact with the underlying storage/service which is the Twitter REST API in this app.
### 4- Data Access Layer
## Class Dependency Diagram
TwitterCLIApp depends on TwitterController depends on TwitterService  depends on TwitterDao depends on TwitterHttpHelper

![Twitter_CLI_Architecture.jpg](assets%2FTwitter_CLI_Architecture.jpg)
# Test
Unit test using JUnit and Mockito libraries.