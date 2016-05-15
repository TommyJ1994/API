package api

import grails.converters.JSON
import static org.springframework.http.HttpStatus.*

class UserController {

    /**
    * This method returns the list of all unique users email addresses in descending order.
    * @HttpMethod GET
    */
    def index() {
      def criteria = User.createCriteria()
		  def userInstanceList = criteria.list {
		    projections {
		        distinct('email') // Unique Results
		    }
			order('email', 'desc') // Descending Order
		  }

      // HATEOS
      def create = [method: "POST", action: "create", href: "/api/users/"]
      def read = [method: "GET", action: "read", href: "/api/users/id"]
      def delete = [method: "DELETE", action: "delete", href: "/api/users/id"]
      def update = [method: "PUT", action: "update", href: "/api/users/id"]
      def search = [method: "GET", action: "search", href: "/api/users/search/id"]
      def links = [create: create, read: read, delete: delete, update: update, search: search]

      // Response Formatting
      response.status = 200
      def response = [users: userInstanceList, links: links]
      render response as JSON
    }

    /**
    * This method returns all users matching a username similar to the search key.
    * @HttpMethod GET
    * @params id = the search key
    */
    def search() {
      def searchKey = params.id
      def users = [users: User.findAllByUsernameILike("%" + searchKey + "%")]

      // HATEOS
      def read = [method: "GET", action: "read", href: "/api/users/id"]
      def delete = [method: "DELETE", action: "delete", href: "/api/users/id"]
      def update = [method: "PUT", action: "update", href: "/api/users/id"]
      def links = [read: read, delete: delete, update: update]

      // Response Formatting
      response.status = 200
      def response = [users: users, links: links]
      render response as JSON
    }

    /**
    * This method returns data for a user found using the email address sent with the GET request.
    * @HttpMethod GET
    * @params id = the email address of the user
    */
    def show() {
      String email = params.id
      def user = [user: User.findByEmail(email)]

      // HATEOS
      def delete = [method: "DELETE", action: "delete", href: "/api/users/" + params.id]
      def update = [method: "PUT", action: "update", href: "/api/users/"  + params.id]
      def links = [delete: delete, update: update]

      // Null check & Response Formatting
      if(user == null) {
          response.status = 404
          def response = [links: links]
          render response as JSON
      }
      else {
        response.status = 200
        def response = [user: user, links: links]
        render response as JSON
      }
    }

    /**
    * This method creates a new User with valid data using the data sent with the POST request.
    * @HttpMethod POST
    */
    def create() {
      def data = request.JSON.user

      def name = [title: data.name.title, first: data.name.first, last: data.name.last]
      def location = [street: data.location.street, city: data.location.city, state: data.location.state, zip: data.location.zip]
      def picture = [large: data.picture.large, medium: data.picture.medium, thumbnail: data.picture.thumbnail]

      def user = new User(gender: data.gender,
  			name: name,
        location: location,
        email: data.email,
        username: data.username,
        password: data.password,
        salt: data.salt,
        md5: data.md5,
        sha1: data.sha1,
        sha256: data.sha256,
        registered: data.registered,
        dob: data.dob,
        phone: data.phone,
        cell: data.cell,
        PPS: data.PPS,
        picture: picture
        )

      // HATEOS
      def read = [method: "GET", action: "read", href: "/api/users/" + data.email]
      def delete = [method: "DELETE", action: "delete", href: "/api/users/" + data.email]
      def update = [method: "PUT", action: "update", href: "/api/users/" + data.email]
      def links = [read: read, delete: delete, update: update]

      // Validation Checks
      user.validate()
    		if (user.hasErrors()) {
          response.status = 405
          def response = [errors: user.errors, links: links]
          render response as JSON
    		}

      // Response Formatting
      user.save(flush:true)
      response.status = 200
      def response = [user: user, links: links]
      render response as JSON
    }

    /**
    * This method updates the data for a user found using the email address sent with the the PUT request.
    * @HttpMethod PUT
    * @params id = the email address of the user
    */
    def update(){
      String email = params.id
      def user = User.findByEmail(email)

      if(user == null) {
          render status:404
      }
      else {
        def data = request.JSON.user

        def name = [title: data.name.title, first: data.name.first, last: data.name.last]
        def location = [street: data.location.street, city: data.location.city, state: data.location.state, zip: data.location.zip]
        def picture = [large: data.picture.large, medium: data.picture.medium, thumbnail: data.picture.thumbnail]

        // Update user credentials
          user.gender = data.gender
          user.name = name
          user.location = location
          user.email = data.email
          user.username = data.username
          user.password = data.password
          user.salt = data.salt
          user.md5 = data.md5
          user.sha1 = data.sha1
          user.sha256 = data.sha256
          user.registered = data.registered
          user.dob = data.dob
          user.phone = data.phone
          user.cell = data.cell
          user.PPS = data.PPS
          user.picture = picture

        // HATEOS
        def read = [method: "GET", action: "read", href: "/api/users/" + data.email]
        def delete = [method: "DELETE", action: "delete", href: "/api/users/" + data.email]
        def links = [read: read, delete: delete]

        // Validation Checks
        user.validate()
          if (user.hasErrors()) {
            response.status = 405
            def response = [errors: user.errors, links: links]
            render response as JSON
          }

          // Response Formatting
          response.status = 200
          def response = [user: user, links: links]
          render response as JSON
      }
    }

    /**
    * This method deletes the user found using the email address sent with the DELETE request.
    * @HttpMethod DELETE
    */
    def delete() {
      String email = params.id
      def user = User.findByEmail(email)

      // HATEOS
      def create = [method: "POST", action: "create", href: "/api/users/"]
      def list = [method: "GET", action: "list", href: "/api/users/"]
      def links = [list: list, create: create]

      if(user == null) {
        response.status = 404
      }
      else {
          user.delete()
          response.status = 200
      }

      // Response Formatting
      def response = [links: links]
      render response as JSON
    }

}
