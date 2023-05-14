# Twitter Java App (API v2)
# Technologies
- Java 8 ()
- Postman / Twitter Api
- Docker
- OAth Authentication

- 
## Create App
```
docker run --rm \
-e consumerKey=YOUR_VALUE \
-e consumerSecret=YOUR_VALUE \
-e accessToken=YOUR_VALUE \
-e tokenSecret=YOUR_VALUE \
jrvs/twitter_app post "The first tweet from Farnaz Towhidi"
```

## Usage: Post | Delete Tweet
```
TwitterApp post [options]
TwitterAApp post "Tweet text"

TwitterApp delete [options]
TwitterApp delete Tweet_id1,Tweet_id2"
```

## Postman
1. Create Tweet
* Postman: Manage Tweet->Create a Tweet.
* END POINT: POST /2/tweets
2. Delete Tweet
* Postman: Manage Tweet->Delete a Tweet.
* End Point: DELETE /2/tweets/:id
3. Show User
* Postman: 
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

# Test