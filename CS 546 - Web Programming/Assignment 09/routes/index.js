const path = require('path'); 
const constructorMethod = (app) => {
 
    app.get('/', (req, res) => {
        res.sendFile(path.resolve('static/ifFiboPrime.html'));
    });
};
 
module.exports = constructorMethod;