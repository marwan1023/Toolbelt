const chalk = require('chalk');
const express = require('express');
const sensor = require('node-dht-sensor');

const app = express()

    app.get('/temperature', function (req, res) 
            {      
               sensor.read(11, 4, function (err, temperature,     humidity) 
                           {        
                        if (!err) 
                            {    
                              res.send(temperature.toFixed(1) + '°C');     
                            }   
               }); 
    });   

   app.get('/humidity', function (req, res)
           {    
     sensor.read(11, 4, function (err, temperature,     humidity) {  
       if (!err) {   
         res.send(humidity.toFixed(1) + '%');    
       }    
     });  
   });  

app.listen(3000,"0.0.0.0", function(){       console.log('Server listening on port 3000');     });
