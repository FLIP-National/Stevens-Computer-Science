function fibonum(num) {
    if (num <= 0) {
        return 0;
    } if (num == 1) {
        return 1;
    };
    return fibonum(num - 2) + fibonum(num - 1);
}

function isPrime(number) {
    if (number <= 1) return false; // negatives
    if (number % 2 == 0 && number > 2) return false; // even numbers
    const s = Math.sqrt(number); // store the square to loop faster
    for (let i = 3; i <= s; i += 2) { // start from 3, stop at the square, increment in twos
        if (number % i === 0) return false; // modulo shows a divisor was found
    }
    return true;
}

function checkFiboPrime() {
    console.log("in checkPrime");
    const inputForm = document.getElementById("input-form");

    const resultContainer = document.getElementById("result-container");


    if (inputForm) {
        const number = parseInt(document.getElementById("number").value);
        if (isNaN(number)) {
            $("#error-container").removeClass("hidden");
            $("#error-text").text("Please enter a number");
        } else if (number < 1) {
            $("#error-container").removeClass("hidden");
            $("#error-text").text("Number should be greater than 1");
        } else {
            $("#error-container").addClass("hidden");
            if (isPrime(fibonum(number)) == true) {
                $("#results").append(`<li class="is-prime"> Fibonacii of ${number} is ${fibonum(number)}.</li>`);
            } else {
                $("#results").append(`<li class="not-prime"> Fibonacii of ${number} is ${fibonum(number)}.</li>`);
            }
        }
    }
}