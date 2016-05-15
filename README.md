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
| ------------- |:---------------------:| -----------------------------------:|
| GET           | /api/users            | Return list of users.               |
| GET           | /api/users/$id        | Return information for a given user |
| GET           | /api/users/search/$id | Search for a user by username       |
| POST          | /api/users            | Create a new user.                  |
| PUT           | /api/users/$id        | Update a users information.         |
| DELETE        | /api/users/$id        | Delete a user.                      |

# Database configuration

Development DB
* host = "localhost"
* port = "27017"
* name = "RedHatProject"

Test DB
* host = "localhost"
* port = "27017"
* name = "RedHatProjectTest"

# Run Application
* grails run-app in project folder

# Run Tests
* grails test-app in project folder
