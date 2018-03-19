'use strict';

const Client = require('node-rest-client').Client;
const client = new Client();

const args = {
    data: { userId: "1",
            title: "testTitle",
            body: "testBody" },
    headers: { "Content-Type": "application/json" }
};

// TEST 1 - GET
const getMethod = () => {  
    client.get("https://jsonplaceholder.typicode.com/posts?userId=1", function (data, response) {
        
        console.log(response.statusCode);
        if(data.length != 0) {
            console.log("Get method success!");
        }else{
            console.log("Get method unsuccessful!");
        };
    });
};

// TEST 2 - POST

const postMethod = () => {

    return new Promise(function(resolve, reject) {
        client.post("https://jsonplaceholder.typicode.com/posts", args, function (data, response) {
            resolve(console.log("Post method success!"));
        }, function() {
            reject(new Error("Post method failed"));
            }
        );
    });
};


// TEST 3 - GET

const getMethodAfterPost = () => {
    client.get("https://jsonplaceholder.typicode.com/posts?userId=1", function (data, response) {
        if(data.length > 10){
            console.log("OK - posted message has been added");
        }else{ 
            console.log("FAIL - message has not been added");
        };
    });
};

getMethod();
postMethod().then(function() {
    getMethodAfterPost();
});