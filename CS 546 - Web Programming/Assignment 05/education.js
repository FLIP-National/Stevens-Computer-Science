var express = require('express');
var educationroute = express.Router();
const education= [{
    schoolName: "Stevens Institute of Technology",
    degree: "MS in Computer Science",
    favoriteClass: "Web Programming",
    favoriteMemory: "Watching the Royal Caribbean Cruize in Hudson River during my evening class."
    
  },
  {
    schoolName: "Pillai College of Engineering",
    degree: "Bachelor of Engineering in Electronics Engineering",
    favoriteClass: "Microcontroller",
    favoriteMemory: "Attending DJ nights along with friends"
    
  },
  {
    schoolName: "Pillai College of Engineering",
    degree: "Diploma in Electronics Engineering",
    favoriteClass: "Introduction to electronics",
    favoriteMemory: "Designing electronic circuits was new to me and is most memorable part of this course."
    
  },
]

educationroute.get('/', function(req, res){
    
   res.send(education);
});
educationroute.post('/', function(req, res){
   res.send('POST route on education.');
});

//export this router to use in our app.js
module.exports = educationroute;