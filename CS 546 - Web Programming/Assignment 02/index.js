const geometry = require("./geometry")
const utilities = require("./utilities")

//volumeOfRectangularPrism
console.log('Volume of Rectagular Prism')
try {
    console.log('test 1:')
    console.log(geometry.volumeOfRectanglarPrism(1,2,6))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
try {
    console.log('test 2:')
    console.log(geometry.volumeOfRectanglarPrism(1,-2,6))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
try {
    console.log('test 3:')
    console.log(geometry.volumeOfRectanglarPrism(1,6))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
//surafceAreaOfRectangularPrism
console.log('Surface Area of a Prism')
try {
        console.log('test 1:')
    console.log(geometry.surfaceAreaOfRectanglarPrism(1,2,3))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
//volumeOfSphere
console.log('Volume of Sphere')
try {
    console.log('test 1:')
    console.log(geometry.volumeOfSphere(3))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
try {
    console.log('test 2:')
    console.log(geometry.volumeOfSphere(-3))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
try {
    console.log('test 3:')
    console.log(geometry.volumeOfSphere("a"))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
//surfaceAreaOfSphere
console.log('Surface Area of a sphere')
try {
    console.log('test 1:')
    console.log(geometry.surfaceAreaOfSphere(3))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
//deepEquality
console.log('Deep Equality')
try {
    console.log('test 1:')
    const first={a:2,b:3};
    const second={a:2,b:3};
    const third={a:8,b:6};
    console.log(utilities.deepEquality(first,second))
    console.log(utilities.deepEquality(first,third))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
//uniqueElements
console.log('Unique Elements')
try {
    console.log('test 1:')
    const testArr=["a","a","b","a","b","c"]
    console.log(utilities.uniqueElements(testArr))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
try {
    console.log('test 2:')
    const testArr=[]
    console.log(utilities.uniqueElements(testArr))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
//countOfEachCharacterInString
console.log('Count of each character in a string')
try {
    console.log('test 1:')
    const test="Hello, the pie is in the oven";
    console.log(utilities.countOfEachCharacterInString(test))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}
try {
    console.log('test 1:')
    const test=22;
    console.log(utilities.countOfEachCharacterInString(test))
    console.log('Hurray! test passed successfully.')
}catch (error){
    console.log(error)
    console.error('Unfortunately, test failed!')
}