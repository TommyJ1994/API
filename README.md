# Objective
Graduate Candidate: Using the above dataset, design a persistent RESTful API with basic CRUDL operations implemented.

Senior Candidate: As above, but include filtering and searching

Guidelines:

1. Use the language, tools and technology choices you are most comfortable with.
2. Be as expressive and feature rich as you wish, just meet the minimum objective requirements for your level of experience, feel free to go beyond this if you so wish.
3. Create your solution as though you would be shipping this to production -- show us what you value in a code base.
4. Minimal scaffolding / auto code generation -- we want you to show your ability and creative side so please keep this to a minimum.
5. Commit early and commit often, we want to see the implementation evolving.

# Resources
| HTTP Method   | Resources             | Description                         |
| --------------|:----------------------|:------------------------------------|
| GET           | /api/users            | Return list of users.               |
| GET           | /api/users/$id        | Return information for a given user.|
| GET           | /api/users/search/$id | Search for a user by username.      |
| POST          | /api/users            | Create a new user.                  |
| PUT           | /api/users/$id        | Update a users information.         |
| DELETE        | /api/users/$id        | Delete a user.                      |

## Return list of users
* Description
  * Returns the list of all users emails (following CRUDL approach)

* Resources
  * `/api/users/`

* HTTP method
  * `GET`

* Sample request
```
curl -X GET -H "http://localhost:8090/API/api/users"
```

* Sample response
```
{
    "users": [
        "alison.reid@example.com",
        "john@gmail.com",
        "johnJoe@gmail.com"
    ],
    "links": {
        "create": {
            "method": "POST",
            "action": "create",
            "href": "/api/users/"
        },
        "read": {
            "method": "GET",
            "action": "read",
            "href": "/api/users/id"
        },
        "delete": {
            "method": "DELETE",
            "action": "delete",
            "href": "/api/users/id"
        },
        "update": {
            "method": "PUT",
            "action": "update",
            "href": "/api/users/id"
        },
        "search": {
            "method": "GET",
            "action": "search",
            "href": "/api/users/search/id"
        }
    }
}
```

## Return information for a given user
* Description
  * Returns a users data for a given user based on the given email address.

* Resources
  * `/api/users/$id`

* HTTP method
  * `GET`

* Sample request
```
curl -X GET "http://localhost:8090/API/api/users/alison.reid@example.com"
```

* Sample response
```
{
    "user": {
        "user": {
            "class": "api.User",
            "id": 54,
            "PPS": "3302243T",
            "cell": "081-647-4650",
            "dob": 932871968,
            "email": "alison.reid@example.com",
            "gender": "female",
            "location": {
                "street": "1097 the avenue",
                "city": "Newbridge",
                "state": "kansas",
                "zip": 28782
            },
            "md5": "bbdd6140e188e3bf68ae7ae67345df65",
            "name": {
                "title": "miss",
                "first": "alison",
                "last": "doyle"
            },
            "password": "rockon",
            "phone": "031-541-9181",
            "picture": {
                "large": "https://randomuser.me/api/portraits/women/60.jpg",
                "medium": "https://randomuser.me/api/portraits/med/women/60.jpg",
                "thumbnail": "https://randomuser.me/api/portraits/thumb/women/60.jpg"
            },
            "registered": 1237176893,
            "salt": "lypI10wj",
            "sha1": "4572d25c99aa65bbf0368168f65d9770b7cacfe6",
            "sha256": "ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb",
            "username": "tinywolf709"
        }
    },
    "links": {
        "delete": {
            "method": "DELETE",
            "action": "delete",
            "href": "/api/users/alison.reid@example.com"
        },
        "update": {
            "method": "PUT",
            "action": "update",
            "href": "/api/users/alison.reid@example.com"
        }
    }
}
```

## Search for a user by username
* Description
  * Return the users that match a search pattern.

* Resources
  * `/api/users/search/$id`

* HTTP method
  * `GET`

* Sample request
```
curl -X GET "http://localhost:8090/API/api/users/search/tinywolf"
```

