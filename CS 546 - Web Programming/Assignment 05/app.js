var express = require('Express');
var app = express();

var about = require('./about.js');
var story = require('./story.js');
var education = require('./education.js');

app.use('/about', about);
app.use('/story', story);
app.use('/education', education);



app.listen(3000, () => {
    console.log("We've now got a server!");
    console.log("Routes are running on http://localhost:3000");
    console.log("About Page is running on http://localhost:3000/about/");
    console.log("Story Page is running on http://localhost:3000/story/");
    console.log("Education Page is running on http://localhost:3000/education/");
  });