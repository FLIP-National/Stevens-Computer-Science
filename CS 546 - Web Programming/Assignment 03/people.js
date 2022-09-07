const axios = require('axios');
async function getPersonById(id) {

    const response = axios.get('https://gist.githubusercontent.com/robherley/5112d73f5c69a632ef3ae9b7b3073f78/raw/24a7e1453e65a26a8aa12cd0fb266ed9679816aa/people.json')
        .then(function (response) {
            if (id == undefined || id == null) throw "Please provide proper input";
            if (id < 0 || id > 500) throw "ID out of bounds"
            if (typeof id == "number") {
                for (var i = 0; i < 501; i++) {
                    if (response.data[i].id == id) {
                        throw response.data[i].firstName + " " + response.data[i].lastName;
                    }
                }
            }

        }).catch(function (error) {
            console.log(error);
        })
}



const idProper = function idProper(id) {
    if (typeof id == null || typeof id == 'undefined' || isNaN(id) || typeof id == 'string') {
        throw `Not a valid input`
    }
}

//Function to check Id within bounds or not
const idWithinBounds = function idWithinBounds(id) {
    if (Math.sign(id) != 1 && id != 0 || id == 0 || id > 500) {
        throw `Number you have entered is out of bounds`
    }
}


function compare(a, b) {
    var compared = 0;
    const lastA = a.lastName.toUpperCase();
    const lastB = b.lastName.toUpperCase();
    if (lastA > lastB) {
        compared = 1;
    }
    else if (lastA < lastB) {
        compared = -1;
    }
    return compared;
}
//Function to sort Last Name
const lexIndex = async function lexIndex(index) {
    idProper(index);
    idWithinBounds(index);
    const { data } = await axios.get('https://gist.githubusercontent.com/robherley/5112d73f5c69a632ef3ae9b7b3073f78/raw/24a7e1453e65a26a8aa12cd0fb266ed9679816aa/people.json');
    Object.keys(data).forEach(function (key) { data.sort(compare); });
    return data[index - 1]['firstName'] + " " + data[index - 1]['lastName'];
}

//Function to perform various operations
const firstNameMetrics = async function firstNameMetrics() {
    let sum = 0, sumVowels = 0, sumConsonants = 0, longestName = "", shortestName = "", longestNameLen = Number.MIN_SAFE_INTEGER, shortestNameLen = Number.MAX_SAFE_INTEGER;
    const { data } = await axios.get('https://gist.githubusercontent.com/robherley/5112d73f5c69a632ef3ae9b7b3073f78/raw/24a7e1453e65a26a8aa12cd0fb266ed9679816aa/people.json');
    if (data == undefined)
        throw "Data you are looking for is not found"
    Object.keys(data).forEach(function (key) {
        var firstName = data[key]['firstName'];
        if (firstName.length > longestNameLen) {
            longestNameLen = firstName.length;
            longestName = firstName;
        }
        if (firstName.length < shortestNameLen) {
            shortestNameLen = firstName.length;
            shortestName = firstName;
        }
        firstName = firstName.toLowerCase();
        for (var i of firstName) {
            if ((i.toUpperCase() == i.toLowerCase())) {
                continue;
            }
            sum++;
            if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
                sumVowels++;
            }
            else {
                sumConsonants++;
            }
        }
    });
    var output = {
        'sum': sum,
        'sumVowels': sumVowels,
        'sumConsonants': sumConsonants,
        'longestName': longestName,
        'shortestName': shortestName
    }
    return output;
}
module.exports = {
    getPersonById,
    lexIndex,
    firstNameMetrics
}