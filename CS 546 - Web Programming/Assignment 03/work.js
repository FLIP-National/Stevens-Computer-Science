const axios = require('axios');
async function whereDoTheyWork(firstName,lastName){
    const response = axios.get('https://gist.githubusercontent.com/robherley/5112d73f5c69a632ef3ae9b7b3073f78/raw/24a7e1453e65a26a8aa12cd0fb266ed9679816aa/people.json')
      .then(function (response) {
          var f=firstName,l=lastName;
    
          if(l == undefined)
          throw "Given input is not present"
          if(f == undefined) 
                throw "Given input is not defined"
          if(typeof f!=="string" || typeof l!=="string")
                throw "Given input is not of proper type"
              
          
    
       for(var i=0;i<500;i++){
        if(response.data[i]['lastName']==l && response.data[i]['firstName']==f){
               var ssn = response.data[i].ssn ;
            return getCompany(ssn,f,l);
           }
          }return hello();
           
}) .catch(function (error) {
        console.log(error);
      })

      
    }

function hello(){
  console.log("Person you are looking for is not found");
}

    function getCompany(ssn,f,l){
      var company,f,l;
         const response = axios.get('https://gist.githubusercontent.com/robherley/61d560338443ba2a01cde3ad0cac6492/raw/8ea1be9d6adebd4bfd6cf4cc6b02ad8c5b1ca751/work.json')
       .then(function (response) {
              var s=ssn;
              for(var i=0;i<500;i++){
              if(response.data[i].ssn==s){
             
                if(response.data[i].willBeFired)
    {console.log(f+" "+l+"-"+response.data[i].jobTitle+" at "+response.data[i].company+". They will be fired." )}
    else {console.log(f+" "+l+"-"+response.data[i].jobTitle+" at "+response.data[i].company+". They will not be fired." )}
              }}}            
      
  
       ).catch(function (error){
         console.log(error);
       })
  }


    function getHacker(ssn){
        
           const response = axios.get('https://gist.githubusercontent.com/robherley/5112d73f5c69a632ef3ae9b7b3073f78/raw/24a7e1453e65a26a8aa12cd0fb266ed9679816aa/people.json')
         .then(function (response) {
                var s=ssn;
                for(var i=0;i<500;i++){
                if(response.data[i].ssn==s){
               
                  console.log(response.data[i].firstName+" "+ response.data[i].lastName+" is the hacker!")
    
             }  } }).catch(function (error){
           console.log(error);
         })
    }
async function findTheHacker(ip){
   const response = axios.get('https://gist.githubusercontent.com/robherley/61d560338443ba2a01cde3ad0cac6492/raw/8ea1be9d6adebd4bfd6cf4cc6b02ad8c5b1ca751/work.json')
          .then(function (response) {
           if(ip ==undefined)
              throw "Input argument undefined"

       for(var i=0;i<500;i++){
        if(response.data[i]['ip']==ip){
            var ssn = response.data[i].ssn ;
            
         return getHacker(ssn);
        }
      } return hellonew();
          }) .catch(function (error) {
            console.log(error);
          })
          
        }

function hellonew(){
  console.log("Input Not Found")
}

    module.exports={
        whereDoTheyWork,findTheHacker

    }