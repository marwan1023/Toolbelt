const chalk = require('chalk');
const express = require('express');

const app = express()

app.get('/temperature', function(req, res) {      res.send('24 °C');    });

app.get('/humidity', function(req, res) {      res.send('48%');    });


//const port = 3000;
//Run Server
//app.listen(process.env.PORT || port, '0.0.0.0', () => console.log(chalk.blue(`Listening intently on port ${port}`)));


app.listen(3000,"0.0.0.0", function(){       console.log('Server listening on port 3000');     });
