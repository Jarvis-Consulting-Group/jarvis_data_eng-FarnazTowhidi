## Postman
1-Delete tweet: Postman->Manage Tweet->Delete a Tweet. The id of tweet should be from user account
End Point: DELETE /2/tweets/:id
2-Create Tweet: Postman->Manage Tweet->Create a Tweet. The text of tweet.
End Point: POST /2/tweets
Body:
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