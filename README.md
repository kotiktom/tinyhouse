# Project tinyhouse
Tavoitteena luoda toimiva backend vastaamaan fronttitiimimme kyselylomaketta.

## Getting Started
In order to run this application, you need to install Eclipse IDE, preferrably version 2019‑09.
Also you need to clone or download this project.


## Running the application
Using eclipse, you need to import the existing project to your eclipse. In order to import, right click project explorer on the left side and select import > maven > existing maven project, and select the downloaded tinyhouse file. Wait until the project is completely imported and after the project has finished importing, select tinyhouseApplication.java right click on it and select run as > java application.

## Deployment
Project is deployed in herokuapp

## Built With
Java Spring boot - framework used
Maven - Dependency Management


## Versioning
TBA

## Authors
Sanna Arvilommi
Mikko Harakka
Tommi Kotikangas
Aleksanteri Fagerholm
Erik Ilonen

## License
This project is licensed under the MIT License - see the LICENSE.md file for details

### Acknowledgments
Hat tip to anyone whose code was used and for all the coffee that kept us awake.

# THIS SECTION CONTAINS REST/API DOCUMENTATION

## Show Question

Returns json data about a single question.

    URL

    /question/:id

    Method:

    GET

    URL Params

    Required:

    id=[Long]

    Data Params

    None

    Success Response:
        Code: 200
        Content: 
	
	{

    "id": 1,
    "questions": [
        "test1",
        "test2"
    ],
    "survey": null,
    "answers": [
        "test1",
        "test2"
    ],
    "new": false,
    "hibernateLazyInitializer": { }

}

    Error Response:
        Code: type=Internal Server Error, status=500
        Content: { error : "Question doesn't exist" }

    OR
        Code: 401 UNAUTHORIZED
        Content: { error : "You are unauthorized to make this request." }

    Sample Call:

      $.ajax({
        url: "/question/1",
        dataType: "json",
        type : "GET",
        success : function(r) {
          console.log(r);
        }
      });

## Show questions

Returns json data about all questions plural.

    URL

    /questions/:id

    Method:

    GET

    URL Params

    Required:

    id=[Long]

    Data Params

    None

    Success Response:
        Code: 200
        Content: 
	
[
    {
        "id": 1,
        "questions": [
            "test1",
            "test2"
        ],
        "survey": null,
        "answers": [
            "test1",
            "test2"
        ],
        "new": false
    }
]

    Error Response:
        Code: 
        Content:

    OR
        Code: 
        Content: 

    Sample Call:

      $.ajax({
        url: "/questions",
        dataType: "json",
        type : "GET",
        success : function(r) {
          console.log(r);
        }
      });

## Post question

Returns json data about posted question. Using Postman app

New guestion
API CALL:
http://localhost:8080/question
METHOD: POST
PARAMETERS:
- 
EXAMPLES OF API CALL:
http://localhost:8080/question (METHOD POST)
API REQUEST BODY:
 {
        
        "questions": [
            "test1",
            "test2"
        ],
      
        "answers": [
            "test1",
            "test2"
        ]
       
    }

API RESPONSE:    ???????
{
    "id": 5,
    "questions": [
        "test1",
        "test2"
    ],
    "survey": null,
    "answers": [
        "test1",
        "test2"
    ],
    "new": false
}

## Post answer /*saattaa olla keskeneräinen toistaiseksi */

Returns json data about posted question. Using Postman app

New guestion
API CALL:
http://localhost:8080/questions/1/answers
METHOD: POST
PARAMETERS:
- 
EXAMPLES OF API CALL:
http://localhost:8080/questions/1/answers (METHOD POST)
API REQUEST BODY:
 {
        
        "questions": [
            "test1",
            "test2"
        ],
      
        "answers": [
            "test1",
            "test2"
        ]
       
    }

API RESPONSE:    ???????
{
    "id": 5,
    "questions": [
        "test1",
        "test2"
    ],
    "survey": null,
    "answers": [
        "test1",
        "test2"
    ],
    "new": false
}
## Post Answer

Returns json data about posted question. Using Postman app

New guestion
API CALL:
http://localhost:8080/questions/answers
METHOD: POST
PARAMETERS:
- 
EXAMPLES OF API CALL:
http://localhost:8080/questions/answers (METHOD POST)
API REQUEST BODY:
 
[	{
    "questionId": 1,
    "answer": "hello world"
	}
]

API RESPONSE:    ???????
[
    {
        "id": 4,
        "answer": "Vastaus 1",
        "new": false
    },
    {
        "id": 5,
        "answer": "hello world",
        "new": false
    }
]