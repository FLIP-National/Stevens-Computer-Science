const people = require("./people");
const work = require("./work");
const weather = require("./weather");

async function main() {
    try {
        await people.getPersonById(43);// Returns: "Brew Peat"
        await people.getPersonById(-1); // Throws error
        await people.getPersonById(1000)// Throws error
        await people.getPersonById() // Throws Error

    } catch (e) {
        console.log(e);
    }

    try {
        await people.lexIndex(2) // Returns: "Dermot Abberley"
        await people.lexIndex(-1) // Throws Error
        await people.lexIndex(1000) // Throws Error
        await people.lexIndex() // Throws Error
    } catch (e) {
        console.log(e);
    }


    await people.firstNameMetrics();


    try {
        await weather.shouldTheyGoOutside("Scotty", "Barajaz") // Returns "Yes, Scotty should go outside."
        await weather.shouldTheyGoOutside("Calli", "Ondrasek") // Returns "No, Calli should not go outside."
        await weather.shouldTheyGoOutside() // Throws Error
        await weather.shouldTheyGoOutside("Bob") // Throws Error
        await weather.shouldTheyGoOutside("Bob", "Smith") // Throws Error
    } catch (e) {
        console.log(e);
    }

    try {
        await work.whereDoTheyWork("Demetra", "Durrand") // Returns: "Demetra Durrand - Nuclear Power Engineer at Buzzshare. They will be fired."
        await work.whereDoTheyWork("Hank", "Tarling") // Returns: "Hank Tarling - Technical Writer at Babbleblab. They will not be fired."
        await work.whereDoTheyWork() // Throws Error
        await work.whereDoTheyWork("Bob") // Throws Error
        await work.whereDoTheyWork("Bob", "Smith") // Throws Error

    } catch (e) {
        console.log(e);
    }


    try {
        await work.findTheHacker("79.222.167.180") // Returns: "Robert Herley is the hacker!"
        await work.findTheHacker("foobar") // Throws Error
        await work.findTheHacker() // Throws Error

    } catch (e) {
        console.log(e);
    }

}
//call main
main()