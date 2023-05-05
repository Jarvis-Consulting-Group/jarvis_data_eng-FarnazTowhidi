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

3-Get Tweet:
End Point: GET /2/users/me