const express = require('express');
const app = express();
const port = 3001; // Choose the port you want to run your server on
const cors = require("cors");

app.get('/', (req, res) => {
  res.send('Hello from Express!');
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});

app.use(cors());

// routes
app.use("/api/traders", require("./src/router/api/traders"));