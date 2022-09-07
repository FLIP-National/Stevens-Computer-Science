var express = require('express');
var aboutroute = express.Router();
const about= {
    name: "Chaitanya Pawar",
    cwid: "20008880",
    biography: "Hey, I am a graduate student at Stevens Institute of Technology, Persueing my Masters in Computer Science. \nI'm a electronics engineer specialized in designing electronic circuits and passionate in programming. Currently, I'm focused on building accessible Web and mobile projects at my free time.",
    favoriteShows: ["Snowpiercer", "Stranger Things", "Star Trek: Discovery", "Marvel Comics"],
    hobbies: ["Trekking", "Cycling", "Camping", "Mountaineering"]
  }


  aboutroute.get('/', function(req, res){
   
   res.json(about);

});
aboutroute.post('/', function(req, res){
   res.send('POST route on about.');
});

//export this router to use in our app.js
module.exports = aboutroute;