* Sample response
```
{
    "users": {
        "users": [

            {
                "class": "api.User",
                "id": 56,
                "PPS": "3302243T",
                "cell": "081-647-4650",
                "dob": 932871968,
                "email": "alison.reid@example.com",
                "gender": "male",
                "location": {
                    "street": "1097 the avenue",
                    "city": "Newbridge",
                    "state": "ohio",
                    "zip": 28782
                },
                "md5": "bbdd6140e188e3bf68ae7ae67345df65",
                "name": {
                    "title": "miss",
                    "first": "alison",
                    "last": "reid"
                },
                "password": "rockon",
                "phone": "031-541-9181",
                "picture": {
                    "large": "https://randomuser.me/api/portraits/women/60.jpg",
                    "medium": "https://randomuser.me/api/portraits/med/women/60.jpg",
                    "thumbnail": "https://randomuser.me/api/portraits/thumb/women/60.jpg"
                },
                "registered": 1237176893,
                "salt": "lypI10wj",
                "sha1": "4572d25c99aa65bbf0368168f65d9770b7cacfe6",
                "sha256": "ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb",
                "username": "tinywolf709"
            },
            {
                "class": "api.User",
                "id": 57,
                "PPS": "1636243A",
                "cell": "091-251-4630",
                "dob": 832321968,
                "email": "lisa.quinn@example.com",
                "gender": "female",
                "location": {
                    "street": "1097 the avenue",
                    "city": "Newbridge",
                    "state": "ohio",
                    "zip": 28782
                },
                "md5": "bbdd6140e188e3bf68ae7ae67345df65",
                "name": {
                    "title": "miss",
                    "first": "lisa",
                    "last": "quinn"
                },
                "password": "ghetto",
                "phone": "041-541-9181",
                "picture": {
                    "large": "https://randomuser.me/api/portraits/women/60.jpg",
                    "medium": "https://randomuser.me/api/portraits/med/women/60.jpg",
                    "thumbnail": "https://randomuser.me/api/portraits/thumb/women/60.jpg"
                },
                "registered": 1432176893,
                "salt": "lypI10wj",
                "sha1": "4572d25c99aa65bbf0368168f65d9770b7cacfe6",
                "sha256": "ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb",
                "username": "tinywolf909"
            }
        ]
    },
    "links": {
        "read": {
            "method": "GET",
            "action": "read",
            "href": "/api/users/id"
        },
        "delete": {
            "method": "DELETE",
            "action": "delete",
            "href": "/api/users/id"
        },
        "update": {
            "method": "PUT",
            "action": "update",
            "href": "/api/users/id"
        }
    }
}
```

## Update a users information
* Description
  * Updates a users information based on the email address and data sent in the request.

* Resources
  * `/api/users/$id`

* HTTP method
  * `PUT`

* Sample request
```
curl -X PUT -H "Content-Type: application/json" -d '{
    "user": {
      "gender": "female",
      "name": {
        "title": "miss",
        "first": "alison",
        "last": "doyle"
      },
      "location": {
        "street": "1097 the avenue",
        "city": "Newbridge",
        "state": "kansas",
        "zip": 28782
      },
      "email": "alison.reid@example.com",
      "username": "tinywolf709",
      "password": "rockon",
      "salt": "lypI10wj",
      "md5": "bbdd6140e188e3bf68ae7ae67345df65",
      "sha1": "4572d25c99aa65bbf0368168f65d9770b7cacfe6",
      "sha256": "ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb",
      "registered": 1237176893,
      "dob": 932871968,
      "phone": "031-541-9181",
      "cell": "081-647-4650",
      "PPS": "3302243T",
      "picture": {
        "large": "https://randomuser.me/api/portraits/women/60.jpg",
        "medium": "https://randomuser.me/api/portraits/med/women/60.jpg",
        "thumbnail": "https://randomuser.me/api/portraits/thumb/women/60.jpg"
      }
    }
  }' "http://localhost:8090/API/api/users/alison.reid@example.com"
```

* Sample response
```
{
    "user": {
        "class": "api.User",
        "id": 55,
        "PPS": "3302243T",
        "cell": "081-647-4650",
        "dob": 932871968,
        "email": "alison.reid@example.com",
        "gender": "female",
        "location": {
            "street": "1097 the avenue",
            "city": "Newbridge",
            "state": "kansas",
            "zip": 28782
        },
        "md5": "bbdd6140e188e3bf68ae7ae67345df65",
        "name": {
            "title": "miss",
            "first": "alison",
            "last": "doyle"
        },
        "password": "rockon",
        "phone": "031-541-9181",
        "picture": {
            "large": "https://randomuser.me/api/portraits/women/60.jpg",
            "medium": "https://randomuser.me/api/portraits/med/women/60.jpg",
            "thumbnail": "https://randomuser.me/api/portraits/thumb/women/60.jpg"
        },
        "registered": 1237176893,
        "salt": "lypI10wj",
        "sha1": "4572d25c99aa65bbf0368168f65d9770b7cacfe6",
        "sha256": "ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb",
        "username": "tinywolf709"
    },
    "links": {
        "read": {
            "method": "GET",
            "action": "read",
            "href": "/api/users/alison.reid@example.com"
        },
        "delete": {
            "method": "DELETE",
            "action": "delete",
            "href": "/api/users/alison.reid@example.com"
        }
    }
}
```

