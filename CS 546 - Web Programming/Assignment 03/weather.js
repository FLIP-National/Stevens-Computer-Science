const axios = require('axios');

async function shouldTheyGoOutside(firstName,lastName){
const response = axios.get('https://gist.githubusercontent.com/robherley/5112d73f5c69a632ef3ae9b7b3073f78/raw/24a7e1453e65a26a8aa12cd0fb266ed9679816aa/people.json')
          .then(function (response) {
              var f=firstName,l=lastName;
              if(f==null) throw "Given input is not present";
              if(l==null) throw "Given input is not present";
              if(typeof f!=="string" || typeof l!=="string")
                    throw "Given input is not of proper type"
              if(typeof f=="string"&& typeof l=="string"){
                for(var i=0;i<500;i++){
                     if(response.data[i].lastName==l && response.data[i].firstName==f){
                         var zip = response.data[i].zip ;
                         response.data[i].firstName;
              return getTemp(zip,firstName);}
              

             }}return hello();
   }) .catch(function (error) {
      console.log(error);
   })
}
    
function hello(){
  console.log("Person you are looking for is not found")
}

function getTemp(zip,firstName){
var f=firstName;

const response = axios.get('https://gist.githubusercontent.com/robherley/1b950dc4fbe9d5209de4a0be7d503801/raw/eee79bf85970b8b2b80771a66182aa488f1d7f29/weather.json')
           .then(function (response) {
                  var z=zip;
                  for(var i=0;i<500;i++){
                        if(response.data[i].zip== z){
                            if(response.data[i].temp >=34)
                            {throw ("Yes,"+f+" "+ "should go outside");}
                            else{throw("No, "+f+" "+ "should not go outside");}
                              }
                            }
              }).catch(function (error){
             console.log(error);
           })
 }
          
 
module.exports={
    shouldTheyGoOutside
}