const express = require('express');
const app = express();
const port = 3001; // Choose the port you want to run your server on

app.get('/', (req, res) => {
  res.send('Hello from Express!');
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
