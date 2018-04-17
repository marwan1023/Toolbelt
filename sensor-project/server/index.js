const chalk = require('chalk');
const express = require('express');
const sensor = require('node-dht-sensor');
const getCachedSensorReadings = require('./cachedSensorReadings')

const app = express()

    res.send(getCachedSensorReadings    .getTemperature().toFixed(1) + '°C')
    });   

   app.get('/humidity', function (req, res)
           {    
      res.send(getCachedSensorReadings    .getHumidity().toFixed(1) + '%')      })
   });  

app.listen(3000,"0.0.0.0", function(){       console.log('Server listening on port 3000');     });