## Create a new user
* Description
  * Creates a new user with the data provided in the POST request.

* Resources
  * `/api/users/$id`

* HTTP method
  * `POST`

* Sample request
```
curl -X POST -H "Content-Type: application/json" -d '{
    "user": {
      "gender": "female",
      "name": {
        "title": "miss",
        "first": "alison",
        "last": "reid"
      },
      "location": {
        "street": "1097 the avenue",
        "city": "Newbridge",
        "state": "ohio",
        "zip": 28782
      },
      "email": "alison.reid@example.com",
      "username": "tinywolf709",
      "password": "rockon",
      "salt": "lypI10wj",
      "md5": "bbdd6140e188e3bf68ae7ae67345df65",
      "sha1": "4572d25c99aa65bbf0368168f65d9770b7cacfe6",
      "sha256": "ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb",
      "registered": 1237176893,
      "dob": 932871968,
      "phone": "031-541-9181",
      "cell": "081-647-4650",
      "PPS": "3302243T",
      "picture": {
        "large": "https://randomuser.me/api/portraits/women/60.jpg",
        "medium": "https://randomuser.me/api/portraits/med/women/60.jpg",
        "thumbnail": "https://randomuser.me/api/portraits/thumb/women/60.jpg"
      }
    }
  }' "http://localhost:8090/API/api/users"
  ```
* Sample Response
```
{
    "user": {
        "class": "api.User",
        "id": 58,
        "PPS": "3302243T",
        "cell": "081-647-4650",
        "dob": 932871968,
        "email": "alison.reid@example.com",
        "gender": "female",
        "location": {
            "street": "1097 the avenue",
            "city": "Newbridge",
            "state": "ohio",
            "zip": 28782
        },
        "md5": "bbdd6140e188e3bf68ae7ae67345df65",
        "name": {
            "title": "miss",
            "first": "alison",
            "last": "reid"
        },
        "password": "rockon",
        "phone": "031-541-9181",
        "picture": {
            "large": "https://randomuser.me/api/portraits/women/60.jpg",
            "medium": "https://randomuser.me/api/portraits/med/women/60.jpg",
            "thumbnail": "https://randomuser.me/api/portraits/thumb/women/60.jpg"
        },
        "registered": 1237176893,
        "salt": "lypI10wj",
        "sha1": "4572d25c99aa65bbf0368168f65d9770b7cacfe6",
        "sha256": "ec0705aec7393e2269d4593f248e649400d4879b2209f11bb2e012628115a4eb",
        "username": "tinywolf709"
    },
    "links": {
        "read": {
            "method": "GET",
            "action": "read",
            "href": "/api/users/alison.reid@example.com"
        },
        "delete": {
            "method": "DELETE",
            "action": "delete",
            "href": "/api/users/alison.reid@example.com"
        },
        "update": {
            "method": "PUT",
            "action": "update",
            "href": "/api/users/alison.reid@example.com"
        }
    }
}
```

## Delete a user
* Description
  * Deletes a user based on the given email.

* Resources
  * `/api/users/$id`

* HTTP method
  * `DELETE`

* Sample request
```
curl -X DELETE "http://localhost:8090/API/api/users/alison.reid@example.com"
```

* Sample response
```
{
    "links": {
        "list": {
            "method": "GET",
            "action": "list",
            "href": "/api/users/"
        },
        "create": {
            "method": "POST",
            "action": "create",
            "href": "/api/users/"
        }
    }
}
```

# Database configuration
## Development DB
* host = "localhost"
* port = "27017"
* name = "RedHatProject"

## Testing DB
* host = "localhost"
* port = "27017"
* name = "RedHatProjectTest"

# Component Versions
* Groovy Version 2.3.7
* Java Version 1.7.0
* Grails Version 2.4.4
* MongoDB Version 3.0.3

# Run Application
* Run `grails run-app` in project folder

# Run Tests
* Run `grails test-app` in project folder
