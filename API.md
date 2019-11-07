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